package jc2s.sistppg.hibernate;

import ve.usb.cohesion.runtime.LocalDate;

public class ProrrogaEvaluacion implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of ProrrogaEvaluacion */
    public ProrrogaEvaluacion() {}
    
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
     * Holds value of property idProrrogaEvaluacion.
     */
    private long idProrrogaEvaluacion;

    /**
     * Getter for property idProrrogaEvaluacion.
     * @return Value of property idProrrogaEvaluacion.
     */
    public long getIdProrrogaEvaluacion() {
        return this.idProrrogaEvaluacion;
    }

    /**
     * Setter for property idProrrogaEvaluacion.
     * @param idProrrogaEvaluacion New value of property idProrrogaEvaluacion.
     */
    public void setIdProrrogaEvaluacion(long idProrrogaEvaluacion) {
        this.id = this.idProrrogaEvaluacion = idProrrogaEvaluacion;
    }

    /**
     * Holds value of property fecha_propuesta.
     */
    private java.util.Date fecha_propuesta;

    /**
     * Getter for property fecha_propuesta.
     * @return Value of property fecha_propuesta.
     */
    public java.util.Date getFecha_propuesta() {
        return this.fecha_propuesta;
    }

    /**
     * Setter for property fecha_propuesta.
     * @param fecha_propuesta New value of property fecha_propuesta.
     */
    public void setFecha_propuesta(java.util.Date fecha_propuesta) {
        if (fecha_propuesta==null || fecha_propuesta instanceof LocalDate)
            this.fecha_propuesta = fecha_propuesta;
        else this.fecha_propuesta = new LocalDate(fecha_propuesta);
    }

    /**
     * Holds value of property prorroga.
     */
    private Prorroga prorroga;

    /**
     * Getter for property prorroga.
     * @return Value of property prorroga.
     */
    public Prorroga getProrroga() {
        return this.prorroga;
    }

    /**
     * Setter for property prorroga.
     * @param prorroga New value of property prorroga.
     */
    public void setProrroga(Prorroga prorroga) {
        this.prorroga = prorroga;
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
        return "<ProrrogaEvaluacion id='C" + this.id +
      //idProrrogaEvaluacion
      "\" fecha_propuesta =\"" + fecha_propuesta +
        ((prorroga==null) ? "" : "\" prorroga =\"C" + prorroga.getId()) +


        "'/>";
    }

}