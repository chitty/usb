package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Jurado extends org.apache.struts.action.ActionForm {


    public F_Jurado() {
        super();
        tipo="";
        periodo="";
        departamento="";
        area="";
        texto="";
        


    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        tipo="";
        periodo="";
        departamento="";
        area="";
        texto="";
       

    }

    public static F_Jurado clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Jurado fF_Jurado = (F_Jurado) sess.getAttribute("F_Jurado");
        if (fF_Jurado == null) {
            fF_Jurado = new F_Jurado();
            sess.setAttribute("F_Jurado", fF_Jurado);
        } else {
            fF_Jurado.reset(mapping, request);
        }
        return fF_Jurado;
    }

    private String tipo;



    private String periodo;



    private String departamento;



    private String area;



    private String texto;



   

  
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

  

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}