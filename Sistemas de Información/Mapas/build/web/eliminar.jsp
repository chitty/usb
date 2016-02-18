
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
                                <li><a href="eliminar.jsp?accion=none">Eliminar Data</a></li>
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
                                        <h1 class="title">Bienvenido al asistente para eliminar Datos Espaciales</h1>
                                        <p class="meta"></p>
                                        <div class="entry">
                                            <br><br><br><br>
                                            <p>Por favor elija una opcion del menú
                                                presentado a la izquierda, si lo que desea<br>
                                                es eliminar un mapa existente en el sistema
                                                elija la opción "Eliminar Plano", de esta forma usted<br>
                                                y otros usuarios privilegiados del sistema
                                                podrán eliminar mapas de riesgos, incidencias y<br>
                                                mapas de extintores sobre el mismo.<br><br></p>
                                            <br><br><br><br><br><br><br><br><br>
                                        </div>
                                        <% } else if (accion.equals("mapa")) {
                                        %>
                                        <sql:transaction dataSource="${bdatos}">


                                            <sql:query var="result">
                                                select table_name, table_schema from information_schema.tables where table_schema NOT IN ('pg_catalog', 'information_schema');
                                            </sql:query>
                                            <h1 class="title">Eliminar Mapa</h1>
                                            <p class="meta"></p>
                                            <html:form action="/eliminarMapa" method="post" enctype="multipart/form-data">
                                                <font color=”red”><html:errors/></font>
                                                Seleccione el Mapa que desea eliminar<br>
                                                <select name="name">
                                                    <c:forEach items="${result.rows}" var="tablas">
                                                        <c:if test="${tablas.table_name != 'geometry_columns'}">
                                                            <c:if test="${tablas.table_name != 'spatial_ref_sys'}">
                                                                <c:if test="${tablas.table_name != 'geography_columns'}">
                                                                    <option><c:out value="${tablas.table_name}" /></option>
                                                                </c:if>
                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                                <html:submit>Eliminar Mapa</html:submit>

                                            </html:form>

                                        </sql:transaction>

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
                                        <li><a href="eliminar.jsp?accion=mapa">Eliminar Mapa</a><span>Eliminar un mapa del sistema</span></li>
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

