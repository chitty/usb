import java.util.*;
import java.io.*;

 public class glob {
  
    public static LinkedList caminos = new LinkedList();
 }


class caminoFloyd {

 public static void AsignarNumeros(Grafo grafo) {    //numero que identifica a cada vert en la matriz

    double cont = 0;
    Set verts = grafo.vertices();
    Iterator vertsIt = verts.iterator();
    while(vertsIt.hasNext()) {

        Vertice verSen = grafo.getVertice((String) vertsIt.next());
        verSen.peso = cont;
        cont++;
    }
 }
 
 public static String getVertConPeso(double pes, Grafo grafo) {

    Set verts = grafo.vertices();
    Iterator vertsIt = verts.iterator();
    String infoVert = "";
    boolean esta = false;
    while(vertsIt.hasNext() && !esta) {

        Vertice verSen = grafo.getVertice((String) vertsIt.next());
        if(verSen.peso == pes) {
        
            infoVert = verSen.idVertice;
            esta = true;
        }
     }
 
     return infoVert;
 }

 public static int[][] obtenerMatrizD(Grafo grafo) {

    AsignarNumeros(grafo);

    int tam = grafo.vertices().size();
    int[][] M = new int[tam][tam];

    for(int p = 0; tam>p; p++){

        for(int q = 0;tam>q;q++){

            if(p == q) {

                M[p][q] = 0;
            } else {

                String ver1 = getVertConPeso((double) p,grafo);
                String ver2 = getVertConPeso((double) q,grafo);
                Set sucs = ((GrafoDirigido) grafo).sucesores(ver1);
                if(sucs.contains(ver2)) {

                    String ladInf = ((GrafoDirigido) grafo).getLadoId(ver1,ver2);
                    Lado lad = ((GrafoDirigido) grafo).getLado(ladInf);
                    M[p][q] = (int) lad.peso;

                } else {
            
                M[p][q] =(int)  700000.0;
                }
            }
         }
      }

      return M;
 }
 
 public static int[][] obtenerMatrizND(Grafo grafo) {

    AsignarNumeros(grafo);

    int tam = grafo.vertices().size();
    int[][] M = new int[tam][tam];

    for(int p = 0; tam>p; p++){

        for(int q = 0;tam>q;q++){

            if(p == q) {

                M[p][q] = 0;
            } else {

                String ver1 = getVertConPeso((double) p,grafo);
                String ver2 = getVertConPeso((double) q,grafo);
                Set sucs = grafo.adyacentes(ver1);
                if(sucs.contains(ver2)) {

                    String ladInf = ((GrafoNoDirigido) grafo).getLadoId(ver1,ver2);
                    Lado lad = ((GrafoNoDirigido) grafo).getLado(ladInf);
                    M[p][q] = (int) lad.peso;

                } else {
            
                M[p][q] =(int)  700000.0;
                }
            }
         }
      }

      return M;
 }

 public static void mostrar(int[][] M,int tam) {

    for(int p = 0; tam>p;p++){

        String crack = " ";
        for(int q = 0; tam>q; q++){

            crack = crack+" "+M[p][q];
        }
        System.out.println(crack);
     }

     System.out.println("MrPolo XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
 }

 

 public static int[][] matrizCamino(int[][] C, int tam) {

     int[][] M = new int [tam][tam];

     for(int p = 0; tam>p; p++) {
 
         for(int q = 0; tam>q; q++) {

             if(C[p][q] == 700000.0) {
            
                 M[p][q] = -1;
             }
         }
      }

     return M;
 }


 public static void RecCamino(int [][] F, int tam,String i, String j,Grafo grafo) {


    Vertice alf = grafo.getVertice(i);
	Vertice bet = grafo.getVertice(j);
 
     if(F[(int) alf.peso][(int) bet.peso]!= 0) {

        int loco = glob.caminos.indexOf(i);
        loco++;

        int k = F[(int) alf.peso][(int) bet.peso];
		k--;
		
		String senVert = getVertConPeso((double) k,grafo); 
		glob.caminos.add(loco, senVert);
		
        RecCamino(F,tam,i,senVert,grafo);
        RecCamino(F,tam,senVert,j,grafo);
     }
 }

        


 public static void floy(Grafo grafo, String inic, String fin, int pasta, int seleccion) {

    int [][] C = new int [grafo.vertices().size()][grafo.vertices().size()];
    if(seleccion == 1) {
	
        C = obtenerMatrizD(grafo);
	} else {
	
	    C = obtenerMatrizND(grafo);
	}
	
     int tam = grafo.vertices().size();
     int [][] F = matrizCamino(C,tam);
     int paja;
     
     for(int k = 0; tam>k; k++) {

         for(int i = 0; tam>i; i++) {

            if(C[i][k]<700000.0 && i!=k) {

                for(int  j = 0; tam>j; j++) {

                    if(j!=k && i!=j && C[k][j]<700000.0) {
         
                        paja = C[i][j];

                        C[i][j] = Math.min(C[i][j],C[i][k]+C[k][j]);
                        if(C[i][j]<paja) {
                 
                           F[i][j] = k + 1;
                        }

                    }
                }
             }
         }
      }               

    // mostrar(F,tam);  
	
	glob.caminos.add(inic);
    glob.caminos.add(fin);
	
	Vertice inicVert = grafo.getVertice(inic);
	Vertice finVert = grafo.getVertice(fin);
	int costoMin = C[(int) inicVert.peso][(int) finVert.peso];
	
	if(pasta - costoMin >=0) {
	
	    RecCamino(F,tam,inic,fin,grafo);
	
	    System.out.println("Camino de menor costo posible: "+glob.caminos);
	    System.out.println("Plata restante: "+(pasta-costoMin));
	    System.out.println("Costo del camino: "+costoMin);
    } else {
	
	    System.out.println("No es posible");
	}
	
 }


 public static void main(String []args) {

	GrafoDirigido g = new GrafoDirigido();
	int seleccion =0;
	try{
	    seleccion = g.leerTipo(args[3]);
		} catch (IOException e){
		} catch (archivoInvalidoException e){}
    if(seleccion == 1){
	
        GrafoDirigido grafo = new GrafoDirigido(args[3]);
        int tam = grafo.vertices().size();
        AsignarNumeros(grafo);
	
    	String inic = args[0];
    	String fin = args[1];
	
    	int pasta = Integer.parseInt(args[2]);
        floy(grafo,inic,fin,pasta,seleccion);
	} else {

        GrafoNoDirigido grafo = new GrafoNoDirigido(args[3]);
        int tam = grafo.vertices().size();
        AsignarNumeros(grafo);
	
    	String inic = args[0];
    	String fin = args[1];
	
    	int pasta = Integer.parseInt(args[2]);
        floy(grafo,inic,fin,pasta,seleccion);
	}	
	
 }
}
 
     
 