<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title>Gestionar Preincripciones CCTDS</title>

        <html:base/>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
        <script type="text/javascript" src="../sorttable.js"></script>
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
                                    <center>${empty msg ? "" : msg}</center>
                                    <div class="box1465928" align="center">

                            <logic:equal name="tipo" value="e">
                                <h1>Prorroga Evaluacion</h1>
                                <table>
                                    <tr>
                                        <th>Estudiante: </th>
                                        <td>${Prorroga.prorroga.estudiante.usbid}</td>
                                    </tr>
                                    <tr>
                                        <th>Justificacion: </th>
                                        <td>${Prorroga.prorroga.justificacion}</td>
                                    </tr>
                                    <tr>
                                        <th>Fecha propuesta: </th>
                                        <td>${Prorroga.fecha_propuesta}</td>
                                    </tr>
                                    <tr>
                                        <th>Fecha Solicitud: </th>
                                        <td>${Prorroga.prorroga.created_at}</td>
                                    </tr>
                                    <tr>
                                        <th>Estatus: </th>
                                        <td>${Prorroga.prorroga.estatus.estatus}</td>
                                    </tr>
                                </table><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaEvaluacion}&tipo=e&nuevo_estatus=1">Aprobar</html:link><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaEvaluacion}&tipo=e&nuevo_estatus=3">Pasar por CCTDS</html:link><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaEvaluacion}&tipo=e&nuevo_estatus=4">Rechazar</html:link><br>
                            </logic:equal>
                            <logic:equal name="tipo" value="i">
                                <h1>Prorroga Evaluacion</h1>
                                <table>
                                    <tr>
                                        <th>Estudiante: </th>
                                        <td>${Prorroga.prorroga.estudiante.usbid}</td>
                                    </tr>
                                    <tr>
                                        <th>Justificacion: </th>
                                        <td>${Prorroga.prorroga.justificacion}</td>
                                    </tr>
                                    <tr>
                                        <th>Fecha Solicitud: </th>
                                        <td>${Prorroga.prorroga.created_at}</td>
                                    </tr>
                                    <tr>
                                        <th>Estatus: </th>
                                        <td>${Prorroga.prorroga.estatus.estatus}</td>
                                    </tr>
                                </table><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaInscripcion}&tipo=i&nuevo_estatus=1">Aprobar</html:link><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaInscripcion}&tipo=i&nuevo_estatus=3">Pasar por CCTDS</html:link><br>
                                <html:link action="/A_mostrar_prorroga.do?id=${Prorroga.idProrrogaInscripcion}&tipo=i&nuevo_estatus=4">Rechazar</html:link><br>
                            </logic:equal>

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