<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@include file="/WEB-INF/jspf/conexion.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Se ha eliminado el plano correctamente</title>
    </head>
    <body>
    <sql:transaction dataSource="${bdatos}">


        <sql:query var="result">
         SELECT DropGeometryTable('<bean:write name="EliminarMapaForm" property="name" />');
        </sql:query>
    </sql:transaction>

    <h1>Se ha eliminado el plano <bean:write name="EliminarMapaForm" property="name" /> correctamente</h1>
</body>
</html>
