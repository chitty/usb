package jc2s.sistppg;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
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
public class AccionesC_Consultar_PG_Est extends CohesionAction {

    /**
     * Called by Struts for the execution of action A_prep_Consultar_PG.
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
    public ActionForward A_prep_Consultar_PG(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_Consultar_PG",};
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors estudiante
        if (!CohesionActor.checkActor(request, 4)) {
            return mapping.findForward(CohesionActor.SALIDA_ACTOR);
        }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {



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
            ProyectoDeGrado pg = (ProyectoDeGrado) s.createQuery("from ProyectoDeGrado where idProyectoDeGrado= :var").setLong("var", key).uniqueResult();
            List<AreaProyectoDeGrado> apg = s.createQuery("from AreaProyectoDeGrado where proyecto_de_grado= :var").setLong("var", key).list();
            List<Etapa> etapas = s.createQuery("from Etapa where proyecto_de_grado= :var").setLong("var", key).list();
//            List<JuradoProyecto> jurados = s.createQuery("from JuradoProyecto where proyecto= :var").setLong("var", key).list();


            request.getSession().setAttribute("Proyecto", pg);
            request.getSession().setAttribute("Tutor", pg.getProfesor());

            String[] res = new String[apg.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = apg.get(i).getArea().getNombre();
            }


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


            request.getSession().setAttribute("Area", res);
//            request.getSession().setAttribute("JuradoProyecto", jurados);


            for (int i = 0; i < etapas.size(); i++) {

                List<PrimeraEtapa> etapa = s.createQuery("from PrimeraEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapa.isEmpty()) {
                    PrimeraEtapa indirecto = etapa.get(0);
                    request.getSession().setAttribute("Etapa1", indirecto.getEtapa());
                    request.getSession().setAttribute("Trimestre1", indirecto.getEtapa().getTrimestre().getNombre());
                    request.getSession().setAttribute("Descripcion1", indirecto.getDescripcion_topicos());

                }


                List<SegundaEtapa> etapaa = s.createQuery("from SegundaEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapaa.isEmpty()) {
                    SegundaEtapa indirecto = etapaa.get(0);
                    request.getSession().setAttribute("Etapa2", indirecto.getEtapa());
                    request.getSession().setAttribute("Trimestre2", indirecto.getEtapa().getTrimestre().getNombre());
                    request.getSession().setAttribute("Descripcion2", indirecto.getDescripcion_topicos());

                }


                List<TerceraEtapa> etapaaa = s.createQuery("from TerceraEtapa where etapa= :var").setLong("var", etapas.get(i).getIdEtapa()).list();
                if (!etapaaa.isEmpty()) {
                    TerceraEtapa indirecto = etapaaa.get(0);
                    request.getSession().setAttribute("Etapa3", indirecto.getEtapa());
                    request.getSession().setAttribute("Trimestre3", indirecto.getEtapa().getTrimestre().getNombre());
//                    request.getSession().setAttribute("Descripcion3", indirecto.getDescripcion_topicos());

                }
            }


            System.out.println(pg);
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
