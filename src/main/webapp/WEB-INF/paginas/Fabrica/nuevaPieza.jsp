<!-- Button trigger modal -->
<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container" >
        <div class="row">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal2">
                    Registrar nueva Pieza
                </button>
            </div>
        </div>
    </div>
</section>

<!-- Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Registrar nueva Pieza</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/servlet-Fabrica?accion=ingresar"  method="POST" class="was-validated">
                    <table>

                        <tr>
                            <td>Nombre Pieza:</td>
                            <td><input type="text" name="pieza" required></td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td><input type="number" name="precio" required></td>
                        </tr>
                        <tr>
                            <td>Cantidad</td>
                            <td><input type="number" name="cantidad" required></td>
                        </tr>
                        <tr>
                            <td><button type="summit" class="btn btn-primary">Guardar</button></td>
                            <td><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Regresar</button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
