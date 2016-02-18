/* 
 * Archivo: nose
 *	asdffffffffffaaasdaaaaaaaaaaaa{{{{{{{{{{{{eeeeeeeee
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <stdlib.h>
#include "listas.h"



int main(int argc, char *argv[ ]){

  Lista l; 
  EMPLEADO e;
  char *tal;
  l= NULL; /* lista vacia */

/*****************************************************/
  printf("Hablame el mix\nDame la web: ");
      /* Crea espacio para el nombre y lo pasa en la estructura e */
      e.Nombre = (char*)malloc(sizeof(char)*MAXNOMBRE);
  if (e.Nombre == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }
      scanf("%s",e.Nombre);
      l = InsertarEmp(l, &e);
  printf("\nCONSULTA \n");
      Consultar(l);
/******************************************/

  FILE *ifp;
  int dummy = 0;

  ifp = fopen(argv[1],"r");
  if (ifp == NULL){
    printf("ERROR: Archivo invalido\n");
    exit(2);
  }


  while ( fgets(e.Nombre, 1000, ifp) != NULL ) {
    printf(" guardando %s \n", e.Nombre);
    l = InsertarEmp(l, &e);
  }

  fclose(ifp);

  printf("\nCONSULTA \n");
      Consultar(l);

  return 0;

}
