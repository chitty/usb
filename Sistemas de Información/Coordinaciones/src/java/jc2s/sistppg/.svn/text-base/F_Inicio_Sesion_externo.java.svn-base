package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Inicio_Sesion_externo extends org.apache.struts.action.ActionForm {
    
    
    public F_Inicio_Sesion_externo() {
        super();
        login = "";
        password = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        login = "";
        password = "";

    }

    public static F_Inicio_Sesion_externo clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Inicio_Sesion_externo fF_Inicio_Sesion_externo = (F_Inicio_Sesion_externo) sess.getAttribute("F_Inicio_Sesion_externo");
        if (fF_Inicio_Sesion_externo == null) {
            fF_Inicio_Sesion_externo = new F_Inicio_Sesion_externo();
            sess.setAttribute("F_Inicio_Sesion_externo", fF_Inicio_Sesion_externo);
        } else {
            fF_Inicio_Sesion_externo.reset(mapping, request);
        }
        return fF_Inicio_Sesion_externo;
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




}