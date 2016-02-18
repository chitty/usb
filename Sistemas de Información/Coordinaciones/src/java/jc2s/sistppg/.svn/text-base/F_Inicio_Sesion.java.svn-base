package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import java.util.List;
import ve.usb.cohesion.runtime.Pair;

public class F_Inicio_Sesion extends org.apache.struts.action.ActionForm {
    
    
    public F_Inicio_Sesion() {
        super();
        usbid = "";
        password = null;

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        usbid = "";
        password = null;

    }

    public static F_Inicio_Sesion clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Inicio_Sesion fF_Inicio_Sesion = (F_Inicio_Sesion) sess.getAttribute("F_Inicio_Sesion");
        if (fF_Inicio_Sesion == null) {
            fF_Inicio_Sesion = new F_Inicio_Sesion();
            sess.setAttribute("F_Inicio_Sesion", fF_Inicio_Sesion);
        } else {
            fF_Inicio_Sesion.reset(mapping, request);
        }
        return fF_Inicio_Sesion;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property usbid.
     */
    private String usbid;

    /**
     * Getter for property usbid.
     * @return Value of property usbid.
     */
    public String getUsbid() {
        return this.usbid;
    }

    /**
     * Setter for property usbid.
     * @param usbid New value of property usbid.
     */
    public void setUsbid(String usbid) {
        this.usbid = usbid;
    }

    /**
     * Holds value of property password.
     */
    private List<Pair> password;

    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public List<Pair> getPassword() {
        return this.password;
    }

    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(List<Pair> password) {
        this.password = password;
    }




}