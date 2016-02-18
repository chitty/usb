/*
 * Archivo: Cliente.java
 *
 * Descripcion: programa cliente para el TAD Administrador De Musica
 * Autor: Carlos Chitty    07-41896
 * Fecha marzo 2009
 */

package ve.usb.reproductor;
import corejava.*;
class Cliente {

  public static void main (String[] args) {

    int implementacion,N;

    System.out.println("\n\t***ADMINISTRADOR DE MUSICA***\n");
    implementacion = Console.readInt("Indique el tipo de implementacion que desea"+ 
	        	"utilizar:\nCon Arreglos\t(0 ó -)\nCon Listas\t(1 ó +)\n\t\t");
	
    if ( implementacion <= 0 ){	

	try{
	    N = Console.readInt("Indique el numero maximo de canciones a registrar: ");
	    if (N<=0) 
		throw new valorNoPositivoException();
	    else{
               try{
		   AdministradorArreglos admin = new AdministradorArreglos(N);
	           ClienteArreglo.arreglo(admin);
	       }catch (valorNoPositivoException e){} // ya la excepcion fue capturada
            }

	}catch (valorNoPositivoException e){
	    do{
	    	System.out.println( e.getMessage() );
		N = Console.readInt("Intente de nuevo: ");
	    }while(N<=0);

	    try{
		AdministradorArreglos admin = new AdministradorArreglos(N);
	        ClienteArreglo.arreglo(admin);
	    }catch (valorNoPositivoException e){} // ya la excepcion fue capturada
	}

    } else{ 
	AdministradorListas admin = new AdministradorListas();
	ClienteLista.conLista(admin);
    }

  }

}

