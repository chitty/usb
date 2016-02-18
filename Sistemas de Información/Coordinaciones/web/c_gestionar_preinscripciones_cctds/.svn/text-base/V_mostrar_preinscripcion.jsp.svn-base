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
                </ul>
            </div>



            <div id="header">
                <%-- NO ESTOY SEGURO DE QUE VA AQUI PERO SE VE FEO Y QUEDA SOBRE LA IMAGEN --%>
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
                                   

                                        <table id="pgInfo">
                                            <tr>
                                                <td id="titulo">Tipo:</td>
                                                <td>${ p.tipo==1 ? "Corta" : ""}${ p.tipo==2 ? "Intermedia" : ""}${ p.tipo==3 ? "Larga" : ""}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Estudiante:</td>
                                                <td>${p.estudiante.nombre}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Carnet:</td>
                                                <td>${p.estudiante.usbid}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Fecha Preinscripcion:</td>
                                                <td>${p.created_at}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Planilla Preinscripcion:</td>
                                                <td><html:link action="/A_GenerarSolicitudPasantia.do?preId=${p.idPreinscripcion}">Descargar<img style="padding-left: 3px" src="../_css/images/download.png"></html:link></td>
                                            </tr>
                                        </table>
                                        <div id="aprobarBtm">
                                            <cohesion:actor actors="1"><h3><html:link action="/A_cambiar_estatus.do?preId=${p.idPreinscripcion}" onclick="return confirm('Se enviará un email con datos del estudiante a empresas que hayan solicitado pasantes de la misma carrera, período y tipo que el \n\r¿Está de acuerdo? ')"><img style="padding-left: 3px" height="22" src="../_css/images/checkmark.png">Aprobar</html:link></h3></cohesion:actor>
                                        </div>
                                 

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