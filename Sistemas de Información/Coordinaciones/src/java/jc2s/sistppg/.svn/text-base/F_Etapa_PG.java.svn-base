package jc2s.sistppg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class F_Etapa_PG extends org.apache.struts.action.ActionForm {
    
    
    public F_Etapa_PG() {
        super();
        nombre = "";
        resultados_minimos = "";
        trimestre = "";
        ano = 0;
        topicos = "";

    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre = "";
        resultados_minimos = "";
        trimestre = "";
        ano = 0;
        topicos = "";

    }

    public static F_Etapa_PG clear(ActionMapping mapping, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        F_Etapa_PG fF_Etapa_PG = (F_Etapa_PG) sess.getAttribute("F_Etapa_PG");
        if (fF_Etapa_PG == null) {
            fF_Etapa_PG = new F_Etapa_PG();
            sess.setAttribute("F_Etapa_PG", fF_Etapa_PG);
        } else {
            fF_Etapa_PG.reset(mapping, request);
        }
        return fF_Etapa_PG;
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
     * Holds value of property resultados_minimos.
     */
    private String resultados_minimos;

    /**
     * Getter for property resultados_minimos.
     * @return Value of property resultados_minimos.
     */
    public String getResultados_minimos() {
        return this.resultados_minimos;
    }

    /**
     * Setter for property resultados_minimos.
     * @param resultados_minimos New value of property resultados_minimos.
     */
    public void setResultados_minimos(String resultados_minimos) {
        this.resultados_minimos = resultados_minimos;
    }

    /**
     * Holds value of property trimestre.
     */
    private String trimestre;

    /**
     * Getter for property trimestre.
     * @return Value of property trimestre.
     */
    public String getTrimestre() {
        return this.trimestre;
    }

    /**
     * Setter for property trimestre.
     * @param trimestre New value of property trimestre.
     */
    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    /**
     * Holds value of property ano.
     */
    private int ano;

    /**
     * Getter for property ano.
     * @return Value of property ano.
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Setter for property ano.
     * @param ano New value of property ano.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

        private String topicos;

    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public String getTopicos() {
        return this.topicos;
    }

    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setTopicos(String topicos) {
        this.topicos = topicos;
    }




}