package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Departamento extends org.apache.struts.action.ActionForm {


    public F_Departamento() {
        super();
        departamento = "";
        area = "";
        idDepartamento= "";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        departamento = "";
        idDepartamento = "";
        area = "";

    }

    public static F_Departamento clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Departamento fF_Departamento = (F_Departamento) sess.getAttribute("F_Departamento");
        if (fF_Departamento == null) {
            fF_Departamento = new F_Departamento();
            sess.setAttribute("F_Departamento", fF_Departamento);
        } else {
            fF_Departamento.reset(mapping, request);
        }
        return fF_Departamento;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property Departamento.
     */
    private String departamento;

    /**
     * Getter for property Departamento.
     * @return Value of property Departamento.
     */
    public String getDepartamento() {
        return this.departamento;
    }

    /**
     * Setter for property Departamento.
     * @param Departamento New value of property Departamento.
     */
    public void setDepartamento(String Departamento) {
        this.departamento = Departamento;
    }

    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String Area) {
        this.area = Area;
    }

    private String idDepartamento;

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}