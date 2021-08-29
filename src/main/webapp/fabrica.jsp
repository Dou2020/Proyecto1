

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! String opcions;%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    opcions = request.getParameter("opcion");

    if (session.getAttribute("nombre") == null || session.getAttribute("keys") == null) {
        response.sendRedirect("inicio.jsp");
    } else if (!"2222".equals(session.getAttribute("keys"))) {
        response.sendRedirect("inicio.jsp");
    }
%>
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
        <c:set var="op" value="${opcions}"/>
        <c:out value="${op}" />
        <c:if test="${op == 1}" >

        </c:if>
        <c:if test="${opcion == '2'}" var="opcion" scope="request" >

            <jsp:include page="WEB-INF/paginas/Fabrica/nuevaPieza.jsp"/>

            <jsp:include page="WEB-INF/paginas/Fabrica/listadoPieza.jsp"/>

        </c:if>
        <c:if test="${opcions}==3">

        </c:if>

        <jsp:include page="/WEB-INF/paginas/comunes/boostrap.jsp"/>
    </body>
</html>
