/* 
 * Archivo: mostrar.c
 * Contiene la operacion Mostrar Particion, Mostrar Bloques y Consistencia
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include "inode.h"
#include "dd.h"

/* Variable global que elmacena en bytes el espacio ocupado por los inodos 
   en la partición */ 

long InodeArea;

/*
  Rutina: MostrarParticion.
  Función: Muestra el contenido de la partición indicada.
  
  Parámetros: 
  archivo: archivo donde se encuentra la partición. 
  n_inodos: total de inodos de la partición. 
  nbloques: total de bloques de la partición.
  tamano: tamano de la particion.  
 
*/

void MostrarParticion(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano) {

  void *A;
  tiny_inodeD *pinodes;
  tiny_block *pblock;
  int i, fd, dummy;
  
  if ((fd = open(archivo,O_RDONLY,S_IRWXU)) == -1) {
    perror("open archiv de salida muestra: ");
    exit(1);
  }

  InodeArea = (sizeof(tiny_inodeD)*n_inodos);
  A = (void *)mmap(0, tamano, PROT_READ,MAP_PRIVATE, fd, 0);
  pinodes = (tiny_inodeD *)A;

  printf("\n DATOS ALMACENADOS EN EL DISCO\n");
  printf("\n Informacion sobre los inodos");
  for (i = 0; i < n_inodos; i++) {
     printf("\n\nInodo %d\n", i);
     printf(" uid =%hd--size = %ldKb", pinodes[i].i_uid, pinodes[i].fsize);
     printf(" Primer Bloque = %d", pinodes[i].first_block);
  }
  printf("\n\n INFORMACION SOBRE LOS BLOQUES DE LA PARTICION\n");
    
  pblock = (tiny_block  *)((char *)A + InodeArea);
  for (i = 0; i < nbloques; i++) {
    printf("Bloque %d ", i);
    dummy = pblock[i].next_block;
    if (dummy == EMPTY )
      printf("es un bloque libre\n" );
    else if (dummy == LAST )
      printf("es el ultimo\n" );
    else 
      printf("proximo %d\n", dummy );
  }
  munmap(0, tamano);

  close(fd);
}

/*
  Rutina: MostrarBloques
  Función: Muestra el contenido de los bloques de un determinado 
  archivo ingresado por el usuario
  Parámetros: 
  archivo: archivo donde se encuentra la partición. 
  n_inodos: total de inodos de la partición. 
  nbloques: total de bloques de la partición.
  tamano: tamano de la particion.   
*/

void MostrarBloques(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano) {

  void *A;
  tiny_inodeD *pinodes;
  tiny_block *pblock;
  int i,j,fd, dummy, numI=0;
  
  if ((fd = open(archivo,O_RDONLY,S_IRWXU)) == -1) {
    perror("open archiv de salida muestra: ");
    exit(1);
  }

  InodeArea = (sizeof(tiny_inodeD)*n_inodos);
  A = (void *)mmap(0, tamano, PROT_READ,MAP_PRIVATE, fd, 0);
  pinodes = (tiny_inodeD *)A;

  do{
    printf("\n Ingrese el numero de inodo: ");
    scanf("%d",&numI);
  }while(numI>n_inodos || numI<0);

  if ( pinodes[numI].fsize == 0 )
    printf("\nEl inodo %d es vacio\n",numI);
  else {    
    pblock = (tiny_block  *)((char *)A + InodeArea);

    for (i = numI; i < nbloques; i++) {
      printf("Bloque %d ", i);
      dummy = pblock[i].next_block;

      if (dummy == LAST || dummy == EMPTY )
        break;
      else 
        printf("proximo %d\n", dummy );

      i = dummy-1;
    }
  }
  munmap(0, tamano);
  close(fd);
}

/*
  Rutina: Consistencia.
  Función: almacena en un archivo de texto la informacion necesaria
  para el posterior chequeo de consistencia
  
  Parámetros: 
  archivo: archivo donde se encuentra la partición. 
  n_inodos: total de inodos de la partición. 
  nbloques: total de bloques de la partición.
  tamano: tamano de la particion.   
*/

void Consistencia(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano, int k) {

  void *A;
  FILE *ofp;
  tiny_inodeD *pinodes;
  tiny_block *pblock;
  int i, fd, Kb=0, num_I=0, freeBlocks=0;
  char archiv[10] = "arch";
  
  if ((fd = open(archivo,O_RDONLY,S_IRWXU)) == -1) {
    perror("open archiv de salida muestra: ");
    exit(1);
  }

  InodeArea = (sizeof(tiny_inodeD)*n_inodos);
  A = (void *)mmap(0, tamano, PROT_READ,MAP_PRIVATE, fd, 0);
  pinodes = (tiny_inodeD *)A;

  for (i = 0; i < n_inodos; i++) {
     Kb += pinodes[i].fsize;
     if (pinodes[i].fsize > 0)
	num_I++; // Sumar cada inodo no vacio
  }
    
  pblock = (tiny_block  *)((char *)A + InodeArea);
  for (i = 0; i < nbloques; i++)
    if (pblock[i].next_block == EMPTY )
      freeBlocks++;

  sprintf(archiv,"%s%d",archiv,k);
  ofp = fopen(archiv,"w");
  fprintf(ofp,"%d\n%d\n%d",Kb,num_I,freeBlocks);
  fclose(ofp);
  munmap(0, tamano);
  close(fd);
}

/*
  Rutina: comparar
  Función: compara la informacion del archivo superblock con la
  informacion recolectada para determinar si hay consistencia.
  
  Parámetros: 
  archivo: archivo con la informacion del superblock
  N: Numero de archivos. 
*/
void comparar(char *archivo, int N){

  FILE *ifp, *yfp;
  char archiv[10]="arch";
  int  i, Kb=0, num_I=0, freeBlocks=0, K=0, nI=0, fB=0, dummy=0;

  if ( (ifp = fopen(archivo,"r")) == NULL ){
    printf("Error abriendo el archivo %s\n", archivo);
    exit(1);
  }

  for (i=0; i<N; i++){
    sprintf(archiv,"arch%d",i);
    yfp = fopen(archiv,"r");
    fscanf(yfp, "%d", &dummy);
    Kb += dummy;
    fscanf(yfp, "%d", &dummy);
    num_I += dummy;
    fscanf(yfp, "%d", &dummy);
    freeBlocks += dummy;
    fclose(yfp);
  }

  fscanf(ifp, "%d\n%d\n%d", &K,&nI,&fB);
  if (K==Kb && nI==num_I && fB==freeBlocks )
    printf("\nHay consistencia\n");
  else
    printf("\nHay inconsistencias en los datos del disco\n");

  printf("Datos del superbloque: %dKb, %d archivos, %d bloques libres\n",K,nI,fB);
  printf("Datos del disco: %dKb, %d archivos, %d bloques libres\n",Kb,num_I,freeBlocks);
}
