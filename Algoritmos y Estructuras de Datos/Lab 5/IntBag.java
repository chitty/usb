/*
 * Archivo: IntBag.java
 *
 * Descripcion: clase que implementa un tipo de datos multiconjunto de enteros. 
 *               Para el modelo concreto de representaci'on utiliza dos arreglos: 
 *               el primero contiene los elementos distintos del multiconjunto y 
 *               el segundo contiene las cantidades de ocurrencias de los 
 *               elementos.
 *
 * Fecha: 9 de febrero 2009
 *
 * Autor: Carlos Chitty 07-41896
 *
 */

//@ import org.jmlspecs.models.JMLInteger;
//@ import org.jmlspecs.models.JMLValueBag;

import corejava.*;

public class IntBag implements IntBagInterface {

    private /*@ spec_public @*/ int[] elems;
    private /*@ spec_public @*/ int[] ocurrencias;
    private /*@ spec_public @*/ int cant;      // cantidad de elementos distintos
    private /*@ spec_public @*/ int tam;       // cantidad de elementos
    private /*@ spec_public @*/ final int Max; // cantidad maxima de elementos

    /*@ invariant 0 <= this.tam && this.tam <= this.Max && 
      @           (this.tam == (\sum int i ; 0 <= i && i < this.cant ; this.ocurrencias[i])) &&
      @           (\forall int i ; 0 <= i && i < this.cant ; this.ocurrencias[i] > 0) &&
      @           (\forall int i ; 0 <= i && i < this.cant 
      @                          ; (\forall int j ; i < j && j < this.cant
      @                                           ; this.elems[i] != this.elems[j])) &&
      @           this.elems.length == this.Max && this.ocurrencias.length == this.Max;
      @*/

    /*@ represents multiconjunto <- JMLValueBag.convertFrom(
      @            intAToJMLIntegerA(this.elems, this.ocurrencias, this.cant, this.tam)); 
      @*/

    /*@
      @ requires m > 0;
      @ ensures this.cant == 0 && this.Max == m;
      @*/
    public IntBag(int m) {
	    
        this.elems = new int[m];
        this.ocurrencias = new int[m];
        this.Max = m;
        this.tam = 0;
        this.cant = 0;

        //@ set MAX = this.Max;
    }

    /*@ 
      @ also 
      @ requires this.tam < this.Max;
      @ ensures this.cant == \old(this.cant) + (\old(this.isIn(x)) ? 0 : 1);
      @ ensures (\forall int i 
      @             ; 0 <= i && i < this.cant && this.elems[i] != x
      @             ; (\exists int j 
      @                    ; 0 <= j && j < \old(this.cant) 
      @                    ;   this.elems[i] == \old(this.elems[j]) 
      @                     && this.ocurrencias[i] == \old(this.ocurrencias[j])
      @               )
      @         ) &&
      @         (\forall int i 
      @             ; 0 <= i && i < \old(this.cant) && \old(this.elems[i]) != x
      @             ; (\exists int j 
      @                    ; 0 <= j && j < this.cant 
      @                    ;   \old(this.elems[i]) == this.elems[j] 
      @                     && \old(this.ocurrencias[i]) == this.ocurrencias[j]
      @               )
      @         );
      @ ensures this.count(x) == \old(this.count(x)) + 1;
      @ ensures this.tam == \old(this.tam) + 1;
      @*/
    public void insert (int x) {

       if( isIn(x) ){

         /*@ loop_invariant 0<=i && i<=this.cant;  @*/
         //@ decreases this.cant-i;
         for(int i=0; i<this.cant; i++){

           if( elems[i] == x ){
             this.ocurrencias[i]++;
           }
           else {} //skip
         }

       }
       else {
         this.elems[this.cant] = x;
         this.ocurrencias[this.cant] = 1; 
         this.cant++;
       }
       this.tam++;
    }

