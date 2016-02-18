import java.io.*;
import java.util.*;

class turistaDFS {

    public static void main(String []args) {

	String origen = (String) args[0];
	String destino = (String) args[1];
	String p = (String) args[2];
	String p2 = (String) args[3];

	double maxPerViaje = Double.parseDouble(p2);
	int tipo = 0;
	double presupuesto = Double.parseDouble(p);	
	GrafoDirigido g = new GrafoDirigido();

	try{
	    tipo = g.leerTipo(args[4]);
	} catch ( archivoInvalidoException e ){
	} catch ( IOException e ){
	}

	if (tipo == 0) 
	    clienteDFS.CrearGrafo(2, args[4], origen, destino, maxPerViaje, presupuesto);
	else if (tipo == 1)
	    clienteDFS.CrearGrafo(1, args[4], origen, destino, maxPerViaje, presupuesto);
	
    }
}	
