<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! String opcions;%>
<jsp:include page="WEB-INF/paginas/Fabrica/autenticacion.jsp"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabrica</title>
        <jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
        <link rel="stylesheet" href="recursos/estilo_financiero.css">
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/Fabrica/cabecero.jsp"/>
        
        <% 
        opcions = request.getParameter("opcion");
        System.out.println(opcions);
        if (opcions != null) {
                
            switch (opcions) {
            case "2": %>
                <jsp:include page="WEB-INF/paginas/Fabrica/nuevaPieza.jsp"/>
                <jsp:include page="WEB-INF/paginas/Fabrica/listadoPieza.jsp"/>
        
                <%break;
            case "3":%>
        
        
                <%break;
            default:%>
            <jsp:include page="WEB-INF/paginas/Fabrica/botonesOrdenar.jsp"/>
            <jsp:include page="WEB-INF/paginas/Fabrica/listadoEnumerarPieza.jsp"/>
                <%break;
            }
        }else{%>
            <jsp:include page="WEB-INF/paginas/Fabrica/botonesOrdenar.jsp"/>
            <jsp:include page="WEB-INF/paginas/Fabrica/listadoEnumerarPieza.jsp"/>
        <% } %>

        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
