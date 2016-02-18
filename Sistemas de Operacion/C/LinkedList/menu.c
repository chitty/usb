/* Archivo menu.c 
   Contiene funciones para  la interaccion con el usuario
   Se utiliza la funcion getchar para obtener la opcion que introduce
   el usuario.  El problema con getchar() es que, como el sistema de
   operacion utiliza buffers, este ultimo solo es pasado al programa
   cuando se introduce un ENTER. Si el usuario aprieta una tecla ('1',
   por ejemplo), esa entrada no llegara al progama, via getchar, hasta
   que no se apriete el ENTER. En consecuencia, la siguiente llamada a
   getchar devolvera el ENTER, que no es una opcion valida.

*/
#include "listas.h"

/* Menu
 * Imprime en la pantalla el menu
 */
void Menu(void)

{ 
  printf("\n                              NOMINA DE EMPLEADOS\n\n");
  printf(" 1) Insertar empleado en la nomina\n"
	 " 2) Eliminar empleado de la nomina.\n"
	 " 3) Consultar.\n"
	 " 4) Salir.\n\n\n");
  printf("Elija una de las opciones y apriete ENTER: ");
}

/* getOpcion
 * Devuelve la opcion (valor ASCII de la tecla oprimida) en el
 * teclado. Toma solo la primera tecla apretada, y luego descarta el
 * resto de las teclas apretadas hasta el primer ENTER
*/
char getOpcion(void)
{
  char c;
  c=getchar();
  getEnter();
  return c;
}

/* getEnter
 * Descarta todos las teclas apretadas hasta encontrar un ENTER
 */
void getEnter(void)
{
  while (getchar() != '\n');
}
