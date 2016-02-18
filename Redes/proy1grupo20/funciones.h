/* Archivo funciones.h
 *   Prototipos de funciones definidas en funciones.c
 */ 

#include <stdio.h>
#include <stdlib.h>
#include "listas.h"

URL leerLinea(FILE *ptr);
Lista archivoP( char *archivo );
char* getServerIP(int fd, Lista forbid, FILE *log);
int port(char *puertoS);
void URLprohibida(char *url,char *MAINurl,int msg);
