
package jc2s.sistppg;


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import ve.usb.cohesion.runtime.CohesionAction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.usb.cohesion.runtime.HibernateUtil;

import java.util.Calendar;

import jc2s.sistppg.hibernate.Estudiante;
import jc2s.sistppg.hibernate.Preinscripcion;
import jc2s.sistppg.hibernate.Usuario;

/**
 *
 * @author chitty
 */
public class AccionesGenerarCartaPostulacion  extends CohesionAction {

/**
     * Called by Struts for the execution of action A_GenerarCartaPostulacion.
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
    public ActionForward A_GenerarCartaPostulacion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_GenerarCartaPostulacion", "A_prep_gestionar_preinscripcion", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();

        try {

            /*mi codigo*/

            String path = getServlet().getServletContext().getRealPath("/")+ "../../img/";
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            Estudiante estudiante = (Estudiante) s.createQuery("from Estudiante where usbid = :login").setString("login", u.getUsbid()).uniqueResult();

            // Un estudiante SOLO puede tener UNA PreInscripcion
            Preinscripcion preinscripcion = (Preinscripcion) s.createQuery("from Preinscripcion where estudiante = :idEst order by created_at desc").setLong("idEst", estudiante.getIdEstudiante()).uniqueResult();

            if (preinscripcion != null) {


                String carnet = (String)(estudiante.getUsbid());
                String nombre = (String)(estudiante.getNombre());
                String apellido = (String)(estudiante.getApellido());
                String carrera = (String) (estudiante.getCarrera().getNombre());
                String genero = (String) estudiante.getSexo();
                int tipo =  preinscripcion.getTipo();

                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);

                String tipoPasantia = new String();
                String ep = new String();
                String creditos = new String();
                String duracion = new String();
                String periodo = new String();
                String adj = "al";

                if (genero.equals("femenino"))
                    adj = "a la";                

                if (tipo == 1){
                    tipoPasantia = "corta";
                    ep = "1420";
                    creditos = "3";
                    duracion = "06";
                    periodo = "Julio-Septiembre";
                } else if (tipo == 2){
                    tipoPasantia = "intermedia";
                    ep = "2420";
                    creditos = "6";
                    duracion = "12";

                    // Se asume que la carta es para el periodo
                    // inmediatamente posterior al actual!
                    if (month > 0 && month < 4) {
                        periodo = "Abril-Julio";
                    } else if (month >= 4 && month < 7) {
                        periodo = "Septiembre-Diciembre";
                    } else if (month >= 7 && month < 10) {
                        periodo = "Octubre-Febrero";
                    } else if (month >= 10 && month < 12) {
                        periodo = "Enero-Marzo";
                    }
                } else {
                    tipoPasantia = "larga";
                    ep = "3420";
                    creditos = "9";
                    duracion = "20";

                    // Se asume que la carta es para el periodo
                    // inmediatamente posterior al actual!
                    if (month > 0 && month < 4) {
                        periodo = "Abril-Septiembre";
                    } else if (month >= 4 && month < 7) {
                        periodo = "Julio-Diciembre";
                    } else if (month >= 7 && month < 10) {
                        periodo = "Octubre-Febrero";
                    } else if (month >= 10 && month < 12) {
                        periodo = "Enero-Mayo";
                    }
                }

            
                /* PDF */
                try {
                    Document pdf = new Document(PageSize.LETTER);

                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", " inline; filename=cartaPostulacion.pdf");

                    PdfWriter.getInstance(pdf, response.getOutputStream());

                    pdf.addTitle("Carta de Postulación - " );
                    pdf.open();

                    // Logo
                    Image logo = Image.getInstance(path +"logo.png");
                    logo.scaleToFit(197, 81);
                    logo.setAlignment(Image.ALIGN_LEFT);
                    pdf.add(logo);

                    // Pie
                    Image pie = Image.getInstance(path +"pie.png");
                    pie.scaleToFit(500, 216);
                    pie.setAbsolutePosition(40, 20);
                    pdf.add(pie);

                    Font font = FontFactory.getFont("Times New Roman", BaseFont.IDENTITY_H, 12);
                    Font bold = FontFactory.getFont("Times New Roman", BaseFont.IDENTITY_H, 12);
                    bold.setStyle(Font.BOLD);

                    Paragraph blank = new Paragraph("\n");
                    pdf.add(blank);
                    pdf.add(blank);
                    pdf.add(blank);

                    Paragraph titulo = new Paragraph("A QUIEN PUEDA INTERESAR", font);
                    titulo.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(titulo);
                    pdf.add(blank);
                    pdf.add(blank);
                    pdf.add(blank);

                    Paragraph uno = new Paragraph("Después de saludarle, me dirijo a Usted para presentarle "
                            + adj +" Br. "+ nombre +" "+ apellido +", estudiante de la carrera  de "
                            + carrera +", Carnet "+ carnet + ", a fin de que se le permita una entrevista para"
                            + " optar a la realización de su pasantía "+ tipoPasantia +" en la empresa,  "
                            + "correspondiente a la asignatura EP-"+ ep + ",  durante el período "+ periodo
                            + "  del año "+ year +", con una duración de ("+ duracion +") semanas que equivalen a ("
                            + creditos + ") créditos académicos.", font);
                    pdf.add(uno);
                    pdf.add(blank);

                    Paragraph dos = new Paragraph("La pasantía busca la familiarización  del estudiante  con la dinámica del sector "
                            + "productivo. Además le permitirá  su participación en tareas o proyectos previamente convenidos entre el "
                            + "tutor industrial y el tutor académico, y  la  aplicación de los conocimientos adquiridos en  sus estudios. ");
                    pdf.add(dos);
                    pdf.add(blank);

                    Paragraph tres = new Paragraph("Agradecemos de antemano la colaboración que pueda prestar a este bachiller en función de "
                            + "proporcionarle un proyecto  para su pasantía que pueda redundar en amplios beneficios tanto para su empresa "
                            + "como para el estudiante. De igual forma, la misma ayuda al desarrollo de nuestro Programa de Pasantías, el cual "
                            + "está  adscrito al Decanato de Extensión de esta casa de estudios.");
                    pdf.add(tres);
                    pdf.add(blank);

                    Paragraph cuatro = new Paragraph("Esperando contar siempre con su participación en el Programa de Pasantías de la U.S.B, le saluda.");
                    pdf.add(cuatro);
                    pdf.add(blank);

                    Paragraph fin = new Paragraph("Atentamente,\n\n\n\n\nProf. Kenyer Dominguez\n", font);
                    fin.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(fin);

                    Paragraph fin2 = new Paragraph("Coordinador de Cooperación Técnica y Desarrollo Social", bold);
                    fin2.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(fin2);

                    pdf.close();
                    /* PDF */

                } catch (Exception e) {
                    salida = SALIDA_1;
                }

            }else{
                salida = SALIDA_1;
            }

            /* Aqui termina mi codigo */
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_GenerarCartaPostulacion.msg0"));
        }
        if (salida==1) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_GenerarCartaPostulacion.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }


}
