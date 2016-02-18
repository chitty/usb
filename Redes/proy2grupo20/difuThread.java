/* 
 * Archivo: difuThread.java
 *
 * Contiene el Thread que maneja cada conexion a difu
 *
 * Autor: Carlos J. Chitty 07-41896
 */

import java.io.*;
import java.net.*;
import nanoxml.*;
import java.util.*;

public class difuThread extends Thread {

    protected XMLElement xml = new XMLElement();
    protected ServerSocket serverSocket = null;
    protected Socket clientSocket = null;

    public difuThread(XMLElement elXML, ServerSocket s, Socket cliente) throws IOException {

	this.xml = elXML;
	this.serverSocket = s;
	this.clientSocket = cliente;
    }

    public void run() {

	String usuarios = "";
	String losUsuarios = "";
	String user = "";
	String dummy = "";
	String dest = "";
	String alias = "";
	StringTokenizer tokens = null;
	
	// inicializar tabla de suscriptores y de mensajes pendientes
	if ( Global.Suscriptores.size() == 0 ){
	    losUsuarios = funcionesXML.obtenerUsuarios(this.xml);
	    tokens = new StringTokenizer(losUsuarios);
	    while(tokens.hasMoreTokens()){ 
		user = tokens.nextToken().trim();
	    	Global.Suscriptores.put(user,new LinkedList());
	    	Global.mensajesPendientes.put(user,new LinkedList());
	    }
	}
	
        try{
	    
     	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
				new InputStreamReader(
				clientSocket.getInputStream()));
            String inputLine, outputLine;
            chapProtocol chap = new chapProtocol();

	    // Proceso de autenticacion mediante CHAP
            outputLine = chap.processInput(null,null); // para que genere el challenge
	    out.println(outputLine);

            if ((inputLine = in.readLine()) != null) {
                outputLine = chap.processInput(inputLine,this.xml); // aqui se envia el response
                out.println(outputLine.charAt(0));
	        tokens = new StringTokenizer(outputLine);
	        while(tokens.hasMoreTokens())
		    alias = tokens.nextToken().trim();

		if (Global.verificacion)
		    System.out.println(inputLine);
            }

	    // si el usuario no pudo ser autenticado cerrar la conexion
	    if ( outputLine.equals("4") ) {
                out.close();
            	in.close();
            	clientSocket.close();
            	serverSocket.close();

	    } else {

		// Usuario autenticado
		String msg = "";
		InputStream teclado = System.in;

            	while ((inputLine = in.readLine()) != null ) {

		    // revisar si hay mensajes pendientes por leer
		    dummy = leerPendientes(alias);
		    if ( dummy != null )
			out.println( dummy );

		    String leido = "";
		    // revisar si se ha escrito algun comando
		    if ( teclado.available() > 0 ){
			leido = Console.readString();
			if ( leido.equals("i") )
			    Global.verificacion = true;
			else if ( leido.equals("f") )
			    Global.verificacion = false;
			else if ( leido.equals("q") ){
                	    out.close();
            		    in.close();
            		    clientSocket.close();
            		    serverSocket.close();
			    teclado.close();
			    System.exit(0);
			}
		    }

		    // si esta en modo verificacion, mostrar lo recibido
		    if (Global.verificacion && !inputLine.equals("z") )
		    	System.out.println(inputLine);

		    // listar usuarios definidos en el sistema
		    if ( inputLine.equals("u") ){ 
		    	usuarios = funcionesXML.obtenerUsuarios(this.xml);
		     	out.println("\tUSUARIOS:\n"+usuarios+"\n" );
		    	continue; 

		    // mensaje para los suscriptores
	            } else if ( inputLine.charAt(0) == 'm' ) {
		        if (inputLine.length() > 2) {
			    msg = inputLine.substring(2,inputLine.length());
			    Date fecha=new Date();
			    msg = msg+" ["+fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900);
			    msg = msg+" @ "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()+"]";
			    enviarMensaje(alias, msg);
			    msg =""; 
			}
		    	continue; 

		    // mensaje para un usuario en particular
	            } else if ( inputLine.charAt(0) == 'w' ) {
			tokens = new StringTokenizer(inputLine);
			if (tokens.hasMoreTokens())
		    	    dest = tokens.nextToken().trim();
			if (tokens.hasMoreTokens())
		    	    dest = tokens.nextToken().trim();
			while(tokens.hasMoreTokens())
		    	    msg = msg+" "+tokens.nextToken().trim();
		        Date fecha=new Date();
			msg = msg+" ["+fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900);
			msg = msg+" @ "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()+"]";
			enviarMensajeA(alias, dest, msg);
			msg ="";  
		    	continue; 

		    // suscribirse a los mensajes de un usuario
	            } else if ( inputLine.charAt(0) == 's' ){ 
			if (inputLine.length() > 2) {
			    dummy = inputLine.substring(2,inputLine.length());
			    Set todos = Global.Suscriptores.keySet();
			    // verificar que el usuario existe
			    if ( todos.contains(dummy) ){
			      LinkedList lista = (LinkedList) Global.Suscriptores.get(dummy);
			    	if ( !lista.contains(alias) && !alias.equals(dummy) ){
			    	    lista.add(alias);
			    	    Global.Suscriptores.put(dummy,lista);
			        }
			     }
			}
		    	continue; 

		    // desuscribirse a los mensajes de un usuario
		    } else if ( inputLine.charAt(0) == 'd' ){ 
			if (inputLine.length() > 2) {
			    dummy = inputLine.substring(2,inputLine.length());
			    Set todos = Global.Suscriptores.keySet();
			    // verificar que el usuario existe
			    if ( todos.contains(dummy) ){
			      LinkedList lista = (LinkedList) Global.Suscriptores.get(dummy);
			    	if ( lista.contains(alias) ){
			    	    lista.remove(alias);
			    	    Global.Suscriptores.put(dummy,lista);
			        }
			     }
			}
		    	continue; 
		    }

            	}

	    }

        }catch(Exception e){
	    System.out.print("Ha ocurrido una excepcion!\n");
	}
    }

    /** procesa el mensaje enviado por el usuario 'alias' y lo
      * almacena para su posterior envio a los suscriptores
      */
    public void enviarMensaje(String alias, String msg){

	LinkedList lista = (LinkedList) Global.Suscriptores.get(alias);
	Iterator it = lista.iterator();
	String suscriptor ="";

	if ( lista.size() > 0 ){
	    while( it.hasNext() ){
		suscriptor = (String) it.next();
    		LinkedList l =(LinkedList) Global.mensajesPendientes.get(suscriptor);
    		l.add("Alias"+alias+":"+msg);
		Global.mensajesPendientes.put(suscriptor,l);
	    }	    
	} else{} // si no hay suscriptores, descartar el mensaje
    }


    /** procesa el mensaje enviado al usuario particular 'alias'
      * y lo almacena para su posterior envio
      */
    public void enviarMensajeA(String de, String para, String msg){

	if ( Global.mensajesPendientes.containsKey(para) ){
	    LinkedList l =(LinkedList) Global.mensajesPendientes.get(para);
    	    l.add("Alias"+de+":"+msg);
	    Global.mensajesPendientes.put(para,l);
	}
    }


    /** lee los mensajes que le han enviado a este usuario
      * y los elimina despues de leidos
      */
    public String leerPendientes(String alias){

	LinkedList lista = (LinkedList) Global.mensajesPendientes.get(alias);
	Iterator it = lista.iterator();
	String msg ="";
	String mensajes =null;
	int i=0;

	if ( lista.size() > 0 ){
	    while( it.hasNext() ){
		msg = (String) it.next();
		if ( i == 0)
		    mensajes = msg;
		else
		    mensajes = mensajes + "\n" + msg;
		i++;
	    }
	}
	lista.clear();	    
	Global.mensajesPendientes.put(alias,lista);
  	
	return mensajes; // si no hay mensajes pendietes
    }

}

/** Variables globales que permiten la comunicacion entre threads
  */
class Global {

    public static boolean verificacion = false;
    public static HashMap Suscriptores = new HashMap();
    public static HashMap mensajesPendientes = new HashMap();
}
