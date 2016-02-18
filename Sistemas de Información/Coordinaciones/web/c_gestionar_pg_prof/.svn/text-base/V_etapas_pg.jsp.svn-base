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


                    <logic:equal value="0" name="netapa"> <li><cohesion:actor actors="8"><html:link action="/A_prep_agregar_primera_etapa.do"><bean:message key="V_etapas_pg.label0"/><%-- Primera Etapa --%></html:link></cohesion:actor></li> </logic:equal>
                    <logic:equal value="1" name="netapa"> <li><cohesion:actor actors="8"><html:link action="/A_prep_agregar_segunda_etapa.do"><bean:message key="V_etapas_pg.label1"/><%-- Segunda Etapa --%></html:link></cohesion:actor></li> </logic:equal>
                    <logic:equal value="2" name="netapa"> <li><cohesion:actor actors="8"><html:link action="/A_prep_agregar_tercera_etapa.do"><bean:message key="V_etapas_pg.label2"/><%-- Tercera Etapa --%></html:link></cohesion:actor></li> </logic:equal>
                    <logic:equal value="3" name="netapa"> <li><cohesion:actor actors="8"><html:link action="/A_finalizar_generar_PG.do"><bean:message key="V_etapas_pg.label3"/><%-- Finalizar Proceso --%></html:link></cohesion:actor></li> </logic:equal>




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


                            <div id="etapasimg">
                                <logic:lessEqual value="2" name="netapa"><img src="../css/images/pg-e${netapa+1}.png"></logic:lessEqual>
                                <logic:greaterThan value="2" name="netapa"><h2>Proceso Finalizado</h2></logic:greaterThan>
                            </div>
                            <%--${empty msg ? "" : msg}<br><br>--%>
                            <br><br><br>
                            <div class="pgInfo">
                                <table id="pgInfo">
                                    <tr>
                                        <td id="titulo">Nombre PG:</td>
                                        <td>${pg.nombre}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Recursos:</td>
                                        <td>${pg.recursos}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Duracion de recursos:</td>
                                        <td>${pg.duracion_recursos}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Puntos de interes:</td>
                                        <td>${pg.puntos_de_interes}</td>
                                    </tr>
                                    <tr>
                                        <td id="titulo">Areas:</td>
                                        <logic:notEmpty name="L_Areas_PG">
                                            <td></td>
                                            </tr>
                                            <logic:iterate id="apg" name="L_Areas_PG">
                                            <tr><td></td><td>${apg.nombre}</td></tr>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                        <logic:empty name="L_Areas_PG">
                                            <td>No ha seleccionado areas</td>
                                        </tr>
                                        </logic:empty>

                                </table>
                            </div>
                                    <br>

                                <div class="tablaEtapas">
                                    <div class="etapasPG" id="etapa1">
                                        <h1>Etapa1</h1>
                                        <table id="etapa1" border="0">
                                            <tr>
                                                <td id="titulo">Nombre:</td>
                                                <td id="contenido">${etapa1.etapa.nombre}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Resultados Minimos:</td>
                                                <td id="contenido">${etapa1.etapa.resultados_minimos}</td>
                                            </tr>
                                            
                                                <logic:notEmpty name="L_etapa1">
                                                    <logic:iterate id="a" name="L_etapa1">
                                                        <tr>
                                                            <td id="actividad">Actividad:</td>
                                                            <td id="contenido">${a.descripcion}</td>
                                                        </tr>
                                                    </logic:iterate>
                                                </logic:notEmpty>
                                            
                                        </table>
                                    </div>

                                    <div class="etapasPG" id="etapa2">
                                        <h1>Etapa2</h1>
                                        <table id="etapa1" border="0">
                                            <tr>
                                                <td id="titulo">Nombre:</td>
                                                <td id="contenido">${etapa2.etapa.nombre}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Resultados Minimos:</td>
                                                <td id="contenido">${etapa2.etapa.resultados_minimos}</td>
                                            </tr>
                                            
                                                <logic:notEmpty name="L_etapa2">
                                                    <logic:iterate id="a" name="L_etapa2">
                                                        <tr>
                                                            <td id="actividad">Actividad:</td>
                                                            <td id="contenido">${a.descripcion}</td>
                                                        </tr>
                                                    </logic:iterate>
                                                </logic:notEmpty>
                                            
                                        </table>
                                    </div>

                                    <div class="etapasPG" id="etapa3">
                                        <h1>Etapa3</h1>
                                        <table id="etapa1" border="0">
                                            <tr>
                                                <td id="titulo">Nombre:</td>
                                                <td id="contenido">${etapa3.etapa.nombre}</td>
                                            </tr>
                                            <tr>
                                                <td id="titulo">Resultados Minimos:</td>
                                                <td id="contenido">${etapa3.etapa.resultados_minimos}</td>
                                            </tr>
                                            
                                                <logic:notEmpty name="L_etapa3">
                                                    <logic:iterate id="a" name="L_etapa3">
                                                        <tr>
                                                            <td id="actividad">Actividad:</td>
                                                            <td id="contenido">${a.descripcion}</td>
                                                        </tr>
                                                        </logic:iterate>
                                                </logic:notEmpty>

                                        </table>
                                    </div>
                                 </div>
                                    


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