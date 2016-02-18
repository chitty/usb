package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Inscripcion_PG extends org.apache.struts.action.ActionForm {
    
    
    public F_Inscripcion_PG() {
        super();
        nombre = "";
        estudiante = "";
        recursos = "";
        duracion_recursos = "";
        puntos_de_interes = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        estudiante = "";
        recursos = "";
        duracion_recursos = "";
        puntos_de_interes = "";

    }

    public static F_Inscripcion_PG clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Inscripcion_PG fF_Inscripcion_PG = (F_Inscripcion_PG) sess.getAttribute("F_Inscripcion_PG");
        if (fF_Inscripcion_PG == null) {
            fF_Inscripcion_PG = new F_Inscripcion_PG();
            sess.setAttribute("F_Inscripcion_PG", fF_Inscripcion_PG);
        } else {
            fF_Inscripcion_PG.reset(mapping, request);
        }
        return fF_Inscripcion_PG;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

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
     * Holds value of property nombre.
     */
    private String estudiante;

    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public String getEstudiante() {
        return this.estudiante;
    }

    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Holds value of property recursos.
     */
    private String recursos;

    /**
     * Getter for property recursos.
     * @return Value of property recursos.
     */
    public String getRecursos() {
        return this.recursos;
    }

    /**
     * Setter for property recursos.
     * @param recursos New value of property recursos.
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * Holds value of property duracion_recursos.
     */
    private String duracion_recursos;

    /**
     * Getter for property duracion_recursos.
     * @return Value of property duracion_recursos.
     */
    public String getDuracion_recursos() {
        return this.duracion_recursos;
    }

    /**
     * Setter for property duracion_recursos.
     * @param duracion_recursos New value of property duracion_recursos.
     */
    public void setDuracion_recursos(String duracion_recursos) {
        this.duracion_recursos = duracion_recursos;
    }

    /**
     * Holds value of property puntos_de_interes.
     */
    private String puntos_de_interes;

    /**
     * Getter for property puntos_de_interes.
     * @return Value of property puntos_de_interes.
     */
    public String getPuntos_de_interes() {
        return this.puntos_de_interes;
    }

    /**
     * Setter for property puntos_de_interes.
     * @param puntos_de_interes New value of property puntos_de_interes.
     */
    public void setPuntos_de_interes(String puntos_de_interes) {
        this.puntos_de_interes = puntos_de_interes;
    }




}