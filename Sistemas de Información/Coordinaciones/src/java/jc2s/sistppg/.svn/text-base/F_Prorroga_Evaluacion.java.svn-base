package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Prorroga_Evaluacion extends org.apache.struts.action.ActionForm {
    
    
    public F_Prorroga_Evaluacion() {
        super();
        fecha_propuesta = "";
        justificacion = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        fecha_propuesta = "";
        justificacion = "";

    }

    public static F_Prorroga_Evaluacion clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Prorroga_Evaluacion fF_Prorroga_Evaluacion = (F_Prorroga_Evaluacion) sess.getAttribute("F_Prorroga_Evaluacion");
        if (fF_Prorroga_Evaluacion == null) {
            fF_Prorroga_Evaluacion = new F_Prorroga_Evaluacion();
            sess.setAttribute("F_Prorroga_Evaluacion", fF_Prorroga_Evaluacion);
        } else {
            fF_Prorroga_Evaluacion.reset(mapping, request);
        }
        return fF_Prorroga_Evaluacion;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property fecha_propuesta.
     */
    private String fecha_propuesta;

    /**
     * Getter for property fecha_propuesta.
     * @return Value of property fecha_propuesta.
     */
    public String getFecha_propuesta() {
        return this.fecha_propuesta;
    }

    /**
     * Setter for property fecha_propuesta.
     * @param fecha_propuesta New value of property fecha_propuesta.
     */
    public void setFecha_propuesta(String fecha_propuesta) {
        this.fecha_propuesta = fecha_propuesta;
    }

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