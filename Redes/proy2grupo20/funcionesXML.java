/* 
 * Archivo: funcionesXML.java
 * contiene las funciones que manejan el archivo xml
 *
 * Autor: Carlos J. Chitty 07-41896
 */

import nanoxml.*;
import java.io.*;
import java.util.*;

public class funcionesXML{

    /**	Funcion que recibe un nombre de archivo xml hace el parsing
	y devuelve un XMLElement que contiene la informacion  
      */
    public static XMLElement XML(String archivo) throws Exception {
		
	XMLElement xml = new XMLElement();
	FileReader reader = new FileReader(archivo);
	xml.parseFromReader(reader);

	return xml;
    }


    /** Funcion que dado un login devuelve la clave de ese usuario
      * tambien devuelve el login y el alias de ese usuario
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

    /** Funcion que devuelve un String con todos los usuarios definidos en el sistema
      */
    public static String obtenerUsuarios(XMLElement xml) {

	String usuarios = new String();
	XMLElement alias = null;
	Enumeration enum1 = xml.enumerateChildren();

	while (enum1.hasMoreElements()) {

       	    XMLElement usuario = (XMLElement) enum1.nextElement();

	    Enumeration enum2 = usuario.enumerateChildren();

	    // el alias es el 3 elemento en esta enumeracion
	    for (int i=0; i<3; i++)
	        alias = (XMLElement) enum2.nextElement();

	    usuarios = usuarios + " -- " + alias.getContent();
	}

	return usuarios;
    }

}
