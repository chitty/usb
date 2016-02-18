package ve.usb.reproductor;

//@ import org.jmlspecs.models.JMLType;

/** Interfaz que representa el tipo Cancion de manera abstracta */
public interface CancionInterface extends JMLType {

    /** t'itulo de la canci'on */
    //@ public ghost instance String t;

    /** int'erprete de la canci'on */
    //@ public ghost instance String i;

    /** ubicaci'on de la canci'on */
    //@ public ghost instance String u;

    /** duraci'on de la canci'on */
    //@ public ghost instance String d;

    /** el contenido de los campos no es nulo */
    //@ instance invariant t != null && i != null && u != null && d != null;

    /** devuelve la duraci'on de la canci'on */
    //@ ensures \result.equals(this.d);
    public String getDuracion();

    /** devuelve el t'itulo de la canci'on */
    //@ ensures \result.equals(this.t);
    public String getTitulo();

    /** devuelve la ubicaci'on de la canci'on */
    //@ ensures \result.equals(this.u);
    public String getUbicacion();

    /** devuelve el int'erprete de la canci'on */
    //@ ensures \result.equals(this.i);
    public String getInterprete();

    /** devuelve una instancia de Canci'on cuyo contenido coincide 
        con el contenido de this */
    /*@ also
      @ ensures \result != this && \result instanceof CancionInterface &&
      @         ((CancionInterface) \result).d.equals(this.d) && 
      @         ((CancionInterface) \result).t.equals(this.t) && 
      @         ((CancionInterface) \result).u.equals(this.u) &&
      @         ((CancionInterface) \result).i.equals(this.i);
      @*/
    public Object clone();

    /** devuelve una representaci'on como String de la canci'on */
    /*@ also
      @ ensures \result.equals("Titulo: " + this.t + ". Interprete: " + this.i +
      @         ". Ubicacion: " + this.u + ". Duracion: " + this.d);
      @
      @*/
    public String toString();

    /** se satisface si el objeto pasado como argumento es una canci'on cuyo
        contenido coincide con el de this */
    /*@ also
      @ ensures \result 
      @         <==> 
      @         o != null && o instanceof CancionInterface && 
      @         ((CancionInterface) o).d.equals(this.d) &&
      @         ((CancionInterface) o).t.equals(this.t) &&
      @         ((CancionInterface) o).u.equals(this.u) && 
      @         ((CancionInterface) o).i.equals(this.i);
      @*/
    public boolean equals(/*@ nullable @*/ Object o);

    /** se satisface si la cancion actual (this) es menor o igual a la cancion
        pasada como argumento */
    /*@ 
      @ ensures \result 
      @         <==> 
      @         (this.i.compareTo(c.i) < 0 ||
      @         (this.i.equals(c.i) && this.t.compareTo(c.t) <= 0));
      @*/
    public /*@ pure @*/ boolean menor (CancionInterface c);
}
