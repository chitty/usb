import java.util.*;

class clienteDFS extends BusqProf{

    public static Set intg(Set c1, Set c2) {
	
	Set c3 = new HashSet();
	Iterator c1It = c1.iterator();
	while(c1It.hasNext()) {
	
	    String sen =(String) c1It.next();
	    if(!c2.contains(sen))		
		c3.add(sen);

	}
	return c3;
    }

   // Impreme todas las listas de caminos
    public static void print (LinkedList Caminos){

	Iterator CIt = Caminos.iterator();
	boolean esta = true;
	global.presupuestoRestante = 0;  //Variable global

	while (CIt.hasNext()){
	    LinkedList camino = (LinkedList) CIt.next();
	    Iterator caminoIt = camino.iterator();
	    System.out.print("< ");

	    while(caminoIt.hasNext()){
		String info = (String) caminoIt.next();
		
		if(esta) {
		
		    double pesVer = global.g.getVertice(info).peso;
			global.presupuestoRestante = global.presupuestoRestante + pesVer; //Variable global
			esta = false;
		} else if(!esta) {
		
		    double pesLad = global.g.getLado(info).peso;
			global.presupuestoRestante = global.presupuestoRestante + pesLad; //Variable global
			esta = true;
		}
				
		System.out.print( info );
		if (caminoIt.hasNext())
		    System.out.print(",");
	    }
		
		global.presupuestoRestante = global.presupuestoSen - global.presupuestoRestante; //Variable global
	    System.out.println(" >"); 
	}
	
	if(Caminos.size()==0) {
	
	   System.out.println("No es posible");
	}
    }

   // Modifica los caminos del grafo con lados ficticios a caminos en el grafo original
    public static LinkedList modificar (LinkedList Caminos, Set indices, LinkedList originales){

	Iterator It = indices.iterator();
	int indice = 0, tam = 0;

	while (It.hasNext()){
	    String i = (String) It.next();
	    i.trim();
	    indice = Integer.parseInt(i);

	    LinkedList cam = (LinkedList) Caminos.get(indice);
	    tam = cam.size();
	    Caminos.remove(indice);
    
	    Iterator camIt = cam.iterator();
	    LinkedList camNew = new LinkedList();

	    while(camIt.hasNext()){
		String info = (String) camIt.next();
		// posible camino con lados/vertices ficticios
		if ( info.startsWith("ef") && cam.indexOf(info) < tam-2 ){
		    String info1 = (String) camIt.next();
		    String info2 = (String) camIt.next();
		    if ( info1.startsWith("f") && info2.startsWith("lf") ){
			Iterator x = originales.iterator();
			while (x.hasNext()){
			    String l = (String) x.next();
			    if ( info2.endsWith(l) && info.endsWith(l) )
				camNew.add(l);
			}
		    } else{
			camNew.add(info);
			camNew.add(info1);
			camNew.add(info2);
		    }
		// otro posible camino con lados/vertices ficticios
		} else if ( info.startsWith("lf") && cam.indexOf(info) < tam-2 ){
		    String info1 = (String) camIt.next();
		    String info2 = (String) camIt.next();
		    if ( info1.startsWith("f") && info2.startsWith("ef") ){
			Iterator x = originales.iterator();
			while (x.hasNext()){
			    String l = (String) x.next();
			    if ( info2.endsWith(l) && info.endsWith(l) )
				camNew.add(l);
			}
		    } else{
			camNew.add(info);
			camNew.add(info1);
			camNew.add(info2);
		    }
		} else
		    camNew.add(info);
	    }
	    Caminos.add(indice,camNew);
	}

	Iterator itx = Caminos.iterator();
	boolean ladoReal = false;
	LinkedList indicesL = new LinkedList();

	// almacena en indicesL los lados a eliminar
	while ( itx.hasNext() ){
	    LinkedList cam = (LinkedList) itx.next();
	    String elLado = (String) cam.getLast();

	    Iterator itz = originales.iterator();
	    ladoReal = false;
	    while ( itz.hasNext() ){
		if ( elLado.equals( itz.next() ) || !elLado.startsWith("f") )
		    ladoReal = true;
	    }
	    if (!ladoReal){
	        indicesL.add( String.valueOf(Caminos.indexOf(cam)) );
	    }
	}

	Iterator xyz = indicesL.iterator();
	int size = indicesL.size();

	int index[] = new int[size];
	int j=0;

	// Arreglo con los indices a eliminar
	while ( xyz.hasNext() ){
	    String aEliminar = (String) xyz.next();
	    aEliminar.trim();
	    index[j] = Integer.parseInt(aEliminar);
	    j++;
	}

	Quicksort.quicksort(index,0,index.length-1);

	// Elimina todos los caminos a lados ficticios
	for (j=index.length-1; j>=0; j--)
	    Caminos.remove(index[j]);

	return Caminos;
    }

