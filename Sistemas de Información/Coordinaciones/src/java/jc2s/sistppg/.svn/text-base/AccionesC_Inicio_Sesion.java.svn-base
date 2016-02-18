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
public class AccionesC_Inicio_Sesion extends CohesionAction {

/**
     * Called by Struts for the execution of action A_Prep_Inicio_Sesion.
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
    public ActionForward A_Prep_Inicio_Sesion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Inicio_Sesion", };
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
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_Prep_Inicio_Sesion.msg0"));

          new CohesionActor(CohesionActor.NO_ACTOR)
                        .setMe(request);
        }

        return mapping.findForward(SALIDAS[salida]);
    }

/**
     * Called by Struts for the execution of action A_Inicio_Sesion.
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
    public ActionForward A_Inicio_Sesion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Inicio_Sesion", "A_Prep_Inicio_Sesion_Est", "A_Prep_Inicio_Sesion_Prof", "A_Prep_Sesion_Coordinador", "A_prep_sesion_ccds" };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;
        final int SALIDA_2 = 2;
        final int SALIDA_3 = 3;
        final int SALIDA_4 = 4;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Inicio_Sesion fF_Inicio_Sesion = (F_Inicio_Sesion)form;
            //mi codigo
            String usbid = fF_Inicio_Sesion.getUsbid();

            Usuario u = (Usuario) s.createQuery("from Usuario where usbid= :var").setString("var", usbid).uniqueResult();

            if(u!=null){
                if(u.getTipo_actor().equals("estudiante")){
                    salida=SALIDA_1;
                    Estudiante e = (Estudiante) s.createQuery("from Estudiante where usbid= :var").setString("var", usbid).uniqueResult();
                    request.getSession().setAttribute("Estudiante", e);
                } else if (u.getTipo_actor().equals("profesor")){
                    salida=SALIDA_2;
                    Profesor prof = (Profesor) s.createQuery("from Profesor where usbid= :var").setString("var", usbid).uniqueResult();
                    request.getSession().setAttribute("Profesor", prof);
                } else if (u.getTipo_actor().equals("coordinacion")){
                    salida=SALIDA_3;
                } else if (u.getTipo_actor().equals("cctds")){
                    salida=SALIDA_4;
                }

                request.getSession().setAttribute("usuario", u);
            }
            //micodigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
            if (salida == 1) {
                new CohesionActor(CohesionActor.ACTOR_estudiante)
                        .setMe(request);
            }
            if (salida == 2) {
                new CohesionActor(CohesionActor.ACTOR_profesor)
                        .setMe(request);
            }
            if (salida == 3) {
                new CohesionActor(CohesionActor.ACTOR_cordiacion_de_carrera)
                        .setMe(request);
            }
            if (salida == SALIDA_4) {
                new CohesionActor(CohesionActor.ACTOR_coordinador_cctds)
                        .setMe(request);
            }

        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_Inicio_Sesion.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }



}