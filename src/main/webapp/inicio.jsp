<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/estilo_inicio.css">
        <script type="text/javascript" src="recursos/funciones_inicio.js"></script>
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
</head>
<body>
    <h1>Mi muebleria</h1>
    <fieldset>
        <legend><h4>Inicio Sesion</h4></legend>
        <form name="form2" action="${pageContext.request.contextPath}/servletInicio" method="POST" onsubmit="return validarForma(this)">
            <table>
                <tr>
                    <td><b>Usuario:</b></td>
                    <td class="ingreso"><input type="text" name="usuario" value=""></td>
                </tr>
                <tr>
                    <td><b>Contraseña: </b></td>
                    <td class="ingreso"><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" id="boton"><input type="submit" value="Enviar" id="en"/></td>
                </tr>
            </table>
        </form>
    </fieldset>
           
</body>
</html>
