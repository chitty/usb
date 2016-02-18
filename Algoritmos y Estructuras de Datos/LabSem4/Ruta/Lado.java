abstract class Lado {
 
    String ident;
    double peso;
    Vertice vert1;
    Vertice vert2;

    public Lado (String i,double p,Vertice v1,Vertice v2) {
   
  	ident = i;
  	peso = p;
	vert1 = v1;
	vert2 = v2;
    }
}
 
public static class Arco extends Lado {
 
    public Arco (String i,double p,Vertice v1,Vertice v2) {   
  	super(i,p,v1,v2);
    }
}
 
public static class Arista extends Lado {
 
    public Arista (String i,double p,Vertice v1,Vertice v2) {
  	super(i,p,v1,v2);
    } 
}

