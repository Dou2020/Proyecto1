

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    
    if (session.getAttribute("nombre") == null || session.getAttribute("keys") == null ) {
            response.sendRedirect("inicio.jsp");
    }else if(!"2222".equals(session.getAttribute("keys"))) {
            response.sendRedirect("inicio.jsp");
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabrica</title>
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        
        <jsp:include page="WEB-INF/paginas/Fabrica/nuevaPieza.jsp"/>
        
        <jsp:include page="WEB-INF/paginas/Fabrica/listadoPieza.jsp"/>
       
        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
