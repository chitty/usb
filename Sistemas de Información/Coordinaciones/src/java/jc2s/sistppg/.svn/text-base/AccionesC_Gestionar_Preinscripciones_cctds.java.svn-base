package jc2s.sistppg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import jc2s.sistppg.hibernate.CiudadPreinscripcion;
import jc2s.sistppg.hibernate.Preinscripcion;


/**
 * 
 */
public class AccionesC_Gestionar_Preinscripciones_cctds extends CohesionAction {
    
/**
     * Called by Struts for the execution of action A_prep_gestionar_preinscripcion_cctds.
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
    public ActionForward A_prep_gestionar_preinscripcion_cctds(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_gestionar_preinscripciones_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            String orderby = (String) request.getParameter("orderby");//request.getAttribute("orderby");
            List<Preinscripcion> preinscripciones;
            if(orderby!=null){
                if(orderby.equals("1")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion order by tipo desc").list();
                }else if(orderby.equals("2")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion order by estudiante desc").list();
                }else if(orderby.equals("3")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion order by estatus desc").list();
                }else if(orderby.equals("4")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion order by created_at desc").list();
                }else{
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion order by created_at desc").list();
                }
            }else{
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion").list();
                }
            request.setAttribute("L_preinscripciones", preinscripciones);
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
     * Called by Struts for the execution of action A_prep_consultar_no_aprobados.
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
    public ActionForward A_prep_consultar_no_aprobados(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_consultar_no_aprobados", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            String orderby = (String) request.getParameter("orderby");//request.getAttribute("orderby");
            List<Preinscripcion> preinscripciones;
            if(orderby!=null){
                if(orderby.equals("1")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool order by tipo asc").setBoolean("bool", false).list();
                }else if(orderby.equals("2")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool order by estudiante asc").setBoolean("bool", false).list();
                }else if(orderby.equals("3")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool order by tipo asc").setBoolean("bool", false).list();
                }else if(orderby.equals("4")){
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool order by created_at desc").setBoolean("bool", false).list();
                }else{
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool order by created_at desc").setBoolean("bool", false).list();
                }
            }else{
                    preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion where estatus = :bool").setBoolean("bool", false).list();
                }
            request.setAttribute("L_preinscripciones", preinscripciones);
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
     * Called by Struts for the execution of action A_procesar_aprobados.
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
    public ActionForward A_procesar_aprobados(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_prep_gestionar_preinscripcion_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            List<Preinscripcion> preinscripciones = (List<Preinscripcion>) s.createQuery("from Preinscripcion p join fetch p.estudiante where p.estatus = :bool").setBoolean("bool", true).list();
            List<Empresa> empresas = (ArrayList<Empresa>) s.createQuery("from Empresa e").list();
            Iterator empresasI = empresas.iterator();
            String emailContent;

            while(empresasI.hasNext()){
                Empresa e = (Empresa) empresasI.next();
                emailContent = "";
                for(int i = 0; i<preinscripciones.size();i++){
                    Set<CiudadPreinscripcion> cps = (Set<CiudadPreinscripcion>) preinscripciones.get(i).getCiudadesPreinscripcion();
                    Iterator icp = cps.iterator();
                    Estudiante est = (Estudiante) preinscripciones.get(i).getEstudiante();
                    while(icp.hasNext()){
                        CiudadPreinscripcion cp = (CiudadPreinscripcion) icp.next();
                        if(e.getCiudad() == cp.getCiudad()){
                            List<EmpresaSolicitaPasante> esp = s.createQuery("from EmpresaSolicitaPasante es where es.empresa = :var").setLong("var", e.getId()).list();
                            for(int y = 0; y < esp.size(); y++){
                                if(esp.get(y).getCarrera().getId() == est.getCarrera().getId()){
                                    emailContent += "<li>"+est.getApellido()+", "+est.getNombre()+" - "+est.getEmail()+est.getTelefono()+" / "+est.getOtrotelefono()+"  ("+est.getCarrera().getNombre()+")</li>";
                                }
                            }
                        }
                    }

                }
                if(!emailContent.equals(""))
                    enviarCorreo(e.getNombre(),e.getEmail(),emailContent);
            }
            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            //throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg",
            getResources(request).getMessage("A_procesar_aprobados.msg0"));
        }

        return mapping.findForward(SALIDAS[salida]);
    }


public void enviarCorreo(String nombreEmpresa, String emailEmpresa, String contenido) throws Exception{

            Properties props = new Properties();

            // Nombre del host de correo, es smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com");

            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");

            // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.port","587");

            // Nombre del usuario
            props.setProperty("mail.smtp.user", "sistemappg@gmail.com");

            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");

            javax.mail.Session sessionMail = javax.mail.Session.getDefaultInstance(props);
            sessionMail.setDebug(true);

            MimeMessage message = new MimeMessage(sessionMail);

            // Quien envia el correo
            String from = "sistemappg@gmail.com";
            message.setFrom(new InternetAddress(from));

            // A quien va dirigido
            String to = (emailEmpresa);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String motivo="Recordatorio: Entrega Documentos";
            String htmlText = setEmailContent(nombreEmpresa,contenido);
            messageBodyPart.setContent(htmlText, "text/html");

            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(getServlet().getServletContext().getRealPath("/")+ "../../email/img06.gif");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID","<image>");

            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            Transport t = sessionMail.getTransport("smtp");
            t.connect("sistemappg@gmail.com","jc2system");
            t.sendMessage(message,message.getAllRecipients());
            t.close();
    }

    public String setEmailContent (String to, String contenido) throws FileNotFoundException, IOException{

        String path = getServlet().getServletContext().getRealPath("/")+ "../../email/";

        FileInputStream fstream = new FileInputStream(path+"emailProcesarPreinscripcion.html");
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String emailContenido = "",strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            emailContenido=emailContenido+"\n"+strLine;
        }

        Pattern patronMotivo = Pattern.compile("TITULO1");
        // creamos el Matcher a partir del patron, la cadena como parametro
        Matcher encaja = patronMotivo.matcher(emailContenido);
        // invocamos el metodo replaceAll
        String resultado = encaja.replaceAll("Postulacion de Pasante");

        Pattern patronDestinatario = Pattern.compile("DESTINATARIO");
        // creamos el Matcher a partir del patron, la cadena como parametro
        encaja = patronDestinatario.matcher(resultado);
        // invocamos el metodo replaceAll
        resultado = encaja.replaceAll(to);

        Pattern patronCarrera = Pattern.compile("CONTENIDO");
        // creamos el Matcher a partir del patron, la cadena como parametro
        encaja = patronCarrera.matcher(resultado);
        // invocamos el metodo replaceAll
        resultado = encaja.replaceAll(contenido);


        Pattern patronRemitente = Pattern.compile("REMITENTE");
        // creamos el Matcher a partir del patron, la cadena como parametro
        encaja = patronRemitente.matcher(resultado);
        // invocamos el metodo replaceAll
        resultado = encaja.replaceAll("CCTDS");

        return resultado;

    }


/**
     * Called by Struts for the execution of action A_mostrar_preinscripcion.
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
    public ActionForward A_mostrar_preinscripcion(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"V_mostrar_preinscripcion", "A_prep_consultar_no_aprobados"};
        final int SALIDA_0 = 0;
        final int SALIDA_1 = 1;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            String parametro = (String) request.getParameter("preId");
            long preId = Long.parseLong(parametro);
            Preinscripcion p = (Preinscripcion) s.createQuery("from Preinscripcion where idPreinscripcion = :id").setLong("id", preId).uniqueResult();
            if(p==null){
                salida = SALIDA_1;
            }else{
                request.setAttribute("p", p);
            }
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
     * Called by Struts for the execution of action A_cambiar_estatus.
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
    public ActionForward A_cambiar_estatus(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Salidas
        final String[] SALIDAS = {"A_prep_gestionar_preinscripcion_cctds", };
        final int SALIDA_0 = 0;

        int salida = SALIDA_0;
//Checking for actors coordinador_cctds
            if (!CohesionActor.checkActor(request, 1)) {
                return mapping.findForward(CohesionActor.SALIDA_ACTOR);
            }
        Session s = HibernateUtil.getCurrentSession();
        Transaction tr = s.beginTransaction();
        try {
            String parametro = (String) request.getParameter("preId");
            long preId = Long.parseLong(parametro);
            Preinscripcion p = (Preinscripcion) s.createQuery("from Preinscripcion where idPreinscripcion = :id").setLong("id", preId).uniqueResult();
            p.setEstatus(true);
            s.update(p);

            tr.commit();

        } catch (Exception ex) {
            tr.rollback();
            throw ex;
        } finally {
            try { s.close(); } catch (Exception ex2) {}
        }
        if (salida==0) {
          request.setAttribute("msg","Estatus Cambiado Satisfactoriamente");
        }

        return mapping.findForward(SALIDAS[salida]);
    }

}

