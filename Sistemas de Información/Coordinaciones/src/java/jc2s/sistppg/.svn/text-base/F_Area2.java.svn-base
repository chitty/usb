package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Area2 extends org.apache.struts.action.ActionForm {


    public F_Area2() {
        super();
        area = "";
        idArea = "";
        departamento = "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        area = "";
        idArea = "";

    }

    public static F_Area2 clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Area2 fF_Area2 = (F_Area2) sess.getAttribute("F_Area2");
        if (fF_Area2 == null) {
            fF_Area2 = new F_Area2();
            sess.setAttribute("F_Area2", fF_Area2);
        } else {
            fF_Area2.reset(mapping, request);
        }
        return fF_Area2;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property area.
     */
    private String area;

    /**
     * Getter for property area.
     * @return Value of property area.
     */
    public String getArea() {
        return this.area;
    }

    /**
     * Setter for property area.
     * @param area New value of property area.
     */
    public void setArea(String area) {
        this.area = area;
    }

    private String idArea;

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


}