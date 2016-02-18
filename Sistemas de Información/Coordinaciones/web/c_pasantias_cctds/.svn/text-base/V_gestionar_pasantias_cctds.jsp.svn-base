<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
%><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
%><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
%><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
%><%@ page contentType="text/html;charset=ISO-8859-1"
%><html:html>
    <head>
        <title><bean:message key="V_gestionar_pasantias_cctds.title"/></title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script type="text/javascript" src="../_tooltips/js/prototype.js"></script>
        <script type="text/javascript" src="../_tooltips/js/HelpBalloon.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">
                    <li><html:link action="/A_consultar_resagados.do"><bean:message key="V_gestionar_pasantias_cctds.label0"/><%-- Consultar Rezagados --%></html:link></li>
                    <li><cohesion:actor actors="1"><html:link action="/A_consultar_pasantias_cctds.do"><bean:message key="V_gestionar_pasantias_cctds.label1"/><%-- Consulta de Pasantias --%></html:link></cohesion:actor></li>
                    <li><cohesion:actor actors="1"><html:link action="/A_prep_sesion_ccds.do">Home</html:link></cohesion:actor></li>
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
                                    <h1>Pasantias Cortas</h1>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th>Estudiante</th>
                                                <tH>Titulo</tH>
                                                <tH>Tutor Academico</tH>
                                                <tH>Tutor Industrial</tH>
                                                <tH>Estatus</tH>
                                            </tr>
                                        </thead>
                                            <logic:notEmpty name="L_pc">
                                            <tbody>
                                                <logic:iterate id="obj" name="L_pc">
                                                    <tr>
                                                        <td>${obj[0]}</td>
                                                        <td>${obj[1]}</td>
                                                        <td>${obj[2]}</td>
                                                        <td>${obj[3]}</td>
                                                        <td>${obj[4]}</td>
                                                    </tr>
                                                </logic:iterate>
                                            </tbody>
                                            </logic:notEmpty>
                                        
                                    </table>
                                    <br>
                                    <br>

                                    <h1>Pasantias Intermedias</h1>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th>Estudiante</th>
                                                <tH>Titulo</tH>
                                                <tH>Tutor Academico</tH>
                                                <tH>Tutor Industrial</tH>
                                                <tH>Estatus</tH>
                                            </tr>
                                        </thead>
                                            <logic:notEmpty name="L_pi">
                                            <tbody>
                                                <logic:iterate id="obj" name="L_pi">
                                                    <tr>
                                                        <td>${obj[0]}</td>
                                                        <td>${obj[1]}</td>
                                                        <td>${obj[2]}</td>
                                                        <td>${obj[3]}</td>
                                                        <td>${obj[4]}</td>
                                                    </tr>
                                                </logic:iterate>
                                            </tbody>
                                            </logic:notEmpty>

                                    </table>

                                    <br>
                                    <br>
                                    <h1>Pasantias Largas</h1>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th>Estudiante</th>
                                                <tH>Titulo</tH>
                                                <tH>Tutor Academico</tH>
                                                <tH>Tutor Industrial</tH>
                                                <tH>Estatus</tH>
                                            </tr>
                                        </thead>
                                            <logic:notEmpty name="L_pl">
                                            <tbody>
                                                <logic:iterate id="obj" name="L_pl">
                                                    <tr>
                                                        <td>${obj[0]}</td>
                                                        <td>${obj[1]}</td>
                                                        <td>${obj[2]}</td>
                                                        <td>${obj[3]}</td>
                                                        <td>${obj[4]}</td>
                                                    </tr>
                                                </logic:iterate>
                                            </tbody>
                                            </logic:notEmpty>

                                    </table>
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
