/* Archivo: createpart.c
   Descripción: contiene funciones para crear una partición según las especificaciones dadas en el nunciado 
   del proyecto. La descripción de los archivos se encuentra en un archivo de texto que recibe como parámetro.
   La salida es un archivo binario con el contenido de la partición. También contiene unas rutinas auxiliares 
   que permiten verificar si los datos se leyeron y almacenaron correctamente en la memoria  y en el disco. 
   Realizado por: M. Curiel
   Fecha: May 13 2009.

*/


#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <sys/mman.h>
#include "inode.h" 
#include "tiempo.h"


/* Variable global que elmacena en bytes el espacio ocupado por los inodos 
   en la partición */ 

long InodeArea;


/* Rutina: Imprimir
   Descripción: Función que permite imprimer la estructura de datos que guarda los inodos temporalmente en memoria antes de escribirlos a disco 
   Parámetros: el número de inodos ocupados y el inicio de la estructura de datos.

*/

void  Imprimir(unsigned short  n_inodos, tiny_inodeM *Inom) {

  int i, j;
  l_block *aux;
  printf("\nInformacion de los Inodos en la Memoria \n");
  for (i = 0; i < n_inodos; i++) {
    printf("\n\n Inodo %d\n", i);
    printf("uid = %hd--size = %ldKb", Inom[i].i_uid, Inom[i].fsize);
    aux = Inom[i].Lblocks;
    printf("\nBloques de datos: ");
    while (aux != NULL) {
      printf("%u-", aux->nblock);
      aux = aux->next;
    }
  }

}

/*
  Rutina: LlenarInodos.
  Función: lee el archivo con la descripción de la partición y vacía 
  esta información en una estructura de datos de la memoria. Añade 
  otros datos a cada inodo como la fecha de creación y el tipo de archivo. 
  Parámetros: 
  numinodos: numero total de inodos de la particion
  Inodes: Dirección de Inicio de la estructura de datos en la memoria que tiene   información de los inodos.  
  fdata: descriptor del archivo que contiene los datos de la partición a crear.
  Retorna: el numero de inodos llenos, es decir aquellos descritos en el 
  archivo de entrada. 

*/

unsigned short  LlenarInodos(unsigned short  numinodos, tiny_inodeM *Inodes, FILE *fdata) {

  int i=0, j=0, bloques;
  
  block_nr nbloque;
  time_t t;

  while (!feof(fdata) && i < numinodos) {
    fscanf(fdata, "%hd %ld\n", &Inodes[i].i_uid, &Inodes[i].fsize);
    fscanf(fdata, "%d\n", &bloques);
    Inodes[i].i_creattime = Tomar_Tiempo(); // Tiempo en microsegundos desde Epoch, January 1, 1970.
    Inodes[i].i_mode = I_REGULAR; // Siempre se coloca el mismo tipo de archivo
    for (j=0; j < bloques; j++) {
      /* Construye en la memoria una lista con los bloques lógicos del archivo */
        fscanf(fdata, "%u\n", &nbloque);
        if (j == 0) {
	  Inodes[i].Lblocks = (l_block *) malloc(sizeof(l_block));
          Inodes[i].Lblocks->nblock = nbloque;
          Inodes[i].Lblocks->next = NULL;
          Inodes[i].last = Inodes[i].Lblocks;
        } else {
          Inodes[i].last->next = (l_block *) malloc(sizeof(l_block));
          Inodes[i].last = Inodes[i].last->next;
          Inodes[i].last->nblock = nbloque;          
          Inodes[i].last->next = NULL;
        }
    }
    i++;
  }
  
  return((unsigned short) i);

}



