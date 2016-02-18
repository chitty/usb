package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Inscripcion_Pasantia extends org.apache.struts.action.ActionForm {
    
    
    public F_Inscripcion_Pasantia() {
        super();
        titulo_pasantia = "";
        tipo = "";
        periodo = "";
        tutor_academico = "";
        tutor_industrial = "";
        objetivos = "";
        resumen = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        titulo_pasantia = "";
        tipo = "";
        periodo = "";
        tutor_academico = "";
        tutor_industrial = "";
        objetivos = "";
        resumen = "";

    }

    public static F_Inscripcion_Pasantia clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Inscripcion_Pasantia fF_Inscripcion_Pasantia = (F_Inscripcion_Pasantia) sess.getAttribute("F_Inscripcion_Pasantia");
        if (fF_Inscripcion_Pasantia == null) {
            fF_Inscripcion_Pasantia = new F_Inscripcion_Pasantia();
            sess.setAttribute("F_Inscripcion_Pasantia", fF_Inscripcion_Pasantia);
        } else {
            fF_Inscripcion_Pasantia.reset(mapping, request);
        }
        return fF_Inscripcion_Pasantia;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property titulo_pasantia.
     */
    private String titulo_pasantia;

    /**
     * Getter for property titulo_pasantia.
     * @return Value of property titulo_pasantia.
     */
    public String getTitulo_pasantia() {
        return this.titulo_pasantia;
    }

    /**
     * Setter for property titulo_pasantia.
     * @param titulo_pasantia New value of property titulo_pasantia.
     */
    public void setTitulo_pasantia(String titulo_pasantia) {
        this.titulo_pasantia = titulo_pasantia;
    }

    /**
     * Holds value of property tipo.
     */
    private String tipo;

    /**
     * Getter for property tipo.
     * @return Value of property tipo.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * Setter for property tipo.
     * @param tipo New value of property tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @param tipo New value of property tipo.
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


    /**
     * Holds value of property tutor_academico.
     */
    private String tutor_academico;

    /**
     * Getter for property tutor_academico.
     * @return Value of property tutor_academico.
     */
    public String getTutor_academico() {
        return this.tutor_academico;
    }

    /**
     * Setter for property tutor_academico.
     * @param tutor_academico New value of property tutor_academico.
     */
    public void setTutor_academico(String tutor_academico) {
        this.tutor_academico = tutor_academico;
    }

    /**
     * Holds value of property tutor_industrial.
     */
    private String tutor_industrial;

    /**
     * Getter for property tutor_industrial.
     * @return Value of property tutor_industrial.
     */
    public String getTutor_industrial() {
        return this.tutor_industrial;
    }

    /**
     * Setter for property tutor_industrial.
     * @param tutor_industrial New value of property tutor_industrial.
     */
    public void setTutor_industrial(String tutor_industrial) {
        this.tutor_industrial = tutor_industrial;
    }

    /**
     * Holds value of property objetivos.
     */
    private String objetivos;

    /**
     * Getter for property objetivos.
     * @return Value of property objetivos.
     */
    public String getObjetivos() {
        return this.objetivos;
    }

    /**
     * Setter for property objetivos.
     * @param objetivos New value of property objetivos.
     */
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * Holds value of property resumen.
     */
    private String resumen;

    /**
     * Getter for property resumen.
     * @return Value of property resumen.
     */
    public String getResumen() {
        return this.resumen;
    }

    /**
     * Setter for property resumen.
     * @param resumen New value of property resumen.
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }




}