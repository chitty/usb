package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Fase_Pasantia extends org.apache.struts.action.ActionForm {
    
    
    public F_Fase_Pasantia() {
        super();
        objetivos_especificos = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        objetivos_especificos = "";

    }

    public static F_Fase_Pasantia clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Fase_Pasantia fF_Fase_Pasantia = (F_Fase_Pasantia) sess.getAttribute("F_Fase_Pasantia");
        if (fF_Fase_Pasantia == null) {
            fF_Fase_Pasantia = new F_Fase_Pasantia();
            sess.setAttribute("F_Fase_Pasantia", fF_Fase_Pasantia);
        } else {
            fF_Fase_Pasantia.reset(mapping, request);
        }
        return fF_Fase_Pasantia;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property objetivos_especificos.
     */
    private String objetivos_especificos;

    /**
     * Getter for property objetivos_especificos.
     * @return Value of property objetivos_especificos.
     */
    public String getObjetivos_especificos() {
        return this.objetivos_especificos;
    }

    /**
     * Setter for property objetivos_especificos.
     * @param objetivos_especificos New value of property objetivos_especificos.
     */
    public void setObjetivos_especificos(String objetivos_especificos) {
        this.objetivos_especificos = objetivos_especificos;
    }




}