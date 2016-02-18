import java.util.*;

class apuntador {

    Nodo box;
	
    public apuntador(String v) {
	box = new Nodo(v,null);
    }
	
    public void apuntar(String v) {
	
	Nodo cage = new Nodo(v,box);
	box = cage;
    }
	
    public void apuntarEsp(String v,String v2) {
	
	Nodo a = box;
	boolean esta = false;
	while(a!=null && !esta) {
	
	    if(a.info.equals(v2)) {
		
		Nodo cage = new Nodo(v,a);
		box = cage;
		esta = true;
	    } else {
		a = a.apunta;
	    }
	}
    }
		
    public LinkedList mostrarDesde(String v) {
	
	Nodo a = box;
	boolean esta = false;
	while(a!=null && !esta) {
	
	    if(a.info.equals(v))
	        esta = true;
	    else 		
		a = a.apunta;		
	}
    
	Nodo b = a;
	LinkedList boxPList = new LinkedList();
	while(b!=null) {
	
	    boxPList.addFirst(b.info);
	    b = b.apunta;
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
