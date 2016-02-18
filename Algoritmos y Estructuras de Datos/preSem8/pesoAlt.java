import java.util.*;

class pesoAlt {

 private class infoPeso {
 
    String ident;
	double pesoId;
	
 public infoPeso(String v, double p) {
 
    ident = v;
	pesoId = p;
 }
 }
 
    private /*@ spec_public @*/ LinkedList infoPesos;
	
 public pesoAlt(Grafo g) {
 
    Set verts = g.vertices();
	infoPesos = new LinkedList();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verInf = (String) vertsIt.next();
		Vertice ver = g.getVertice(verInf);
		double newPeso = ver.peso;
		infoPeso x = new infoPeso(verInf,newPeso);
		infoPesos.add(x);
	}
 }
 
 public double getPesoAlt(String vert) {
 
    double key = 0.0;
	Iterator infoPesosIt = infoPesos.iterator();
	boolean esta = false;
	while(infoPesosIt.hasNext() && !esta) {
	
	    infoPeso x = (infoPeso) infoPesosIt.next();
		if(x.ident.equals(vert)) {
		
		    key = x.pesoId;
			esta = true;
		}
	}
	
	return key;
 }
 
 public static void main(String []args) {
 
 Grafo g = new GrafoDirigido(Console.readString("Archivo "));
 pesoAlt y = new pesoAlt(g);
 double test = y.getPesoAlt(Console.readString("Vertice "));
 System.out.println(test);
 }
}