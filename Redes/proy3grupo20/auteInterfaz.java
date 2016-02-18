/**
 * Archivo: auteInterfaz.java
 * <p>
 * contiene el prototipo de las funciones que pueden ser invocadas
 * remotamente mediante una conexion RMI
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

import java.util.*;

public interface auteInterfaz 
          extends java.rmi.Remote {

    /**
     * Devuelve una lista que contiene todos los usuarios que
     * estan definidos en el sistema
     * <p>
     * @return  	lista con todos los usuarios
     */
    public LinkedList listaDeUsuarios()
        throws java.rmi.RemoteException;

    /**
     * Genera el challenge para el proceso de autenticacion del
     * usuario actual, esto como primer paso del protocolo CHAP
     * <p>
     * @param	login	login del usuario a autenticar
     * @return  	challenge para autenticar al usuario actual
     */
    public long getChallenge(String login)
        throws java.rmi.RemoteException;

    /**
     * Revisa el response recibido a ver si coincide con la informacion
     * registrada en el archivo de cuentas, como segundo paso del protocolo CHAP
     * <p>
     * @param	response  response del usuario a autenticar
     * @return  	  usuario valido (SUCCESS=3) o no valido (FAILURE=4)
     */
    public int autenticarUsu(String response)
        throws java.rmi.RemoteException;

    /**
     * Crea una lista con todos los usuarios que estan
     * conectados y autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios conectados
     */
    public String Conectados()
        throws java.rmi.RemoteException;

    /**
     * Crea una lista con todos los usuarios que NO estan
     * conectados y/o autenticados en el sistema en ese momento
     * <p>
     * @return		cadena de caracteres con los alias de los usuarios NO conectados
     */
    public String NoConectados()
        throws java.rmi.RemoteException;

    /**
     * Cierra la autenticacion del usuario en el sistema y lo
     * elimina de la lista de usuarios conectados y lo agrega
     * en la lista de usuarios NO conectados
     */
    public void LogOut()
        throws java.rmi.RemoteException;

    /**
     * Devuelve el alias del usuario actual
     * <p>
     * @return		alias del usuario actual
     */
    public String getAlias()
        throws java.rmi.RemoteException;
}
