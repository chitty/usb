/* 
 * Archivo: formatear.c
 * Contiene las operaciones de Compactar y Formatear Disco
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <stdlib.h>
#include "inode.h"
#include "dd.h"


/*
  Rutina: Compactar
  Función: Compacta el disco
  
  Parámetros: 
  archivo: archivo donde se encuentra la partición. 
  n_inodos: total de inodos de la partición. 
  nbloques: total de bloques de la partición.
  tamano: tamano de la particion.  
 
*/

void *Compactar(void *threadarg) {

  char *archivo;
  unsigned short  n_inodos, nbloques;
  int  tamano;

  struct thread_data *my_data;

  my_data = (struct thread_data *) threadarg;
  archivo = my_data->archivo;
  n_inodos = my_data->n_inodos;
  nbloques = my_data->nbloques;
  tamano = my_data->tamano;

  void *A;
  tiny_block *pblock;
  int i, fd, siguiente, dummy, actual;
  long InodeArea;
  
  if ((fd = open(archivo,O_RDONLY,S_IRWXU)) == -1) {
    perror("open archiv de salida muestra: ");
    exit(1);
  }

  InodeArea = (sizeof(tiny_inodeD)*n_inodos);
  A = (void *)mmap(0, tamano, PROT_READ,MAP_PRIVATE, fd, 0);
    
  pblock = (tiny_block  *)((char *)A + InodeArea);
  for (i = 0; i < nbloques; i++) {
    siguiente = pblock[i].next_block;

    if ( i+1<siguiente && siguiente!=LAST){ 
      actual = i;		            
      while( i<siguiente ){
	i++;
	if( pblock[i].next_block == EMPTY ){
	  printf("\ni %d, actual %d, siguiente %d\n",i,actual,siguiente);
          //pblock[i] = pblock[siguiente];
	  // swap
	  break;
	}
      }
    } 
  }
  munmap(0, tamano);

  close(fd);
}

/*
  Rutina: Formatear.
  Función: Formatea la particion dada
  
  Parámetros: 
  threadarg: Structura que contiene toda la informacion a ser
  pasada.   
*/

void *Formatear(void *threadarg) {

  char *archivo;
  unsigned short  n_inodos, nbloques;
  int  tamano;

  struct thread_data *my_data;

  my_data = (struct thread_data *) threadarg;
  archivo = my_data->archivo;
  n_inodos = my_data->n_inodos;
  nbloques = my_data->nbloques;
  tamano = my_data->tamano;

  tiny_inodeD *InDisk;
  tiny_block blockmemE;
  int i, fd, bytes;
  
  if ((fd = open(archivo,O_RDWR,S_IRWXU)) == -1) {
    perror("open archiv de salida muestra: ");
    exit(1);
  }

  InDisk = (tiny_inodeD *)calloc(n_inodos, sizeof(tiny_inodeD));
  blockmemE.next_block = EMPTY;
  

  for (i = 0; i < n_inodos; i++) 
    InDisk[i].i_uid = EMPTY;

  // Se escribe el arreglo de Inodos en el disco
  bytes = write(fd, InDisk, n_inodos*sizeof(tiny_inodeD));

  if (bytes <= 0) {
     perror("write");
     exit(1);
  }

  // Se llena toda la partición de bloques vacíos. 
  for (i = 0; i < nbloques; i++) {
      
      bytes = write(fd, &blockmemE, BLOCKSIZE);      
      if (bytes <= 0) {
         perror("write");
         exit(1);
      }      
  }
  close(fd);
}
