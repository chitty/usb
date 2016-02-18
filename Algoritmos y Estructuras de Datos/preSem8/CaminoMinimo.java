import java.util.*;

class CaminoMinimo {

 public static void AsigCostInic(Grafo grafo) {
  //8
    Set verts = grafo.vertices();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verInf = (String) vertsIt.next();
		grafo.getVertice(verInf).peso = 10000000.0;
	}
 }
 
 public static boolean ExistenAbiertos(Grafo grafo, visitado vis) {
 
    Set verts = grafo.vertices();
	Iterator vertsIt = verts.iterator();
	boolean esta = false;
	while(vertsIt.hasNext() && !esta) {
	
	    String vertInf = (String) vertsIt.next();
		if(!vis.estaVisitado(vertInf)) {
		
		    esta = true;
		}
	}
	return esta;
 }
 
 public static String VertMenorCost(Grafo grafo,visitado vis) {
 //8
    String key ="";
	Set verts = grafo.vertices();
	
	Iterator crack = verts.iterator();
	while(crack.hasNext()) {
	
	    String desprotector = (String) crack.next();
	    if(!vis.estaVisitado(desprotector)) {
		
	        key = desprotector;
	    }
	}
	
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String key2 = (String) vertsIt.next();
		Vertice vert1 = grafo.getVertice(key);
		Vertice vert2 = grafo.getVertice(key2);
		if(vert1.peso>=vert2.peso && !vis.estaVisitado(key2)) {
		
		    key = key2;
		}
	}
	
	return key;
 }

 public static void dijkstra(String vert, String vert2, Grafo grafo, int plataPC, int plata) {
 
    pesoAlt pesos = new pesoAlt(grafo);
    visitado vis = new visitado(grafo.vertices());
	apuntador ap = new apuntador(vert);
	AsigCostInic(grafo);
	Vertice x = grafo.getVertice(vert);
	x.peso = 0;
	String vert1;
	
	Set verts = grafo.vertices();
	System.out.println("");//8
	while(ExistenAbiertos(grafo,vis)) {

		
	    vert1 = VertMenorCost(grafo,vis); //n 
		vis.marcarVisitado(vert1); 
		Set sucs = ((GrafoDirigido) grafo).sucesores(vert1);
		Iterator vertsIt2 = sucs.iterator();
		while(vertsIt2.hasNext()) { //8
		
		    String vert2 = (String) vertsIt2.next(); //m
		    if(!vis.estaVisitado(vert2)) { //8
			
			    Vertice vert1Or = grafo.getVertice(vert1);
				Vertice vert2Or = grafo.getVertice(vert2);
				
				String ladInf = ((GrafoDirigido) grafo).getLadoId(vert1,vert2);
				Lado lad = grafo.getLado(ladInf);
				
				double pesoV1 = vert1Or.peso;
				double pesoV2 = vert2Or.peso;
				double pesoLad = lad.peso;

				if(pesoV1 !=0) {
				
				    pesoV1 = pesoV1 - pesos.getPesoAlt(vert1);
				}
				
				if(pesoV2>pesoV1 + pesoLad && pesoLad<=plataPC && pesoV1 + pesoLad + pesos.getPesoAlt(vert2) + pesos.getPesoAlt(vert1)<= plata) {
				
				    ap.apuntarEsp(vert2,vert1); 
					grafo.getVertice(vert2).peso = pesoV1 + pesoLad + pesos.getPesoAlt(vert1) + pesos.getPesoAlt(vert2); //mod
				}
			}
		}
	}
	
	LinkedList list = ap.mostrarDesde(vert2);
	
	if(list.size()!=0) {
    	System.out.println(list);      //imprime camino 
	
    	Set verts2 = grafo.vertices();
    	Iterator vertsIt = verts2.iterator();
	    boolean esta = false;	
	    double key = 0.0;
	    while(vertsIt.hasNext() && !esta) {  //imprime plata restante
	
    	    String verInf = (String) vertsIt.next();
    		if(verInf.equals(vert2)){
		
    		    Vertice ver = grafo.getVertice(verInf);
    			double key =  ver.peso;
    			mr.key = key;
    			System.out.println("Plata restante: "+(plata-key));
        		esta = true;
    	    }
		
		
		
		
	    }

    	Iterator listIt = list.iterator();
	    double key2 = 0.0;
	    while(listIt.hasNext()) {
	
	        String verInf = (String) listIt.next();
	    	Vertice ver = grafo.getVertice(verInf);
	    	key2 = key2 + pesos.getPesoAlt(verInf);
	    }
	
	    System.out.println("Costo de camino: "+(mr.key - key2));
	} else { System.out.println("No es posible ");}
 }
 
 public static void main(String []args) {
 
        GrafoDirigido grafo = new GrafoDirigido(args[4]);
	String vert = args[0];
	String vert2 = args[1];
	int plata = Integer.parseInt(args[2]);
	int plataPC = Integer.parseInt(args[3]);
    	
	dijkstra(vert,vert2,grafo,plataPC,plata);
	


 }
}

public class mr {

    public static double key;
}