package jc2s.sistppg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ve.usb.cohesion.runtime.CohesionAction;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.usb.cohesion.runtime.HibernateUtil;
import jc2s.sistppg.hibernate.*;
import org.hibernate.EntityMode;


/**
 * 
 */
public class AccionesC_Gestionar_PG_Prof extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_gestionar_PG_prof.
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
    public ActionForward A_prep_gestionar_PG_prof(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_PG_prof", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
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
            getResources(request).getMessage("A_prep_gestionar_PG_prof.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_prep_agregar_PG.
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
    public ActionForward A_prep_agregar_PG(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_agregar_PG", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            Proyecto p = new Proyecto();
            Date date = new Date();
            p.setCreated_at(date);

            List<Estudiante> L_Est = s.createQuery("from Estudiante").list();
            request.setAttribute("L_Est", L_Est);

            s.save(p);

            request.getSession().setAttribute("proyecto",p);//guardo proyecto en la sesion.
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_agregar_PG.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_PG.
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
    public ActionForward A_agregar_PG(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_agregar_PG", "V_areas_pg", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Inscripcion_PG fpg = (F_Inscripcion_PG)form;

            //saco los datos del formulario y verifico que no esten vacios
            String nombre = fpg.getNombre();
            if(nombre.equals(""))
                salida = SALIDA_0;

            String recursos = fpg.getRecursos();
            if(nombre.equals(""))
                salida = SALIDA_0;

            String duracion = fpg.getDuracion_recursos();
            if(nombre.equals(""))
                salida = SALIDA_0;

            String puntos = fpg.getPuntos_de_interes();
            if(nombre.equals(""))
                salida = SALIDA_0;
            
            //
            if(salida != 0){
                Proyecto p = (Proyecto) request.getSession().getAttribute("proyecto");
                Estudiante est = (Estudiante) s.createQuery("from Estudiante where usbid = :usbidEst").setString("usbidEst", fpg.getEstudiante()).uniqueResult();
                ProyectoDeGrado pg = new ProyectoDeGrado();
                pg.setCodigo("PG-"+est.getUsbid()+p.getId_proyecto());//codigo
                pg.setNombre(nombre);//nombre
                pg.setDuracion_recursos(duracion);//duracion Recursos
                Profesor prof = (Profesor) request.getSession().getAttribute("profesor");
                pg.setProfesor(prof);//profesor
                pg.setPuntos_de_interes(puntos);//puntos de interes
                pg.setRecursos(recursos);//recursos
                pg.setProyecto(p);//proyecto

                EstudianteRealizaProyecto erp = new EstudianteRealizaProyecto();
                erp.setEstudiante(est);
                erp.setProyecto(p);

                s.save(pg);
                s.save(erp);

                request.getSession().setAttribute("pg", pg);//guado el pg en la sesion

                List<Area> L_Areas = s.createQuery("from Area").list();
                request.getSession().setAttribute("L_Areas", L_Areas);

                List<Area> L_Areas_PG = s.createQuery("from Area").list();
                L_Areas_PG.removeAll(L_Areas_PG);
                request.getSession().setAttribute("L_Areas_PG", L_Areas_PG);

            }
            tr.commit();
            fpg.reset(mapping, request);

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_PG.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_PG.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_area_PG.
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
    public ActionForward A_agregar_area_PG(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_areas_pg", "V_areas_pg", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Area farea = (F_Area)form;

            List<Area> L_Areas_PG = (List<Area>) request.getSession().getAttribute("L_Areas_PG");
            Area area = (Area) s.createQuery("from Area where idArea = :aid").setInteger("aid", Integer.parseInt(farea.getArea())).uniqueResult();
            if(!L_Areas_PG.contains(area)){
                ProyectoDeGrado pg = (ProyectoDeGrado) request.getSession().getAttribute("pg");

                AreaProyectoDeGrado apg = new AreaProyectoDeGrado();
                apg.setProyecto_de_grado(pg);
                apg.setArea(area);

                L_Areas_PG.add(area);
                request.getSession().setAttribute("L_Areas_PG", L_Areas_PG);

                s.save(apg);
            }
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_area_PG.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_area_PG.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_prep_etapas_ppg.
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
    public ActionForward A_prep_etapas_ppg(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_etapas_pg", "V_areas_pg", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            tr.commit();

            //
            List<Area> l = (List<Area>) request.getSession().getAttribute("L_Areas_PG");
            if(l.isEmpty())
                salida = SALIDA_1;


            request.getSession().setAttribute("netapa",0);
            //

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_etapas_ppg.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_etapas_ppg.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_prep_agregar_primera_etapa.
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
    public ActionForward A_prep_agregar_primera_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_agregar_primera_etapa", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //obtengo los trimestres
            List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
            request.setAttribute("L_Trim", L_Trim);
            //obtengo los trimestres
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_agregar_primera_etapa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_guardar_primera_etapa.
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
    public ActionForward A_guardar_primera_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividades_etapa", "V_agregar_primera_etapa"};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Etapa_PG fetapa_PG = (F_Etapa_PG)form;

            //verifico datos q no esten vacios
            String nombre = fetapa_PG.getNombre();
            if(nombre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Nombre valido.");
            }

            String resultados = fetapa_PG.getResultados_minimos();
            if(resultados.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese Resultados Minimos validos.");
            }

            String topicos = fetapa_PG.getTopicos();
            if(topicos.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese Topicos validos.");
            }

            String trimestre = fetapa_PG.getTrimestre();
            if(trimestre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Trimestre valido.");
            }

            int ano = fetapa_PG.getAno();
            if(ano > 2500 || ano < 2010){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un año valido.");
            }

            if(salida == 0){
                Etapa e = new Etapa();
                e.setAno(ano);
                e.setNombre(nombre);
                ProyectoDeGrado pg = (ProyectoDeGrado) request.getSession().getAttribute("pg");
                e.setProyecto_de_grado(pg);
                e.setResultados_minimos(resultados);
                Trimestre t = (Trimestre)s.createQuery("from Trimestre where idTrimestre = :trim").setLong("trim", Long.parseLong(trimestre)).uniqueResult();
                e.setTrimestre(t);
                s.save(e);
                request.getSession().setAttribute("etapa",e);
                request.getSession().setAttribute("netapa",1);

                PrimeraEtapa pe = new PrimeraEtapa();
                pe.setEtapa(e);
                pe.setDescripcion_topicos(topicos);
                s.save(pe);
                request.getSession().setAttribute("etapa1",pe);


                fetapa_PG.reset(mapping, request);
            }else{
                //obtengo los trimestres
                List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
                request.setAttribute("L_Trim", L_Trim);
                //obtengo los trimestres
            }
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_agregar_actividad_etapa.
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
    public ActionForward A_agregar_actividad_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividades_etapa", "V_actividades_etapa", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Actividad_Etapa factividad = (F_Actividad_Etapa)form;

            //verifico que todos los campos esten bien
            String desc = factividad.getDescripcion();
            if(!desc.equals("")){
                Actividad a = new Actividad();
                a.setDescripcion(desc);

                Etapa e = (Etapa) request.getSession().getAttribute("etapa");
                a.setEtapa(e);

                int netapa = (Integer) request.getSession().getAttribute("netapa");
                switch(netapa){
                    case 1:
                        PrimeraEtapa etapa1 = (PrimeraEtapa) request.getSession().getAttribute("etapa1");
                        a.setPrimera_etapa(etapa1);
                        List<Actividad> L_Act1 = (List<Actividad>) s.createQuery("from Actividad where etapa = :et").setLong("et",e.getIdEtapa()).list();
                        break;
                    case 2:
                        SegundaEtapa etapa2 = (SegundaEtapa) request.getSession().getAttribute("etapa2");
                        a.setSegunda_etapa(etapa2);
                        List<Actividad> L_Act2 = (List<Actividad>) s.createQuery("from Actividad where etapa = :et").setLong("et",e.getIdEtapa()).list();
                        break;
                    case 3:
                        TerceraEtapa etapa3 = (TerceraEtapa) request.getSession().getAttribute("etapa3");
                        a.setTercera_etapa(etapa3);
                        List<Actividad> L_Act3 = (List<Actividad>) s.createQuery("from Actividad where etapa = :et").setLong("et",e.getIdEtapa()).list();
                        break;
                }
                s.save(a);
                salida = SALIDA_1;
                request.setAttribute("msg","Actividad agregada.");
                factividad.reset(mapping, request);
            }


            

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {

        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_agregar_actividad_etapa.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_finalizar_actividades_etapa.
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
    public ActionForward A_finalizar_actividades_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividades_etapa", "V_etapas_pg", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
                List<Actividad> la;
                int netapa = (Integer) request.getSession().getAttribute("netapa");
                switch(netapa){
                    case 1:
                        PrimeraEtapa pe = (PrimeraEtapa) request.getSession().getAttribute("etapa1");
                        la = (List<Actividad>) s.createQuery("from Actividad where primera_etapa = :peId").setLong("peId", pe.getIdPrimeraEtapa()).list();
                        request.getSession().setAttribute("L_etapa1", la);
                        break;
                    case 2:
                        SegundaEtapa se = (SegundaEtapa) request.getSession().getAttribute("etapa2");
                        la = (List<Actividad>) s.createQuery("from Actividad where segunda_etapa = :peId").setLong("peId", se.getIdSegundaEtapa()).list();
                        request.getSession().setAttribute("L_etapa2", la);
                        break;
                    case 3:
                        TerceraEtapa te = (TerceraEtapa) request.getSession().getAttribute("etapa3");
                        la = (List<Actividad>) s.createQuery("from Actividad where tercera_etapa = :peId").setLong("peId", te.getIdTerceraEtapa()).list();
                        request.getSession().setAttribute("L_etapa3", la);
                        break;
                }
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_finalizar_actividades_etapa.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_finalizar_actividades_etapa.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_finalizar_generar_PG.
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
    public ActionForward A_finalizar_generar_PG(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_prep_gestionar_PG_prof", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("netapa");
            request.getSession().removeAttribute("etapa1");
            request.getSession().removeAttribute("etapa2");
            request.getSession().removeAttribute("etapa3");
            request.getSession().removeAttribute("etapa");
            request.getSession().removeAttribute("L_etapa1");
            request.getSession().removeAttribute("L_etapa2");
            request.getSession().removeAttribute("L_etapa3");
            request.getSession().removeAttribute("L_Areas_PG");
            request.getSession().removeAttribute("L_Areas");
            request.getSession().removeAttribute("etapa");
            request.getSession().removeAttribute("pg");
            request.getSession().removeAttribute("proyecto");


            tr.commit();

        } catch (Exception ex) {
            //tr.rollback();
            //throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_finalizar_generar_PG.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_prep_agregar_segunda_etapa.
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
    public ActionForward A_prep_agregar_segunda_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_agregar_segunda_etapa", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //obtengo los trimestres
            List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
            request.setAttribute("L_Trim", L_Trim);
            //obtengo los trimestres
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_agregar_segunda_etapa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_guardar_segunda_etapa.
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
    public ActionForward A_guardar_segunda_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividades_etapa", "V_agregar_segunda_etapa", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Etapa_PG fetapa_PG = (F_Etapa_PG)form;

            //verifico datos q no esten vacios
            String nombre = fetapa_PG.getNombre();
            if(nombre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Nombre valido.");
            }

            String resultados = fetapa_PG.getResultados_minimos();
            if(resultados.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese Resultados Minimos validos.");
            }

            String topicos = fetapa_PG.getTopicos();
            if(topicos.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese Topicos validos.");
            }

            String trimestre = fetapa_PG.getTrimestre();
            if(trimestre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Trimestre valido.");
            }

            int ano = fetapa_PG.getAno();
            if(ano > 2500 || ano < 2010){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un año valido.");
            }

            if(salida == 0){
                Etapa e = new Etapa();
                e.setAno(ano);
                e.setNombre(nombre);
                ProyectoDeGrado pg = (ProyectoDeGrado) request.getSession().getAttribute("pg");
                e.setProyecto_de_grado(pg);
                e.setResultados_minimos(resultados);
                Trimestre t = (Trimestre)s.createQuery("from Trimestre where idTrimestre = :trim").setLong("trim", Long.parseLong(trimestre)).uniqueResult();
                e.setTrimestre(t);
                s.save(e);
                request.getSession().setAttribute("etapa",e);
                request.getSession().setAttribute("netapa",2);

                SegundaEtapa se = new SegundaEtapa();
                se.setEtapa(e);
                se.setDescripcion_topicos(topicos);
                s.save(se);
                request.getSession().setAttribute("etapa2",se);


                fetapa_PG.reset(mapping, request);
            }else{
                //obtengo los trimestres
                List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
                request.setAttribute("L_Trim", L_Trim);
                //obtengo los trimestres
            }

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_guardar_segunda_etapa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_prep_agregar_tercera_etapa.
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
    public ActionForward A_prep_agregar_tercera_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_agregar_tercera_etapa", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //obtengo los trimestres
            List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
            request.setAttribute("L_Trim", L_Trim);
            //obtengo los trimestres
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_agregar_tercera_etapa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_guardar_tercera_etapa.
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
    public ActionForward A_guardar_tercera_etapa(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_actividades_etapa", "V_agregar_tercera_etapa", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors profesor
            if (!CohesionActor.checkActor(request, 8)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Etapa_PG fetapa_PG = (F_Etapa_PG)form;

            //verifico datos q no esten vacios
            String nombre = fetapa_PG.getNombre();
            if(nombre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Nombre valido.");
            }

            String resultados = fetapa_PG.getResultados_minimos();
            if(resultados.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese Resultados Minimos validos.");
            }

            String trimestre = fetapa_PG.getTrimestre();
            if(trimestre.equals("")){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un Trimestre valido.");
            }

            int ano = fetapa_PG.getAno();
            if(ano > 2500 || ano < 2011){
                salida = SALIDA_1;
                request.setAttribute("msg", "Ingrese un año valido.");
            }

            if(salida == 0){
                Etapa e = new Etapa();
                e.setAno(ano);
                e.setNombre(nombre);
                ProyectoDeGrado pg = (ProyectoDeGrado) request.getSession().getAttribute("pg");
                e.setProyecto_de_grado(pg);
                e.setResultados_minimos(resultados);
                Trimestre t = (Trimestre)s.createQuery("from Trimestre where idTrimestre = :trim").setLong("trim", Long.parseLong(trimestre)).uniqueResult();
                e.setTrimestre(t);
                s.save(e);
                request.getSession().setAttribute("etapa",e);
                request.getSession().setAttribute("netapa",3);

                TerceraEtapa te = new TerceraEtapa();
                te.setEtapa(e);
                s.save(te);
                request.getSession().setAttribute("etapa3",te);

                fetapa_PG.reset(mapping, request);
            }else{
                //obtengo los trimestres
                List<Trimestre> L_Trim = s.createQuery("from Trimestre").list();
                request.setAttribute("L_Trim", L_Trim);
                //obtengo los trimestres
            }
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_guardar_tercera_etapa.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}