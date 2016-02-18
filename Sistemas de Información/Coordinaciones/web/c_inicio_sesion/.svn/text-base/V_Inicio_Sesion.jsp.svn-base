<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" 
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title><bean:message key="V_Inicio_Sesion.title"/></title>


        <html:base/>
        <link rel="stylesheet" type="text/css" href="../css/style.css"></link>
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
        <style type="text/css">

            div#box1465928 {width: 400px; margin: 40px auto; }

            form#1465928 {float: left; margin: 0; padding: 0; display: inline; width: 400px; }

            form#1465928 p {float: left; margin: 0; padding: 0; display: inline; }

            form#1465928 label {float: left; margin: 0; padding: 0; display: inline; overflow: hidden; }

            form#1465928 input {float: left; margin: 0; padding: 0; display: inline; }

            form#1465928 p#1465930_C {clear: both; width: 400px; }

            form#1465928 p#1465930_C label {clear: both; width: 400px; }

            form#1465928 p#1465930_C input {clear: both; width: 396px; }

            form#1465928 p#1465933_C {clear: both; width: 400px; }

            form#1465928 p#1465933_C label {clear: both; width: 400px; }

            form#1465928 p#1465933_C input {clear: both; width: 396px; }



        </style>

        <%--   <link rel="stylesheet" type="text/css" href="_css/style.css"/>
           <style type="text/css">
           div#box1840387 {width: 400px; margin: 40px auto; }
           form#1840387 {float: left; margin: 0; padding: 0; display: inline; width: 400px; }
           form#1840387 p {float: left; margin: 0; padding: 0; display: inline; }
           form#1840387 label {float: left; margin: 0; padding: 0; display: inline; overflow: hidden; }
           form#1840387 input {float: left; margin: 0; padding: 0; display: inline; }
             form#1840387 p#1840389_C {clear: both; width: 400px; }
             form#1840387 p#1840389_C label {clear: both; width: 400px; }
             form#1840387 p#1840389_C input {clear: both; width: 396px; }
             form#1840387 p#1840392_C {clear: both; width: 400px; }
             form#1840387 p#1840392_C label {clear: both; width: 400px; }
             form#1840387 p#1840392_C input {clear: both; width: 396px; }

        </style> --%>

    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">

                    <li><html:link action="/A_Prep_Inicio_Sesion_Empresa.do"><bean:message key="V_Inicio_Sesion.label1"/><%-- Empresas --%></html:link></li>
                    <li><html:link action="/A_prep_inicio_sesion_t_industrial.do"><bean:message key="V_Inicio_Sesion.label2"/><%-- Tutores Industriales --%></html:link></li>
                    <li><html:link action="/A_Prep_Inicio_Sesion_Adm.do"><bean:message key="V_Inicio_Sesion.label3"/><%-- Administrador --%></html:link></li>

                </ul>
            </div>

            <div id="header">
            </div>
            <div id="page">

                <div id="content">
                    <div id="body">
                        <div id="split">
                            <div class="top"> </div>
                            <div id="left">
                                <div class="content">
                                    <center>${empty msg ? "" : msg}</center>
                                    <div class="box1465928" align="center">

                                        <html:form
                                            action="/A_Inicio_Sesion.do" method="post">
                                            <table border="0">
                                                <tr>
                                                    <th>
                                                        <p id="1840389_C"><label for="1840389"><bean:message key="F_Inicio_Sesion.label0"/><%-- Usbid: --%></label><html:text styleId="1840389" property="usbid" size="30"/></p>
                                                    </th>
                                                
                                                    <th>
                                                        <html:submit styleClass="button"><bean:message key="V_Inicio_Sesion.label0"/><%-- Ingresar --%></html:submit>
                                                    </th>
                                                </tr>
                                                </table>
                                                    <table border="0">
                                                <tr align="center">
                                                    Se les recuerda a nuestros Usuarios que cualquier información enviada por correo<br> electrónico será a la traves de su cuenta de correo USBNet.
                                                    </tr>
                                            </table>

                                        </html:form>

                                    </div>
                                </div>
                            </div>

                            <div class="clearer"></div>
                            <div class="bottom"></div>
                        </div>
                        <div class="clearer"></div>
                    </div>
                    <div class="clearer"></div>
                </div>

                <div id="end_body"></div>
            </div>
            <div style="clear: both;">&nbsp;</div>
        </div>
        <div id="footer"><center> <bean:message key="bottom.label"/> </center></div>



    </body>
</html:html>