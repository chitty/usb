/*
 * Archivo: IntBagInterface.java
 *
 * Descripcion: interfaz que especifica con modelo abstracto un tipo de datos 
 *               multiconjunto de enteros, para la representaci'on se incluye un 
 *               campo de tipo JMLValueBag, modelo matematico multiconjunto, y 
 *               un campo de tipo int que indica el tamaño maximo del
 *               multiconjunto.
 *
 * Fecha: febrero 2009
 *
 * Nota: falta la especificacion de la funcion count, esta funcion devuelve la
 *       cantidad de elementos que contiene el multiconjunto.
 * Autor: Gabriela Montoya
 *
 * Version: 0.1
 */

//@ import org.jmlspecs.models.JMLValueBag;
//@ import org.jmlspecs.models.JMLInteger;

public interface IntBagInterface {

    //@ public model instance JMLValueBag multiconjunto;
    //@ public ghost instance int MAX;

    //@ instance invariant  (this.multiconjunto.int_size() <= MAX);

    /*@ requires this.multiconjunto.union(new JMLValueBag(new JMLInteger(x))).int_size() < MAX;
      @ ensures 
      @ this.multiconjunto.equals(\old(this.multiconjunto.union(new JMLValueBag(new JMLInteger(x)))));
      @*/
    public void insert (int x);

    /*@ ensures this.multiconjunto.equals(
      @           \old(this.multiconjunto.difference(new JMLValueBag(new JMLInteger(x))))
      @         );
      @*/
    public void remove (int x);

    //@ ensures \result <==> this.multiconjunto.has(new JMLInteger(x));
    public /*@ pure @*/ boolean isIn (int x);

    public /*@ pure @*/ int count (int x);

    //@ ensures \result == this.multiconjunto.int_size();
    public /*@ pure @*/ int size ();

}
