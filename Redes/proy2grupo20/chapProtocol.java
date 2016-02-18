/* 
 * Archivo: chapProtocol.java
 * implementa la autenticacion del protocolo CHAP
 *
 * Autor: Carlos J. Chitty 07-41896
 */

import nanoxml.*;
import java.util.*;

public class chapProtocol {
    private static final int CHALLENGE = 1;
    private static final int RESPONSE = 2;
    private static final int SUCCESS = 3;
    private static final int FAILURE = 4;
    private int state = CHALLENGE;


    public String processInput(String theInput, XMLElement xml) {
        
	String theOutput = null;
        Random generator = new Random();  // para generar el challenge
        int random = 0;
    	String resp = "";
    	String response = "";
    	String log = "";
    	String login = "";
    	String clave = "";
    	String alias = "";
    	String secret = "";

        if (state == CHALLENGE) {
	    random = generator.nextInt();
	    global.challenge = Integer.toString(random);
            theOutput = global.challenge; // envia el challenge
            state = RESPONSE;

	} else if (state == RESPONSE) {
 
	    try{

		StringTokenizer tokens = new StringTokenizer(theInput);  
	        if(tokens.hasMoreTokens())
		    response = tokens.nextToken().trim();
	        if(tokens.hasMoreTokens())
		    log = tokens.nextToken().trim(); 

		try{
		    secret = funcionesXML.obtenerClave(xml,log);
		} catch (Exception e){
		    System.out.println("excepcion llamando a obtenerClave!");
		}

		tokens = new StringTokenizer(secret);
	        if(tokens.hasMoreTokens())
		    login = tokens.nextToken().trim();
	        if(tokens.hasMoreTokens())
		    clave = tokens.nextToken().trim();
	        if(tokens.hasMoreTokens())
		    alias = tokens.nextToken().trim();

		resp = MD5.md5(global.challenge+clave);

	    	System.out.println("\n\tPROCESO DE AUTENTICACION");
	    	System.out.println("Login: " + login);
	    	System.out.println("Alias: " + alias);
	    	System.out.println("Clave: " + clave);
	    	System.out.println("Challenge: " + global.challenge);
	    	System.out.println("Clave Cifrada: " + resp + "\n");

		// COMPARAR EL RESPONSE CON EL MD5 SI COINCIDEN ACEPTAR CONEXION
            	if (response.equals(resp)){
		    theOutput = Integer.toString(SUCCESS);
		    theOutput = theOutput + " " + alias;

		// SI NO COINCIDEN ENVIAR FAILURE
            	} else           
		    theOutput = Integer.toString(FAILURE);

		state = CHALLENGE;
            
	    } catch ( Exception e ){
		System.out.println("excepcion!");
	    }
	}
        return theOutput;
    }

}

// challenge variable global para poder referenciarla en distintas llamadas
class global {
    public static String challenge = "";
}
