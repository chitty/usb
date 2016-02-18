package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Pais extends org.apache.struts.action.ActionForm {


    public F_Pais() {
        super();
        nombre = "";
        idPais = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        idPais = "";

    }

    public static F_Pais clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Pais fF_Pais = (F_Pais) sess.getAttribute("F_Pais");
        if (fF_Pais == null) {
            fF_Pais = new F_Pais();
            sess.setAttribute("F_Pais", fF_Pais);
        } else {
            fF_Pais.reset(mapping, request);
        }
        return fF_Pais;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property pais.
     */
    private String nombre;

    /**
     * Getter for property pais.
     * @return Value of property pais.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for property pais.
     * @param pais New value of property pais.
     */
    public void setNombre(String pais) {
        this.nombre = pais;
    }

    private String idPais;

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }


}