import java.util.*;
import java.io.*;

public class globl {

    public static String suc = "";
    public static String t = "";
    public static String sen = "";
    public static boolean quitar1 = false;
    public static boolean quitar2 = false;
}

class planEstudio {


    /** multiplica el peso de todos los lados del grafo por -1*/
    public static void CambiarNegativos(Grafo grafo) {
 
     	Set lads = grafo.lados();
    	Iterator ladsIt = lads.iterator();
    	while(ladsIt.hasNext()) {
	
	    String ladSen = (String) ladsIt.next();
	    Lado lad = grafo.getLado(ladSen);
	    lad.peso = (-1)*lad.peso;
    	}
    }
 
 
    /** asigna 1 a el peso de todos los vertices*/
    public static void ponerUnos(Grafo grafo) {
 
      	Set lads = grafo.lados();
    	Iterator ladsIt = lads.iterator();
    	while(ladsIt.hasNext()) {
	
	    String ladSen = (String) ladsIt.next();
	    Lado lad = grafo.getLado(ladSen);
	    lad.peso = 1;
	}
    }
 
 
    /**DFS modificado, es usado por el TAC*/ 
    public static void BusqProfMod(GrafoDirigido grafo, String x, visitado vis,double TEC_t) {
 
    	vis.marcarVisitado(x);
	if(x.equals(globl.t)) {
	
	    Vertice xVert = grafo.getVertice(x);
	    xVert.peso = TEC_t;
	} else {
	
	    Set sucs = grafo.sucesores(x);
	    Iterator sucsIt = sucs.iterator();
	    while(sucsIt.hasNext()) {
		
		String verSen = (String) sucsIt.next();
		if(!vis.estaVisitado(verSen))
		    BusqProfMod(grafo,verSen, vis, TEC_t);
		
	    }
			
	    Set sucs2 = grafo.sucesores(x);
  	    Vertice xVert2 = grafo.getVertice(x);
	    Iterator sucsIt2 = sucs2.iterator();
	    while(sucsIt2.hasNext()) {
			
		String verSen2 = (String) sucsIt2.next();
		String ladInf = grafo.getLadoId(x,verSen2);
		Lado lad = grafo.getLado(ladInf);
		Vertice ve = grafo.getVertice(verSen2);
				
		if(ve.peso!=70000000.0 && xVert2.peso > ve.peso - lad.peso)			
		    xVert2.peso = ve.peso - lad.peso;
	
	    }		
	}
    }
 
 
    /** Este metodo guarda en el peso de cada vertice su TAC*/
    public static void TAC(GrafoDirigido grafo, double TEC_t, String s) {
 
        Set verts = grafo.vertices();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verSen = (String) vertsIt.next();
	    Vertice ver = grafo.getVertice(verSen);
	    ver.peso = 70000000.0;
	}
	
