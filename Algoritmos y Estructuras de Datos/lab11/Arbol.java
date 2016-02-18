/*
 * Archivo: Arbol.java
 *
 * Descripci'on: implementaci'on del tipo concreto Arbol Binario de Busqueda.
 *               Los objetos almacenados en este arbol deben implementar la 
 *               interfaz JMLComparable.
 *               Para la especificaci'on de las operaciones se ha utilizado un
 *               campo modelo de tipo secuencia que representa el contenido del
 *               arbol.
 * 
 * Versi'on: 0.1.
 *
 * Autor: Gabriela Montoya.
 * 
 * Fecha: marzo, 2009.
 *
 */

package lab11;
//@ import org.jmlspecs.models.JMLValueSequence;
//@ import org.jmlspecs.models.JMLType;
import org.jmlspecs.models.JMLComparable;
import org.jmlspecs.models.JMLInteger;
import org.jmlspecs.models.JMLValueSequence;
import java.util.Iterator;

public class Arbol {

    /** Representacion abstracta del tipo Arbol */
    //@ public model JMLValueSequence seq;
    //@ represents seq <- deArbolASequence(elementos);

    private /*@ spec_public nullable @*/ Nodo elementos;

    /*@ invariant (\forall JMLType e ; seq.has(e) ; e instanceof JMLComparable) &&
      @           (\forall int i ; 0 <= i && i < seq.int_size() - 1  
      @                          ; ((JMLComparable) seq.itemAt(i)).compareTo(seq.itemAt(i+1)) <= 0 );
      @*/

    //@ ensures this.seq.int_size() == 0;
    public Arbol () {
	this.elementos = null;
    }

    /** Busca en el arbol el nodo cuyo campo informacion coincida con e, en caso
        de no encontrarlo retorna null. Esta coincidencia depende de la operacion
        compareTo. */
    /*@ ensures (\result == null && !(\exists JMLComparable ele ; this.seq.has(ele) ; ele.compareTo(e) == 0))
      @         ||
      @         (\result != null && this.seq.has(\result.informacion) && (\result.informacion.compareTo(e) == 0) &&
      @         (\forall int i ; 0 <= i && i < this.seq.indexOf((JMLComparable) \result.informacion) 
      @                        ; ((JMLComparable) this.seq.itemAt(i)).compareTo(e) < 0));
      @*/         
    private /*@ pure nullable @*/ Nodo buscarNodo (JMLComparable e) {

        Nodo n = this.elementos;

	if ( n != null ){

	  while ( n != null ){

            if ( e.compareTo(n.informacion) > 0 ){
		n = n.der;

	    }else if( e.compareTo(n.informacion) < 0 ){
		n = n.izq;
	    }else if( e.compareTo(n.informacion) == 0 ){
		return n;
	    }
	  }

	}

	return null;
    }

    /** Busca en el arbol el nodo padre del nodo n, en caso de que n no tenga padre
        retorna null. n debe estar en el arbol. */
    /*@ requires (* n forma parte del arbol referenciado por this.elementos *);
      @ ensures (\result == null && n.equals(this.elementos))
      @         ||
      @         (\result != null && (\result.izq.equals(n) || \result.der.equals(n)));
      @*/
    private /*@ nullable @*/ Nodo padre (Nodo n) {
	
        Nodo actual = this.elementos;
        Nodo padre = null;

	if ( actual != null ){

	  while ( actual != null ){

            if ( n.informacion.compareTo(actual.informacion) > 0 ){
		padre = actual;
		actual = actual.der;
	    }else if( n.informacion.compareTo(actual.informacion) < 0 ){
		padre = actual;
		actual = actual.izq;
	    }else if( n.informacion.compareTo(actual.informacion)  == 0 ){
		return padre;
	    }
          }

	}

	return null;
    }

    /** Busca en el arbol la informacion de nodo que coincida con e, en caso
        de no encontrarlo retorna null. Esta coincidencia depende de la operacion
        compareTo */
    /*@ ensures (\result == null && !(\exists JMLComparable ele ; this.seq.has(ele) ; ele.compareTo(e) == 0))
      @         ||
      @         (\result != null && this.seq.has(\result) && (\result.compareTo(e) == 0) &&
      @         (\forall int i ; 0 <= i &&  i < this.seq.indexOf((JMLComparable) \result) 
      @                        ; ((JMLComparable) this.seq.itemAt(i)).compareTo(e) < 0));
      @*/         
    public /*@ pure nullable @*/ JMLComparable buscar (JMLComparable e) {

        return null; // SUSTITUIR POR SU IMPLEMENTACI'ON
    }

