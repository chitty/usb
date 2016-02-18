package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Carrera extends org.apache.struts.action.ActionForm {


    public F_Carrera() {
        super();
        nombre = "";
        email="";
        idCarrera="";

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        email="";
        idCarrera="";

    }

    public static F_Carrera clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Carrera fF_Carrera = (F_Carrera) sess.getAttribute("F_Carrera");
        if (fF_Carrera == null) {
            fF_Carrera = new F_Carrera();
            sess.setAttribute("F_Carrera", fF_Carrera);
        } else {
            fF_Carrera.reset(mapping, request);
        }
        return fF_Carrera;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property area.
     */
    private String nombre;

    /**
     * Getter for property area.
     * @return Value of property area.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for property area.
     * @param area New value of property area.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String idCarrera;

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }


}