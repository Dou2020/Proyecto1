<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal1">
    Registrar nuevo Mueble
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar nuevo Mueble</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/servletFinanciero?accion=ingresar"  method="POST" class="was-validated">
                    <table>

                        <tr>
                            <td>Nombre Mueble:</td>
                            <td><input type="text" name="usuario" required></td>
                        </tr>
                        <tr>
                            <td>Precio: </td>
                            <td><input type="number" name="precio" required step="any"></td>
                        </tr>
                        <tr>

                        </tr>
                        <tr>
                            <td colspan="2"> 
                                <select class="form-select form-select-lg mb-2" aria-label=".form-select-lg example">
                                    <option selected value="">Selecciona Pieza</option>

                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Cantidad:</td>
                            <td><input type="number" name="cantidad" required step="any"></td>
                        </tr>
                        <tr>
                            <td>
                                <button class="btn btn-primary" onclick="" >Agregar</button>
                            </td>
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
