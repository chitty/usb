package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Registro_Empresa extends org.apache.struts.action.ActionForm {
    
    
    public F_Registro_Empresa() {
        super();
        login = "";
        password = "";
        confirmar_password = "";
        nombre = "";
        rif = "";
        telefono = "";
        direccion = "";
        email = "";
        pais = "";
        ciudad = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        login = "";
        password = "";
        confirmar_password = "";
        nombre = "";
        rif = "";
        telefono = "";
        direccion = "";
        email="";
        pais = "";
        ciudad = "";

    }

    public static F_Registro_Empresa clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Registro_Empresa fF_Registro_Empresa = (F_Registro_Empresa) sess.getAttribute("F_Registro_Empresa");
        if (fF_Registro_Empresa == null) {
            fF_Registro_Empresa = new F_Registro_Empresa();
            sess.setAttribute("F_Registro_Empresa", fF_Registro_Empresa);
        } else {
            fF_Registro_Empresa.reset(mapping, request);
        }
        return fF_Registro_Empresa;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property login.
     */
    private String login;

    /**
     * Getter for property login.
     * @return Value of property login.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Setter for property login.
     * @param login New value of property login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Holds value of property password.
     */
    private String password;

    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Holds value of property confirmar_password.
     */
    private String confirmar_password;

    /**
     * Getter for property confirmar_password.
     * @return Value of property confirmar_password.
     */
    public String getConfirmar_password() {
        return this.confirmar_password;
    }

    /**
     * Setter for property confirmar_password.
     * @param confirmar_password New value of property confirmar_password.
     */
    public void setConfirmar_password(String confirmar_password) {
        this.confirmar_password = confirmar_password;
    }

    /**
     * Holds value of property nombre.
     */
    private String nombre;

    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Holds value of property rif.
     */
    private String rif;

    /**
     * Getter for property rif.
     * @return Value of property rif.
     */
    public String getRif() {
        return this.rif;
    }

    /**
     * Setter for property rif.
     * @param rif New value of property rif.
     */
    public void setRif(String rif) {
        this.rif = rif;
    }

    /**
     * Holds value of property telefono.
     */
    private String telefono;

    /**
     * Getter for property telefono.
     * @return Value of property telefono.
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Setter for property telefono.
     * @param telefono New value of property telefono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Holds value of property direccion.
     */
    private String direccion;

    /**
     * Getter for property direccion.
     * @return Value of property direccion.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Setter for property direccion.
     * @param direccion New value of property direccion.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     /**
     * Holds value of property email.
     */
    private String email = "";

    /**
     * Getter for property email.
     * @return Value of property email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Holds value of property pais.
     */
    private String pais;

    /**
     * Getter for property pais.
     * @return Value of property pais.
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * Setter for property pais.
     * @param pais New value of property pais.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Holds value of property ciudad.
     */
    private String ciudad;

    /**
     * Getter for property ciudad.
     * @return Value of property ciudad.
     */
    public String getCiudad() {
        return this.ciudad;
    }

    /**
     * Setter for property ciudad.
     * @param ciudad New value of property ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }




}