/*
  Rutina: CrearParticion.
  Función: Recorre la estructura de Datos Inom, que contiene la información de los nodos ocupados de la 
  partición y va escribiendo esta información en el archivo de salida. Para enlazar los bloques de datos en
  el disco utiliza la función lseek. 
  Parámetros: 
  inodos_llenos: numero de inodos ocupados de la particion
  inodos_disco: total de inodos de la partición. 
  Inom: inicio de la estructura de datos en la memoria que contiene la información de los inodos. 
  nbloques: total de bloques de la pertición.
  fd: descriptor del archivo de salida 
 

*/
void CrearParticion(unsigned short inodos_llenos, unsigned short inodos_disco, tiny_inodeM *Inom, unsigned short nbloques, int fd) {


  int i, bytes, vacio=EMPTY, cero;
  
  block_nr proximo;
  // Copia de los Inodos en la particion;

  tiny_inodeD *InDisk;
  tiny_block blockmem, blockmemE;
  l_block *aux;

  InodeArea = (sizeof(tiny_inodeD)*inodos_disco);

  
 
  /* Crea una estructura similar a Inom, pero los registros son similares a la representación que tendrán 
  los inodos en el disco. La idea es construir el registro en la memoria para después escribirlo al disco.
   En este registro sólo va el  número del primer bloque lógico de cada archivo.  */

  InDisk = (tiny_inodeD *)calloc(inodos_disco, sizeof(tiny_inodeD));
  
  for (i = 0; i < inodos_llenos; i++) {
    
    InDisk[i].i_uid = Inom[i].i_uid;
    InDisk[i].i_creattime = Inom[i].i_creattime; 
    InDisk[i].fsize = Inom[i].fsize;     
    InDisk[i].first_block = Inom[i].Lblocks->nblock;
    
     
  }
  

  /* Los inodos vacíos se inicializan */ 

  for (i = inodos_llenos; i < inodos_disco; i++) InDisk[i].i_uid = EMPTY;

  // Se escribe el arreglo de Inodos en el disco

  bytes = write(fd, InDisk, inodos_disco*sizeof(tiny_inodeD));
  
  if (bytes <= 0) {
     perror("write");
     exit(1);

  }
  
  // Una variable que  sirve para representar un bloque vacío. 

   blockmemE.next_block = EMPTY;
  
   // Se llena el área de datos del bloque con 0. 
  strncpy(blockmemE.datos,(char *)&cero, BLOCKDATA); 

  // Primero se llena toda la partición de bloques vacíos. 
  for (i = 0; i < nbloques; i++) {
      
      bytes = write(fd, &blockmemE, BLOCKSIZE);
      
      if (bytes <= 0) {
         perror("write");
         exit(1);
      }
      
  }
    
  /* En este ciclo se enlazan los bloques de cada archivo en el disco. El primer ciclo recorre los Inodos. 
     El segundo recorre la lista de bloques lógicos  de cada archivo */  

  for (i = 0; i < inodos_llenos; i++) {
    // Una iteración por cada inodo lleno. Se obtiene  el primer bloque lógico.     
    proximo = Inom[i].Lblocks->nblock;
    aux = Inom[i].Lblocks->next;
    // Escribo cualquier cosa en el área de datos. Noten que cada bloque está lleno. En los archivos reales, el último bloque del archivo no tiene porque estar lleno. 

    strncpy(blockmem.datos,(char *)&i, BLOCKDATA); 
    while (aux != NULL) {
      /* Se va a la posición de cada bloque lógico en el disco con lseek y en el registro  se coloca el número 
	 del próximo bloque lógico que se obtiene de la lista que mantiene cada inodo en la memoria. El desplazamiento es siempre desde el inicio del archivo (SEEK_SET) */
  
      lseek(fd, InodeArea + BLOCKSIZE*proximo, SEEK_SET);      
      blockmem.next_block = aux->nblock;
      bytes = write(fd, &blockmem, BLOCKSIZE);
      if (bytes <= 0) {
         perror("write");
         exit(1);
      }
      // pasarse al siguiente bloque lógico en la lista de la memoria. 
      proximo = aux->nblock;
      aux = aux->next;
    }
    if (aux == NULL) {
      // Ultimo bloque del archivo. 
       lseek(fd, InodeArea + BLOCKSIZE*proximo, SEEK_SET);
       blockmem.next_block = LAST;
       bytes = write(fd, &blockmem, BLOCKSIZE);    
       if (bytes <= 0) {
         perror("write");
         exit(1);
      }   
       
    } 

  }


}


