package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Periodo_Pasantia_Larga extends org.apache.struts.action.ActionForm {


    public F_Periodo_Pasantia_Larga() {
        super();
        periodoPasantiaLarga = "";
        idPeriodoPasantiaLarga = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        periodoPasantiaLarga = "";
        idPeriodoPasantiaLarga = "";

    }

    public static F_Periodo_Pasantia_Larga clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Periodo_Pasantia_Larga fF_Periodo_Pasantia_Larga = (F_Periodo_Pasantia_Larga) sess.getAttribute("F_Periodo_Pasantia_Larga");
        if (fF_Periodo_Pasantia_Larga == null) {
            fF_Periodo_Pasantia_Larga = new F_Periodo_Pasantia_Larga();
            sess.setAttribute("F_Periodo_Pasantia_Larga", fF_Periodo_Pasantia_Larga);
        } else {
            fF_Periodo_Pasantia_Larga.reset(mapping, request);
        }
        return fF_Periodo_Pasantia_Larga;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property periodoPasantiaLarga.
     */
    private String periodoPasantiaLarga;

    /**
     * Getter for property periodoPasantiaLarga.
     * @return Value of property periodoPasantiaLarga.
     */
    public String getPeriodoPasantiaLarga() {
        return this.periodoPasantiaLarga;
    }

    /**
     * Setter for property periodoPasantiaLarga.
     * @param periodoPasantiaLarga New value of property periodoPasantiaLarga.
     */
    public void setPeriodoPasantiaLarga(String periodoPasantiaLarga) {
        this.periodoPasantiaLarga = periodoPasantiaLarga;
    }

    private String idPeriodoPasantiaLarga;

    public String getIdPeriodoPasantiaLarga() {
        return idPeriodoPasantiaLarga;
    }

    public void setIdPeriodoPasantiaLarga(String idPeriodoPasantiaLarga) {
        this.idPeriodoPasantiaLarga = idPeriodoPasantiaLarga;
    }


}