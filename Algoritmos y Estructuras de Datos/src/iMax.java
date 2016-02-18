/*
 * Autor: Carlos Chitty 07-41896
 */

import java.util.*;


class iMax {

    // Determina si hay o no elementos en comun
    static boolean elemEnComun(LinkedList A, Set B){

	Iterator x = A.iterator();

	while(x.hasNext()){
	    String dummy = (String) x.next();
	    if ( B.contains(dummy) )
		return true;
	}
	return false;
    }

    // Devuelve un elemento en comun
    static String getComun(LinkedList A, Set B){

	Iterator x = A.iterator();
	String dummy ="";

	while ( x.hasNext() ){
	    dummy = (String) x.next();
	    if ( B.contains(dummy) )
		return dummy;
	}
	return dummy;
    }

    // Devuelve un elemento en comun
    static Arista getNoComun(Set A, Set B){

	Iterator x = A.iterator();
	Iterator y = B.iterator();
	Vertice v = new Vertice(" ",0.0);
	Vertice v1 = new Vertice("",0.0);
	Arista dummy =new Arista("error",0.0,v,v1);
	
	while ( x.hasNext() ){
	    dummy = (Arista) x.next();
	    if ( !B.contains(dummy) ){
		return dummy;
	    }
	}
	if ( y.hasNext() )
	    return (Arista)y.next();

	System.out.println("falla");
	return dummy;
    }

    static GrafoNoDirigido Anexo(GrafoNoDirigido grafo) {

	//GrafoNoDirigido grafo = new GrafoNoDirigido(args[0]);
	Set numV = grafo.vertices();
	LinkedList I = new LinkedList();
	Iterator x = numV.iterator();
	String v = "";
	Set Adj = new HashSet();
	Set D = new HashSet();

	// Agregar a I todos los Vertices con grado impar
	while ( x.hasNext() ){
	    v = (String) x.next();
	    Vertice vert = grafo.getVertice(v);
	    if( (grafo.grado(vert) % 2) != 0 )
		I.addLast(v);
	}

	while( !I.isEmpty() ){

	    v = (String) I.getLast();
	    I.removeLast();
	    Adj = grafo.adyacentes(v);

	    if ( elemEnComun(I,Adj) ){

		String ex = getComun(I,Adj);
		System.out.println("En el if, v= "+v+", en comun: "+ex);
		Vertice i = grafo.getVertice(v);
		Vertice x = grafo.getVertice(ex);
		Arista a = new Arista("new"+v+ex,0.0,i,x);
		grafo.agregarArista(a);
		I.remove(ex);
		D.add(a);

	    } else {
		
		System.out.println("En el else... v= "+v);
		Set Inc = grafo.incidentes(v); // Conjunto de Aristas
	        Arista ex2 = getNoComun(Inc,D);
      		grafo.agregarArista(ex2);
		I.add(ex2.vert2.idVertice);
		D.add(ex2);
		
	    }

	}

	return grafo;
    }

    public static void main(String []args) {

	GrafoNoDirigido grafo = new GrafoNoDirigido(args[0]);
	
	// Crear todos los Vertices de grado par en el grafo
	grafo = Anexo(grafo);
	rutasMaximas.ruta(grafo);

    }
}
