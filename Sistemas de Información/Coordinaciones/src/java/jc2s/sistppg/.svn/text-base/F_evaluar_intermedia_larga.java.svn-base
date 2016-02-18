package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_evaluar_intermedia_larga extends org.apache.struts.action.ActionForm {


    public F_evaluar_intermedia_larga() {
        super();
        evaluacion = "";
        idPasantia = "";
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        evaluacion = "";
        idPasantia = "";

    }

    public static F_Tutor_Industrial clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Tutor_Industrial fF_Tutor_Industrial = (F_Tutor_Industrial) sess.getAttribute("F_Tutor_Industrial");
        if (fF_Tutor_Industrial == null) {
            fF_Tutor_Industrial = new F_Tutor_Industrial();
            sess.setAttribute("F_Tutor_Industrial", fF_Tutor_Industrial);
        } else {
            fF_Tutor_Industrial.reset(mapping, request);
        }
        return fF_Tutor_Industrial;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property nombre.
     */
    private String evaluacion;

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */

     private String idPasantia;

    public String getIdPasantia() {
        return idPasantia;
    }

    public void setIdPasantia(String idPasantia) {
        this.idPasantia = idPasantia;
    }

}