/* 
 * Archivo: apps.c
 * Se encarga de los calculos para las diferentes 
 * aplicaciones ejecutadas y los datos específicos
 * de cada usuario.
 *
 * Autor: Carlos J. Chitty 07-41896
 */

#include <string.h>
#include "reportlog.h"

/* app
 * Cuenta el número de veces que cada aplicacion es ejecutada,
 * luego determina la aplicación que se ejecutó más veces y  
 * guarda esta información en el archivo de salida
 * n: Cantidad de aplicaciones diferentes
 * aplicaciones: Lista de aplicaciones
 * l: Lista con toda la información
 * *out: apuntador al archivo de salida
 * retorna: la aplicación que se ejecutó más veces
 */
char *app(int n, ListaS aplicaciones, Lista l, FILE *out){

  char *ap[n];
  int num[n], primerDia[3], ultimoDia[3], p[3], u[3]; 
  int max=0, i=0, fin=0,inicio=0,f=0,in=0,t=0;
  Lista temp=l;

  /* Almacena la informacion del ultimo dia (ya que los elementos 
   * en la lista estan en el orden contrario al archivo leido)
   */
  ultimoDia[0] = temp->Fecha[0];
  ultimoDia[1] = temp->Fecha[1];
  ultimoDia[2] = temp->Fecha[2];
  u[0] = temp->Hora[0];
  u[1] = temp->Hora[1];
  u[2] = temp->Hora[2];

  // Sabemos la cantidad exacta de elementos en la lista
  for(i=0; i<n; i++){

    ap[i]=aplicaciones->info;
    num[i]=0;
    aplicaciones=aplicaciones->proximo;
  } 
   
  // guarda en num la cantidad de veces que se ejecutó cada apĺicación
  for(i=0; i<n; i++){

     while (temp!= NULL) {

      if ( strcmp(temp->Aplicacion, ap[i]) == 0 )
        num[i]++;
   
      // Siguiente elemento en la lista principal
      if (temp->proximo != NULL ){
      	temp= temp-> proximo;
      } else {
  	primerDia[0] = temp->Fecha[0];
  	primerDia[1] = temp->Fecha[1];
  	primerDia[2] = temp->Fecha[2];
        p[0] = temp->Hora[0];
        p[1] = temp->Hora[1];
        p[2] = temp->Hora[2];
      	break;
      }
    } 
    temp = l; // volver al principio de la lista principal
  }

  // recuerda que aplicación se ejecutó más veces
  for(i=1; i<n; i++)
    if ( num[i] > num[i-1] )
      max = i;

  // pone la información en terminos de días
  inicio = primerDia[2]*365 + primerDia[1]*30 + primerDia[0];
  fin = ultimoDia[2]*365 + ultimoDia[1]*30 + ultimoDia[0];
  // pone la información en terminos de segundos
  in = p[2] + p[1]*60 + p[0]*3600;
  f = u[2] + u[1]*60 + u[0]*3600;
  
  /* Si la hora en la que terminó es menor a la hora en que
   * inició entonces no se cumplió un día completo
   */
  if(f<in){
    f+=3600*24;
    fin--;
  }
  
  t = (f-in)/3600;

  fprintf(out,"\nInicio del log:\t %2d/%2d/%d",primerDia[0],primerDia[1],primerDia[2]);
  fprintf(out," %.2d:%.2d:%.2d",p[0],p[1],p[2]);
  fprintf(out,"\nFin del log:\t %2d/%2d/%d",ultimoDia[0],ultimoDia[1],ultimoDia[2]);
  fprintf(out," %.2d:%.2d:%.2d\n\n",u[0],u[1],u[2]);
  fprintf(out,"Duración del período de medición: %d días y %d horas\n",(fin-inicio),t);


  

  return ap[max];
}

/* Aplicaciones
 * Crea una lista de todas las aplicaciones diferentes y calcula el
 * total de aplicaciones diferentes ejecutadas, llama a app para 
 * calcular cual aplicación se ejecutó el mayor número de veces.
 * También calcula datos específicos de los usuarios dados
 * n: número de usuarios de los que se desea información específica
 * nombre[n]: usuarios de los que se desea información específica
 * lista: lista donde está almacenada la información ya leida
 * *out: apuntador al archivo de salida
 */
void Aplicaciones(int n, char *nombre[n], Lista lista, FILE *out){
  
  int ad=0; // Aplicaciones diferentes
  int esta=0,i=0;
  char *aplicacion;
  ListaS apps=NULL, primero=NULL;
  Lista l = lista;

  // Recorre la lista principal
  while (l!= NULL) {

    esta=0;

    while (apps!=NULL){

      if ( strcmp(l->Aplicacion, apps->info) == 0 ){
        esta=1;
	// Volver al primer elemento, para la siguiente iteracion
	apps = primero;
	break;
      }else{
        // Siguiente elemento en la lista de aplicaciones
      	if (apps->proximo != NULL ){
          apps = apps-> proximo;
      	} else {
	  apps = primero;
          break;
      	} 	
      }
    }
    
    // Si el elemento NO esta, hay insertarlo
    if (esta==0){
      apps = insertar(primero,l->Aplicacion);
      primero = apps; // hay que recordar el 1er elemento
      ad++;
    }
    // Siguiente elemento en la lista principal
    if (l->proximo != NULL ){
      l= l-> proximo;
    } else {
      break;
    }
  }

  fprintf(out,"\nTotal de aplicaciones diferentes ejecutadas: %d\n",ad);
  aplicacion=app(ad,apps,lista,out);
  usuariosYproc(aplicacion,lista,out);

  fprintf(out,"\n\n\t*********************\n\t* DATOS ESPECIFICOS *\n\t*********************\n\n");
  fprintf(out,"Usuario:\tApp:\tTiempoM:\n");
  for (i=0; i<n; i++)
    apliEx(ad,nombre[i],primero,lista,out);

}

