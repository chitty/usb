<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title>Consultar Proyectos</title>

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
                    <li><cohesion:actor actors="11"><html:link action="/A_consultar_PG.do"><bean:message key="V_consulta_proyectos.label0"/><%-- Consultar PG --%></html:link></cohesion:actor></li>
	            <li><cohesion:actor actors="11"><html:link action="/A_consultar_pasantias.do"><bean:message key="V_consulta_proyectos.label1"/><%-- Consultar Pasantias --%></html:link></cohesion:actor></li>
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

                                    ${empty msg ? "" : msg}
                                    <logic:empty name="EstudianteRealizaProyecto">
                                        <h1 align="center">¡No hay estudiantes realizando proyectos!</h1>
                                    </logic:empty>
                                    <logic:notEmpty name="EstudianteRealizaProyecto">
                                        <center>
                                            <h1>Proyectos: </h1>
                                            <logic:empty name="Pasantias">
                                            </logic:empty>
                                            <logic:notEmpty name="Pasantias">
                                                <h2><html:link action="/A_consultar_pasantias.do">Pasantias</html:link></h2>
                                                <div class="administrador">
                                                    <table width="500px" class="sortable">
                                                        <thead>
                                                            <tr><th align="center">Título</th></tr>
                                                        </thead>
                                                        <tbody>
                                                            <logic:iterate id="pas" collection="${empty Pasantias ? _vacio : Pasantias}">
                                                                <tr><td align="center">${pas.titulo}</td>
                                                                </tr>
                                                            </logic:iterate>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </logic:notEmpty>
                                            <logic:empty name="ProyectoDeGrado">
                                            </logic:empty>
                                            <logic:notEmpty name="ProyectoDeGrado">
                                                <br><br><h2><html:link action="/A_consultar_PG.do">Proyectos De Grado:</html:link></h2>
                                                <div class="administrador">
                                                    <table width="500px" class="sortable">
                                                        <thead>
                                                            <tr><th align="center">Nombre</th></tr>
                                                        </thead>
                                                        <tbody>
                                                            <logic:iterate id="pg" collection="${empty ProyectoDeGrado ? _vacio : ProyectoDeGrado}">
                                                                <tr><td align="center">${pg.nombre}</td>
                                                                </tr>
                                                            </logic:iterate>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </logic:notEmpty>
                                        </center>
                                    </logic:notEmpty>

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