<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emerII.modelo.Seminario"%>
<%
    List<Seminario> seminario = (List<Seminario>)request.getAttribute("seminarios");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>punto Seminarios</title>
    </head>
    <body>
        <div class="container">
            <h1>Seminarios</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="seminarios"/>
            </jsp:include>
            <br>
            <a href="SeminarioControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo </a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Cupo</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${seminarios}">
                    <tr>
                    <th>${item.id}</th>
                    <th>${item.titulo}</th>
                    <th>${item.fecha}</th>
                    <th>${item.cupo}</th>
                    <th><a href="SeminarioController?action=edit&id=${item.id}"><i class="fas fa-edit"></i></a></th>
                    <th><a href="SeminarioController?action=delete&id=${item.id}" onclick="return(confirm('Esta Seguro ???'))"><i class="fas fa-trash-alt"></i></a></th>
                    <th></th>
                </tr>
                </c:forEach>
                
                
            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
