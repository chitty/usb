/**
 * Archivo: auteImpl.java
 * <p>
 * contiene la definicion del tipo auteImpl y la implementacion de las
 * funciones que pueden ser invocadas remotamente mediante una conexion RMI
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import java.util.*;
import nanoxml.*;

public class auteImpl
    extends 
      java.rmi.server.UnicastRemoteObject
    implements auteInterfaz {

    private XMLElement xml;
    private LinkedList conectados;
    private LinkedList NOconectados;
    private Cuenta cuenta;

    /**
     * Constructor que inicializa los campos del tipo auteImpl
     * <p>
     * @param  cuentas  nombre del archivo de cuentas en formato xml
     */
    public auteImpl(String cuentas)
        throws java.rmi.RemoteException {

        super();

        this.xml = new XMLElement();
	this.conectados = new LinkedList();
	this.NOconectados = new LinkedList();
	this.cuenta = new Cuenta();

	    try{
	    	this.xml = funcionesXML.XML(cuentas);
	    } catch(Exception e) {
                System.err.println("Error al leer el archivo de cuentas "+ cuentas +"!");
                System.exit(1);
	    }

	this.NOconectados = funcionesXML.AllUsers(this.xml);
    }


    /**
     * Devuelve una lista que contiene todos los usuarios que
     * estan definidos en el sistema
     * <p>
     * @return  	lista con todos los usuarios
     */
    public LinkedList listaDeUsuarios()
        throws java.rmi.RemoteException{

	return funcionesXML.AllUsers(this.xml);
    }


    /**
     * Genera el challenge para el proceso de autenticacion del
     * usuario actual, esto como primer paso del protocolo CHAP
     * <p>
     * @param	login	login del usuario a autenticar
     * @return  	challenge para autenticar al usuario actual
     */
    public long getChallenge(String login)
        throws java.rmi.RemoteException {

	Random generator = new Random();  // genera el challenge
	this.cuenta.setChallenge( generator.nextInt() );
	this.cuenta.setLogin(login);

        return this.cuenta.getChallenge();
    }


    /**
     * Revisa el response recibido a ver si coincide con la informacion
     * registrada en el archivo de cuentas, como segundo paso del protocolo CHAP
     * <p>
     * @param	response  response del usuario a autenticar
     * @return  	  usuario valido (SUCCESS=3) o no valido (FAILURE=4)
     */
    public int autenticarUsu(String response)
        throws java.rmi.RemoteException {
	
	String secret = "";
	String resp = "";
	String login = "";
	String alias = "";
	String clave = "";
	boolean loginInvalido = false;


	try{
	    secret = funcionesXML.obtenerClave(this.xml,this.cuenta.getLogin());
	} catch (Exception e){
	    System.out.println("excepcion llamando a obtenerClave!");
	}

        if ( secret == null ){
	    System.out.println("Fallo la autenticacion, el login "+this.cuenta.getLogin()+" no existe!");
            loginInvalido = true;
	} else {

	 StringTokenizer tokens = new StringTokenizer(secret);  
	 if(tokens.hasMoreTokens())
	    login = tokens.nextToken().trim();
	 if(tokens.hasMoreTokens())
	    clave = tokens.nextToken().trim();
	 if(tokens.hasMoreTokens())
	    alias = tokens.nextToken().trim();

	 this.cuenta.setClave(clave);
	 this.cuenta.setAlias(alias);

	 try{
	    resp = MD5.md5(this.cuenta.getChallenge()+clave);
	 }catch (Exception e){
	    System.err.println("Error de la funcion MD5!");
	    System.exit(1);
	 }
	 System.out.println("\n\tPROCESO DE AUTENTICACION");
	 System.out.println("Login: " + this.cuenta.getLogin());
	 System.out.println("Alias: " + this.cuenta.getAlias());
	 System.out.println("Clave: " + this.cuenta.getClave());
	 System.out.println("Challenge: " + this.cuenta.getChallenge() );
	 System.out.println("Clave Cifrada: " + resp + "\n");
        }

	if (response.equals(resp)) {
	    System.out.println("El usuario "+alias+" ha sido autenticado.");
	    if ( this.NOconectados.contains(alias) )
	    	this.NOconectados.remove(alias);
	    if ( !this.conectados.contains(alias) )
	    	this.conectados.add(alias);
	    return 3; // SUCCESS
	} else {
	    if ( !loginInvalido )
	        System.out.println("Fallo la autenticacion, clave invalida!");
	    return 4; // FAILURE
	}
    }


    /**
     * Crea una lista con todos los usuarios que estan
     * conectados y autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios conectados
     */
    public String Conectados()
        throws java.rmi.RemoteException{

	String alias = "";
	String usuarios = "";
	Iterator it = this.conectados.iterator();

	while(it.hasNext()){
	    alias = (String) it.next();
	    usuarios += " -- "+alias; 
	}

	return usuarios;
    }


    /**
     * Crea una lista con todos los usuarios que NO estan
     * conectados y/o autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios NO conectados
     */
    public String NoConectados()
        throws java.rmi.RemoteException{

	String alias = "";
	String usuarios = "";
	Iterator it = this.NOconectados.iterator();

	while(it.hasNext()){
	    alias = (String) it.next();
	    usuarios += " -- "+alias; 
	}

	return usuarios;
    }


    /**
     * Cierra la autenticacion del usuario en el sistema y lo
     * elimina de la lista de usuarios conectados y lo agrega
     * en la lista de usuarios NO conectados
     */
    public void LogOut()
        throws java.rmi.RemoteException{

	this.NOconectados.add(this.cuenta.getAlias());
    	this.conectados.remove(this.cuenta.getAlias());
    }


    /**
     * Devuelve el alias del usuario actual
     * <p>
     * @return		alias del usuario actual
     */
    public String getAlias()
        throws java.rmi.RemoteException{

	return this.cuenta.getAlias();
    }

}
