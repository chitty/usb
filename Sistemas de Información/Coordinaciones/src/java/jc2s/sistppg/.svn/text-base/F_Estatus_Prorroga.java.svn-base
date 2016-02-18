package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Estatus_Prorroga extends org.apache.struts.action.ActionForm {


    public F_Estatus_Prorroga() {
        super();
        estatus = "";
        idEstatusProrroga = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        estatus = "";
        idEstatusProrroga = "";

    }

    public static F_Estatus_Prorroga clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Estatus_Prorroga fF_EstatusProrroga = (F_Estatus_Prorroga) sess.getAttribute("F_EstatusProrroga");
        if (fF_EstatusProrroga == null) {
            fF_EstatusProrroga = new F_Estatus_Prorroga();
            sess.setAttribute("F_EstatusProrroga", fF_EstatusProrroga);
        } else {
            fF_EstatusProrroga.reset(mapping, request);
        }
        return fF_EstatusProrroga;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property status_prorroga.
     */
    private String estatus;

    /**
     * Getter for property status_prorroga.
     * @return Value of property status_prorroga.
     */
    public String getEstatus() {
        return this.estatus;
    }

    /**
     * Setter for property status_prorroga.
     * @param status_prorroga New value of property status_prorroga.
     */
    public void setEstatus(String status_prorroga) {
        this.estatus = status_prorroga;
    }

    private String idEstatusProrroga;

    public String getIdEstatusProrroga() {
        return idEstatusProrroga;
    }

    public void setIdEstatusProrroga(String idEstatusProrroga) {
        this.idEstatusProrroga = idEstatusProrroga;
    }


}