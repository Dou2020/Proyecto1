
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container" >
        <div class="row">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="openDetailsModal('${pageContext.request.contextPath}')" >Registrar nuevo Mueble</button>
            </div>
        </div>
    </div>
</section>
<div id="myModal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar nuevo Mueble</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="modal-content">
                <p>Contenido para inspeccionar.</p>
            </div>
        </div>
    </div>
</div>

