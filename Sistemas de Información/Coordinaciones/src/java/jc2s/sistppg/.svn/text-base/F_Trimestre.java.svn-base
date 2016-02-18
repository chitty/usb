package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Trimestre extends org.apache.struts.action.ActionForm {


    public F_Trimestre() {
        super();
        nombre = "";
        idTrimestre = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        idTrimestre = "";

    }

    public static F_Trimestre clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Trimestre fF_Trimestre = (F_Trimestre) sess.getAttribute("F_Trimestre");
        if (fF_Trimestre == null) {
            fF_Trimestre = new F_Trimestre();
            sess.setAttribute("F_Trimestre", fF_Trimestre);
        } else {
            fF_Trimestre.reset(mapping, request);
        }
        return fF_Trimestre;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property trimestre.
     */
    private String nombre;

    /**
     * Getter for property trimestre.
     * @return Value of property trimestre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for property trimestre.
     * @param trimestre New value of property trimestre.
     */
    public void setNombre(String trimestre) {
        this.nombre = trimestre;
    }

    private String idTrimestre;

    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }


}