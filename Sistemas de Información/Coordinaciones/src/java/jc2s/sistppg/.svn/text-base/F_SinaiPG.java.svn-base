package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMapping;

public class F_SinaiPG extends org.apache.struts.action.ActionForm {


    public F_SinaiPG() {
        super();
        tutor=-1;
        trimestre=-1;
        ano=-1;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        tutor=-1;
        trimestre=-1;
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


    private long tutor;

    public long getTutor() {
        return tutor;
    }

    public void setTutor(long tutor) {
        this.tutor = tutor;
    }


    private long trimestre;

    public long getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(long trimestre) {
        this.trimestre = trimestre;
    }


    private int ano;

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


}

