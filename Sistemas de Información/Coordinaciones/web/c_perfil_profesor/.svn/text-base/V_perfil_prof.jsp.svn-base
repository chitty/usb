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
                                    <center><h3>Crear Perfil de Profesor</h3></center>
                                    <br>
                                    <div class="box1465928" align="center">
                                        <html:form
                                            action="/A_guardar_perfil_prof.do" method="post">
                                            <table border="0">
                                                <tr><td><p id="1840413_C"><label for="1840413"><bean:message key="F_Perfil_Profesor.label0"/><%-- Nombre: --%></label></td><td><html:text styleId="1840413" property="nombre" size="30" value="${Datos.nombre}"/></td></tr>
                                                <tr><td><p id="1840416_C"><label for="1840416"><bean:message key="F_Perfil_Profesor.label1"/><%-- Apellido: --%></label></td><td><html:text styleId="1840416" property="apellido" size="30" value="${Datos.apellido}"/></td></tr>
                                                <tr><td><p id="1840419_C"><label for="1840419"><bean:message key="F_Perfil_Profesor.label2"/><%-- Cedula: --%></label></td><td><html:text styleId="1840419" property="cedula" size="30" value="${Datos.cedula}"/></td></tr>
                                                <tr><td><p id="1840423_C"><label for="1840423"><bean:message key="F_Perfil_Profesor.label3"/><%-- Email: --%></label></td><td><html:text styleId="1840423" property="email" size="30" value="${Datos.email}"/></td></tr>
                                                <tr><td><p id="1840426_C"><label for="1840426"><bean:message key="F_Perfil_Profesor.label4"/><%-- Departamento: --%></label></td><td>

                                                        <html:select styleId="1840426" property="departamento">
                                                            <logic:iterate id="departamento" collection="${empty L_Departamentos ? _vacio : L_Departamentos}">
                                                        <option value="${departamento.idDepartamento}">${departamento.nombre}</option>
                                                    </logic:iterate>
                                                </html:select></td></tr>
                                            </table>
                                            </p>
                                            <html:submit styleClass="button"><bean:message key="V_perfil_prof.label0"/><%-- Crear --%></html:submit>
                                            <p><bean:message key="V_Obligatorios.msg0"/>
                                            </html:form>


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