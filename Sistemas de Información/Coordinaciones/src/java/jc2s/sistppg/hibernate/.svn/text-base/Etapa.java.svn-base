package jc2s.sistppg.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Etapa implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Etapa */
    public Etapa() {}
    
    /**
     * Holds value of property id.
     */
    private Long id;

    /**
     * Getter for property id.
     * @return Value of property id.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Holds value of property idEtapa.
     */
    private long idEtapa;

    /**
     * Getter for property idEtapa.
     * @return Value of property idEtapa.
     */
    public long getIdEtapa() {
        return this.idEtapa;
    }

    /**
     * Setter for property idEtapa.
     * @param idEtapa New value of property idEtapa.
     */
    public void setIdEtapa(long idEtapa) {
        this.id = this.idEtapa = idEtapa;
    }

    /**
     * Holds value of property nombre.
     */
    private String nombre = "";

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
    private String resultados_minimos = "";

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
    private Trimestre trimestre;

    /**
     * Getter for property trimestre.
     * @return Value of property trimestre.
     */
    public Trimestre getTrimestre() {
        return this.trimestre;
    }

    /**
     * Setter for property trimestre.
     * @param trimestre New value of property trimestre.
     */
    public void setTrimestre(Trimestre trimestre) {
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

    /**
     * Holds value of property proyecto_de_grado.
     */
    private ProyectoDeGrado proyecto_de_grado;

    /**
     * Getter for property proyecto_de_grado.
     * @return Value of property proyecto_de_grado.
     */
    public ProyectoDeGrado getProyecto_de_grado() {
        return this.proyecto_de_grado;
    }

    /**
     * Setter for property proyecto_de_grado.
     * @param proyecto_de_grado New value of property proyecto_de_grado.
     */
    public void setProyecto_de_grado(ProyectoDeGrado proyecto_de_grado) {
        this.proyecto_de_grado = proyecto_de_grado;
    }
    /**
     * Holds value of property actividades.
     */
    private Set<Actividad> actividades = new HashSet<Actividad>();

    /**
     * Getter for property actividades.
     * @return Value of property actividades.
     */
    public Set<Actividad> getActividades() {
        return this.actividades;
    }

    /**
     * Setter for property actividades.
     * @param actividades New value of property actividades.
     */
    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Add an element to set property actividades
     * and sets elements's property etapa.
     * @param element New element to be added to actividades.
     */
    public void addToActividades(Actividad element) {
        element.setEtapa(this);
        actividades.add(element);
    }

    /**
     * Removes and old element from set actividades
     * and sets element's property etapa to null.
     * @param old The element to be removed from actividades
     */
    public void removeFromActividades(Actividad old) {
        actividades.remove(old);
        old.setEtapa(null);
    }



    public String toString() {
        return "<Etapa id='C" + this.id +
      //idEtapa
      "\" nombre =\"" + nombre +
      "\" resultados_minimos =\"" + resultados_minimos +
        ((trimestre==null) ? "" : "\" trimestre =\"C" + trimestre.getId()) +

      "\" ano =\"" + ano +
        ((proyecto_de_grado==null) ? "" : "\" proyecto_de_grado =\"C" + proyecto_de_grado.getId()) +

      //actividades

        "'/>";
    }

}