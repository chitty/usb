/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import java.io.*;

/**
 *
 * @author Gurren Lagann
 */
public class FileuploadAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    class StreamGobbler extends Thread {

        InputStream is;
        String type;
        OutputStream os;

        StreamGobbler(InputStream is, String type) {
            this(is, type, null);
        }

        StreamGobbler(InputStream is, String type, OutputStream redirect) {
            this.is = is;
            this.type = type;
            this.os = redirect;
        }

        public void run() {
            try {
                PrintWriter pw = null;
                if (os != null) {
                    pw = new PrintWriter(os);
                }

                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (pw != null) {
                        pw.println(line);
                    }
                }
                if (pw != null) {
                    pw.flush();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String path = "";
        String pathb = "";
        fileForm myForm = (fileForm) form;
        FormFile myFileshp = myForm.getTheFile();
        FormFile myFiledbf = myForm.getTheFile2();
        String contentTypeshp = myFileshp.getContentType();
        String contentTypedbf = myFiledbf.getContentType();
        String fileNameshp = myFileshp.getFileName();
        String fileNamedbf = myFiledbf.getFileName();
        byte[] fileDatashp = myFileshp.getFileData();
        byte[] fileDatadbf = myFiledbf.getFileData();
        String filePath = getServlet().getServletContext().getRealPath("/") + "upload";
        if (!fileNameshp.equals("") && !fileNamedbf.equals("")) {
            File fileToCreate1 = new File(filePath, fileNameshp);
            File fileToCreate2 = new File(filePath, fileNamedbf);
            if (!fileToCreate1.exists()) {
                FileOutputStream fileOutStream = new FileOutputStream(fileToCreate1);
                fileOutStream.write(myFileshp.getFileData());
                fileOutStream.flush();
                fileOutStream.close();
            }
            if (!fileToCreate2.exists()) {
                FileOutputStream fileOutStream = new FileOutputStream(fileToCreate2);
                fileOutStream.write(myFiledbf.getFileData());
                fileOutStream.flush();
                fileOutStream.close();
            }
            path = "\"" + path + fileToCreate1.getAbsolutePath() + "\"";
            pathb = "\"" + pathb + fileToCreate2.getAbsolutePath() + "\"";
        }
        request.setAttribute("fileName", fileNameshp);



        String path1 = "\"C:\\Program Files\\PostgreSQL\\8.4\\bin\\shp2pgsql.exe\" -s 4326 ";
        String path2 = " public." + fileNameshp.substring(0, fileNameshp.lastIndexOf('.'));

        FileOutputStream fos = new FileOutputStream(getServlet().getServletContext().getRealPath("/") + "upload\\" + "upload");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("\"C:\\Program Files\\PostgreSQL\\8.4\\bin\\psql.exe\" -d postgis -U postgres -f " + "\"" + getServlet().getServletContext().getRealPath("/") + "upload\\" + fileNameshp.substring(0, fileNameshp.lastIndexOf('.')) + ".sql\"");
        // any error message?
        StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

        // any output?
        StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", fos);

        // kick them off
        errorGobbler.start();
        outputGobbler.start();

        // any error???
        int exitVal = proc.waitFor();
        System.out.println("ExitValue: " + exitVal);
        fos.flush();
        fos.close();









//        Runtime rt2 = Runtime.getRuntime();
//        Process proc2 = rt2.exec("\"C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\psql.exe\" -d postgis -U postgres -f " + "\"" + getServlet().getServletContext().getRealPath("/") + "upload\\" + fileNameshp.substring(0, fileNameshp.lastIndexOf('.')) + ".sql\"");
//        // any error message?









//        File todelete = new File(getServlet().getServletContext().getRealPath("/") + "upload\\" + "upload.sql");
//        todelete.delete();
//        File todelete2 = new File(path);
//        todelete2.delete();
//        File todelete3 = new File(pathb);
//        todelete3.delete();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + getServlet().getServletContext().getRealPath("/") + "upload\\" + "upload.sql" + "\"");
        System.out.println(path);
        System.out.println(pathb);
        System.out.println("\"C:\\Program Files\\PostgreSQL\\8.4\\bin\\psql.exe\" -d postgis -U postgres -f " + "\"" + getServlet().getServletContext().getRealPath("/") + "upload\\" + fileNameshp.substring(0, fileNameshp.lastIndexOf('.')) + ".sql\"");
        System.out.println("-----------------------------------------------------------------------------------");
        return mapping.findForward(SUCCESS);
    }
}
