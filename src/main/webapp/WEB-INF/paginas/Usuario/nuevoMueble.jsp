<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal1">
  Registrar nuevo Mueble
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content modal-lg">
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
                <td><input type="number" name="password" required step="any"></td>
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
