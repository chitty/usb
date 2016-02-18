/*
 * Archivo: Quicksort.java
 *
 * Descripcion: implementacion del algoritmo de ordenamiento
 *              quicksort sobre un arreglo de enteros, haciendo uso de
 *              procedimientos
 *
 * Autor: Carlos Chitty    07-41896
 *      
 * Fecha 2 de Febredo del 2009
 */

class Quicksort {
 
  /*@ requires a != null; @*/
  /*@ ensures a.length == \old(a.length)
    @         &&
    @         (\forall int i ; 0 <= i && i < a.length
    @                        ; (\num_of int j ; 0 <= j && j < a.length ; a[i] == a[j])
    @                          ==
    @                          (\num_of int j ; 0 <= j && j < \old(a.length) ; a[i] == \old(a[j]))
    @         )
    @         &&
    @         (\forall int i ; low <= i && i < high ; a[i] <= a[i+1]);
    @*/
  /*@ measured_by high-low; @*/
  public static void quicksort(int[] a, int low, int high) {
     
    int pivote;

    if (low < high) {
      pivote=particion(a,low,high);
      quicksort(a,low,pivote-1);  
      quicksort(a,pivote+1,high);  
    }
    else {} // skip
  }

  /*@ requires a != null; @*/
  /*@ ensures (\forall int x ; \result<x && x<=der ; a[\result]<a[x])
    @      && (\forall int x ; izq<=x && x<\result ; a[x]<=a[\result])
    @      && (\forall int i ; 0 <= i && i < a.length
    @                        ; (\num_of int j ; 0 <= j && j < a.length ; a[i] == a[j])
    @                          ==
    @                          (\num_of int j ; 0 <= j && j < \old(a.length) ; a[i] == \old(a[j]))
    @         );
    @*/  
  public static int particion(int[] a, int izq, int der) {
     
    int pivot=a[der];
    int i=izq-1;

    /*@ loop_invariant izq<=j && j<=der 
      @      && (\forall int x ; izq<=x && x<=i ; a[x]<=pivot)
      @      && (\forall int x ; i<x && x<j ; pivot<a[x]);
      @*/
    /*@ decreases der-j; @*/
    for (int j=izq; j<der; j++) {
      if (a[j]<=pivot){
        i++;
        swap(a,i,j); 
      }else {} // skip
    }
    swap(a,i+1,der); 

    return i+1;
  }

  /*@ requires a != null; @*/
  /*@ ensures a[i] == \old(a[j]) && a[j] == \old(a[i]); @*/   
  public static void swap(int[] a, int i, int j) {

    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
  }

}
