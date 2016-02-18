/* Archivo listas.h
 * Contiene las definiciones utilizadas en la aplicacion EjemploLista
 */ 

#include <stdio.h>
#include <stdlib.h>


#define MAXNOMBRE 9999

struct List {
       char *Info;
       struct List *proximo;
};

typedef struct List URL;
typedef struct List *Lista;

/* Prototipos de funciones definidas en listas.c */
extern Lista Insertar(Lista , URL *);
extern void Consultar (Lista);

/* Prototipos de funciones definidas en listASDFFFFFFFFFFas.c */
URL leerLinea(FILE *ptr);
Lista archivoP( char *archivo );
