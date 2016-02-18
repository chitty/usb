/* 
 * Archivo: reportlog.c
 * Contiene el programa principal y hace llamadas a
 * diversas funciones para generar las estadísticas
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <string.h>
#include "reportlog.h"

int main(int argc, char *argv[ ]){

  Lista l = NULL;
  DatosG gen;
  char dummy;
  FILE *ifp, *ofp;
  ifp = fopen(argv[1],"r");
  long int pos=ftell(ifp); //recuerda la posición 
  int i=0;
  int n=atoi(argv[3]); 
  char *nombres[n]; 

  // leer archivo hasta el final
  do{
    fseek(ifp,pos,SEEK_SET);
    gen = leerLinea(ifp);
    l=InsertU(l,&gen);
    pos=ftell(ifp);
  }while( fscanf(ifp, "%c", &dummy) != EOF );

  fclose(ifp);
  
  for (i=0; i<n; i++)
    nombres[i] = argv[4+i];

  ofp = fopen(argv[2],"w");

  Usuarios(l,ofp);
  countProc(l,ofp);
  Aplicaciones(n,nombres,l,ofp);

  fclose(ofp);
  return 0;
}
