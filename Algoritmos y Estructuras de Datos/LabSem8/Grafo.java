import java.io.*;
import java.util.*;


abstract class Grafo {

    Map ListAdy;
    LinkedList Lados;

    /**Se crea un nuevo grafo*/
    public Grafo () {

     	ListAdy = new HashMap();
    	Lados = new LinkedList();
    } 

    /**Se agrega un vertice al grafo*/
    public void agregarVertice(Vertice v) {

   	this.ListAdy.put(v,new LinkedList());    
    }
 
    /**Se elimina el vertice asociado al String idVert*/
    public void eliminarVertice(String idVert) {
 
    	Set verts = this.ListAdy.keySet();
    	Iterator x = verts.iterator();
    	boolean esta = false;
    	Vertice vert = null; 
	
   	while(x.hasNext() && !esta) {

            vert = (Vertice) x.next();
            if(vert.idVertice.equals(idVert)) {
        	ListAdy.remove(vert);
        	esta = true;
            }
    	}
 
    	Iterator y = verts.iterator();
    	x = ListAdy.values().iterator();
 
    	if(vert!=null) {
  
    	    while(x.hasNext()) {
  
        	Vertice vert2 = (Vertice) y.next();
        	LinkedList lista = (LinkedList) x.next();
            	if(lista.contains(vert)) {
	            ((LinkedList) ListAdy.get(vert2)).remove(vert);
	        }
	    }
    	} 
  
    	Iterator z = Lados.iterator();
 
    	while(z.hasNext()) {
 
            Lado lado =(Lado) z.next();
            if(lado.vert1.idVertice.equals(idVert) || lado.vert2.idVertice.equals(idVert)) {
      	   	Lados.remove(lado);
           	z = Lados.iterator();
            }
    	}
    }

   public Lado getLado(String lado) {
  
   Lado ladSalida = null;

   Iterator ladosIt = Lados.iterator();
   boolean estado = false;
   while(ladosIt.hasNext() && !estado) {
  
       Lado ladSen = (Lado) ladosIt.next();
       String infoSen = ladSen.ident;
       if(infoSen.equals(lado)) {
      
           ladSalida = ladSen;
           estado = true;
       }
    }
  
    return ladSalida;
   }
 
    /**Se obtiene un conjunto de String correspondiente a los vertices del grafo*/
    public Set vertices() {

    	Set keys = this.ListAdy.keySet();
    	Iterator x = keys.iterator();
    	Set vertString = new HashSet();
  
    	while(x.hasNext()) {
            Vertice ver = (Vertice) x.next();
            vertString.add(ver.idVertice);
    	}
        return vertString;
    }

    /**Se obtiene un conjunto de String correspondiente a los lados del grafo*/
    public Set lados() {

    	Iterator x = this.Lados.iterator();
    	Set idLados = new HashSet();

    	while(x.hasNext()) {
            idLados.add(((Lado) x.next()).ident);
    	} 
    	return idLados;
    } 
 
    /**Se obtiene el grado del vertice v*/
    public int grado(Vertice v) {

    	int k = 0;
    	LinkedList lista = (LinkedList) this.ListAdy.get(v);
    	k = lista.size();
 
    	return k;
    }

    /**Se obtiene un conjunto de String correspondiente a los vertices adyacentes al vertice cuya eiqueta es idVert del grafo*/
    public Set adyacentes(String idVert) {
 
    	Set keys = this.ListAdy.keySet();
    	Set adys = new HashSet();
    	Vertice vertkey = this.getVertice(idVert);
    	Vertice vert;
    	Iterator keysi = keys.iterator(); 

	LinkedList listkey =(LinkedList) this.ListAdy.get(vertkey);
    	Iterator listkeyi = listkey.iterator();

    	while(listkeyi.hasNext()) {
            vert = (Vertice) listkeyi.next();
            adys.add(vert.idVertice);
    	}
    	while(keysi.hasNext()) {
       	    vert = (Vertice) keysi.next();
       	    LinkedList lista = (LinkedList) this.ListAdy.get(vert);
   
       	    if(lista.contains(vertkey)) {
            	adys.add(vert.idVertice);
            }
    	} 
	return adys;
    }

