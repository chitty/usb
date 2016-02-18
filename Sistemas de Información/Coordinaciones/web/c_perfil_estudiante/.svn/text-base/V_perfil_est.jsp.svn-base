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
                                    <center><h3>${empty msg ? "" : msg}</h3></center>
                                    <br>
                                    <div class="box1465928" align="center">

                                        <html:form styleId="perfilEForm"
                                                   action="/A_guardar_perfil.do" method="post">
                                            <table border="0">
                                                <tr><td><p id="1840398_C"><label for="1840398"><bean:message key="F_Perfil_Estudiante.label0"/><%-- Nombre: --%></label></td><td><html:text styleId="1840398" property="nombre" size="30" value="${Datos.nombre}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840402_C"><label for="1840402"><bean:message key="F_Perfil_Estudiante.label1"/><%-- Apellido: --%></label></td><td><html:text styleId="1840402" property="apellido" size="30" value="${Datos.apellido}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840405_C"><label for="1840405"><bean:message key="F_Perfil_Estudiante.label2"/><%-- Cedula: --%></label></td><td><html:text styleId="1840405" property="cedula" size="30" value="${Datos.cedula}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840408_C"><label for="1840408"><bean:message key="F_Perfil_Estudiante.label3"/><%-- Email: --%></label></td><td><html:text styleId="1840408" property="email" size="30" value="${Datos.email}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840459_C"><label for="1840459"><bean:message key="F_Perfil_Estudiante.label4"/><%-- Telefono: --%></label></td><td><html:text styleId="1840459" property="telefono" size="30" value="${Datos.telefono}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840459_C"><label for="1840459">Otro teléfono:</label></td><td><html:text styleId="1840459" property="otrotelefono" size="30" value="${Datos.otrotelefono}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840459_C"><label for="18404591">Direccion:</label></td><td><html:textarea styleId="18404591" property="direccion" cols="30" rows="5" value="${Datos.direccion}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840459_C"><label for="18404592">Sexo: </label></td><td>
                                                <html:select styleId="18404592" property="sexo" value="${Datos.sexo}">
                                                    <option value="masculino" >Masculino</option>
                                                    <option value="femenino">Femenino</option>
                                                </html:select></td></tr>
                                                <tr><td><p id="1840459_C"><label for="18404593">Nacionalidad(pais):</label></td><td><html:text property="nacionalidad" size="30" value="${Datos.nacionalidad}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1840459_C"><label for="18404594">Indice:</label></td><td><html:text styleId="1840459" property="indice" size="5" value="${Datos.indice}" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1843493_C"><label for="1843493"><bean:message key="F_Perfil_Estudiante.label5"/><%-- Carrera: --%></label></td><td>
                                                        <html:select styleId="1843493" property="carrera" value="${Datos.carrera}">
                                                            <logic:iterate id="carrera" collection="${empty L_Carreras ? _vacio : L_Carreras}">
                                                        <option value="${carrera.idCarrera}">${carrera.nombre}</option>
                                                    </logic:iterate>
                                                </html:select></td></tr></td></tr>
                                                <tr><td><p id="1843588_C"><label for="1843588"><bean:message key="F_Perfil_Estudiante.label6" /><%-- Fecha Nacimiento: --%></label></td><td><html:text styleId="1843588" property="fecha_nacimiento" size="30" styleClass="validate[required]"/></td></tr>
                                                <tr><td><p id="1843591_C"><label for="1843591"><bean:message key="F_Perfil_Estudiante.label7"/><%-- Estado Civil --%></label></td><td>
                                                <html:select styleId="1843591" property="estadoCivil" value="${Datos.edocivil}">
                                                    <option value="Soltero"> Soltero </option>
                                                    <option value="Casado"> Casado </option>
                                                    <option value="Divorciado"> Divorciado </option>
                                                    <option value="Viudo"> Viudo </option>
                                                </html:select>
                                                </td></tr>
                                            </table>
                                            <center><html:submit styleClass="button"><bean:message key="V_perfil_est.label0"/><%-- CrearPerfilEst --%></html:submit></center>
                                        </html:form>
                                        <script>
                                            $(document).ready(function(){
                                                $("#perfilEForm").validationEngine('attach');
                                            });
                                        </script>

                                        <p><bean:message key="V_Obligatorios.msg0"/>


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