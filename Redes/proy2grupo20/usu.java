/* 
 * Archivo: usu.java
 *
 * Contiene el programa principal usu, este es el programa cliente
 * de la aplicacion difumensajes, que permite la comunicacion entre
 * varios host a travez de un servidor (difu) 
 *
 * Autor: Carlos J. Chitty 07-41896
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class usu {

    public static void main(String[] args) throws IOException {

	String host = "";
	File archivo = null;
	int puerto = 0;
	StringTokenizer tokens = null;
	BufferedReader fileIN = null;
	boolean hayArchivo = false;

	// verificar que al programa se le pasaron los parametros correctos
        if (args.length != 4 && args.length != 6) {
             System.out.println("Uso: ./usu -h <host de difu> -p <puerto de difu> [-c <archivo de comandos>]");
             return;
        }

	// Extraer los valores pasados por linea de comando
	if ( args[0].equals("-h") )
	    host = args[1];
	else if ( args[0].equals("-p") )
	    puerto = Integer.parseInt(args[1].trim());
	else
	    return;	// si la entrada es mala salir

	if ( args[2].equals("-h") )
	    host = args[3];
	else if ( args[2].equals("-p") )
	    puerto = Integer.parseInt(args[3].trim());
	else
	    return;	// si la entrada es mala salir

	// ver si se paso algun archivo de comandos
	if ( args.length == 6 && args[4].equals("-c") ){
	    archivo = new File(args[5]);
	    fileIN = new BufferedReader( new FileReader(archivo) );
	    if ( archivo.exists() )
		hayArchivo = true;
	}


	int resp = 0;
	boolean failure = false;
        Socket usuSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
    	String login = null;
    	String secret = null;
    	String dummy = null;
	String comando = "";
        String fromServer;
        String fromUser;

	// Proceso de conexion
        try {
            usuSocket = new Socket(host, puerto);
            out = new PrintWriter(usuSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(usuSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: "+ host +".");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: "+ host +".");
            System.exit(1);
        }

	// una vez establecida la conexion el usuario debe identificarse para la autenticacion CHAP
	System.out.println("Identifiquese para ingresar al sistema.");
	while (login == null || secret == null){
	    comando = Console.readString("$");
	    tokens = new StringTokenizer(comando);
	    if(tokens.hasMoreTokens()){ 
		dummy =  tokens.nextToken().trim();
		if ( dummy.equals("l") && tokens.hasMoreTokens() )
		    login = tokens.nextToken().trim();
		else if ( dummy.equals("c") && tokens.hasMoreTokens() )
		    secret = tokens.nextToken().trim();
 	    }  
	}


	// leer el challenge y mandar el response
        if ((fromServer = in.readLine()) != null) {

	    try{ 
            	fromUser = MD5.md5(fromServer+secret); // envio el response
	    	if (fromUser != null)
                    out.println(fromUser +" "+ login);

	    } catch ( Exception e ){
		System.out.println("excepcion!");
	    }
        }

	// leer si hubo success o failure
        if ((fromServer = in.readLine()) != null) {
	    tokens = new StringTokenizer(fromServer);
	    resp = Integer.parseInt(fromServer);
	    // Usuario autenticado
	    if (resp == 3) {
                System.out.print("\nBienvenido al sistema!\n$ ");
	    // No se pudo autenticar
	    } else if (resp == 4){
		System.out.println("FAILURE!\nLogin y/o password incorrecto!"); 
		failure = true;
	    } else {
		System.out.println("Hubo un comportamiento inesperado en CHAP");
            	System.exit(1);
	    } 
        }

	// Si no se pudo autenticar, cerrar la conexion
	if (failure){
	    out.close();
            in.close();
            usuSocket.close();
	} else {

	    String mensaje ="";
	    char cmd='m';
	    boolean archivoNoLeido = true;
	    boolean imprimirPrompt = false;
	    InputStream teclado = System.in;

	    while(true){

	
		// ver si llego algun mensaje
		out.println("z");
		while ( in.ready() ){
		    fromServer = in.readLine();
		    System.out.println(fromServer);
		    fromServer = "";
		    imprimirPrompt = true;
		}

		if (imprimirPrompt){
		    System.out.print("$ ");
		    imprimirPrompt = false;
		}

		// Lectura de comandos de un archivo (si es que lo hay)
		if (hayArchivo && archivoNoLeido){
    		    if ( (dummy = fileIN.readLine()) != null){
       		    	tokens = new StringTokenizer(dummy);
		        imprimirPrompt = true;
		    }else
			archivoNoLeido = false;

		if (imprimirPrompt){
		    System.out.println("$ "+dummy);
		    imprimirPrompt = false;
		}

		// Lectura de comandos por teclado
		} else if ( teclado.available() > 0 ){
	    	    dummy = Console.readString();
		    tokens = new StringTokenizer(dummy);
                    imprimirPrompt = true;
		} else
		    dummy ="";

		if(tokens.hasMoreTokens()){
		    comando = tokens.nextToken().trim();
		    cmd = comando.charAt(0);
		}else
		    comando = "";


		// Comandos
	        if ( comando.equals("u") ) {
		    leerComando(cmd,"",null,out);
		} else if ( comando.equals("s") || comando.equals("d") ){
		    if(tokens.hasMoreTokens()){
		    	comando =  tokens.nextToken().trim();
			leerComando(cmd,comando,null,out);			
		    }else
			System.out.println("Comando Incompleto");

		// Enviar un mensaje
		} else if ( comando.equals("m") ){
		    if(tokens.hasMoreTokens()){
		    	comando =  tokens.nextToken().trim();
			// mensaje para todos los suscriptores
			if ( comando.charAt(0) == '#' ) {
			    mensaje = comando.substring(1,comando.length()); // mensaje
			    while( tokens.hasMoreTokens() )
				mensaje = mensaje + " " + tokens.nextToken().trim();
			    leerComando(cmd,mensaje,null,out);	

			// mensaje para algun usuario en particular
			} else if (tokens.hasMoreTokens()) {
			    String alias = comando.substring(0,comando.length()-1); //alias
			    mensaje = tokens.nextToken().trim();  // mensaje
			    while( tokens.hasMoreTokens() )
				mensaje = mensaje + " " + tokens.nextToken().trim();
			    leerComando(cmd,alias,mensaje,out);
			} else 
			    System.out.println("Comando imcompleto!");	
                    } else 
			System.out.println("Comando imcompleto!");			

		// Salir
	        } else if ( comando.equals("q") )
		    break;
	    }
	}

	// fin de ejecucion, cerrar conexion
        out.close();
       	in.close();
       	usuSocket.close();

    }


    /** ya esta garantizado que se ingreso un comando correctamente
      * ahora hacer pequeñas modificaciones para enviar la solicitud
      * del comando al servidor
      */
    public static void leerComando(char comando, String param1, String param2, PrintWriter out){

	String output = "";

	//Listar Usuarios
	if ( comando == 'u' ){ 
	    output = "u";

	// Suscribirse a mensajes
	}else if ( comando == 's' ) {
	    output = "s "+param1;
	
	// Desuscribirse a mensajes
	} else if ( comando == 'd' ) {
	    output = "d "+param1;

	// Enviar mensajes
	} else if ( comando == 'm' ) {
	    if ( param2 != null )
		output = "w "+param1+" "+param2;
	    else
		output = "m "+param1;		    
	}

	out.println(output);
    }

}
