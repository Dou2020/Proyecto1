<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Ensamble Mueble</title>
        <script type="text/javascript" src="recursos/funciones_fabrica.js"></script>
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        <form onload="CrearListas(${Muebles},${piezas})">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Ensamblar Mueble</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <select id="muebleNueva" class="form-select form-select-lg mb-2" aria-label=".form-select-lg example" onchange="cambiarPiezas(this, '${pageContext.request.contextPath}')" >
                                            <option id="listaEnMueble" selected value="">Seleccionar Mueble Ensamblar</option>  
                                            <c:forEach var="mueble" items="${Muebles}">
                                                <option id="${mueble.nombre}" value="${mueble.nombre}">${mueble.nombre}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group" id="Parametros-Mueble">
                                        <label for="precio">Precio: </label> 
                                        <input id="precioo" class="form-control" type="number" name="precio" required step="any">
                                        </br>
                                        <table id="mi-tabla" class="table">
                                            <tr id="insertando">
                                                <th>Pieza</th>
                                                <th>Cantidad</th>
                                            </tr>

                                        </table>
                                        </br>
                                        <label>costo:</label>
                                        <input type="number" class="form-control" id="costoTotal" name="cantidad" step="any">

                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <button type="summit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
