
/* Archivo EjemploLista.c
 * Aplicacion que ejercita el manejo de listas enlazadas con manejo
 * dinamico de la memoria. Consiste en el manejo de una peque~na
 * nomina, que contiene un registro por empleado, con su nombre, edad,
 * sueldo, cedula. El espacio para la cadena de caracteres del nombre
 * tambien se maneja  dinamicamente, aunque no es necesario en este
 * ejemplo. 
 * Uso: EjemploLista (no requiere parametros)
 * Despliega un menu que permite seleccionar la operacion deseada
 */

#include "listas.h"


/* Programa Principal */

int main(void)
{
  int opcion;

  Lista l; 
  EMPLEADO e; /* almacena temporalmente el empleado introducido por el
		 usuario */
  int Cedula;
    
	
	
  l= NULL; /* lista vacia */

  system("clear"); 
  Menu(); /*Muestra las opciones del menu*/

  opcion = getOpcion();
  /* Lazo principal: presenta el menu, y realiza la accion de acuerdo
     a la seleccion del usuario */
  while (opcion != '4' ) { 
    switch (opcion) {
    case '1': /* Insertar empleado */
      printf("Por favor inserte la informacion del empleado en el siguiente orden:\n");
      printf("Nombre :");
      /* Crea espacio para el nombre y lo pasa en la estructura e */
      e.Nombre = (char*)malloc(sizeof(char)*MAXNOMBRE);
      scanf("%s",e.Nombre);
      printf("\nEdad :");
      scanf("%d", &e.Edad);
      printf("\nSueldo:");
      scanf("%f",&e.Sueldo);
	
      printf("\nCedula :");
      scanf("%ld",&e.Cedula);

      l = InsertarEmp(l, &e);
      printf("Presione ENTER\n");
      getEnter(); 
      getEnter(); /* se llama dos veces porque el scanf deja el ENTER
		     de fin de linea en el buffer */
      break;
    case '2':/* Eliminar empleado */
      printf("Por favor introduzca la cedula del empleado que desea eliminar de la nomina:\n ");
      printf("\nCedula: ");
      scanf("%ld",&Cedula);
      l= EliminarEmp(l,Cedula);
      printf("Presione ENTER\n");
      getEnter();
      getEnter(); /* se llama dos veces porque el scanf deja el ENTER
		     de fin de linea en el buffer */
      break;
    case '3': /* Consultar */
      Consultar(l);
      break;
    case '4': /* Salir */
      exit(1);
      break;
    default:
      printf("Invalida opcion, por favor vuelva a intentar.\n\n");
      break;
    }
    Menu();
    opcion = getOpcion();
  }
  printf("Se termino el programa.\n");
  return 0;
	
}
