/*
 * Archivo: AgendaInterface.java
 *
 * Descripci'on: interfaz que especifica con modelo abstracto un tipo de datos
 *               Agenda. Este TAD permite almacenar nombres y un telefono asociado
 *               a cada nombre.
 *
 * Fecha: febrero 2009
 *
 * Autor: Gabriela Montoya
 *
 * Version: 0.1
 */

package lab10;
//@ import org.jmlspecs.models.JMLInteger;
//@ import org.jmlspecs.models.JMLString;
//@ import org.jmlspecs.models.JMLType;
//@ import org.jmlspecs.models.JMLValueValuePair;
//@ import org.jmlspecs.models.JMLValueSet;
//@ import org.jmlspecs.models.JMLValueToValueMap;

public interface AgendaInterface {

    //@ public model instance JMLValueSet nombres;
    //@ public model instance JMLValueToValueMap telefono;
    //@ public ghost instance int MAX;

    /*@ public instance invariant 
      @     this.nombres.equals(this.telefono.domain()) && this.nombres.int_size() <= this.MAX &&
      @     (\forall JMLValueValuePair p 
      @              ; this.telefono.has(p) 
      @              ;   p.key instanceof JMLString && p.key != null 
      @               && p.value instanceof JMLInteger 
      @               && p.value != null && telefonoValido(((JMLInteger) p.value).intValue()));
      @*/

    /*@ 
      @ ensures this.telefono.equals(\old(this.telefono.union(new JMLValueToValueMap(
      @                     new JMLString(n), new JMLInteger(t))).toFunction()));
      @*/
    public void agregarContacto (final String n, final int t);

    /*@ 
      @ requires this.nombres.has(new JMLString(n));
      @ ensures this.telefono.equals(\old(this.telefono.difference(
      @                          new JMLValueToValueMap(new JMLString(n), 
      @                                       this.telefono.apply(new JMLString(n))))));
      @*/
    public void eliminarContacto (final String n);

    /*@
      @ requires n != null;
      @ ensures (this.nombres.has(new JMLString(n)) 
      @          && \result == ((JMLInteger) this.telefono.apply(new JMLString(n))).intValue()) 
      @       ||
      @         (!this.nombres.has(new JMLString(n)) && \result == -1);
      @*/
    public /*@ pure @*/ int buscarTelefono (String n);

    /*@ 
      @ requires true;
      @ ensures (* se han escrito en pantalla los elementos de telefono ordenados por nombre *);
      @*/
    public void listarContactos ();

    /*@
      @ requires !(\exists JMLType e ; this.nombres.has(e) ; a1.nombres.has(e)) 
      @        && this.nombres.int_size() + a1.nombres.int_size() <= a1.MAX;
      @ ensures a1.telefono.equals(this.telefono.union(a1.telefono));
      @ ensures this.telefono.equals(\old(this.telefono));
      @*/
    public void incluirContactos (AgendaInterface a1);

    //@ ensures \result == this.nombres.int_size();
    public /*@ pure @*/ int cantidadContactos ();

    /*@
      @ requires true;
      @ ensures \result <==> 212000000 <= t && t <= 426999999;
      @*/
    public /*@ pure @*/ boolean telefonoValido (int t);

}
