/* Archivo listas.c
   Contiene funciones para el manejo de una lista enlazada de la
   aplicacion EjemploList
*/

#include "listas.h"

/* InsertarEmp 
 * Inserta un nuevo empleado en la lista
 * Crea un nuevo EMPLEADO, y lo rellena con la informacion pasada por
 * parametro. La insercion se hace al principio, por ser mas eficiente 
 * l: lista donde se insertara el nuevo empleado
 * e: apuntador a la estructura con la informacion del nuevo empleado
 *    que sera insertado  
 * retorna la lista (apuntador al primer elemento)
 */
Lista InsertarEmp(Lista l, EMPLEADO * e)
{ 
  Lista Temp;
	
  Temp = malloc(sizeof(EMPLEADO));
  Temp->Nombre = e->Nombre; /* No necesita crear el espacio porque ya
			      fue creado en el programa principal */
  Temp->Edad = e->Edad;
  Temp->Sueldo = e->Sueldo;
  Temp->Cedula = e->Cedula;
  Temp -> proximo = l; 
  return Temp;
}

/* EliminarEmp
 * Elimina un empleado de la lista, identificado por la cedula
 * Se recorre la lista buscando por la cedula. Si se encuentra, se
 * elimina, enlazando el anterior del eliminado con el siguiente, para
 * no romper la lista. Si no se encuentra, se escribe un mensaje en la
 * pantalla 
 * l: lista de donde sera eliminado el empleado
 * Cedula: cedula del empleado que se quiere eliminar
 * retorna lista (apuntador al primer elemento, o NULL si vacia)
 */ 
 Lista EliminarEmp(Lista l, int Cedula)
{
  Lista Temp,anterior;
    
  if (l == NULL) return NULL; /* lista vacia */

  if (Cedula == l->Cedula  ) { /* Caso especial: el empleado a
				  eliminar esta de primero */
    Temp= l;
    l= l-> proximo; /* la lista empieza ahora en el segundo */
    free(Temp->Nombre); /* libera espacio del Nombre primero! */
    free(Temp); /* libera espacio de Empleado eliminado */
    return l;
  } else {  /* empleado no esta de primero */ 
    anterior= l;
    Temp= l-> proximo;
    /* Ahora recorre la lista buscando por el campo  Cedula */
    while (Temp != NULL && Temp->Cedula != Cedula) {
      anterior= Temp;
      Temp= Temp-> proximo;
    }
  }
  if (Temp!= NULL) { /* Encontro empleado con esa cedula */
    anterior-> proximo = Temp->proximo;
    free(Temp->Nombre); /* libera espacio del Nombre primero! */
    free(Temp); /* libera espacio de Empleado eliminado */
    return l;
  } else { /* No se encontro empleado con esa cedula */
    printf("\n\nESTE EMPLEADO NO SE ENCUENTRA EN LA NOMINA\n\n");
    return l;
  }
}



/* Consultar
 * Imprime en pantalla los datos de todos los empleados existentes
 * l: lista a imprimir
 */
void Consultar(Lista l)
{
  if (l== NULL) {
    printf("\n\nNO HAY EMPLEADOS EN LA NOMINA.\n\n");
    printf("\n\nPresione ENTER\n\n");
    getEnter();
  } else {
    printf("\n\nNOMINA DE EMPLEADOS: \n\n");
    while (l!= NULL) {
      printf("--------------------------------------\n");
      printf("%s%s\n","Nombre: ",l->Nombre);
      printf("%s%d\n","Edad: ",l->Edad);
      printf("%s%f\n\n","Sueldo: ",l->Sueldo);
      printf("%s%d\n\n","Cedula: ",l->Cedula);
      printf("--------------------------------------\n");
      if (l->proximo != NULL )
	{
	  l= l-> proximo;
	  printf("Presione ENTER para seguir mostrando.\n");
	  getEnter();
	} else {
	  printf("La lista se acabo. Presione ENTER\n");
	  getEnter();
	  return;
	}
    }
  }
}
