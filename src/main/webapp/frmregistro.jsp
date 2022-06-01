<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emerII.modelo.Registro"%>
<%
    Registro registro = (Registro) request.getAttribute("registro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo producto</h1>
        <form action="RegistroControlador" method="post">
            <input type="hidden" name="id" value="${registro.id}" />
            <table>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${registro.apellidos}" placeholder="Escriba nombre del producto" /></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombres" value="${registro.nombres}" placeholder="Escriba su descripcion"/></td>
                </tr>
                <tr>
                    <td>Id seminario</td>
                    <td><input type="text" name="id_seminario" value="${registro.id_seminario}" placeholder="Escriba el precio"/></td>
                </tr>
                <tr>
                    <td>confirmado</td>
                    <td><input type="text" name="confirmado" value="${registro.confirmado}" placeholder="Escriba el precio"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>