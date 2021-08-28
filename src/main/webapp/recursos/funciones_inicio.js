function validarForma(forma){
    var Usuario = forma.usuario;
    if(Usuario.value == "" || Usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        Usuario.focus();
        Usuario.select();
        return false;
        
    }
    var password = forma.password;
    if (password.value == "" || password.value.length < 3) {
        alert("Debe proporcionar un passwoed al menos de 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    alert("formulario valido, enviando datos al servidor");
    return true;
    
}
function mensajes(forma1){
    var nombre = forma1;
    alert(nombre);
}

