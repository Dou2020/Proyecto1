<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_GT" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Piezas</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#ID</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                            </tr>
                        <tbody>
                            <c:forEach var="pieza" items="${piezas}">
                                <tr>
                                    <td>${pieza.id}</td>
                                    <td>${pieza.nombre}</td>
                                    <td><fmt:formatNumber value="${pieza.costo}" type="currency"/> </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=editar&idPieza=${pieza.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                           <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=eliminar&idPieza=${pieza.id}"
                                           class="btn btn-danger">
                                            <i class="fas fa-times-circle"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
    
            