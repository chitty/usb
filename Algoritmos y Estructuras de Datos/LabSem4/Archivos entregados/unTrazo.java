import java.util.*;

class unTrazo {

 public static void unTrazo(GrafoNoDirigido grafo) {
 
   LinkedList camino = new LinkedList();
   LinkedList caminovert = new LinkedList();
   Set verts = grafo.vertices();
   boolean impar = false;
   int cont = 0;
   Vertice vertic = null;
   Vertice vertic3 = null;
   Iterator vertsi = verts.iterator();
   boolean crack = true;
   boolean crack2 = true;
   
   while(vertsi.hasNext() && cont <= 2) {  
       
	   String idvertic = (String) vertsi.next();
       Vertice vert = grafo.getVertice(idvertic);
       int grd = grafo.grado(vert);

    if(grd % 2 != 0) {
	
	    if(crack && crack2) {
        vertic = vert; 
		if(crack2) {
		 vertic3 = vert;
		 }
		crack2 = false;
        } 
	
        if(grafo.grado(vertic) == 1) {
        crack = false;
        } 	
        cont++;
    }
     }
 
    if(cont>2) { impar = true;}
 
    if(!impar) {

        boolean estado = true;

    if(cont==0) {
    
       Set verts2 = grafo.vertices();
       Object[] elems = verts2.toArray();
       String elem = (String) elems[0];
       vertic = grafo.getVertice(elem);
    }
    
    Vertice verticprin = vertic;
	   
    while(estado) {
	   
       caminovert.addLast(vertic.idVertice);  
       Set ady = grafo.adyacentes(vertic.idVertice);  
       Object[] adyi = ady.toArray(); 
       String idver = (String) adyi[0];
       Vertice vertic2 = grafo.getVertice(idver);

       Set incidVertic = grafo.incidentes(vertic.idVertice);
       Set incidVertic2 = grafo.incidentes(vertic2.idVertice);
       Iterator x = incidVertic.iterator();
       boolean est=  false;
    
    while(x.hasNext() && !est) {

       String idver = (String) x.next();
       if(incidVertic2.contains(idver)) {
       
           camino.addLast(idver); 
           grafo.eliminarArista(idver);
           est = true; 
        }
    }    

 
    if((verticprin.idVertice.equals(vertic2.idVertice) && grafo.grado(vertic2)==0) && grafo.vertices().size()>2) {
	
	    Set vertgraf = grafo.vertices();
	    Iterator y = caminovert.iterator();
	
	    boolean estt = false;
	
	while(y.hasNext() && !estt ) {
	 
	    String lad = (String) camino.getLast();
	    camino.addFirst(lad);
	    camino.removeLast();
	    String vert = (String)caminovert.getLast();
	 
	if(vertgraf.contains(vert)) {
	   
 	   estt = true;
	   vertic = grafo.getVertice(vert); 
	} else {
	   camino.addFirst(vert); 
	   camino.removeLast();
	   
       }
    }
    } else if(!verticprin.idVertice.equals(vertic2.idVertice) && grafo.grado(vertic2)==0) {
	
	vertic = vertic3;
	LinkedList newlista = new LinkedList();
	
	while(camino.size()!=0) {
	String obj= (String) camino.getLast();
	newlista.addLast(obj);
	camino.removeLast();
	}
	camino = newlista;
	
	}
	
	else { vertic = vertic2;}
	
	Set g = grafo.vertices();
	Iterator gi = g.iterator();
	
	while(gi.hasNext()) {
	 
	    String idv = (String) gi.next();
	    if(grafo.grado(grafo.getVertice(idv)) == 0) {
	        grafo.eliminarVertice(idv);
	    }
	}
	
   
    if(grafo.vertices().size() ==0) { estado = false;}

    } } else {System.out.println("no es posible");}

    Iterator t = camino.iterator();
    
   	while(t.hasNext()) {
  
       System.out.println(t.next());
    }
 }
 
 public static void main (String []args) {
 
     GrafoNoDirigido g = new GrafoNoDirigido(Console.readString("Archivo: "));
	 unTrazo(g);
 }
}