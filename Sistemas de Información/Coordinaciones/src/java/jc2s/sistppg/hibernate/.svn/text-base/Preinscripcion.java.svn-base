package jc2s.sistppg.hibernate;

import java.util.HashSet;
import java.util.Set;
import ve.usb.cohesion.runtime.Timestamp;

public class Preinscripcion implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Preinscripcion */
    public Preinscripcion() {}

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
     * Holds value of property idPreinscripcion.
     */
    private long idPreinscripcion;

    /**
     * Getter for property idPreinscripcion.
     * @return Value of property idPreinscripcion.
     */
    public long getIdPreinscripcion() {
        return this.idPreinscripcion;
    }

    /**
     * Setter for property idPreinscripcion.
     * @param idPreinscripcion New value of property idPreinscripcion.
     */
    public void setIdPreinscripcion(long idPreinscripcion) {
        this.id = this.idPreinscripcion = idPreinscripcion;
    }

    /**
     * Holds value of property tipo.
     */
    private int tipo;

    /**
     * Getter for property tipo.
     * @return Value of property tipo.
     */
    public int getTipo() {
        return this.tipo;
    }

    /**
     * Setter for property tipo.
     * @param tipo New value of property tipo.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Holds value of property regiones.
     */
    private String regiones = "";

    /**
     * Getter for property regiones.
     * @return Value of property regiones.
     */
    public String getRegiones() {
        return this.regiones;
    }

    /**
     * Setter for property regiones.
     * @param regiones New value of property regiones.
     */
    public void setRegiones(String regiones) {
        this.regiones = regiones;
    }

    /**
     * Holds value of property por_graduar.
     */
    private boolean por_graduar;

    /**
     * Getter for property por_graduar.
     * @return Value of property por_graduar.
     */
    public boolean getPor_graduar() {
        return this.por_graduar;
    }

    /**
     * Setter for property por_graduar.
     * @param por_graduar New value of property por_graduar.
     */
    public void setPor_graduar(boolean por_graduar) {
        this.por_graduar = por_graduar;
    }

    /**
     * Holds value of property estatus.
     */
    private boolean estatus;

    /**
     * Getter for property estatus.
     * @return Value of property estatus.
     */
    public boolean getEstatus() {
        return this.estatus;
    }

    /**
     * Setter for property estatus.
     * @param estatus New value of property estatus.
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }


    /**
     * Holds value of property tramitecctds.
     */
    private boolean tramitecctds;

    /**
     * Getter for property tramitecctds.
     * @return Value of property tramitecctds.
     */
    public boolean getTramitecctds() {
        return this.tramitecctds;
    }

    /**
     * Setter for property tramitecctds.
     * @param tramitecctds New value of property tramitecctds.
     */
    public void setTramitecctds(boolean tramitecctds) {
        this.tramitecctds = tramitecctds;
    }

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
     * Holds value of property ciudadesPreinscripcion.
     */
    private Set<CiudadPreinscripcion> ciudadesPreinscripcion = new HashSet<CiudadPreinscripcion>();

    /**
     * Getter for property actividades.
     * @return Value of property ciudadesPreinscripcion.
     */
    public Set<CiudadPreinscripcion> getCiudadesPreinscripcion() {
        return this.ciudadesPreinscripcion;
    }

    /**
     * Setter for property ciudadesPreinscripcion.
     * @param ciudadesPreinscripcion New value of property ciudadesPreinscripcion.
     */
    public void setCiudadesPreinscripcion(Set<CiudadPreinscripcion> ciudadesPreinscripcion) {
        this.ciudadesPreinscripcion = ciudadesPreinscripcion;
    }



    public String toString() {
        return "<Preinscripcion id='C" + this.id +
      //idPreinscripcion
      "\" tipo =\"" + tipo +
      "\" regiones =\"" + regiones +
      "\" por_graduar =\"" + por_graduar +
      "\" estatus =\"" + estatus +
      "\" tramitecctds =\"" + tramitecctds +
        ((estudiante==null) ? "" : "\" estudiante =\"C" + estudiante.getId()) +

      "\" created_at =\"" + created_at +

        "'/>";
    }

}