    /*@ 
      @ also
      @ requires !this.isIn(x);
      @ assignable \nothing;
      @ also
      @ requires this.isIn(x);
      @ ensures this.tam == \old(this.tam) - 1;
      @ ensures \old(this.count(x)) - 1 == this.count(x);
      @ ensures (\forall int i 
      @             ; 0 <= i && i < this.cant && this.elems[i] != x
      @             ; (\exists int j 
      @                    ; 0 <= j && j < \old(this.cant) 
      @                    ;   this.elems[i] == \old(this.elems[j]) 
      @                     && this.ocurrencias[i] == \old(this.ocurrencias[j])
      @               )
      @         ) &&
      @         (\forall int i 
      @             ; 0 <= i && i < \old(this.cant) && \old(this.elems[i]) != x
      @             ; (\exists int j 
      @                    ; 0 <= j && j < this.cant 
      @                    ;   \old(this.elems[i]) == this.elems[j] 
      @                     && \old(this.ocurrencias[i]) == this.ocurrencias[j]
      @               )
      @         );
      @*/
    public void remove (int x) {

        if ( isIn(x) ) {
            /*@
              @ loop_invariant 
              @   0 <= i && i <= this.cant 
              @   && 
              @   (i == this.cant 
              @       ? (\forall int k 
              @              ; 0 <= k && k < this.cant && this.elems[k] != x
              @              ; (\exists int l 
              @                     ; 0 <= l && l < \old(this.cant) 
              @                     ;   this.elems[k] == \old(this.elems[l]) 
              @                      && this.ocurrencias[k] == \old(this.ocurrencias[l])
              @                )
              @         ) &&
              @         (\forall int k 
              @              ; 0 <= k && k < \old(this.cant) && \old(this.elems[k]) != x
              @              ; (\exists int l 
              @                     ; 0 <= l && l < this.cant 
              @                     ;   \old(this.elems[k]) == this.elems[l] 
              @                      && \old(this.ocurrencias[k]) == this.ocurrencias[l]
              @                )
              @         ) && \old(this.count(x)) - 1 == this.count(x)
              @       : (\forall int k 
              @              ; 0 <= k && k < i
              @              ; (\exists int l 
              @                     ; 0 <= l && l < i 
              @                     ;   this.elems[k] == \old(this.elems[l]) 
              @                      && this.ocurrencias[k] == \old(this.ocurrencias[l])
              @                )
              @         ) &&
              @         (\forall int k 
              @              ; 0 <= k && k < i
              @              ; (\exists int l 
              @                     ; 0 <= l && l < i
              @                     ;   \old(this.elems[k]) == this.elems[l] 
              @                      && \old(this.ocurrencias[k]) == this.ocurrencias[l]
              @                )
              @         ) && \old(this.count(x)) == this.count(x)
              @   );
              @ decreasing this.cant - i;
              @*/
            for(int i=0; i<this.cant; i++){

              if( this.elems[i] == x && ocurrencias[i] == 1 ){
                this.cant--;
                this.elems[i] = elems[this.cant];
                this.ocurrencias[i] = ocurrencias[this.cant];
                break;
              }
              else if( this.elems[i] == x && ocurrencias[i] > 1 ){
                this.ocurrencias[i]--; 
                break;     
              }
              else { continue; 
              } //skip

            }
            this.tam--;
        }
    }

    /*@
      @ also
      @ ensures \result <==> (\exists int i ; 0 <= i && i < this.cant ; this.elems[i] == x);
      @*/
    public /*@ pure @*/ boolean isIn (int x) {

        boolean esta = false;
    
       /*@ loop_invariant 0 <= i && i <= this.cant &&
         @ esta <==> (\exists int j ; 0 <= j && j < i ; this.elems[j] == x);
         @*/
        for(int i=0; i<this.cant; i++){
          if( this.elems[i] == x ){
            esta = true;
          }
          else {} //skip
        }
 
        return esta;
    }
   
