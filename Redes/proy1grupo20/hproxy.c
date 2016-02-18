/* 
 * Archivo: hproxy.c
 *
 *   Implementacion de un HTTP Proxy utilizando sockets
 *   en el esquema cliente-servidor para prohibir unas
 *   paginas web dadas y mantener un archivo log de las 
 *   paginas visitadas por los usuarios.
 *
 * Autor: Carlos J. Chitty 07-41896
 */


#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/stat.h>
#include <netinet/in.h>
#include <netdb.h>
#include <time.h>
#include <string.h>
#include <fcntl.h>
#include "funciones.h"
#include "errors.h"

#define QUEUELENGTH 15
#define SIZE 32768

int main(int argc, char *argv[ ]){

  int clientaddrlength;
  int pid;
  int puerto=16000; // valor por defecto
  int tam;
  int i;
  int sockfd;	// File Descriptors
  int sockfd2;
  int newsockfd;
  int prohibida;
  int filefd;
  mode_t fd_mode = S_IRUSR | S_IWUSR | S_IRGRP;
  Lista forbid=NULL;
  time_t lt;  // para el tiempo 
  FILE *log;
  char *archivo="log";
  char *server;
  char buffer[SIZE];
  struct sockaddr_in clientaddr;
  struct sockaddr_in serveraddr;
  struct sockaddr_in serveraddr2;


  /** PARAMETROS ADICIONALES -f, -p, -l ***/
  if ( argc==3 || argc==5 || argc==7 ){
    for (i=1; i<argc; i++){
    
      if ( (strcmp(argv[i], "-f") == 0) ){
        forbid = archivoP(argv[i+1]);
	i++;
      }
      else if ( (strcmp(argv[i], "-p") == 0) ){
        puerto = port(argv[i+1]);
        printf("Puerto: %d\n",puerto);
	i++;
      }
      else if ( (strcmp(argv[i], "-l") == 0) ){
	archivo = argv[i+1];
	i++;
      }
      else {
	printf("Opcion No Valida: %s\n",argv[i]);
        break;
      }
    } 
  }

  
  /** SOCKETS **/

  /* Remember the program name for error messages. */
  programname = argv[0];

  /* Open a TCP socket. */
  sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (sockfd < 0)
    fatalerror("can't open socket");

  /* Bind the address to the socket. */
  bzero(&serveraddr, sizeof(serveraddr));
  serveraddr.sin_family = AF_INET;
  serveraddr.sin_addr.s_addr = htonl(INADDR_ANY);
  serveraddr.sin_port = htons(puerto);

  if (bind(sockfd, (struct sockaddr *) &serveraddr,
           sizeof(serveraddr)) != 0)
    fatalerror("can't bind to socket");

  if (listen(sockfd, QUEUELENGTH) < 0)
    fatalerror("can't listen");

  while (1) {
    /* Wait for a connection. */
    clientaddrlength = sizeof(clientaddr);
    newsockfd = accept(sockfd, 
                       (struct sockaddr *) &clientaddr,
                       &clientaddrlength);
    if (newsockfd < 0)
      fatalerror("accept failure");

    /* Fork a child to handle the connection. */
    pid = fork();
    if (pid < 0)
      fatalerror("fork error");
    else if (pid == 0) {
      /* I'm the child. */
      close(sockfd);
      
      log = fopen(archivo,"a"); //IP del host
      fprintf(log, "%s\t",(char *)inet_ntoa(clientaddr.sin_addr) );


       /* Abrir socket. Este socket sera el cliente del servidor web */
       sockfd2 = socket(AF_INET, SOCK_STREAM, 0);
       if (sockfd2 < 0)
         fatalerror("can't open socket");

       server = getServerIP(newsockfd,forbid,log);

       // URL prohibida, enviar mensaje correspondiente
       if( strcmp( server, "block" ) == 0 ){
         if ((prohibida = open("urlP", O_RDONLY) ) == -1)
   	   perror("No se pudo abrir el archivo urlP");

         copyData(prohibida,newsockfd);
         close(prohibida);
         fprintf(log,"forbidden\t");
         remove("urlP");

       } else{
       
         /* Get the address of the server. */
         bzero(&serveraddr2, sizeof(serveraddr));
         serveraddr2.sin_family = AF_INET;
         serveraddr2.sin_addr.s_addr = inet_addr(server);
         serveraddr2.sin_port = htons(80);

         /* Connect to the server. */
         if (connect(sockfd2, (struct sockaddr *) &serveraddr2,
              sizeof(serveraddr2)) < 0)
           fatalerror("can't connect to server");

         // Lee archivo fd y envia la peticion almacenada al servidor
         if ((filefd = open("fd", O_RDONLY, fd_mode) ) == -1)
   	   perror("No se pudo abrir el archivo fd para lectura");
         copyData(filefd,sockfd2);
         close(filefd);

	 // Pasa la respuesta que envio el servidor a un buffer y luego 
         // de ese buffer envia esa respuesta al navegador
         while ((tam = read(sockfd2, buffer, sizeof(buffer))) > 0){
    	  if (write(newsockfd, buffer, tam) != tam)
      	    die("write");
  	 }
         fprintf(log,"sent\t");
      } 

      lt = time(NULL);
      fprintf(log,"%s",ctime(&lt));
      fclose(log);
 
      exit(EXIT_SUCCESS);
    }
    else
      /* I'm the parent. */
      close(newsockfd);

  }

  fclose(log);
  return 0;
}
