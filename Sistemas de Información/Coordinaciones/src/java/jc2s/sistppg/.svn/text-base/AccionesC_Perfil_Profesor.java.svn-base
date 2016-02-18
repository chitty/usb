package jc2s.sistppg;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.*;
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
public class AccionesC_Perfil_Profesor extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_prep_crear_perfil_profesor.
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
    public ActionForward A_prep_crear_perfil_profesor(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_prof",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //Mi Codigo
            List<Departamento> d = s.createQuery("from Departamento").list();

            Profesor p = new Profesor();


            request.setAttribute("L_Departamentos", d);

            request.setAttribute("Datos", p);


            //Mi Codigo
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
                    getResources(request).getMessage("A_prep_crear_perfil_profesor.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_guardar_perfil_prof.
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
    public ActionForward A_guardar_perfil_prof(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_prof", "V_Sesion_Profesor",};
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
            F_Perfil_Profesor fF_Perfil_Profesor = (F_Perfil_Profesor) form;

            //mi codigo
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            List<Profesor> lp = s.createQuery("from Profesor where usbid= :var").setString("var", u.getUsbid()).list();

            Profesor p;
            if (lp.isEmpty()) {
                p = new Profesor();

                p.setUsbid(u.getUsbid());



                //verifico nombre
                if (Pattern.matches("([a-zA-Z]|\\s)+", fF_Perfil_Profesor.getNombre())) {
                    p.setNombre(fF_Perfil_Profesor.getNombre());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                }
                //verifico apellido
                if (Pattern.matches("([a-zA-Z]|\\s)+", fF_Perfil_Profesor.getApellido())) {
                    p.setApellido(fF_Perfil_Profesor.getApellido());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Apellido Válido");
                }
                //verifico cedula
                if (Pattern.matches("(v|V|e|E)?-?[0-9]+", fF_Perfil_Profesor.getCedula())) {
                    p.setCedula(fF_Perfil_Profesor.getCedula());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Cedula Válida");
                }

                //verifico email
                if (Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", fF_Perfil_Profesor.getEmail())) {
                    p.setEmail(fF_Perfil_Profesor.getEmail());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Mail Válido");
                }


                if (salida != SALIDA_0) {
                    int idDepartamento = Integer.parseInt(fF_Perfil_Profesor.getDepartamento());
                    Departamento c = (Departamento) s.createQuery("from Departamento where idDepartamento = :var").setInteger("var", idDepartamento).uniqueResult();
                    if (c != null) {
                        p.setDepartamento(c);
                    }



                    s.save(p);
                    request.getSession().setAttribute("profesor", p);
                    salida = SALIDA_1;
                }

            } else {
                p = lp.get(0);

                p.setUsbid(u.getUsbid());

                //verifico nombre
                if (Pattern.matches("([a-zA-Z]|\\s)+", fF_Perfil_Profesor.getNombre())) {
                    p.setNombre(fF_Perfil_Profesor.getNombre());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                }
                //verifico apellido
                if (Pattern.matches("([a-zA-Z]|\\s)+", fF_Perfil_Profesor.getApellido())) {
                    p.setApellido(fF_Perfil_Profesor.getApellido());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Apellido Válido");
                }
                //verifico cedula
                if (Pattern.matches("(v|V|e|E)?-?[0-9]+", fF_Perfil_Profesor.getCedula())) {
                    p.setCedula(fF_Perfil_Profesor.getCedula());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Cedula Válida");
                }

                //verifico email
                if (Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", fF_Perfil_Profesor.getEmail())) {
                    p.setEmail(fF_Perfil_Profesor.getEmail());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Mail Válido");
                }


                if (salida != SALIDA_0) {
                    int idDepartamento = Integer.parseInt(fF_Perfil_Profesor.getDepartamento());
                    Departamento c = (Departamento) s.createQuery("from Departamento where idDepartamento = :var").setInteger("var", idDepartamento).uniqueResult();
                    if (c != null) {
                        p.setDepartamento(c);
                    }



                    s.update(p);
                    request.getSession().setAttribute("Profesor", p);
                    salida = SALIDA_1;
                }
            }


            if (salida == 0) {
//          request.setAttribute("msg",
//            getResources(request).getMessage("A_guardar_perfil_prof.msg0"));
                List<Departamento> d = s.createQuery("from Departamento").list();

                Profesor pp = (Profesor) s.createQuery("from Profesor where usbid = :var").setString("var", u.getUsbid()).uniqueResult();


                request.setAttribute("L_Departamentos", d);

                request.setAttribute("Datos", pp);
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
//        if (salida == 0) {
////          request.setAttribute("msg",
////            getResources(request).getMessage("A_guardar_perfil_prof.msg0"));
//            List<Departamento> d = s.createQuery("from Departamento").list();
//
//            request.setAttribute("L_Departamentos", d);
//        }
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_guardar_perfil_prof.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_prep_modif_perfil_profesor.
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
    public ActionForward A_prep_modif_perfil_profesor(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_prof",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //Mi Codigo
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
             List<Departamento> d = s.createQuery("from Departamento").list();

            Profesor p = (Profesor) s.createQuery("from Profesor where usbid = :var").setString("var", u.getUsbid()).uniqueResult();


            request.setAttribute("L_Departamentos", d);

            request.setAttribute("Datos", p);
            //Mi Codigo
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
                    getResources(request).getMessage("A_prep_modif_perfil_profesor.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }
}
