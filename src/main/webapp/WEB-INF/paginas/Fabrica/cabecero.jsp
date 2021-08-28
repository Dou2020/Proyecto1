
<table class="titulo">
    <tr>
        <td id="pagina"><h1 ><i class="fas fa-cog"></i> Fabrica</h1></td>
        <td id="nombre"><h2>Usuario: <%= session.getAttribute("nombre")%></h2></td>
        <td>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="fabrica.jsp?opcion=1">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="fabrica.jsp?opcion=2">Ingresar Piezas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="fabrica.jsp?opcion=3">Ensamble Mueble</a>
                </li>
            </ul>
        </td>
        <td id="boton"> <a class="cerrar" href="${pageContext.request.contextPath}/servlet-Fabrica?accion=salir">Salir Sesion</a> </td>
    </tr>
</table>