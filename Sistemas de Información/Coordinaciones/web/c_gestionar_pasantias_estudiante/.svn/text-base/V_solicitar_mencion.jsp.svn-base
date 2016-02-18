<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title><bean:message key="V_solicitar_prorroga_evaluacion.title"/></title>

        <html:base/>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>

    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">
                </ul>
                <p align="right"><html:link action="/A_Prep_Inicio_Sesion.do">Cerrar Sesión</html:link>
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
Solicitar Mencion
                                        <html:form
                                            action="/A_solicitar_prorroga_evaluacion.do" method="post">
                                            <p id="1840450_C">Justificacion: <br><html:textarea styleId="1840450" property="justificacion" cols="60" rows="10"></html:textarea></p>
                                            <p id="1840450_C">Fecha: <br><html:text styleId="1840450" property="fecha_propuesta"></html:text></p>
                                            <html:submit styleClass="button"><bean:message key="V_solicitar_prorroga_inscripcion.label0"/><%-- Solicitar Prorroga --%></html:submit>
                                        </html:form>

                                            <%--                                        <form
                                            action="/A_solicitar_prorroga_evaluacion.do" method="post">

                                            <p>Justificacion: <br><textarea name="justificacion" cols="60" rows="10" id="1840450"></textarea></p>
                                            <p>Fecha propuesta (dd/mm/aaaa): <input type="text" name="fecha" size="10"></p>
                                            <input type="submit" class="button" value="Solicitar">
                                        </form>
                                        --%>


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
