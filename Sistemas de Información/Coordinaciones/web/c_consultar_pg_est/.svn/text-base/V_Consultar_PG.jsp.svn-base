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


                                        <table width="500px">
                                                <tr><th>Proyecto de Grado</th></tr>
                                            </table>
                                            <hr><p></p>
                                        <table border="0" width="500px">
                                            <tr>
                                                <th width="200px">Nombre</th>
                                                <td>${Proyecto.nombre}</td>
                                            </tr>
                                            <tr>
                                                <th>Código</th>
                                                <td>${Proyecto.codigo}</td>
                                            </tr>
                                            <tr>
                                                <th>Recursos</th>
                                                <td>${Proyecto.recursos}</td>
                                            </tr>
                                            <tr>
                                                <th>Duración Recursos</th>
                                                <td>${Proyecto.duracion_recursos}</td>
                                            </tr>
                                            <tr>
                                                <th>Puntos de Interés</th>
                                                <td>${Proyecto.puntos_de_interes}</td>
                                            </tr>
                                            <tr>
                                                <th>Áreas</th>
                                            </tr>

                                            <logic:iterate id="element" name="Area" >
                                                <tr> <td></td><td><bean:write name="element" /></td></tr>
                                            </logic:iterate>


                                        </table>
                                        <p>
                                        </p>
                                        <hr>
                                        <p>
                                        </p>
                                        <table width="500px">
                                            <tr><th>Tutor Académico</th></tr>
                                        </table>
                                        <hr>
                                        <p></p>
                                        <table border="0" width="500px">
                                            <tr>
                                                <th width="200px">Nombre</th>
                                                <td>${Tutor.nombre}</td>
                                            </tr>
                                            <tr>
                                                <th>Apellido</th>
                                                <td>${Tutor.apellido}</td>
                                            </tr>
                                            <tr>
                                                <th>Email</th>
                                                <td>${Tutor.email}</td>
                                            </tr>
                                        </table>
                                        <p>
                                        </p>
                                        <logic:notEmpty name="Etapa1">
                                            <hr><p></p>
                                            <table width="500px">
                                                <tr><th>Etapa 1</th></tr>
                                            </table>
                                            <hr><p></p>
                                            <p>
                                            </p>
                                            
                                            <table border="0" width="500px">
                                                <tr>
                                                    <th width="200px">Nombre</th>
                                                    <td>${Etapa1.nombre}</td>
                                                </tr>
                                                <tr>
                                                    <th>Resultados_Minimos</th>
                                                    <td>${Etapa1.resultados_minimos}</td>
                                                </tr>
                                                <tr>
                                                    <th>Trimestre</th>
                                                    <td>${Trimestre1}</td>
                                                </tr>
                                                <tr>
                                                    <th>Año</th>
                                                    <td>${Etapa1.ano}</td>
                                                </tr>
                                                <tr>
                                                    <th>Descripcion</th>
                                                    <td>${Descripcion1}</td>
                                                </tr>
                                            </table>
                                        </logic:notEmpty>
                                        <p>
                                        </p>
                                        <logic:notEmpty name="Etapa2">
                                            <hr><p></p>
                                            <table width="500px">
                                                <tr><th>Etapa 2</th></tr>
                                            </table>
                                            <hr><p></p>
                                            <p>
                                            </p>
                                            
                                            <table border="0" width="500px">
                                                <tr>
                                                    <th width="200px">Nombre</th>
                                                    <td>${Etapa2.nombre}</td>
                                                </tr>
                                                <tr>
                                                    <th>Resultados_Minimos</th>
                                                    <td>${Etapa2.resultados_minimos}</td>
                                                </tr>
                                                <tr>
                                                    <th>Trimestre</th>
                                                    <td>${Trimestre2}</td>
                                                </tr>
                                                <tr>
                                                    <th>Año</th>
                                                    <td>${Etapa2.ano}</td>
                                                </tr>
                                                <tr>
                                                    <th>Descripcion</th>
                                                    <td>${Descripcion2}</td>
                                                </tr>
                                            </table>
                                        </logic:notEmpty>
                                        <p>
                                        </p>

                                        <logic:notEmpty name="Etapa3">
                                            <hr><p></p>
                                            <table width="500px">
                                                <tr><th>Etapa 3</th></tr>
                                            </table>
                                            <hr><p></p>
                                            <p>
                                            </p>
                                            
                                            <table border="0" width="500px">
                                                <tr>
                                                    <th width="200px">Nombre</th>
                                                    <td>${Etapa3.nombre}</td>
                                                </tr>
                                                <tr>
                                                    <th>Resultados_Minimos</th>
                                                    <td>${Etapa3.resultados_minimos}</td>
                                                </tr>
                                                <tr>
                                                    <th>Trimestre</th>
                                                    <td>${Trimestre3}</td>
                                                </tr>
                                                <tr>
                                                    <th>Año</th>
                                                    <td>${Etapa3.ano}</td>
                                                </tr>

                                            </table>
                                        </logic:notEmpty>
                                        <p></p>
                                        <%--  <logic:notEmpty name="JuradoProyecto">
                                              <table width="500px">
                                                  <tr><th>Jurados</th></tr>
                                              </table>
                                              <p>
                                              </p>
                                              </table>
                                              <table border="0" width="500px">








                                    <logic:iterate id="jur" collection="${empty JuradoProyecto ? _vacio : JuradoProyecto}">
                                        <tr>
                                            <th width="200px">Nombre</th>
                                            <td>${jur.profesor.nombre}</td>
                                        </tr>
                                        <tr>
                                            <th>Apellido</th>
                                            <td>${jur.profesor.apellido}</td>
                                        </tr>
                                        <tr>
                                            <th>Email</th>
                                            <td>${jur.profesor.email}</td>
                                        </tr>
                                    </logic:iterate>> 
                                </table>
                                <p></p>
                            </logic:notEmpty>--%>



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