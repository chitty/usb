/* 
 * Archivo: nose
 *	asdffffffffffaaasdaaaaaaaaaaaa{{{{{{{{{{{{eeeeeeeee
 * Autor: Carlos J. Chitty 07-41896
 */

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "listas.h"


int main(int argc, char *argv[ ]){

  Lista forbid=NULL;
  char *data;

  printf("argc %d", argc); //ver argc
  if (argc > 2){
    if ( (strcmp(argv[1], "-f") == 0) ){
      forbid = archivoP(argv[2]);
    }  
  }

  return 0;
}


/* Leer Archivo de URLs prohibidas
 */
Lista archivoP(char *archivo){

  URL prohibida;
  Lista l = NULL; /* lista vacia */
  char dummy;
  FILE *ifp;
  ifp = fopen(archivo,"r");
  long int pos=ftell(ifp); //recuerda la posición 

  // leer archivo hasta el final
  do{
    fseek(ifp,pos,SEEK_SET);
    prohibida = leerLinea(ifp);
    l=Insertar(l,&prohibida);
    pos=ftell(ifp);
  }while( fscanf(ifp, "%c", &dummy) != EOF );

  Consultar(l);

  fclose(ifp);

  return l;
}

/* leerLinea
 * Lee una linea del archivo abierto y almacena la
 * informacion de manera apropiada
 * retorna: una lista con la información leida de una linea
 */
URL leerLinea(FILE *ptr) {

  FILE *ifp=ptr;
  char d;
  URL url;

  /* Crea espacio para el nombre y lo pasa en la estructura e */
  url.Info = (char*)malloc(sizeof(char)*MAXNOMBRE);
  
  if (url.Info == NULL){ // En caso de que falle malloc()
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }

  fscanf(ifp, "%s", url.Info);
 
  // en caso de haber basura...
  while( fscanf(ifp, "%c", &d) && d!='\n');

  return url;
}
