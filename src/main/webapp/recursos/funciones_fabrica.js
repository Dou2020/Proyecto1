function insertarPieza() {
    var nFilas = $("#mi-tabla tr").length;
    var nombre = $("#piezaNueva").val();
    var cantidad = $("#cantidadNueva").val();
    var valores1 = '<input value="' + nombre + '" name="pieza' + nFilas + '" aria-label="readonly input example" readonly >';
    var txt1 = '<td id="no' + nFilas + '">' + valores1 + '</td>';
    var valores2 = '<input value="' + cantidad + '" name="numero' + nFilas + '" aria-label="readonly input example" readonly>';
    var txt3 = '<td id="n' + nFilas + '">' + valores2 + '</td>';
    var txt2 = '<tr>' + txt1 + txt3 + '</tr>';           // Create element with HTML
    //var txt2 = $("<i></i>").text("love ");  // Create with jQuery
    //var txt3 = document.createElement("b");   // Create with DOM
    // txt3.innerHTML = "jQuery!";
    if (nombre !== null && nombre !== "") {
        if (cantidad !== null && cantidad !== "") {
            $("#insertando").after(txt2);    // Insert new elements after insertando 
            $("#piezaNueva").val("");
            $("#cantidadNueva").val("");
        }
    }
}
function cambiarPiezas(Mueble, context) {
    var mueble = $(Mueble).val();
    alert(mueble);
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Fabrica?accion=enviarParametro&idMueble=" + mueble,
        success: function (result) {
            $('#Parametros-Mueble').html(result);
        }
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}
function listarPrecios(context, pieza, id) {
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Fabrica?accion=listarPrecios&idPieza=" + pieza + "&columna=" + id,
        success: function (result) {
            $('#modal-content-EnMueble').html(result);
            $('#modalParaListarPrecio').modal('show');
        }
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}
function eliminarPieza(columna) {

}
function cambiarPrecio(valor, id) {
    var precio = $(valor).val();
    var idCambiar = "#precioo" + id;
    $(idCambiar).val(precio);
    
    var nFilas = $("#tablaCostos tr").length;
    var x = 0;
    var y = 0;
    var z = 0;
    for (var i = 1; i < nFilas; i++) {
        var n = "#precioo" + i;
        y = parseInt( $(n).val() );
         z = x + y ;
         x = z;
    }
    $('#costoTotal').val(z);
}
function mensaje() {
    alert("mensaje de conexion");
}
function openDetailsModal(context) {
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Fabrica?accion=enMueble",
        success: function (result) {
            $('#modal-content').html(result);
            $('#myModal').modal('show');
        }
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}

