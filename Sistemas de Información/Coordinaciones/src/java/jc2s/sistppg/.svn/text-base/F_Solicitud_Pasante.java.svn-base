package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Solicitud_Pasante extends org.apache.struts.action.ActionForm {
    
    
    public F_Solicitud_Pasante() {
        super();
        carrera = "";
        periodo = "";
        tipo_pasantia = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        carrera = "";
        periodo = "";
        tipo_pasantia = "";

    }

    public static F_Solicitud_Pasante clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Solicitud_Pasante fF_Solicitud_Pasante = (F_Solicitud_Pasante) sess.getAttribute("F_Solicitud_Pasante");
        if (fF_Solicitud_Pasante == null) {
            fF_Solicitud_Pasante = new F_Solicitud_Pasante();
            sess.setAttribute("F_Solicitud_Pasante", fF_Solicitud_Pasante);
        } else {
            fF_Solicitud_Pasante.reset(mapping, request);
        }
        return fF_Solicitud_Pasante;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property carrera.
     */
    private String carrera;

    /**
     * Getter for property carrera.
     * @return Value of property carrera.
     */
    public String getCarrera() {
        return this.carrera;
    }

    /**
     * Setter for property carrera.
     * @param carrera New value of property carrera.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Holds value of property periodo.
     */
    private String periodo;

    /**
     * Getter for property periodo.
     * @return Value of property periodo.
     */
    public String getPeriodo() {
        return this.periodo;
    }

    /**
     * Setter for property periodo.
     * @param periodo New value of property periodo.
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * Holds value of property tipo_pasantia.
     */
    private String tipo_pasantia;

    /**
     * Getter for property tipo_pasantia.
     * @return Value of property tipo_pasantia.
     */
    public String getTipo_pasantia() {
        return this.tipo_pasantia;
    }

    /**
     * Setter for property tipo_pasantia.
     * @param tipo_pasantia New value of property tipo_pasantia.
     */
    public void setTipo_pasantia(String tipo_pasantia) {
        this.tipo_pasantia = tipo_pasantia;
    }




}