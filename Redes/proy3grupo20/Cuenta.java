/**
 * Archivo: Cuenta.java
 * <p>
 * contiene la definicion del tipo Cuenta, que almacena el
 * challenge, login, clave y alias para algun usuario determinado
 * <p>
 * @autor: Carlos J. Chitty 07-41896
 */

public class Cuenta {

    private int challenge;
    private String login;
    private String clave;
    private String alias;

    public void setChallenge(int chllng) {
      this.challenge = chllng;
    }

    public void setLogin(String name) {
      this.login = name;
    }

    public void setClave(String name) {
      this.clave = name;
    }

    public void setAlias(String name) {
      this.alias = name;
    }

   public int getChallenge() {
      return this.challenge;
    }

    public String getLogin() {
      return this.login;
    }

    public String getClave() {
      return this.clave;
    }

    public String getAlias() {
      return this.alias;
    }
}
