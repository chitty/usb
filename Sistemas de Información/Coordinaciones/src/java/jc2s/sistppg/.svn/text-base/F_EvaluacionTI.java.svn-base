
package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMapping;

public class F_EvaluacionTI extends org.apache.struts.action.ActionForm {

    public F_EvaluacionTI() {
        super();
        uno = 0;
        dos = 0;
        tres = 0;
        cuatro = 0;
        cinco = 0;
        seis = 0;
        siete = 0;
        ocho = 0;
        nueve = 0;
        diez = 0;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        uno = 0;
        dos = 0;
        tres = 0;
        cuatro = 0;
        cinco = 0;
        seis = 0;
        siete = 0;
        ocho = 0;
        nueve = 0;
        diez = 0;

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


    // Pergunta UNO
    private int uno;

    public int getUno() {
        return this.uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    // Pergunta dos
    private int dos;

    public int getDos() {
        return this.dos;
    }

    public void setDos(int dos) {
        this.dos = dos;
    }

    // Pergunta tres
    private int tres;

    public int getTres() {
        return this.tres;
    }

    public void setTres(int tres) {
        this.tres = tres;
    }

    // Pergunta cuatro
    private int cuatro;

    public int getCuatro() {
        return this.cuatro;
    }

    public void setCuatro(int cuatro) {
        this.cuatro = cuatro;
    }

    // Pergunta cinco
    private int cinco;

    public int getCinco() {
        return this.cinco;
    }

    public void setCinco(int cinco) {
        this.cinco = cinco;
    }

    // Pergunta seis
    private int seis;

    public int getSeis() {
        return this.seis;
    }

    public void setSeis(int seis) {
        this.seis = seis;
    }

    // Pergunta siete
    private int siete;

    public int getSiete() {
        return this.siete;
    }

    public void setSiete(int siete) {
        this.siete = siete;
    }

    // Pergunta ocho
    private int ocho;

    public int getOcho() {
        return this.ocho;
    }

    public void setOcho(int ocho) {
        this.ocho = ocho;
    }

    // Pergunta nueve
    private int nueve;

    public int getNueve() {
        return this.nueve;
    }

    public void setNueve(int nueve) {
        this.nueve = nueve;
    }

    // Pergunta diez
    private int diez;

    public int getDiez() {
        return this.diez;
    }

    public void setDiez(int diez) {
        this.diez = diez;
    }



}

