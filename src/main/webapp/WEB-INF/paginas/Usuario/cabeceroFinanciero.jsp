<link rel="stylesheet" href="recursos/estilo_financiero.css">
<table class="titulo">
    <tr>
        <td id="pagina"><h1 ><i class="fas fa-chart-pie"></i> Financiero</h1></td>
        <td id="nombre"><h2>Usuario: <%= session.getAttribute("nombre")%></h2></td>
        <td>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="financiero.jsp?opcion=1">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="financiero.jsp?opcion=2">Ingresar Usuario</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="financiero.jsp?opcion=3">Ingresar Mueble</a>
                </li>
            </ul>
        </td>
        <td id="boton"> <a class="cerrar" href="${pageContext.request.contextPath}/servlet-Financiero?accion=salir">Salir Sesion</a> </td>
    </tr>
</table>