/** 
 * Archivo: MD5.java
 * <p>
 * Contiene la funcion MD5 utilizada para la encriptacion del
 * response en el protocolo de autenticacion CHAP
 */

import java.security.*;
import java.math.*;
 
public class MD5 {

    /**
     * Encripta una cadena de caracteres utilizando el algoritmo MD5
     * <p>
     * @param   s  cadena de caracteres a ser encriptada mediante el algoritmo MD5
     * @return  el resultado de aplicar el algoritmo MD5 en la cadena recibida s
     */
    public static String md5(String s) throws Exception{
       	MessageDigest m=MessageDigest.getInstance("MD5");
       	m.update(s.getBytes(),0,s.length());
	String ans = new BigInteger(1,m.digest()).toString(16);
	return ans;
   }
}

