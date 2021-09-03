<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mueble</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/servlet-Financiero?accion=ingresarMueble"  method="POST" class="was-validated">
            <table class="table table-borderless">
                <tr>
                    <td>Nombre Mueble:</td>
                    <td><input type="text" name="usuario" required></td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input type="number" name="precio" required step="any"></td>
                </tr>
                <tr>
                <table id="mi-tabla" class="table">
                    <tr id="insertando">
                        <th>Pieza</th>
                        <th>Cantidad</th>
                    </tr>
                </table>
                </tr>
                <tr>
                    <td colspan="2"> 
                        <select id="piezaNueva" class="form-select form-select-lg mb-2" aria-label=".form-select-lg example">
                            <option selected value="">Selecciona Pieza</option>
                            <c:forEach var="p" items="${piezas}">
                                <option value="${p.nombre}">${p.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                </br><!--  -->
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="number" id="cantidadNueva" name="cantidad" step="any"></td>
                </tr>
                </br></br>
                <tr>
                    <td colspan="2" class="align-top" >
                        <a class="btn btn-primary" onclick="insertarPieza()" >Agregar</a>
                    </td>
                </tr>
                </br></br>
                <tr>
                    <td><button type="summit" class="btn btn-primary">Guardar</button></td>
                    <td><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Regresar</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>