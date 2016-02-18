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


                                        <logic:notEmpty name="Datos">
                                            <center>

                                                <h2>
                                                    Estatus de Prórrogas
                                                </h2><hr>
                                                <div class="administrador">
                                                    <table class="sortable" width="400px">
                                                        <thead>
                                                            <tr>
                                                                <th width="250px">
                                                                    <center>
                                                                        Estatus
                                                                    </center>
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <logic:iterate id="dato" collection="${empty Datos ? _vacio : Datos}">

                                                                <tr onclick="location.href='/sistppg70/A_Prep_Gestionar_Estatus_Prorrogas.do?idEstatus_Prorroga=${dato.idEstatusProrroga}'" onmouseover="this.style.cursor='pointer'">

                                                                    <td>
                                                                        <center>
                                                                            ${dato.estatus}
                                                                        </center>
                                                                    </td>
                                                                </tr>

                                                            </logic:iterate>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </center>
                                        </logic:notEmpty>

                                        <p><p><p>

                                            <logic:notEmpty name="Singular">
                                            <hr>
                                            <html:form
                                                action="/A_insertar_estatus_prorroga.do" method="post">
                                                <table border="0">
                                                    <tr><td>estatus</td><td><html:text styleId="1840413" property="estatus" size="30" value="${Singular.estatus}"/></td></tr>
                                                    <html:hidden property="idEstatusProrroga" value="${Singular.idEstatusProrroga}"/>


                                                    <tr><td><html:link action="/A_eliminar_estatus_prorroga.do" onclick="return confirm('¿Esta seguro de que desea borrar el registro?')" >Eliminar</html:link></td><td><html:submit styleClass="button">Modificar<%-- Crear --%></html:submit><p>
                                                        </td></tr>
                                                </table>
                                                <p><bean:message key="V_Obligatorios.msg0"/>
                                                </html:form>




                                            </logic:notEmpty>


                                            <logic:empty name="Agregar">
                                                <bean:define id="Agregare" value="Agregare"/>
                                            <table><th>
                                                    <html:link action="/A_Prep_Gestionar_Estatus_Prorrogas.do" paramName="Agregare"
                                                               paramId="Agregar">Agregar Estatus_Prorroga</html:link>
                                                </th></table>

                                        </logic:empty>

                                        <logic:notEmpty name="Agregar">
                                            <hr>
                                            <html:form
                                                action="/A_insertar_estatus_prorroga.do" method="post">
                                                <table border="0">
                                                    <tr><td>estatus</td><td><html:text styleId="1840413" property="estatus" size="30" value=""/></td></tr>
                                                    <html:hidden property="idEstatusProrroga" value=""/>


                                                    <tr><td></td><td><html:submit styleClass="button">Insertar<%-- Crear --%></html:submit><p>
                                                        </td></tr>
                                                </table>
                                                <p><bean:message key="V_Obligatorios.msg0"/>
                                                </html:form>
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