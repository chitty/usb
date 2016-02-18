package jc2s.sistppg;

import java.util.regex.*;
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
public class AccionesC_Inicio_Sesion_T_industrial extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_prep_inicio_sesion_t_industrial.
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
    public ActionForward A_prep_inicio_sesion_t_industrial(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_inicio_sesion_t_industrial",};
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
            try {
                s.close();
            } catch (Exception ex2) {
            }
        }
        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_inicio_sesion_t_industrial.
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
    public ActionForward A_inicio_sesion_t_industrial(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_sesion_tutor_i", "V_inicio_sesion_t_industrial",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Inicio_Sesion_externo fF_Inicio_Sesion_externo = (F_Inicio_Sesion_externo) form;

            List<TutorIndustrial> le = s.createQuery("from TutorIndustrial where login = :login").setString("login", fF_Inicio_Sesion_externo.getLogin()).list();

            if (!le.isEmpty()) {
                TutorIndustrial e = le.get(0);
                if (e.getPassword().equals(fF_Inicio_Sesion_externo.getPassword())) {
                    request.getSession().setAttribute("tutorindustrial", e);
                    salida = SALIDA_0;
                    fF_Inicio_Sesion_externo.reset(mapping, request);
                }
            }

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
            new CohesionActor(CohesionActor.ACTOR_tutor_industrial).setMe(request);
        }
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_inicio_sesion_t_industrial.msg0"));
        }
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_inicio_sesion_t_industrial.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_modificar_perfil.
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
    public ActionForward A_modificar_perfil(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_modificar_perfil_TI",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors tutor_industrial
        if (!CohesionActor.checkActor(request, 16)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            TutorIndustrial ti = (TutorIndustrial) request.getSession().getAttribute("tutorindustrial");
            List<Empresa> em = s.createQuery("from Empresa").list();

//            TutorIndustrial p = (TutorIndustrial) s.createQuery("from TutorIndustrial where login = :var").setString("var", p.getUsbid()).uniqueResult();


            request.setAttribute("Datos", ti);
            request.setAttribute("L_Empresas", em);

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
                    getResources(request).getMessage("A_modificar_perfil.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_actualizar_perfil_TI.
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
    public ActionForward A_actualizar_perfil_TI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_modificar_perfil_TI", "V_sesion_tutor_i",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
//Checking for actors tutor_industrial
        if (!CohesionActor.checkActor(request, 16)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Tutor_Industrial fF_Tutor_Industrial = (F_Tutor_Industrial) form;

            //Mi Codigo

            String nombre = fF_Tutor_Industrial.getNombre();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s)+", nombre)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
            }


            String cedula = fF_Tutor_Industrial.getCedula();
            if (!Pattern.matches("(v|V|e|E)?-?[0-9]+", cedula)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Cédula Válida");
            }

            String email = fF_Tutor_Industrial.getEmail();
            if (!Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", email)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Email Válido");
            }

            String telefono = fF_Tutor_Industrial.getTelefono();
            if (!Pattern.matches("(\\d){0,4}-?\\d{7}", telefono)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Teléfono Válido");
            }

            String profesion = fF_Tutor_Industrial.getProfesion();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", profesion)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Profesión Válida");
            }

            String direccion = fF_Tutor_Industrial.getDireccion();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", direccion)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Dirección Válida");
            }

            String departamento = fF_Tutor_Industrial.getDepartamento();
            if (!Pattern.matches(".+", departamento)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Departamento Válido");
            }

            String cargo = fF_Tutor_Industrial.getCargo();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", cargo)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Cargo Válido");
            }


            String password = fF_Tutor_Industrial.getPassword();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", password)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Password Válido");
            }

            String login = fF_Tutor_Industrial.getLogin();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", login)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Login Incorrecto");
            }

            if (salida == SALIDA_1) {

                TutorIndustrial ti = new TutorIndustrial();
              
                
                int idEmpresa = Integer.parseInt(fF_Tutor_Industrial.getEmpresa());
                Empresa c = (Empresa) s.createQuery("from Empresa where idEmpresa = :var").setInteger("var", idEmpresa).uniqueResult();

//               List<TutorIndustrial> lp = s.createQuery("from TutorIndustrial where login= :var").setString("var", login).list();
//               TutorIndustrial tt = lp.get(0);
                ti.setEmpresa(c);
                ti.setCedula(cedula);
                ti.setEmail(email);
                ti.setNombre(nombre);
                ti.setTelefono(telefono);
                ti.setProfesion(profesion);
                ti.setDireccion(direccion);
                ti.setDepartamento(departamento);
                ti.setCargo(cargo);
                ti.setLogin(login);
                ti.setPassword(password);
               ti.setIdTutorIndustrial(((TutorIndustrial) request.getSession().getAttribute("tutorindustrial")).getIdTutorIndustrial());

                s.update(ti);
                request.getSession().setAttribute("tutorindustrial", ti);
                fF_Tutor_Industrial.reset(mapping, request);
            } else {
                TutorIndustrial ti = (TutorIndustrial) request.getSession().getAttribute("tutorindustrial");
                List<Empresa> em = s.createQuery("from Empresa").list();

//            TutorIndustrial p = (TutorIndustrial) s.createQuery("from TutorIndustrial where login = :var").setString("var", p.getUsbid()).uniqueResult();


                request.setAttribute("Datos", ti);
                request.setAttribute("L_Empresas", em);
            }

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
       
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_actualizar_perfil_TI.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_prep_gestionar_pasatias_TI.
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
    public ActionForward A_prep_gestionar_pasatias_TI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_pasantias_TI",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors tutor_industrial
        if (!CohesionActor.checkActor(request, 16)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            // Mi codigo
            TutorIndustrial tutor = (TutorIndustrial) request.getSession().getAttribute("tutorindustrial");
            List<Pasantia> pasantias = s.createQuery("from Pasantia where tutor_industrial = :var))").setLong("var", tutor.getId()).list();
            request.setAttribute("Pasantias", pasantias);

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
        return mapping.findForward(SALIDAS[salida]);
    }

    // EVALUAR PASANTIA TI
        public ActionForward A_evaluar_pasatias_TI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_evaluar_pasantias_TI",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors tutor_industrial
        if (!CohesionActor.checkActor(request, 16)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            // Mi codigo
            TutorIndustrial tutor = (TutorIndustrial) request.getSession().getAttribute("tutorindustrial");
            List<Pasantia> pasantias = s.createQuery("from Pasantia where tutor_industrial = :var))").setLong("var", tutor.getId()).list();
            request.setAttribute("Pasantias", pasantias);

            String pas = request.getParameter("idPasantia");
            
            long idPas = 57;
            if (pas != null)
                idPas = Long.valueOf(pas).longValue();
            
            Pasantia pasantia = (Pasantia) s.createQuery("from Pasantia where idpasantia= :var").setLong("var", idPas).uniqueResult();
            request.setAttribute("Pasantia", pasantia);

            F_EvaluacionTI eval = (F_EvaluacionTI) form;

            double nota = ( eval.getUno()+eval.getDos()+eval.getTres()+eval.getCuatro()
                    +eval.getCinco()+eval.getSeis()+eval.getSiete()+eval.getOcho()+
                    eval.getNueve()+eval.getDiez() ) / 10.0;

            if (nota > 0.11)
                request.setAttribute("Ya_Evaluo", nota);
            
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
        return mapping.findForward(SALIDAS[salida]);
    }
}
