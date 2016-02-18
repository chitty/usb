package jc2s.sistppg;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import jc2s.sistppg.hibernate.Ciudad;
import jc2s.sistppg.hibernate.Estudiante;
import jc2s.sistppg.hibernate.Preinscripcion;
import jc2s.sistppg.hibernate.Prorroga;
import jc2s.sistppg.hibernate.Usuario;

public class AccionesGenerarProrrogaInscripcion extends CohesionAction {

/**
     * Called by Struts for the execution of action A_GenerarSolicitudPasantia.
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
    public ActionForward A_GenerarProrrogaInscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_GenerarCartaPostulacion", "A_prep_solicitar_prorroga_inscripcion", };
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();

        try {

            /*mi codigo*/

            String path = getServlet().getServletContext().getRealPath("/") + "../../img/";
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            Estudiante estudiante = (Estudiante) s.createQuery("from Estudiante where usbid = :login").setString("login", u.getUsbid()).uniqueResult();
            Preinscripcion preinscripcion = new Preinscripcion();

            // Consulta de la CCTDS
            if (estudiante == null){
                String parametro = (String) request.getParameter("preId");
                long preId = Long.parseLong(parametro);
                preinscripcion = (Preinscripcion) s.createQuery("from Preinscripcion where idPreinscripcion = :id").setLong("id", preId).uniqueResult();
                estudiante = preinscripcion.getEstudiante();

            // Consulta del propio estudiante
            } else {
                // Un estudiante SOLO puede tener UNA PreInscripcion
                preinscripcion = (Preinscripcion) s.createQuery("from Preinscripcion where estudiante = :idEst order by created_at desc").setLong("idEst", estudiante.getIdEstudiante()).uniqueResult();
            }

            List<Prorroga> prorrogas = (List<Prorroga>) s.createQuery("from Prorroga where estudiante = :idEst and idProrroga IN (Select prorroga from ProrrogaInscripcion)").setLong("idEst", estudiante.getIdEstudiante()).list();
            Prorroga pro = null;
            if (!prorrogas.isEmpty())
                pro = prorrogas.get(0);

            if (preinscripcion != null && pro != null) {


                String carnet = (String) estudiante.getUsbid();
                String nombre = (String) estudiante.getNombre();
                String apellido = (String) estudiante.getApellido();
                String carrera = (String) estudiante.getCarrera().getNombre();
                String nacionalidad = (String) estudiante.getNacionalidad();
                String genero = (String) estudiante.getSexo();
                String direccion = (String) estudiante.getDireccion();
                String correo = (String) estudiante.getEmail();
                String tlf = (String) estudiante.getTelefono();
                String edocivil = (String) estudiante.getEdocivil();
                Date fn = (Date) estudiante.getFecha_nacimiento();
                double indice = estudiante.getIndice();
                int tipo =  preinscripcion.getTipo();
                int cedula = estudiante.getCedula();
                boolean graduando = preinscripcion.getPor_graduar();
                boolean tramite = preinscripcion.getTramitecctds();
                String donde = preinscripcion.getRegiones();
                String just = pro.getJustificacion();



                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);

                String ep = new String();
                String periodo = new String();


                if (tipo == 1){
                    ep = "CORTA (EP-1420)";
                    periodo = "Julio-Septiembre";
                } else if (tipo == 2){
                    ep = "INTERMEDIA (EP-2420)";

                    // Se asume que la prorroga es para el periodo
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
                    ep = "LARGA (EP-3420)";

                    // Se asume que la prorroga es para el periodo
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

                    pdf.addTitle("Solicitud de Pasantía - " );
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
                    font.setStyle(Font.BOLD);

                    Paragraph blank = new Paragraph("\n");
                    pdf.add(blank);

                    Paragraph titulo = new Paragraph("PERMISO PARA PASANTÍA", font);
                    titulo.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(titulo);

                    Chunk space = new Chunk(' ');
                    Chunk epBold = new Chunk("\nCoordinación de " + carrera, font);
                    Chunk otro = new Chunk("\n\nNombre del estudiante: "+nombre+" "+apellido+" Carnet: "+carnet+"\n\nINSCRIPCIÓN EXTEMPORANEA");
                    pdf.add(epBold);
                    pdf.add(otro);

                    Paragraph fila1 = new Paragraph("PASANTÍA\n\n"+ep+"\n\nPERIODO: "+periodo+" "+year);
                    PdfPTable datosP = new PdfPTable(3);
                    PdfPCell cell = new PdfPCell( fila1 );
                    cell.setMinimumHeight(80f);
                    cell.setColspan(3);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    datosP.addCell(cell);

                    cell = new PdfPCell(new Paragraph("Justificación:\n"+just ));
                    cell.setMinimumHeight(80f);
                    cell.setColspan(3);
                    datosP.addCell(cell);

                    cell = new PdfPCell(new Paragraph("Observaciones CCTDS: \n\n____________________________________________________________________________________________________"));
                    cell.setMinimumHeight(100f);
                    datosP.addCell(cell);
                    cell = new PdfPCell (new Paragraph ("\n\n\n\n\nVo Bo. Firma y sello de Coordinación de Carrera\nFecha:"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    datosP.addCell(cell);
                    cell = new PdfPCell (new Paragraph ("\n\n\n\n\nFirma del Coordinador de CCTDS\nFecha:"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    datosP.addCell(cell);

                    datosP.setWidthPercentage(80);
                    datosP.setHorizontalAlignment(Element.ALIGN_LEFT);
                    pdf.add(datosP);


                    pdf.close();
                    /* PDF */

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else {
                salida = 1;
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
            getResources(request).getMessage("A_GenerarProrroga.msg1"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }

    private int calcularEdad(Date fechaNacimiento){

        Calendar fn = new GregorianCalendar();
        Calendar hoy = new GregorianCalendar();
        int edad = 0;
        int factor = 0;

        Date currentDate = new Date();
        fn.setTime(fechaNacimiento);
        hoy.setTime(currentDate);
        if (hoy.get(Calendar.MONTH) <= fn.get(Calendar.MONTH)) {
            if (hoy.get(Calendar.MONTH) == fn.get(Calendar.MONTH)) {
                if (hoy.get(Calendar.DATE) > fn.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaños
            }
        }
        edad = (hoy.get(Calendar.YEAR) - fn.get(Calendar.YEAR)) + factor;
        return edad;
    }

}
