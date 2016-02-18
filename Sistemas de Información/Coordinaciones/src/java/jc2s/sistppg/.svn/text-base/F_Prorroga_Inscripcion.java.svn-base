package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Prorroga_Inscripcion extends org.apache.struts.action.ActionForm {
    
    
    public F_Prorroga_Inscripcion() {
        super();
        justificacion = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        justificacion = "";

    }

    public static F_Prorroga_Inscripcion clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Prorroga_Inscripcion fF_Prorroga_Inscripcion = (F_Prorroga_Inscripcion) sess.getAttribute("F_Prorroga_Inscripcion");
        if (fF_Prorroga_Inscripcion == null) {
            fF_Prorroga_Inscripcion = new F_Prorroga_Inscripcion();
            sess.setAttribute("F_Prorroga_Inscripcion", fF_Prorroga_Inscripcion);
        } else {
            fF_Prorroga_Inscripcion.reset(mapping, request);
        }
        return fF_Prorroga_Inscripcion;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property justificacion.
     */
    private String justificacion;

    /**
     * Getter for property justificacion.
     * @return Value of property justificacion.
     */
    public String getJustificacion() {
        return this.justificacion;
    }

    /**
     * Setter for property justificacion.
     * @param justificacion New value of property justificacion.
     */
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }




}