<table class="titulo">
    <tr>
        <td id="pagina"><h1 ><i class="fas fa-chart-pie"></i> Financiero</h1></td>
        <td id="nombre"><h2>Usuario: <%= session.getAttribute("nombre")%></h2></td>
        <td id="boton"> <a class="cerrar" href="${pageContext.request.contextPath}/servletFinanciero?accion=salir">Salir Sesion</a> </td>
    </tr>
</table>