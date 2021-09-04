<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Ensamble Mueble</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        <form onload="CrearListas(${Muebles},${piezas})">
            <table class="table table-borderless">
                <tr>
                    <td colspan="2"> 
                        <select id="muebleNueva" class="form-select form-select-lg mb-2" aria-label=".form-select-lg example" onchange="" >
                            <option id="listaEnMueble" selected value="">Seleccionar Mueble Ensamblar</option>   
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input id="precioo" type="number" name="precio" required step="any"></td>
                </tr>
                <tr>
                <table id="mi-tabla" class="table">
                    <tr id="insertando">
                        <th>Pieza</th>
                        <th>Cantidad</th>
                    </tr>
                    
                </table>
                </tr>
                </br><!--  -->
                <tr>
                    <td>costo:</td>
                    <td><input type="number" id="costoTotal" name="cantidad" step="any"></td>
                </tr>
                </br></br>
                <tr>
                    <td><button type="summit" class="btn btn-primary">Guardar</button></td>
                    <td><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Regresar</button></td>
                </tr>
            </table>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
