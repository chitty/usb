package jc2s.sistppg.hibernate;

import ve.usb.cohesion.runtime.Timestamp;

public class Prorroga implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /**
     * Holds value of property estudiante.
     */
    private Estudiante estudiante;

    /**
     * Getter for property estudiante.
     * @return Value of property estudiante.
     */
    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    /**
     * Setter for property estudiante.
     * @param estudiante New value of property estudiante.
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /** Creates a new instance of Prorroga */
    public Prorroga() {}
    
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
     * Holds value of property idProrroga.
     */
    private long idProrroga;

    /**
     * Getter for property idProrroga.
     * @return Value of property idProrroga.
     */
    public long getIdProrroga() {
        return this.idProrroga;
    }

    /**
     * Setter for property idProrroga.
     * @param idProrroga New value of property idProrroga.
     */
    public void setIdProrroga(long idProrroga) {
        this.id = this.idProrroga = idProrroga;
    }


    /**
     * Holds value of property justificacion.
     */
    private String justificacion = "";

    /**
     * Getter for property justificacion.
     * @return Value of property justificacion.
     */
    public String getJustificacion() {
        return this.justificacion;
    }

    /**
     * Setter for property justificacion.
     * @param justificacion New value of property justificacion.
     */
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    /**
     * Holds value of property attachment.
     */
    private String attachment = "";

    /**
     * Getter for property attachment.
     * @return Value of property attachment.
     */
    public String getAttachment() {
        return this.attachment;
    }

    /**
     * Setter for property attachment.
     * @param attachment New value of property attachment.
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     * Holds value of property estatus.
     */
    private EstatusProrroga estatus;

    /**
     * Getter for property estatus.
     * @return Value of property estatus.
     */
    public EstatusProrroga getEstatus() {
        return this.estatus;
    }

    /**
     * Setter for property estatus.
     * @param estatus New value of property estatus.
     */
    public void setEstatus(EstatusProrroga estatus) {
        this.estatus = estatus;
    }
    /**
     * Holds value of property created_at.
     */
    private java.util.Date created_at;

    /**
     * Getter for property created_at.
     * @return Value of property created_at.
     */
    public java.util.Date getCreated_at() {
        return this.created_at;
    }

    /**
     * Setter for property created_at.
     * @param created_at New value of property created_at.
     */
    public void setCreated_at(java.util.Date created_at) {
        if (created_at==null || created_at instanceof Timestamp)
            this.created_at = created_at;
        else this.created_at = new Timestamp(created_at);
    }
    /**
     * Holds value of property updated_at.
     */
    private java.util.Date updated_at;

    /**
     * Getter for property updated_at.
     * @return Value of property updated_at.
     */
    public java.util.Date getUpdated_at() {
        return this.updated_at;
    }

    /**
     * Setter for property updated_at.
     * @param updated_at New value of property updated_at.
     */
    public void setUpdated_at(java.util.Date updated_at) {
        if (updated_at==null || updated_at instanceof Timestamp)
            this.updated_at = updated_at;
        else this.updated_at = new Timestamp(updated_at);
    }



    public String toString() {
        return "<Prorroga id='C" + this.id +
      //idProrroga
      "\" justificacion =\"" + justificacion +
      "\" attachment =\"" + attachment +
        ((estatus==null) ? "" : "\" estatus =\"C" + estatus.getId()) +

      "\" created_at =\"" + created_at +
      "\" updated_at =\"" + updated_at +

        "'/>";
    }

}