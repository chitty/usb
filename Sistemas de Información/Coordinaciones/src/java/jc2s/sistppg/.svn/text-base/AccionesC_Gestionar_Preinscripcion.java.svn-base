package jc2s.sistppg;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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


public class AccionesC_Gestionar_Preinscripcion extends CohesionAction {

/**
     * Called by Struts for the execution of action A_prep_gestionar_preinscripcion.
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
    public ActionForward A_prep_gestionar_preinscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_preinscripcion", };
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
            List<Preinscripcion> preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estudiante = :idEst order by created_at desc").setLong("idEst", est.getIdEstudiante()).list();
            request.setAttribute("L_preins", preinscripciones);
            if(preinscripciones.isEmpty()){
                List<Ciudad> ciudades = (List<Ciudad>) s.createQuery("from Ciudad order by nombre desc").list();
                request.setAttribute("L_ciudades", ciudades);
            } else
                request.setAttribute("Estatus", preinscripciones.get(0).getEstatus());

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
     * Called by Struts for the execution of action A_Preinscripcion.
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
    public ActionForward A_Preinscripcion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestion_Pasantias_Est", "V_gestionar_preinscripcion",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo
            F_Preinscripcion f_pre = (F_Preinscripcion) form;

            boolean bloque = f_pre.getBloque();
            boolean buscar = f_pre.getBuscar();
            String donde = f_pre.getDonde();
            int tipo = f_pre.getTipo();

            Estudiante e = (Estudiante)request.getSession().getAttribute("estudiante");
            List<Preinscripcion> lp = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estudiante = :idEst and tipo = 1").setLong("idEst",e.getIdEstudiante()).list();

            if(lp.isEmpty()){
                Preinscripcion pre = new Preinscripcion();

                pre.setPor_graduar(bloque);
                pre.setTramitecctds(buscar);
                pre.setRegiones(donde);
                pre.setEstudiante(e);
                pre.setEstatus(false);
                pre.setTipo(tipo);
                pre.setCreated_at(new Date());

                f_pre.reset(mapping, request);
                s.save(pre);

                CiudadPreinscripcion cp;
                Ciudad c;
                String[] ciudades = donde.split(",");
                for(int i=0;i<ciudades.length;i++){
                    c = (Ciudad) s.createQuery("from Ciudad c where c.idCiudad = :idc").setLong("idc", Long.parseLong(ciudades[i])).uniqueResult();
                    cp = new CiudadPreinscripcion();
                    cp.setCiudad(c);
                    cp.setPreinscripcion(pre);
                    s.save(cp);
                }



                salida = SALIDA_0;
            } else {
                // ERROR YA UD está preinscrito!!!!!!!!!!!
                salida = SALIDA_1;
            }

            if (salida == 1) {
                request.setAttribute("msg",
                getResources(request).getMessage("A_Preinscipcion.msg1"));
            }

            //mi codigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try {
                s.close();
            } catch (Exception ex2) {
            }
        }
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Preinscripcion.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    // ELIMINAR PREINSCRIPCION

    public ActionForward A_EliminarPreinscripcion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestion_Pasantias_Est", "V_gestionar_preinscripcion",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo

            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            Estudiante estudiante = (Estudiante) s.createQuery("from Estudiante where usbid = :login").setString("login", u.getUsbid()).uniqueResult();

            // Un estudiante SOLO puede tener UNA PreInscripcion
            Preinscripcion preinscripcion = (Preinscripcion) s.createQuery("from Preinscripcion where estudiante = :idEst order by created_at desc").setLong("idEst", estudiante.getIdEstudiante()).uniqueResult();

            if (preinscripcion != null) {
                // ON DELETE CASCADE A MANO
                Set<CiudadPreinscripcion> c = preinscripcion.getCiudadesPreinscripcion();
                Iterator it = c.iterator();
                while(it.hasNext()){
                    CiudadPreinscripcion ciudad = (CiudadPreinscripcion) it.next();
                    CiudadPreinscripcion c2 = (CiudadPreinscripcion) s.get(CiudadPreinscripcion.class, ciudad.getId());
                    s.delete(c2);
                }
            }

            //mi codigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try {
                s.close();
            } catch (Exception ex2) {
            }
        }

        // Abro otra sesión para borrar la preinscripción
        ahoraBorro(request);

        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_EliminarPreinscripcion.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    // Otra sesión para borrar la preinscripción
    // Solución no elegante, pero funciona
    public void ahoraBorro(HttpServletRequest request) throws Exception{
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo

            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            Estudiante estudiante = (Estudiante) s.createQuery("from Estudiante where usbid = :login").setString("login", u.getUsbid()).uniqueResult();

            // Un estudiante SOLO puede tener UNA PreInscripcion
            Preinscripcion preinscripcion = (Preinscripcion) s.createQuery("from Preinscripcion where estudiante = :idEst order by created_at desc").setLong("idEst", estudiante.getIdEstudiante()).uniqueResult();

            if (preinscripcion != null) {

                Preinscripcion p = (Preinscripcion) s.get(Preinscripcion.class, preinscripcion.getId());
                s.delete(p);
            }

            //mi codigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try {
                s.close();
            } catch (Exception ex2) {
            }
        }
    }


}