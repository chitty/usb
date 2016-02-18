import java.util.*;

public class Caja2 {

    String nombre;
    int caminos;
	
    public Caja2 (String n,int x) {
	
	nombre = n;
	caminos = x;
    }
}

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
    public static LinkedList print (LinkedList Caminos){

	Iterator CIt = Caminos.iterator();
	int diff = 0;
	boolean esta = false;
	LinkedList dif = new LinkedList();
	String info ="";

	Caja2 oc = new Caja2("",0);

	while (CIt.hasNext()){
	    LinkedList camino = (LinkedList) CIt.next();
	    Iterator caminoIt = camino.iterator();
	    System.out.print("< ");

	    while(caminoIt.hasNext()){
		info = (String) caminoIt.next();
		System.out.print( info );
		if (caminoIt.hasNext())
		    System.out.print(",");
	    }
	    Iterator difIt = dif.iterator();

	    esta = false;
	    while (difIt.hasNext()){
		oc = (Caja2) difIt.next();
		if ( oc.nombre.equals(info) ){
		    esta = true;
		    oc.caminos++;
		}
 	    }
		
	    if (!esta && !info.equals("")){
		oc = new Caja2(info,1);
		dif.add(oc);
	    }

	    System.out.println(" >");

	}

	return dif;
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
		if ( elLado.equals( itz.next() ) )
		    ladoReal = true;
	    }
	    if (!ladoReal)
	        indicesL.add( String.valueOf(Caminos.indexOf(cam)) );
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

    public static void main(String []args) {
	
	LinkedList Caminos = new LinkedList();	
	LinkedList LadosB = new LinkedList();
	String vert ="";
	
	
	String archivo = Console.readString("Nombre de archivo: ");
	GrafoDirigido grafo = new GrafoDirigido(archivo);
//	GrafoDirigido grafosen = new GrafoDirigido(archivo);
	vert = Console.readString("Vertice inicio: ");
	LadosB = grafo.transformarGrafoSimpleD();
	Set verfic = intg(grafo.vertices(),grafosen.vertices());
	Set ladfic = intg(grafo.lados(),grafosen.lados());
		
	global.elem = vert;
	// inicializa todos los vertices como NO visitados
	visitado vis = new visitado(grafo.vertices());
	// predecesores, inicializados como todos nulos
	apuntador apun = new apuntador(vert);
	Caminos = BusqProf(vis, vert, grafo,apun,verfic,ladfic,Caminos);

	

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
		    }
	        }
	    }
	    Caminos = modificar(Caminos,indices,LadosB);	    
	}
	
	System.out.println("Solucion:");
	LinkedList ans = print(Caminos);
	Iterator difIt2 = ans.iterator();

	while (difIt2.hasNext()){
	    Caja2 laCaja = (Caja2) difIt2.next();
	    System.out.println(vert+" "+laCaja.nombre+" "+laCaja.caminos);
	}
    }
}	
