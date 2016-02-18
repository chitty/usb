<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
%><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
%><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
%><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
%><%@ page contentType="text/html;charset=ISO-8859-1"
%><html:html>
    <head>
        <title><bean:message key="V_Sesion_Empresa.title"/></title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
        <script src="_js/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="_js/insc-pasant.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">
                    <li><cohesion:actor actors="11"><html:link action="/A_consultar_pasantias.do"><bean:message key="V_consulta_pasantia.label0"/><%-- ordenar --%></html:link></cohesion:actor></li>
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
                            <html:form action="/A_consultar_pasantias.do" method="post">
                                <table>
                                    <tr><th>Criterios de Búsqueda</th><td></td></tr>
                                    <tr><td>Carrera: </td>
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
                                        </td></tr>

                                    <tr><td>Tipo: </td>
                                        <td>
                                    <html:select property="tipo" styleId="1843570">
                                        <html:option value="all"> Todos</html:option>
                                        <html:option styleId="l" value="larga"> Pasantía Larga</html:option>
                                        <html:option styleId="i" value="intermedia"> Pasantía Intermedia</html:option>
                                        <html:option styleId="c" value="corta"> Pasantía Corta</html:option>
                                    </html:select>
                                        </td>
                                    </tr>

                                    <tr><td>
                                        <label for="18435702">Periodo:</label>
                                        </td><td>
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
                                    </tr>

                                    <tr><td>Año: </td>
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
                                        </td></tr>

                                    <tr><td>Estatus: </td>
                                        <td>
                                    <html:select property="status">
                                        <html:option value="-1"> Todos </html:option>
                                        <logic:iterate id="stats" collection="${empty Estatus ? _vacio : Estatus}">
                                            <html:option value="${stats.idEstatusPasantia}"> ${stats.estatus}</html:option>
                                        </logic:iterate>
                                    </html:select>
                                        </td></tr>

                            <tr><td></td><td><html:submit styleClass="button">Buscar</html:submit></td></tr>
                                </table>
                            </html:form>


                            <logic:empty name="Pasantias">
                                <h1>¡No hay estudiantes haciendo pasantías!</h1>
                            </logic:empty>
                            <logic:notEmpty name="Pasantias">
                                <h1>Pasantías: </h1>
                                <table border="1">
                                    <tr><th>Título</th><th>Resumen</th></tr>
                                <logic:iterate id="pas" collection="${empty Pasantias ? _vacio : Pasantias}">
                                       <tr><td><html:link action="/A_mostrar_pasantia.do" paramName="pas" paramProperty="idPasantia" paramId="idPasantia">${pas.titulo}</html:link></td>
                                        <td> ${pas.resumen} </td>
                                    </tr>
                                </logic:iterate>
                                </table>
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
        <div id="footer"> <bean:message key="bottom.label"/> </div>

    </body>
</html:html>