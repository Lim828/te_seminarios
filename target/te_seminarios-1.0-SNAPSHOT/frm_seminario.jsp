<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emerII.modelo.Seminario"%>
<%
    Seminario seminario = (Seminario) request.getAttribute("seminario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo seminario</h1>
        <form action="SeminarioControlador" method="post">
            <input type="hidden" name="id" value="${seminario.id}" />
            <table>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${seminario.titulo}" placeholder="Escriba su nombre"/></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="${seminario.fecha}" placeholder="Escriba su correo"/></td>
                </tr>
                <tr>
                    <td>Cupo</td>
                    <td><input type="text" name="cupo" value="${seminario.cupo}" placeholder="Escriba su celular"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
