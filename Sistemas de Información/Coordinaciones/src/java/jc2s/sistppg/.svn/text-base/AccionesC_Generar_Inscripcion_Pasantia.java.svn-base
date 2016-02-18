package jc2s.sistppg;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import ve.usb.cohesion.runtime.CohesionAction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.usb.cohesion.runtime.HibernateUtil;
import jc2s.sistppg.hibernate.*;


/**
 *
 */
public class AccionesC_Generar_Inscripcion_Pasantia extends CohesionAction {

/**
     * Called by Struts for the execution of action A_prep_generar_inscripcion.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptions will normally be treated with
     * the default exception action.
     */
    public ActionForward A_prep_generar_inscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestion_Pasantias_Est", "V_generar_inscripcion", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            List<Profesor> lp = (List<Profesor>) s.createQuery("from Profesor").list();
            List<TutorIndustrial> lti = (List<TutorIndustrial>) s.createQuery("from TutorIndustrial").list();

            List<PeriodoPasantiaLarga> ppl = (List<PeriodoPasantiaLarga>) s.createQuery("from PeriodoPasantiaLarga").list();
            List<PeriodoPasantiaIntermedia> ppi = (List<PeriodoPasantiaIntermedia>) s.createQuery("from PeriodoPasantiaIntermedia").list();

            Estudiante e = (Estudiante) request.getSession().getAttribute("estudiante");
            EstudianteRealizaProyecto erp = new EstudianteRealizaProyecto();

            Proyecto p = new Proyecto();
            p.setCreated_at(new Date());

            s.save(p);

            //erp.setEstudiante(e);
            //erp.setProyecto(p);

            //s.save(erp);

            //paso los parametros por la sesion
            request.setAttribute("L_TA", lp);
            request.setAttribute("L_TI", lti);
            request.setAttribute("L_PPL",ppl);
            request.setAttribute("L_PPI",ppi);
            request.getSession().setAttribute("proyecto", p);

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_generar_inscripcion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_generar_inscripcion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_generar_inscripcion.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptios will normally be treated with
     * the default exception action.
     */
    public ActionForward A_generar_inscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_fases_pasantia", "V_generar_inscripcion", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Inscripcion_Pasantia fpasantia = (F_Inscripcion_Pasantia)form;
            Pasantia pas = new Pasantia();
            Proyecto pro = (Proyecto) request.getSession().getAttribute("proyecto");
            EstatusPasantia est = (EstatusPasantia) s.createQuery("from EstatusPasantia where estatus = :est").setString("est", "Por revisar").uniqueResult();
            Profesor prof = (Profesor) s.createQuery("from Profesor where idProfesor = :profId").setLong("profId", Long.parseLong(fpasantia.getTutor_academico())).uniqueResult();
            TutorIndustrial ti = (TutorIndustrial) s.createQuery("from TutorIndustrial where idTutorIndustrial = :tiId").setLong("tiId", Long.parseLong(fpasantia.getTutor_industrial())).uniqueResult();

            Calendar cal = Calendar.getInstance();

            pas.setProyecto(pro);
            pas.setEstatus(est);
            pas.setObjetivos_generales(fpasantia.getObjetivos());
            pas.setResumen(fpasantia.getResumen());
            pas.setTitulo(fpasantia.getTitulo_pasantia());
            pas.setTutor_academico(prof);
            pas.setTutor_industrial(ti);
            // Año actual. Hay que sumarle 1 si es para E-M
            pas.setAno(cal.get(Calendar.YEAR));

            s.save(pas);


            String tipo = fpasantia.getTipo();
            if(tipo.equals("1")){
                PasantiaCorta pc = new PasantiaCorta();
                pc.setPasantia(pas);
                s.save(pc);
                request.getSession().setAttribute("pc", pc);
            }if(tipo.equals("2")){
                PasantiaIntermedia pi = new PasantiaIntermedia();
                pi.setPasantia(pas);
                PeriodoPasantiaIntermedia ppi = (PeriodoPasantiaIntermedia) s.createQuery("from PeriodoPasantiaIntermedia where idPeriodoPasantiaIntermedia = :pId").setLong("pId", Long.parseLong(fpasantia.getPeriodo())).uniqueResult();
                pi.setPeriodo(ppi);
                s.save(pi);
                request.getSession().setAttribute("pi", pi);
            }if(tipo.equals("3")){
                PasantiaLarga pl = new PasantiaLarga();
                pl.setPasantia(pas);
                PeriodoPasantiaLarga ppl = (PeriodoPasantiaLarga) s.createQuery("from PeriodoPasantiaLarga where idPeriodoPasantiaLarga = :pId").setLong("pId", Long.parseLong(fpasantia.getPeriodo())).uniqueResult();
                pl.setPeriodo(ppl);
                s.save(pl);
                request.getSession().setAttribute("pl", pl);

            }

