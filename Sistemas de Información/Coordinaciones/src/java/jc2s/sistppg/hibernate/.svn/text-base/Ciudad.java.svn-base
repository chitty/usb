package jc2s.sistppg.hibernate;



public class Ciudad implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Ciudad */
    public Ciudad() {}
    
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
     * Holds value of property idCiudad.
     */
    private long idCiudad;

    /**
     * Getter for property idCiudad.
     * @return Value of property idCiudad.
     */
    public long getIdCiudad() {
        return this.idCiudad;
    }

    /**
     * Setter for property idCiudad.
     * @param idCiudad New value of property idCiudad.
     */
    public void setIdCiudad(long idCiudad) {
        this.id = this.idCiudad = idCiudad;
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
     * Holds value of property pais.
     */
    private Pais pais;

    /**
     * Getter for property pais.
     * @return Value of property pais.
     */
    public Pais getPais() {
        return this.pais;
    }

    /**
     * Setter for property pais.
     * @param pais New value of property pais.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }



    public String toString() {
        return "<Ciudad id='C" + this.id +
      //idCiudad
      "\" nombre =\"" + nombre +
        ((pais==null) ? "" : "\" pais =\"C" + pais.getId()) +


        "'/>";
    }

}