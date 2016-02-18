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
    </head>
    <body>
        <div id="wrapper">
            <div id="menu">
                <ul id="nav">
              <li><html:link action="/A_prep_agregar_tutor_I.do">Agregar Tutor Industrial</html:link></li>
                    <li><html:link action="/A_Prep_gestionar_solicitud_pasantes.do"><bean:message key="V_Sesion_Empresa.label1"/><%-- Solicitud de pasantes --%></html:link></li>
               </ul>
               <p align="right"><html:link action="/A_Prep_Inicio_Sesion.do">Cerrar Sesión</html:link></p>
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
                            <div class="box1840560"><html:form
                                    action="/A_Agregar_Tutor_Ind.do" method="post">
                                    <table borde="0">
                                        <tr><td><p id="1840562_C"><label for="1840562"><bean:message key="F_Tutor_Industrial.label0"/><%-- Nombre: --%></label></td><td><html:text styleId="1840562" property="nombre" size="30"/></td></tr>
                                        <tr><td><p id="1840565_C"><label for="1840565"><bean:message key="F_Tutor_Industrial.label1"/><%-- Email: --%></label></td><td><html:text styleId="1840565" property="email" size="30"/></td></tr>
                                        <tr><td><p id="1840569_C"><label for="1840569"><bean:message key="F_Tutor_Industrial.label2"/><%-- Cedula: --%></label></td><td><html:text styleId="1840569" property="cedula" size="30"/></td></tr>
                                        <tr><td><p id="1840572_C"><label for="1840572"><bean:message key="F_Tutor_Industrial.label3"/><%-- Telefono: --%></label></td><td><html:text styleId="1840572" property="telefono" size="30"/></td></tr>
                                        <tr><td><p id="1844840_C"><label for="1844840"><bean:message key="F_Tutor_Industrial.label4"/><%-- Profesi&oacute;n: --%></label></td><td><html:text styleId="1844840" property="profesion" size="30"/></td></tr>
                                        <tr><td><p id="1844843_C"><label for="1844843"><bean:message key="F_Tutor_Industrial.label5"/><%-- Direccion: --%></label></td><td><html:textarea styleId="1844843" property="direccion" cols="30" rows="10"></html:textarea></td></tr>
                                        <tr><td><p id="1844837_C"><label for="1844837"><bean:message key="F_Tutor_Industrial.label7"/><%-- Departamento: --%></label></td><td><html:text styleId="1844837" property="departamento" size="30"/></td></tr>
                                        <tr><td><p id="1844848_C"><label for="1844848"><bean:message key="F_Tutor_Industrial.label8"/><%-- Cargo: --%></label></td><td><html:text styleId="1844848" property="cargo" size="30"/></td></tr>
                                        <tr><td><p id="1844834_C"><label for="1844834"><bean:message key="F_Tutor_Industrial.label9"/><%-- Login de sesion: --%></label></td><td><html:text styleId="1844834" property="login" size="30"/></td></tr>
                                        <tr><td><p id="1844823_C"><label for="1844823"><bean:message key="F_Tutor_Industrial.label10"/><%-- Password de sesion: --%></label></td><td><html:password styleId="1844823" property="password" size="30"/></td></tr>
                                        <tr><td></td><td><html:submit styleClass="button"><bean:message key="V_Agregar_Tutor_I.label0"/><%-- Agregar Tutor --%></html:submit></td></tr>
                                    </table>
                                    <p><center><bean:message key="V_Obligatorios.msg0"/></center>
                                </html:form></div>
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