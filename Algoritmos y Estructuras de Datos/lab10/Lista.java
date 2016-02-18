/*
 * Archivo: Lista.java
 *
 * Descripcion: implementacion del tipo concreto Lista enlazada simple.
 *              Los objetos almacenados en esta lista estan ordenados, para ello
 *              deben implementar la interfaz JMLComparable.
 *              Para la especificacion de las operaciones se ha utilizado un
 *              campo modelo de tipo secuencia que representa el contenido de
 *              la lista.
 * 
 * Version: 0.1.1
 *
 * Autor: Carlos Chitty
 * 
 * Fecha: marzo, 2009.
 *
 */
package lab10;
//@ import org.jmlspecs.models.JMLValueSequence;
//@ import org.jmlspecs.models.JMLType;
import org.jmlspecs.models.JMLComparable;
import org.jmlspecs.models.JMLInteger;
import java.util.Iterator;
import corejava.*;

public class Lista {

    //@ public model JMLValueSequence seq;

    //@ represents seq <- deListaASequence(elementos);

    private /*@ spec_public nullable @*/ Nodo elementos; // apuntador al primer nodo

    /*@ invariant (\forall JMLType e ; seq.has(e) ; e instanceof JMLComparable) &&
      @           (\forall int i ; 0 <= i && i < seq.int_size() - 1 
      @                          ; ((JMLComparable) seq.itemAt(i)).compareTo(seq.itemAt(i+1)) <= 0 );
      @*/

    //@ ensures this.seq.int_size() == 0;
    public Lista() {
	this.elementos = null;
    }

    /*@ ensures (\result == null && !(\exists JMLComparable ele ; seq.has(ele) ; ele.compareTo(e) == 0))
      @         ||
      @         (\result != null && 
      @          (\forall int i ; 0 <= i && i < seq.indexOf((JMLComparable)\result) 
      @                         ; ((JMLComparable)seq.itemAt(i)).compareTo(e) < 0) && 
      @          seq.has(\result) && \result.compareTo(e) == 0 );
      @*/         
    public /*@ pure nullable @*/ JMLComparable buscar (JMLComparable e) {

        return null; // SUSTITUIR POR SU IMPLEMENTACI'ON
    }

    /*@ ensures seq.int_size() == \old(seq.int_size()) + 1 && seq.has(e);
      @ ensures \old(seq).equals(seq.subsequence(0, seq.indexOf(e)).
      @              concat(seq.subsequence(seq.indexOf(e)+1, seq.int_size())));
      @*/
    public void insertar(JMLComparable e) {

        Nodo anterior = null;
	Nodo n = this.elementos;
	
	if (this.elementos == null) {  // insertar en lista vacia
	    this.elementos = new Nodo(e,null);
	} else if ( this.elementos != null && this.elementos.siguiente != null ){

	    while ( n.informacion.compareTo(e) < 0 && n.siguiente != null ){
		anterior = n;
		n = n.siguiente;
	    }

            Nodo aux;
	    aux = new Nodo(e,null);

	    if (n.siguiente != null || n.informacion.compareTo(e) >= 0 ){
	    	aux.siguiente = n;
	        if ( anterior != null ){ // insertar en el medio
		    anterior.siguiente = aux;
		} else { // insertar el principio
                   this.elementos = aux;
	        }
	    }else { // insertar al final
		n.siguiente = aux;
	    }

	// cuando hay un solo elemento en la lista
	} else if ( this.elementos != null && this.elementos.siguiente == null ){ 
            if ( n.informacion.compareTo(e) < 0 ){
		Nodo aux;
	    	aux = new Nodo(e,null);
		n.siguiente = aux;
	    } else {
		Nodo aux;
	    	aux = new Nodo(e,this.elementos);
		this.elementos = aux;	   
	    }
        }	
    }
    
