package jc2s.sistppg;

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


/**
 * 
 */
public class AccionesC_Pasantias_CCTDS extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_gestionar_pasantias_cctds.
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
    public ActionForward A_prep_gestionar_pasantias_cctds(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_pasantias_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {

            Date fecha_actual = new Date();
            Date fecha_anterior = new Date(fecha_actual.getTime());

            List<String> L_pc = (List<String>) s.createQuery("select erp.estudiante.usbid, pc.pasantia.titulo, pc.pasantia.tutor_academico.usbid, pc.pasantia.tutor_industrial.nombre, pc.pasantia.estatus.estatus from EstudianteRealizaProyecto erp, PasantiaCorta pc where erp.proyecto.id_proyecto = pc.pasantia.proyecto.id_proyecto").list();// and pc.pasantia.proyecto.created_at < :fecha_actual and pc.pasantia.proyecto.created_at > :fecha_anterior").setDate("fecha_actual", fecha_actual).setDate("fecha_anterior", fecha_anterior).list();
            List<String> L_pi = (List<String>) s.createQuery("select erp.estudiante.usbid, pc.pasantia.titulo, pc.pasantia.tutor_academico.usbid, pc.pasantia.tutor_industrial.nombre, pc.pasantia.estatus.estatus from EstudianteRealizaProyecto erp, PasantiaIntermedia pc where erp.proyecto.id_proyecto = pc.pasantia.proyecto.id_proyecto").list();// and pc.pasantia.proyecto.created_at < :fecha_actual and pc.pasantia.proyecto.created_at > :fecha_anterior").setDate("fecha_actual", fecha_actual).setDate("fecha_anterior", fecha_anterior).list();
            List<String> L_pl = (List<String>) s.createQuery("select erp.estudiante.usbid, pc.pasantia.titulo, pc.pasantia.tutor_academico.usbid, pc.pasantia.tutor_industrial.nombre, pc.pasantia.estatus.estatus from EstudianteRealizaProyecto erp, PasantiaLarga pc where erp.proyecto.id_proyecto = pc.pasantia.proyecto.id_proyecto").list();// and pc.pasantia.proyecto.created_at < :fecha_actual and pc.pasantia.proyecto.created_at > :fecha_anterior").setDate("fecha_actual", fecha_actual).setDate("fecha_anterior", fecha_anterior).list();

            System.out.println("size lc="+L_pc.size());
            System.out.println("size li="+L_pi.size());
            System.out.println("size ll="+L_pl.size());

            System.out.println("size fecha a="+fecha_actual.toString());
            System.out.println("size fecha ant="+fecha_anterior.toString());

            request.setAttribute("L_pc", L_pc);
            request.setAttribute("L_pi", L_pi);
            request.setAttribute("L_pl", L_pl);

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_gestionar_pasantias_cctds.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_consultar_resagados.
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
    public ActionForward A_consultar_resagados(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_rezagados", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
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
        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_consultar_pasantias_cctds.
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
    public ActionForward A_consultar_pasantias_cctds(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consultar_pasantias_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
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
        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_mostrar_pasantia_cctds.
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
    public ActionForward A_mostrar_pasantia_cctds(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_pasantia_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
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
        return mapping.findForward(SALIDAS[salida]);
    }



}