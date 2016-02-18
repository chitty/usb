package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Actividad_Fase extends org.apache.struts.action.ActionForm {
    
    
    public F_Actividad_Fase() {
        super();
        descripcion = "";
        tiempo_estimado = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        descripcion = "";
        tiempo_estimado = "";

    }

    public static F_Actividad_Fase clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Actividad_Fase fF_Actividad_Fase = (F_Actividad_Fase) sess.getAttribute("F_Actividad_Fase");
        if (fF_Actividad_Fase == null) {
            fF_Actividad_Fase = new F_Actividad_Fase();
            sess.setAttribute("F_Actividad_Fase", fF_Actividad_Fase);
        } else {
            fF_Actividad_Fase.reset(mapping, request);
        }
        return fF_Actividad_Fase;
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

    /**
     * Holds value of property tiempo_estimado.
     */
    private String tiempo_estimado;

    /**
     * Getter for property tiempo_estimado.
     * @return Value of property tiempo_estimado.
     */
    public String getTiempo_estimado() {
        return this.tiempo_estimado;
    }

    /**
     * Setter for property tiempo_estimado.
     * @param tiempo_estimado New value of property tiempo_estimado.
     */
    public void setTiempo_estimado(String tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }




}