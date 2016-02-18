/* Archivo log.h
 * Contiene las definiciones utilizadas en la aplicacion Disk Doctor
 *
 * Autor: Carlos J. Chitty 07-41896
 */

struct thread_data{
   char *archivo;
   unsigned short  n_inodos;
   unsigned short  nbloques;
   int  tamano;
};

struct thread_data1{
   char *archivo;
   unsigned short  n_inodos;
   unsigned short  nbloques;
   int  tamano,k;
};

void menu();
void mostrar();
void MostrarParticion(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
void MostrarBloques(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
void  Imprimir(unsigned short  n_inodos, tiny_inodeM *Inom);
void *Consistencia(void *threadarg);
void comparar(char *archivo, int N);
void *Compactar(void *threadarg);
void *Formatear(void *threadarg);