    //@ ensures seq.equals(\old(seq.removeItemAt(seq.indexOf(e))));
    public void eliminar(JMLComparable e) {

	if ( this.elementos != null ){

            Nodo anterior = null;
	    Nodo n = this.elementos;

	    if (this.elementos.siguiente == null && this.elementos.informacion.equals(e)){
		this.elementos = null; // hay un unico elemento, y este es eliminado

	    }else if(this.elementos.siguiente == null && !this.elementos.informacion.equals(e)){
		// el elemento a ser eliminado NO esta en la lista

	    }else { // hay al menos 2 elementos en la lista
		while (n.siguiente != null && !n.informacion.equals(e) ){
		    anterior = n;
		    n = n.siguiente;
		}

		if(n.informacion.equals(e)){ // elemento a eliminar esta en la lista

		    if (anterior == null){ // elemento a eliminar esta de 1ro
			this.elementos = this.elementos.siguiente;

		    }else{
			anterior.siguiente = n.siguiente;
		    }		    
		}else{
		    // el elemento a ser eliminado NO esta en la lista
		}
	    }

	 } else {} // skip, lista vacia

    }

    /* ensures (\forall int i; 0 <= i && i < seq.int_size() 
                             ; \result.nthNextElement(i).equals(seq.get(i)));
      */
    public Iterator iterator() {
	IteradorLista i = new IteradorLista();
        return i;
    }

    /*@ ensures ((l == null) && (\result.int_size() == 0)) 
      @      || (l != null && \result.first().equals(l.informacion) 
      @           && \result.trailer().equals(deListaASequence(l.siguiente)));
      @*/
    public static /*@ pure @*/ JMLValueSequence deListaASequence (
                    final Nodo l) {

        JMLValueSequence seq = new JMLValueSequence();
        Nodo aux = l;

        while (aux != null) {

            JMLComparable o = (JMLComparable) aux.informacion;
            aux = aux.siguiente;
            seq = seq.insertBack(o);
        }
        return seq;
    }

    private class Nodo {

        private /*@ spec_public @*/ JMLComparable informacion;
        private /*@ spec_public @*/ Nodo siguiente;

        /*@ ensures this.informacion.equals(i) && 
          @         ((this.siguiente == null && s == null) || (this.siguiente.equals(s))); 
          @*/
        public Nodo (JMLComparable i, Nodo s) {

            informacion = i;
            siguiente = s;
        }
    }

    private class IteradorLista implements Iterator {

         //@ represents moreElements <- hasNext();
        private /*@ spec_public @*/ Nodo actual;

        //@ ensures this.actual == elementos;
        public /*@ pure @*/ IteradorLista() {

             actual = elementos;
         }

         /*@ also 
           @ ensures \result <==> (actual != null); 
           @*/
         public /*@ pure @*/ boolean hasNext() {

	    if ( this.actual != null ){
             	return true;
	    } else {
		return false;
	    }
         }

         /*@ also
           @ requires this.hasNext(); 
           @ assignable actual;
           @ ensures \result == \old(this.actual.informacion) 
           @                    && this.actual == \old(this.actual.siguiente);
           @*/
         public Object next() {
             JMLComparable n;
	     n = this.actual.informacion;
	     this.actual = this.actual.siguiente;
             return n;
         }

        /*@ also 
          @ assignable \nothing; 
          @*/
         public void remove() {

             throw (new UnsupportedOperationException());
         }
    }
/*
    public static void main(String args[]) {

        Lista l = new Lista();

	l.insertar(new JMLInteger(2));
	l.insertar(new JMLInteger(10));
	l.insertar(new JMLInteger(4));
	l.insertar(new JMLInteger(22));
	l.insertar(new JMLInteger(20));
	l.insertar(new JMLInteger(100));
	l.insertar(new JMLInteger(1));
	l.insertar(new JMLInteger(88));
	l.insertar(new JMLInteger(101));
	
	l.eliminar(new JMLInteger(22));	
	l.eliminar(new JMLInteger(4));	

	for ( Iterator it = l.iterator(); it.hasNext();  ){
	    System.out.println("elementos "+l.elementos.informacion);
	    it.next();
	    l.elementos = l.elementos.siguiente;
	}
    }
*/

}
