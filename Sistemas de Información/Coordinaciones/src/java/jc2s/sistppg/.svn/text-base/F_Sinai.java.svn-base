package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMapping;

public class F_Sinai extends org.apache.struts.action.ActionForm {


    public F_Sinai() {
        super();
        status = -1;
        tipo="all";
        periodo="all";
        idCarrera=-1;
        ano=-1;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        status = -1;
        tipo="";
        periodo="";
        idCarrera=-1;
        ano=-1;

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
    private long status;

    /**
     * Getter for property area.
     * @return Value of property area.
     */
    public long getStatus() {
        return this.status;
    }

    /**
     * Setter for property area.
     * @param area New value of property area.
     */
    public void setStatus(long status) {
        this.status = status;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String periodo;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    private long idCarrera;

    public long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(long idCarrera) {
        this.idCarrera = idCarrera;
    }


    private int ano;

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


}
