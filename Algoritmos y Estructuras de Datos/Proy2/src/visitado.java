import java.util.*;

public class visitado {

    private /*@ spec_public @*/ LinkedList vertices;
	
    public visitado(Set verts) {
	
	vertices = new LinkedList();
	Iterator vertsIt = verts.iterator(); 

	while(vertsIt.hasNext()) {
	    caja box = new caja((String) vertsIt.next(),false); 
	    vertices.add(box); 
	}
    }
	
    public boolean estaVisitado(String v) {
	
	Iterator verticesIt = vertices.iterator();
	boolean salida = false;
	
	while(verticesIt.hasNext()) {
	
	    caja box = (caja) verticesIt.next();
	    if(box.vert.equals(v)) 
		salida = box.estado;		
	}
	return salida;
    }
	    public void marcarVisitado(String v) {
	
	Iterator verticesIt = vertices.iterator();
	while(verticesIt.hasNext()) {
	
	    caja box = (caja) verticesIt.next();
	    if(box.vert.equals(v))
		box.estado = true;		
	}
    }	
}	
