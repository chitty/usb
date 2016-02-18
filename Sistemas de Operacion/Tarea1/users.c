/* 
 * Archivo: users.c
 * Se encarga de leer la información del log y almacenarla
 * en la estructura de datos lista. También genera los datos
 * estadísticos de los usuarios y del uso de procesadores.
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <string.h>
#include "reportlog.h"

/* leerLinea
 * Lee una linea del archivo abierto y almacena la informacion
 * de manera apropiada en la estructura de datos Datos.
 * *ptr: apuntador de archivo a la linea a leer
 * retorna: una lista con la información leida de una linea
 */
DatosG leerLinea(FILE *ptr) {

  FILE *ifp=ptr;
  char *proc;
  char d;
  int num=0,i=0,dummy=0;
  int dia=0,mes=0,ano=0,h=0,min=0,seg=0;
  DatosG generales;

  generales.Usuario = (char*)malloc(sizeof(char)*dummy);
  // En caso de que falle malloc()
  if (generales.Usuario == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }
  // lee el usuario
  fscanf(ifp, "%s", generales.Usuario);
 
  generales.Aplicacion = (char*)malloc(sizeof(char)*dummy);
  // En caso de que falle malloc()
  if (generales.Aplicacion == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }
  // lee la aplicación
  fscanf(ifp, "%s", generales.Aplicacion);

  proc = (char*)malloc(sizeof(char)*dummy);
  // En caso de que falle malloc()
  if (proc == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }
  // lee el (los) procesador(es)
  fscanf(ifp, "%s", proc);

  // Solo se consideran los valores 0,1,2,4,8,16,32,64 y 128
  if ( (strcmp(proc,"0")==0) || (strcmp(proc,"1")==0) ||(strcmp(proc,"2")==0) ||(strcmp(proc,"4")==0) 
       || (strcmp(proc,"8")==0) || (strcmp(proc,"16")==0) || (strcmp(proc,"32")==0) ||(strcmp(proc,"64")==0) 
       || (strcmp(proc,"128")==0) )
    generales.Procesador=atoi(proc);

  // lee el tiempo de ejecución
  fscanf(ifp, "%s", proc);
  generales.Tiempo=atoi(proc);

  // lee la fecha
  fscanf(ifp, "%d/%d/%d", &mes,&dia,&ano);
  generales.Fecha[0] = dia;
  generales.Fecha[1] = mes;
  generales.Fecha[2] = ano;

  // lee la hora
  fscanf(ifp, "%d:%d:%d", &h,&min,&seg);
  generales.Hora[0] = h;
  generales.Hora[1] = min;
  generales.Hora[2] = seg;

  // en caso de haber basura...
  while( fscanf(ifp, "%c", &d) && d!='\n');

  return generales;
}

/* InsertU
 * Inserta un nuevo usuario a una lista
 * l: lista donde está almacenada la información ya leida
 * g: información que se va a agregar a la lista l 
 * retorna: una lista que resulta de insertar g en la lista l
 */
Lista InsertU(Lista l, DatosG * g)
{ 
  Lista Temp;
	
  Temp = malloc(sizeof(DatosG));
  // En caso de que falle malloc()
  if (Temp == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }

  Temp->Usuario = g->Usuario; 
  Temp->Aplicacion = g->Aplicacion;
  Temp->Procesador = g->Procesador;
  Temp->Tiempo = g->Tiempo;
  Temp->Fecha[0] = g->Fecha[0];
  Temp->Fecha[1] = g->Fecha[1];
  Temp->Fecha[2] = g->Fecha[2];
  Temp->Hora[0] = g->Hora[0];
  Temp->Hora[1] = g->Hora[1];
  Temp->Hora[2] = g->Hora[2];
  Temp -> proximo = l;
 
  return Temp;
}

/* countProc
 * Cuenta cuantas aplicaciones fueron ejecutadas en cada procesador
 * y luego imprime la información en el archivo de salida.
 * l: lista con los datos
 * *out: apuntador al archivo de salida
 */
