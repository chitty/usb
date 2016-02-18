<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
%><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
%><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
%><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
%><%@ page contentType="text/html;charset=ISO-8859-1"
%><html:html>
    <head>
        <title><bean:message key="V_areas.title"/></title>
        <link rel="stylesheet" type="text/css" href="_css/style.css"/>
        <style type="text/css">
        div#box1840605 {width: 400px; margin: 40px auto; }
        form#1840605 {float: left; margin: 0; padding: 0; display: inline; width: 400px; }
        form#1840605 p {float: left; margin: 0; padding: 0; display: inline; }
        form#1840605 label {float: left; margin: 0; padding: 0; display: inline; overflow: hidden; }
        form#1840605 input {float: left; margin: 0; padding: 0; display: inline; }
          form#1840605 p#1840607_C {clear: both; width: 400px; }
          form#1840605 p#1840607_C label {clear: both; width: 400px; }
          form#1840605 p#1840607_C input {clear: both; width: 396px; }

        </style>

    </head>
    <body>
        <div id="header">
            <div id="title"><bean:message key="V_areas.title"/></div>
            <div id="menu">
                <ul id="nav">
                    <li><cohesion:actor actors="4"><html:link action="/A_guardar_areas.do"><bean:message key="V_areas.label1"/><%-- Especificar Fases --%></html:link></cohesion:actor></li>

                </ul>
            </div>
        </div>
        <div id="body_wrapper">
            <div id="body">
                <div id="split">
                    <div class="top"></div>
                    <div id="left">
                        <div class="content">
                            <center><h3>Inscripción de Pasantía</h3></center>
                            ${empty msg ? "" : msg}
                            <br><br>

                             <div class="pgInfo">
                                <table id="pgInfo">
                                    <tr>
                                        <td id="titulo">Titulo:</td>
                                        <td>${pasantia.titulo}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Tutor Academico:</td>
                                        <td>${pasantia.tutor_academico.nombre}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Tutor Industrial:</td>
                                        <td>${pasantia.tutor_industrial.nombre}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Objetivos:</td>
                                        <td>${pasantia.objetivos_generales}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Resumen:</td>
                                        <td>${pasantia.resumen}</td>
                                    </tr><%--
                                    <tr>
                                        <td id="titulo">Areas:</td>
                                        <logic:notEmpty name="L_Areas_Pas">
                                            <td></td>
                                            </tr>
                                            <logic:iterate id="apas" name="L_Areas_Pas">
                                            <tr><td></td><td>${apas.nombre}</td></tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                        <logic:empty name="L_Areas_Pas">
                                            <td>No ha seleccionado areas</td>
                                        </tr>
                                        </logic:empty>
--%>
                                </table>
                            </div>

                <div class="box1840605"><html:form
                  action="/A_agregar_area.do" method="post">
                  <p id="1840607_C"><label for="1840607"><bean:message key="F_Area.label0"/><%-- Area: --%></label>
                      <html:select styleId="1840607" property="area">
                            <logic:iterate id="area" collection="${empty L_Areas ? _vacio : L_Areas}">
                                <option value="${area.idArea}">${area.nombre}</option>
                            </logic:iterate>
                          </html:select></p>
                  <html:submit styleClass="button"><bean:message key="V_areas.label0"/><%-- Agregar Area --%></html:submit>
                </html:form></div>

                         </div>
                    </div>
                    <div id="right"></div>
                    <div class="clearer"></div>
                    <div class="bottom"></div>
                </div>
                <div class="clearer"></div>
            </div>
            <div class="clearer"></div>
        </div>
        <div id="end_body"></div>
        <div id="footer"> <bean:message key="bottom.label"/> </div>

    </body>
</html:html>