    /** Inserta en el arbol el elemento e, en la posici'on apropiada de acuerdo
        a la relaci'on de orden dada por la operaci'on compareTo */
    /*@ ensures this.seq.int_size() == \old(this.seq.int_size()) + 1 && this.seq.has(e);
      @ ensures \old(this.seq).equals(this.seq.subsequence(0, this.seq.indexOf(e)).concat(
      @                       this.seq.subsequence(this.seq.indexOf(e)+1, this.seq.int_size())));
      @*/
    public void insertar (JMLComparable e) {

        Nodo n = this.elementos;
        Nodo anterior = null;

	if ( n != null ){

	  while ( n != null ){

            if ( e.compareTo(n.informacion) >= 0 ){
		anterior = n;
		n = n.der;

	    }else if( e.compareTo(n.informacion) < 0 ){
	        anterior = n;
		n = n.izq;
	    }
	  }

	  Nodo nuevo = new Nodo(e,null,null);
	  if ( e.compareTo(anterior.informacion) >= 0 ){
	     anterior.der = nuevo;

	  }else if( e.compareTo(anterior.informacion) < 0 ){
	     anterior.izq = nuevo;
	  }
	
	} else if (n == null){
	    Nodo nuevo = new Nodo(e,null,null);
	    this.elementos = nuevo;
	}
    }

    /** Elimina el nodo cuyo campo informacion coincide con e */
    //@ ensures this.seq.equals(\old(this.seq.removeItemAt(this.seq.indexOf(e))));
    public void eliminar (JMLComparable e) {

        // COMPLETAR
    }

    /** Devuelve un Iterator sobre los elementos del arbol */
    /*@ ensures (\forall int i; 0 <= i && i < this.seq.int_size() 
      @                       ; \result.nthNextElement(i).equals(this.seq.get(i)));
      @*/
    public Iterator iterator() {

        return null; // SUSTITUIR POR SU IMPLEMENTACI'ON
    }

    /*@ ensures ((l == null) && (\result.int_size() == 0)) 
      @       || (l != null && \result.equals(deArbolASequence(l.izq).concat(
      @           deArbolASequence(l.der).insertFront(l.informacion))));
      @*/
    public static /*@ pure @*/ JMLValueSequence deArbolASequence (
                    final Nodo l) {

        JMLValueSequence seq = new JMLValueSequence();

        if (l != null) {
            if (l.izq != null) {
                 seq = deArbolASequence(l.izq);
            }
            seq = seq.insertBack(l.informacion);
            if (l.der != null) {
                 seq = seq.concat(deArbolASequence(l.der));
            }
        }

        return seq;
    }

    private class Nodo {

        private /*@ spec_public @*/ JMLComparable informacion;
        private /*@ spec_public nullable @*/ Nodo izq, der;

        /*@ ensures this.informacion.equals(i) 
          @      && ((this.izq == null && iz == null) || (this.izq.equals(iz))) 
          @      && ((this.der == null && de == null) || (this.izq.equals(de)));
          @*/
        public Nodo (JMLComparable i, Nodo iz, Nodo de) {

            this.informacion = i;
            this.izq = iz;
            this.der = de;
        }

        /** Devuelve el mayor Nodo que se encuentra a partir de this */
        /*@ ensures \result.equals(deArbolASequence(this).last()); @*/
        private Nodo mayor () {
	    
            if (this == null){
		return null;
	    }else if (this != null){
		
	    }
	    return null;
        }

        /** Devuelve el menor Nodo que se encuentra a partir de this */
        /*@ ensures \result.equals(deArbolASequence(this).first()); @*/
        private /*@ spec_public pure @*/ Nodo menor () {

            return null; // SUSTITUIR POR SU IMPLEMENTACI'ON
        }
	
    }

    private class IteradorArbol implements Iterator {
         //@ represents moreElements <- hasNext();
        private /*@ spec_public @*/ Pila anteriores;
        private /*@ spec_public nullable @*/ Nodo actual;
        
        /*@ ensures this.actual == elementos.menor() &&
          @         (* se han empilado en this.anteriores los nodos desde la raiz de elementos hasta
          @            el nodo padre de this.actual *);
          @*/
        public IteradorArbol () {

            // COMPLETAR

        }

         //@ also ensures \result <==> (this.anteriores.tamano() > 0 || this.actual != null);
        public /*@ pure @*/ boolean hasNext() {

            return true; // SUSTITUIR POR SU IMPLEMENTACI'ON
        }

         /*@ also 
           @ requires this.hasNext();
           @ assignable this.actual, this.anteriores;
           @ ensures \result == \old(this.actual.informacion) 
           @      && (* this.actual referencia al elemento siguiente luego de \result *)
           @      && (* si el nodo actual tenia elementos mayores a si mismo, se
           @            han almacenado en this.anteriores todos los nodos intermedios
           @            entre this.actual y el elemento siguiente *)
           @      && (* si el nodo actual no tiene elementos mayores a si mismo, se
           @            desempila un elemento de this.anteriores *);
           @*/
        public Object next() {

            return null; // SUSTITUIR POR SU IMPLEMENTACI'ON
        }
    }
/*
    public static void main (String args[]) {

         // INCLUIR UN PROGRAMA DE PRUEBA QUE PERMITA PROBAR LAS OPERACIONES DE ESTE TIPO
	Arbol arbolito = new Arbol();
	arbolito.insertar(new JMLInteger(22));
	arbolito.insertar(new JMLInteger(4));
	arbolito.insertar(new JMLInteger(33));
	
    }
*/
}
