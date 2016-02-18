/**
 * Archivo: difuImpl.java
 * <p>
 * contiene la definicion del tipo difuImpl y la implementacion de las
 * funciones que pueden ser invocadas remotamente mediante una conexion RMI
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import java.rmi.*;
import java.util.*;
import java.net.MalformedURLException;

public class difuImpl
    extends 
      java.rmi.server.UnicastRemoteObject
    implements difuInterfaz {

    protected int puerto;
    protected String host;
    protected auteInterfaz aut;


    /**
     * Constructor que inicializa los campos del tipo difuImpl e
     * inicia la conexion al servidor de autenticacion aute 
     * <p>
     * @param  puerto  puerto del rmiregistry de aute
     * @param  host    host del rmiregistry de aute
     */
    public difuImpl(int puerto, String host)
        throws java.rmi.RemoteException {

        super();

	this.puerto = puerto;
	this.host = host;

	try{
	    this.aut = (auteInterfaz) 
	    Naming.lookup("rmi://"+host+":"+puerto+"/Autenticacion");

        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException: "+murle);

        } catch (RemoteException re) {
            System.out.println("RemoteException: "+re);

        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException: "+nbe);
        }

	// inicializar tabla de suscriptores y de mensajes pendientes
    	LinkedList losUsuarios = this.aut.listaDeUsuarios();
	Iterator it = losUsuarios.iterator();
	String user ="";
	while(it.hasNext()){ 
	    user = (String) it.next();
	    global.Suscriptores.put(user,new LinkedList());
	    global.mensajesPendientes.put(user,new LinkedList());
	}
	
    }


    /**
     * Envia el login del usuario a aute, y envia a usu el challenge
     * generado por el servidor de autenticacion aute, esto como
     * primer paso del protocolo CHAP
     * <p>
     * @param	login	login del usuario a autenticar
     * @return  	challenge para autenticar a un usuario en usu
     */
    public long enviarChallenge(String login)
        throws java.rmi.RemoteException {
	
        return this.aut.getChallenge(login);
    }


    /**
     * Envia el response del usuario a aute para su autenticacion
     * mediante el protocolo CHAP, y le devuelve la respuesta al
     * usuario de si fue autenticado (SUCCESS) o no (FAILURE)
     * esto como segundo paso del protocolo CHAP
     * <p>
     * @param	response  response del usuario a autenticar
     * @return  	  usuario valido (SUCCESS=3) o no valido (FAILURE=4)
     */
    public int response(String response)
        throws java.rmi.RemoteException {
	
        return this.aut.autenticarUsu(response);
    }


    /**
     * Muestra a un cliente usu todos los usuarios que estan
     * conectados y autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios conectados
     */
    public String mostrarConectados()
        throws java.rmi.RemoteException{
	
	return this.aut.Conectados();
    }


    /**
     * Muestra a un cliente usu todos los usuarios que NO estan
     * conectados y/o autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios NO conectados
     */
    public String mostrarNoConectados()
        throws java.rmi.RemoteException{
	
	return this.aut.NoConectados();
    }


    /**
     * Cierra la autenticacion del usuario en el sistema
     */
    public void cerrarAute()
        throws java.rmi.RemoteException {
	
	this.aut.LogOut();
    }


    /**
     * Suscribe al usuario actual al usuario del alias proporcionado
     * en caso de que exista. Si no existe no pasa nada
     * <p>
     * @param	alias	usuario al que se desea suscribir
     */
    public void suscribirseA(String alias)
        throws java.rmi.RemoteException{
   	
	String suscriptor = this.aut.getAlias();
	Set todos = global.Suscriptores.keySet();

	// verificar que el usuario existe
	if ( todos.contains(alias) ){
	     LinkedList lista = (LinkedList) global.Suscriptores.get(alias);
	     if ( !lista.contains(suscriptor) && !suscriptor.equals(alias) ){
		lista.add(suscriptor);
		global.Suscriptores.put(alias,lista);
	     }
	}
    }


    /**
     * Almacena un mensaje en cada una de las listas 
     * de los suscriptores del emisor del mensaje, si no hay
     * suscriptores el mensaje es descartado
     * <p>
     * @param	msg	mensaje emitido
     */
    public void Mensaje(String msg)
        throws java.rmi.RemoteException{
	
	String alias = aut.getAlias();
	LinkedList lista = (LinkedList) global.Suscriptores.get(alias);
	Iterator it = lista.iterator();
	String suscriptor ="";

	if ( lista.size() > 0 ){
	    while( it.hasNext() ){
		suscriptor = (String) it.next();
    		LinkedList l =(LinkedList) global.mensajesPendientes.get(suscriptor);
    		l.add("Alias"+alias+": "+msg);
		global.mensajesPendientes.put(suscriptor,l);
	    }	    
	} else{} // si no hay suscriptores, descartar el mensaje
    }


    /**
     * Almacena un mensaje en la lista particular del usuario 
     * elegido como destinatario. Si el destinatario no existe
     * el mensaje es descartado
     * <p>
     * @param	msg	mensaje particular emitido
     * @param	para	destinatario del mensaje particular emitido
     */
    public void MensajeParticular(String msg, String para)
        throws java.rmi.RemoteException{
	
	String de = aut.getAlias();

	if ( global.mensajesPendientes.containsKey(para) ){
	   
    	    LinkedList l =(LinkedList) global.mensajesPendientes.get(para);
    	    l.add("Alias"+de+": "+msg);
	    global.mensajesPendientes.put(para,l);
	    	    
	} else{} // si no existe ese usuario, descartar el mensaje
    }


    /**
     * Revisa si ha llegado algun mensaje para el usuario actual
     * <p>
     * @return  	  mensaje pendiente, y si no hay mensaje pendiente
     *			  retorna null
     */
    public String llegoMensaje()
        throws java.rmi.RemoteException{

	String alias = aut.getAlias();
	LinkedList lista = (LinkedList) global.mensajesPendientes.get(alias);
	Iterator it = lista.iterator();
	String msg ="";
	String mensajes =null;
	int i=0;

	if ( lista.size() > 0 ){
	    while( it.hasNext() ){
		msg = (String) it.next();
		if ( i == 0)
		    mensajes = msg;
		else
		    mensajes = mensajes + "\n" + msg;
		i++;
	    }
	}

	lista.clear();	    
	global.mensajesPendientes.put(alias,lista);
  	
	return mensajes;
    }
}

class global{
    public static HashMap Suscriptores = new HashMap();
    public static HashMap mensajesPendientes = new HashMap();
}
