package jc2s.sistppg;

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
public class AccionesC_Sesion_CCTDS extends CohesionAction {

/**
     * Called by Struts for the execution of action A_prep_sesion_ccds.
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
    public ActionForward A_prep_sesion_ccds(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_sesion_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            long p_aprobado      = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=1").uniqueResult();
            long p_retirado      = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=2").uniqueResult();
            long p_reprobado     = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=3").uniqueResult();
            long p_rezagado      = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=4").uniqueResult();
            long p_revisado      = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=5").uniqueResult();
            long p_porrevisar    = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=6").uniqueResult();
            long p_pasarporcctds = (Long) s.createQuery("SELECT COUNT(idPasantia) FROM Pasantia WHERE estatus.idEstatusPasantia=7").uniqueResult();
            long preins_noa      = (Long) s.createQuery("SELECT COUNT(idPreinscripcion) FROM Preinscripcion WHERE estatus = false").uniqueResult();
            long preins_a        = (Long) s.createQuery("SELECT COUNT(idPreinscripcion) FROM Preinscripcion WHERE estatus = true").uniqueResult();

            request.setAttribute("p_aprobado", p_aprobado);
            request.setAttribute("p_retirado", p_retirado);
            request.setAttribute("p_reprobado", p_reprobado);
            request.setAttribute("p_rezagado", p_rezagado);
            request.setAttribute("p_revisado", p_revisado);
            request.setAttribute("p_porrevisar", p_porrevisar);
            request.setAttribute("p_pasarporcctds", p_pasarporcctds);
            request.setAttribute("preins_noa", preins_noa);
            request.setAttribute("preins_a", preins_a);

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_prep_sesion_ccds.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}