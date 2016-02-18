package jc2s.sistppg.hibernate;

import ve.usb.cohesion.runtime.Timestamp;

public class Proyecto implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Proyecto */
    public Proyecto() {}
    
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
     * Holds value of property id_proyecto.
     */
    private long id_proyecto;

    /**
     * Getter for property id_proyecto.
     * @return Value of property id_proyecto.
     */
    public long getId_proyecto() {
        return this.id_proyecto;
    }

    /**
     * Setter for property id_proyecto.
     * @param id_proyecto New value of property id_proyecto.
     */
    public void setId_proyecto(long id_proyecto) {
        this.id = this.id_proyecto = id_proyecto;
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



    public String toString() {
        return "<Proyecto id='C" + this.id +
      //id_proyecto
      "\" created_at =\"" + created_at +

        "'/>";
    }

}