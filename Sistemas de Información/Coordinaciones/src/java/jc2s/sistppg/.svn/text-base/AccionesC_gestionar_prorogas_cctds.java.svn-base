package jc2s.sistppg;

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
public class AccionesC_gestionar_prorogas_cctds extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_gestionar_prorrogas.
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
    public ActionForward A_prep_gestionar_prorrogas(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_prorrogas", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            long pi_aprobada      = (Long) s.createQuery("SELECT COUNT(idProrrogaInscripcion) FROM ProrrogaInscripcion WHERE prorroga.estatus.idEstatusProrroga=1").uniqueResult();
            long pi_porrevisar    = (Long) s.createQuery("SELECT COUNT(idProrrogaInscripcion) FROM ProrrogaInscripcion WHERE prorroga.estatus.idEstatusProrroga=2").uniqueResult();
            long pi_pasarporcctds = (Long) s.createQuery("SELECT COUNT(idProrrogaInscripcion) FROM ProrrogaInscripcion WHERE prorroga.estatus.idEstatusProrroga=3").uniqueResult();
            long pi_rechazada     = (Long) s.createQuery("SELECT COUNT(idProrrogaInscripcion) FROM ProrrogaInscripcion WHERE prorroga.estatus.idEstatusProrroga=4").uniqueResult();

            long pe_aprobada      = (Long) s.createQuery("SELECT COUNT(idProrrogaEvaluacion) FROM ProrrogaEvaluacion WHERE prorroga.estatus.idEstatusProrroga=1").uniqueResult();
            long pe_porrevisar    = (Long) s.createQuery("SELECT COUNT(idProrrogaEvaluacion) FROM ProrrogaEvaluacion WHERE prorroga.estatus.idEstatusProrroga=2").uniqueResult();
            long pe_pasarporcctds = (Long) s.createQuery("SELECT COUNT(idProrrogaEvaluacion) FROM ProrrogaEvaluacion WHERE prorroga.estatus.idEstatusProrroga=3").uniqueResult();
            long pe_rechazada     = (Long) s.createQuery("SELECT COUNT(idProrrogaEvaluacion) FROM ProrrogaEvaluacion WHERE prorroga.estatus.idEstatusProrroga=4").uniqueResult();

            request.setAttribute("pi_aprobada", pi_aprobada);
            request.setAttribute("pi_porrevisar", pi_porrevisar);
            request.setAttribute("pi_pasarporcctds", pi_pasarporcctds);
            request.setAttribute("pi_rechazada", pi_rechazada);

            request.setAttribute("pe_aprobada", pe_aprobada);
            request.setAttribute("pe_porrevisar", pe_porrevisar);
            request.setAttribute("pe_pasarporcctds", pe_pasarporcctds);
            request.setAttribute("pe_rechazada", pe_rechazada);

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
     * Called by Struts for the execution of action A_consultar_prorrogas_i.
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
    public ActionForward A_consultar_prorrogas_i(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consultar_prorrogas_i", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            List<ProrrogaInscripcion> prorrogas = (List<ProrrogaInscripcion>) s.createQuery("from ProrrogaInscripcion pi join fetch pi.prorroga pr join fetch pr.estatus").list();
            request.setAttribute("L_prorrogas", prorrogas);
            //prorrogas.get(0).getProrroga().getEstatus().getEstatus()
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
     * Called by Struts for the execution of action A_consultar_prorrogas_e.
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
    public ActionForward A_consultar_prorrogas_e(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consultar_prorrogas_e", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            List<ProrrogaEvaluacion> prorrogas = (List<ProrrogaEvaluacion>) s.createQuery("from ProrrogaEvaluacion pe join fetch pe.prorroga pr join fetch pr.estatus").list();
            request.setAttribute("L_prorrogas", prorrogas);
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
     * Called by Struts for the execution of action A_mostrar_prorroga.
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
    public ActionForward A_mostrar_prorroga(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_prorroga", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            if(!request.getParameter("tipo").equals("") && !request.getParameter("id").equals("")){
                long id = (long) Long.parseLong(request.getParameter("id"));
                if(request.getParameter("tipo").equals("e")){
                    ProrrogaEvaluacion pe = (ProrrogaEvaluacion) s.createQuery("from ProrrogaEvaluacion pe join fetch pe.prorroga p join fetch p.estatus where pe.idProrrogaEvaluacion = :id").setLong("id", id).uniqueResult();
                    if(request.getParameter("nuevo_estatus")!=null){
                        EstatusProrroga estatus = (EstatusProrroga) s.createQuery("from EstatusProrroga where idEstatusProrroga = :var").setLong("var", Long.parseLong(request.getParameter("nuevo_estatus"))).uniqueResult();
                        pe.getProrroga().setEstatus(estatus);
                       s.save(pe);
                    }
                    request.setAttribute("Prorroga", pe);
                }else{
                    ProrrogaInscripcion pi = (ProrrogaInscripcion) s.createQuery("from ProrrogaInscripcion pe join fetch pe.prorroga p join fetch p.estatus where pe.idProrrogaInscripcion = :id").setLong("id", id).uniqueResult();
                    if(request.getParameter("nuevo_estatus")!=null){
                        EstatusProrroga estatus = (EstatusProrroga) s.createQuery("from EstatusProrroga where idEstatusProrroga = :var").setLong("var", Long.parseLong(request.getParameter("nuevo_estatus"))).uniqueResult();
                        pi.getProrroga().setEstatus(estatus);
                        s.save(pi);
                    }
                    request.setAttribute("Prorroga", pi);
                }   

                request.setAttribute("tipo",request.getParameter("tipo"));

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



}