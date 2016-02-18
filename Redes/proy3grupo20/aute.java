/**
 * Archivo: aute.java
 * <p>
 * Contiene el programa principal aute, este es el programa servidor
 * de autenticacion de la aplicacion difumensajes II, que hace posible
 * la autenticacion de diferentes usuarios en el sistema difu. Esto
 * gracias a la utilizacion de RMI como mecanismo de conexion
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import nanoxml.*;
import java.util.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class aute {


    /**
     * Constructor que crea su servicio de nombres para ser ubicado por el
     * cliente difu y asi establecer una conexion.
     * 
     * <p>
     * @param  puerto  puerto del rmiregistry de aute
     * @param  cuentas nombre del archivo de cuentas en formato xml
     */
    public aute(String cuentas, int puerto) {
    	try {

      	    LocateRegistry.createRegistry(puerto);
      	    auteInterfaz elaute = new auteImpl(cuentas);
      	    Naming.rebind("rmi://localhost:"+puerto+"/Autenticacion", elaute);

    	} catch (Exception e) {
      	    System.out.println("Trouble: " + e);
    	}
    }


    /**
     * Programa principal que recibe los parametros pasados por linea de comandos, los
     * verifica para luego pasarlos al constructor aute para que establesca la conexion RMI
     * <p>
     * @param  args  parametros pasados por linea de comandos
     */
    public static void main(String args[]) {

	int puerto = 0; 
	String host = "";
	String cuentas = "";

	// verificar que al programa se le pasaron la cantidad de parametros correctos
        if (args.length != 4) {
             System.out.println("Uso: java aute -l <puerto del rmiregistry de aute> -a <archivo de cuentas>");
             return;
        }

	// Extraer los valores pasados por linea de comando
	if ( args[0].equals("-l") && args[2].equals("-a") ){
	    puerto = Integer.parseInt(args[1].trim());
	    cuentas = args[3];

	} else if ( args[2].equals("-l") && args[0].equals("-a") ){
	    puerto = Integer.parseInt(args[3].trim());
	    cuentas = args[1];

	} else {
             System.out.println("Uso: java aute -l <puerto del rmiregistry de aute> -a <archivo de cuentas>");
             return;
	}

    	new aute(cuentas,puerto);
    }
}
