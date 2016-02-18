<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
%><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
%><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
%><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
%><%@ page contentType="text/html;charset=ISO-8859-1"
%><html:html>
    <head>
        <title><bean:message key="V_fases_pasantia.title"/></title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
        <style type="text/css">
        div#box1840475 {width: 400px; margin: 40px auto; }
        form#1840475 {float: left; margin: 0; padding: 0; display: inline; width: 400px; }
        form#1840475 p {float: left; margin: 0; padding: 0; display: inline; }
        form#1840475 label {float: left; margin: 0; padding: 0; display: inline; overflow: hidden; }
        form#1840475 input {float: left; margin: 0; padding: 0; display: inline; }
          form#1840475 p#1840477_C {clear: both; width: 400px; }
          form#1840475 p#1840477_C label {clear: both; width: 400px; }
          form#1840475 p#1840477_C input {clear: both; width: 396px; }

        </style>

    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">
                    <li><cohesion:actor actors="4"><html:link action="/A_finalizar_inscripcion.do"><bean:message key="V_fases_pasantia.label1"/><%-- Finalizar --%></html:link></cohesion:actor></li>                    
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
                                    <center><h3>Inscripción de Pasantía</h3>
                                        <h4>Agregar Fase</h4>
                                    ${empty msg ? "" : msg}</center>
                                    <div class="box1840475">
                                    <html:form action="/A_agregar_fase.do" method="post">
                                    <p id="1840477_C"><label for="1840477">
                                    <bean:message key="F_Fase_Pasantia.label0"/><%-- Objetivos Especificos: --%></label><html:textarea styleId="1840477" property="objetivos_especificos" cols="60" rows="10"></html:textarea></p>

                                    <html:submit styleClass="button"><bean:message key="V_fases_pasantia.label0"/><%-- Agregar Fase --%></html:submit>
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