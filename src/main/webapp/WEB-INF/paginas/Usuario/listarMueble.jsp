<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="cliente">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Muebles</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Precio</th>
                            </tr>
                        <tbody>
                            <c:forEach var="p" items="${muebles}">
                                <tr>
                                    <td>${p.nombre}</td>
                                    <td>${p.precio}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servlet-Financiero?accion=editarMueble&nombreMueble=${p.nombre}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/servlet-Financiero?accion=eliminarMueble&nombreMueble=${p.nombre}"
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