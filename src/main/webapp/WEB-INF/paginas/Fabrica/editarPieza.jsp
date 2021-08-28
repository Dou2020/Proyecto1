<%-- 
    Document   : editarPieza.jsp
    Created on : 28/08/2021, 10:18:56
    Author     : douglas2021
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pieza</title>
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        <form action="${pageContext.request.contextPath}/servlet-Fabrica?accion=modificar&idPieza=${pieza.id}"
              method="POST" class="was-validated">
            <!-- botones de navegacion editar -->
            <jsp:include page="/WEB-INF/paginas/Fabrica/botonesNavegacion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Pieza</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre pieza:</label>
                                        <input type="text" class="form-control" name="nombre" required value="${pieza.nombre}"> 
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Precio: </label>
                                        <input type="number" class="form-control" name="saldo" required value="${pieza.costo}" step="any"> 
                                    </div>
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