/*
  Rutina: MostrarParticion.
  Función: Muestra el contenido de la partición creada, haciendo un mapping del disco a la memoria mmap(). 
  Observen como se puede traer el contenido de un archivo a la memoria (con una sola operación) y tratarse 
  como un arreglo. Observen también como la misma zona de memoria se puede ver como un registro de bloque o
  de disco, dependiendo del apuntados que coloquen al comienzo. 
  
  Parámetros: 
  fd: descriptor del archivo donde se encuentra la partición. 
  n_inodos: total de inodos de la partición. 
  nbloques: total de bloques de la pertición.
  tamano: tamano de la particion.  
 
*/

void MostrarParticion(int fd, unsigned short n_inodos, unsigned short nbloques, int tamano) {

  void *A;
  tiny_inodeD *pinodes;
  tiny_block *pblock;
  int i, primero, proximo;
  

   A = (void *)mmap(0, tamano, PROT_READ,MAP_PRIVATE, fd, 0);
   pinodes = (tiny_inodeD *)A;

   printf("\n\n DATOS ALMACENADOS EN EL DISCO\n\n");
   printf("\n Informacion sobre los inodos\n");
   for (i = 0; i < n_inodos; i++) {
    printf("\n\nInodo %d\n", i);
    printf(" uid =%hd--size = %ldKb", pinodes[i].i_uid, pinodes[i].fsize);
    printf(" Primer Bloque = %d", pinodes[i].first_block);
   }
    printf("\n\n INFORMACION SOBRE LOS BLOQUES DE LA PARTICION\n");
    
    pblock = (tiny_block  *)((char *)A + InodeArea);
    for (i = 0; i < nbloques; i++) {
	printf("Bloque %d ", i);
        printf("proximo %d\n", pblock[i].next_block);
   
    }
    munmap(0, tamano);
    
}


int main(int argc, char *argv[]) {
  
  long tamano;
  int n_inodos, nbloques;
  unsigned short llenos;
  FILE *fdata;
  int fd;
  tiny_inodeM *Inom;
  tiny_inodeD *Inod;
 


   if (argc < 4) {
    printf("Numero de parametros incorrecto\n");
    printf("Usar createpart tamano_particion Nro.Inodos InputData Particion \n");
    exit(1);

  }
   /* Tamano en bytes de la particion */
   tamano = atoi(argv[1]);
   /* Numero de archivos que se podrán almacenar */
   n_inodos  = atoi(argv[2]); 

   /* Se abre el archivo que contiene información sobre los archivos de la partición. Este archivo debe 
   tener el formato explicado en el archivo data */

   if ((fdata = fopen(argv[3],"r+")) == NULL) {
        printf("Error abriendo el archivo %s\n", argv[3]);
        exit(1);

   }
   /* Archivo que contiene la partición con los inodos y bloques de datos */

   if ((fd = open(argv[4],O_CREAT|O_TRUNC|O_RDWR,S_IRWXU)) == -1) {
         perror("open archiv de salida muestra: ");
         exit(1);

   }
   
   /* Estructura de datos para guardar la información de los inodos en la 
      memoria antes de pasarla al disco */

   Inom = (tiny_inodeM *) malloc(n_inodos*sizeof(tiny_inodeM));

   /* Llenar la estructuras de datos de la memoria con la información contenida en InputData (argv[3]). La rutina devuelve el número de nodos ocupados en la partición, es decir, aquellos cuya información se describe en InputData */

   llenos = LlenarInodos(n_inodos, Inom, fdata);


   /* De acuerdo al número de inodos, al tamano de la partición y al tamano de bloques, se calcula 
   el número de bloques libres de la partición. Aqui se debería verificar que por ejemplo, el tamaño de
    la partición no sea más pequeño que el tamaño del bloque o que el numero de bloques de la partición no 
   sea menos al numero de bloques ocupados por los archivos */

   nbloques = (tamano - n_inodos*(sizeof(tiny_inodeD)))/BLOCKSIZE; 
   /* Ver si los datos se leyeron y almacenaron bien en la memoria */

   Imprimir(llenos, Inom);

   /* Rutina que crea el archivo binario que representa la partición */
  
   CrearParticion(llenos, n_inodos, Inom, nbloques, fd);

   /* Se muestra el contenido de la partición usando mmap() */
   MostrarParticion(fd, n_inodos, nbloques, tamano);

   /* Se cierran los archivos, también se debería liberar la memoria. */
   fclose(fdata);
   close(fd);
    
}
