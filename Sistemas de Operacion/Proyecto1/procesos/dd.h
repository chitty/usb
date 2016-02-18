/* Archivo log.h
 * Contiene las definiciones utilizadas en la aplicacion Disk Doctor
 *
 * Autor: Carlos J. Chitty 07-41896
 */

void menu();
void mostrar();
void MostrarParticion(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
void MostrarBloques(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
void  Imprimir(unsigned short  n_inodos, tiny_inodeM *Inom);
void Consistencia(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano, int k);
void comparar(char *archivo, int N);
void Compactar(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
void Formatear(char *archivo, unsigned short n_inodos, unsigned short nbloques, int tamano);
