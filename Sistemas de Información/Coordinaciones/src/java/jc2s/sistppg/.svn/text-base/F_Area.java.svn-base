package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Area extends org.apache.struts.action.ActionForm {
    
    
    public F_Area() {
        super();
        area = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        area = "";

    }

    public static F_Area clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Area fF_Area = (F_Area) sess.getAttribute("F_Area");
        if (fF_Area == null) {
            fF_Area = new F_Area();
            sess.setAttribute("F_Area", fF_Area);
        } else {
            fF_Area.reset(mapping, request);
        }
        return fF_Area;
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




}