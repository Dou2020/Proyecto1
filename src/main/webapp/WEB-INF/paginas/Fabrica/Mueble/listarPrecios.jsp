<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<td>${p.nombre}</td>
<td>
    <select class="form-select form-select-sm" aria-label=".form-select-sm example">
        <option selected onload="">Seleccione el precio</option>
        <c:forEach var="p" items="${precioss}">
            <option value="${p.id}">${p.costo}</option>
        </c:forEach>
    </select>
</td>