    /**Se obtiene un conjunto de String correspondiente a los lados que inciden en el vertice cuya etiqueta es idVert*/
    public Set incidentes(String idVert) {
 
    	Iterator x = this.Lados.iterator();
    	Set incs = new HashSet();
 
    	while(x.hasNext()) {
 
            Lado lado = (Lado) x.next();
            if(lado.vert1.idVertice.equals(idVert) || lado.vert2.idVertice.equals(idVert)) { 
            	incs.add(lado.ident);
            } 
    	}
      	return incs;
    }

    public Vertice getVertice(String idVert) {
 
    	Set keys = this.ListAdy.keySet();
    	Iterator x = keys.iterator();
    	Vertice vert = new Vertice("",1);
	Vertice vert2;
    	boolean esta = false;

    	while(x.hasNext() && !esta) {

    	    vert2 = (Vertice) x.next();
            if(vert2.idVertice.equals(idVert)) {
		vert = vert2;
        	esta = true;
            }
    	}  
    	return vert;
    }
	
    /**Se almacena el tipo de grafo que se encuentra en el archivo archivoEntrada*/
    public int leerTipo(String archivoEntrada)
     throws IOException, archivoInvalidoException {

    	int n = 0;
    	BufferedReader in = new BufferedReader(new FileReader(archivoEntrada));
    	String s, data;
    	String[] tok;
    	data = new String();

    	// Se lee la primera linea del archivo (tipo de grafo)
    	if( (s = in.readLine()) != null ){

      	    tok = s.split("\\b\\s");
      	    data = tok[0].trim();
      	    if (data.equals("n")){
		return 0;
            } else if (data.equals("d")){
		return 1;
      	    } else{
		throw new archivoInvalidoException();
      	    }
    	}
    	throw new archivoInvalidoException();
    }

    public void leerArchivo(String archivoEntrada) throws IOException, archivoInvalidoException {}

    public void guardar(String n) throws IOException {}
 
} 
 
//****************************************************** GRAFO NO DIRIGIDO ********************************************
    //************************************************************************************************************************************************

public class GrafoNoDirigido extends Grafo {

    /**Se crea un grafo no dirigido */
    public GrafoNoDirigido() {    
	super();
    }

	/**Se crea un grafo no dirigido con la informacion almacenada en el archivo n*/
    public GrafoNoDirigido (String n) { 
    
	super();
    	try{
	    leerArchivo(n);
        }catch (IOException e){
	    System.out.println( e.getMessage() );
        }catch (archivoInvalidoException e){
	    System.out.println( e.getMessage() );
        } 
   } 
 
    /***Se agrega una arista entre dos vertices del grafo no dirigido*/ 
    public void agregarArista(Arista a) {
 
    	Vertice ver1 = a.vert1;
    	Vertice ver2 = a.vert2;
    	Lados.add(a);
  
    	LinkedList lista =(LinkedList) this.ListAdy.get(ver1);
    	lista.add(ver2);
  
    	LinkedList lista2 =(LinkedList) this.ListAdy.get(ver2);
    	lista2.add(ver1);  
    }
	
    public void transformarGrafoSimpleND() {
	
	Set verts = this.vertices();
	Iterator vertsIt = verts.iterator();
	while(vertsIt.hasNext()) {
	
	    String ver = (String) vertsIt.next();
	    Set adys = this.adyacentes(ver);
	    Iterator adysIt = adys.iterator();
	    while(adysIt.hasNext()) {
		
	        String ady = (String) adysIt.next();
		int gradoA = this.gradoArista(ady,ver);
		if(gradoA>1) {
			
		    for(int p = 1; gradoA>p; p++) {
				
		        String lad = this.getLadoId(ady,ver);
			this.eliminarArista(lad);
		    }				
		}
	    }
	}
    }
	
