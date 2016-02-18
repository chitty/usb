<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"
           %><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"
           %><%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"
           %><%@ taglib tagdir="/WEB-INF/tags" prefix="cohesion"
           %><%@ page contentType="text/html;charset=ISO-8859-1"
           %><html:html>
    <head>
        <title>Gestionar Areas</title>


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
                                                    Areas
                                                </h2><hr>
                                                <div class="administrador">
                                                    <table class="sortable">
                                                        <thead>
                                                            <tr>
                                                                <th>
                                                                    <center>
                                                                        Nombre
                                                                    </center>
                                                                </th>
                                                                <th>
                                                                    <center>
                                                                        Departamento
                                                                    </center>
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <logic:iterate id="dato" collection="${empty Datos ? _vacio : Datos}">

                                                                <bean:write name="dato" filter="false"/>


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
                                                    action="/A_insertar_area.do" method="post">
                                                <table border="0">
                                                    <tr><td><p id="1840413_C">Nombre</td><td><html:text styleId="1840413" property="area" size="30" value="${Singular.nombre}"/></td></tr></p>
                                                    <tr><td><p>Departamento</td><td>
                                                            <html:select styleId="1843493" property="departamento" value="${AreaD.idDepartamento}">
                                                                <logic:iterate id="arrea" collection="${empty L_Areas ? _vacio : L_Areas}">
                                                            <option value="${arrea.idDepartamento}">${arrea.nombre}</option>
                                                        </logic:iterate>
                                                    </html:select>
                                                    </td></tr>

                                                    <html:hidden property="idArea" value="${Singular.idArea}"/>

                                                    <tr><td><html:link action="/A_eliminar_area.do" onclick="return confirm('¿Esta seguro de que desea borrar el registro?')" >Eliminar</html:link></td><td><html:submit styleClass="button">Modificar<%-- Crear --%></html:submit><p>
                                                        </td></tr>
                                                </table>
                                                <p><bean:message key="V_Obligatorios.msg0"/>
                                                </html:form>









                                            </logic:notEmpty>


                                            <logic:empty name="Agregar">
                                                <bean:define id="Agregare" value="Agregare"/>
                                            <table><th>
                                                    <html:link action="/A_Prep_Gestionar_Areas.do" paramName="Agregare"
                                                               paramId="Agregar">Agregar Area</html:link>
                                                </th></table>

                                        </logic:empty>

                                        <logic:notEmpty name="Agregar">
                                        <hr>
                                            <html:form
                                                action="/A_insertar_area.do" method="post">
                                                <table border="0">
                                                    <tr><td><p id="1840413_C">Nombre</td><td><html:text styleId="1840413" property="area" size="30" value=""/></td></tr></p>
                                                    <tr><td><p>Departamento</td><td>
                                                            <html:select styleId="1843493" property="departamento" value="">
                                                                <logic:iterate id="arrea" collection="${empty L_Areas ? _vacio : L_Areas}">
                                                            <option value="${arrea.idDepartamento}">${arrea.nombre}</option>
                                                        </logic:iterate>
                                                    </html:select>
                                                    </td></tr>
                                                <html:hidden property="idArea" value=""/>


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