/* apliEx
 * Calcula las estadísticas específicas de los usuarios dados
 * y las almacena en el archivo de salida.
 * n: número de usuarios de los que se desea información específica
 * nombre[n]: usuarios de los que se desea información específica
 * aplicaciones: lista de aplicaciones diferentes
 * l: lista donde está almacenada la información ya leida
 * *out: apuntador al archivo de salida
 */
void apliEx(int n, char *name, ListaS aplicaciones, Lista l, FILE *out){

  char *ap[n]; // Aplicaciones
  int ejecutadas[n]; 
  float tiempoM[n];
  int veces[n];
  int max=0, i=0;
  Lista temp=l;

  // Sabemos la cantidad exacta de elementos en la lista
  for(i=0; i<n; i++){

    ap[i]=aplicaciones->info;
    ejecutadas[i]=0; // inicialización (ninguna ejecutada)
    tiempoM[i]=0;
    veces[i]=0;
    aplicaciones=aplicaciones->proximo;
  }
  
  // recorre la lista principal  
  while (temp!= NULL) {

    // Cada vez que aparezca el Usuario 'name' en la lista...
    if ( strcmp(temp->Usuario, name) == 0 ){

      // ver que aplicación ejecutó el usuario
      for(i=0; i<n; i++){

	if ( strcmp(temp->Aplicacion, ap[i]) == 0 ){
	  ejecutadas[i]++;
	  veces[i]++;
          // calcula el tiempo medio de ejecución
	  tiempoM[i] = (tiempoM[i]*(veces[i]-1) + temp->Tiempo)/veces[i];

	  // se acuerda de cual fue la aplicación más larga
	  if( (temp->Tiempo) > max )
	    max = i;	  
        }
      }
    }
    // Siguiente elemento en la lista principal
    if (temp->proximo != NULL ){
      temp= temp-> proximo;
    } else {
      break;
    }
  } 

  fprintf(out,"\n%s\n",name);

  for(i=0; i<n; i++)
    if (ejecutadas[i] != 0)
      fprintf(out,"\t\t%s\t%f\n",ap[i],tiempoM[i]);

  fprintf(out,"\nLa aplicación más larga de %s fué: %s\n\n",name,ap[max]);
}

/* usuariosYpro
 * Calcula en que procesador y por que usuario(s) fue ejecutada la 
 * aplicación que mayor número de veces aparere en el archivo de
 * entrada
 * aplic: aplicación que se ejecutó más veces en el período dado
 * l: lista donde está almacenada la información ya leida
 * *out: apuntador al archivo de salida
 */
void usuariosYproc(char *aplic,Lista l,FILE *out){

  Lista temp=l;
  ListaS usuarios=NULL,primero=NULL;
  int procesador=0, esta=0;

  // recorre la lista principal  
  while (temp!= NULL) {

    if ( strcmp(temp->Aplicacion, aplic)==0 ){

      procesador = temp->Procesador;
      esta=0;
      while (usuarios!=NULL){

        if ( strcmp(temp->Usuario, usuarios->info) == 0 ){
          esta=1;
	  // Volver al primer elemento, para la siguiente iteración
	  usuarios = primero;
	  break;
        }else{
          // Siguiente elemento en la lista de usuarios
      	  if (usuarios->proximo != NULL ){
            usuarios = usuarios-> proximo;
      	  } else {
	    usuarios = primero;
            break;
      	  } 	
        }
      }

      // Si el elemento NO esta, hay insertarlo
      if (esta==0){
        usuarios = insertar(primero,temp->Usuario);
        primero = usuarios; // hay que recordar el 1er elemento
      }
    }

      // Siguiente elemento en la lista principal
      if (temp->proximo != NULL ){
        temp= temp-> proximo;
      } else {
        break;
      }
  }


  fprintf(out,"\nAplicación que se ejecutó el mayor número de veces:\n");
  fprintf(out,"  %s en ",aplic);
  
  if (procesador == 0)
    fprintf(out,"el front end (0)",procesador);
  else if (procesador == 1)
    fprintf(out,"%d procesador",procesador);
  else 
    fprintf(out,"%d procesadores",procesador);

  fprintf(out," por: ");

  // imprime los usuarios
  while (usuarios!=NULL){

    fprintf(out," %s ",usuarios->info);
    // Siguiente elemento en la lista de usuarios
    if (usuarios->proximo != NULL )
      usuarios = usuarios-> proximo;
    else
      break;	
  }
}
