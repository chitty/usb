package jc2s.sistppg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class AccionesC_Gestionar_proyectos_Estudiante extends CohesionAction {

/**
     * Called by Struts for the execution of action A_Prep_Gestion_Proy_Est.
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
    public ActionForward A_Prep_Gestion_Proy_Est(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestion_Proy_Est", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //micodigo

            Estudiante e = (Estudiante) request.getSession().getAttribute("Estudiante");

            List<EstudianteRealizaProyecto> proyectos = s.createQuery("from EstudianteRealizaProyecto where estudiante= :var").setLong("var", e.getId()).list();

            request.setAttribute("EstudianteRealizaProyecto", proyectos);

            if (!proyectos.isEmpty()) {

                Iterator it = proyectos.iterator();
                EstudianteRealizaProyecto proy = new EstudianteRealizaProyecto();
                List<ProyectoDeGrado> tesis = new LinkedList<ProyectoDeGrado>();
                List<Pasantia> pasantias = new LinkedList<Pasantia>();

                while (it.hasNext()) {
                    proy = (EstudianteRealizaProyecto) it.next();
                    ProyectoDeGrado pg = (ProyectoDeGrado) s.createQuery("from ProyectoDeGrado where proyecto= :var").setLong("var", proy.getProyecto().getId()).uniqueResult();

                    if (pg != null) { // Es proyecto de grado
                        tesis.add(pg);
                    } else {                       
                        Pasantia pasantia = (Pasantia) s.createQuery("from Pasantia where proyecto= :var").setLong("var", proy.getProyecto().getId()).uniqueResult();
                        if (pasantia != null) {
                            pasantias.add(pasantia);
                        }
                    }
                }

                request.setAttribute("ProyectoDeGrado", tesis);
                request.setAttribute("Pasantias", pasantias);
            }

            //micodigo
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