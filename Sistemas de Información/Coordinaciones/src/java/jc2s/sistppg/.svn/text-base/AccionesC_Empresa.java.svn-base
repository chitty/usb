package jc2s.sistppg;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;
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
public class AccionesC_Empresa extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_Prep_Inicio_Sesion_Empresa.
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
    public ActionForward A_Prep_Inicio_Sesion_Empresa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Inicio_Sesion_Empresa",};
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
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Prep_Inicio_Sesion_Empresa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_Prep_Registro_Empresa.
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
    public ActionForward A_Prep_Registro_Empresa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Registro_Empresa",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo


            //paso la lista de ciudades
            List<Ciudad> L_Ciudades = s.createQuery("from Ciudad").list();
            request.setAttribute("L_Ciudades", L_Ciudades);

            List<Pais> L_Paises = s.createQuery("from Pais").list();
            request.setAttribute("L_Paises", L_Paises);
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
                    getResources(request).getMessage("A_Prep_Registro_Empresa.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_Registrar_Empresa.
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
    public ActionForward A_Registrar_Empresa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Inicio_Sesion_Empresa", "V_Registro_Empresa",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Registro_Empresa fempresa = (F_Registro_Empresa) form;

            //mi codigo

            //verifico si el usuario existe
            String login = fempresa.getLogin();
            if (!Pattern.matches("([a-zA-Z0-9]|_|-)+", login) || !(s.createQuery("from Empresa where login = :var").setString("var", login).list().isEmpty())) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte un Login Válido");
            }

            //verifico si la confirmacion del password es el password
            String password = fempresa.getPassword();
            if (!password.equals(fempresa.getConfirmar_password()) || password.equals("")) {
                salida = SALIDA_1;
            }

            //verifico que los demas campos obliatorios esten completos.
            String nombre = fempresa.getNombre();
            if (!Pattern.matches("([a-zA-Z0-9]|\\.|\\s)+", nombre)) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
            }

            String rif = fempresa.getRif();
            if (!Pattern.matches("[a-zA-Z]-?[0-9]+", rif)) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte un Rif Válido");
            }

            String telefono = fempresa.getTelefono();
            if (!Pattern.matches("(\\d){0,4}-?\\d{7}", telefono)) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte un Teléfono Válido");
            }

            String direccion = fempresa.getDireccion();
            if (!Pattern.matches(".+", direccion)) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte una Dirección Válida");
            }

            String email = fempresa.getEmail();
            if (!Pattern.matches(".+", email)) {
                salida = SALIDA_1;
                request.setAttribute("msg", "Por Favor Inserte un Email Válido");
            }

            if (salida == 0) {
                Empresa e = new Empresa();
                Ciudad c = (Ciudad) s.createQuery("from Ciudad where idCiudad = :var").setInteger("var", Integer.parseInt(fempresa.getCiudad())).list().get(0);
                Pais pa = (Pais) s.createQuery("from Pais where idPais = :var").setInteger("var", Integer.parseInt(fempresa.getPais())).list().get(0);

                e.setCiudad(c);
                e.setDireccion(direccion);
                e.setEmail(email);
                e.setLogin(login);
                e.setNombre(nombre);
                e.setPassword(password);
                e.setRif(rif);
                e.setTelefono(telefono);
                s.save(e);

                fempresa.reset(mapping, request);

            } else {
                List<Ciudad> L_Ciudades = s.createQuery("from Ciudad").list();
                request.setAttribute("L_Ciudades", L_Ciudades);

                 List<Pais> L_Paises = s.createQuery("from Pais").list();
            request.setAttribute("L_Paises", L_Paises);
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
                    getResources(request).getMessage("A_Registrar_Empresa.msg0"));
        }
//        if (salida == 1) {
//            request.setAttribute("msg",
//                    getResources(request).getMessage("A_Registrar_Empresa.msg1"));
//
//        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_Inicio_Sesion_Empresa.
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
    public ActionForward A_Inicio_Sesion_Empresa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Inicio_Sesion_Empresa", "V_Sesion_Empresa",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Inicio_Sesion_externo fempresa = (F_Inicio_Sesion_externo) form;

            //mi codigo

            List<Empresa> le = s.createQuery("from Empresa where login = :login").setString("login", fempresa.getLogin()).list();

            if (!le.isEmpty()) {
                Empresa e = le.get(0);
                if (e.getPassword().equals(fempresa.getPassword())) {
                    request.getSession().setAttribute("empresa", e);
//                    request.setAttribute("tutores", s.createQuery("from TutorIndustrial where empresa = :var").setLong("var", e.getId()).uniqueResult());
                    salida = SALIDA_1;
                    fempresa.reset(mapping, request);
                    request.setAttribute("L_Tutores", s.createQuery("from TutorIndustrial where empresa = :var").setLong("var", e.getId()).list());
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
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Inicio_Sesion_Empresa.msg0"));
        }
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Inicio_Sesion_Empresa.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_prep_agregar_tutor_I.
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
    public ActionForward A_prep_agregar_tutor_I(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Agregar_Tutor_I",};
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
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_prep_agregar_tutor_I.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_Agregar_Tutor_Ind.
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
    public ActionForward A_Agregar_Tutor_Ind(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Agregar_Tutor_I", "V_Sesion_Empresa",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Tutor_Industrial findustrial = (F_Tutor_Industrial) form;

            //mi codigo
            String nombre = findustrial.getNombre();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s)+", nombre)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
            }


            String cedula = findustrial.getCedula();
            if (!Pattern.matches("(v|V|e|E)?-?[0-9]+",cedula)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Cédula Válida");
            }

            String email = findustrial.getEmail();
            if (!Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+",email)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Email Válido");
            }

            String telefono = findustrial.getTelefono();
            if (!Pattern.matches("(\\d){0,4}-?\\d{7}", telefono)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Teléfono Válido");
            }

            String profesion = findustrial.getProfesion();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", profesion)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Profesión Válida");
            }

            String direccion = findustrial.getDireccion();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", direccion)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte una Dirección Válida");
            }

            String departamento = findustrial.getDepartamento();
            if (!Pattern.matches(".+", departamento)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Departamento Válido");
            }

            String cargo = findustrial.getCargo();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", cargo)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Cargo Válido");
            }

            String login = findustrial.getLogin();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", login)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Login Válido");
            }

            String password = findustrial.getPassword();
            if (!Pattern.matches("([a-zA-Z0-9]|\\s|,|\\.|_|-)+", password)) {
                salida = SALIDA_0;
                request.setAttribute("msg", "Por Favor Inserte un Password Válido");
            }


            if (salida == SALIDA_1) {

                TutorIndustrial ti = new TutorIndustrial();
                ti.setCedula(cedula);
                ti.setEmail(email);
                ti.setEmpresa((Empresa) request.getSession().getAttribute("empresa"));
                ti.setNombre(nombre);
                ti.setTelefono(telefono);
                ti.setProfesion(profesion);
                ti.setDireccion(direccion);
                ti.setDepartamento(departamento);
                ti.setCargo(cargo);
                ti.setLogin(login);
                ti.setPassword(password);

                s.save(ti);
                findustrial.reset(mapping, request);
                request.setAttribute("L_Tutores", s.createQuery("from TutorIndustrial where empresa = :var").setLong("var", ((Empresa) request.getSession().getAttribute("empresa")).getId()).list());
            }
            //mi codifo
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
//            request.setAttribute("msg",
//                    getResources(request).getMessage("A_Agregar_Tutor_Ind.msg0"));
//        }
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Agregar_Tutor_Ind.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }
}
