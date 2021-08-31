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
                            <c:forEach var="piez" items="${piezass}">
                                <tr>
                                    <td>${piez.nombre}</td>
                                    <td>${piez.cantidad}</td>
                                    <td>${piez.estado}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=editar"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                           <a href="${pageContext.request.contextPath}/servlet-Fabrica?accion=eliminar"
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