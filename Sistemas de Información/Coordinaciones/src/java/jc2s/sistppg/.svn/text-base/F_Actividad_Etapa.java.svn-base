package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Actividad_Etapa extends org.apache.struts.action.ActionForm {
    
    
    public F_Actividad_Etapa() {
        super();
        descripcion = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        descripcion = "";

    }

    public static F_Actividad_Etapa clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Actividad_Etapa fF_Actividad_Etapa = (F_Actividad_Etapa) sess.getAttribute("F_Actividad_Etapa");
        if (fF_Actividad_Etapa == null) {
            fF_Actividad_Etapa = new F_Actividad_Etapa();
            sess.setAttribute("F_Actividad_Etapa", fF_Actividad_Etapa);
        } else {
            fF_Actividad_Etapa.reset(mapping, request);
        }
        return fF_Actividad_Etapa;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property descripcion.
     */
    private String descripcion;

    /**
     * Getter for property descripcion.
     * @return Value of property descripcion.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Setter for property descripcion.
     * @param descripcion New value of property descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}