	visitado vis = new visitado(grafo.vertices());
	BusqProfMod(grafo,s,vis,TEC_t);
    }
	

    /** Calcula los vertices fuentes del grafo pasado como argumento, es decir, en una lista guarda todos los vertices del grafo
        grado de entrada es 0 */
    public static LinkedList verticesFuentes(GrafoDirigido grafo) {
 
    	LinkedList vertsF = new LinkedList();
	Set verts = grafo.vertices();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verSen = (String) vertsIt.next();
	    int GE = grafo.gradoExterior(verSen);

	    if(GE == 0)		
		vertsF.add(verSen);
	}
	
	return vertsF;
    }
 
 
    /** Calcula los vertices sumidero del grafo pasado como argumento, es decir, en una lista guarda todos los vertices del grafo
        grado de salida es 0 */
    public static LinkedList verticesSumidero(GrafoDirigido grafo) {
 
    	LinkedList vertsF = new LinkedList();
	Set verts = grafo.vertices();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String verSen = (String) vertsIt.next();
	    int GE = grafo.gradoInterior(verSen);

	    if(GE == 0)
		vertsF.add(verSen);		
	}
	
	return vertsF;
    }
 
 
    /** verifica si es necesario introducir un vertice ficticio fuente o sumidero al grafo pasado como argumento*/ 
    public static void Arreglar(GrafoDirigido grafoOr, LinkedList part) {
 
	LinkedList listFirst = verticesFuentes(grafoOr);
	
	if(listFirst.size()>1) {
	
	    globl.quitar1 = true;
	
	    Vertice verNew = new Vertice("sen",0.0);
	    grafoOr.agregarVertice(verNew);
	    Iterator listFirstIt = listFirst.iterator();
	    while(listFirstIt.hasNext()) {
		
		String verInf = (String) listFirstIt.next();
		Vertice verI = grafoOr.getVertice(verInf);
		Arco arc = new Arco("ArcSen",0.0,verNew,verI);
		grafoOr.agregarArco(arc);
	    }
		
	    globl.quitar2 = false;
	    LinkedList listLast = verticesSumidero(grafoOr);
	    if(listLast.size()>1) {
		
		LinkedList VS = verticesSumidero(grafoOr);
		
		globl.quitar2 = true;
		Vertice vNew = new Vertice("sen2",0.0);
		grafoOr.agregarVertice(vNew);
		Iterator listLastIt = listLast.iterator();
		while(listLastIt.hasNext()) {
			
		    String vInf = (String) listLastIt.next();
		    Vertice vI = grafoOr.getVertice(vInf);
		    Arco arc = new Arco("ArcSen2",0.0,vI,vNew);
		    grafoOr.agregarArco(arc);
		}
	    }		
     	    globl.sen ="sen";	
		
	} else {
	
            globl.quitar2 = false;
	    LinkedList listLast = verticesSumidero(grafoOr);
	    if(listLast.size()>1) {
		
		LinkedList VS = verticesSumidero(grafoOr);
		System.out.println(VS.size());
		
		globl.quitar2 = true;
		Vertice vNew = new Vertice("sen2",0.0);
		grafoOr.agregarVertice(vNew);
		Iterator listLastIt = listLast.iterator();
		while(listLastIt.hasNext()) {
			
		    String vInf = (String) listLastIt.next();
		    Vertice vI = grafoOr.getVertice(vInf);
		    Arco arc = new Arco("ArcSen2",0.0,vI,vNew);
		    grafoOr.agregarArco(arc);
		}
	    }
		
	    listFirst = (LinkedList) part.getFirst();
	    globl.sen = (String) listFirst.getFirst();
		
	}	
    }
 
 
    /** algoritmo principal, hace las llamadas a los metodos y los tipos necesarios e imprime resultados */
    public static void planEstudio(GrafoDirigido grafo, String nArchivo, int tam) {
 
    	LinkedList part = new LinkedList();
    	LinkedList clas = new LinkedList();
	boolean circuito = false;
	Set verts = grafo.vertices();
	GrafoDirigido grafoSen = new GrafoDirigido(nArchivo); //nueva pos grafoSen
	GrafoDirigido grafoOr = new GrafoDirigido(nArchivo); //nueva pos grafoSen
	
	while(verts.size()!=0 && !circuito) {
	
	    clas = verticesFuentes(grafo);
	    if(clas.size() == 0) {
		System.out.println("Hay un circuito en el grafo!. Programa abortado");
		System.exit(0);
	    } else {
		
		if(clas.size()>tam) {

                    int tamList = clas.size();
		    for(int d = 0; tamList - tam>d; d++)
		    	clas.removeLast();		    
		}
			
		part.add(clas);
		Iterator clasIt = clas.iterator();
		while(clasIt.hasNext()) {
			
		    String verSen = (String) clasIt.next();
		    grafo.eliminarVertice(verSen);
		    verts.remove(verSen);
		}
	    }
	}
	
	Iterator partIt = part.iterator();
	System.out.println("Orden Secuencial de las materias: ");
	while(partIt.hasNext()) {  // resultado 1
	
	    LinkedList partList = (LinkedList) partIt.next();
	    Iterator partListIt = partList.iterator();
	    while(partListIt.hasNext())
		 System.out.println(partListIt.next());
	}
		
	ponerUnos(grafoSen);
	ponerUnos(grafoOr);
	
	Arreglar(grafoOr,part);
    	CambiarNegativos(grafoOr);

	Bellman bell = new Bellman(grafoOr,globl.sen);
	LinkedList list = bell.getSecuenciaC();
	HashSet conjunto = bell.getSecuenciaS();
	
	if(globl.quitar2)		
	    list.removeLast();
	
	if(globl.quitar1)	
	    list.removeFirst();
	
	System.out.println("\nMinimo numero de periodos:\n"+list.size()); //resultado 2
		
	System.out.println("\nSecuencia de materias critica:");

	LinkedList laLista = new LinkedList();
	Iterator conjIt = conjunto.iterator();
	// Imprime todas las secuencias criticas
	while( conjIt.hasNext() ){
	    laLista = (LinkedList) conjIt.next();
	    System.out.println(laLista);
 	}
	
	//MOSTRAR HOLGURAS
	Arreglar(grafoSen,part);
        CambiarNegativos(grafoSen);

	Bellman bell2 = new Bellman(grafoSen,globl.sen);
	list = bell2.getSecuenciaC();
	
	pesoAlt pes = bell2.getTECs();   //TEC
	GrafoDirigido graf = bell2.getGrafo();
	
	double TAC_t = (-1)*graf.getVertice((String) list.getLast()).peso;
	globl.t = (String) list.getLast();
	String s = (String) list.getFirst();
	
    	CambiarNegativos(graf);
	
	
	TAC(graf,TAC_t,s);
	
    	Set verTACs = graf.vertices();
	Iterator verTACsIt = verTACs.iterator();
	System.out.println("\nHolguras:\n");

    	while(verTACsIt.hasNext()) {
	
	    String verTAC = (String) verTACsIt.next();
	    Vertice vTAC = graf.getVertice(verTAC);
	    double TEC = pes.getPesoAlt(verTAC);
		
	    if(!verTAC.equals("sen") && !verTAC.equals("sen2"))
		System.out.println(verTAC+" = "+((int) (vTAC.peso+TEC)));		
	}

	
	System.out.println("\nPlan de estudios basico:\n");
	partIt = part.iterator();
	int cont = 1;
	while(partIt.hasNext()) {  // resultado 4
	
	    System.out.println("Periodo "+cont++);
	    LinkedList partList2 = (LinkedList) partIt.next();
	    System.out.println(partList2);		
	}
	
    }
 
    public static void main (String []args) {
 
 	GrafoDirigido grafo = new GrafoDirigido();
 
	// Verifica que se hayan pasado al menos 2 argumentos por consola
	if (args.length < 2) {
 	    System.out.println ("Numero incorrecto de parametros!");
 	    System.out.println ("Debe ser: <nombre de archivo> <# max de materias>");
	    System.exit(0);
	}

 	try{
 	    int f = grafo.leerTipo(args[0]);
 	    if(f!=1) {
    	    	System.out.println("El grafo no es dirigido!. Programa abortado");
	    	System.exit(0);
 	    }
    	}catch (IOException e){
    	    System.out.println( e.getMessage() );
	    System.exit(0);
	}catch (archivoInvalidoException e){
	    System.out.println( e.getMessage() );
	    System.exit(0);
    	}

	grafo = new GrafoDirigido(args[0]);
 	int tam = Integer.parseInt(args[1]);	
 	planEstudio(grafo,args[0],tam);
    }
}
