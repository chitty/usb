/* Archivo log.h
 * Contiene las definiciones utilizadas en la aplicacion reportlog
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <stdio.h>
#include <stdlib.h>

struct Datos {
    	char *Usuario;
	char *Aplicacion;
    	int Procesador;
	int Tiempo;
	int Fecha[3];
	char Hora[3];
        struct Datos *proximo;
};

struct String {
    	char *info;
        struct String *proximo;
};

typedef struct Datos DatosG;
typedef struct Datos *Lista;
typedef struct String *ListaS;

Lista InsertU(Lista l, DatosG * g);
void * countProc(Lista l, FILE *out);
DatosG leerLinea(FILE *ptr);
char *app(int n, ListaS aplicaciones, Lista l, FILE *out);
void userApp(int n, ListaS usuarios, Lista l, FILE *out);
ListaS insertar(ListaS l, char * datos);
int equals(char *dato1, char *dato2);
void Usuarios(Lista lista, FILE *salida);
void usuariosYproc(char *aplic,Lista l,FILE *out);
void Aplicaciones(int n, char *nombre[n], Lista lista, FILE *out);
void apliEx(int n, char *name, ListaS aplicaciones, Lista l, FILE *out);
