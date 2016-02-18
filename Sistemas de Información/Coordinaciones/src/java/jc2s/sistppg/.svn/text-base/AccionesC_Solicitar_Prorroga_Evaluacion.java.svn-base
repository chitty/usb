package jc2s.sistppg;

import java.util.Date;
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
public class AccionesC_Solicitar_Prorroga_Evaluacion extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_solicitar_prorroga_evaluacion.
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
    public ActionForward A_prep_solicitar_prorroga_evaluacion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_solicitar_prorroga_evaluacion", };
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
        return mapping.findForward(SALIDAS[salida]);
    }

    // MENCION
    public ActionForward A_prep_mencion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mencion", };
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
        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_solicitar_prorroga_evaluacion.
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
    public ActionForward A_solicitar_prorroga_evaluacion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_solicitar_prorroga_evaluacion", "A_Prep_Gestion_Pasantias_Estudiante", };
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

            F_Prorroga_Evaluacion fprorroga = (F_Prorroga_Evaluacion)form;
            String justificacion = fprorroga.getJustificacion();
            String[] fecha = fprorroga.getFecha_propuesta().split("/");
            if(!justificacion.equals("") && fecha.length==3){
                salida = SALIDA_1;
                Estudiante est = (Estudiante) request.getSession().getAttribute("estudiante");
                Prorroga p = new Prorroga();
                p.setCreated_at(new Date());
                p.setUpdated_at(new Date());
                EstatusProrroga e = (EstatusProrroga) s.createQuery("from EstatusProrroga where estatus = 'Por revisar'").uniqueResult();
                p.setEstatus(e);
                p.setEstudiante(est);

                s.save(p);
                ProrrogaEvaluacion pe = new ProrrogaEvaluacion();
                pe.setProrroga(p);

                Pasantia pas = (Pasantia) s.createQuery("from Pasantia p order by p.proyecto.created_at DESC").iterate().next();
                pe.setPasantia(pas);

                Date fecha_propuesta = new Date(Integer.parseInt(fecha[0])-1900,Integer.parseInt(fecha[1])-1,Integer.parseInt(fecha[2]));
                pe.setFecha_propuesta(fecha_propuesta);

                s.save(pe);
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
            getResources(request).getMessage("A_solicitar_prorroga_evaluacion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_solicitar_prorroga_evaluacion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    // Solicitar Mención
        public ActionForward A_solicitar_mencion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Consultar_Pasantia_Est", "A_Prep_Gestion_Pasantias_Estudiante", };
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

            F_Prorroga_Evaluacion fprorroga = (F_Prorroga_Evaluacion)form;
            String justificacion = fprorroga.getJustificacion();
            String[] fecha = fprorroga.getFecha_propuesta().split("/");
            if(!justificacion.equals("") && fecha.length==3){
                salida = SALIDA_1;
                Estudiante est = (Estudiante) request.getSession().getAttribute("estudiante");
                Prorroga p = new Prorroga();
                p.setCreated_at(new Date());
                p.setUpdated_at(new Date());
                EstatusProrroga e = (EstatusProrroga) s.createQuery("from EstatusProrroga where estatus = 'Por revisar'").uniqueResult();
                p.setEstatus(e);
                p.setEstudiante(est);

                s.save(p);
                ProrrogaEvaluacion pe = new ProrrogaEvaluacion();
                pe.setProrroga(p);

                Pasantia pas = (Pasantia) s.createQuery("from Pasantia p order by p.proyecto.created_at DESC").iterate().next();
                pe.setPasantia(pas);

                Date fecha_propuesta = new Date(Integer.parseInt(fecha[0])-1900,Integer.parseInt(fecha[1])-1,Integer.parseInt(fecha[2]));
                pe.setFecha_propuesta(fecha_propuesta);

                s.save(pe);
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
            getResources(request).getMessage("A_solicitar_prorroga_evaluacion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_solicitar_prorroga_evaluacion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }


}