void * countProc(Lista l, FILE *out){

  int proc[9]={0,0,0,0,0,0,0,0,0};

  if (l== NULL) { //NO HAY INFORMACION
  } else {
    while (l!= NULL) {

      if ( l->Procesador == 0 ){
        proc[0]++;
      }else if ( l->Procesador == 1 ){
        proc[1]++;
      }else if ( l->Procesador == 2 ){
        proc[2]++;
      }else if ( l->Procesador == 4 ){
        proc[3]++;
      }else if ( l->Procesador == 8 ){
        proc[4]++;
      }else if ( l->Procesador == 16 ){
        proc[5]++;
      }else if ( l->Procesador == 32 ){
        proc[6]++;
      }else if ( l->Procesador == 64 ){
        proc[7]++;
      }else if ( l->Procesador == 128 ){
        proc[8]++;
      }

      if (l->proximo != NULL ) {
        l= l-> proximo;
      } else {
        break; // no hay mas elementos en la lista
      }
    }
  }

  fprintf(out,"\nAplicaciones ejecutadas en:\n",proc[0]);
  fprintf(out,"  front end (0): %d\n",proc[0]);
  fprintf(out,"  1 procesador: %d\n",proc[1]);
  fprintf(out,"  2 procesadores: %d\n",proc[2]);
  fprintf(out,"  4 procesadores: %d\n",proc[3]);
  fprintf(out,"  8 procesadores: %d\n",proc[4]);
  fprintf(out,"  16 procesadores: %d\n",proc[5]);
  fprintf(out,"  32 procesadores: %d\n",proc[6]);
  fprintf(out,"  64 procesadores: %d\n",proc[7]);
  fprintf(out,"  128 procesadores: %d\n",proc[8]);
}

/* userApp
 * Cuenta el número de aplicaciones ejecutadas por cada usuario
 * luego determina el usuario que ejecutó más y guarda esta 
 * información en el archivo de salida
 * n: Cantidad de usuarios diferentes
 * usuarios: Lista de usuarios
 * l: Lista con toda la información
 * *out: apuntador al archivo de salida
 */
void userApp(int n, ListaS usuarios, Lista l, FILE *out){

  char *user[n];
  int apps[n];
  int max=0, i=0;
  Lista temp=l;

  // Sabemos la cantidad exacta de elementos en la lista
  for(i=0; i<n; i++){

    user[i]=usuarios->info;
    apps[i]=0;
    usuarios=usuarios->proximo;
  } 
   
  // guarda en apps la cantidad de applicaciones ejecutadas por cada usuario
  for(i=0; i<n; i++){

     while (temp!= NULL) {

      if ( strcmp(temp->Usuario, user[i]) == 0 )
        apps[i]++;
   
      // Siguiente elemento en la lista principal
      if (temp->proximo != NULL ){
      	temp= temp-> proximo;
      } else {
      	break;
      }
    } 
    temp = l; // volver al principio de la lista principal
  }

  // recuerda quien ejecuto el mayor numero de aplicaciones
  for(i=1; i<n; i++)
    if ( apps[i] > apps[i-1] )
      max = i;
 
  fprintf(out,"Usuario que ejecutó el mayor número de aplicaciones: %s\n",user[max]);

}


/* Insertar
 * inserta un elemento al inicio de la lista
 */
ListaS insertar(ListaS l, char *datos){

  ListaS Temp;
	
  Temp = malloc(sizeof(ListaS));
  // En caso de que falle malloc()
  if (Temp == NULL){
    printf("ERROR: La llamada al sisteme malloc() falló\n");
    exit(2);
  }
  Temp-> info = datos; 
  Temp -> proximo = l;

  return Temp;
}


/* Usuarios
 * Crea una lista de todos los usuarios diferentes y calcula el
 * total de usuarios diferentes, llama a userApp para calcular
 * cual usuario ejecutó el mayor número de aplicaciones
 * lista: lista donde está almacenada la información ya leida
 * *out: apuntador al archivo de salida
 */
void Usuarios(Lista lista, FILE *out){
  
  int ud=0; // Usuarios diferentes
  int esta=0;
  ListaS users=NULL, primero=NULL;
  Lista l = lista;

  // Recorre la lista principal
  while (l!= NULL) {

    esta=0;
    while (users!=NULL){

      if ( strcmp(l->Usuario, users->info) == 0 ){
        esta=1;
	// Volver al primer elemento, para la siguiente iteración
	users = primero;
	break;
      }else{
        // Siguiente elemento en la lista de usuarios
      	if (users->proximo != NULL ){
          users = users-> proximo;
      	} else {
	  users = primero;
          break;
      	} 	
      }
    }
    
    // Si el elemento NO esta, hay insertarlo
    if (esta==0){
      users = insertar(primero,l->Usuario);
      primero = users; // hay que recordar el 1er elemento
      ud++;
    }
    // Siguiente elemento en la lista principal
    if (l->proximo != NULL ){
      l= l-> proximo;
    } else {
      break;
    }
  }

  fprintf(out,"\t*******************\n\t* DATOS GENERALES *\n\t*******************\n\n");
  fprintf(out,"Total de usuarios diferentes: %d\n",ud);
  userApp(ud,users,lista,out);
}
