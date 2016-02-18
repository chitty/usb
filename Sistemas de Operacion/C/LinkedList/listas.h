/* Archivo listas.h
 * Contiene las definiciones utilizadas en la aplicacion EjemploLista
 */ 

#include <stdio.h>
#include <stdlib.h>


#define MAXNOMBRE 20

struct Empleado {
       char *Nombre;
       int  Edad;
       float Sueldo;
       int Cedula;
       struct Empleado *proximo;
};

typedef struct Empleado EMPLEADO;
typedef struct Empleado *Lista;

/* Prototipos de funciones definidas en listas.c */
extern Lista InsertarEmp(Lista , EMPLEADO *);
extern Lista EliminarEmp(Lista , int );
extern void Consultar (Lista);


/* Prototipos de funciones definidas en menu.c */
extern char getOption(void);
extern void Menu(void);
extern void getEnter(void);
