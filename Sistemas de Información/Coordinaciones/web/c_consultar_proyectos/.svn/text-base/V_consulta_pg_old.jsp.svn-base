<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title>Consultar PG</title>

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
                                        <h1 align="center">Proyectos de Grado</h1>
                                        <html:form action="/A_consultar_PG.do" method="post">
                                            <table borde="0">
                                                <tr>
                                                    <th align="center">
                                                        Trimestre
                                                    </th>
                                                    <th align="center">
                                                        Año
                                                    </th>
                                                    <th align="center">
                                                        Tutor
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <html:select property="trimestre">
                                                            <html:option value="-1"> Todos </html:option>
                                                            <logic:iterate id="tri" collection="${empty Trimestre ? _vacio : Trimestre}">
                                                                <html:option value="${tri.idTrimestre}"> ${tri.nombre}</html:option>
                                                            </logic:iterate>
                                                        </html:select>
                                                    </td>
                                                    <td>
                                                        <html:select property="ano">
                                                            <html:option value="-1"> Todos </html:option>
                                                            <html:option value="2006"> 2006</html:option>
                                                            <html:option value="2007"> 2007</html:option>
                                                            <html:option value="2008"> 2008</html:option>
                                                            <html:option value="2009"> 2009</html:option>
                                                            <html:option value="2010"> 2010</html:option>
                                                            <html:option value="2011"> 2011</html:option>
                                                            <html:option value="2012"> 2012</html:option>
                                                        </html:select>
                                                    </td>
                                                    <td>
                                                        <html:select property="tutor">
                                                            <html:option value="-1"> Todos </html:option>
                                                            <logic:iterate id="tut" collection="${empty Profesor ? _vacio : Profesor}">
                                                                <html:option value="${tut.idProfesor}"> ${tut.nombre} ${tut.apellido}</html:option>
                                                            </logic:iterate>
                                                        </html:select>
                                                    </td>
                                                    <td>
                                                        <html:submit styleClass="button">Buscar</html:submit>
                                                    </td>
                                                </tr>

                                            </table>
                                        </html:form>


                                        <logic:empty name="L_PGS">
                                            <h1>¡No se encontró ningun proyecto de grado con los criterios dados!</h1>
                                        </logic:empty>
                                        <logic:notEmpty name="L_PGS">

                                            <div class="administrador">
                                                <table width="500px" class="sortable">
                                                    <logic:iterate id="proy" collection="${empty L_PGS ? _vacio : L_PGS}">
                                                        <thead>
                                                            <tr>
                                                                <th align="center">
                                                                    Código
                                                                </th>
                                                                <th align="center">
                                                                    Nombre
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr onclick="location.href='/sistppg70/A_mostrar_pg.do?idProyectoDeGrado=${proy.idProyectoDeGrado}'" onmouseover="this.style.cursor='pointer'">
                                                                <td>
                                                                    ${proy.codigo}
                                                                </td>
                                                                <td>
                                                                    ${proy.nombre}
                                                                </td>
                                                            </tr>
                                                        </tbody>

                                                    </logic:iterate>
                                                </table>
                                            </div>
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