    public int gradoArista(String vert1,String vert2) {
	
	int grado = 0;
	Iterator x = Lados.iterator();

	while(x.hasNext()) {
	    Lado lado = (Lado) x.next();
   	    String ver1 = lado.vert1.idVertice;
	    String ver2 = lado.vert2.idVertice;

	    if((ver1.equals(vert1) && ver2.equals(vert2)) || (ver1.equals(vert2) && ver2.equals(vert1)))
		grado++;
	}
	return grado;
    }
	
    public String getLadoId(String vert1,String vert2) {
	
    	String id = "";
    	Iterator x = Lados.iterator();
	boolean esta = false;
   	while(x.hasNext() && !esta) {
            Lado lado = (Lado) x.next();
	    String ver1 = lado.vert1.idVertice;
	    String ver2 = lado.vert2.idVertice;
	    if((ver1.equals(vert1) && ver2.equals(vert2)) || (ver1.equals(vert2) && ver2.equals(vert1))) {
		id = lado.ident;
		esta = true;
	    }
	}
	return id;
    }
	
 
    /**Se elimina una arista entre dos vertices del grafo no dirigido*/
    public void eliminarArista(String idArist) {
 
	Iterator x = Lados.iterator();
    	boolean esta = false;
    	Vertice ver1 = null;
    	Vertice ver2 = null;
 
    	while(x.hasNext() && !esta) {
 
      	    Lado lado =(Lado) x.next();
       	    if(lado.ident.equals(idArist)) {
           	ver1 = lado.vert1;
           	ver2 = lado.vert2;
           	Lados.remove(lado);
           	esta = true;
            }
    	}
 
    	LinkedList lista = (LinkedList) this.ListAdy.get(ver1); 
    	lista.remove(ver2);
 
    	LinkedList lista2 = (LinkedList) this.ListAdy.get(ver2); 
    	lista2.remove(ver1);    
    }

    public void leerArchivo(String archivoEntrada)
     throws IOException, archivoInvalidoException { 

    	int i, n = 0, nroVertices = 0, nroLados = 0;
    	BufferedReader in = new BufferedReader(new FileReader(archivoEntrada));
    	String s;
    	String[] tok;

    	// ya se sabe que es No dirigido, se ignora esta linea
    	s = in.readLine();
    
    	if( (s = in.readLine()) != null ){ // Se lee el valor nroVertices
       	    tok = s.split("\\b\\s");
       	    nroVertices = Integer.valueOf( tok[0].trim() ).intValue();
    	}
    
    	if( (s = in.readLine()) != null ){ 	// Se lee el valor nroLados
            tok = s.split("\\b\\s");
       	    nroLados = Integer.valueOf( tok[0].trim() ).intValue();
    	}

    	// Se leen nroVertices lineas, cada una con 2 datos
    	for( i = 0; i < nroVertices; i++ ){

            if( (s = in.readLine()) != null ){
	    	tok = s.split("\\b\\s");
	        String etiq = tok[0].trim();
	        double pes = Double.valueOf( tok[1].trim() ).doubleValue();
	        Vertice vert = new Vertice(etiq,pes);
		this.agregarVertice(vert);
            }
    	}

    	// Se leen nroLados lineas, cada una con 4 datos
    	for( i = 0; i < nroLados; i++ ){

            if( (s = in.readLine()) != null ){
	    	tok = s.split("\\b\\s");
	    	String aident = tok[0].trim();
	    	Vertice vert1 = this.getVertice(tok[1].trim());
	    	Vertice vert2 = this.getVertice(tok[2].trim());
	    	double apeso = Double.valueOf( tok[3].trim() ).doubleValue();
		Arista arista = new Arista(aident,apeso,vert1,vert2);
	    	this.agregarArista(arista);
            }
    	}
    	in.close();
    }

