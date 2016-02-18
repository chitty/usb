<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@include file="/WEB-INF/jspf/conexion.jspf" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Dirección de Seguridad Integral</title>
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1>Dirección de Seguridad Integral<hr><a href="http://www.usb.ve">UNIVERSIDAD SIMÓN BOLÍVAR</a></h1>
                </div>
            </div>
            <!-- end #header -->
            <div id="menu">
                <ul>
                    <li><a href=""></a></li>
                    <li><a href=""> Novedades </a></li>
                    <li><a href="principal_mapas.jsp"> Mapas </a></li>
                    <li><a href=""> SHA </a></li>
                    <li><a href=""> Apoyo Administrativo </a></li>

                </ul>
            </div>
            <!-- end #menu -->


            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">

                        <div id="menu2">
                            <ul>
                                <li><a href="principal_mapas.jsp">Inicio</a></li>
                                <li><a href="consultar.jsp?accion=none">Consultar Data</a></li>
                                <li><a href="#">Eliminar Data</a></li>
                                <li><a href="agregar.jsp?accion=none">Agregar Data</a></li>
                                <li><a href="#">Contacto</a></li>
                            </ul>
                        </div>

                        <div id="content">
                            <div class="post">
                                <div class="post-bgtop">
                                    <div class="post-bgbtm">
                                        <%
                                                    String accion = request.getParameter("accion");
                                                    if (accion.equals("none")) {
                                        %>
                                        <h1 class="title">Bienvenido al asistente para agregar Datos Espaciales</h1>
                                        <p class="meta"></p>
                                        <div class="entry">
                                            <br><br><br><br>
                                            <p>Por favor elija una opcion del menú
                                                presentado a la izquierda, si lo que desea<br>
                                                es agregar un nuevo plano elija la primera
                                                opción "Agregar Plano", de esta forma usted<br>
                                                o otros usuarios privilegiados del sistema
                                                podrán visualizar riesgos, incidencias y<br>
                                                mapas de extintores sobre el mismo.<br><br>
                                                Si por otra parte desea agregar una nueva
                                                zona al sistema por favor elija la segunda<br>
                                                opción "Crear Zona" y podrá crear una nueva
                                                zona utilizando como base un plano ya existente<br>
                                                en el sistema.<br><br>
                                                Si lo que desea es Agregar un nuevo riesgo
                                                o tipo de novedad para que pueda ser visto<br>
                                                sobre los planos del sistema elija la tercera
                                                opción "Agregar Riesgo".</p>
                                            <br><br><br><br><br><br><br><br><br>
                                        </div>
                                        <% } else if (accion.equals("plano")) {
                                        %>
                                        <html:form action="/fileupload" method="post" enctype="multipart/form-data">
                                            <center>
                                                <h1>Agregar Plano</h1><br><br>
                                                <font color=”red”><html:errors/></font>
                                                Archivo de extensión shp<br>
                                                <html:file property="theFile"/><br><br>
                                                Archivo de extensión bdf<br>
                                                <html:file property="theFile2"/><br><br>
                                                <html:submit>Cargar Plano</html:submit>
                                            </center>
                                        </html:form>
                                        <% } else if (accion.equals("zona")) {
                                        %>
                                        <% }
                                        %>
                                    </div>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>
                        <!-- end #content -->
                        <div id="sidebar">
                            <ul>
                                <li>
                                    <h2>Opciones</h2>
                                    <ul>
                                        <li><a href="agregar.jsp?accion=plano">Agregar Plano</a><span>Agregue un nuevo plano al sistema</span></li>
                                        <li><a href="agregar.jsp?accion=zona">Crear Zona</a><span>Cree una nueva zona a partir de un plano</span></li>
                                        <li><a href="agregar.jsp?accion=riesgo">Agregar Riesgo</a><span>Agregue un nuevo riesgo al sistema</span> </li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                        <!-- end #sidebar -->
                        <div style="clear: both;">&nbsp;</div>
                    </div>
                </div>
            </div>
            <!-- end #page -->
            <div id="footer">
                <p>Edificio Ciencias Básicas II. Piso 2. Apartado 89000. Valle de Sartenejas. Baruta. Edo. Miranda.<br />
                    Teléfono: 58-0212-9063460-9063461
                    Fax: 58-0212-9063460
                    <a>Correo electrónico: segu-int@usb.ve.</a></p>
                <p>Sistema creado por <img src="images/logoSSD.jpg" alt="Security Systems Design" /> </p>
            </div>
            <!-- end #footer -->
        </div>
    </body>
</html>
