import java.util.*;

class Grado {

 private class Contenedor {
 
    String vert;
	int grado;
	
	public Contenedor(String v, int g) {
	
	vert = v;
	grado = g;
	}
 }
 
 private /*@ spec_public @*/ LinkedList grados;
 
 public Grado(GrafoDirigido grafo) {
 
    grados = new LinkedList();
    Set verts = grafo.vertices();
	Iterator  vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verSen = (String) vertsIt.next();
		int GE = grafo.gradoExterior(verSen);
		Contenedor box = new Contenedor(verSen,GE);
		grados.add(box);
	}
 }
 
 public void modGrado(String v, int g) {
 
    Iterator gradosIt = grados.iterator();
    boolean esta = false;
    while(gradosIt.hasNext() && !esta) {
 
        Contenedor box = (Contenedor) gradosIt.next();
		if(box.vert.equals(v)) {
		
		    box.grado = g;
			esta = true;
		}
	}
 }
 
 public int getGrado(String v) {
 
    int k = 0;
    Iterator gradosIt = grados.iterator();
    boolean esta = false;
    while(gradosIt.hasNext() && !esta) {
 
        Contenedor box = (Contenedor) gradosIt.next();
		if(box.vert.equals(v)) {
		
		    k = box.grado;
			esta = true;
		}
	}
	return k;
 }
 
 /*public static void main (String []args) {
 
 GrafoDirigido grafo = new GrafoDirigido(Console.readString("Archivo: "));
 Grado grad = new Grado(grafo);
 int k = grad.getGrado("3");
 System.out.println(k);
 
 grad.modGrado("3",k-1);
 k = grad.getGrado("3");
 System.out.println(k);
 }*/
}
	