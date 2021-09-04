<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Mueble</title>
        <script type="text/javascript" src="recursos/funciones_financiero.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Usuario/cabeceroFinanciero.jsp"/>
        <form action="${pageContext.request.contextPath}/servlet-Financiero?accion=editarMueble"  method="POST" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Mueble</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre Mueble:</label>
                                        <input class="form-control" type="text" name="nombreMueble" value="${mueble.nombre}" aria-label="readonly input example" readonly>
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <label for="precio">Precio: </label>
                                        <input type="number" class="form-control" value="${mueble.precio}" name="precio" required step="any">
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <table id="mi-tabla" class="table">
                                            <tr id="insertando">
                                                <th>Pieza</th>
                                                <th>Cantidad</th>
                                            </tr>
                                            <%! int contador;%>
                                            <c:forEach var="pp" items="${piezass}">
                                                <% contador+=1;%> 
                                                
                                                <tr id="<%=contador%>">
                                                    <td><input class="piezass<%=contador%>" name="pieza<%=contador%>" value="${pp.nombre}" aria-label="readonly input example" readonly></td>
                                                    <td> <input class="piezass<%=contador%>" name="numero<%=contador%>" value="${pp.cantidad}" aria-label="readonly input example" readonly></td>
                                                    <td><a class="btn btn-danger" onclick="" ><i class="fas fa-times-circle" aria-hidden="true" onclick="eliminarPieza('<%=contador%>')"></i> Eliminar</a></td>
                                                </tr>
                                            </c:forEach>
                                            <% contador = 0; %>
                                        </table>
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <select id="piezaNueva" class="form-select form-select-lg mb-2" aria-label=".form-select-lg example">
                                            <option selected value="">Selecciona Pieza</option>
                                            <c:forEach var="p" items="${piezas}">
                                                <option value="${p.nombre}">${p.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <label for="cantidad">Cantidad:</label>
                                        <input type="number" class="form-control" id="cantidadNueva" name="cantidad" step="any">
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <a class="btn btn-primary" onclick="insertarPieza()" >Agregar</a>
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
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>