<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title><bean:message key="V_Inicio_Sesion.title"/></title>

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
                    <li><html:link action="/A_Prep_Gestion_Pasantias_Estudiante.do"><bean:message key="V_Gestion_Proy_Est.label0"/><%-- Gestionar Pasantias --%></html:link></li>
                    <li><cohesion:actor actors="4"><html:link action="/A_Prep_Gestion_PG_Est.do"><bean:message key="V_Gestion_Proy_Est.label1"/><%-- Gestionar PG --%></html:link></cohesion:actor></li>
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


                                        <logic:empty name="EstudianteRealizaProyecto">
                                            <h1>¡Usted no está realizando ningun tipo de proyecto!</h1>
                                        </logic:empty>
                                        <logic:notEmpty name="EstudianteRealizaProyecto">
                                            <h1>Usted tiene los siguientes proyectos asociados: </h1>
                                            <logic:empty name="Pasantias">
                                            </logic:empty>
                                            <logic:notEmpty name="Pasantias">
                                                <h2><html:link action="/A_Prep_Gestion_Pasantias_Estudiante.do">Pasantias:</html:link></h2>
                                                <div class="administrador">
                                                    <table class="sortable" width="500">
                                                        <thead><tr><th align="center"><h2>Título</h2></th></tr></thead>
                                                        <tbody>
                                                            <logic:iterate id="pas" collection="${empty Pasantias ? _vacio : Pasantias}">
                                                                <tr><td><center>${pas.titulo}</center></td>
                                                                </tr>
                                                            </logic:iterate>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </logic:notEmpty>
                                            <logic:empty name="ProyectoDeGrado">
                                            </logic:empty>
                                            <logic:notEmpty name="ProyectoDeGrado">
                                                <br><br><h2><html:link action="/A_Prep_Gestion_PG_Est.do">Proyectos De Grado:</html:link></h2>
                                                <div class="administrador">
                                                    <table class="sortable" width="500">
                                                        <thead><tr><th><h2 align="center">Nombre</h2></th></tr></thead>
                                                        <tbody>
                                                            <logic:iterate id="pg" collection="${empty ProyectoDeGrado ? _vacio : ProyectoDeGrado}">
                                                                <tr><td><center>${pg.nombre}</center></td>
                                                                </tr>
                                                            </logic:iterate>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </logic:notEmpty>
                                        </logic:notEmpty>


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