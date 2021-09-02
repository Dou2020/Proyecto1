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
function modificarUsuario(context, id, estado) {
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
  var txt1 = "<b>I </b>";           // Create element with HTML
  var txt2 = $("<i></i>").text("love ");  // Create with jQuery
  var txt3 = document.createElement("b");   // Create with DOM
  txt3.innerHTML = "jQuery!";
  $("img").after(txt1, txt2, txt3);    // Insert new elements after img
  $("").before();
}


