/* 
 * Archivo: dd.c
 * Contiene el programa principal y el menu
 * Version con procesos
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include "inode.h"
#include "dd.h"

int main(int argc, char *argv[ ]){

  long tamano;
  int i, status, childpid, n_inodos, N, num=0, choice = 0;
  unsigned short nbloques;
  FILE *ifp;

   if (argc < 4+atoi(argv[4])) {
    printf("Numero de parametros incorrecto\n");
    printf("Usar dd superblock Tam Nro.Inodos Nro.Particiones Part1... PartN \n");
    exit(1);
  }

  tamano = atoi(argv[2]); /* Tamano en bytes de la particion */   
  n_inodos  = atoi(argv[3]);
  N  = atoi(argv[4]); /* Numero de particiones del disco */
  nbloques = (tamano - n_inodos*(sizeof(tiny_inodeD)))/BLOCKSIZE; 

  while ( choice != 6 ){

    menu();
    scanf("%d",&choice);
    switch ( choice ){

      case 1: //** MOSTRAR PARTICION **//
	do{
	  printf("Indique el numero 'n' de particion, el numero n debe ser 0<n<=%d:\n",N);
	  scanf("%d",&num);
	} while(1>num || num>N);

	MostrarParticion(argv[4+num], n_inodos, nbloques, tamano);
	break;

      case 2: //** COMPACTAR DISCO **//

 	// Abanico de procesos
	for (i=0; i<N; i++){
	  if ( (childpid = fork()) < 0 ){
	    perror("fork:");
	    exit(1);
  	  }
	  if (childpid == 0) {
	    Compactar(argv[5+i], n_inodos, nbloques, tamano);
	    exit(0);
	  }
	}
	for (i=0; i<N; i++) // padre espera por los hijos
	  wait(&status);
	
	break;

      case 3: //** FORMATEAR DISCO **//

	// Abanico de procesos
	for (i=0; i<N; i++){
	  if ( (childpid = fork()) < 0 ){
	    perror("fork:");
	    exit(1);
  	  }
	  if (childpid == 0) {
	    Formatear(argv[5+i], n_inodos, nbloques, tamano);
	    exit(0);
	  }
	}
	for (i=0; i<N; i++) // padre espera por los hijos
	  wait(&status);
	break;

      case 4:  //** MOSTRAR BLOQUES LOGICOS **//
	do{
	  printf("Indique el numero 'n' de particion, el numero n debe ser 0<n<=%d:\n",N);
	  scanf("%d",&num);
	} while(1>num || num>N);
	MostrarBloques(argv[4+num], n_inodos, nbloques, tamano);
	break;

      case 5:  //** CHEQUEO DE CONSISTENCIA **//

	// Abanico de procesos
	for (i=0; i<N; i++){
	  if ( (childpid = fork()) < 0 ){
	    perror("fork:");
	    exit(1);
  	  }
	  if (childpid == 0) {
	    Consistencia(argv[5+i], n_inodos, nbloques, tamano, i);
	    exit(0);
	  }
	}
	for (i=0; i<N; i++) // padre espera por los hijos
	  wait(&status);

	comparar(argv[1],N);
	break;

      case 6:
	printf("Goodbye!\n");
	break;

      default:
	printf("Opcion invalida!\n");
	break;
    }

  }
  return 0;
}

void menu(){

  printf("\n\t________\n\t\\ MENU /\n\n");
  printf("1. Mostrar Particion\n");
  printf("2. Compactar Disco\n");
  printf("3. Formatear Disco\n");
  printf("4. Mostrar los Bloques Logicos de un Determinado Archivo\n");
  printf("5. Chequeo de Consistencia\n");
  printf("6. Salir\n");
}
