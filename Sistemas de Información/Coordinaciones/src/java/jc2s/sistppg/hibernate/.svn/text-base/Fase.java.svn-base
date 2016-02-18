package jc2s.sistppg.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fase implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Fase */
    public Fase() {}
    
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
     * Holds value of property idFase.
     */
    private long idFase;

    /**
     * Getter for property idFase.
     * @return Value of property idFase.
     */
    public long getIdFase() {
        return this.idFase;
    }

    /**
     * Setter for property idFase.
     * @param idFase New value of property idFase.
     */
    public void setIdFase(long idFase) {
        this.id = this.idFase = idFase;
    }

    /**
     * Holds value of property objetivos_especificos.
     */
    private String objetivos_especificos = "";

    /**
     * Getter for property objetivos_especificos.
     * @return Value of property objetivos_especificos.
     */
    public String getObjetivos_especificos() {
        return this.objetivos_especificos;
    }

    /**
     * Setter for property objetivos_especificos.
     * @param objetivos_especificos New value of property objetivos_especificos.
     */
    public void setObjetivos_especificos(String objetivos_especificos) {
        this.objetivos_especificos = objetivos_especificos;
    }

    /**
     * Holds value of property actividades.
     */
    private Set<ActividadFase> actividades = new HashSet<ActividadFase>();

    /**
     * Getter for property actividades.
     * @return Value of property actividades.
     */
    public Set<ActividadFase> getActividades() {
        return this.actividades;
    }

    /**
     * Setter for property actividades.
     * @param actividades New value of property actividades.
     */
    public void setActividades(Set<ActividadFase> actividades) {
        this.actividades = actividades;
    }

    /**
     * Add an element to set property actividades
     * and sets elements's property fase.
     * @param element New element to be added to actividades.
     */
    public void addToActividades(ActividadFase element) {
        element.setFase(this);
        actividades.add(element);
    }

    /**
     * Removes and old element from set actividades
     * and sets element's property fase to null.
     * @param old The element to be removed from actividades
     */
    public void removeFromActividades(ActividadFase old) {
        actividades.remove(old);
        old.setFase(null);
    }
    /**
     * Holds value of property pasantia.
     */
    private Pasantia pasantia;

    /**
     * Getter for property pasantia.
     * @return Value of property pasantia.
     */
    public Pasantia getPasantia() {
        return this.pasantia;
    }

    /**
     * Setter for property pasantia.
     * @param pasantia New value of property pasantia.
     */
    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
    }

 

    public String toString() {
        return "<Fase id='C" + this.id +
      //idFase
      "\" objetivos_especificos =\"" + objetivos_especificos +
      //actividades
        ((pasantia==null) ? "" : "\" pasantia =\"C" + pasantia.getId()) +


        "'/>";
    }

}