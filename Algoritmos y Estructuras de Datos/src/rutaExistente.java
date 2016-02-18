import java.util.*;

public class Global {
    public static int i = 0;
}

class rutaExistente {

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

	String city1 = Console.readString("Ciudad 1: ");
	int f = obtenerValor(count,city1,vertices);
	String city2 = Console.readString("Ciudad 2: ");
	int c = obtenerValor(count,city2,vertices);

	if ( f!=-1 && c!=-1 && M[f][c] == 1 )
	    System.out.println("si.");
	else
	    System.out.println("no.");

    }
}
