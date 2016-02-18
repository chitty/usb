<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <html:base/>
        <title><bean:message key="V_Sesion_Empresa.title"/></title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
        <script src="../_js/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="../_js/insc-pasant.js" type="text/javascript"></script>
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
                                        <h1 align="center">Pasantías</h1>
                                        <html:form action="/A_consultar_pasantias.do" method="post">

                                            <table border="0">
                                                <tr>
                                                    <th align="center">
                                                        Carrera
                                                    </th>

                                                    <th align="center">
                                                        Tipo
                                                    </th>

                                                    <th align="center">
                                                        Periodo
                                                    </th>

                                                    <th align="center">
                                                        Año
                                                    </th>

                                                    <th align="center">
                                                        Estatus
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <logic:empty name="Carreras">
                                                            <html:select property="idCarrera">
                                                                <%-- Valor cabliao --%>
                                                                <html:option value="2"> Ingeniería de Computación</html:option>
                                                            </html:select>
                                                        </logic:empty>
                                                        <logic:notEmpty name="Carreras">
                                                            <html:select property="idCarrera">
                                                                <html:option value="-1"> Todas </html:option>
                                                                <logic:iterate id="car" collection="${empty Carreras ? _vacio : Carreras}">
                                                                    <html:option value="${car.idCarrera}"> ${car.nombre}</html:option>
                                                                </logic:iterate>
                                                            </html:select>
                                                        </logic:notEmpty>
                                                    </td>
                                                    <td>
                                                        <html:select property="tipo" styleId="1843570">
                                                            <html:option value="all"> Todos</html:option>
                                                            <html:option styleId="l" value="larga"> Pasantía Larga</html:option>
                                                            <html:option styleId="i" value="intermedia"> Pasantía Intermedia</html:option>
                                                            <html:option styleId="c" value="corta"> Pasantía Corta</html:option>
                                                        </html:select>
                                                    </td>
                                                    <td>
                                                        <html:select property="periodo" styleId="18435702">
                                                            <html:option value="-1">Todos</html:option>
                                                            <%-- periodos pasantia larga --%>
                                                            <logic:empty name="L_PPL">
                                                                <html:option styleClass="periodo ppl" value="0">Fail.</html:option>
                                                            </logic:empty>
                                                            <logic:notEmpty name="L_PPL">
                                                                <logic:iterate id="ppl" name="L_PPL">
                                                                    <html:option styleClass="periodo ppl" value="${ppl.idPeriodoPasantiaLarga}">${ppl.nombre}</html:option>
                                                                </logic:iterate>
                                                            </logic:notEmpty>

                                                            <%-- periodos pasantia intermedia --%>
                                                            <logic:empty name="L_PPI">
                                                                <html:option styleClass="periodo ppi" value="0">Fail.</html:option>
                                                            </logic:empty>
                                                            <logic:notEmpty name="L_PPI">
                                                                <logic:iterate id="ppi" name="L_PPI">
                                                                    <html:option styleClass="periodo ppi" value="${ppi.idPeriodoPasantiaIntermedia}">${ppi.nombre}</html:option>
                                                                </logic:iterate>
                                                            </logic:notEmpty>
                                                            <%-- periodos pasantia corta --%>
                                                            <html:option styleClass="periodo ppc" value="0">Julio-Septiembre</html:option>
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
                                                        <html:select property="status">
                                                            <html:option value="-1"> Todos </html:option>
                                                            <logic:iterate id="stats" collection="${empty Estatus ? _vacio : Estatus}">
                                                                <html:option value="${stats.idEstatusPasantia}"> ${stats.estatus}</html:option>
                                                            </logic:iterate>
                                                        </html:select>
                                                    </td>
                                                    <td>
                                                        <html:submit styleClass="button">Buscar</html:submit>
                                                    </td>
                                                </tr>


                                            </table>
                                        </html:form>

                                        <%-- Resultados de la Búsqueda --%>

                                        <logic:empty name="Pasantias">
                                            <h1>¡No hay estudiantes haciendo pasantías según los criterios de búsqueda seleccionados!</h1>
                                        </logic:empty>
                                        <logic:notEmpty name="Pasantias">
                                            <div class="administrador">
                                                <table width="500px" class="sortable">
                                                    <thead>
                                                        <tr><th align="center">Título</th><th align="center">Resumen</th></tr>
                                                    </thead>
                                                    <tbody>
                                                        <logic:iterate id="pas" collection="${empty Pasantias ? _vacio : Pasantias}">

                                                            <tr onclick="location.href='/sistppg70/A_mostrar_pasantia.do?idPasantia=${pas.idPasantia}<logic:notEmpty name="idJurado">&idJuradoA=<%= request.getParameter("idJurado") %></logic:notEmpty>'" onmouseover="this.style.cursor='pointer'">

                                                                <td>${pas.titulo}</td>
                                                                <td>${pas.resumen}</td>
                                                            </tr>
                                                        </logic:iterate>
                                                    </tbody>
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