    /*@
      @ also
      @ ensures 
      @    ((\exists int j ; 0 <= j && j < this.cant ; this.elems[j] == x) 
      @       ? (\forall int j ; 0 <= j && j < this.cant && this.elems[j] == x
      @                        ; \result == this.ocurrencias[j]) 
      @       : \result == 0);
      @*/
    public /*@ pure @*/ int count (int x) {

        int ocs = 0;

        /*@ loop_invariant 
          @    0 <= i && i <= this.cant
          @    &&
          @    ((\exists int j ; 0 <= j && j < i ; this.elems[j] == x) 
          @       ? (\forall int j ; 0 <= j && j < i && this.elems[j] == x
          @                        ; ocs == this.ocurrencias[j]) 
          @       : ocs == 0);
          @
          @ decreasing this.cant - i;
          @*/
        for (int i=0; i<this.cant ; i++){
          if (this.elems[i] == x){
            ocs = this.ocurrencias[i];
          }
          else {} //skip
        }

        return ocs;
    }

    /*@ also
      @  ensures \result == this.tam;
      @*/
    public /*@ pure @*/ int size () {
    
        return this.tam;
    }

    /*@
      @ requires es.length <= N && ocurrs.length <= N &&
      @          (\forall int i ; 0 <= i && i < cant ; ocurrs[i] > 0) &&
      @          N == (\sum int i ; 0 <= i && i < cant ; ocurrs[i]);
      @ ensures 
      @  (\forall int i 
      @    ; 0 <= i && i < cant
      @    ; (\forall int j 
      @        ; 0 <= j && j < ocurrs[i] 
      @        ; es[i] == \result[(\sum int k ; 0 <= k && k < i ; ocurrs[k])+j].intValue()
      @      )
      @  );
      @*/
    private static /*@ spec_public pure @*/ JMLInteger[] intAToJMLIntegerA(
            int[] es, int[] ocurrs, int cant, int N) {

        JMLInteger[] arregloJI = new JMLInteger[N];
        int acum = 0;

        /*@ loop_invariant 
          @    0 <= i && i <= cant 
          @    &&
          @    acum == (\sum int k ; 0 <= k && k < i ; ocurrs[k])
          @    &&
          @    (\forall int l 
          @       ; 0 <= l && l < i
          @       ; (\forall int m 
          @            ; 0 <= m && m < ocurrs[l]
          @            ; es[l] == arregloJI[(\sum int k ; 0 <= k && k < l 
          @                                           ; ocurrs[k])+m].intValue()
          @         )
          @    );
          @ decreasing cant - i; 
          @*/
        for (int i = 0; i < cant; i++) {

            /*@ loop_invariant
              @     0 <= j && j <= ocurrs[i]
              @     &&
              @     (\forall int l ; 0 <= l && l < j ; es[i] == arregloJI[acum+l].intValue());
              @*/
            for (int j = 0 ; j < ocurrs[i] ; j++) {
                arregloJI[acum + j] = new JMLInteger(es[i]);
            }
            acum = acum + ocurrs[i];
        }
        return arregloJI;
    }  

    public static void main (String args[]) {

      // INCLUIR UN PROGRAMA DE PRUEBA QUE UTILICE TODAS LAS OPERACIONES DEL TAD
      int N = Console.readInt("Ingrese tamano del multiconjunto: ");
      IntBag a = new IntBag(N);
      int dummy;  

      /*@ loop_invariant 0<=k && k<=N; @*/ 
      /*@ decreases N-k; @*/
      for(int k=0; k<N; k++) {
        a.insert( Console.readInt("elemento "+k+":") );
      }

      System.out.println("\nTamaño del multiconjunto: "+a.size()+"  ");
      dummy = Console.readInt("\nIngrese un elemento para contar sus ocurrencias");
      System.out.println("ocurrencias de "+dummy+": "+a.count(dummy) ); 
      
      dummy = Console.readInt("\nIngrese un elemento para eliminarlo: ");
      a.remove(dummy);

      dummy = Console.readInt("\nIngrese un elemento para saber si esta en el multiconjunto: ");
      if ( a.isIn(dummy) ){
        System.out.println("El elemento "+dummy+" SI esta en el multiconjunto!"); 
        System.out.println("ocurrencias de "+dummy+": "+a.count(dummy) );
      } 
      else{
        System.out.println("El elemento "+dummy+" NO esta en el multiconjunto!"); 
      } 

      System.out.println("\nTamaño del multiconjunto: "+a.size()+"  ");
    }
}
