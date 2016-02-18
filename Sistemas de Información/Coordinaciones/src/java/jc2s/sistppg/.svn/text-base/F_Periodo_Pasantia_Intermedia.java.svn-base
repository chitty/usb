package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Periodo_Pasantia_Intermedia extends org.apache.struts.action.ActionForm {


    public F_Periodo_Pasantia_Intermedia() {
        super();
        periodoPasantiaIntermedia = "";
        idPeriodoPasantiaIntermedia = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        periodoPasantiaIntermedia = "";
        idPeriodoPasantiaIntermedia = "";

    }

    public static F_Periodo_Pasantia_Intermedia clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Periodo_Pasantia_Intermedia fF_Periodo_Pasantia_Intermedia = (F_Periodo_Pasantia_Intermedia) sess.getAttribute("F_Periodo_Pasantia_Intermedia");
        if (fF_Periodo_Pasantia_Intermedia == null) {
            fF_Periodo_Pasantia_Intermedia = new F_Periodo_Pasantia_Intermedia();
            sess.setAttribute("F_Periodo_Pasantia_Intermedia", fF_Periodo_Pasantia_Intermedia);
        } else {
            fF_Periodo_Pasantia_Intermedia.reset(mapping, request);
        }
        return fF_Periodo_Pasantia_Intermedia;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property periodoPasantiaIntermedia.
     */
    private String periodoPasantiaIntermedia;

    /**
     * Getter for property periodoPasantiaIntermedia.
     * @return Value of property periodoPasantiaIntermedia.
     */
    public String getPeriodoPasantiaIntermedia() {
        return this.periodoPasantiaIntermedia;
    }

    /**
     * Setter for property periodoPasantiaIntermedia.
     * @param periodoPasantiaIntermedia New value of property periodoPasantiaIntermedia.
     */
    public void setPeriodoPasantiaIntermedia(String periodoPasantiaIntermedia) {
        this.periodoPasantiaIntermedia = periodoPasantiaIntermedia;
    }

    private String idPeriodoPasantiaIntermedia;

    public String getIdPeriodoPasantiaIntermedia() {
        return idPeriodoPasantiaIntermedia;
    }

    public void setIdPeriodoPasantiaIntermedia(String idPeriodoPasantiaIntermedia) {
        this.idPeriodoPasantiaIntermedia = idPeriodoPasantiaIntermedia;
    }


}