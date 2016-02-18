<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title><bean:message key="V_agregar_PG.title"/></title>
        <html:base/>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
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
                                    <center><h1>${empty msg ? "" : msg}</h1></center><hr><p><p>
                                    <div class="box1465928" align="center">

                                        <html:form styleId="pgForm"
                                                   action="/A_agregar_PG.do" method="post">
                                            <table border="0">
                                            <tr><td><p id="1840580_C"><label for="1840580"><bean:message key="F_Inscripcion_PG.label0"/><%-- Nombre Proyecto: --%></label></td><td><html:text styleId="1840580" property="nombre" size="60" maxlength="100" styleClass="validate[required]"/><small>(máximo 100 caracteres)</small></td></tr>
                                            <tr><td><p id="1840583_C"><label for="1840583"><bean:message key="F_Inscripcion_PG.label1"/><%-- Recursos Necesarios: --%></label></td><td><html:textarea styleId="1840583" property="recursos" cols="60" rows="10" styleClass="validate[required]"></html:textarea></td></tr>
                                            <tr><td><p id="1840586_C"><label for="1840586"><bean:message key="F_Inscripcion_PG.label2"/><%-- Duracion de Recursos: --%></label></td><td><html:textarea styleId="1840586" property="duracion_recursos" cols="60" rows="10" styleClass="validate[required]"></html:textarea></td></tr>
                                            <tr><td><p id="1840589_C"><label for="1840589"><bean:message key="F_Inscripcion_PG.label3"/><%-- Puntos de Interes: --%></label></td><td><html:textarea styleId="1840589" property="puntos_de_interes" cols="60" rows="10" styleClass="validate[required]"></html:textarea></td></tr>
                                            </center></td></tr></table><center><p id="18405891_C">Estudiante:<html:select styleId="18405891" property="estudiante">
                                                    
                                                    <logic:iterate id="estudiante" collection="${empty L_Est ? _vacio : L_Est}">
                                                    <option value="${estudiante.usbid}">${estudiante.apellido}, ${estudiante.nombre}</option>
                                                </logic:iterate>

                                            </html:select></p>
                                            </center></td></tr></table>
                                    <hr>
                                            <html:submit styleClass="button">Adelante</html:submit>
                                        </html:form>
                                        <script>
                                            $(document).ready(function(){
                                                $("#pgForm").validationEngine('attach');
                                            });
                                        </script>



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