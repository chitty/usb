/*
 * Archivo: Cancion.java
 *
 * Descripcion: clase que implementa un tipo de datos Cancion
 * Fecha: marzo del 2009
 * Autor: Carlos Chitty 07-41896
 * Version: 0.1
 */

package ve.usb.reproductor;
//@ import org.jmlspecs.models.JMLString;
import org.jmlspecs.models.JMLComparable;

class Cancion implements CancionInterface, JMLComparable {

    private /*@ spec_public @*/ String t;
    private /*@ spec_public @*/ String i;
    private /*@ spec_public @*/ String u;
    private /*@ spec_public @*/ String d;

    //@ instance invariant t != null && i != null && u != null && d != null;

    // represents t <- convertStringToJMLString(this.t,this.t.length());
    // represents i <- convertStringToJMLString(this.i,this.i.length());
    // represents u <- convertStringToJMLString(this.u,this.u.length());
    // represents d <- convertStringToJMLString(this.d,this.d.length());

    public Cancion(String titulo, String interprete, String ubicacion, String duracion) {

        this.t = titulo;
        this.i = interprete;
        this.u = ubicacion;
        this.d = duracion;
    }

    //@ also ensures \result == this.d;
    public /*@ pure @*/ String getDuracion(){
	return this.d;
    }

    //@ also ensures \result == this.t;
    public /*@ pure @*/ String getTitulo(){
	return this.t;
    }

    //@ also ensures \result == this.u;
    public /*@ pure @*/ String getUbicacion(){
	return this.u;
    }

    //@ also ensures \result == this.i;
    public /*@ pure @*/ String getInterprete(){
	return this.i;
    }

    /** devuelve una instancia de Cancion cuyo contenido coincide 
        con el contenido de this */
    /*@ also
      @ ensures \result != this && \result instanceof CancionInterface &&
      @         ((CancionInterface) \result).d == this.d && 
      @         ((CancionInterface) \result).t == this.t && 
      @         ((CancionInterface) \result).u == this.u &&
      @         ((CancionInterface) \result).i == this.i;
      @*/
    public Object clone(){
	Cancion c = new Cancion(this.t,this.i,this.u,this.d);
	return c;
    }

    /** devuelve una representaci'on como String de la canci'on */
    /*@ also
      @ ensures \result.equals("Titulo: " + this.t + ". Interprete: " + this.i +
      @         ". Ubicacion: " + this.u + ". Duracion: " + this.d);
      @
      @*/
    public String toString(){
 	String s = new String("Titulo: " + this.t + ". Interprete: " + this.i + 
                              ". Ubicacion: " + this.u + ". Duracion: " + this.d
                             );
	return s;
    }

    /** se satisface si el objeto pasado como argumento es una cancion cuyo
        contenido coincide con el de this */
    /*@ also
      @ ensures \result 
      @         <==> 
      @         o != null && o instanceof CancionInterface && 
      @         ((CancionInterface) o).d == this.d &&
      @         ((CancionInterface) o).t == this.t &&
      @         ((CancionInterface) o).u == this.u && 
      @         ((CancionInterface) o).i == this.i;
      @*/
    public boolean equals(/*@ nullable @*/ Object o){
	if (  ((Cancion)o).d == this.d && ((Cancion)o).t == this.t &&
              ((Cancion)o).u == this.u && ((Cancion)o).i == this.i
	   ){
	    return true;
        }else{
	    return false;
	}
    }

    /*@
      @ requires tam <= ns.length;
      @ ensures \result.length == tam;
      @ ensures (\forall int i ; 0 <= i && i < tam ; \result[i].equals(new JMLString(ns[i])));
      @*/
    private static /*@ pure spec_public @*/ JMLString[] convertStringToJMLString(
                                                              String[] ns, int tam) {

        JMLString[] res = new JMLString[tam];

        for (int i = 0; i < tam; i++) {
            res[i] = new JMLString(ns[i]);
        }
        return res;
    }

}
