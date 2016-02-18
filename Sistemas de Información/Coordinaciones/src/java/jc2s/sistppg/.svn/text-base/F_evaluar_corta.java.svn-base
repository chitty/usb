package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_evaluar_corta extends org.apache.struts.action.ActionForm {


    public F_evaluar_corta() {
        super();
        item1 = "0";
        item2 = "0";
        item3 = "0";
        item4 = "0";
        item5 = "0";
        idPasantia = "";
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        item1 = "0";
        item2 = "0";
        item3 = "0";
        item4 = "0";
        item5 = "0";
        idPasantia = "";

    }

    public static F_Tutor_Industrial clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Tutor_Industrial fF_Tutor_Industrial = (F_Tutor_Industrial) sess.getAttribute("F_Tutor_Industrial");
        if (fF_Tutor_Industrial == null) {
            fF_Tutor_Industrial = new F_Tutor_Industrial();
            sess.setAttribute("F_Tutor_Industrial", fF_Tutor_Industrial);
        } else {
            fF_Tutor_Industrial.reset(mapping, request);
        }
        return fF_Tutor_Industrial;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property nombre.
     */
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String idPasantia;

    public String getIdPasantia() {
        return idPasantia;
    }

    public void setIdPasantia(String idPasantia) {
        this.idPasantia = idPasantia;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getItem5() {
        return item5;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }

    

}