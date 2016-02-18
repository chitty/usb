package jc2s.sistppg;

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
public class AccionesC_Solicitar_Prorroga_Inscripcion extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_solicitar_prorroga_inscripcion.
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
    public ActionForward A_prep_solicitar_prorroga_inscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_solicitar_prorroga_inscripcion", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {

            Estudiante est = (Estudiante)request.getSession().getAttribute("estudiante");
            List<Prorroga> prorrogas = (List<Prorroga>) s.createQuery("from Prorroga where estudiante = :idEst and idProrroga IN (Select prorroga from ProrrogaInscripcion)").setLong("idEst", est.getIdEstudiante()).list();

            Prorroga pro = null;
            if (!prorrogas.isEmpty())
                pro = prorrogas.get(0);

            request.setAttribute("Prorroga", pro);

            if(!prorrogas.isEmpty())
                request.setAttribute("Estatus", pro.getEstatus().getEstatus());

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
     * Called by Struts for the execution of action A_solicitar_prorroga_inscripcion.
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
    public ActionForward A_solicitar_prorroga_inscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_solicitar_prorroga_inscripcion", "V_Gestion_Pasantias_Est", };
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
            Estudiante est = (Estudiante) request.getSession().getAttribute("estudiante");
            F_Prorroga_Inscripcion fprorroga = (F_Prorroga_Inscripcion)form;
            List<Prorroga> pl = (List<Prorroga>) s.createQuery("from Prorroga pr where pr.estudiante.idEstudiante = :var").setLong("var", est.getIdEstudiante()).list();
            if(!fprorroga.getJustificacion().equals("") && pl.isEmpty()){
                Prorroga p = new Prorroga();
                p.setCreated_at(new Date());
                p.setUpdated_at(new Date());
                EstatusProrroga e = (EstatusProrroga) s.createQuery("from EstatusProrroga where estatus = 'Por revisar'").uniqueResult();
                p.setEstatus(e);
                String justificacion = fprorroga.getJustificacion();
                p.setJustificacion(justificacion);
                p.setEstudiante(est);
                s.save(p);
                ProrrogaInscripcion pi = new ProrrogaInscripcion();
                pi.setProrroga(p);
                s.save(pi);
                salida = SALIDA_1;
            }
            tr.commit();
            fprorroga.reset(mapping, request);

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_solicitar_prorroga_inscripcion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_solicitar_prorroga_inscripcion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}