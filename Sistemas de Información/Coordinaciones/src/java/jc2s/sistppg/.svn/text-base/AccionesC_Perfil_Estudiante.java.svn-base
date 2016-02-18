package jc2s.sistppg;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AccionesC_Perfil_Estudiante extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_prep_crear_perfil_estudiante.
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
    public ActionForward A_prep_crear_perfil_estudiante(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_est",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //micodigo
            List<Carrera> c = s.createQuery("from Carrera").list();
            Estudiante e = new Estudiante();
            request.setAttribute("L_Carreras", c);
            request.setAttribute("Datos", e);
            //micodigo
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
            new CohesionActor(CohesionActor.ACTOR_estudiante).setMe(request);
        }
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_prep_crear_perfil_estudiante.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_guardar_perfil.
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
    public ActionForward A_guardar_perfil(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_est", "A_Prep_Inicio_Sesion_Est",};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_1;
        //Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 4)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            F_Perfil_Estudiante fperfil = (F_Perfil_Estudiante) form;
            //mi codigo
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            List<Estudiante> lu = s.createQuery("from Estudiante where usbid= :var").setString("var", u.getUsbid()).list();

            Estudiante e;
            if (lu.isEmpty()) {
                e = new Estudiante();

                e.setUsbid(u.getUsbid());


                //verifico nombre
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getNombre())) {
                    e.setNombre(fperfil.getNombre());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                }
                //verifico apellido
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getApellido())) {
                    e.setApellido(fperfil.getApellido());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Apellido Válido");
                }
                //verifico cedula
                if (Pattern.matches("(v|V|e|E)?-?[0-9]+", fperfil.getCedula())) {
                    e.setCedula(Integer.parseInt(fperfil.getCedula()));
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Cedula Válida");
                }

                //verifico email
                if (Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", fperfil.getEmail())) {
                    e.setEmail(fperfil.getEmail());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Mail Válido");
                }

                //verifico telefono
                if (Pattern.matches("(\\d){0,4}-?\\d{7}", fperfil.getTelefono())) {
                    e.setTelefono(fperfil.getTelefono());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Teléfono Válido");
                }

                //verifico nacionalidad
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getNacionalidad())) {
                    e.setNacionalidad(fperfil.getNacionalidad());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Nacionalidad Válido");
                }

                //verifico indice
                if (Pattern.matches("((0*[1-4](\\.[0-9]+)?)|5(\\.0*)?)", fperfil.getIndice())) {
                    e.setIndice(Double.parseDouble(fperfil.getIndice()));
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Indice Válido");
                }

                //verifico direccion
                if (Pattern.matches(".+", fperfil.getDireccion())) {
                    e.setDireccion(fperfil.getDireccion());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Direccion Válido");
                }

                e.setSexo(fperfil.getSexo());
                e.setOtrotelefono(fperfil.getOtroTelefono());
                e.setEdocivil(fperfil.getEstadoCivil());


                //verifico fecha
                if (Pattern.matches("[0-9][0-9]?/[0-9][0-9]?/[0-9][0-9][0-9][0-9]", fperfil.getFecha_nacimiento())) {
                    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = formatoDelTexto.parse(fperfil.getFecha_nacimiento());
                    e.setFecha_nacimiento(fecha);
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Fecha Válida");
                }


                if (salida != SALIDA_0) {
                    int idCarrera = Integer.parseInt(fperfil.getCarrera());
                    Carrera c = (Carrera) s.createQuery("from Carrera where idCarrera = :var").setInteger("var", idCarrera).uniqueResult();
                    if (c != null) {
                        e.setCarrera(c);
                    }


                    //                e.setUsbid(u.getUsbid());
                    s.save(e);
                    request.getSession().setAttribute("Estudiante", e);
                    salida = SALIDA_1;
                }
            } else {
                e = lu.get(0);

                e.setUsbid(u.getUsbid());

                //verifico nombre
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getNombre())) {
                    e.setNombre(fperfil.getNombre());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                }
                //verifico apellido
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getApellido())) {
                    e.setApellido(fperfil.getApellido());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Apellido Válido");
                }
                //verifico cedula
                if (Pattern.matches("(v|V|e|E)?-?[0-9]+", fperfil.getCedula())) {
                    e.setCedula(Integer.parseInt(fperfil.getCedula()));
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Cedula Válida");
                }

                //verifico email
                if (Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", fperfil.getEmail())) {
                    e.setEmail(fperfil.getEmail());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Mail Válido");
                }

                //verifico telefono
                if (Pattern.matches("(\\d){0,4}-?\\d{7}", fperfil.getTelefono())) {
                    e.setTelefono(fperfil.getTelefono());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Teléfono Válido");
                }

                //verifico fecha
                if (Pattern.matches("[0-9][0-9]?/[0-9][0-9]?/[0-9][0-9][0-9][0-9]", fperfil.getFecha_nacimiento())) {
                    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = formatoDelTexto.parse(fperfil.getFecha_nacimiento());
                    e.setFecha_nacimiento(fecha);
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Fecha Válida");
                }



               //verifico nacionalidad
                if (Pattern.matches("([a-zA-Z]|\\s)+", fperfil.getNacionalidad())) {
                    e.setNacionalidad(fperfil.getNacionalidad());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Nacionalidad Válido");
                }

                //verifico indice
                if (Pattern.matches("((0*[1-4](\\.[0-9]+)?)|5(\\.0*)?)", fperfil.getIndice())) {
                    e.setIndice(Double.parseDouble(fperfil.getIndice()));
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte un Indice Válido");
                }

                //verifico direccion
                if (Pattern.matches(".+", fperfil.getDireccion())) {
                    e.setDireccion(fperfil.getDireccion());
                } else {
                    salida = SALIDA_0;
                    request.setAttribute("msg", "Por Favor Inserte una Direccion Válida");
                }

                e.setSexo(fperfil.getSexo());
                e.setOtrotelefono(fperfil.getOtroTelefono());
                e.setEdocivil(fperfil.getEstadoCivil());


                if (salida != SALIDA_0) {
                    int idCarrera = Integer.parseInt(fperfil.getCarrera());
                    Carrera c = (Carrera) s.createQuery("from Carrera where idCarrera = :var").setInteger("var", idCarrera).uniqueResult();
                    if (c != null) {
                        e.setCarrera(c);
                    }


                    //                e.setUsbid(u.getUsbid());
                    s.update(e);
                    request.getSession().setAttribute("Estudiante", e);
                    salida = SALIDA_1;
                }
            }

            if (salida == 0) {
//          request.setAttribute("msg",
//            getResources(request).getMessage("A_guardar_perfil_prof.msg0"));
                List<Carrera> c = s.createQuery("from Carrera").list();
                Estudiante ee = (Estudiante) s.createQuery("from Estudiante where usbid = :var").setString("var", u.getUsbid()).uniqueResult();
                request.setAttribute("L_Carreras", c);
                request.setAttribute("Datos", ee);
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
        if (salida == 1) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_guardar_perfil_prof.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_prep_modif_perfil_estudiante.
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
    public ActionForward A_prep_modif_perfil_estudiante(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_perfil_est",};
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

            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            List<Carrera> c = s.createQuery("from Carrera").list();
            Estudiante e = (Estudiante) s.createQuery("from Estudiante where usbid = :var").setString("var", u.getUsbid()).uniqueResult();
            request.setAttribute("L_Carreras", c);
            request.setAttribute("Datos", e);
            //micodigo
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
                    getResources(request).getMessage("A_prep_modif_perfil_estudiante.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }
}
