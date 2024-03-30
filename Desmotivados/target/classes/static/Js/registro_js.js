function saludar(){
    console.log("Hola hpt mundo de mierda");
}

function saveUsuario(){
    let name = $("#usuarioname").val();
    let lastname = $("#usuarioapellido").val();
    let username = $("#usuarioalias").val();
    let uni = $("#usuariouniversidad").val();
    let career = $("#usuariocarrera").val();
    let period = $("#usuariosemestre").val();
    let pet = $("#usuarionmascota").val();
    let contrasena = $("#usuariocontrasena").val();

    let data = {
        nombre: name,
        apellido: lastname,
        alias: username,
        universidad: uni,
        carrera: career,
        semestre: period,
        nmascota: pet,
        password: contrasena,
    }

    $.ajax({
        url: '/cregistro/guardarUs',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            console.log('Usuario guardado correctamente:', response);
            // Aquí puedes realizar alguna acción adicional si lo necesitas, como redirigir a otra página.
        },
        error: function(xhr, status, error) {
            console.error('Error al guardar el usuario:', error);
        }
    });
}