

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
        <script type="text/javascript" src="recursos/funciones_financiero.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Financiero</title>
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/Usuario/cabeceroFinanciero.jsp"/>
            <div>
                <table>
                    <tr>
                        <td>
                            <jsp:include page="/WEB-INF/paginas/Usuario/nuevoMueble.jsp"/>
                        </td>
                        <td>
                            <jsp:include page="/WEB-INF/paginas/Usuario/nuevoUsuario.jsp"/>
                        </td>
                        <td>
                            <jsp:include page="WEB-INF/paginas/Usuario/botonSubirArchivo.jsp"/>
                        </td>
                    </tr>
                </table>
            </div>
                            <jsp:include page="WEB-INF/paginas/Usuario/listarUsuario.jsp"/>
                            <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
