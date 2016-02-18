/*
 * Archivo: AdministradorArreglos1.java
 *
 * Descripcion: clase que implementa un tipo de datos Administrador de Musica
 *              con arreglos.
 * Fecha: marzo del 2009
 * Autor: Carlos Chitty 07-41896
 *
 * Version: 0.1
 */

//@ import org.jmlspecs.models.JMLValueToValueMap;
//@ import org.jmlspecs.models.JMLValueSequence;
import org.jmlspecs.models.JMLInteger;
import org.jmlspecs.models.JMLString;
import corejava.*;

class AdministradorArreglos1 {

    private /*@ spec_public @*/ Cancion[] elementos;
    private /*@ spec_public @*/ int tam;
    private /*@ spec_public @*/ final int Max;

    /*@ public instance invariant 
      @     
      @     (\forall int i ; 0 <= i && i < this.tam ; cancionValida(this.elementos[i]) ) &&
      @     (\forall int i ; 0 <= i && i < this.tam-1 ; menor(this.elementos[i],this.elementos[i+1]) );
      @*/

    // represents contenido <- JMLValueSequence.convertFrom( convertArrayToJMLType(elementos,elementos.length())) ;

    /*@ requires m > 0; 
      @ ensures this.Max == m && this.tam == 0;
      @*/

    public AdministradorArreglos1(int m) throws valorNoPositivoException {
        this.elementos = new Cancion[m];
        this.tam = 0;
        this.Max = m;
    }

    /*@ 
      @ requires this.tam < this.Max && cancionValida(c);
      @ ensures  this.tam == \old(this.tam) +1 &&
      @          (\exists int i; 0<=i && i<this.tam
      @			; this.elementos[i].equals(c) &&
      @			(\forall int j;0<=j && j<i
      @				; this.elementos[j].equals( \old(this.elementos[j]) ) 
      @			) &&
      @			(\forall int j;i<=j && j<this.tam
      @				; this.elementos[j].equals( \old(this.elementos[j-1]) )
      @			)
      @			
      @  	 );
      @*/
    public void agregarCancion(Cancion c) 
     throws noHaySuficienteEspacioException, cancionNoValidaException{
	this.elementos[this.tam] = c;
	this.tam++;
    }

    /*@
      @ ensures ( (\exists int j; 0<=j && j<this.tam; a.elementos[j].equals(\result)) &&
      @		  \result.getInterprete().equals(i) && \result.getTitulo().equals(t) 
      @         ) ||
      @		( !(\exists int j; 0<=j && j<this.tam; a.elementos[j].getInterprete().equals(i) &&
      @			a.elementos[j].getTitulo().equals(t) && \result == null )
      @		); 
      @*/
    public Cancion buscarCancion(AdministradorArreglos1 a,String i, String t){

        //@ loop_invariant 0 <= j && j <= a.tam;
        //@ decreases a.tam - j;
	for(int j=0; j!=a.tam; j++){
	    if (a.elementos[j].getInterprete() == i && a.elementos[j].getTitulo() == t){
		return a.elementos[j];
	    } else {} //skip 
	}
	return null;
    }

    /*@
      @ ensures ( (\exists int j; 0<=j && j<this.tam; a.elementos[j].equals(\result)) &&
      @		  \result.getInterprete().substring(0,i.length()).equals(i) && 
      @ 	  \result.getTitulo().substring(0,t.length()).equals(t)
      @         ) ||
      @		( !(\exists int j; 0<=j && j<this.tam; 
      @			a.elementos[j].getInterprete().substring(0,i.length()).equals(i) &&
      @			a.elementos[j].getTitulo().substring(0,t.length()).equals(t) && \result == null )
      @		); 
      @*/
    public Cancion buscarCancionAprox(AdministradorArreglos1 a,String i, String t){

        //@ loop_invariant 0 <= j && j <= a.tam;
        //@ decreases a.tam - j;
	for(int j=0; j!=a.tam; j++){
	    if (a.elementos[j].getInterprete().substring(0,i.length()) == i &&
		 a.elementos[j].getTitulo().substring(0,t.length()) == t){
		return a.elementos[j];
	    } else {} //skip 
	}
	return null;
    }

