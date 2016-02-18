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
            idLados.add(((Lado) x.next()));
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
 
 
 
//******************************************************PROGRAMA PRINCIPAL********************************************
  
    public static void main(String []args) {
 
    System.out.println("");
    System.out.println("1. Grafo No dirigido");
    System.out.println("2. Grafo dirigido");
	System.out.println("3. Salir\n");
    int caso = Console.readInt("Que tipo de Grafo desea construir?\n");

	
    if(caso == 2) {
        GrafoDirigido g = new GrafoDirigido();
        boolean estado = true;
  
        while(estado) {
 
            System.out.println("1. Agregar vertice");
            System.out.println("2. Eliminar vertice");
            System.out.println("3. Vertices");
            System.out.println("4. Lados");
            System.out.println("5. Grado");
            System.out.println("6. Adyacentes");
            System.out.println("7. Incidentes");
            System.out.println("8. Agregar arco");
            System.out.println("9. Eliminar arco");
            System.out.println("10. Grado interior");
            System.out.println("11. Grado exterior");
            System.out.println("12. Sucesores");
            System.out.println("13. Predecesores");
            System.out.println("14. Guardar");
            System.out.println("15. Leer de un archivo");
            System.out.println("16. Salir\n");
            int hacer = Console.readInt("Que desea hacer?\n");
  
            if(hacer == 1) {
                Vertice o = new Vertice(Console.readString("Etiqueta"),Console.readDouble("Peso"));
                g.agregarVertice(o);
   
                } else if(hacer == 2) {
                g.eliminarVertice(Console.readString("Etiqueta"));
   
                } else if(hacer ==3) {
                Set verts = g.vertices();
                Iterator x = verts.iterator();
				
				if(verts.size() == 0) {System.out.println("No hay vertices en el grafo");} else {
   
                while(x.hasNext()) {
                    System.out.println((String) x.next());
	            }
	            }
                } else if(hacer == 4) {
                Set lads = g.lados();
                Iterator x = lads.iterator();
                
				if(lads.size() == 0) {System.out.println("No hay lados en el grafo");} else {
				
                while(x.hasNext()) {
                    System.out.println((String) x.next());
	            }
	            }
                } else if(hacer ==5) {
                Vertice o = g.getVertice(Console.readString("Etiqueta"));
                int k = g.grado(o);
                System.out.println(k);
  
                } else if(hacer == 6) {
                Set adys = g.adyacentes(Console.readString("Etiqueta"));
                Iterator x = adys.iterator();
   
                while(x.hasNext()) {
                    System.out.println((String) x.next());
	            }
	
                } else if(hacer ==7) {
				String etq = Console.readString("Etiqueta");
                Set inci = g.incidentes(etq);
                Iterator x = inci.iterator();
   
                if(inci.size() == 0) {System.out.println("No existen lados incidentes al vertice con etiqueta "+etq);} else {
   
                while(x.hasNext()) {
                    System.out.println((String) x.next());
	            }
	            }
                } else if(hacer == 8) {
                String etiq = Console.readString("Etiqueta");
                double pes = Console.readDouble("Peso");
                System.out.println("vertice de salida");
                Vertice ver1 = g.getVertice(Console.readString("Etiqueta"));
                System.out.println("vertice de llegada");
                Vertice ver2 = g.getVertice(Console.readString("Etiqueta"));
                g.agregarArco(new Arco(etiq,pes,ver1,ver2));
   
               } else if(hacer ==9) {
                g.eliminarArco(Console.readString("Etiqueta de arco"));
   
               } else if(hacer == 10) {
                System.out.println(g.gradoInterior(Console.readString("Etiqueta de vertice")));
   
               } else if(hacer ==11) {
                System.out.println(g.gradoExterior(Console.readString("Etiqueta de vertice")));
   
               } else if(hacer == 12) {
			    String etq = Console.readString("Etiqueta de vertice");
                Set t = g.sucesores(etq);
                Iterator t1 = t.iterator();
				
				if(t.size() == 0) {System.out.println("No existen vertices sucesores al vertice con etiqueta "+etq);} else {
				
               while(t1.hasNext()) {
                   System.out.println((String) t1.next());
                }
               }
               } else if(hacer ==13) {
			   String etq = Console.readString("Etiqueta de vertice");
               Set cosa = g.predecesores(etq);
               Iterator t2 = cosa.iterator();
			   
			   if(cosa.size() == 0) {System.out.println("No existen vertices predecesores al vertice con etiqueta "+etq);} else {
			   
               while(t2.hasNext()) {
                   System.out.println((String) t2.next());
               }                                                               
               }
               } else if(hacer ==14) { 
               try{
               g.guardar(Console.readString("Guardar en "));
               }catch (IOException e){
               } 
               } else if(hacer ==15) { 
               String nombreAr = Console.readString("Nombre de archivo");
               int dummy=-1;
               try{
                   dummy = g.leerTipo(nombreAr);
	               }catch (IOException e){
	               }catch (archivoInvalidoException e){
	               } 
	               if (dummy == 1){
                       g = new GrafoDirigido(nombreAr);
                    }
               }
               else { estado = false;}
                      }
                 } else if (caso == 1) {

               GrafoNoDirigido g = new GrafoNoDirigido();
               boolean estado = true;
  
               while(estado) {
 
               System.out.println("1. Agregar vertice"); 
               System.out.println("2. Eliminar vertice");
               System.out.println("3. Vertices");
               System.out.println("4. Lados");
               System.out.println("5. Grado");
               System.out.println("6. Adyacentes");
               System.out.println("7. Incidentes");
               System.out.println("8. Agregar arista");
               System.out.println("9. Eliminar arista");
               System.out.println("10. Guardar en archivo");
               System.out.println("11. Leer de archivo");
               System.out.println("12. Salir");
			   System.out.println("");
               int hacer = Console.readInt("Que desea hacer?");
			   System.out.println("");
  
               if(hacer == 1) {
               Vertice o = new Vertice(Console.readString("Etiqueta"),Console.readDouble("peso"));
               g.agregarVertice(o);
   
               } else if(hacer == 2) {
               g.eliminarVertice(Console.readString("Etiqueta"));
   
               } else if(hacer ==3) {
               Set verts = g.vertices();
               Iterator x = verts.iterator();
   
               if(verts.size() == 0) {System.out.println("No hay vertices en el grafo");} else {
   
                while(x.hasNext()) {
                    System.out.println((String) x.next());
	           }
	           }
               } else if(hacer == 4) {
               Set lads = g.lados();
               Iterator x = lads.iterator();
			   
			   if(lads.size() == 0) {System.out.println("No hay lados en el grafo");} else {
   
               while(x.hasNext()) {
                      System.out.println((String) x.next());
	           }
	           }
               } else if(hacer ==5) {
               Vertice o = g.getVertice(Console.readString("Etiqueta"));
               int k = g.grado(o);
               System.out.println(k);
  
               } else if(hacer == 6) {
               Set adys = g.adyacentes(Console.readString("Etiqueta"));
               Iterator x = adys.iterator();
   
               while(x.hasNext()) {
                     System.out.println((String) x.next());
	           }
	
               } else if(hacer ==7) {
			    String etq = Console.readString("Etiqueta");
                Set inci = g.incidentes(etq);
                Iterator x = inci.iterator();
   
               if(inci.size() == 0) {System.out.println("No existen lados incidentes al vertice con etiqueta "+etq);} else {

               while(x.hasNext()) {
                     System.out.println((String) x.next());
	           }
	           }
               } else if(hacer == 8) {
               String etiq = Console.readString("Etiqueta");
               double pes = Console.readDouble("Peso");
               System.out.println("Vertice 1");
               Vertice ver1 = g.getVertice(Console.readString("Etiqueta"));
               System.out.println("Vertice 2");
               Vertice ver2 = g.getVertice(Console.readString("Etiqueta"));
               g.agregarArista(new Arista(etiq,pes,ver1,ver2));
   
               } else if(hacer ==9) {
               g.eliminarArista(Console.readString("Etiqueta de arista"));
   
               } else if(hacer ==10) { 
                   try{
                       g.guardar(Console.readString("Guardar en "));
                       }catch (IOException e){
                       }
               } else if(hacer ==11) {
               String nombreAr = Console.readString("Nombre de archivo");
               int dummy=-1;
               try{
                   dummy = g.leerTipo(nombreAr);
	               }catch (IOException e){
	               }catch (archivoInvalidoException e){
	               } 
	               if (dummy == 0){
                       g = new GrafoNoDirigido(nombreAr);
                    }  
               }  else { estado = false;}
  
                 }
                 }
    }
}
//******************************************************FIN PROGRAMA PRINCIPAL********************************************
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
    lista.add(ver2);} catch (Exception e) { System.out.println("Alguno de los vertices asignados no estan en el grafo");}
  
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
    } catch (Exception e) {System.out.println("El arco no se encuentra representado en el grafo");}
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
   
        if(vert.idVertice.equals(idVert)) {
            k++;
        }
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

        while(y.hasNext()) {
            k.add((String) ((Vertice) y.next()).idVertice);
        }
        }
    }

    return k;
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

    /**Se obtiene un conjunto de String correspondiente a los lados que inciden en el vertice cuya etiqueta es idVert*/
    public Set incidentes(String idVert) {
 
    	Iterator x = this.Lados.iterator();
    	Set incs = new HashSet();
 
    	while(x.hasNext()) {
 
            Arista lado = (Arista) x.next();
            if(lado.vert1.idVertice.equals(idVert) || lado.vert2.idVertice.equals(idVert)) { 
            	incs.add(lado);
            } 
    	}
      	return incs;
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
