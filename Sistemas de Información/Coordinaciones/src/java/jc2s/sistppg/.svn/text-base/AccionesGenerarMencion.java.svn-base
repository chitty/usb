
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
import jc2s.sistppg.hibernate.Usuario;

/**
 *
 * @author chitty
 */
public class AccionesGenerarMencion  extends CohesionAction {

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
    public ActionForward A_GenerarMencion(ActionMapping mapping, ActionForm  form,
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
            
            if (estudiante != null) {

                F_Mencion f_mencion = (F_Mencion) form;
                String defensa = f_mencion.getFecha_propuesta();
                String mencion = f_mencion.getJustificacion();

                String carnet = (String)(estudiante.getUsbid());
                String nombre = (String)(estudiante.getNombre());
                String apellido = (String)(estudiante.getApellido());
                String carrera = (String) (estudiante.getCarrera().getNombre());
                String genero = (String) estudiante.getSexo();
                
                int ci   = estudiante.getCedula();
                
                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);

                String adj = "al";

                if (genero.equals("femenino"))
                    adj = "a la";


                /* PDF */
                try {
                    Document pdf = new Document(PageSize.LETTER);

                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", " inline; filename=cartaMencion.pdf");

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

                    Paragraph titulo = new Paragraph("RECONOCIMIENTO", font);
                    titulo.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(titulo);
                    pdf.add(blank);
                    pdf.add(blank);
                    pdf.add(blank);

                    Paragraph uno = new Paragraph("Quien suscribe, Profesor Kenyer Dominguez Coordinador de Cooperación Técnica"
                            + "y Desarrollo Social, hace constar que el Trabajo de Pasantía realizado por "
                            + adj +" Br. "+ apellido +", "+ nombre +" C.I. número "+ci+" y estudiante de la carrera "
                            + carrera +" ha sido evaluada en fecha "+defensa+" por un Jurado examinador conformado por la "
                            + "Profesora Tutor Académico, y el Profesor jurado quienes han determinado por unanimidad que"
                            + "dicho trabajo posee una calidad EXCEPCIONALMENTE BUENA, con base en los siguientes argumentos \""
                            +mencion+"\".", font);
                    pdf.add(uno);
                    pdf.add(blank);


                    Paragraph tres = new Paragraph("En razon de ello se emite el presente Reconocimiento en el Valle de Sartenejas, "
                            + "Baruta a los 4 días del mes de junio de 2011.");
                    pdf.add(tres);
                    pdf.add(blank);


                    Paragraph fin = new Paragraph("\n\n\n\n\nProfesor Kenyer Dominguez\n", font);
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

