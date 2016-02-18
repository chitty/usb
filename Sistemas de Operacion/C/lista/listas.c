/* Archivo listas.c
   Contiene funciones para el manejo de una lista enlazada de la
   aplicacion EjemploList
*/

#include "listas.h"

/* Insertar
 * Inserta un nuevo empleado en la lista
 * Crea un nuevo EMPLEADO, y lo rellena con la informacion pasada por
 * parametro. La insercion se hace al principio, por ser mas eficiente 
 * l: lista donde se insertara el nuevo empleado
 * e: apuntador a la estructura con la informacion del nuevo empleado
 *    que sera insertado  
 * retorna la lista (apuntador al primer elemento)
 */
Lista Insertar(Lista l, URL * e)
{ 
  Lista Temp;
	
  Temp = malloc(sizeof(URL));
  Temp->Info = e->Info; /* No necesita crear el espacio porque ya
			      fue creado en el programa principal */
  Temp -> proximo = l; 
  return Temp;
}


/* Consultar
 * Imprime en pantalla los datos de todos los empleados existentes
 * l: lista a imprimir
 */
void Consultar(Lista l)
{
  if (l== NULL) {
    printf("\n\nNO HAY ELEMENTOS EN LA LISTA.\n\n");

  } else {
    printf("\n\nURL BLOQUEADAS: \n\n");
    while (l!= NULL) {
      printf("%s%s\n","data: ",l->Info);

      if (l->proximo != NULL )
	l= l-> proximo;
      else
	  return;
    }
  }
}
