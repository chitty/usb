/* 
 * Archivo: funciones.c
 *	
 *   Implementacion de diversas funciones utilizadas
 *   en el programa hproxy 
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <netdb.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include "funciones.h"
#include "sockutil.h"

#define PORT 16000

/** Lee el archivo de URLs prohibidas y almacena
 *  la informacion en una lista
 */
Lista archivoP(char *archivo){

  URL prohibida;
  Lista l = NULL; /* lista vacia */
  char dummy;
  FILE *ifp;
  ifp = fopen(archivo,"r");
  if ( ifp != NULL ){

    long int pos=ftell(ifp); //recuerda la posición 

    // leer archivo hasta el final
    do{
      fseek(ifp,pos,SEEK_SET);
      prohibida = leerLinea(ifp);
      l=Insertar(l,&prohibida);
      pos=ftell(ifp);
    }while( fscanf(ifp, "%c", &dummy) != EOF );

    fclose(ifp);

    return l;

  }else // en caso de no existir el archivo 
    return NULL;
}


/** Lee una linea del archivo abierto y almacena la URL
 *  de manera apropiada en una lista.
 */
URL leerLinea(FILE *ptr) {

  FILE *ifp=ptr;
  char d;
  URL url;

  /* Crea espacio para la url */
  url.Info = (char*)malloc(sizeof(char)*MAXURL);
  
  if (url.Info == NULL){ // En caso de que falle malloc()
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }

  fscanf(ifp, "%s", url.Info);
 
  // en caso de haber basura...
  while( fscanf(ifp, "%c", &d) && d!='\n');

  return url;
}


/** Revisa si la URL solicitada esta bloqueado o no
 *  si no esta bloqueada obtiene la IP del servidor
 *  web al que el navegador se desea conectar
 */
char* getServerIP(int fd, Lista forbid, FILE *log){

  char buf[1024];
  char *ptr, *dir, *ip;
  int amount;
  int msg = 1;
  int filefd;
  size_t n;
  struct hostent *cch;
  mode_t fd_mode = S_IRUSR | S_IWUSR | S_IRGRP;

  if (( amount = read(fd, buf, sizeof(buf))) <= 0)
    fatalerror("No se pudo leer");

  // Lee la peticion del navegador y la guarda en fd
  if ((filefd = open("fd", O_WRONLY | O_CREAT, fd_mode) ) == -1)
    perror("No se pudo abrir el archivo fd");

  if ( write(filefd, buf, amount) != amount) {
    die("write");
    return;
  }

  close(filefd);  

  ptr = strtok( buf, " "); // lee el GET
  if( strcmp( buf, "GET" ) == 0 ){
    ptr = strtok(NULL, " ");
  
    fprintf(log,"%s\t",ptr);

    if (forbid== NULL) {
    // pagina no esta prohibida

    } else {
      // recorro la lista de paginas prohibidas
      while (forbid!= NULL) {
        n = strlen(forbid->Info);
        if( strncmp( forbid->Info, ptr, n ) == 0 ){
	  if ( n < strlen(ptr) )
	    msg = 2;

	  URLprohibida(ptr,forbid->Info,msg);
	  return "block";
        }

        if (forbid->proximo != NULL )
	  forbid= forbid-> proximo;
        else
	  break;
      }
    }

    // sacar la parte http:// del URL para que
    // el DNS resuelva el nombre a una IP 
    ptr = strtok( ptr, "http://");

    cch = gethostbyname(ptr);
 
    if (cch==NULL)
      fatalerror("No hay ese host");
    else 
      ip = (char *)inet_ntoa(*((struct in_addr *)cch->h_addr));
  
  } else
    fatalerror("No se puede determinar IP del servidor");

  return ip;
}

/** Envia la pagina correspondiente al error
 *  de pagina prohibida
 */
void URLprohibida(char *url,char *MAINurl,int msg){
	
  FILE *out;
  out = fopen("urlP","w");

  if (msg==1){ // Mensage de error 1

    fprintf(out,"<html>\n");
    fprintf(out,"<head><title>error1</title></head>\n");
    fprintf(out,"<bodyl>\n");
    fprintf(out,"<h1>Página Prohibida</h1>\n");
    fprintf(out,"<h2>La página %s esta en la lista de páginas prohibidas, si necesita información de esa página contacte al administrador del sistema</h2>\n", url);
    fprintf(out,"</body>\n");
    fprintf(out,"</html>\n");
  
  } else if(msg==2){ // Mensage de error 2

    fprintf(out,"<html>\n");
    fprintf(out,"<head><title>error1</title></head>\n");
    fprintf(out,"<bodyl>\n");
    fprintf(out,"<h1>Página Prohibida</h1>\n");
    fprintf(out,"<h2>La página %s está contenida dentro de la página prohibidas %s, si necesita información de esa página contacte al administrador del sistema</h2>\n", url,MAINurl);
    fprintf(out,"</body>\n");
    fprintf(out,"</html>\n");

  }

  fclose(out);
}

/** Verifica si el puerto dado es correcto.
 *  Si no lo es, se usa el puerto por defecto
 */
int port(char *puertoS){

  int puerto;
  int dummy;

  dummy = atoi(puertoS);
  if ( dummy >= 1024 && dummy <= 65535)
    puerto = dummy;
  else
    puerto = PORT;

  return puerto;
}
