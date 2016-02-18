/*
 * Archivo: Pila.java
 *
 * Descripcion: implementacion del tipo concreto Pila
 * 
 * Version: 0.1.1
 *
 * Autor: Carlos Chitty
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
import corejava.*;

public class Pila {

    //@ public model JMLValueSequence seq;

    //@ represents seq <- deListaASequence(elementos);

    private /*@ spec_public nullable @*/ Nodo elementos; // apuntador al primer nodo+
    private int tamano;

    /*@ invariant (\forall JMLType e ; seq.has(e) ; e instanceof JMLComparable) &&
      @           (\forall int i ; 0 <= i && i < seq.int_size() - 1 
      @                          ; ((JMLComparable) seq.itemAt(i)).compareTo(seq.itemAt(i+1)) <= 0 );
      @*/

    //@ ensures this.seq.int_size() == 0;
    public Pila() {
	this.elementos = null;
	this.tamano = 0;
    }


    /*@ ensures seq.int_size() == \old(seq.int_size()) + 1 && seq.has(e);
      @ ensures \old(seq).equals(seq.subsequence(0, seq.indexOf(e)).
      @              concat(seq.subsequence(seq.indexOf(e)+1, seq.int_size())));
      @*/
    public void push(JMLComparable e) {

        Nodo anterior = null;
	Nodo n = this.elementos;
	
	if (this.elementos == null) {  // insertar en pila vacia
	    this.elementos = new Nodo(e,null);

	}else {
            Nodo aux;
	    aux = new Nodo(e,this.elementos);
            this.elementos = aux;
	}
	tamano++;
    }
    
    //@ ensures seq.equals(\old(seq.removeItemAt(seq.indexOf(e))));
    public void pop(JMLComparable e) {

	if ( this.elementos != null ){

            Nodo anterior = null;
	    Nodo n = this.elementos;
	    this.elementos = this.elementos.siguiente;
	}else {} //skip Pila vacia
	tamano--;	
    }

    public JMLComparable top() {

        return this.elementos.informacion;
    }

    public /*@ pure @*/int tamano() {

        return this.tamano;
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
