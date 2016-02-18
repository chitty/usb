/* 
 * Archivo: difu.java
 *
 * Contiene el programa principal difu, este es el programa servidor
 * de la aplicacion difumensajes, que hace posible la comunicacion
 * entre varios procesos usu. Esto gracias a la utilizacion de 
 * threads en el programa difuThread.
 *
 * Autor: Carlos J. Chitty 07-41896
 */

import nanoxml.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class difu { 
    public static void main(String[] args)  {

	int puerto = 0;
	String cuentas = "";
	XMLElement xml = new XMLElement();
        ServerSocket serverSocket = null;
	Socket clientSocket = null;

	// verificar que al programa se le pasaron los parametros correctos
        if (args.length != 4 && args.length != 2) {
             System.out.println("Uso: ./difu -l <puerto de difu> [-a <archivo de cuentas>]");
             return;
        }

	// Extraer los valores pasados por linea de comando
	if ( args[0].equals("-l") )
	    puerto = Integer.parseInt(args[1].trim());
	else {
             System.out.println("Uso: ./difu -l <puerto de difu> [-a <archivo de cuentas>]");
             return;
        }

	// revisar si se paso algun archivo de cuentas
        if (args.length == 4) {
	    if ( args[2].equals("-a") ){
	    	cuentas = args[3];
		try{
	    	    xml = funcionesXML.XML(cuentas);
		} catch(Exception e) {
            	    System.err.println("Error al leer el archivo de cuentas "+ cuentas +"!");
            	    System.exit(1);
		}
	    } else
	    	System.out.println("Para especificar un archivo de cuentas usar '-a' y no '"+ args[2] +"'");
        }

	// Proceso de conexion
        try {
            serverSocket = new ServerSocket(puerto);

	    while(true){
        	try {
            	    clientSocket = serverSocket.accept();
        	} catch (IOException e) {
            	    System.err.println("Accept failed.");
            	    System.exit(1);
        	}

		// dejar que un thread maneje la conexion
      		difuThread user = new difuThread(xml, serverSocket, clientSocket);            
	    	user.start();
	    }
        } catch (IOException e) {
            System.out.println("Error: "+ e +".");
            System.exit(1);
        }

    }
}
