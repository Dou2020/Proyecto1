<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Lista de datos erroneos</h3>
<ul class="list-group">
    <c:forEach var="p" items="${error}">
         <li class="list-group-item">${p}</li>
    </c:forEach>
        
</ul>
<h3>
    Lista de datos aceptados
</h3>
<h4>Lista de ususarios</h4>
<ul class="list-group">
    <c:forEach var="p" items="${usuariosR}">
         <li class="list-group-item">${p.nombre}  tipo: ${p.tipo}</li>
    </c:forEach>
</ul>
<h4>Lista de piezas</h4>
<ul class="list-group">
    <c:forEach var="p" items="${piezasR}">
         <li class="list-group-item">${p.nombre} costo:${p.costo}</li>
    </c:forEach>
</ul>
<h4>Lista de muebles</h4>
<ul class="list-group">
    <c:forEach var="p" items="${mueblesR}">
         <li class="list-group-item"> ${p.nombre} precio: ${p.precio}</li>
    </c:forEach>
</ul>
<h4>Lista de clientes</h4>
<ul class="list-group">
    <c:forEach var="p" items="${clientesR}">
         <li class="list-group-item">${p.nombre}  ${p.nit}  ${p.direccion}  ${p.municipio}</li>
    </c:forEach>
        
</ul>