    /*@
      @ ensures  this.tam == \old(this.tam) -1 &&
      @          !(\exists int i; 0<=i && i<this.tam
      @			; this.elementos[i].equals(c) 
      @		  );
      @*/
    public void eliminarCancion(Cancion c){

        //@ loop_invariant 0 <= i && i <= this.tam;
        //@ decreases this.tam - i;
	for(int i=0; i!=this.tam; i++){
	    if ( elementos[i] == c ){
		elementos[i] = elementos[this.tam-1];
	    } else {} // skip
	}
	this.tam--;	
    }

    /*@
      @ ensures this.tam == 0;
      @*/
    public void eliminarLista(){
	this.tam = 0;
    }

    /*@
      @ requires (* n corresponde a un archivo valido cuyo
      @  contenido es valido como lista de reproduccion *);
      @ ensures (* se han incluido en this las canciones
      @  indicadas en el archivo n *);
      @*/
    public void agregarLista(String n){

    }

    /*@
      @ ensures (* se ha almacenado la lista de reproduccion correspondiente
      @  a 'a' en el archivo n *);
      @*/
    public void guardarListaReproduccion(AdministradorInterface a, String n);

    /*@
      @ ensures \result <==> ( c.getInterprete() != null && c.getTitulo() != null &&
      @    ubicacionValida(c.getUbicacion()) && duracionValida(c.getDuracion()) );
      @*/
    public /*@ pure @*/ boolean cancionValida (Cancion c){
	if ( c.getInterprete() != null && c.getTitulo() != null &&
           ubicacionValida(c.getUbicacion()) && duracionValida(c.getDuracion()) ){
		return true;
	}else {
		return false;
	}
    }

    /*@
      @ ensures \result <==> ( u.length() > 4 &&
      @    u.substring(u.length()-4,u.length()).equals(".mp3") );
      @*/
    public /*@ pure @*/ boolean ubicacionValida (String u){
	if ( u.length() > 4 && u.substring(u.length()-4,u.length()).equals(".mp3") ){
		return true;
	}else {
		return false;
	}
    }

    /*@
      @ ensures \result <==> 
      @       ( d.length() == 4 &&
      @           0<=Integer.parseInt(d.substring(0,2)) && 
      @           Integer.parseInt(d.substring(0,2))<60 &&
      @           0<=Integer.parseInt(d.substring(2,4)) && 
      @           Integer.parseInt(d.substring(2,4))<60 
      @       );
      @*/
    public /*@ pure @*/ boolean duracionValida (String d){
	if  ( d.length() == 4 && 0<=Integer.parseInt(d.substring(0,2)) && 
              Integer.parseInt(d.substring(0,2))<60 &&
              0<=Integer.parseInt(d.substring(2,4)) && 
              Integer.parseInt(d.substring(2,4))<60 
            ){
		return true;
	}else {
		return false;
	}
    }

    /*@
      @ ensures \result <==> 
      @   ( c0.getInterprete().compareTo(c1.getInterprete()) < 0  ||
      @     ( c0.getInterprete().equals(c1.getInterprete()) &&
      @       c0.getTitulo().compareTo(c1.getTitulo()) < 0 ) 
      @   );
      @*/
    public /*@ pure @*/ boolean menor (Cancion c0, Cancion c1){
	if ( c0.getInterprete().compareTo(c1.getInterprete()) < 0  ||
              ( c0.getInterprete().equals(c1.getInterprete()) &&
                c0.getTitulo().compareTo(c1.getTitulo()) <= 0    
	      ) 
           ){
		return true;
	}else {
		return false;
	}
    }

    /*@
      @ requires tam <= a.length;
      @ ensures \result.length == tam;
      @ ensures (\forall int i ; 0 <= i && i < tam ; \result[i].equals(new JMLType(a[i])));
      @*/
    private static /*@ pure spec_public @*/ JMLType[] convertArrayToJMLType(
                                                              Cancion[] a, int tam) {

        JMLType[] res = new JMLType[tam];

        for (int i = 0; i < tam; i++) {
            res[i] = new JMLType(a[i]);
        }
        return res;
    }

/******************
    EXCEPCIONES
******************/

  class valorNoPositivoException extends Exception
  {
    public valorNoPositivoException()
    {
	super("Error: valor no positivo.");
    } 
  }

  class noHaySuficienteEspacioException extends Exception
  {
    public noHaySuficienteEspacioException()
    {
	super("Error: No Hay Suficiente Espacio!");
    } 
  }

  class cancionNoValidaException extends Exception
  {
    public cancionNoValidaException()
    {
	super("Error: Cancion no valida!");
    } 
  }

}
