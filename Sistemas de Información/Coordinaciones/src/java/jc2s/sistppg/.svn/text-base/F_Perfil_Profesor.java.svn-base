package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Perfil_Profesor extends org.apache.struts.action.ActionForm {
    
    
    public F_Perfil_Profesor() {
        super();
        nombre = "";
        apellido = "";
        cedula = "";
        email = "";
        departamento = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        apellido = "";
        cedula = "";
        email = "";
        departamento = "";

    }

    public static F_Perfil_Profesor clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Perfil_Profesor fF_Perfil_Profesor = (F_Perfil_Profesor) sess.getAttribute("F_Perfil_Profesor");
        if (fF_Perfil_Profesor == null) {
            fF_Perfil_Profesor = new F_Perfil_Profesor();
            sess.setAttribute("F_Perfil_Profesor", fF_Perfil_Profesor);
        } else {
            fF_Perfil_Profesor.reset(mapping, request);
        }
        return fF_Perfil_Profesor;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property nombre.
     */
    private String nombre;

    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Holds value of property apellido.
     */
    private String apellido;

    /**
     * Getter for property apellido.
     * @return Value of property apellido.
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Setter for property apellido.
     * @param apellido New value of property apellido.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Holds value of property cedula.
     */
    private String cedula;

    /**
     * Getter for property cedula.
     * @return Value of property cedula.
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * Setter for property cedula.
     * @param cedula New value of property cedula.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Holds value of property email.
     */
    private String email;

    /**
     * Getter for property email.
     * @return Value of property email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Holds value of property departamento.
     */
    private String departamento;

    /**
     * Getter for property departamento.
     * @return Value of property departamento.
     */
    public String getDepartamento() {
        return this.departamento;
    }

    /**
     * Setter for property departamento.
     * @param departamento New value of property departamento.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }




}