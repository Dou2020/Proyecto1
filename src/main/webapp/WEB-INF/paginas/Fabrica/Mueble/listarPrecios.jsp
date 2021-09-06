<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fomulario de precios</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="recursos/funciones_fabrica.js"></script>
    </head>
    <body>
        <h3>${columna}</h3>
        </br>
            <select id ="precioSeleccionado" onchange="cambiarPrecio(this,'${columna}')" class="form-select" multiple aria-label="multiple select example">
                <option selected value="0">Seleccionar el precio</option>
                <c:forEach var="p" items="${precioss}">
                    <option value="${p.costo}">${p.costo}</option>
                </c:forEach>
            </select>
            </br><!-- comment -->
            <button type="button" data-bs-dismiss="modal" class="btn btn-primary">Seleccionado</button>
    </body>
</html>

