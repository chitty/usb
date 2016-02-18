import java.util.*;

class apuntador {

    Nodo box;
    LinkedList listaBox;
	
    public apuntador(String v) {
	box = new Nodo(v,null);
	listaBox = new LinkedList();
	listaBox.add(box);
    }
	
    public void apuntar(String v) {
	
	Nodo cage = new Nodo(v,box);
	box = cage;
    }
	
    public void apuntarEsp(String v,String v2) {
	
	Iterator boxIt = listaBox.iterator();
	boolean esta = false;
	while(boxIt.hasNext() && !esta) {
	
	    Nodo boxSen = (Nodo) boxIt.next();
	    if(boxSen!=null){
		
		if(boxSen.info.equals(v2)) {
		
		    Nodo cage = new Nodo(v,boxSen);
		    listaBox.addFirst(cage);
		    esta = true;
	        }
	    }
	}
    }

	
    public  boolean estaApuntando(String v, String v2) {
	
	Nodo a = box;
	boolean esta = false;
	while(a!=null && !esta) {
	
	    if(a.info.equals(v)) {
		
	        if(a.apunta.info.equals(v2)) {
			
		    esta = true;
		}
	    }
	}
	
	return esta;
    }
		
    public LinkedList mostrarDesde(String v) {
	
	LinkedList boxPList = new LinkedList();
	Iterator boxIt = listaBox.iterator();
	boolean esta = false;
	while(boxIt.hasNext() && !esta) {
	
	    Nodo boxSen = (Nodo) boxIt.next();
	    if(boxSen!=null) {
		
		if(boxSen.info.equals(v)) {
		
	    	    while(boxSen!=null) {
			
		    	boxPList.addFirst(boxSen.info);
			boxSen = boxSen.apunta;
		    }
			
	    	    esta = true;
	    	}
	    }
	}
	
	return boxPList;
    }

	
    private class Nodo {

    	String info;
    	Nodo apunta;
   
   	public Nodo (String v, Nodo n) {
   
   	    info = v;
   	    apunta = n;
   	}
   }   

}
