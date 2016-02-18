/*
 * Archivo: ClienteLista.java
 *
 * Descripcion: programa cliente para el TAD Administrador De Musica
 * Autor: Carlos Chitty    07-41896
 * Fecha marzo 2009
 */

package ve.usb.reproductor;
import corejava.*;
class ClienteLista {

    public static void conLista (AdministradorListas admin) {

	int opcion;
	boolean salir = false;
	String titulo = "";
	String interprete = ""; 
	String ubicacion = ""; 
	String duracion = "";
	String dummy = ""; 

	do{
	   menu();
	   opcion = Console.readInt("");

	    switch (opcion){
		case 1:
		    System.out.println("Ingrese la informacion de la cancion a agregar:");
		    titulo = Console.readString("Titulo: ");
		    interprete = Console.readString("Interprete: ");
		    ubicacion = Console.readString("Ubicacion: ");
		    duracion = Console.readString("Duracion: ");
		    try{
			Cancion cancionNueva = new Cancion(titulo,interprete,ubicacion,duracion);
			admin.agregarCancion( cancionNueva );		
		    }catch(noHaySuficienteEspacioException e){

		    }catch(cancionNoValidaException e2){

		    }
		    continue;
		case 2:
		    dummy = Console.readString("Ingrese el nombre del archivo: ");
	/*	    try{
			admin.agregarLista( dummy );		
		    }catch(noHaySuficienteEspacioException e){

		    }catch(cancionNoValidaException e2){

		    }
                    */
		    continue;
		case 3:
		    System.out.println("Ingrese la informacion de la cancion a eliminar:");
		    titulo = Console.readString("Titulo: ");
		    interprete = Console.readString("Interprete: ");
		    ubicacion = Console.readString("Ubicacion: ");
		    duracion = Console.readString("Duracion: ");
		    Cancion cancionEliminar = new Cancion(titulo,interprete,ubicacion,duracion);
		    admin.eliminarCancion(cancionEliminar);
		    continue;
		case 4:
		    admin.eliminarLista();
		    System.out.println("4");
		    continue;
		case 5:
		    System.out.println("Ingrese la informacion de la cancion a buscar:");
		    titulo = Console.readString("Titulo: ");
		    interprete = Console.readString("Interprete: ");
		    if ( admin.buscarCancion(admin,interprete,titulo) == null ){
			System.out.println("La cancion NO esta!");
		    }else {
			System.out.println("La cancion SI esta!");
                        Cancion esta = admin.buscarCancion(admin,interprete,titulo);
		    }		
		    continue;
		case 6:
		    System.out.println("Ingrese la informacion aproximada de la cancion a buscar:");
		    titulo = Console.readString("Titulo: ");
		    interprete = Console.readString("Interprete: ");
		    if ( admin.buscarCancionAprox(admin,interprete,titulo) == null ){
			System.out.println("La cancion NO esta!");
		    }else {
			System.out.println("La cancion SI esta!");
                        Cancion esta = admin.buscarCancionAprox(admin,interprete,titulo);
		    }		
		    continue;
		case 7:
		    System.out.println("7");
		    continue;
		case 8:
		    System.out.println("8");
		    continue;
		case 9:
		    System.out.println("9");
		    continue;
		case 10:
		    System.out.println("10");
		    continue;
		case 11:
		    System.out.println("11");
		    continue;
		case 12:
		    System.out.println("\tGoodbye!\n");
		    salir = true;
		    break;
		default:
		    System.out.println("\tOpcion Invalida!\n\n\tIntente de nuevo...");
		    continue;
	    }
		
	}while(!salir);

    }

    public static void menu(){
        System.out.println("\n\tOPCIONES\n"); 
        System.out.println("1) Agregar Cancion"); 
	System.out.println("2) Agregar Lista de Canciones"); 
	System.out.println("3) Eliminar Cancion"); 
	System.out.println("4) Eliminar Lista de Canciones"); 
	System.out.println("5) Buscar Cancion"); 
	System.out.println("6) Buscar Cancion Aproximada"); 
	System.out.println("7) Iniciar Reproduccion"); 
	System.out.println("8) Pausar Reproduccion"); 
	System.out.println("9) Continuar Reproduccion"); 
	System.out.println("10) Siguiente Cancion en Reproduccion"); 
	System.out.println("11) Listar Canciones"); 
	System.out.println("12) Salir del Sistema"); 
    }
}

