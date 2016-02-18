package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author chitty
 */
public class F_Preinscripcion extends org.apache.struts.action.ActionForm {


    public F_Preinscripcion() {
        super();
        bloque = false;
        buscar = false;
        donde = "";
        tipo = 1;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        bloque = false;
        buscar = false;
        donde = "";
        tipo = 1;

    }

    public static F_Preinscripcion clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Preinscripcion fF_Preinscripcion = (F_Preinscripcion) sess.getAttribute("F_Preinscripcion");
        if (fF_Preinscripcion == null) {
            fF_Preinscripcion = new F_Preinscripcion();
            sess.setAttribute("F_Preinscripcion", fF_Preinscripcion);
        } else {
            fF_Preinscripcion.reset(mapping, request);
        }
        return fF_Preinscripcion;
    }

//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//
//        return errors;
//    }

    /**
     * Holds value of property bloque.
     */
    private boolean bloque;

    /**
     * Getter for property bloque.
     * @return Value of property bloque.
     */
    public boolean getBloque() {
        return this.bloque;
    }

    /**
     * Setter for property bloque.
     * @param bloque New value of property bloque.
     */
    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    /**
     * Holds value of property buscar.
     */
    private boolean buscar;

    /**
     * Getter for property buscar.
     * @return Value of property buscar.
     */
    public boolean getBuscar() {
        return this.buscar;
    }

    /**
     * Setter for property buscar.
     * @param buscar New value of property buscar.
     */
    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    /**
     * Holds value of property donde.
     */
    private String donde;

    /**
     * Getter for property donde.
     * @return Value of property donde.
     */
    public String getDonde() {
        return this.donde;
    }

    /**
     * Setter for property donde.
     * @param donde New value of property donde.
     */
    public void setDonde(String donde) {
        this.donde = donde;
    }

    /**
     * Holds value of property tipo.
     */
    private int tipo;

    /**
     * Getter for property tipo.
     * @return Value of property tipo.
     */
    public int getTipo() {
        return this.tipo;
    }

    /**
     * Setter for property tipo.
     * @param tipo New value of property tipo.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }



}
