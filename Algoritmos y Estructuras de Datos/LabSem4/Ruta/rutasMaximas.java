import java.util.*;

public class Global {
    public static int i = 0;
}

class rutasMaximas {

    static void DFS(int N, int j, int M[][], String V[], GrafoNoDirigido g){

	M[Global.i][j]=1;
	Set elem = g.adyacentes(V[j]);
	Iterator x = elem.iterator();
	int z=0;

	while ( x.hasNext() ){
	    String zz = (String) x.next();
	    z = obtenerValor(N,zz,V); 
	
	    if ( z!=-1 && M[Global.i][z]==0 )
		DFS(N,z,M,V,g);
	}
    }

    static int obtenerValor(int N, String Vertice, String V[]){

	for(int k=0; k<N; k++)
	    if ( V[k].equals(Vertice) )
		return k;

	return -1;
    }

    public static void main(String []args) {

	GrafoNoDirigido grafo = new GrafoNoDirigido(args[0]);
	Set numV = grafo.vertices();
	Iterator x = numV.iterator();
	int count=0;

	for ( ;x.hasNext();x.next() )
	    count++;

	String vertices[] = new String[count];
	int M[][] = new int[count][count] ;

	Iterator xx = numV.iterator();
	// Inicializacion de la matriz de adjacencias
	for ( int k=0; k<count; k++ ){
	    vertices[k]=(String)xx.next();
	    for ( int j=0; j<count; j++ )
		M[k][j]=0;
	}

	// Aplicar DFS a cada vertice del grafo
	for ( Global.i=0; Global.i<count; Global.i++ ){
	    DFS(count,Global.i,M,vertices,grafo);
	}

	boolean indicador = false;
	int ruta=0;
	Set conjunto = new HashSet();
	LinkedList l = new LinkedList();
	// Recorrer la matriz en busca de 1
	for ( int k=0; k<count; k++ ){
	    for ( int j=0; j<count; j++ ){
		if ( M[k][j]==1 && !conjunto.contains(vertices[j]) ){
		//    System.out.print(":"+vertices[j]+", ");
		    l.addLast(vertices[j]);
		    conjunto.add(vertices[j]);
		    indicador=true;
		}
	    }
	    if (indicador){
		ruta++;
	    	System.out.print("Ruta "+ruta+": { ");
		Iterator xl = l.iterator();
		while ( xl.hasNext() )
		    System.out.print( (String)xl.next()+", " );
		System.out.println("}");
	    }
	    l.clear();
	    indicador = false;
	}
	

    }
}
