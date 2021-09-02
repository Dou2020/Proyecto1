
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        <form action="${pageContext.request.contextPath}/servlet-Financiero?accion=ingresar"  method="POST" class="was-validated">
                    <table>

                        <tr>
                            <td>Usuario:</td>
                            <td><input type="text" name="usuario" required value=""></td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="tipo" id="inlineRadio1" value="3" checked>
                                    <label class="form-check-label" for="inlineRadio1">Fabrica</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="tipo" id="inlineRadio2" value="2">
                                    <label class="form-check-label" for="inlineRadio2">Ventas</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="tipo" id="inlineRadio3" value="1">
                                    <label class="form-check-label" for="inlineRadio3">Financiero</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Nueva Contraseña</td>
                            <td><input type="password" name="password" required></td>
                        </tr>

                        <tr>
                            <td>Confirmar contraseña</td>
                            <td><input type="password" name="password2" required></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" name="estado" value="true" checked>
                                    <label class="form-check-label" for="flexSwitchCheckChecked">Activar el usuario</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><button type="summit" class="btn btn-primary">Guardar</button></td>
                            <td><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Regresar</button></td>
                        </tr>
                    </table>
                </form>
                                    <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
