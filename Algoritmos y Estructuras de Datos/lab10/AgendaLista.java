/*
 * Archivo: AgendaLista.java
 *
 * Descripci'on: Implementaci'on del TAD Agenda, haciendo uso de Listas enlazadas
 *               simples como modelo de representaci'on concreto.
 *               Se usa una implementaci'on de listas enlazadas cuyo contenido
 *               esta ordenado. Para usar esa implementaci'on de listas es
 *               necesario que el tipo base de la lista enlazada implemente la
 *               interfaz JMLComparable.
 *
 * Versi'on: 0.1.
 *
 * Autor: Gabriela Montoya.
 * 
 * Fecha: marzo, 2009.
 * 
 */
package lab10;
//@ import org.jmlspecs.models.JMLValueToValueMap;
//@ import org.jmlspecs.models.JMLValueValuePair;
//@ import org.jmlspecs.models.JMLType;
//@ import org.jmlspecs.models.JMLValueSequence;
import org.jmlspecs.models.JMLComparable;
import org.jmlspecs.models.JMLInteger;
import org.jmlspecs.models.JMLString;
import java.util.Iterator;

class AgendaLista implements AgendaInterface{

    private /*@ spec_public @*/ Lista contactos;
    private /*@ spec_public @*/ int cant;

    /*@ public invariant 
      @     0 <= cant && cant <= Integer.MAX_VALUE &&
      @     (\forall JMLValueValuePair p 
      @              ; deSequenceAFunction(contactos.seq).has(p) 
      @              ; p.key instanceof JMLString && p.key != null 
      @               && p.value instanceof JMLInteger 
      @               && p.value != null && telefonoValido(((JMLInteger) p.value).intValue())) &&
      @     (\forall JMLType e 
      @             ; contactos.seq.has(e) 
      @             ; (\num_of JMLType e1 
      @                      ; contactos.seq.has(e1) 
      @                      ; (((Contacto) e).nombre.equals(((Contacto) e1).nombre)))== 1);
      @*/

    /*@
      @ represents telefono <- deSequenceAFunction(contactos.seq);
      @ represents nombres <- telefono.domain();
      @*/

    /*@ ensures this.cant == 0; @*/
    public AgendaLista() {

        this.cant = 0;
	contactos = new Lista();
        //@ set MAX = Integer.MAX_VALUE;
    }

    /*@ also
      @ requires n != null && this.buscarTelefono(n) == -1 && 
      @          this.telefonoValido(t) && this.cant < Integer.MAX_VALUE;
      @ ensures this.cant == \old(this.cant) + 1;
      @ ensures ((Contacto) buscar(n)).telefono == t;
      @ ensures \old(contactos.seq).equals(
      @            contactos.seq.subsequence(0, contactos.seq.indexOf(buscar(n))).concat(
      @            contactos.seq.subsequence(contactos.seq.indexOf(buscar(n))+1, contactos.seq.int_size())));
      @*/
    public void agregarContacto (String n, int t) {

	Contacto nuevoContacto = new Contacto(n,t);
        contactos.insertar(nuevoContacto);
	this.cant++;
    }

    /*@ also
      @ requires n != null && this.buscarTelefono(n) != -1;
      @ ensures this.cant == \old(this.cant) - 1;
      @ ensures contactos.seq.equals(\old(contactos.seq.removeItemAt(contactos.seq.indexOf(buscar(n)))));
      @*/
    public void eliminarContacto (String n) {

        // COMPLETAR
    }

    /*@ ensures \result == ((Contacto) contactos.buscar(new Contacto(n, 212000000)));
      @*/
    private /*@ spec_public pure nullable @*/ Contacto buscar (String n) {

	Lista l = this.contactos;
        Contacto buscado = null;
/*
	for ( Iterator it = l.iterator(); it.hasNext();  ){

          if( l.equals(n) ){
            buscado = l.clone();
          } else {} //skip

	  it.next();
//	  l = l.siguiente;
        }
*/
        return buscado;
    }

    /*@ also
      @ ensures (\result == -1 && buscar(n) == null)
      @         ||
      @         (\exists JMLComparable e 
      @             ; contactos.seq.has(e) 
      @             ; ((Contacto) e).nombre.equals(n) && ((Contacto) e).telefono == \result);
      @*/          
    public /*@ pure @*/ int buscarTelefono (String n) {

         return -1; // SUSTITUIR POR SU IMPLEMENTACI'ON
    }