    public void guardar(String n) throws IOException{

    	Set keys = this.ListAdy.keySet();
    	Iterator x = keys.iterator();
    	String linea = new String();
    	Vertice v = new Vertice("",0.0);
    	int dummy,dummy2;
    	PrintWriter out =
    	new PrintWriter(new BufferedWriter(new FileWriter(n)));
    	out.println("n"); // no dirigido
    	dummy = this.ListAdy.size();
    	out.println(dummy);
    	dummy2 = this.Lados.size();
    	out.println(dummy2);

    	// Ciclo para imprimir los vertices
    	for(int i=0; i<dummy; i++){
            v = (Vertice) x.next();
    	    linea = v.idVertice+" "+v.peso;
            out.println(linea);
    	}
 
    	Arista a = new Arista("",1,v,v);
    	Iterator xx = this.Lados.iterator();
    	// Ciclo para imprimir las aristas
    	for(int i=0; i<dummy2; i++){
            a = (Arista) xx.next();
	    linea = a.ident+" "+a.vert1.idVertice+" "+a.vert2.idVertice+" "+a.peso;
            out.println(linea);
    	}
    	out.close();
    }

}


/****************************************************** GRAFO DIRIGIDO ********************************************
  **************************************************************************************************************/

public class GrafoDirigido extends Grafo {

    /**Se crea un grafo dirigido*/
    public GrafoDirigido() {
    	super();
    }
    
    /**Se crea un grafo dirigido con la informacion almacenada en el archivo n*/
    public GrafoDirigido (String n) { 

   	super();
    	try{
	    leerArchivo(n);
        }catch (IOException e){
	    System.out.println( e.getMessage() );
        }catch (archivoInvalidoException e){
	    System.out.println( e.getMessage() );
        } 
    }

    /**Se agrega un arco entre dos vertices del grafo dirigido*/
    public void agregarArco(Arco a) {

    	try{
	    Vertice ver1 = a.vert1;
    	    Vertice ver2 = a.vert2;
    	    Lados.add(a);
    	    LinkedList lista =(LinkedList) this.ListAdy.get(ver1);
    	    lista.add(ver2);
	} catch (Exception e) { 
	    System.out.println("Alguno de los vertices asignados no estan en el grafo");
	}
  
    }
  
    /**Se obtiene el grado del vertice v en el grafo dirigido*/
    public int grado(Vertice v) {
    
	int k = this.gradoInterior(v.idVertice) + this.gradoExterior(v.idVertice);
    	return k;
    }

    /**Se elimina el arco de etiqueta idArc del grafo dirigido*/ 
    public void eliminarArco(String idArc) {

    	try{
	    Iterator x = Lados.iterator();
    	    boolean esta = false;
   	    Vertice ver1 = null;
    	    Vertice ver2 = null;
 
    	    while(x.hasNext() && !esta) {
 
    		Lado lado =(Lado) x.next();
        	if(lado.ident.equals(idArc)) {
        	    ver1 = lado.vert1;
        	    ver2 = lado.vert2;
        	    Lados.remove(lado);
        	    esta = true;
    		}
    	    }
 
       	LinkedList lista = (LinkedList) this.ListAdy.get(ver1); 
    	lista.remove(ver2);
    	} catch (Exception e) {
	    System.out.println("El arco no se encuentra representado en el grafo");
	}
    }

    /**Se obtiene el grado interior del vertice v en el grafo dirigido*/
    public int gradoInterior(String idVert) {

    	Set keys = this.ListAdy.keySet();
    	Iterator x = keys.iterator();
    	boolean esta = false;
    	int k = 0;

 	while(x.hasNext() && !esta) {
 	    Vertice vert = (Vertice) x.next();

 	    if(vert.idVertice.equals(idVert)) {
        	LinkedList lista = (LinkedList) this.ListAdy.get(vert);
        	k = lista.size();
	    }
    	} 
    	return k;
    }

