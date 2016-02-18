package jc2s.sistppg;

import java.math.BigInteger;
import java.util.Iterator;
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
public class AccionesC_Gestionar_Jurados extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_Prep_Gestionar_Jurados.
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
    public ActionForward A_Prep_Gestionar_Jurados(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Jurados",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 2)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
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
     * Called by Struts for the execution of action A_consultar_jurado.
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
    public ActionForward A_consultar_jurado(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consultar_jurados",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 2)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {

            request.getSession().removeAttribute("Datos");

            List<Area> L_Areas = s.createQuery("from Area").list();
            request.getSession().setAttribute("L_Areas", L_Areas);
            List<Departamento> L_Departamentos = s.createQuery("from Departamento").list();
            request.getSession().setAttribute("L_Departamentos", L_Departamentos);
            List<Trimestre> L_Trimestres = s.createQuery("from Trimestre").list();
            request.getSession().setAttribute("L_Trimestres", L_Trimestres);
            List<PeriodoPasantiaIntermedia> L_PeriodosPasantiaIntermedia = s.createQuery("from PeriodoPasantiaIntermedia").list();
            request.getSession().setAttribute("L_PeriodosPasantiaIntermedia", L_PeriodosPasantiaIntermedia);
            List<PeriodoPasantiaLarga> L_PeriodosPasantiaLarga = s.createQuery("from PeriodoPasantiaLarga").list();
            request.getSession().setAttribute("L_PeriodosPasantiaLarga", L_PeriodosPasantiaLarga);

            String query = "";

            //Se hace el filtro por nombre, apellido, cedula y departamento
            F_Jurado forma = (F_Jurado) form;
            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();
            if (!forma.getDepartamento().equals("")) {
                query = "AND departamento = '" + forma.getDepartamento() + "'";
            }
            List<Profesor> profesores = s.createQuery("from Profesor where (cedula LIKE '%" + forma.getTexto() + "%' OR nombre LIKE '%" + forma.getTexto() + "%' OR apellido LIKE '%" + forma.getTexto() + "%')" + query).list();
            List<Profesor> profesores1 = s.createQuery("from Profesor where cedula = '-18'").list();

            List<Profesor> profesores2 = s.createQuery("from Profesor where cedula = '-18'").list();

            Iterator iterador;



            //Se hace el filtro por Periodo
            if (!forma.getPeriodo().equals("")) {
                List<String> periodos0 = s.createSQLQuery("select idTrimestre from trimestre where nombre = '" + forma.getPeriodo() + "'").list();
                if (!periodos0.isEmpty()) {

                    Iterator itp0 = periodos0.iterator();



                    List<String> proyectos00 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                    while (itp0.hasNext()) {
                        proyectos00.addAll(s.createSQLQuery("select proyecto_de_grado from etapa where trimestre = '" + itp0.next() + "'").list());
                    }
                   


                    itp0 = itp0 = proyectos00.iterator();

                    List<String> proyectos0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                    while (itp0.hasNext()) {
                        proyectos0.addAll(s.createSQLQuery("select proyecto from proyectoDeGrado where idProyectoDeGrado = '" + itp0.next() + "'").list());
                    }
                    
                    List<String> profesores0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                    itp0 = proyectos0.iterator();
                    while (itp0.hasNext()) {
                        profesores0.addAll(s.createSQLQuery("select profesor from juradoProyecto where proyecto = '" + itp0.next() + "'").list());
                    }
                    itp0 = profesores.iterator();

                    while (itp0.hasNext()) {
                        Profesor iterado = (Profesor) itp0.next();
                        if (profesores0.contains(BigInteger.valueOf(iterado.getIdProfesor()))) {
                            profesores1.add(iterado);
                        }
                    }

                    
//                    List<String> periodos1 = s.createSQLQuery("select idPeriodoPasantiaIntermedia from PeriodoPasantiaIntermedia where nombre = '" + forma.getPeriodo() + "'").list();
//                    List<String> periodos2 = s.createSQLQuery("select idPeriodoPasantiaLarga from PeriodoPasantiaLarga where nombre = '" + forma.getPeriodo() + "'").list();

                } else {
                    periodos0 = s.createSQLQuery("select idPeriodoPasantiaIntermedia from periodoPasantiaIntermedia where nombre = '" + forma.getPeriodo() + "'").list();
                    if (!periodos0.isEmpty()) {

                        Iterator itp0 = periodos0.iterator();
                        List<String> proyectos0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                        while (itp0.hasNext()) {
                            proyectos0.addAll(s.createSQLQuery("select pasantia from pasantiaIntermedia where periodo = '" + itp0.next() + "'").list());
                        }

                        
                        List<String> pasantias0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                        itp0 = proyectos0.iterator();
                        while (itp0.hasNext()) {
                            pasantias0.addAll(s.createSQLQuery("select proyecto from Pasantia where idPasantia = '" + itp0.next() + "'").list());
                        }



                       
                        List<String> profesores0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                        itp0 = pasantias0.iterator();
                        while (itp0.hasNext()) {
                            profesores0.addAll(s.createSQLQuery("select profesor from juradoProyecto where proyecto = '" + itp0.next() + "'").list());
                        }
                        itp0 = profesores.iterator();

                        while (itp0.hasNext()) {
                            Profesor iterado = (Profesor) itp0.next();
                            if (profesores0.contains(BigInteger.valueOf(iterado.getIdProfesor()))) {
                                profesores1.add(iterado);
                            }
                        }

                        

                    } else {
                        periodos0 = s.createSQLQuery("select idPeriodoPasantiaLarga from periodoPasantiaLarga where nombre = '" + forma.getPeriodo() + "'").list();
                        if (!periodos0.isEmpty()) {

                            Iterator itp0 = periodos0.iterator();
                            List<String> proyectos0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                            while (itp0.hasNext()) {
                                proyectos0.addAll(s.createSQLQuery("select pasantia from pasantiaLarga where periodo = '" + itp0.next() + "'").list());
                            }

                            
                            List<String> pasantias0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                            itp0 = proyectos0.iterator();
                            while (itp0.hasNext()) {
                                pasantias0.addAll(s.createSQLQuery("select proyecto from Pasantia where idPasantia = '" + itp0.next() + "'").list());
                            }



                            
                            List<String> profesores0 = s.createQuery("select nombre from Profesor where cedula = '-18'").list();
                            itp0 = pasantias0.iterator();
                            while (itp0.hasNext()) {
                                profesores0.addAll(s.createSQLQuery("select profesor from juradoProyecto where proyecto = '" + itp0.next() + "'").list());
                            }
                            itp0 = profesores.iterator();

                            while (itp0.hasNext()) {
                                Profesor iterado = (Profesor) itp0.next();
                                if (profesores0.contains(BigInteger.valueOf(iterado.getIdProfesor()))) {
                                    profesores1.add(iterado);
                                }
                            }

                            

                        }
                    }
                }
            } else {
                profesores1 = profesores;
            }




            //Se hace el filtro por area del profesor
            if (!forma.getArea().equals("")) {
                List<String> ap = s.createSQLQuery("select profesor from areaProfesor where area = '" + forma.getArea() + "'").list();

                iterador = profesores1.iterator();
                while (iterador.hasNext()) {
                    Profesor iterado = (Profesor) iterador.next();
                    if (ap.contains(BigInteger.valueOf(iterado.getIdProfesor()))) {
                        profesores2.add(iterado);
                    }
                }

            } else {
                profesores2 = profesores1;
            }










            iterador = profesores2.iterator();
            while (iterador.hasNext()) {
                Profesor iterado = (Profesor) iterador.next();
                Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_jurado.do?idJurado=" + iterado.getIdProfesor() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getNombre() + "</center></td><td><center>" + iterado.getApellido() + "</center></td>");
                Devolucion.add("<td><center>" + iterado.getDepartamento().getNombre() + "</center></td><td><center>" + ((List<String>) s.createSQLQuery("select proyecto from juradoProyecto where profesor =" + iterado.getIdProfesor()).list()).size() + "</center></td></tr>");
            }

            if (!Devolucion.isEmpty()) {
                request.getSession().setAttribute("Datos", Devolucion);
            } else {
                request.setAttribute("msg",
                        getResources(request).getMessage("A_Prep_Consultar_Jurados.msg0"));
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
        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_mostrar_jurado.
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
    public ActionForward A_mostrar_jurado(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_jurado",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 2)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {



            request.getSession().removeAttribute("Datos");
            request.getSession().removeAttribute("Datos2");

            String parameter = request.getParameter("idJurado");
            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();

            if (parameter != null && !parameter.equals("")) {
                Profesor profesor = (Profesor) s.createQuery("from Profesor where idProfesor= :var").setLong("var", Long.parseLong(parameter)).uniqueResult();
                Devolucion.add("<table><thead><tr><th width=\"250px\"><h3 align=\"right\">Nombre: </h3></th><th width=\"250px\" align=\"left\">" + profesor.getNombre() + "</th></tr>");
                Devolucion.add("<tr><th><h3 align=\"right\">Apellido: </h3></th><th align=\"left\">" + profesor.getApellido() + "</th></tr><tr><th><h3 align=\"right\">Cédula: </h3></th><th align=\"left\">" + profesor.getCedula());
                Devolucion.add("</th></tr><tr><th><h3 align=\"right\">USBId: </h3></th><th align=\"left\">" + profesor.getUsbid() + "</th></tr><tr><th><h3 align=\"right\">Contacto: </h3></th><th align=\"left\">" + profesor.getEmail());
                Devolucion.add("</th></tr><tr><th><h3 align=\"right\">Departamento: </h3></th><th align=\"left\">" + profesor.getDepartamento().getNombre() + "</th></tr>");
                Devolucion.add("<tr><th><h3 align=\"right\">Areas: </h3></th>");
                List<String> areaProfesor = s.createSQLQuery("select area from areaProfesor where profesor= :var").setLong("var", profesor.getIdProfesor()).list();
                Iterator it = areaProfesor.iterator();
                String query = "";
                while (it.hasNext()) {
                    if (!query.equals("")) {
                        query = query + " OR";
                    }
                    query = query + " idArea = '" + it.next() + "'";
                }
                if (!query.equals("")) {
                    List<Area> areas = s.createQuery("from Area where " + query).list();
                    it = areas.iterator();
                    while (it.hasNext()) {
                        Devolucion.add("<th align=\"left\">" + ((Area) it.next()).getNombre() + "</th></tr><tr><th></th>");
                    }
                }

                if (!Devolucion.isEmpty()) {
                    Devolucion.add("<th></th></tr></thead></table>");
                
                    request.getSession().setAttribute("Datos", Devolucion);
                } else {
                    request.setAttribute("msg",
                            getResources(request).getMessage("A_Prep_Inicio_Sesion_Adm.msg0"));
                }


                List<String> Devolucion2 = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();

                List<String> proyectos = s.createSQLQuery("select proyecto from juradoProyecto where profesor = '"+profesor.getIdProfesor()+"'").list();
                it = proyectos.iterator();
                query = "";
                while (it.hasNext()) {
                    if (!query.equals("")) {
                        query = query + " OR";
                    }
                    query = query + " proyecto= '" + it.next() + "'";
                }
                if (!query.equals("")) {
//                    System.out.println("----------------------------------------from Pasantia where "+query);
                    List<Pasantia> pasantias = s.createQuery("from Pasantia where " + query).list();
//                    System.out.println("----------------------------------------from Pasantia where "+query);
                    
                    it = pasantias.iterator();
                    while (it.hasNext()) {
                        Pasantia pasantia= (Pasantia)it.next();
                        Devolucion2.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia.do?idPasantia=" + pasantia.getIdPasantia() + "&idJurado="+profesor.getIdProfesor()+"'\" onmouseover=\"this.style.cursor='pointer'\">     <td align=\"center\">" + pasantia.getTitulo() + "</td></tr>");
                    }
                }


                if (!query.equals("")) {
                    List<ProyectoDeGrado> pgs = s.createQuery("from ProyectoDeGrado where " + query).list();
                    it = pgs.iterator();
                    while (it.hasNext()) {
                        ProyectoDeGrado pg = (ProyectoDeGrado)it.next();
                        Devolucion2.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pg.do?idProyectoDeGrado=" + pg.getIdProyectoDeGrado() + "&idJurado="+profesor.getIdProfesor()+"'\" onmouseover=\"this.style.cursor='pointer'\">     <td align=\"center\">" + pg.getNombre() + "</td></tr>");
                    }
                }

                if (!Devolucion2.isEmpty()) {

                    request.getSession().setAttribute("Datos2", Devolucion2);
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
        return mapping.findForward(SALIDAS[salida]);
    }




    public ActionForward A_remover_jurado(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Jurados",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 2)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            String idJurado = request.getParameter("idJurado");
            String idPasantia = request.getParameter("idPasantia");
            String idProyectoDeGrado = request.getParameter("idProyectoDeGrado");

            if(idPasantia!=null){
                Pasantia proyecto = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(idPasantia)).uniqueResult();
                JuradoProyecto jp = (JuradoProyecto) s.createQuery("from JuradoProyecto where proyecto= :var AND profesor= :vbr").setLong("var", proyecto.getProyecto().getId_proyecto()).setLong("vbr",Long.parseLong(idJurado)).uniqueResult();
                s.delete(jp);
            }else{
                ProyectoDeGrado proyecto = (ProyectoDeGrado) s.createQuery("from ProyectoDeGrado where idProyectoDeGrado= :var").setLong("var", Long.parseLong(idProyectoDeGrado)).uniqueResult();
                JuradoProyecto jp = (JuradoProyecto) s.createQuery("from JuradoProyecto where proyecto= :var AND profesor= :vbr").setLong("var", proyecto.getProyecto().getId_proyecto()).setLong("vbr",Long.parseLong(idJurado)).uniqueResult();
                s.delete(jp);
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
        return mapping.findForward(SALIDAS[salida]);
    }


    public ActionForward A_asignar_jurado(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Gestionar_Jurados",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 2)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            String idJurado = request.getParameter("idJurado");
            String idPasantia = request.getParameter("idPasantia");
            String idProyectoDeGrado = request.getParameter("idProyectoDeGrado");

            if(idPasantia!=null){
                Pasantia p = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(idPasantia)).uniqueResult();
                Profesor pp = (Profesor) s.createQuery("from Profesor where idProfesor= :var").setLong("var", Long.parseLong(idJurado)).uniqueResult();

                JuradoProyecto jp = new JuradoProyecto();
                jp.setProfesor(pp);
                jp.setProyecto(p.getProyecto());
                s.save(jp);
            }else{
                ProyectoDeGrado p = (ProyectoDeGrado) s.createQuery("from ProyectoDeGrado where idProyectoDeGrado= :var").setLong("var", Long.parseLong(idProyectoDeGrado)).uniqueResult();
                Profesor pp = (Profesor) s.createQuery("from Profesor where idProfesor= :var").setLong("var", Long.parseLong(idJurado)).uniqueResult();

                JuradoProyecto jp = new JuradoProyecto();
                jp.setProfesor(pp);
                jp.setProyecto(p.getProyecto());
                s.save(jp);
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
        return mapping.findForward(SALIDAS[salida]);
    }

}
