<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title><bean:message key="V_Inicio_Sesion.title"/></title>


        <html:base/>

        <link rel="stylesheet" type="text/css" href="../css/style.css"></link>

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
            </div>



            <div id="header">
                <%-- NO ESTOY SEGURO DE QUE VA AQUI PERO SE VE FEO Y QUEDA SOBRE LA IMAGEN --%>
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
                                                    Periodos de Pasantías Largas
                                                </h2><hr>
                                                <dic class="administrador">

                                                    <table class="sortable" width="400x">
                                                        <thead>
                                                            <tr>
                                                                <th width="250px">
                                                                    <center>
                                                                        Nombre
                                                                    </center>
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                           <logic:iterate id="dato" collection="${empty Datos ? _vacio : Datos}">

                                                                <tr onclick="location.href='/sistppg70/A_Prep_Gestionar_Periodo_Pasantia_Largas.do?idPeriodoPasantiaLarga=${dato.idPeriodoPasantiaLarga}'" onmouseover="this.style.cursor='pointer'">

                                                                    <td>
                                                                        <center>
                                                                            ${dato.nombre}
                                                                        </center
                                                                    </td>
                                                                </tr>

                                                        </logic:iterate>
                                                        </tbody>
                                                    </table>

                                                    </div>
                                                </logic:notEmpty>

                                                <p><p><p>
                                                <center>
                                                    <logic:notEmpty name="Singular">
                                                        <hr>
                                                        <html:form
                                                            action="/A_insertar_periodo_pasantia_larga.do" method="post">
                                                            <table border="0">
                                                                <tr><td><p id="1840413_C">Nombre</td><td><html:text styleId="1840413" property="periodoPasantiaLarga" size="30" value="${Singular.nombre}"/></td></tr></p>
                                                                <html:hidden property="idPeriodoPasantiaLarga" value="${Singular.idPeriodoPasantiaLarga}"/>


                                                                <tr><td><html:link action="/A_eliminar_periodo_pasantia_larga.do" onclick="return confirm('¿Esta seguro de que desea borrar el registro?')" >Eliminar</html:link></td><td><html:submit styleClass="button">Modificar<%-- Crear --%></html:submit><p>
                                                                    </td></tr>
                                                            </table>
                                                            <p><bean:message key="V_Obligatorios.msg0"/>
                                                            </html:form>
                                                    </center>








                                                </logic:notEmpty>
                                                <center>

                                                    <logic:empty name="Agregar">
                                                        <bean:define id="Agregare" value="Agregare"/>
                                                        <table><th>
                                                                <html:link action="/A_Prep_Gestionar_Periodo_Pasantia_Largas.do" paramName="Agregare"
                                                                           paramId="Agregar">Agregar PeriodoPasantiaLarga</html:link>
                                                            </th></table>

                                                    </logic:empty>

                                                    <logic:notEmpty name="Agregar">
                                                        <hr>
                                                        <html:form
                                                            action="/A_insertar_periodo_pasantia_larga.do" method="post">
                                                            <table border="0">
                                                                <tr><td><p id="1840413_C">Nombre</td><td><html:text styleId="1840413" property="periodoPasantiaLarga" size="30" value=""/></td></tr></p>
                                                                <html:hidden property="idPeriodoPasantiaLarga" value=""/>


                                                                <tr><td></td><td><html:submit styleClass="button">Insertar<%-- Crear --%></html:submit><p>
                                                                    </td></tr>
                                                            </table>
                                                            <p><bean:message key="V_Obligatorios.msg0"/>
                                                            </html:form>
                                                        </logic:notEmpty>

                                                </center>
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