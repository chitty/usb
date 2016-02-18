package jc2s.sistppg.hibernate;

import ve.usb.cohesion.runtime.Timestamp;

public class EmpresaSolicitaPasante implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of EmpresaSolicitaPasante */
    public EmpresaSolicitaPasante() {}
    
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
     * Holds value of property idEmpresaSolicitaPasante.
     */
    private long idEmpresaSolicitaPasante;

    /**
     * Getter for property idEmpresaSolicitaPasante.
     * @return Value of property idEmpresaSolicitaPasante.
     */
    public long getIdEmpresaSolicitaPasante() {
        return this.idEmpresaSolicitaPasante;
    }

    /**
     * Setter for property idEmpresaSolicitaPasante.
     * @param idEmpresaSolicitaPasante New value of property idEmpresaSolicitaPasante.
     */
    public void setIdEmpresaSolicitaPasante(long idEmpresaSolicitaPasante) {
        this.id = this.idEmpresaSolicitaPasante = idEmpresaSolicitaPasante;
    }

    /**
     * Holds value of property empresa.
     */
    private Empresa empresa;

    /**
     * Getter for property empresa.
     * @return Value of property empresa.
     */
    public Empresa getEmpresa() {
        return this.empresa;
    }

    /**
     * Setter for property empresa.
     * @param empresa New value of property empresa.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    /**
     * Holds value of property carrera.
     */
    private Carrera carrera;

    /**
     * Getter for property carrera.
     * @return Value of property carrera.
     */
    public Carrera getCarrera() {
        return this.carrera;
    }

    /**
     * Setter for property carrera.
     * @param carrera New value of property carrera.
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
        return "<EmpresaSolicitaPasante id='C" + this.id +
      //idEmpresaSolicitaPasante
        ((empresa==null) ? "" : "\" empresa =\"C" + empresa.getId()) +

        ((carrera==null) ? "" : "\" carrera =\"C" + carrera.getId()) +

      "\" created_at =\"" + created_at +

        "'/>";
    }

}