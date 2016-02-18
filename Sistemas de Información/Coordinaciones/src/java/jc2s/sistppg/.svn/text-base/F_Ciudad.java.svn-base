package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Ciudad extends org.apache.struts.action.ActionForm {


    public F_Ciudad() {
        super();
        ciudad = "";
        idCiudad = "";
        pais = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        ciudad = "";
        idCiudad = "";

    }

    public static F_Ciudad clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Ciudad fF_Ciudad = (F_Ciudad) sess.getAttribute("F_Ciudad");
        if (fF_Ciudad == null) {
            fF_Ciudad = new F_Ciudad();
            sess.setAttribute("F_Ciudad", fF_Ciudad);
        } else {
            fF_Ciudad.reset(mapping, request);
        }
        return fF_Ciudad;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

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

    private String idCiudad;

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    private String pais;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}