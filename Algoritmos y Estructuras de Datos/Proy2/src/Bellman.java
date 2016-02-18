import java.util.*;

class Bellman {

    private /*@ spec_public @*/ LinkedList SecCritica;
    private /*@ spec_public @*/ HashSet Secuencias;
    private /*@ spec_public @*/ GrafoDirigido grafo;
    private /*@ spec_public @*/ String v;
    private /*@ spec_public @*/ pesoAlt TEC;
    private /*@ spec_public @*/ String glob_suc;

	
 /**constructor bellman, se ejecuta el algoritmo bellman*/		
	
    public Bellman(GrafoDirigido g, String vert2) {
 
    	grafo = g;
    	v = vert2;
	glob_suc ="";
 
    	Set keys = new HashSet(); // T
	
	keys.add(v);
	Vertice ver = grafo.getVertice(v);
	ver.peso = 0;
	
	Set verts = grafo.vertices();                // se ponen los infinitos
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verSen = (String) vertsIt.next();
	    if(!verSen.equals(v)) {
		
		ver = grafo.getVertice(verSen);
		ver.peso = 70000000.0;
	    }
	}
	
	Grado grad = new Grado(grafo);
	apuntador ap = new apuntador(v);
	
	while(keys.size()!=0) {
	
	    String vert = ""; //n
	    Iterator keysIt = keys.iterator();

	    if(keysIt.hasNext())
		vert = (String) keysIt.next();
				
	    Vertice ver2 = grafo.getVertice(vert); //n
		
	    keys.remove(vert);
		
	    Set sucs = grafo.sucesores(vert);
	    Iterator sucsIt = sucs.iterator();
	    while(sucsIt.hasNext()) {
		
		String suc = (String) sucsIt.next();  //m
		glob_suc = suc;
			
		int gradAlt = grad.getGrado(suc);
		grad.modGrado(suc,gradAlt - 1);
		gradAlt = grad.getGrado(suc);

		if(gradAlt == 0)	
		    keys.add(suc);	

		ver = grafo.getVertice(suc); //m
		String ladInfo = grafo.getLadoId(vert,suc);
		Lado lad = grafo.getLado(ladInfo);
			
		if(ver.peso > ver2.peso + lad.peso) {
		
		    ver.peso = ver2.peso + lad.peso;
		    ap.apuntarEsp(suc,vert); 
		}
	    }		
	}

	verts = grafo.vertices();                // se almacenan todos los caminos
	vertsIt = verts.iterator();
	SecCritica = ap.mostrarDesde(glob_suc); 
	int max = 0;
	if ( SecCritica.contains("sen") && SecCritica.contains("sen2") )
	    max = SecCritica.size()-2;
	else if ( SecCritica.contains("sen") || SecCritica.contains("sen2") )
	    max = SecCritica.size()-1;
	else
	    max = SecCritica.size();
	Secuencias = new HashSet();
	while(vertsIt.hasNext()) {
	
	    String vertSen = (String) vertsIt.next();
	    SecCritica = ap.mostrarDesde(vertSen);

	    if ( SecCritica.contains("sen") )
	        SecCritica.remove("sen");
	    if ( SecCritica.contains("sen2") )
	        SecCritica.remove("sen2");

	    if ( SecCritica.size()==max )
	    	Secuencias.add(SecCritica);
	}

	TEC = new pesoAlt(grafo);
	SecCritica = ap.mostrarDesde(glob_suc); 
	
    }
	
	
  /** Retorna un tipo pesoAlt que contiene los TECs asociado a cada vertice*/	
 
    public pesoAlt getTECs() {
 
    	return TEC;
    }
	
	
  /** Retorna las secuencias de caminos criticos correspondientes a grafo*/
 
    public LinkedList getSecuenciaC() { 
    	return SecCritica;
    }
	
	
 /** Retorna todas las secuencias de caminos criticos correspondientes a grafo*/

    public HashSet getSecuenciaS() { 
    	return Secuencias;
    }
	
	
  /** Retorna el grafo utilizado en el algoritmo de bellman, con todas sus modificaciones*/
 
    public GrafoDirigido getGrafo() {
 
    	return grafo;
    }
}
