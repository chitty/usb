package jc2s.sistppg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;


/**
 *
 */
public class AccionesC_Consultar_Proyectos extends CohesionAction {

/**
     * Called by Struts for the execution of action A_prep_consultar_proyectos.
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
    public ActionForward A_prep_consultar_proyectos(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consulta_proyectos", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor, coordinador_cctds, cordiacion_de_carrera
            if (!CohesionActor.checkActor(request, 11)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //micodigo

            Usuario user = (Usuario) request.getSession().getAttribute("usuario");

            List<EstudianteRealizaProyecto> proyectos = new LinkedList<EstudianteRealizaProyecto>();

            if (user.getUsbid().equals("coord-comp")){
                //VALOR CABLIAO
                long idCarrera = 2;
                // TODOS los proyectos, toca filtrarlos por carrera
                proyectos = s.createQuery("from EstudianteRealizaProyecto where estudiante IN (select idEstudiante from Estudiante where carrera= :var)").setLong("var", idCarrera).list();

            } else {
                List<Carrera> c = s.createQuery("from Carrera").list();
                request.setAttribute("L_Carreras", c);
                proyectos = s.createQuery("from EstudianteRealizaProyecto where estudiante IN (select idEstudiante from Estudiante)").list();
            }

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

/**
     * Called by Struts for the execution of action A_consultar_PG.
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
    public ActionForward A_consultar_PG(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consulta_pg", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors cordiacion_de_carrera, coordinador_cctds, profesor
        if (!CohesionActor.checkActor(request, 11)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //Mi Codigo

            //Añadido por Jorge pa asignar jurado

            String parjur = request.getParameter("idJurado");
            if(parjur!=null){request.setAttribute("idJurado", parjur);}


            //fin jorge


            List<Profesor> profe = (List<Profesor>) s.createQuery("from Profesor").list();
            List<Trimestre> trim = (List<Trimestre>) s.createQuery("from Trimestre").list();
            request.setAttribute("Profesor", profe);
            request.setAttribute("Trimestre", trim);

            List<EstudianteRealizaProyecto> proye = s.createQuery("from EstudianteRealizaProyecto").list();
            List<ProyectoDeGrado> lpg = s.createQuery("from ProyectoDeGrado").list();
            List<ProyectoDeGrado> lpg2 = new LinkedList<ProyectoDeGrado>();


            F_SinaiPG f_sinai = (F_SinaiPG) form;
            long tutor = f_sinai.getTutor();
            int ano = f_sinai.getAno();
            long trimestre = f_sinai.getTrimestre();

            if ( tutor!=-1 ){
                lpg = s.createQuery("from ProyectoDeGrado where profesor = '"+tutor+"'").list();
            }

            if ( ano != -1){
              lpg2 = s.createQuery("from ProyectoDeGrado where idProyectoDeGrado IN (Select proyecto_de_grado from Etapa where ano = '"+ano+"')").list();
              lpg.retainAll(lpg2);
            }

            if ( trimestre != -1){
              lpg2 = s.createQuery("from ProyectoDeGrado where idProyectoDeGrado IN (Select proyecto_de_grado from Etapa where trimestre = '"+trimestre+"')").list();
              lpg.retainAll(lpg2);
            }

            //Codigo de Jorge
            if(parjur!=null){
                List<ProyectoDeGrado> lpg3 = s.createQuery("from ProyectoDeGrado where proyecto IN (Select proyecto from JuradoProyecto where profesor = '"+parjur+"')").list();
                lpg.removeAll(lpg3);
            }
            //End Codigo de Jorge

            request.setAttribute("L_PGS", lpg);


            //Mi Codigo
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
     * Called by Struts for the execution of action A_mostrar_pg.
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
    public ActionForward A_mostrar_pg(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_pg", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors cordiacion_de_carrera, profesor, coordinador_cctds
        if (!CohesionActor.checkActor(request, 11)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            // Mi codigo
                String parjur = request.getParameter("idJurado");
            if(parjur!=null){request.setAttribute("idJurado", parjur);}
            String parjur2 = request.getParameter("idJuradoA");
            if(parjur2!=null){request.setAttribute("idJuradoA", parjur2);}
//            request.getSession().removeAttribute("Proyecto");
//            request.getSession().removeAttribute("Tutor");
//            request.getSession().removeAttribute("Area");
//            request.getSession().removeAttribute("JuradoProyecto");
//            request.getSession().removeAttribute("Etapa1");
//            request.getSession().removeAttribute("Trimestre1");
//            request.getSession().removeAttribute("Descripcion1");
//            request.getSession().removeAttribute("Etapa2");
//            request.getSession().removeAttribute("Trimestre2");
//            request.getSession().removeAttribute("Descripcion2");
//            request.getSession().removeAttribute("Etapa3");
//            request.getSession().removeAttribute("Trimestre3");


            Long key = Long.parseLong(request.getParameter("idProyectoDeGrado"));
            ProyectoDeGrado pg = (ProyectoDeGrado) s.createQuery("from ProyectoDeGrado as p join fetch p.profesor where idProyectoDeGrado= :var").setLong("var", key).uniqueResult();
            if(parjur!=null){request.setAttribute("idProyectoDeGrado", pg.getIdProyectoDeGrado());}
            List<AreaProyectoDeGrado> apg = s.createQuery("from AreaProyectoDeGrado where proyecto_de_grado= :var").setLong("var", key).list();
            List<Etapa> etapas = s.createQuery("from Etapa where proyecto_de_grado= :var").setLong("var", key).list();
//            List<JuradoProyecto> jurados = s.createQuery("from JuradoProyecto where proyecto= :var").setLong("var", key).list();





//            request.setAttribute("Proyecto", pg);
//            request.setAttribute("Tutor", pg.getProfesor());

            String[] res = new String[apg.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = apg.get(i).getArea().getNombre();
            }


             List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();
            Devolucion.add("<tr><th width=\"200px\">Nombre</th><td>"+pg.getNombre()+"</td></tr><tr><th>Código</th><td>"+pg.getCodigo()+"</td></tr>");
            Devolucion.add("<tr><th>Recursos</th><td>"+pg.getRecursos()+"</td></tr><tr><th>Duración Recursos</th><td>"+pg.getDuracion_recursos()+"</td> </tr>");
           Devolucion.add("<tr><th>Puntos de Interés</th><td>"+pg.getPuntos_de_interes()+"</td></tr><tr><th>Áreas</th></tr>");

            Iterator itt=apg.iterator();
            while(itt.hasNext()){
                Devolucion.add("<tr> <td></td><td>"+itt.next()+"</td></tr>");
            }

            Devolucion.add("</table><p></p><hr><p></p><table width=\"500px\"><tr><th>Tutor Académico</th></tr></table><hr><p></p>");
            Devolucion.add("<table border=\"0\" width=\"500px\"><tr><th width=\"200px\">Nombre</th><td>"+pg.getProfesor().getNombre()+"</td></tr><tr><th>Apellido</th>");
            Devolucion.add("<td>"+pg.getProfesor().getApellido()+"</td></tr><tr><th>Email</th><td>"+pg.getProfesor().getEmail()+"</td></tr></table><p></p>");





            for (int i = 0; i < etapas.size(); i++) {

                List<PrimeraEtapa> etapa = s.createQuery("from PrimeraEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapa.isEmpty()) {
                    PrimeraEtapa indirecto = etapa.get(0);
                    Devolucion.add("<table width=\"500px\"><tr><th>Etapa1</th></tr></table><hr><p></p><p></p></table><table border=\"0\" width=\"500px\">");
                    Devolucion.add("<tr><th width=\"200px\">Nombre</th><td>"+indirecto.getEtapa().getNombre()+"</td></tr><tr><th>Resultados_Minimos</th><td>"+indirecto.getEtapa().getResultados_minimos()+"</td>");
                    Devolucion.add("</tr><tr><th>Trimestre</th><td>"+indirecto.getEtapa().getTrimestre().getNombre()+"</td></tr><tr><th>Año</th><td>"+indirecto.getEtapa().getAno()+"</td>");
                    Devolucion.add("</tr><tr><th>Descripcion</th><td>"+indirecto.getDescripcion_topicos()+"</td></tr></table><p></p><hr><p></p>");

                }


                List<SegundaEtapa> etapaa = s.createQuery("from SegundaEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapaa.isEmpty()) {
                    SegundaEtapa indirecto = etapaa.get(0);
                    Devolucion.add("<table width=\"500px\"><tr><th>Etapa2</th></tr></table><hr><p></p><p></p></table><table border=\"0\" width=\"500px\">");
                    Devolucion.add("<tr><th width=\"200px\">Nombre</th><td>"+indirecto.getEtapa().getNombre()+"</td></tr><tr><th>Resultados_Minimos</th><td>"+indirecto.getEtapa().getResultados_minimos()+"</td>");
                    Devolucion.add("</tr><tr><th>Trimestre</th><td>"+indirecto.getEtapa().getTrimestre().getNombre()+"</td></tr><tr><th>Año</th><td>"+indirecto.getEtapa().getAno()+"</td>");
                    Devolucion.add("</tr><tr><th>Descripcion</th><td>"+indirecto.getDescripcion_topicos()+"</td></tr></table> <p></p><hr><p></p>");

                }


                List<TerceraEtapa> etapaaa = s.createQuery("from TerceraEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapaaa.isEmpty()) {
                    TerceraEtapa indirecto = etapaaa.get(0);
                    Devolucion.add("<table width=\"500px\"><tr><th>Etapa3</th></tr></table><hr><p></p><p></p></table><table border=\"0\" width=\"500px\">");
                    Devolucion.add("<tr><th width=\"200px\">Nombre</th><td>"+indirecto.getEtapa().getNombre()+"</td></tr><tr><th>Resultados_Minimos</th><td>"+indirecto.getEtapa().getResultados_minimos()+"</td>");
                    Devolucion.add("</tr><tr><th>Trimestre</th><td>"+indirecto.getEtapa().getTrimestre().getNombre()+"</td></tr><tr><th>Año</th><td>"+indirecto.getEtapa().getAno()+"</td>");
                    Devolucion.add("</tr></table><br>");

                }
            }




            request.setAttribute("Datos", Devolucion);






//            String[] res2 = new String[jurados.size()*3];
//            int j = 0;
//            Iterator it = jurados.iterator();
//            while (it.hasNext()) {
//                Profesor pro = ((JuradoProyecto) it.next()).getProfesor();
//                res2[j] = pro.getNombre();
//                j++;
//                res2[j] = pro.getApellido();
//                j++;
//                res2[j] = pro.getEmail();
//
//            }


//            request.setAttribute("Area", res);
//            request.getSession().setAttribute("JuradoProyecto", jurados);



            //Mi codigo
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
     * Called by Struts for the execution of action A_consultar_pasantias.
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
    public ActionForward A_consultar_pasantias(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consulta_pasantia",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors coordinador_cctds, profesor, cordiacion_de_carrera
        if (!CohesionActor.checkActor(request, 11)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //micodigo

            //Añadido por Jorge pa asignar jurado

            String parjur = request.getParameter("idJurado");
            if(parjur!=null){request.setAttribute("idJurado", parjur);}


            //fin jorge

            Usuario user = (Usuario) request.getSession().getAttribute("usuario");


            List<Pasantia> pas = s.createQuery("from Pasantia").list();
            List<Pasantia> pas1 = new LinkedList<Pasantia>();
            List<Pasantia> pasDef = new LinkedList<Pasantia>();
            boolean tipoON = false;
            boolean hayCarrera = false;
            boolean hayPeriodo = false;
            long idCarrera;

            // Formulario recibido
            F_Sinai f_sinai = (F_Sinai) form;

            if (user.getUsbid().equals("coord-comp")){
                //VALOR CABLIAO
                idCarrera = 2;
                // TODOS los proyectos, toca filtrarlos por carrera
                pas1 = s.createQuery("from Pasantia where proyecto IN (select proyecto from EstudianteRealizaProyecto where estudiante IN (select idEstudiante from Estudiante where carrera= :var))").setLong("var", idCarrera).list();
                hayCarrera = true;
            } else {
                List<Carrera> career = s.createQuery("from Carrera").list();
                request.setAttribute("Carreras", career);
                idCarrera = f_sinai.getIdCarrera();
                if (idCarrera != -1) {
                    pas1 = s.createQuery("from Pasantia where proyecto IN (select proyecto from EstudianteRealizaProyecto where estudiante IN (select idEstudiante from Estudiante where carrera= :var))").setLong("var", idCarrera).list();
                    hayCarrera = true;
                }
            }

            List<PeriodoPasantiaLarga> ppl = (List<PeriodoPasantiaLarga>) s.createQuery("from PeriodoPasantiaLarga").list();
            List<PeriodoPasantiaIntermedia> ppi = (List<PeriodoPasantiaIntermedia>) s.createQuery("from PeriodoPasantiaIntermedia").list();
            request.setAttribute("L_PPL",ppl);
            request.setAttribute("L_PPI",ppi);

            List<EstatusPasantia> estatus = s.createQuery("from EstatusPasantia").list();
            request.setAttribute("Estatus", estatus);


            String tipo = f_sinai.getTipo();
            String periodo = f_sinai.getPeriodo();
            String query = new String();
            // Tipo de pasantía
            if (tipo.equals("larga")) {
                if (periodo.equals("-1")){
                    query = "from Pasantia where idPasantia IN (Select pasantia from PasantiaLarga)";
                } else {
                    query = "from Pasantia where idPasantia IN (Select pasantia from PasantiaLarga where periodo = '"+periodo+"')";
                }
                pas = s.createQuery(query).list();
                tipoON = true;
            } else if (tipo.equals("corta")) {
                query = "from Pasantia where idPasantia IN (Select pasantia from PasantiaCorta)";
                pas = s.createQuery(query).list();
                tipoON = true;
            } else if (tipo.equals("intermedia")) {
                if (periodo.equals("-1")){
                    query = "from Pasantia where idPasantia IN (Select pasantia from PasantiaIntermedia)";
                } else {
                    query = "from Pasantia where idPasantia IN (Select pasantia from PasantiaIntermedia where periodo = '"+periodo+"')";
                }
                pas = s.createQuery(query).list();
                tipoON = true;
            }

            // Intersección: Carrera-Tipo-Periodo
            if (hayCarrera)
                pas.retainAll(pas1);

            /************
             * CRITERIA *
             ************/
            long estatuss = f_sinai.getStatus();
            int ano = f_sinai.getAno();
            Criteria criteria = s.createCriteria(Pasantia.class);

