// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the modal
var modal2 = document.getElementById("myModal2");

// Get the button that opens the modal
var btn2 = document.getElementById("myBtn2");


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName("close")[0];

btn2.onclick = function() {
  modal2.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span2.onclick = function() {
  modal2.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal2) {
    modal2.style.display = "none";
  }
}

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
function modificarUser(context, id, estado) {
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Financiero?accion=modificarUser&idUser="+id+"&estado="+estado,
        success: function () {
            document.getElementById(id).innerHTML = !estado ;
            alert("Se modifico estado del usuario: "+id +" a estado: "+!estado);
        }
    }).fail(function () {
        alert("error");
    });
}
function modificarUsuario(context, id) {
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Financiero?accion=modificarUser&idUser="+id+"&estado="+estado,
        success: function () {
            document.getElementById(id).innerHTML = !estado ;
            alert("Se modifico estado del usuario: "+id +" a estado: "+!estado);
        }
    }).fail(function () {
        alert("error");
    });
}
function insertarPieza() {
  var nFilas = $("#mi-tabla tr").length;
  var nombre = $("#piezaNueva").val();
  var cantidad = $("#cantidadNueva").val();
  var valores1 = '<input value="'+nombre+'" name="pieza'+nFilas+'" aria-label="readonly input example" readonly >';
  var txt1 = '<td>'+valores1+'</td>';
  var valores2 ='<input value="'+cantidad+'" name="numero'+nFilas+'" aria-label="readonly input example" readonly>';
  var txt3 = '<td>'+valores2+'</td>';
  var txt2 = '<tr>'+txt1+txt3+'</tr>';           // Create element with HTML
  //var txt2 = $("<i></i>").text("love ");  // Create with jQuery
  //var txt3 = document.createElement("b");   // Create with DOM
 // txt3.innerHTML = "jQuery!";
    if (nombre !== null && nombre !== "") {
        if (cantidad !==null && cantidad !== "") {
            $("#insertando").after(txt2);    // Insert new elements after img 
            $("#piezaNueva").val("");
            $("#cantidadNueva").val("");
        }  
    }
}
function eliminarPieza(idEliminar){
    $('.piezass'+idEliminar).val("");
    $('#'+idEliminar).hide();
}
function openDetailsModal(context) {
    $.ajax({
        type: 'GET',
        url: context + "/servlet-Financiero?accion=verPieza",
        success: function (result) {
            $('#modal-content').html(result);
            $('#myModal').modal('show');
        }
    }).fail(function ( jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}



