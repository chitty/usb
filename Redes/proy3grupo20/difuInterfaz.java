/**
 * Archivo: difuInterfaz.java
 * <p>
 * contiene el prototipo de las funciones que pueden ser invocadas
 * remotamente mediante una conexion RMI
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

public interface difuInterfaz 
          extends java.rmi.Remote {

    /**
     * Envia el login del usuario a aute, y envia a usu el challenge
     * generado por el servidor de autenticacion aute, esto como
     * primer paso del protocolo CHAP
     * <p>
     * @param	login	login del usuario a autenticar
     * @return  	challenge para autenticar a un usuario en usu
     */
    public long enviarChallenge(String login)
        throws java.rmi.RemoteException;

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
        throws java.rmi.RemoteException;

    /**
     * Muestra a un cliente usu todos los usuarios que estan
     * conectados y autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios conectados
     */
    public String mostrarConectados()
        throws java.rmi.RemoteException;

    /**
     * Muestra a un cliente usu todos los usuarios que NO estan
     * conectados y/o autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios NO conectados
     */
    public String mostrarNoConectados()
        throws java.rmi.RemoteException;

    /**
     * Cierra la autenticacion del usuario en el sistema
     */
    public void cerrarAute()
        throws java.rmi.RemoteException;

    /**
     * Suscribe al usuario actual al usuario del alias proporcionado
     * en caso de que exista. Si no existe no pasa nada
     * <p>
     * @param	alias	usuario al que se desea suscribir
     */
    public void suscribirseA(String alias)
        throws java.rmi.RemoteException;

    /**
     * Almacena un mensaje en cada una de las listas 
     * de los suscriptores del emisor del mensaje, si no hay
     * suscriptores el mensaje es descartado
     * <p>
     * @param	msg	mensaje emitido
     */
    public void Mensaje(String msg)
        throws java.rmi.RemoteException;

    /**
     * Almacena un mensaje en la lista particular del usuario 
     * elegido como destinatario. Si el destinatario no existe
     * el mensaje es descartado
     * <p>
     * @param	msg	mensaje particular emitido
     * @param	para	destinatario del mensaje particular emitido
     */
    public void MensajeParticular(String msg, String para)
        throws java.rmi.RemoteException;

    /**
     * Revisa si ha llegado algun mensaje para el usuario actual
     * <p>
     * @return  	  mensaje pendiente, y si no hay mensaje pendiente
     *			  retorna null
     */
    public String llegoMensaje()
        throws java.rmi.RemoteException;
}
