<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" 
%><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" 
%><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" 
%><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
%><%@ page contentType="text/html;charset=ISO-8859-1"
%><html:html>
    <head>
        <title><bean:message key="V_actividad_fase.title"/></title>
        <link rel="stylesheet" type="text/css" href="../css/style.css"/>
        <script type="text/javascript" src="_js/jquery-1.4.4.min.js"></script>
        <link type="text/css" href="_css/smoothness/jquery-ui-1.8.10.custom.css" rel="Stylesheet" />
        <script type="text/javascript" src="_js/jquery-ui-1.8.10.custom.min.js"></script>
        <script type="text/javascript" src="_js/jquery.ui.datepicker-es.js"></script>
        <style type="text/css">
        div#box1840480 {width: 400px; margin: 40px auto; }
        form#1840480 {float: left; margin: 0; padding: 0; display: inline; width: 400px; }
        form#1840480 p {float: left; margin: 0; padding: 0; display: inline; }
        form#1840480 label {float: left; margin: 0; padding: 0; display: inline; overflow: hidden; }
        form#1840480 input {float: left; margin: 0; padding: 0; display: inline; }
          form#1840480 p#1840482_C {clear: both; width: 400px; }
          form#1840480 p#1840482_C label {clear: both; width: 400px; }
          form#1840480 p#1840482_C input {clear: both; width: 396px; }
          form#1840480 p#1840509_C {clear: both; width: 400px; }
          form#1840480 p#1840509_C label {clear: both; width: 400px; }
          form#1840480 p#1840509_C input {clear: both; width: 396px; }

        </style>

    </head>
    <body>

                
           <div id="wrapper">
            <div id="menu">
                <ul id="nav">
                    <li><cohesion:actor actors="4"><html:link action="/A_guardar_fase.do"><bean:message key="V_actividad_fase.label1"/><%-- Guardar Fase --%></html:link></cohesion:actor></li>
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
                            ${empty msg ? "" : msg}
                <div class="box1840480"><html:form
                  action="/A_agregar_actividad.do" method="post">
                  <p id="1840482_C"><label for="1840482"><bean:message key="F_Actividad_Fase.label0"/><%-- Descripcion: --%></label><html:textarea styleId="1840482" property="descripcion" cols="60" rows="10"></html:textarea></p>
                  <p id="1840509_C"><label for="1840509"><bean:message key="F_Actividad_Fase.label1"/><%-- Tiempo Estimado: --%></label><html:text styleId="1840509" property="tiempo_estimado" size="30"/></p>

                  <html:submit styleClass="button"><bean:message key="V_actividad_fase.label0"/><%-- Agregar Actividad --%></html:submit>
                </html:form></div>

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
        <div id="footer"> <bean:message key="bottom.label"/> </div>
        
    </body>
</html:html>