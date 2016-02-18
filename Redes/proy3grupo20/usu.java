/** 
 * Archivo: usu.java
 * <p>
 * Contiene el programa principal usu, este es el programa cliente de la
 * aplicacion difumensajes II, que permite la comunicacion entre varios
 * host a travez de un servidor (difu) utilizando RMI.
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import java.io.*;
import java.util.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class usu {

    /**
     * Programa principal usu donde se llevan a cabo todas las operaciones del
     * cliente la conexion a difu mediante RMI y la invocacion remota de metodos
     * <p>
     * @param  args  parametros pasados por linea de comandos
     */
    public static void main(String[] args) {

    	String login = null;
    	String secret = null;
    	String dummy = null;
	String comando = "";
	String host = "";
	String response = "";
	String mensaje = null;
	int puerto = 0;
	long challenge;
	boolean usuarioAutenticado = false;
	boolean archivoNoLeido = true;
	boolean imprimirPrompt = false;
	boolean hayArchivo = false;
	boolean loginListo = false;
	boolean claveLista = false;
	File archivo = null;
	BufferedReader fileIN = null;
	StringTokenizer tokens = null;
	InputStream teclado = System.in;

	// verificar que al programa se le pasaron la cantidad de parametros correctos
        if (args.length != 4 && args.length != 6) {
             System.out.println("Uso: usu -h <host del rmiregistry de difu> -p <puerto del rmiregistry de difu> [-c <archivo de comandos>]");
             return;
        }

	// Extraer los valores pasados por linea de comando
	for(int i=0; i<args.length; i+=2){
	    if ( args[i].equals("-h") ){
		host = args[i+1];
	    } else if ( args[i].equals("-p") ){
		puerto = Integer.parseInt(args[i+1].trim());
	    } else if ( args[i].equals("-c") && args.length == 6 ){
		archivo = new File(args[i+1]);
		try{
		    if ( archivo.exists() )
	            	fileIN = new BufferedReader( new FileReader(archivo) );
		    else
			System.out.println("El archivo "+archivo+" no existe!");
		}catch(FileNotFoundException fnfe){}

	        if ( archivo.exists() )
		    hayArchivo = true;
	    } else {
	    	System.out.println("Uso: usu -h <host del rmiregistry de difu> -p <puerto del rmiregistry de difu> [-c <archivo de comandos>]");
		return;
	    }
	}

	// intentar conectarse a difu
        try {

            difuInterfaz dif = (difuInterfaz) 
	    Naming.lookup("rmi://"+host+":"+puerto+"/Service");
 
	    // ciclo infinito para leer comandos
	    while(true){

		/** 
		 * autenticar a un usuario que ingreso su login y clave
		 */
		if ( !usuarioAutenticado && loginListo && claveLista ){

		    // recibe el challenge de aute a travez de difu
	    	    challenge = dif.enviarChallenge(login);

	    	    try{
	    		response = MD5.md5(challenge+secret);
	   	    }catch (Exception e){
			System.err.println("Error de la funcion MD5!");
			System.exit(1);
	   	    }

	    	    usuarioAutenticado = (dif.response(response) == 3);

	    	    // usuario no autenticado, mostrar mensaje 
	    	    if ( !usuarioAutenticado )
			System.out.println("Login y/o clave invalido!");
		    else
			System.out.println("Bienvenido al sistema"); 

  		    if ( !hayArchivo || !archivoNoLeido)
			System.out.print("$ ");

		    loginListo = false;
		    claveLista = false;

		// revisar mensajes pendientes, solo si el usuario esta autenticado
		} else if( usuarioAutenticado ) {
		    mensaje = dif.llegoMensaje();
		    if (mensaje != null)
			System.out.println(mensaje);
		}
			

		if (imprimirPrompt){
		    System.out.print("$ ");
		    imprimirPrompt = false;
		}

  		try{
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
		    // usuario no autenticado por lo tanto hay que esperar por algun comando
		    } else if ( !usuarioAutenticado ){
	    	    	dummy = Console.readString("$");
		    	tokens = new StringTokenizer(dummy);

		    // Lectura de comandos por teclado no bloqueante
		    } else if ( teclado.available() > 0 ){
	    	    	dummy = Console.readString();
		    	tokens = new StringTokenizer(dummy);
                    	imprimirPrompt = true;

		    } else
		    	dummy ="";

  		}catch (IOException e){
		    System.out.println("Error leyendo el archivo de comandos: "+e);
  		}

		if(tokens.hasMoreTokens())
		    comando = tokens.nextToken().trim();
		else
		    comando = "";

		// lectura de comandos
	        if ( comando.equals("l") ) {
		    // leer el login si el usuario no esta autenticado
		    if (!usuarioAutenticado){
		    	if(tokens.hasMoreTokens()){
		    	    login = tokens.nextToken().trim();
			    loginListo = true;						
		    	}else
			    System.out.println("Comando Incompleto");
		    } else
			System.out.println("login ignorado, usted ya esta autenticado!");
		    
	        } else if ( comando.equals("c") ) {
		    // leer la clave si el usuario no esta autenticado
		    if (!usuarioAutenticado){
		    	if(tokens.hasMoreTokens()){
		    	    secret = tokens.nextToken().trim();
			    claveLista = true;						
		    	}else
			    System.out.println("Comando Incompleto");
		    } else
			System.out.println("clave ignorada, usted ya esta autenticado!");
		    
	        } else if ( comando.equals("a") ) {
		    // mostrar usuarios conectados y autenticados
		    if (usuarioAutenticado){
		    	System.out.println("\tUSUARIOS CONECTADOS Y AUTENTICADOS\n");
		    	System.out.println( dif.mostrarConectados() );
		    } else
			System.out.println("Debe autenticarse primero, para poder ver quien esta conectado!");

		} else if ( comando.equals("f") ) {
		    // mostrar usuarios no conectados y/o no autenticados
		    if (usuarioAutenticado){
		    	System.out.println("\tUSUARIOS NO CONECTADOS Y/O NO AUTENTICADOS\n");
		    	System.out.println( dif.mostrarNoConectados() );
		    } else
			System.out.println("Debe autenticarse primero, para poder ver quien no esta conectado!");
 
		} else if ( comando.equals("x") ) {
		    // cerrar la autenticacion de la cuenta
		    if (usuarioAutenticado){
		    	dif.cerrarAute();
		    	usuarioAutenticado = false;
			imprimirPrompt = false;
		    } else
			System.out.println("Para cerrar su autenticacion debe primero estar conectado y autenticado!");

		}else if ( comando.equals("s") ){
		    // suscrubirse al usuario 'comando'
		    if (usuarioAutenticado){
		    	if(tokens.hasMoreTokens()){
		    	    comando =  tokens.nextToken().trim();
			    dif.suscribirseA(comando);						
		    	}else
			    System.out.println("Comando Incompleto");
		    } else
			System.out.println("Para suscribirse a algun usuario debe primero estar conectado y autenticado!");
	
		} else if ( comando.equals("d") ){
		    // desuscrubirse del usuario 'comando'
		    if (usuarioAutenticado){
		    	if(tokens.hasMoreTokens()){
		    	    comando =  tokens.nextToken().trim();
			 //   dif.suscribirseA(comando,login);						
		    	}else
			    System.out.println("Comando Incompleto");
		    } else
			System.out.println("Para desuscribirse de algun usuario debe primero estar conectado y autenticado!");
		
		} else if ( comando.equals("m") ){
		    // Enviar un mensaje	
		    if (usuarioAutenticado){

		        if(tokens.hasMoreTokens()){
		    	    comando =  tokens.nextToken().trim();
			    // mensaje para todos los suscriptores
			    if ( comando.charAt(0) == '#' ) {
			    	mensaje = comando.substring(1,comando.length()); // mensaje
			    	while( tokens.hasMoreTokens() )
				    mensaje = mensaje + " " + tokens.nextToken().trim();
			    	dif.Mensaje(mensaje);

			    // mensaje para algun usuario en particular
			    } else if (tokens.hasMoreTokens()) {
			    	String alias = comando.substring(0,comando.length()-1); //alias
			    	mensaje = tokens.nextToken().trim();  // mensaje
			    	while( tokens.hasMoreTokens() )
				    mensaje = mensaje + " " + tokens.nextToken().trim();
			    	dif.MensajeParticular(mensaje,alias);
			    } else 
			    	System.out.println("Comando imcompleto!");	
			    	
		    	} else 
			    System.out.println("Comando imcompleto!");
	
		    } else
			System.out.println("Mensaje no enviado, usuario no autenticado!");
		

		// Salir
	        } else if ( comando.equals("q") ){
		    dif.cerrarAute();
		    usuarioAutenticado = false;
		    break;
		}

	    } // fin del ciclo
	 
	// capturar posibles excepciones de la conoexion RMI
        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException: "+murle);
        } catch (RemoteException re) {
            System.out.println("RemoteException: "+re);
        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException: "+nbe);
        }
    }
}