            request.getSession().setAttribute("pasantia", pas);


            List<Area> L_Areas = s.createQuery("from Area").list();
            request.getSession().setAttribute("L_Areas", L_Areas);

            fpasantia.reset(mapping, request);
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_generar_inscripcion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_generar_inscripcion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_area.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptios will normally be treated with
     * the default exception action.
     */
    public ActionForward A_agregar_area(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_areas", "V_areas", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Area farea = (F_Area)form;

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_area.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_area.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_guardar_areas.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptios will normally be treated with
     * the default exception action.
     */
    public ActionForward A_guardar_areas(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_fases_pasantia", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_guardar_areas.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_finalizar_inscripcion.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptios will normally be treated with
     * the default exception action.
     */
    public ActionForward A_finalizar_inscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_fases_pasantia", "A_Prep_Gestion_Pasantias_Estudiante", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //aqui comienza
            Pasantia pas = (Pasantia) request.getSession().getAttribute("pasantia");
            List<Fase> lf = s.createQuery("from Fase where pasantia = :pas").setLong("pas", pas.getId()).list();
            if(!lf.isEmpty())
                salida = SALIDA_1;

                Proyecto pro = (Proyecto) request.getSession().getAttribute("proyecto");
                Estudiante e = (Estudiante) request.getSession().getAttribute("estudiante");
                EstudianteRealizaProyecto erp = new EstudianteRealizaProyecto();
                erp.setEstudiante(e);
                erp.setProyecto(pro);
                s.save(erp);
            //aqui termina
                tr.commit();
        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_finalizar_inscripcion.msg0"));
        }
        if (salida==1) {
          Proyecto pro = (Proyecto) request.getSession().getAttribute("proyecto");
          Estudiante e = (Estudiante) request.getSession().getAttribute("estudiante");
          request.setAttribute("msg","Inscripcion finaliza correctamente. E<"+e.getId()+"-"+e.getNombre()+">"+"P<"+pro.getId()+"-"+pro.getCreated_at()+">");
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_fase.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptions will normally be treated with
     * the default exception action.
     */
    public ActionForward A_agregar_fase(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividad_fase", "V_fases_pasantia"};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Fase_Pasantia ffase = (F_Fase_Pasantia)form;
            if(!ffase.getObjetivos_especificos().equals("")){
                Fase f = new Fase();
                f.setObjetivos_especificos(ffase.getObjetivos_especificos());
                Pasantia p = (Pasantia) request.getSession().getAttribute("pasantia");
                f.setPasantia(p);
                s.save(f);
                request.getSession().setAttribute("fase", f);
            }else{
                salida = SALIDA_1;
            }
            ffase.reset(mapping, request);
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_fase.msg1"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_fase.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_guardar_fase.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptios will normally be treated with
     * the default exception action.
     */
    public ActionForward A_guardar_fase(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividad_fase", "V_fases_pasantia", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //aqui comienza el codigo
            Fase f = (Fase) request.getSession().getAttribute("fase");
            s.refresh(f);
            if(!f.getActividades().isEmpty()){
                salida = SALIDA_1;
            }
            //aqui termina el codigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg","Error agregando actividades para esta fase, intente de nuevo.");
        }
        if (salida==1) {
          request.setAttribute("msg","Actividades de la fase agregadas con éxito");
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_actividad.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @return The Struts name of the following step.
     * @throws java.lang.Exception For untreated exceptions.
     * These exceptions will normally be treated with
     * the default exception action.
     */
    public ActionForward A_agregar_actividad(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividad_fase", "V_actividad_fase", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Actividad_Fase factividad = (F_Actividad_Fase)form;
            if(!factividad.getDescripcion().equals("") && !factividad.getTiempo_estimado().equals("")){
                ActividadFase af = new ActividadFase();
                af.setDescripcion(factividad.getDescripcion());
                af.setTiempo_estimado(factividad.getTiempo_estimado());
                af.setFase((Fase)request.getSession().getAttribute("fase"));
                s.save(af);
            }else{salida = SALIDA_1;}
            factividad.reset(mapping, request);
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try {s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_actividad.msg1"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_actividad.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}