/* 
 * Archivo: dd.c
 * Contiene el programa principal y el menu
 * Version con threads
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <pthread.h>
#include <unistd.h>
#include <string.h>
#include "inode.h"
#include "dd.h"

int main(int argc, char *argv[ ]){

  long tamano;
  int i, rc, n_inodos, N, num=0, choice = 0;
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
  pthread_t threads[N]; // N hilos
  struct thread_data thread_data_array[N];
  struct thread_data1 thread_data_array1[N];


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

	for (i=0; i<N; i++){
	  thread_data_array[i].archivo = argv[5+i];
	  thread_data_array[i].n_inodos = n_inodos;
	  thread_data_array[i].nbloques = nbloques;
	  thread_data_array[i].tamano = tamano;
	  rc = pthread_create(&threads[i], NULL, Compactar, (void *) &thread_data_array[i]);
          if (rc) {
            perror("Compactar");
            exit(-1);
          }
	}
        // espera a que todos los hilos terminen
	for (i=0; i<N; i++)
	  pthread_join(threads[i], NULL);
	break;

      case 3: //** FORMATEAR DISCO **//

	for (i=0; i<N; i++){
	  thread_data_array[i].archivo = argv[5+i];
	  thread_data_array[i].n_inodos = n_inodos;
	  thread_data_array[i].nbloques = nbloques;
	  thread_data_array[i].tamano = tamano;
	  rc = pthread_create(&threads[i], NULL, Formatear, (void *) &thread_data_array[i]);
          if (rc) {
            perror("Formatear");
            exit(-1);
          }
	}
        // espera a que todos los hilos terminen
	for (i=0; i<N; i++)
	  pthread_join(threads[i], NULL);
	break;

      case 4:  //** MOSTRAR BLOQUES LOGICOS **//
	do{
	  printf("Indique el numero 'n' de particion, el numero n debe ser 0<n<=%d:\n",N);
	  scanf("%d",&num);
	} while(1>num || num>N);
	MostrarBloques(argv[4+num], n_inodos, nbloques, tamano);
	break;

      case 5:  //** CHEQUEO DE CONSISTENCIA **//

	for (i=0; i<N; i++){
	  thread_data_array1[i].archivo = argv[5+i];
	  thread_data_array1[i].n_inodos = n_inodos;
	  thread_data_array1[i].nbloques = nbloques;
	  thread_data_array1[i].tamano = tamano;
	  thread_data_array1[i].k = i;
	  rc = pthread_create(&threads[i], NULL, Consistencia, (void *) &thread_data_array1[i]);
          if (rc) {
            perror("Consistencia");
            exit(-1);
          }
	}
        // espera a que todos los hilos terminen
	for (i=0; i<N; i++)
	  pthread_join(threads[i], NULL);

	// despues que todos terminen se puede comparar
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
