package jc2s.sistppg.hibernate;



public class Pasantia implements java.io.Serializable, ve.usb.cohesion.runtime.Auditable {

    /** Creates a new instance of Pasantia */
    public Pasantia() {}
    
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
     * Holds value of property idPasantia.
     */
    private long idPasantia;

    /**
     * Getter for property idPasantia.
     * @return Value of property idPasantia.
     */
    public long getIdPasantia() {
        return this.idPasantia;
    }

    /**
     * Setter for property idPasantia.
     * @param idPasantia New value of property idPasantia.
     */
    public void setIdPasantia(long idPasantia) {
        this.id = this.idPasantia = idPasantia;
    }

    /**
     * Holds value of property titulo.
     */
    private String titulo = "";

    /**
     * Getter for property titulo.
     * @return Value of property titulo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Setter for property titulo.
     * @param titulo New value of property titulo.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Holds value of property tutor_academico.
     */
    private Profesor tutor_academico;

    /**
     * Getter for property tutor_academico.
     * @return Value of property tutor_academico.
     */
    public Profesor getTutor_academico() {
        return this.tutor_academico;
    }

    /**
     * Setter for property tutor_academico.
     * @param tutor_academico New value of property tutor_academico.
     */
    public void setTutor_academico(Profesor tutor_academico) {
        this.tutor_academico = tutor_academico;
    }
    /**
     * Holds value of property tutor_industrial.
     */
    private TutorIndustrial tutor_industrial;

    /**
     * Getter for property tutor_industrial.
     * @return Value of property tutor_industrial.
     */
    public TutorIndustrial getTutor_industrial() {
        return this.tutor_industrial;
    }

    /**
     * Setter for property tutor_industrial.
     * @param tutor_industrial New value of property tutor_industrial.
     */
    public void setTutor_industrial(TutorIndustrial tutor_industrial) {
        this.tutor_industrial = tutor_industrial;
    }
    /**
     * Holds value of property proyecto.
     */
    private Proyecto proyecto;

    /**
     * Getter for property proyecto.
     * @return Value of property proyecto.
     */
    public Proyecto getProyecto() {
        return this.proyecto;
    }

    /**
     * Setter for property proyecto.
     * @param proyecto New value of property proyecto.
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    /**
     * Holds value of property estatus.
     */
    private EstatusPasantia estatus;

    /**
     * Getter for property estatus.
     * @return Value of property estatus.
     */
    public EstatusPasantia getEstatus() {
        return this.estatus;
    }

    /**
     * Setter for property estatus.
     * @param estatus New value of property estatus.
     */
    public void setEstatus(EstatusPasantia estatus) {
        this.estatus = estatus;
    }
    /**
     * Holds value of property resumen.
     */
    private String resumen = "";

    /**
     * Getter for property resumen.
     * @return Value of property resumen.
     */
    public String getResumen() {
        return this.resumen;
    }

    /**
     * Setter for property resumen.
     * @param resumen New value of property resumen.
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * Holds value of property objetivos_generales.
     */
    private String objetivos_generales = "";

    /**
     * Getter for property objetivos_generales.
     * @return Value of property objetivos_generales.
     */
    public String getObjetivos_generales() {
        return this.objetivos_generales;
    }

    /**
     * Setter for property objetivos_generales.
     * @param objetivos_generales New value of property objetivos_generales.
     */
    public void setObjetivos_generales(String objetivos_generales) {
        this.objetivos_generales = objetivos_generales;
    }

    /**
     * Holds value of property ano.
     */
    private int ano = 0;

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


    private String evaluacion_tutor_academico;

    public String getEvaluacion_tutor_academico() {
        return evaluacion_tutor_academico;
    }

    public void setEvaluacion_tutor_academico(String evaluacion_tutor_academico) {
        this.evaluacion_tutor_academico = evaluacion_tutor_academico;
    }


    public String toString() {
        return "<Pasantia id='C" + this.id +
      //idPasantia
      "\" titulo =\"" + titulo +
        ((tutor_academico==null) ? "" : "\" tutor_academico =\"C" + tutor_academico.getId()) +

        ((tutor_industrial==null) ? "" : "\" tutor_industrial =\"C" + tutor_industrial.getId()) +

        ((proyecto==null) ? "" : "\" proyecto =\"C" + proyecto.getId()) +

        ((estatus==null) ? "" : "\" estatus =\"C" + estatus.getId()) +

      "\" resumen =\"" + resumen +
      "\" objetivos_generales =\"" + objetivos_generales +
      "\" ano =\"" + ano +

        "'/>";
    }

}