import java.util.*;

public class Global {
    public static int i = 0;
}

class rutaExistente1 {

    static int match(int N, String Vertice, String V[]){

	for(int k=0; k<N; k++)
	    if ( V[k].equals(Vertice) )
		return k;

	return -1;
    }

    static void DFS(int j, int M[][], String V[], GrafoNoDirigido g){

	M[Global.i][j]=1;
	Set elem = g.adyacentes(V[j]);
	Iterator x = elem.iterator();
	int z=0;

	while ( x.hasNext() ){
	    String zz = (String) x.next();
	    z=match(11,zz,V);
	    
	    if ( M[Global.i][z]==0 )
		DFS(z,M,V,g);
	}
    }

    public static void main(String []args) {

	GrafoNoDirigido grafo = new GrafoNoDirigido(args[0]);
	Set numV = grafo.vertices();
	Iterator x = numV.iterator();
	int count=0;

	for ( ;x.hasNext();x.next() )
	    count++;

	System.out.println( count );

	String vertices[] = new String[count];
	int M[][] = new int[count][count] ;

	Iterator xx = numV.iterator();
	// Inicializacion de la matriz de adjacencias
	for ( int k=0; k<count; k++ )
	    for ( int j=0; j<count; j++ ){
		M[k][j]=0;
		vertices[k]=(String)xx.next();
	    }

	// Aplicar DFS a cada vertice del grafo
	for ( Global.i=0; Global.i<count; Global.i++ ){
	//    DFS(Global.i,M,vertices,grafo);
	}
    }
}
