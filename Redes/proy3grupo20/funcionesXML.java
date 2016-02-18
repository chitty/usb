/**
 * Archivo: funcionesXML.java
 * <p>
 * contiene las funciones para el manejo de archivos de cuentas en formato xml
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import nanoxml.*;
import java.io.*;
import java.util.*;

public class funcionesXML{


    /**
     * Interpreta un archivo de cuentas en formato xml
     * <p>
     * @param	archivo	el nombre de el archivo xml
     * @return  	estructura de datos que contiene la informacion del archivo de cuentas
     */
    public static XMLElement XML(String archivo) throws Exception {
		
	XMLElement xml = new XMLElement();
	FileReader reader = new FileReader(archivo);
	xml.parseFromReader(reader);

	return xml;
    }


    /**
     * Obtiene la clave y alias de un usuario 
     * <p>
     * @param	log	login del usuario del que se requiere clave y/o alias
     * @param	xml	estructura de datos que contiene la informacion de los usuarios
     * @return  	cadena de caracteres con login, clave y alias
     */
    public static String obtenerClave(XMLElement xml, String log) throws Exception  {

	Enumeration enum1 = xml.enumerateChildren();
	String info = null;

	while (enum1.hasMoreElements()) {

       	    XMLElement usuario = (XMLElement) enum1.nextElement();

	    Enumeration enum2 = usuario.enumerateChildren();

	    XMLElement login = (XMLElement) enum2.nextElement();
	    XMLElement clave = (XMLElement) enum2.nextElement();
	    XMLElement alias = (XMLElement) enum2.nextElement();

	    if ( log.equals(login.getContent()) ){
		info = login.getContent()+" "+clave.getContent()+" "+alias.getContent();
		break;
	    }	
		
	}

	return info;
    }


    /**
     * Obtiene la lista de usuarios definidos en el sistema 
     * <p>
     * @param	xml	estructura de datos que contiene la informacion de los usuarios
     * @return  	lista con todos los usuarios definidos en el sistema
     */
    public static LinkedList AllUsers(XMLElement xml) {

	LinkedList usuarios = new LinkedList();
	XMLElement alias = null;
	Enumeration enum1 = xml.enumerateChildren();

	while (enum1.hasMoreElements()) {

       	    XMLElement usuario = (XMLElement) enum1.nextElement();

	    Enumeration enum2 = usuario.enumerateChildren();

	    // el alias es el 3er elemento en esta enumeracion
	    for (int i=0; i<3; i++)
	        alias = (XMLElement) enum2.nextElement();

	    usuarios.add( alias.getContent() );
	}

	return usuarios;
    }

}
