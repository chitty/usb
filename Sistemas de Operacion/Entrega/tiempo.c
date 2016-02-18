/*****************************************************************************
 * ARCHIVO : Ejemplo_Tiempo.c  
 *
 * CONTENIDO : implementacion de la funcion para el calculo de la combinatoria
 *             de dos numeros con toma de tiempos en Solaris o Linux
 *
 * AUTOR :  Yudith Cardinale
 *
 * LIBRERIAS UTILIZADAS: stdio.h, stdlib.h sys/time.h math.h
 *
 *****************************************************************************/

#include <stdlib.h> 
#include <math.h>
#include <stdio.h>
#include <sys/time.h>


/***************************************************************************
 * Definicion de la funcion para tomar los tiempos en Solaris o Linux.
 * Retorna el tiempo en microsegundos
 ***************************************************************************/
int Tomar_Tiempo()
{
  struct timeval t;     /* usado para tomar los tiempos */
  int dt;
  gettimeofday ( &t, (struct timezone*)0 );
  dt = (t.tv_sec)*1000000 + t.tv_usec;
  return dt;
}                              

/*****************************************************************************
 * FUNCION : factorial.
 *
 * DESCRIPCION : dado un numero entero calcula su factorial recursivamete.
 *
 * PARAMETROS : (->)y entero,
 *              (<-)entero.
 *
 * VARIABLES GLOBALES : ninguna.
 *
 *****************************************************************************/


int factorial (int y)
{
  int i,x;

  x=1;
  for (i=1;i<=y;i++)
    {
      x=x* i;              
    }
  return x;
}      

/*****************************************************************************
 * FUNCION : combinatoria.
 *
 * DESCRIPCION : dado dos numeros enteros calcula la combinatoria del primero
 *               en el segundo.
 *
 * PARAMETROS : (->)m entero,n entero
 *              (<-)entero.
 *
 * VARIABLES GLOBALES : ninguna.
 *
 *****************************************************************************/
int comb (int m, int n)
{
  int x;

  x=factorial (m)/(factorial (n)*factorial (m-n));
  return x;
}
                        
