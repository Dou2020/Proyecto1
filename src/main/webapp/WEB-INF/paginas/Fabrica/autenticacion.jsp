
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("nombre") == null || session.getAttribute("keys") == null) {
        response.sendRedirect("inicio.jsp");
    } else if (!"2222".equals(session.getAttribute("keys"))) {
        response.sendRedirect("inicio.jsp");
    }
%>
