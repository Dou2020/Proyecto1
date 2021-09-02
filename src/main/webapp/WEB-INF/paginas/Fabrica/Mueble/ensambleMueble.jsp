<%-- 
    Document   : editarMueble
    Created on : 1/09/2021, 09:39:01
    Author     : douglas2021
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Ensamble</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Fabrica/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/servlet-Fabrica?accion=modificar&idPieza=${pieza.id}"
              method="POST" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Ensamble mueble</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre mueble:</label>
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
