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
import jc2s.sistppg.hibernate.Ciudad;
import jc2s.sistppg.hibernate.Estudiante;
import jc2s.sistppg.hibernate.Preinscripcion;
import jc2s.sistppg.hibernate.Usuario;

public class AccionesGenerarSolicitudPasantia extends CohesionAction {

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
    public ActionForward A_GenerarSolicitudPasantia(ActionMapping mapping, ActionForm  form,
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


            
            if (preinscripcion != null) {


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
                String region = "ninguna";

                String[] ciudades = donde.split(",");
                Ciudad c;
                for(int i=0;i<ciudades.length;i++){
                    c = (Ciudad) s.createQuery("from Ciudad c where c.idCiudad = :idc").setLong("idc", Long.parseLong(ciudades[i])).uniqueResult();
                    if (region.equals("ninguna"))
                        region = c.getNombre();
                    else if ( i+1<ciudades.length )
                        region = region +", "+c.getNombre();
                    else
                        region = region +" y "+c.getNombre();
                }

                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);

                String ep = new String();
                String periodo = new String();


                if (tipo == 1){
                    ep = "1420";
                    periodo = "Julio-Septiembre";
                } else if (tipo == 2){
                    ep = "2420";

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
                    ep = "3420";

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

                    // Foto
                    Image foto = Image.getInstance(path +"foto.png");
                    foto.scaleToFit(125, 168);
                    foto.setAlignment(Image.ALIGN_RIGHT | Image.TEXTWRAP);
                    pdf.add(foto);

                    Font font = FontFactory.getFont("Times New Roman", BaseFont.IDENTITY_H, 12);
                    font.setStyle(Font.BOLD);

                    Paragraph blank = new Paragraph("\n");
                    pdf.add(blank);

                    Paragraph titulo = new Paragraph("SOLICITUD DE PASANTIA", font);
                    titulo.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(titulo);

                    Chunk space = new Chunk(' ');
                    Chunk epBold = new Chunk("\nEP: ", font);
                    Chunk epAns = new Chunk(" "+ep+" ");
                    Chunk periodBold = new Chunk("PERÍODO: ", font);
                    Chunk periodAns = new Chunk(" "+periodo+" ");
                    Chunk anoBold = new Chunk("AÑO: ", font);
                    Chunk anoAns = new Chunk(" "+year+" ");
                    pdf.add(epBold);
                    pdf.add(epAns);
                    for( int i=0; i<5; i++)
                        pdf.add(space);
                    pdf.add(periodBold);
                    pdf.add(periodAns);
                    for( int i=0; i<5; i++)
                        pdf.add(space);
                    pdf.add(anoBold);
                    pdf.add(anoAns);

                    Phrase dPersonales = new Phrase("\n\nDATOS PERSONALES", font);
                    pdf.add(dPersonales);

                    PdfPTable datosP = new PdfPTable(1);
                    PdfPCell cell = new PdfPCell(new Paragraph("CARNET: " +carnet));
                    cell.setMinimumHeight(30f);
                    datosP.addCell(cell);

                    cell = new PdfPCell(new Paragraph("CARRERA: "+ carrera ));
                    cell.setMinimumHeight(30f);
                    datosP.addCell(cell);

                    cell = new PdfPCell(new Paragraph("ÍNDICE ACADÉMICO: "+indice));
                    cell.setMinimumHeight(30f);
                    datosP.addCell(cell);

                    datosP.setWidthPercentage(75);
                    datosP.setHorizontalAlignment(Element.ALIGN_LEFT);
                    pdf.add(datosP);
                    pdf.add(blank);
                    pdf.add(blank);

                    String bloque;
                    if (graduando) {
                        bloque = "BLOQUE A (Me graduo con la pasantía)";
                    } else {
                        bloque = "BLOQUE B (No me graduo con la pasantía)";
                    }

                    float[] widths = { 5f, 4f, 5f };
                    PdfPTable t = new PdfPTable(widths);
                    t.addCell("APELLIDOS: "+apellido);  t.addCell("NOMBRE: "+nombre); t.addCell("C.I.: "+cedula);
                    t.addCell("EDAD: "+calcularEdad(fn));     t.addCell("SEXO: "+genero);    t.addCell("NACIONALIDAD: "+nacionalidad);
                    t.addCell("EDO CIVIL: "+edocivil); t.addCell("TELEFONO(HAB): "+tlf); t.addCell("OTROS TELEFONOS: ");
                    t.addCell(bloque);     t.addCell("E-MAIL: "+correo);      t.addCell("DIRECCIÓN: "+direccion);
                    t.setHorizontalAlignment(Element.ALIGN_LEFT);
                    pdf.add(t);
                    pdf.add(blank);

                    Paragraph deseo;
                    if (tramite) {
                        deseo = new Paragraph("Deseo que la Coordinación de Cooperación Técnica y Desarrollo Social tramite el "
                                + "Proceso de Búsqueda de Pasantía en la Empresa\nEstoy dispuesto(a) a ir a la región: "
                                + region);
                    } else {
                        deseo = new Paragraph("No Deseo que la Coordinación de Cooperación Técnica y Desarrollo Social tramite el Proceso de Búsqueda de Pasantía en la Empresa\n\n");
                    }

                    pdf.add(deseo);

                    Paragraph firma = new Paragraph("\n\n\n\n_________________\nFIRMA ");
                    firma.setAlignment(Paragraph.ALIGN_CENTER);
                    pdf.add(firma);

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
            getResources(request).getMessage("A_GenerarCartaPostulacion.msg1"));
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