    /**Se obtiene el grado exterior del vertice v en el grafo dirigido*/
    public int gradoExterior(String idVert) {
 
 	int k = 0;
 	Collection listas = this.ListAdy.values();
 	Iterator x = listas.iterator();
 
 	while(x.hasNext()) {
            LinkedList lista = (LinkedList) x.next();
            Iterator y = lista.iterator();
 
    	while(y.hasNext()) {

            Vertice vert = (Vertice) y.next();   
            if(vert.idVertice.equals(idVert)) 
            	k++;
        
    	}
    }
 
    return k;
    }
 
    /**Se obtienen los sucesores del vertice v en el grafo dirigido*/
    public Set sucesores(String idVert) {

    	Set keys = this.ListAdy.keySet();
    	Iterator x = keys.iterator();
    	boolean esta = false;
    	Set k = new HashSet();

    	while(x.hasNext() && !esta) {
            Vertice vert = (Vertice) x.next();

            if(vert.idVertice.equals(idVert)) {
            	LinkedList lista = (LinkedList) this.ListAdy.get(vert);
            	Iterator y = lista.iterator();

        	while(y.hasNext())
            	    k.add((String) ((Vertice) y.next()).idVertice);
            }
    	}
    	return k;
    }
	
    public int gradoArco(String vert1,String vert2) {
	
    	int grado = 0;
    	Iterator x = Lados.iterator();

    	while(x.hasNext()) {

            Lado lado = (Lado) x.next();
	    String ver1 = lado.vert1.idVertice;
	    String ver2 = lado.vert2.idVertice;
	    if((ver1.equals(vert1) && ver2.equals(vert2)))
		grado++;
	}
	return grado;
    }
	
    public LinkedList transformarGrafoSimpleD() {
	
	Set verts = this.vertices();
	Iterator vertsIt = verts.iterator();
	LinkedList LadosB = new LinkedList();
	int pp = 0;

	while(vertsIt.hasNext()) {
	
	    String ver = (String) vertsIt.next();
	    Set sucs = this.sucesores(ver);
	    Iterator sucsIt = sucs.iterator(); 
	    while(sucsIt.hasNext()) {
		
	        String suc = (String) sucsIt.next();
		int gradoA = this.gradoArco(ver,suc); 
		if(gradoA>1) {
			
		    for(int p = 0; p<gradoA; p++) {				
	    	        String lad = this.getLadoId(ver,suc); 
			this.eliminarArco(lad);
			// Almacenar en LadosB la informacion
			LadosB.add(lad);
			LadosB.add(ver);
			LadosB.add(suc);

			Vertice verFic = new Vertice("f"+pp+p+ver,0); 
			this.agregarVertice(verFic);
			Arco lad1 = new Arco("ef"+pp+p+lad,0,this.getVertice(ver),verFic);
			Arco lad2 = new Arco("lf"+pp+p+lad,0,verFic,this.getVertice(suc));
			this.agregarArco(lad1);
			this.agregarArco(lad2);
		    }
		    pp++;
		}
	    }
	}
try{ this.guardar("bobo");} catch(IOException e){}
	return LadosB;
    }
	
    public String getLadoId(String vert1,String vert2) {
	
    	String id = "";
    	Iterator x = Lados.iterator();
	boolean esta = false;

    	while(x.hasNext() && !esta) {
            Lado lado = (Lado) x.next();
	    String ver1 = lado.vert1.idVertice;
	    String ver2 = lado.vert2.idVertice;

	    if((ver1.equals(vert1) && ver2.equals(vert2))) {
		id = lado.ident;
		esta = true;
	    }
	}
	return id;
    }
 
