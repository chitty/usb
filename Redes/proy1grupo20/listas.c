/* Archivo listas.c
   Contiene la funcion para insertar a una lista
*/

#include "listas.h"

/* Insertar
 * Inserta una nueva URL en la lista
 * retorna la lista (apuntador al primer elemento)
 */
Lista Insertar(Lista l, URL * e)
{ 
  Lista Temp;
	
  Temp = malloc(sizeof(URL));
  Temp->Info = e->Info;
  Temp -> proximo = l; 

  return Temp;
}
