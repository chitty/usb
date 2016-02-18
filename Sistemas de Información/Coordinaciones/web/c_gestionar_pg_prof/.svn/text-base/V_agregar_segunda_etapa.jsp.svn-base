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
                                    <center><h1>${empty msg ? "" : msg}</h1></center><hr>
                                    <div class="box1465928" align="center">

                                        <html:form styleId="etapa2Form"
                                                   action="/A_guardar_segunda_etapa.do" method="post">
                                            <table border="0">

                                                <tr><th><p id="1840610_C"><label for="1840610"><bean:message key="F_Etapa_PG.label0"/></label></th><td><html:text styleClass="validate[required]" styleId="1840610" property="nombre" size="30"/></td></tr></p>
                                            <tr><th><p id="1840613_C"><label for="1840613"><bean:message key="F_Etapa_PG.label1"/></label></th><td><html:textarea styleClass="validate[required]" styleId="1840613" property="resultados_minimos" cols="60" rows="10"></html:textarea></td></tr></p>
                                            <tr><th><p id="18406131_C">Descripcion Topicos:</th><td><html:textarea styleClass="validate[required]" styleId="18406131" property="topicos" cols="60" rows="10"></html:textarea></td></tr></p>

                                            </table>
                                            <p id="1840616_C"><label for="1840616">
                                                    <html:select styleId="18405891" property="trimestre">
                                                        <logic:iterate id="trim" collection="${empty L_Trim ? _vacio : L_Trim}">
                                                            <option value="${trim.idTrimestre}">${trim.nombre}</option>
                                                        </logic:iterate>
                                                    </html:select></p>
                                            <p id="1840620_C"><label for="1840620"><bean:message key="F_Etapa_PG.label3"/><%-- A&ntilde;o: --%></label><html:text styleId="1840620" property="ano" size="30"/></p>
                                            <hr>
                                            <html:submit styleClass="button"><bean:message key="V_agregar_segunda_etapa.label0"/><%-- Continuar --%></html:submit>

                                        </html:form>
                                        <script>
                                            $(document).ready(function(){
                                                $("#etapa2Form").validationEngine('attach');
                                            });
                                        </script>


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