    /**Se obtienen los predecesores del vertice v en el grafo dirigido*/
    public Set predecesores(String idVert) {
 
        Set keys = this.ListAdy.keySet();
        Iterator x = keys.iterator();
        Set predec = new HashSet();
 
        while(x.hasNext()) {
            Vertice vertic = (Vertice) x.next();
            LinkedList lista =(LinkedList) this.ListAdy.get(vertic);
            Iterator y = lista.iterator();
            boolean esta = false;

    	    while(y.hasNext() && !esta) {
        	Vertice vertic2 = (Vertice) y.next();

        	if(vertic2.idVertice.equals(idVert)) {
            	    predec.add(vertic.idVertice);
            	    esta = true;
        	}
    	    }
    	}
    	return predec; 
    }

    /**Se guarda el grafo correspondiente en el archivo n*/
    public void guardar(String n) throws IOException{

    Set keys = this.ListAdy.keySet();
    Iterator x = keys.iterator();
    String linea = new String();
    Vertice v = new Vertice("",0.0);
    int dummy,dummy2;
    PrintWriter out =
    new PrintWriter(new BufferedWriter(new FileWriter(n)));
    out.println("d"); // dirigido
    dummy = this.ListAdy.size();
    out.println(dummy);
    dummy2 = this.Lados.size();
    out.println(dummy2);

    // Ciclo para imprimir los vertices
    for(int i=0; i<dummy; i++){
        v = (Vertice) x.next();
    	linea = v.idVertice+" "+v.peso;
        out.println(linea);
    }
 
    Arco a = new Arco("",1,v,v);
    Iterator xx = this.Lados.iterator();
    // Ciclo para imprimir los arcos
    for(int i=0; i<dummy2; i++){
        a = (Arco) xx.next();
	    linea = a.ident+" "+a.vert1.idVertice+" "+a.vert2.idVertice+" "+a.peso;
        out.println(linea);
    }
    out.close();
    }

    public void leerArchivo(String archivoEntrada)
   	throws IOException, archivoInvalidoException { 

    int i, n = 0, nroVertices = 0, nroLados = 0;
    BufferedReader in = new BufferedReader(new FileReader(archivoEntrada));
    String s;
    String[] tok;
    // ya se sabe que es dirigido, se ignora esta linea
    s = in.readLine();

    // Se lee el valor nroVertices
    if( (s = in.readLine()) != null ){
       tok = s.split("\\b\\s");
       nroVertices = Integer.valueOf( tok[0].trim() ).intValue();
    }

    // Se lee el valor nroLados
    if( (s = in.readLine()) != null ){
       tok = s.split("\\b\\s");
       nroLados = Integer.valueOf( tok[0].trim() ).intValue();
    }

    // Se leen nroVertices lineas, cada una con 2 datos
    for( i = 0; i < nroVertices; i++ ){
        if( (s = in.readLine()) != null ){
	    tok = s.split("\\b\\s");
        
	    String etiq = tok[0].trim();
	    double pes = Double.valueOf( tok[1].trim() ).doubleValue();
	    Vertice vert = new Vertice(etiq,pes);
			
	    this.agregarVertice(vert);
        }
    }

    // Se leen nroLados lineas, cada una con 4 datos
    for( i = 0; i < nroLados; i++ ){
        if( (s = in.readLine()) != null ){
	    tok = s.split("\\b\\s");
	    String aident = tok[0].trim();
	    Vertice vert1 = this.getVertice(tok[1].trim());
	    Vertice vert2 = this.getVertice(tok[2].trim());
	    double apeso = Double.valueOf( tok[3].trim() ).doubleValue();
		
	    Arco arco = new Arco(aident,apeso,vert1,vert2);
	    this.agregarArco(arco);
        }
    }
    in.close();

    }
}

class archivoInvalidoException extends Exception {
    public archivoInvalidoException() {
    
	super("ERROR: el formato del archivo de lectura es invalido!");
    } 
}

class errorException extends Exception {
    public errorException() {
    
	super("ERROR: el formato del archivo de lectura es invalido!");
    } 
}
