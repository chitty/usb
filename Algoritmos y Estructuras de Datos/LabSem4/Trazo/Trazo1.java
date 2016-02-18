import java.util.*;

class Trazo1 {

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
	    System.out.println("vecino-Vertice:"+nombre );
	    w = g.getVertice(nombre);
	}
	return w;
    }

    static void reordenar(LinkedList C,LinkedList V, String vert){

//	System.out.println("re-ORDENAR!");

	Iterator x = V.iterator();
	Iterator xx = C.iterator();
	String vertice ="";
	String arista ="";
	LinkedList V2 = V;

	while ( !vertice.equals(vert) ){
	  if( x.hasNext() && xx.hasNext() ){

	    vertice = (String)x.next();
	    arista = (String)xx.next();
		System.out.println("fuck				");
	    V2.remove(vertice);
	    V2.addLast(vertice);
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

    public static void main(String []args) {

	GrafoNoDirigido grafo = new GrafoNoDirigido(args[0]);
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
		Vlist.add(v.idVertice);

		if ( C.size()!=0 ){
	    	    reordenar(C,Vlist,v.idVertice); //************FALTA HACER BIEN EL REORDENAMIENTO!!!!!!!!
		}
		Cprime.clear();

		while( grafo.grado(v)!=0 ){

		    Vertice w = vecino(v,grafo);
		    Vlist.add(w.idVertice);
		    eliminarLado(v.idVertice,w.idVertice,grafo,Cprime);

		    if ( grafo.grado(w) <= 1 )
			w.peso = 2.0; // Colorear de rojo
		    else
			w.peso = 1.0; // Colorear de amarillo

		    v = w;
                    print(Vlist);
  		}
		C.addAll(Cprime);
                print(C);
	    }

	} else {
	    System.out.println("No es posible!");
  	}
    }

}
