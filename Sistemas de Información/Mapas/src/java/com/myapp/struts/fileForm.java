/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Gurren Lagann
 */
public class fileForm extends org.apache.struts.action.ActionForm {

    private FormFile theFile;
    private FormFile theFile2;

    public FormFile getTheFile() {
        return theFile;
    }

    public void setTheFile(FormFile theFile) {
        this.theFile = theFile;
    }

    public FormFile getTheFile2() {
        return theFile2;
    }

    public void setTheFile2(FormFile theFile) {
        this.theFile2 = theFile;
    }

    public fileForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getTheFile() == null) {
            errors.add("TheFile", new ActionMessage("error.TheFile.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
