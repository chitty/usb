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
//888
     public static LinkedList BusqProf(visitado vis, String vert, GrafoDirigido g, apuntador apun, Set verfic, Set ladfic,LinkedList C,double costo,double presupuestoPC,double presupuesto, String vert3) {
	
	vis.marcarVisitado(vert);
	Set suc = g.sucesores(vert);
	Iterator sucIt = suc.iterator();
    boolean esta = sucIt.hasNext();	//88888
		
	//costo = costo + g.getVertice(vert).peso; 
		
	if(esta) {
	
    	    while(sucIt.hasNext()) {
	
	        String vertSen = (String) sucIt.next(); //8888
			
	    String ladoInfo = g.getLadoId(vert,vertSen);
            double pesoVertSen = g.getVertice(vertSen).peso;
            double pesoLado = g.getLado(ladoInfo).peso; 
			if(vert.equals(global.elem)) { costo = 0;}
            if(!vis.estaVisitado(vertSen)) {costo = costo + pesoLado + g.getVertice(vert).peso;} //99999
            System.out.println(costo+" "+vert+"  "+vertSen);

	        if(!vis.estaVisitado(vertSen) && g.getLado(ladoInfo).peso<=presupuestoPC && costo+pesoVertSen<=presupuesto) {
		    String lad = g.getLadoId(vert,vertSen);
		    apun.apuntarEsp(lad,vert);
                    apun.apuntarEsp(vertSen,lad);
		    LinkedList dum = BusqProf(vis,vertSen,g,apun,verfic,ladfic,C,costo,presupuestoPC,presupuesto,vert3); 
		}
		esta = sucIt.hasNext();
	    }
	}
	
	//8888
	String info = (String) apun.mostrarDesde(vert).getLast();
    if(info.equals(vert3)) {
		
	    LinkedList camino = apun.mostrarDesde(vert);
	
    	global.presupuestoRestante = presupuesto - costo; //888
	
    	if ( camino.size() > 1 )	
	        C.add( camino );}

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
	
	
     public static LinkedList BusqProfND(visitado vis, String vert, GrafoNoDirigido g, apuntador apun,Set verfic,Set ladfic,LinkedList C, double costo, double presupuestoPC, double presupuesto, String vert3) {
	
	vis.marcarVisitado(vert);
	Set adys = g.adyacentes(vert); 
	Iterator adysIt = adys.iterator();
	
	//costo = costo + g.getVertice(vert).peso; 
	
	if(NoEstanVisND(vert,g,vis)) {
	
	    while(adysIt.hasNext()) {
	
	    	String vertSen = (String) adysIt.next(); //9999

			String ladoInfo = g.getLadoId(vert,vertSen);
            double pesoVertSen = g.getVertice(vertSen).peso;
            double pesoLado = g.getLado(ladoInfo).peso; 
			if(vert.equals(global.elem)) { costo = 0;}
            if(!vis.estaVisitado(vertSen)) {costo = costo + pesoLado + g.getVertice(vert).peso;} //99999
            System.out.println(costo+" "+vert+"  "+vertSen);
			
	    	if(!vis.estaVisitado(vertSen) && g.getLado(ladoInfo).peso<=presupuestoPC && costo+pesoVertSen<=presupuesto) {
    		    String lad = g.getLadoId(vert,vertSen); 
		    apun.apuntarEsp(lad,vert);
                    apun.apuntarEsp(vertSen,lad);
		    LinkedList dum = BusqProfND(vis,vertSen,g,apun,verfic,ladfic, C,costo,presupuestoPC,presupuesto,vert3);
		} 
	    }
	}
	
	
    String info = (String) apun.mostrarDesde(vert).getLast(); //999999
    if(info.equals(vert3)) {

	LinkedList camino = apun.mostrarDesde(vert);
	
	global.presupuestoRestante = presupuesto - costo; //99999
	if ( camino.size() > 1 )	
	    C.add( camino ); }

	return C; 	
    }
}

public class global {

    public static String elem = "";
	public static double presupuestoRestante = 0.0;//8888
	public static Grafo g;
	public static double presupuestoSen;
}
