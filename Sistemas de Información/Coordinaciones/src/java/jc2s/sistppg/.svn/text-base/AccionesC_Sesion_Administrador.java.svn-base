package jc2s.sistppg;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
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
public class AccionesC_Sesion_Administrador extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_Prep_Inicio_Sesion_Est.
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
    public ActionForward A_Inicio_Sesion_Adm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Sesion_Administrador",};
        final int SALIDA_0 = 0;


        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Agregar");
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
            new CohesionActor(CohesionActor.ACTOR_administrador).setMe(request);
        }
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Inicio_Sesion_Adm.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_Prep_Inicio_Sesion_Adm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_inicio_sesion_administrador",};
        final int SALIDA_0 = 0;


        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo
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
            new CohesionActor(CohesionActor.ACTOR_administrador).setMe(request);
        }
        if (salida == 0) {
            request.setAttribute("msg",
                    getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Carreras(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Carreras",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idCarrera");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null) {                                                                //AQUI ABAJO
                Carrera singular = (Carrera) s.createQuery("from Carrera where idCarrera= :var").setLong("var", Long.parseLong(request.getParameter("idCarrera"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<Carrera> dato = s.createQuery("from Carrera ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_carrera(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Carreras",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Carrera fF_Carrera = (F_Carrera) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idCarrera");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                Carrera singular = (Carrera) s.createQuery("from Carrera where idCarrera= :var").setLong("var", Long.parseLong(request.getParameter("idCarrera"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            Carrera p;
            boolean guarda = true;
            if (!fF_Carrera.getIdCarrera().equals("")) {                                        //CAMBIAR CLASES
                p = (Carrera) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new Carrera();
            }


//            p.setIdCarrera(Long.parseLong(fF_Carrera.getIdCarrera()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Carrera.getNombre())) {
                p.setNombre(fF_Carrera.getNombre());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }
            //verifico mail
            if (Pattern.matches("(\\w|-|\\.)+@(\\w|-|\\.)+\\.(\\w|-|\\.)+", fF_Carrera.getEmail())) {
                p.setEmail(fF_Carrera.getEmail());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Apellido Válido");
                return mapping.findForward(SALIDAS[salida]);
            }
            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<Carrera> dato = s.createQuery("from Carrera ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_carrera(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Carreras",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            Carrera p = (Carrera) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");






            List<Estudiante> guarda = s.createQuery("from Estudiante where carrera= :var").setLong("var", p.getIdCarrera()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar la carrera si aún hay estudiantes asociados a la misma");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }

            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Areas(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Areas",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("AreaD");
            request.getSession().removeAttribute("L_Areas");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
                List<Departamento> L_Areas = s.createQuery("from Departamento").list();
                request.getSession().setAttribute("L_Areas", L_Areas);
            }
            String parameter = request.getParameter("idArea");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                Area singular = (Area) s.createQuery("from Area where idArea= :var").setLong("var", Long.parseLong(parameter)).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
                Departamento AreaD = (Departamento) ((DepartamentoArea) s.createQuery("from DepartamentoArea where area= :var").setLong("var", Long.parseLong(request.getParameter("idArea"))).uniqueResult()).getDepartamento();
                request.getSession().setAttribute("AreaD", AreaD);
                List<Departamento> L_Areas = s.createQuery("from Departamento").list();
                request.getSession().setAttribute("L_Areas", L_Areas);
            }
            List<Area> predato = s.createQuery("from Area ").list();                             //CAMBIAR LA TABLA
            Iterator it = predato.iterator();
            Area iterado;


            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();
            while (it.hasNext()) {
                iterado = (Area) it.next();
                DepartamentoArea dato = (DepartamentoArea) s.createQuery("from DepartamentoArea where area= :var").setLong("var", iterado.getIdArea()).uniqueResult();
                Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_Prep_Gestionar_Areas.do?idArea=" + iterado.getIdArea() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td width=\"250px\"><center>" +  iterado.getNombre() + "</center></td><td width=\"250px\"><center>" + dato.getDepartamento().getNombre() + "</center></td></tr>");
            }

            if (!Devolucion.isEmpty()) {
                request.getSession().setAttribute("Datos", Devolucion);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_area(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Areas",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Area2 fF_Area2 = (F_Area2) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            request.getSession().removeAttribute("Datos");
//            String parameter = request.getParameter("idArea");               //CAMBIAR CLAVE
//            String parameter2 = request.getParameter("idArea");
//            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
//                Area singular = (Area) s.createQuery("from Area where idArea= :var").setLong("var", Long.parseLong(request.getParameter("idArea"))).uniqueResult();
//                request.getSession().setAttribute("Singular", singular);
//            }







            Area p;
            DepartamentoArea da;
            boolean guarda = true;
            if (!fF_Area2.getIdArea().equals("")) {                                        //CAMBIAR CLASES
                p = (Area) s.createQuery("from Area where idArea= :var").setLong("var", Long.parseLong(fF_Area2.getIdArea())).uniqueResult();
                guarda = false;
                List<DepartamentoArea> das = s.createQuery("from DepartamentoArea where area= :var").setLong("var", Long.parseLong(fF_Area2.getIdArea())).list();
                da = das.get(0);
            } else {
                p = new Area();
                da = new DepartamentoArea();
                da.setArea(p);
            }
            da.setDepartamento((Departamento) s.createQuery("from Departamento where idDepartamento= :var").setLong("var", Long.parseLong(fF_Area2.getDepartamento())).uniqueResult());




//            p.setIdArea(Long.parseLong(fF_Area2.getIdArea()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Area2.getArea())) {
                p.setNombre(fF_Area2.getArea());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
                s.save(da);
            } else {
                s.update(p);
                s.update(da);
            }
            request.getSession().setAttribute("idArea", fF_Area2.getArea());
            List<Area> dato = s.createQuery("from Area ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.getSession().removeAttribute("Agregar");
        request.getSession().removeAttribute("Agregare");

        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_area(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Areas",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
            request.getSession().removeAttribute("Datos");
            Area p = (Area) request.getSession().getAttribute("Singular");
            request.getSession().removeAttribute("Singular");
            DepartamentoArea ad = (DepartamentoArea) s.createQuery("from DepartamentoArea where area= :var").setLong("var", p.getIdArea()).uniqueResult();
//               request.getSession().removeAttribute("Singular");


            //List<Area> dato = s.createQuery("from Area ").list();
//            List<Area> dato = (List<Area>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<AreaProfesor> guarda = s.createQuery("from AreaProfesor where area= :var").setLong("var", p.getIdArea()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el área si aún hay profesores asociados a la misma");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }
            List<AreaProyectoDeGrado> guarda2 = s.createQuery("from AreaProyectoDeGrado where area= :var").setLong("var", p.getIdArea()).list();
            if (!guarda2.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el área si aún hay proyectos de grado asociados a la misma");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }





            s.delete(ad);
            s.delete(ad.getArea());


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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Departamentos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Departamentos",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idDepartamento");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null) {                                                                //AQUI ABAJO
                Departamento singular = (Departamento) s.createQuery("from Departamento where idDepartamento= :var").setLong("var", Long.parseLong(request.getParameter("idDepartamento"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<Departamento> dato = s.createQuery("from Departamento ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_departamento(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Departamentos",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Departamento fF_Departamento2 = (F_Departamento) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idDepartamento");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                Departamento singular = (Departamento) s.createQuery("from Departamento where idDepartamento= :var").setLong("var", Long.parseLong(request.getParameter("idDepartamento"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            Departamento p;
            boolean guarda = true;
            if (!fF_Departamento2.getIdDepartamento().equals("")) {                                        //CAMBIAR CLASES
                p = (Departamento) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new Departamento();
            }


//            p.setIdDepartamento(Long.parseLong(fF_Departamento2.getIdDepartamento()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Departamento2.getDepartamento())) {
                p.setNombre(fF_Departamento2.getDepartamento());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<Departamento> dato = s.createQuery("from Departamento ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_departamento(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Departamentos",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            Departamento p = (Departamento) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<Departamento> dato = s.createQuery("from Departamento ").list();
//            List<Departamento> dato = (List<Departamento>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<DepartamentoArea> guarda3 = s.createQuery("from DepartamentoArea where area= :var").setLong("var", p.getIdDepartamento()).list();
            if (!guarda3.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el departamento si aún hay areas asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }




            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Estatus_Pasantias(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Estatus_Pasantias",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idEstatus_Pasantia");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null) {                                                                //AQUI ABAJO
                EstatusPasantia singular = (EstatusPasantia) s.createQuery("from EstatusPasantia where idEstatusPasantia= :var").setLong("var", Long.parseLong(request.getParameter("idEstatus_Pasantia"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<EstatusPasantia> dato = s.createQuery("from EstatusPasantia ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_estatus_pasantia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Estatus_Pasantias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Estatus_Pasantia fF_EstatusPasantia = (F_Estatus_Pasantia) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idEstatus_Pasantia");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                EstatusPasantia singular = (EstatusPasantia) s.createQuery("from EstatusPasantia where idEstatusPasantia= :var").setLong("var", Long.parseLong(request.getParameter("idEstatus_Pasantia"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            EstatusPasantia p;
            boolean guarda = true;
            if (!fF_EstatusPasantia.getIdEstatusPasantia().equals("")) {                                        //CAMBIAR CLASES
                p = (EstatusPasantia) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new EstatusPasantia();
            }


//            p.setIdEstatus_Pasantia(Long.parseLong(fF_Estatus_Pasantia.getIdEstatus_Pasantia()));



            //verifico estatus
            if (Pattern.matches(".+", fF_EstatusPasantia.getEstatus())) {
                p.setEstatus(fF_EstatusPasantia.getEstatus());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un estatus Válido" + "LOOOOOOCOOOOOOOOO" + fF_EstatusPasantia.getEstatus());
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<EstatusPasantia> dato = s.createQuery("from EstatusPasantia ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_estatus_pasantia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Estatus_Pasantias",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            EstatusPasantia p = (EstatusPasantia) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<Estatus_Pasantia> dato = s.createQuery("from EstatusPasantia ").list();
//            List<Estatus_Pasantia> dato = (List<Estatus_Pasantia>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<Pasantia> guarda = s.createQuery("from Pasantia where estatus= :var").setLong("var", p.getIdEstatusPasantia()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el estatus si aún hay pasantías asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }



            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Estatus_Prorrogas(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Estatus_Prorrogas",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idEstatus_Prorroga");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null) {                                                                //AQUI ABAJO
                EstatusProrroga singular = (EstatusProrroga) s.createQuery("from EstatusProrroga where idEstatusProrroga= :var").setLong("var", Long.parseLong(request.getParameter("idEstatus_Prorroga"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<EstatusProrroga> dato = s.createQuery("from EstatusProrroga ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_estatus_prorroga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Estatus_Prorrogas",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Estatus_Prorroga fF_EstatusProrroga = (F_Estatus_Prorroga) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idEstatus_Prorroga");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                EstatusProrroga singular = (EstatusProrroga) s.createQuery("from EstatusProrroga where idEstatusProrroga= :var").setLong("var", Long.parseLong(request.getParameter("idEstatus_Prorroga"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            EstatusProrroga p;
            boolean guarda = true;
            if (!fF_EstatusProrroga.getIdEstatusProrroga().equals("")) {                                        //CAMBIAR CLASES
                p = (EstatusProrroga) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new EstatusProrroga();
            }


//            p.setIdEstatus_Prorroga(Long.parseLong(fF_Estatus_Prorroga.getIdEstatus_Prorroga()));



            //verifico estatus
            if (Pattern.matches(".+", fF_EstatusProrroga.getEstatus())) {
                p.setEstatus(fF_EstatusProrroga.getEstatus());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un estatus Válido" + "LOOOOOOCOOOOOOOOO" + fF_EstatusProrroga.getEstatus());
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<EstatusProrroga> dato = s.createQuery("from EstatusProrroga ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_estatus_prorroga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Estatus_Prorrogas",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            EstatusProrroga p = (EstatusProrroga) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<Estatus_Prorroga> dato = s.createQuery("from EstatusProrroga ").list();
//            List<Estatus_Prorroga> dato = (List<Estatus_Prorroga>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<Prorroga> guarda = s.createQuery("from Prorroga where estatus= :var").setLong("var", p.getIdEstatusProrroga()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el estatus si aún hay prorrogas asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }




            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Periodo_Pasantia_Intermedias(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Periodos_Pasantia_Intermedia",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idPeriodoPasantiaIntermedia");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                PeriodoPasantiaIntermedia singular = (PeriodoPasantiaIntermedia) s.createQuery("from PeriodoPasantiaIntermedia where idPeriodoPasantiaIntermedia= :var").setLong("var", Long.parseLong(request.getParameter("idPeriodoPasantiaIntermedia"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<PeriodoPasantiaIntermedia> dato = s.createQuery("from PeriodoPasantiaIntermedia ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_periodo_pasantia_intermedia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Periodo_Pasantia_Intermedias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Periodo_Pasantia_Intermedia fF_Periodo_Pasantia_Intermedia = (F_Periodo_Pasantia_Intermedia) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idPeriodoPasantiaIntermedia");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                PeriodoPasantiaIntermedia singular = (PeriodoPasantiaIntermedia) s.createQuery("from PeriodoPasantiaIntermedia where idPeriodoPasantiaIntermedia= :var").setLong("var", Long.parseLong(request.getParameter("idPeriodoPasantiaIntermedia"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            PeriodoPasantiaIntermedia p;
            boolean guarda = true;
            if (!fF_Periodo_Pasantia_Intermedia.getIdPeriodoPasantiaIntermedia().equals("")) {                                        //CAMBIAR CLASES
                p = (PeriodoPasantiaIntermedia) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new PeriodoPasantiaIntermedia();
            }


//            p.setIdPeriodoPasantiaIntermedia(Long.parseLong(fF_Periodo_Pasantia_Intermedia.getIdPeriodoPasantiaIntermedia()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Periodo_Pasantia_Intermedia.getPeriodoPasantiaIntermedia())) {
                p.setNombre(fF_Periodo_Pasantia_Intermedia.getPeriodoPasantiaIntermedia());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<PeriodoPasantiaIntermedia> dato = s.createQuery("from PeriodoPasantiaIntermedia ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_periodo_pasantia_intermedia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Periodo_Pasantia_Intermedias",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            PeriodoPasantiaIntermedia p = (PeriodoPasantiaIntermedia) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<PeriodoPasantiaIntermedia> dato = s.createQuery("from PeriodoPasantiaIntermedia ").list();
//            List<PeriodoPasantiaIntermedia> dato = (List<PeriodoPasantiaIntermedia>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<PasantiaIntermedia> guarda = s.createQuery("from PasantiaIntermedia where periodo= :var").setLong("var", p.getIdPeriodoPasantiaIntermedia()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el periodo si aún hay pasantías asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }



            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Periodo_Pasantia_Largas(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Periodos_Pasantia_Larga",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idPeriodoPasantiaLarga");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                PeriodoPasantiaLarga singular = (PeriodoPasantiaLarga) s.createQuery("from PeriodoPasantiaLarga where idPeriodoPasantiaLarga= :var").setLong("var", Long.parseLong(request.getParameter("idPeriodoPasantiaLarga"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<PeriodoPasantiaLarga> dato = s.createQuery("from PeriodoPasantiaLarga ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_periodo_pasantia_larga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Periodo_Pasantia_Largas",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Periodo_Pasantia_Larga fF_Periodo_Pasantia_Larga = (F_Periodo_Pasantia_Larga) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idPeriodoPasantiaLarga");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                PeriodoPasantiaLarga singular = (PeriodoPasantiaLarga) s.createQuery("from PeriodoPasantiaLarga where idPeriodoPasantiaLarga= :var").setLong("var", Long.parseLong(request.getParameter("idPeriodoPasantiaLarga"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            PeriodoPasantiaLarga p;
            boolean guarda = true;
            if (!fF_Periodo_Pasantia_Larga.getIdPeriodoPasantiaLarga().equals("")) {                                        //CAMBIAR CLASES
                p = (PeriodoPasantiaLarga) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new PeriodoPasantiaLarga();
            }


//            p.setIdPeriodoPasantiaLarga(Long.parseLong(fF_Periodo_Pasantia_Larga.getIdPeriodoPasantiaLarga()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Periodo_Pasantia_Larga.getPeriodoPasantiaLarga())) {
                p.setNombre(fF_Periodo_Pasantia_Larga.getPeriodoPasantiaLarga());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<PeriodoPasantiaLarga> dato = s.createQuery("from PeriodoPasantiaLarga ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_periodo_pasantia_larga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Periodo_Pasantia_Largas",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            PeriodoPasantiaLarga p = (PeriodoPasantiaLarga) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<PeriodoPasantiaLarga> dato = s.createQuery("from PeriodoPasantiaLarga ").list();
//            List<PeriodoPasantiaLarga> dato = (List<PeriodoPasantiaLarga>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<PasantiaLarga> guarda = s.createQuery("from PasantiaLarga where periodo= :var").setLong("var", p.getIdPeriodoPasantiaLarga()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el periodo si aún hay pasantías asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }

            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Trimestres(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Trimestres",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idTrimestre");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                Trimestre singular = (Trimestre) s.createQuery("from Trimestre where idTrimestre= :var").setLong("var", Long.parseLong(request.getParameter("idTrimestre"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<Trimestre> dato = s.createQuery("from Trimestre ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_trimestre(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Trimestres",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Trimestre fF_Trimestre = (F_Trimestre) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idTrimestre");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                Trimestre singular = (Trimestre) s.createQuery("from Trimestre where idTrimestre= :var").setLong("var", Long.parseLong(request.getParameter("idTrimestre"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            Trimestre p;
            boolean guarda = true;
            if (!fF_Trimestre.getIdTrimestre().equals("")) {                                        //CAMBIAR CLASES
                p = (Trimestre) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new Trimestre();
            }


//            p.setIdTrimestre(Long.parseLong(fF_Trimestre.getIdTrimestre()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Trimestre.getNombre())) {
                p.setNombre(fF_Trimestre.getNombre());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<Trimestre> dato = s.createQuery("from Trimestre ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_trimestre(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Trimestres",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            Trimestre p = (Trimestre) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<Trimestre> dato = s.createQuery("from Trimestre ").list();
//            List<Trimestre> dato = (List<Trimestre>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<Etapa> guarda = s.createQuery("from Etapa where trimestre= :var").setLong("var", p.getIdTrimestre()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el trimestre si aún hay etapas asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }


            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    public ActionForward A_Prep_Gestionar_Paises(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Paises",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
            }
            String parameter = request.getParameter("idPais");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                Pais singular = (Pais) s.createQuery("from Pais where idPais= :var").setLong("var", Long.parseLong(request.getParameter("idPais"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }
            List<Pais> dato = s.createQuery("from Pais ").list();                             //CAMBIAR LA TABLA

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_pais(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Paises",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Pais fF_Pais = (F_Pais) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            // request.getSession().removeAttribute("Singular");

            request.getSession().removeAttribute("Datos");
            String parameter = request.getParameter("idPais");               //CAMBIAR CLAVE
            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
                Pais singular = (Pais) s.createQuery("from Pais where idPais= :var").setLong("var", Long.parseLong(request.getParameter("idPais"))).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
            }







            Pais p;
            boolean guarda = true;
            if (!fF_Pais.getIdPais().equals("")) {                                        //CAMBIAR CLASES
                p = (Pais) request.getSession().getAttribute("Singular");
                guarda = false;
            } else {
                p = new Pais();
            }


//            p.setIdPais(Long.parseLong(fF_Pais.getIdPais()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Pais.getNombre())) {
                p.setNombre(fF_Pais.getNombre());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            List<Pais> dato = s.createQuery("from Pais ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_pais(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Paises",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
//            request.getSession().removeAttribute("Singular");
//            request.getSession().removeAttribute("Datos");
            Pais p = (Pais) request.getSession().getAttribute("Singular");                        //CAMBIAR CLASES
            request.getSession().removeAttribute("Singular");


            //List<Pais> dato = s.createQuery("from Pais ").list();
//            List<Pais> dato = (List<Pais>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<Ciudad> guarda = s.createQuery("from Ciudad where pais= :var").setLong("var", p.getIdPais()).list();
            if (!guarda.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar el país si aún hay ciudades asociadas al mismo");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }


            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }



















    public ActionForward A_Prep_Gestionar_Ciudades(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Ciudades",};                                   //CAMBIAR JSP
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            request.getSession().removeAttribute("Singular");
            request.getSession().removeAttribute("CiudadD");
            request.getSession().removeAttribute("L_Paises");
            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Agregar");
            String parametro = request.getParameter("Agregar");
            if (parametro != null) {
                request.getSession().setAttribute("Agregar", parametro);
                List<Pais> L_Paises = s.createQuery("from Pais").list();
                request.getSession().setAttribute("L_Paises", L_Paises);
            }
            String parameter = request.getParameter("idCiudad");                                   //CAMBIAR CLAVE Y VAINAS DE LA BD
            if (parameter != null && !parameter.equals("")) {                                                                //AQUI ABAJO
                Ciudad singular = (Ciudad) s.createQuery("from Ciudad where idCiudad= :var").setLong("var", Long.parseLong(parameter)).uniqueResult();
                request.getSession().setAttribute("Singular", singular);
                Pais CiudadD = (Pais) ((Ciudad) s.createQuery("from Ciudad where idCiudad= :var").setLong("var", Long.parseLong(request.getParameter("idCiudad"))).uniqueResult()).getPais();
                request.getSession().setAttribute("CiudadD", CiudadD);
                List<Pais> L_Paises = s.createQuery("from Pais").list();
                request.getSession().setAttribute("L_Paises", L_Paises);
            }
            List<Ciudad> predato = s.createQuery("from Ciudad ").list();                             //CAMBIAR LA TABLA
            Iterator it = predato.iterator();
            Ciudad iterado;


            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();
            while (it.hasNext()) {
                iterado = (Ciudad) it.next();
                Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_Prep_Gestionar_Ciudades.do?idCiudad=" + iterado.getIdCiudad() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td width=\"250px\"><center>" + iterado.getNombre() + "</center></td><td width=\"250px\"><center>" + iterado.getPais().getNombre() + "</center></td></tr>");
            }

            if (!Devolucion.isEmpty()) {
                request.getSession().setAttribute("Datos", Devolucion);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
            }


            //YA NO ES MI VAINA
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

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    public ActionForward A_insertar_ciudad(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Ciudades",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            //MI VAINA
            F_Ciudad fF_Ciudad = (F_Ciudad) form;                            //CAMBIAR CLASE


            request.getSession().removeAttribute("Agregar");
            request.getSession().removeAttribute("Datos");
//            String parameter = request.getParameter("idCiudad");               //CAMBIAR CLAVE
//            String parameter2 = request.getParameter("idCiudad");
//            if (parameter != null && !parameter.equals("")) {                   //CAMBIAR VAINAS DE LAS TABLAS AQUI ABAJO
//                Ciudad singular = (Ciudad) s.createQuery("from Ciudad where idCiudad= :var").setLong("var", Long.parseLong(request.getParameter("idCiudad"))).uniqueResult();
//                request.getSession().setAttribute("Singular", singular);
//            }







            Ciudad p;
            boolean guarda = true;
            if (!fF_Ciudad.getIdCiudad().equals("")) {                                        //CAMBIAR CLASES
                p = (Ciudad) s.createQuery("from Ciudad where idCiudad= :var").setLong("var", Long.parseLong(fF_Ciudad.getIdCiudad())).uniqueResult();
                guarda = false;
            } else {
                p = new Ciudad();
            }
            p.setPais((Pais) s.createQuery("from Pais where idPais= :var").setLong("var", Long.parseLong(fF_Ciudad.getPais())).uniqueResult());




//            p.setIdCiudad(Long.parseLong(fF_Ciudad.getIdCiudad()));



            //verifico nombre
            if (Pattern.matches(".+", fF_Ciudad.getCiudad())) {
                p.setNombre(fF_Ciudad.getCiudad());
            } else {
                request.setAttribute("msg", "Por Favor Inserte un Nombre Válido");
                return mapping.findForward(SALIDAS[salida]);
            }

            request.setAttribute("msg", "Modificación Exitosa");
            request.getSession().removeAttribute("Singular");
            if (guarda) {
                s.save(p);
            } else {
                s.update(p);
            }
            request.getSession().setAttribute("idCiudad", fF_Ciudad.getCiudad());
            List<Ciudad> dato = s.createQuery("from Ciudad ").list();

            if (!dato.isEmpty()) {
                request.getSession().setAttribute("Datos", dato);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
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



        request.getSession().removeAttribute("Singular");
        request.getSession().removeAttribute("Agregar");
        request.getSession().removeAttribute("Agregare");

        request.setAttribute("msg", "Modificación Exitosa");
        return mapping.findForward(SALIDAS[salida]);
    }

    public ActionForward A_eliminar_ciudad(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_Prep_Gestionar_Ciudades",};                                 //CAMBIAR PAGINA
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        if (!CohesionActor.checkActor(request, 32)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            request.getSession().removeAttribute("Agregar");
            request.getSession().removeAttribute("Datos");
            Ciudad p = (Ciudad) request.getSession().getAttribute("Singular");
            request.getSession().removeAttribute("Singular");
//               request.getSession().removeAttribute("Singular");


            //List<Ciudad> dato = s.createQuery("from Ciudad ").list();
//            List<Ciudad> dato = (List<Ciudad>) request.getSession().getAttribute("Datos");
//            dato.remove(p);
//
//            if (!dato.isEmpty()) {
//                request.getSession().setAttribute("Datos", dato);
//            } else {
//                request.getSession().removeAttribute("Datos");
//                request.setAttribute("msg",
//                        getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
//            }


            List<Empresa> guarda2 = s.createQuery("from Empresa where ciudad= :var").setLong("var", p.getIdCiudad()).list();
            if (!guarda2.isEmpty()) {
                request.setAttribute("msg", "Disculpe no puede eliminar la ciudad si aún hay empresas asociadas a la misma");
                try {
                    s.close();
                } catch (Exception ex2) {
                }
                return mapping.findForward(SALIDAS[salida]);
            }





            s.delete(p);

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


        request.setAttribute("msg", "Se elimino con éxito el registro");
        return mapping.findForward(SALIDAS[salida]);
    }





}
