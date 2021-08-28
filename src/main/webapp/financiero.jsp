

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    
    if (session.getAttribute("nombre") == null || session.getAttribute("keys") == null ) {
            response.sendRedirect("inicio.jsp");
    }else if(!"1111".equals(session.getAttribute("keys"))) {
            response.sendRedirect("inicio.jsp");
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
        <title>Financiero</title>
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
    </head>
    <body>
        <table class="titulo">
            <tr>
                <td id="pagina"><h1 ><i class="fas fa-chart-pie"></i> Financiero</h1></td>
                <td id="nombre"><h2>Usuario: <%= session.getAttribute("nombre")%></h2></td>
                <td id="boton"> <a class="cerrar" href="${pageContext.request.contextPath}/servletFinanciero?accion=salir">Salir Sesion</a> </td>
            </tr>
        </table>
            <div>
                <table>
                    <tr>
                        <td>
                            <jsp:include page="/WEB-INF/paginas/comunes/nuevoMueble.jsp"/>
                        </td>
                        <td>
                            <jsp:include page="/WEB-INF/paginas/comunes/nuevoUsuario.jsp"/>
                        </td>
                    </tr>
                </table>
            </div>
                            <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