            if (ano != -1){
                criteria.add(Expression.eq("ano",ano));
            }
            if ( estatuss != -1){
                criteria.createCriteria("estatus")
                        .add( Restrictions.eq("idEstatusPasantia", estatuss));
            }

            List<Pasantia> pas2 = criteria.list();

            pas.retainAll(pas2);

            //Codigo de Jorge
            if(parjur!=null){
                List<Pasantia> lpg3 = s.createQuery("from Pasantia where proyecto IN (Select proyecto from JuradoProyecto where profesor = '"+parjur+"')").list();
                pas.removeAll(lpg3);
            }
            //End Codigo de Jorge

            request.setAttribute("Pasantias", pas);

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

/**
     * Called by Struts for the execution of action A_mostrar_pasantia.
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
    public ActionForward A_mostrar_pasantia(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_pasantia", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors cordiacion_de_carrera, profesor, coordinador_cctds
        if (!CohesionActor.checkActor(request, 11)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
           //mi codigo
            String parjur = request.getParameter("idJurado");
            if(parjur!=null){request.setAttribute("idJurado", parjur);}
            String parjur2 = request.getParameter("idJuradoA");
            if(parjur2!=null){request.setAttribute("idJuradoA", parjur2);}
            String pas = request.getParameter("idPasantia");
            long idPasantia = Long.valueOf(pas).longValue();

            Pasantia pasantia = (Pasantia) s.createQuery("from Pasantia as p join fetch p.estatus join fetch p.proyecto join fetch p.tutor_academico join fetch p.tutor_industrial where idpasantia= :var").setLong("var", idPasantia).uniqueResult();
            request.setAttribute("Pasantia", pasantia);
            request.setAttribute("Estatus", pasantia.getEstatus());
            request.setAttribute("Profesor", pasantia.getTutor_academico());
            request.setAttribute("TutorIndustrial", pasantia.getTutor_industrial());
            request.setAttribute( "Ano", getDateTime( pasantia.getProyecto().getCreated_at() ) );

            // Tipo de Pasantía //
            PasantiaLarga larga = (PasantiaLarga) s.createQuery("from PasantiaLarga where pasantia= :var").setLong("var", idPasantia).uniqueResult();
            if (larga != null){
                PeriodoPasantiaLarga periodoL = (PeriodoPasantiaLarga) s.createQuery("from PeriodoPasantiaLarga where idPeriodoPasantiaLarga= :var").setLong("var", larga.getPeriodo().getId() ).uniqueResult();
                request.setAttribute("PasantiaLarga", larga);
                request.setAttribute("Periodo", periodoL);
            } else {
                PasantiaCorta corta = (PasantiaCorta) s.createQuery("from PasantiaCorta where pasantia= :var").setLong("var", idPasantia).uniqueResult();

                if (corta != null){
                    request.setAttribute("PasantiaCorta", corta);
                } else {
                    PasantiaIntermedia media = (PasantiaIntermedia) s.createQuery("from PasantiaIntermedia where pasantia= :var").setLong("var", idPasantia).uniqueResult();
                    request.setAttribute("PasantiaIntermedia", media);
                    // Por si acaso...
                    if( media != null ){
                        PeriodoPasantiaIntermedia periodoI = (PeriodoPasantiaIntermedia) s.createQuery("from PeriodoPasantiaIntermedia where idPeriodoPasantiaIntermedia= :var").setLong("var", media.getPeriodo().getId() ).uniqueResult();
                        request.setAttribute("Periodo", periodoI);
                    }
                }
            }

            // FASES
            List<Fase> fases = s.createQuery("from Fase as fase join fetch fase.actividades as actividades where fase.pasantia= :var").setLong("var", idPasantia ).list();
            request.setAttribute("Fases", fases);

            Iterator it = fases.iterator();
            Fase fase = new Fase();
            List<Fase> fases2 = new LinkedList<Fase>();

            while(it.hasNext()){
                fase = (Fase) it.next();
                if(!fases2.contains(fase))
                    fases2.add(fase);
            }

            request.setAttribute("Fases", fases2);

            //mi codigo
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        return mapping.findForward(SALIDAS[salida]);
    }

    private String getDateTime(Date fecha) {
       DateFormat dateFormat = new SimpleDateFormat("yyyy");
       Date date = fecha;
       return dateFormat.format(date);
   }


}