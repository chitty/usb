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
public class AccionesC_Solicitar_pasantes extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_Prep_gestionar_solicitud_pasantes.
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
    public ActionForward A_Prep_gestionar_solicitud_pasantes(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_solicitud_pasantes", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            Empresa e = (Empresa) request.getSession().getAttribute("empresa");
            List<EmpresaSolicitaPasante> esp = (List<EmpresaSolicitaPasante>) s.createQuery("from EmpresaSolicitaPasante esp join fetch esp.empresa join fetch esp.carrera where esp.empresa = :e").setLong("e",e.getId()).list();
            List<Carrera> carreras = (List<Carrera>) s.createQuery("from Carrera").list();
            request.setAttribute("L_esp", esp);
            request.setAttribute("L_carreras", carreras);
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_Prep_gestionar_solicitud_pasantes.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_solicitar_pasante.
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
    public ActionForward A_solicitar_pasante(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_gestionar_solicitud_pasantes", "A_Prep_gestionar_solicitud_pasantes", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Solicitud_Pasante fsp = (F_Solicitud_Pasante)form;
            if(!fsp.getCarrera().equals("0")){
                Long idC = Long.parseLong(fsp.getCarrera());
                EmpresaSolicitaPasante esp = new EmpresaSolicitaPasante();
                Empresa e = (Empresa) request.getSession().getAttribute("empresa");
                Carrera c = (Carrera) s.createQuery("from Carrera c where c.idCarrera = :var").setLong("var", idC).uniqueResult();
                esp.setCarrera(c);
                esp.setEmpresa(e);
                esp.setCreated_at(new Date());
                s.save(esp);
                salida = SALIDA_0;
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
            getResources(request).getMessage("A_solicitar_pasante.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_solicitar_pasante.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_eliminar_solicitud.
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
    public ActionForward A_eliminar_solicitud(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_gestionar_solicitud_pasantes", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            Long id = Long.parseLong((String)request.getParameter("solId"));
            EmpresaSolicitaPasante esp = (EmpresaSolicitaPasante) s.createQuery("from EmpresaSolicitaPasante esp where esp.idEmpresaSolicitaPasante = :var").setLong("var",id).uniqueResult();
            s.delete(esp);
            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_eliminar_solicitud.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}