    /*@ also
      @ requires true;
      @ ensures (* se han escrito en pantalla los elementos de telefono ordenados por nombre *);
      @*/
    public void listarContactos () {
	
	Lista l = this.contactos;

	System.out.println("Nombre\tTelefono");
	for ( Iterator it = l.iterator(); it.hasNext();  ){
	    System.out.println( l.toString() );
	    it.next();
	}
    }

    /*@ also
      @ requires !(\exists JMLType e ; this.contactos.seq.has(e)
      @                              ; a.buscarTelefono(((Contacto) e).nombre) != -1)
      @        && this.cant + a.cantidadContactos() <= Integer.MAX_VALUE;
      @ ensures a.cantidadContactos() == this.cant + \old(a.cantidadContactos());
      @ ensures (\forall int i ; 0 <= i && i < this.cant
      @                        ; a.buscarTelefono(((Contacto) this.contactos.seq.itemAt(i)).nombre)
      @                          ==
      @                          ((Contacto) this.contactos.seq.itemAt(i)).telefono
      @         ) 
      @         && \old(a.nombres).isSubset(a.nombres) && 
      @         \old(a.telefono.toSet()).isSubset(a.telefono.toSet());
      @ ensures this.cant == \old(this.cant);
      @ ensures this.contactos.seq.equals(\old(this.contactos.seq));
      @*/
    public void incluirContactos (AgendaInterface a) {

         // COMPLETAR
    }

    /*@ also
      @ ensures \result == this.cant;
      @*/    
    public /*@ pure @*/ int cantidadContactos () {

        return this.cant;
    }

    /*@ also
      @ requires true;
      @ ensures \result <==> 212000000 <= t && t <= 426999999;
      @*/
    public /*@ pure @*/ boolean telefonoValido (int t) {

        if ( 212000000 <= t && t <= 426999999 ) {
          return true;
        }else{
          return false;
        }
    }

    /*@ requires (\forall JMLType e 
      @               ; s.has(e) 
      @               ; (\num_of JMLType e1 
      @                      ; s.has(e1) 
      @                      ; (((Contacto) e).nombre.equals(((Contacto) e1).nombre)))== 1);
      @ ensures \result.int_size() == s.int_size();
      @ ensures (\forall JMLType e 
      @               ; s.has(e) 
      @               ; \result.has(new JMLValueValuePair(new JMLString(((Contacto) e).nombre), 
      @                                                   new JMLInteger(((Contacto) e).telefono))));
      @*/
    public static /*@ pure  @*/ JMLValueToValueMap deSequenceAFunction (
                    final JMLValueSequence s) {

        JMLValueToValueMap func = new JMLValueToValueMap();
        JMLValueSequence aux = s;

        for (int i = 0; i < s.int_size(); i++) {
            Contacto c = (Contacto) s.get(i);
            func = func.extend(new JMLString(c.nombre), new JMLInteger(c.telefono));
        }
        return func;
    }

    private /*@ spec_public @*/ class Contacto implements JMLComparable {

        public String nombre;
        public int telefono;

        public Contacto (String n, int t) {

            nombre = n;
            telefono = t;
        }

        public String toString() {

            return ("Nombre: "+nombre+". Telefono: "+telefono+".");
        }

        public /*@ pure @*/ int compareTo(Object o) throws ClassCastException {

            if (o == null) {
                throw (new NullPointerException());
            } else if (!(o instanceof Contacto)) {
                throw (new ClassCastException());
            }
            return nombre.compareTo(((Contacto) o).nombre);
        }

        public boolean equals (Object o) {

            return (o != null) && (o instanceof Contacto) && 
                 ((Contacto) o).nombre.equals(nombre) && ((Contacto) o).telefono == telefono;
        }

        public Object clone() {
            return new Contacto(nombre, telefono);
        }

    } 

    public static void main(String args[]) {

         // INCLUIR UN PROGRAMA PRINCIPAL QUE PERMITA REALIZAR PROBAR LAS OPERACIONES DE ESTA IMPLEMENTACI'ON.
    }
}

