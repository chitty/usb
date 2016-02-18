package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Estatus_Pasantia extends org.apache.struts.action.ActionForm {


    public F_Estatus_Pasantia() {
        super();
        estatus = "";
        idEstatusPasantia = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        estatus = "";
        idEstatusPasantia = "";

    }

    public static F_Estatus_Pasantia clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Estatus_Pasantia fF_EstatusPasantia = (F_Estatus_Pasantia) sess.getAttribute("F_EstatusPasantia");
        if (fF_EstatusPasantia == null) {
            fF_EstatusPasantia = new F_Estatus_Pasantia();
            sess.setAttribute("F_EstatusPasantia", fF_EstatusPasantia);
        } else {
            fF_EstatusPasantia.reset(mapping, request);
        }
        return fF_EstatusPasantia;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property status_pasantia.
     */
    private String estatus;

    /**
     * Getter for property status_pasantia.
     * @return Value of property status_pasantia.
     */
    public String getEstatus() {
        return this.estatus;
    }

    /**
     * Setter for property status_pasantia.
     * @param status_pasantia New value of property status_pasantia.
     */
    public void setEstatus(String status_pasantia) {
        this.estatus = status_pasantia;
    }

    private String idEstatusPasantia;

    public String getIdEstatusPasantia() {
        return idEstatusPasantia;
    }

    public void setIdEstatusPasantia(String idEstatusPasantia) {
        this.idEstatusPasantia = idEstatusPasantia;
    }


}