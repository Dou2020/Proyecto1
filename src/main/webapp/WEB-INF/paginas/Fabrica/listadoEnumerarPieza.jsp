<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="cliente">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de cantidad Pieza</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Estado</th>
                            </tr>
                        <tbody>
                            <c:forEach var="p" items="${cantidadPieza}">
                                <tr>
                                    <td>${p.nombre}</td>
                                    <td>${p.cantidad}</td>
                                    <td>${p.estado}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=editarPiezas&nombrePiezas=${p.nombre}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <c:if test="${p.cantidad == 0}">
                                            <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=eliminarPiezas&nombrePiezas=${p.nombre}"
                                               class="btn btn-danger">
                                                <i class="fas fa-times-circle"></i> Eliminar
                                            </a>
                                        </c:if>
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