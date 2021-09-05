<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/paginas/comunes/borrarCache.jsp"/>
<script type="text/javascript" src="recursos/funciones_fabrica.js"></script>

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
<table  class="table">
    <div>
        <tr id="insertando">
            <th>Pieza</th>
            <th>Precio</th>
        </tr>
        <%! int contar; %>
        <c:forEach var="p" items="${piezasss}">
            <% contar++; %>
            <tr id="preciosPieza<%=contar%>">
                <td>${p.nombre}</td>
                <td>
                    <a class="btn btn-primary" onclick="listarPrecios('${pageContext.request.contextPath}','${p.nombre}')" >Precio</a>
                    <input type="text" id="precioo<%=contar%>">
                </td>
            </tr>
        </c:forEach>
    </div>
</table>
</br>
<label>costo:</label>
<input type="number" class="form-control" id="costoTotal" name="cantidad" step="any">