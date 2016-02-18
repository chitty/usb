package jc2s.sistppg;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jc2s.sistppg.hibernate.Pasantia;
import jc2s.sistppg.hibernate.PasantiaCorta;
import jc2s.sistppg.hibernate.PasantiaIntermedia;
import jc2s.sistppg.hibernate.PasantiaLarga;
import jc2s.sistppg.hibernate.Profesor;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import ve.usb.cohesion.runtime.CohesionAction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.usb.cohesion.runtime.HibernateUtil;

/**
 * 
 */
public class AccionesC_Gestionar_Pasantia_Prof extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_prep_gestionar_pasantia_prof.
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
    public ActionForward A_prep_gestionar_pasantia_prof(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_pasantias_prof",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
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
     * Called by Struts for the execution of action A_consultar_pasantias_propias.
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
    public ActionForward A_consultar_pasantias_propias(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consulta_pasantia_propias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
        //Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //micodigo
            Profesor profe = (Profesor) request.getSession().getAttribute("profesor");

            List<Pasantia> pasCortas = s.createQuery("from Pasantia where tutor_academico= :var AND idPasantia IN (Select pasantia from PasantiaCorta)").setLong("var", profe.getIdProfesor()).list();
            List<Pasantia> pasIntermedias = s.createQuery("from Pasantia where tutor_academico= :var AND idPasantia IN (Select pasantia from PasantiaIntermedia)").setLong("var", profe.getIdProfesor()).list();
            List<Pasantia> pasLargas = s.createQuery("from Pasantia where tutor_academico= :var AND idPasantia IN (Select pasantia from PasantiaLarga)").setLong("var", profe.getIdProfesor()).list();
            //List<Pasantia> pasCortas2 = s.createQuery("from Pasantia where tutor_academico= :var").setLong("var", profe.getIdProfesor()).list();
//            pasCortas.retainAll(pasCortas2);

            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();
            Iterator it = pasCortas.iterator();
            Pasantia iterado;
            while (it.hasNext()) {
                iterado = (Pasantia) it.next();
                if (iterado.getEvaluacion_tutor_academico() != null && !iterado.getEvaluacion_tutor_academico().equals("")) {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Corta </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center>" + iterado.getEvaluacion_tutor_academico() + "</center></td></tr>");
                } else {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Corta </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center></center></td></tr>");
                }
            }
            it = pasIntermedias.iterator();
            while (it.hasNext()) {
                iterado = (Pasantia) it.next();
                if (iterado.getEvaluacion_tutor_academico() != null && !iterado.getEvaluacion_tutor_academico().equals("")) {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Intermedia </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center>" + iterado.getEvaluacion_tutor_academico() + "</center></td></tr>");
                } else {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Intermedia </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center></center></td></tr>");
                }
            }
            it = pasLargas.iterator();
            while (it.hasNext()) {
                iterado = (Pasantia) it.next();
                if (iterado.getEvaluacion_tutor_academico() != null && !iterado.getEvaluacion_tutor_academico().equals("")) {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Larga </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center>" + iterado.getEvaluacion_tutor_academico() + "</center></td></tr>");
                } else {
                    Devolucion.add("<tr onclick=\"location.href='/sistppg70/A_mostrar_pasantia_propia.do?idPasantia=" + iterado.getIdPasantia() + "'\" onmouseover=\"this.style.cursor='pointer'\">               <td><center>" + iterado.getTitulo() + "</center></td><td><center>" + iterado.getAno() + "</center></td><td><center> Pasantía Larga </center></td><td><center>" + iterado.getEstatus().getEstatus() + "</center></td><td><center></center></td></tr>");
                }
            }


            request.getSession().setAttribute("Datos", Devolucion);

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
        return mapping.findForward(SALIDAS[salida]);
    }

    /**
     * Called by Struts for the execution of action A_mostrar_pasantia_propia.
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
    public ActionForward A_mostrar_pasantia_propia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_pasantia_propia",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {

            String idPasantia = request.getParameter("idPasantia");
            Pasantia pasantia = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(idPasantia)).uniqueResult();
            List<String> Devolucion = s.createSQLQuery("select nombre from trimestre where nombre = 'nidevainaexisto'").list();

            Devolucion.add("<h2><center>" + pasantia.getTitulo() + "</center></h2><hr><table border=\"0\">  <tr><th align=\"right\">Resumen</th><td align=\"left\">" + pasantia.getResumen() + "</td></tr> <tr><th align=\"right\">Objetivos Generales</th><td align=\"left\">" + pasantia.getObjetivos_generales() + "</td></tr> <tr><th align=\"right\">Año</th><td align=\"left\">" + pasantia.getAno() + "</td></tr>   <tr><th align=\"right\">Estatus</th><td align=\"left\">" + pasantia.getEstatus().getEstatus() + "</td></tr>  <tr><th align=\"right\">Evaluación</th><td align=\"left\">" + pasantia.getEvaluacion_tutor_academico() + "</td></tr>  <tr><th align=\"right\">Tipo de Pasantía</th><td align=\"left\">");


            List<PasantiaCorta> consultor = s.createQuery("from PasantiaCorta where pasantia= :var").setLong("var", Long.parseLong(idPasantia)).list();
            if (!consultor.isEmpty()) {
                Devolucion.add("Pasantía Corta </td></tr>  </table> <center><a href=\"/sistppg70/A_prep_evaluacion_corta.do?idPasantia=" + idPasantia + "\">EVALUAR</a></center>");
            } else {
                List<PasantiaIntermedia> consultor2 = s.createQuery("from PasantiaIntermedia where pasantia= :var").setLong("var", Long.parseLong(idPasantia)).list();
                if (!consultor2.isEmpty()) {
                    Devolucion.add("Pasantía Intermedia </td>     </tr>  <tr><th align=\"right\">Periodo</th><td align=\"left\">" + consultor2.get(0).getPeriodo().getNombre() + "</td></tr>  </table> <center><a href=\"/sistppg70/A_prep_evaluacion_intermedia.do?idPasantia=" + idPasantia + "\">EVALUAR</a></center>");
                } else {
                    List<PasantiaLarga> consultor3 = s.createQuery("from PasantiaLarga where pasantia= :var").setLong("var", Long.parseLong(idPasantia)).list();
                    Devolucion.add("Pasantía Larga </td>    </tr> <tr><th align=\"right\">Periodo</th><td align=\"left\">" + consultor3.get(0).getPeriodo().getNombre() + "</td></tr>  </table> <center><a href=\"/sistppg70/A_prep_evaluacion_larga.do?idPasantia=" + idPasantia + "\">EVALUAR</a></center>");
                }
            }



            Devolucion.add("   </td></tr>  </table>");




            request.getSession().setAttribute("Datos", Devolucion);

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
     * Called by Struts for the execution of action A_prep_evaluacion.
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
    public ActionForward A_prep_evaluacion_corta(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_evaluacion_pasantia_corta",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
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

    public ActionForward A_prep_evaluacion_intermedia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_evaluacion_pasantia_intermedia",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
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

    public ActionForward A_prep_evaluacion_larga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_evaluacion_pasantia_larga",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
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


    public ActionForward A_evaluacion_corta(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_consultar_pasantias_propias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {

            F_evaluar_corta F = (F_evaluar_corta) form;
            Pasantia p = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(F.getIdPasantia())).uniqueResult();
            Long puntaje = Long.parseLong("0");
            Long respondidas = Long.parseLong("0");
            Long actual = Long.parseLong(F.getItem1());
            if (actual>0){
                puntaje=puntaje+actual;
                respondidas++;
            }
            actual = Long.parseLong(F.getItem2());
            if (actual>0){
                puntaje=puntaje+actual;
                respondidas++;
            }
            actual = Long.parseLong(F.getItem3());
            if (actual>0){
                puntaje=puntaje+actual;
                respondidas++;
            }
            actual = Long.parseLong(F.getItem4());
            if (actual>0){
                puntaje=puntaje+actual;
                respondidas++;
            }
            actual = Long.parseLong(F.getItem5());
            if (actual>0){
                puntaje=puntaje+actual;
                respondidas++;
            }
            p.setEvaluacion_tutor_academico(String.valueOf(puntaje/respondidas));
     
            s.update(p);


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

    public ActionForward A_evaluacion_intermedia(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_consultar_pasantias_propias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


            F_evaluar_intermedia_larga F = (F_evaluar_intermedia_larga) form;
            Pasantia p = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(F.getIdPasantia())).uniqueResult();
            p.setEvaluacion_tutor_academico(F.getEvaluacion());
            s.update(p);

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

    public ActionForward A_evaluacion_larga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_consultar_pasantias_propias",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors profesor
        if (!CohesionActor.checkActor(request, 8)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {


             F_evaluar_intermedia_larga F = (F_evaluar_intermedia_larga) form;
            Pasantia p = (Pasantia) s.createQuery("from Pasantia where idPasantia= :var").setLong("var", Long.parseLong(F.getIdPasantia())).uniqueResult();
            p.setEvaluacion_tutor_academico(F.getEvaluacion());
            s.update(p);
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
