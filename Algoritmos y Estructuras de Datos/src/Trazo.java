/*
 * Autor: Carlos Chitty 07-41896
 */

import java.util.*;

class Trazo {

    static boolean existeAmarillo(GrafoNoDirigido g){

	Set vertices = g.vertices();
    	Iterator x = vertices.iterator();

	while(x.hasNext()) {

            String ident = (String) x.next();
	    Vertice ver = g.getVertice(ident);
	    if ( ver.peso == 1.0 ){
		return true;
	    }
	}
	return false;
    }

    static Vertice getAmarillo(GrafoNoDirigido g){

	Set vertices = g.vertices();
    	Iterator x = vertices.iterator();

	while(x.hasNext()) {

            String ident = (String) x.next();
	    Vertice ver = g.getVertice(ident);
	    if ( ver.peso == 1.0 ){
		return ver;
	    }
	}
	return null;
    }

    static Vertice vecino(Vertice ver, GrafoNoDirigido g){

	Vertice w = null;
	Set ady = g.adyacentes(ver.idVertice);
	Iterator y = ady.iterator();

	if ( y.hasNext() ){
	    String nombre = (String) y.next();
	    w = g.getVertice(nombre);
	}
	return w;
    }

    static void reordenar(LinkedList C,LinkedList V, String vert){

	Iterator x = V.iterator();
	String vertice ="";
	String ultimo ="";

	if( x.hasNext() ){

	    vertice = (String)x.next();
	    if( !vertice.equals(vert) ){
	    	V.remove(vertice);
		ultimo = (String) V.getLast();

	        if ( ultimo != vertice )
	    	    V.addLast(vertice);
		
	  	reordenar(C,V,vert);
            }
	}
    }

    static void camino(LinkedList C,LinkedList V, GrafoNoDirigido g){

	String vert1 = "", vert2="";
	Iterator x = V.iterator();
	C.clear(); 

	if ( x.hasNext() )
	    vert1 = (String)x.next();
	else return;

	while ( x.hasNext() ) {
	    vert2 = vert1;
	    vert1 = (String)x.next();
	    Set inciV1 = g.incidentes(vert1);
	    Set inciV2 = g.incidentes(vert2);
	    Iterator xx = inciV1.iterator();

	    while( xx.hasNext() ){
	
	 	String elem = (String)xx.next();
	 	if( inciV2.contains(elem) )    
	       	    C.add(elem);
	    }
	}
 
    }

    static void eliminarLado(String v, String w, GrafoNoDirigido g, LinkedList C){

	Iterator x = g.incidentes(v).iterator();
	Set incidentw = g.incidentes(w);
	String elem ="";

	while( x.hasNext() ){
	
	    elem = (String)x.next();
 	    if( incidentw.contains(elem) ) {       
       		C.add(elem);
       		g.eliminarArista(elem);
     	    }
	}	
    }

    static void print(LinkedList C){

	Iterator x = C.iterator();
	while( x.hasNext() ){
 	    System.out.print(x.next()+" ");
	}
 	System.out.println("");	
    }

    static void t(GrafoNoDirigido g) {

	GrafoNoDirigido grafo = g;
	GrafoNoDirigido original = g;
 	LinkedList C = new LinkedList();
 	LinkedList Vlist = new LinkedList();
 	LinkedList Cprime = new LinkedList();
	boolean gradoPar = true;
	Set vertices = grafo.vertices();
    	Iterator x = vertices.iterator();
	Vertice v = null;

	while(x.hasNext()) {
            String ident = (String) x.next();
	    Vertice ver = grafo.getVertice(ident);

            if ( (grafo.grado(ver) % 2) != 0 || grafo.grado(ver)==0 ){
		gradoPar = false;
 		break;
	    }
    	}

    	// Si G posee un ciclo euleriano el grado de todo vertice en G es par
	if ( gradoPar ){
	
	    // Colorear un vertice cualquiera de amarillo
	    Iterator z = vertices.iterator();
    	    if (z.hasNext()) {

                String id = (String) z.next();
	        v = grafo.getVertice(id);
		v.peso = 1.0; // 1.0 es amarillo
	    }
	  
	    while ( existeAmarillo(grafo) ){

		v=getAmarillo(grafo);

		if ( C.size()!=0 ){
	    	    reordenar(C,Vlist,v.idVertice); 
		}
		Cprime.clear();
		Vlist.add(v.idVertice);

		while( grafo.grado(v)!=0 ){

		    Vertice w = vecino(v,grafo);
		    Vlist.add(w.idVertice);
		    eliminarLado(v.idVertice,w.idVertice,grafo,Cprime);

		    if ( grafo.grado(w) <= 1 )
			w.peso = 2.0; // Colorear de rojo
		    else
			w.peso = 1.0; // Colorear de amarillo

		    v = w;
                    //print(Vlist);
  		}
		C.addAll(Cprime);
                
	    }
	    camino(C,Vlist,original);
	    System.out.print("Es posible: ");
	    print(C);

	} else {
	    System.out.println("No es posible!");
  	}
    }

}
