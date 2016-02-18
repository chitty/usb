package jc2s.sistppg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
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
public class AccionesC_Consultar_Pasantia_Est extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_Consultar_Pasantia.
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
    public ActionForward A_prep_Consultar_Pasantia(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Consultar_Pasantia_Est", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
            if (!CohesionActor.checkActor(request, 4)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            //mi codigo

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