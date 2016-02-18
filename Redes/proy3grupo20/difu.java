/**
 * Archivo: difu.java
 * <p>
 * Contiene el programa principal difu, este es el programa servidor
 * de la aplicacion difumensajes II, que hace posible la comunicacion
 * entre varios procesos usu. Esto gracias a la utilizacion de RMI
 * y la autenticacion de cada usuario mediante otra conexion RMI con
 * el servidor de autenticacion aute.
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class difu {


    /**
     * Constructor que crea su servicio de nombres para ser ubicado por los
     * clientes usu y asi establecer una conexion.
     * 
     * <p>
     * @param  p_difu  puerto del rmiregistry de difu
     * @param  p_aute  puerto del rmiregistry de aute
     * @param  host    host del rmiregistry de aute
     */
    public difu(int p_difu, int p_aute, String host) {
    	try {
  
      	    LocateRegistry.createRegistry(p_difu);
      	    difuInterfaz eldifu = new difuImpl(p_aute,host);
      	    Naming.rebind("rmi://localhost:"+p_difu+"/Service", eldifu);

    	} catch (Exception e) {
      	    System.out.println("Trouble: " + e);
    	}
    }


    /**
     * Programa principal que recibe los parametros pasados por linea de comandos, los
     * verifica para luego pasarlos al constructor difu para que establesca la conexion RMI
     * <p>
     * @param  args  parametros pasados por linea de comandos
     */
    public static void main(String args[]) {

	int puertodifu = 0; 
	int puertoaute = 0; 
	String host = "";

	// verificar que al programa se le pasaron la cantidad de parametros correctos
        if (args.length != 6) {
             System.out.println("Uso: java difu -l <puerto del rmiregistry de difu> -p <puerto del rmiregistry de aute> -h <host del rmiregistry de aute>");
             return;
        }

	// Extraer los valores pasados por linea de comando
	for(int i=0; i<args.length; i+=2){
	    if ( args[i].equals("-l") ){
		puertodifu = Integer.parseInt(args[i+1].trim());
	    } else if ( args[i].equals("-p") ){
		puertoaute = Integer.parseInt(args[i+1].trim());
	    } else if ( args[i].equals("-h") ){
		host = args[i+1];
	    } else {
	    	System.out.println("Uso: java difu -l <puerto del rmiregistry de difu> -p <puerto del rmiregistry de aute> -h <host del rmiregistry de aute>");
		return;
	    }
	}
	
    	new difu(puertodifu, puertoaute, host);
    }
}
