/*
 * Archivo: AdministradorInterface.java
 *
 * Descripcion: interfaz que especifica con modelo abstracto un tipo de datos
 *              Administrador de musica
 * Fecha: marzo 2009
 * Autor: Carlos Chitty
 *
 * Version: 0.1
 */

//@ import org.jmlspecs.models.JMLInteger;
//@ import org.jmlspecs.models.JMLString;
//@ import org.jmlspecs.models.JMLType;
//@ import org.jmlspecs.models.JMLValueSequence;

interface AdministradorInterface {
    
    //@ public model instance JMLValueSequence contenido;
    //@ public ghost instance int MAX;

    /*@ public instance invariant 
      @     this.contenido.int_size() <= this.MAX && 	     
      @ (\forall JMLType c; this.contenido.has(c); c instanceof CancionInterface);
      @
      @*/ // (\forall int i; 0<=i<this.contenido.int_size()-1; menor( this.contenido.get(i),this.contenido.get(i+1) ) )

    /*@ 
      @ requires this.contenido.int_size() < this.MAX && cancionValida(c);
      @ ensures  (\exists int i; 0<=i && i<this.contenido.int_size()
      @			; this.contenido.get(i).equals(c) &&
      @			(\forall int j;0<=j && j<i
      @				; this.contenido.get(j).equals( \old(this.contenido.get(j)) ) 
      @			) &&
      @			(\forall int j;i<=j && j<this.contenido.int_size()
      @				; this.contenido.get(j).equals( \old(this.contenido.get(j-1)) )
      @			)
      @  	 ) &&
      @		this.contenido.int_size() == \old(this.contenido.int_size()) +1;
      @*/
    public void agregarCancion(Cancion c);

    /*@
      @ ensures ( a.contenido.has(\result) && \result.getInterprete().equals(i) &&
      @             \result.getTitulo().equals(t) 
      @         ) || 
      @		!(\exists Cancion c; a.contenido.has(c); c.getInterprete().equals(i) &&
      @               c.getTitulo().equals(t) && \result == null
      @		);
      @*/
    public Cancion buscarCancion(AdministradorInterface a,String i, String t);

    /*@
      @ ensures ( a.contenido.has(\result) && \result.getInterprete().indexOf(i) >= 0 &&
      @           \result.getTitulo().indexOf(t) >= 0  &&
      @         	(\forall Cancion c; a.contenido.has(c) && menor(c,\result);
      @				c.getInterprete().indexOf(i) == -1 ||
      @              		c.getTitulo().indexOf(t) == -1
      @			)
      @		) ||
      @		( \result == null &&
      @		  !(\exists Cancion c; a.contenido.has(c); c.getInterprete().indexOf(i) >= 0 &&
      @			c.getTitulo().indexOf(t) >= 0 )
      @		);
      @*/
    public Cancion buscarCancionAprox(AdministradorInterface a,String i, String t);

    /*@
      @ ensures !this.contenido.has(c);
      @*/
    public void eliminarCancion(Cancion c);

    /*@
      @ ensures this.contenido == null;
      @*/
    public void eliminarLista();

    /*@
      @ requires (* n corresponde a un archivo valido cuyo
      @  contenido es valido como lista de reproduccion *);
      @ ensures (* se han incluido en this las canciones
      @  indicadas en el archivo n *);
      @*/
    public void agregarLista(String n);

    /*@
      @ ensures (* obtenerReproductor es un reproductor cuya lista
      @  de reproduccion se corresponde con a.contenido *);
      @*/
    public Reproductor obtenerReproductor(AdministradorInterface a, String n);

    /*@
      @ ensures (* iterador es un iterador sobre la secuencia a.contenido *);
      @*/
    public Iterador iterador(AdministradorInterface a);

    /*@
      @ ensures (* se ha almacenado la lista de reproduccion correspondiente
      @  a 'a' en el archivo n *);
      @*/
    public void guardarListaReproduccion(AdministradorInterface a, String n);

    /*@
      @ ensures \result <==> ( c.getInterprete() != null && c.getTitulo() != null &&
      @    ubicacionValida(c.getUbicacion()) && duracionValida(c.getDuracion()) );
      @*/
    public /*@ pure @*/ boolean cancionValida (Cancion c);

    // esArchivo(u)
    /*@
      @ ensures \result <==> ( u.length() > 4 &&
      @    u.substring(u.length()-4,u.length()).equals(".mp3") );
      @*/
    public /*@ pure @*/ boolean ubicacionValida (String u);

    /*@
      @ ensures \result <==> 
      @       ( d.length() == 4 &&
      @           0<=Integer.parseInt(d.substring(0,2)) && 
      @           Integer.parseInt(d.substring(0,2))<60 &&
      @           0<=Integer.parseInt(d.substring(2,4)) && 
      @           Integer.parseInt(d.substring(2,4))<60 
      @       );
      @*/
    public /*@ pure @*/ boolean duracionValida (String d);

    /*@
      @ ensures \result <==> 
      @   ( c0.getInterprete().compareTo(c1.getInterprete()) < 0  ||
      @     ( c0.getInterprete().equals(c1.getInterprete()) &&
      @       c0.getTitulo().compareTo(c1.getTitulo()) <= 0 ) 
      @   );
      @*/
    public /*@ pure @*/ boolean menor (Cancion c0, Cancion c1);

}
