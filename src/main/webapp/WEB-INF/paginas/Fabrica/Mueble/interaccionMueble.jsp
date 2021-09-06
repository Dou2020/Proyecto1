<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
<script type="text/javascript" src="recursos/funciones_fabrica.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<label for="precio">Precio: </label> 
<input id="precioo" value="${m.precio}" class="form-control" type="number" name="precio" required step="any">
</br>
<table id="mi-tabla" class="table">
    <tr id="insertando">
        <th>Pieza</th>
        <th>Cantidad</th>
    </tr>
    <c:forEach var="p" items="${piezasss}">
        <tr>
            <td>${p.nombre}</td>
            <td>${p.cantidad}</td>
        </tr>

    </c:forEach>
</table> 
<table  class="table" id="tablaCostos">
    <tr id="insertando">
        <th>Pieza</th>
        <th>Precio</th>
    </tr>
    <%! int contar;%>
    <c:forEach var="p" items="${piezasss}">
        <c:forEach var="i" begin="1" end="${p.cantidad}">
            <% contar++;%>
            <tr>
                <td>${p.nombre}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalParaListarPrecio" onclick="listarPrecios('${pageContext.request.contextPath}', '${p.nombre}', '<%=contar%>')" >Precio</button>
                    <input type="number" id="precioo<%= contar%>" value="0.0" onchange="sumarTodo()" >
                </td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</br>
<label>costo:</label>
<input type="number" class="form-control" id="costoTotal" name="cantidad" step="any">
<% contar = 0;%>