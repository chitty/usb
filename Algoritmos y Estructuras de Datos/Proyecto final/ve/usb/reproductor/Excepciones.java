/*
 * Archivo: AdministradorInterface.java
 *
 * Descripcion: interfaz que especifica con modelo abstracto un tipo de datos
 *              Administrador de musica
 * Fecha: marzo 2009
 * Autor: Carlos Chitty
 *
 * Version: 0.1
 */

package ve.usb.reproductor;

class valorNoPositivoException extends Exception
{
  public valorNoPositivoException()
  {
     super("ERROR: valor no positivo!");
  } 
}

class noHaySuficienteEspacioException extends Exception
{
  public noHaySuficienteEspacioException()
  {
    super("ERROR: No Hay Suficiente Espacio!");
  } 
}

class cancionNoValidaException extends Exception
{
  public cancionNoValidaException()
  {
    super("ERROR: Cancion no valida!");
  } 
}
