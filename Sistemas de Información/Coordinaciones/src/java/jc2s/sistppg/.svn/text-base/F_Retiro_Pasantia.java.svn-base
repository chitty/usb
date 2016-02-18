package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Retiro_Pasantia extends org.apache.struts.action.ActionForm {
    
    
    public F_Retiro_Pasantia() {
        super();
        carta_retiro_tutor_academico = "";
        carta_retiro_tutor_industrial = "";
        carta_retiro_estudiante = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        carta_retiro_tutor_academico = "";
        carta_retiro_tutor_industrial = "";
        carta_retiro_estudiante = "";

    }

    public static F_Retiro_Pasantia clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Retiro_Pasantia fF_Retiro_Pasantia = (F_Retiro_Pasantia) sess.getAttribute("F_Retiro_Pasantia");
        if (fF_Retiro_Pasantia == null) {
            fF_Retiro_Pasantia = new F_Retiro_Pasantia();
            sess.setAttribute("F_Retiro_Pasantia", fF_Retiro_Pasantia);
        } else {
            fF_Retiro_Pasantia.reset(mapping, request);
        }
        return fF_Retiro_Pasantia;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property carta_retiro_tutor_academico.
     */
    private String carta_retiro_tutor_academico;

    /**
     * Getter for property carta_retiro_tutor_academico.
     * @return Value of property carta_retiro_tutor_academico.
     */
    public String getCarta_retiro_tutor_academico() {
        return this.carta_retiro_tutor_academico;
    }

    /**
     * Setter for property carta_retiro_tutor_academico.
     * @param carta_retiro_tutor_academico New value of property carta_retiro_tutor_academico.
     */
    public void setCarta_retiro_tutor_academico(String carta_retiro_tutor_academico) {
        this.carta_retiro_tutor_academico = carta_retiro_tutor_academico;
    }

    /**
     * Holds value of property carta_retiro_tutor_industrial.
     */
    private String carta_retiro_tutor_industrial;

    /**
     * Getter for property carta_retiro_tutor_industrial.
     * @return Value of property carta_retiro_tutor_industrial.
     */
    public String getCarta_retiro_tutor_industrial() {
        return this.carta_retiro_tutor_industrial;
    }

    /**
     * Setter for property carta_retiro_tutor_industrial.
     * @param carta_retiro_tutor_industrial New value of property carta_retiro_tutor_industrial.
     */
    public void setCarta_retiro_tutor_industrial(String carta_retiro_tutor_industrial) {
        this.carta_retiro_tutor_industrial = carta_retiro_tutor_industrial;
    }

    /**
     * Holds value of property carta_retiro_estudiante.
     */
    private String carta_retiro_estudiante;

    /**
     * Getter for property carta_retiro_estudiante.
     * @return Value of property carta_retiro_estudiante.
     */
    public String getCarta_retiro_estudiante() {
        return this.carta_retiro_estudiante;
    }

    /**
     * Setter for property carta_retiro_estudiante.
     * @param carta_retiro_estudiante New value of property carta_retiro_estudiante.
     */
    public void setCarta_retiro_estudiante(String carta_retiro_estudiante) {
        this.carta_retiro_estudiante = carta_retiro_estudiante;
    }




}