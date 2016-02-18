/*
 * Archivo: AdministradorListas.java
 *
 * Descripcion: clase que implementa un tipo de datos Administrador de Musica
 *              con listas.
 * Fecha: marzo del 2009
 * Autor: Carlos Chitty 07-41896
 *
 * Version: 0.1
 */

package ve.usb.reproductor;
//@ import org.jmlspecs.models.JMLValueToValueMap;
//@ import org.jmlspecs.models.JMLValueSequence;
//@ import org.jmlspecs.models.JMLType;
import org.jmlspecs.models.JMLInteger;
import org.jmlspecs.models.JMLString;
import corejava.*;
import java.io.*;
import java.util.Iterator;

class AdministradorListas {

    private /*@ spec_public @*/ Lista elementos;
    private /*@ spec_public @*/ int tam;
    private /*@ spec_public @*/ final int Max;

    /* public instance invariant 
           
           size(elementos)<=MAX && MAX>0;
      */

    // represents contenido <- JMLValueSequence.convertFrom( convertArrayToJMLType(elementos,elementos.length())) ;


    public AdministradorListas() {

        this.elementos = new Lista();
        this.tam = 0;
        this.Max =  Integer.MAX_VALUE;
    }


    public void agregarCancion(Cancion c) 
     throws noHaySuficienteEspacioException, cancionNoValidaException{

	if (this.tam >= this.Max)
	    throw new noHaySuficienteEspacioException();

	if (this.tam < this.Max && !cancionValida(c))
	    throw new cancionNoValidaException();

	this.elementos.insertar(c);
	this.tam++;
    }


    public Cancion buscarCancion(AdministradorListas a,String i, String t){
	return null;
    }


    public Cancion buscarCancionAprox(AdministradorListas a,String i, String t){
	return null;
    }


    public void eliminarCancion(Cancion c){

        this.elementos.eliminar(c);
	this.tam--;	
    }

    /*@
      @ ensures this.tam == 0;
      @*/
    public void eliminarLista(){
	this.elementos = new Lista();
	this.tam = 0;
    }

    /*@
      @ requires (* n corresponde a un archivo valido cuyo
      @  contenido es valido como lista de reproduccion *);
      @ ensures (* se han incluido en this las canciones
      @  indicadas en el archivo n *);
      @*/
    public void agregarLista(String n) throws IOException {

	String linea,t,i,u,d = "";
    	String[] tok;
	BufferedReader lista = new BufferedReader( new FileReader(n) );
	
	while( (linea = lista.readLine()) != null){
	    tok = linea.split("\\b\\s");
	    t = tok[0].trim();
	    i = tok[1].trim();
	    u = tok[2].trim();
	    d = tok[3].trim();
	    try{
	    	this.agregarCancion( new Cancion(t,i,u,d) );
	    }catch(noHaySuficienteEspacioException e){
		System.out.println("La Cancion no pudo ser agregada!");
	    }catch(cancionNoValidaException e2){
		System.out.println("La Cancion no pudo ser agregada!");
	    }
	}
	
    }

    /*@
      @ ensures (* se ha almacenado la lista de reproduccion correspondiente
      @  a 'a' en el archivo n *);
      @*/
    public void guardarListaReproduccion(AdministradorListas a, String n) 
     throws IOException{
	
	PrintWriter lista = new PrintWriter( new FileOutputStream(n) );

    }

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

}
