import java.util.*;

public class BusqProf {

 public static boolean estanVisD(String v, GrafoDirigido g, visitado vis) {
	
	Set suc = g.sucesores(v);
	boolean esta = false;
	Iterator sucIt = suc.iterator();

	while(sucIt.hasNext()) {	
	    String inf = (String) sucIt.next();

	    if(vis.estaVisitado(inf))
		esta = true;		
	}	
	return esta;
    }

     public static LinkedList BusqProf(visitado vis, String vert, GrafoDirigido g, apuntador apun, Set verfic, Set ladfic,LinkedList C) {
	
	Set suc = g.sucesores(vert);
	Iterator sucIt = suc.iterator();
    	boolean esta = sucIt.hasNext();	
	

    	    while(sucIt.hasNext()) {
	
	        String vertSen = (String) sucIt.next(); 

		    String lad = g.getLadoId(vert,vertSen);
		    Arco lado = (Arco) g.getLado(lad);
		    g.eliminarArco(lad); // elimina el arco para que en llamadas recursivas no pase por ahi
		    apun.apuntarEsp(lad,vert);
                    apun.apuntarEsp(vertSen,lad);
		    LinkedList dum = BusqProf(vis,vertSen,g,apun,verfic,ladfic,C);
		    g.agregarArco(lado); // se agrega el arco eliminado, es necesario para otros caminos
		esta = sucIt.hasNext();
	    }
	
	LinkedList camino = apun.mostrarDesde(vert);
	if ( camino.size() > 1 )	
	    C.add( camino );

	return C;	
    }

	
     public static boolean NoEstanVisND(String v, GrafoNoDirigido g, visitado vis) {
	
	Set adys = g.adyacentes(v);
	boolean esta = false;
	Iterator adysIt = adys.iterator();
	while(adysIt.hasNext()) {
	
	    String inf = (String) adysIt.next();
	    if(!vis.estaVisitado(inf))
		esta = true;		
	}
	
	return esta;
    }	
	
	
     public static LinkedList BusqProfND(visitado vis, String vert, GrafoNoDirigido g, apuntador apun,Set verfic,Set ladfic,LinkedList C) {
	
	vis.marcarVisitado(vert);
	Set adys = g.adyacentes(vert); 
	Iterator adysIt = adys.iterator();
	
	if(NoEstanVisND(vert,g,vis)) {
	
	    while(adysIt.hasNext()) {
	
	    	String vertSen = (String) adysIt.next(); 

	    	if(!vis.estaVisitado(vertSen)) {
    		    String lad = g.getLadoId(vert,vertSen);
		    apun.apuntarEsp(lad,vert);
                    apun.apuntarEsp(vertSen,lad);
		    LinkedList dum = BusqProfND(vis,vertSen,g,apun,verfic,ladfic, C);
		} 
	    }
	}

	LinkedList camino = apun.mostrarDesde(vert);
	if ( camino.size() > 1 )	
	    C.add( camino );

	return C; 	
    }
}

public class global {

    public static String elem = "";
}