   public static void CrearGrafo(int select, String archivo, String vert, String vert3, double presupuestoPC, double presupuesto) {

	
	LinkedList Caminos = new LinkedList();	
	LinkedList LadosB = new LinkedList();
	
	if(select == 1) {
	
	    GrafoDirigido grafo = new GrafoDirigido(archivo);
	    GrafoDirigido grafosen = new GrafoDirigido(archivo);
	    global.g = new GrafoDirigido(archivo);  //Variable global
	    LadosB = grafo.transformarGrafoSimpleD();
	    Set verfic = intg(grafo.vertices(),grafosen.vertices());
	    Set ladfic = intg(grafo.lados(),grafosen.lados());
	    global.presupuestoSen = presupuesto;  //Variable global
		
	    global.elem = vert;
	    // inicializa todos los vertices como NO visitados
	    visitado vis = new visitado(grafo.vertices());
	    // predecesores, inicializados como todos nulos
	    apuntador apun = new apuntador(vert);
	    Caminos = BusqProf(vis, vert, grafo,apun,verfic,ladfic,Caminos,0.0,presupuestoPC,presupuesto,vert3);

	} else if(select == 2) {

	    global.elem = vert;
	    GrafoNoDirigido grafo = new GrafoNoDirigido(archivo);
	    GrafoNoDirigido grafosen = new GrafoNoDirigido(archivo);
	    global.g = new GrafoNoDirigido(archivo);  //Variable global
	    LadosB = grafo.transformarGrafoSimpleND();
	    Set verfic = intg(grafo.vertices(),grafosen.vertices());
	    Set ladfic = intg(grafo.lados(),grafosen.lados());
	    global.presupuestoSen = presupuesto; //Variable global
		
	    global.elem = vert;
	    // inicializa todos los vertices como NO visitados
	    visitado vis = new visitado(grafo.vertices());
	    // predecesores, inicializados como todos nulos
	    apuntador apun = new apuntador(vert);
	    Caminos = BusqProfND(vis, vert, grafo,apun,verfic,ladfic,Caminos,0.0,presupuestoPC,presupuesto,vert3);
		
	}

	// Transformar al grafo original
	if ( LadosB.size() > 0 ){

	    Iterator CIt = Caminos.iterator();
	    int indice = 0;
	    Set indices = new HashSet();

	    while (CIt.hasNext()){
	    	LinkedList camino = (LinkedList) CIt.next();
	    	Iterator caminoIt = camino.iterator();

	        while(caminoIt.hasNext()){
		    String info = (String) caminoIt.next();
		    // posible lado ficticio
		    if ( info.startsWith("ef") && caminoIt.hasNext() ){
			info = (String) caminoIt.next();
			if ( info.startsWith("f") && caminoIt.hasNext() ){
			   info = (String) caminoIt.next();
			   if ( info.startsWith("lf") ){
				indice = Caminos.indexOf(camino);
				indices.add( String.valueOf(indice) );
				break;
			   }
			}
		    // otro caso de posible lado ficticio
		    } else if ( info.startsWith("lf") && caminoIt.hasNext() ){
			info = (String) caminoIt.next();
			if ( info.startsWith("f") && caminoIt.hasNext() ){
			   info = (String) caminoIt.next();
			   if ( info.startsWith("ef") ){
				indice = Caminos.indexOf(camino);
				indices.add( String.valueOf(indice) );
				break;
			   }
			}
		    }
	        }
	    }
	    Caminos = modificar(Caminos,indices,LadosB);	    
	}
	
	print(Caminos); 
	System.out.println("Presupuesto restante:"+global.presupuestoRestante);
    }
}	
