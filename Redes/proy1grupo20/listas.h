/* Archivo listas.h
 * Contiene las definiciones utilizadas en listas.c
 */ 

#include <stdio.h>
#include <stdlib.h>

#define MAXURL 9999

struct List {
       char *Info;
       struct List *proximo;
};

typedef struct List URL;
typedef struct List *Lista;

/* Prototipos de funciones definidas en listas.c */
extern Lista Insertar(Lista , URL *);
