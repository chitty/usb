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
                <script type="text/javascript" src="../_js/jquery-1.6.1.js"></script>
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
                    <li><cohesion:actor actors="4"><html:link action="/A_Prep_Gestion_Pasantias_Estudiante.do">Regresar</html:link></cohesion:actor></li>
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


                                        <logic:empty name="L_preins">
                                            <h2>Preinscripción de pasantía</h2>

                                            <html:form action="/A_Preinscripcion.do" method="post">
                                                
                                                <br><h3>Tipo de Pasantía</h3>
                                                <html:radio property="tipo" value="1">Corta EP-1420</html:radio>                                                
                                                <html:radio property="tipo" value="2">Intermedia EP-2420</html:radio>                                                
                                                <html:radio property="tipo" value="3">Larga EP-3420</html:radio>
                                                    
                                                <br><br><h3>Bloque</h3>
                                                <html:radio property="bloque" value="true">A (Te gradúas con la pasantía)</html:radio>
                                                <html:radio property="bloque" value="false">B (No te gradúas con la pasantía)</html:radio>
                                                    
                                                <br><br><h3>¿Desea que la Coordinación de Cooperación Técnica y Desarrollo Social tramite el Proceso de Búsqueda de Pasantía en la Empresa?</h3>
                                                <html:radio property="buscar" value="true">Sí</html:radio>
                                                <html:radio property="buscar" value="false">No</html:radio>
                                                    

                                                <br><br><h3>¿A que ciudades estaría Ud. dispuesto a ir?</h3>
                                                <html:text styleId="ciudades" property="donde" size="50" style="display:none;"/>
                                                <select multiple="multiple">
                                                    <logic:iterate name="L_ciudades" id="ciudad">
                                                        <option id="${ciudad.idCiudad}">${ciudad.nombre}</option>
                                                    </logic:iterate>
                                                </select>
                                                <script>
                                                    $("select").change(function () {
                                                          var str = "";
                                                          $("select option:selected").each(function () {
                                                                str += $(this).attr("id") + ",";
                                                              });
                                                              $("#ciudades").attr("value", str);
                                                        })
                                                        .trigger('change');
                                                </script>

                                                <br><br>
                                                <html:submit styleClass="button">Preinscribete!</html:submit>                                                        
                                                
                                            </html:form>

                                        </logic:empty>
                                        <logic:notEmpty name="L_preins">
                                            <ul id="preinscripciones">
                                                <logic:iterate id="p" name="L_preins">
                                                    <h1>Usted se preinscribió para realizar pasantía ${p.tipo==1 ? "corta" : ""} ${p.tipo==2 ? "intermedia" : ""} ${p.tipo==3 ? "larga" : ""} </h1>
                                                    Creada el: ${p.created_at}
                                                    <h3><html:link action="/A_GenerarCartaPostulacion.do">Generar Carta Postulación<img style="padding-left: 3px" src="../_css/images/download.png"></html:link></h3>
                                                    <h3><html:link action="/A_GenerarSolicitudPasantia.do">Generar Solicitud de Pasantía<img style="padding-left: 3px" src="../_css/images/download.png"></html:link></h3>
                                                    <logic:equal name="Estatus" value="false">
                                                        <h3><html:link action="/A_EliminarPreinscripcion.do" onclick="return confirm('¿Está seguro que desea eliminar su preinscripción?')"><img style="padding-rigth: 10px" height="15" src="../_css/images/eliminar.gif"><font color="red"> Eliminar Preinscripción</font></html:link></h3>
                                                        Recuerde revisar sus datos y en caso de que sean incorrectos elimine su preinscripción, corrija sus datos y vuelva a preinscribirse
                                                        <p>Una vez la CCTDS apruebe su preinscripción usted no podrá hacer modificaciones</p>
                                                    </logic:equal>
                                                    <logic:equal name="Estatus" value="true">
                                                        <h4>La CCTDS aprobó su preinscripción y envió sus datos a las empresas que estan solicitando pasantes en su area.</h4>
                                                    </logic:equal>
                                                </logic:iterate>
                                            </ul>
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