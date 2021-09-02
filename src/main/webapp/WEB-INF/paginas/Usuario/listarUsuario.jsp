<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="cliente">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Usuarios</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Puesto</th>
                                <th>Estado</th>
                            </tr>
                        <tbody>
                            <c:forEach var="p" items="${usuarios}">
                                <c:if test="${p.tipo != 1}">
                                    <tr>
                                        <td>${p.nombre}</td>
                                        <c:if test="${p.tipo ==2}">
                                            <td>Ventas</td>
                                        </c:if>
                                        <c:if test="${p.tipo == 3}">
                                            <td>Fabrica</td>
                                        </c:if>
                                        <td>
                                            <c:if test="${p.estado == true}">
                                                <div class="form-check form-switch">
                                                    <input class="form-check-input" type="checkbox" name="estatus1" onclick="modificarUser('${pageContext.request.contextPath}', '${p.nombre}',${p.estado})" checked="on">
                                                    <label class="form-check-label" for="flexSwitchCheckChecked" id="${p.nombre}">${p.estado}</label>
                                                </div>

                                            </c:if>
                                            <c:if test="${p.estado == false}">

                                                <div class="form-check form-switch">
                                                    <input class="form-check-input" type="checkbox" name="estatus2" onclick="modificarUser('${pageContext.request.contextPath}', '${p.nombre}',${p.estado})" >
                                                    <label class="form-check-label" for="flexSwitchCheckChecked" id="${p.nombre}">${p.estado}</label>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/servlet-Financiero?accion=editarUsuario&nombreUsuario=${p.nombre}"
                                               class="btn btn-secondary">
                                                <i class="fas fa-angle-double-right"></i>Editar
                                            </a>
                                            <a href="${pageContext.request.contextPath}/servlet-Financiero?accion=eliminarUsuario&nombreUsuario=${p.nombre}"
                                               class="btn btn-danger">
                                                <i class="fas fa-times-circle"></i> Eliminar
                                            </a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>