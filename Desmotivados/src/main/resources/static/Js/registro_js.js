function saludar(){
    console.log("Hola hpt mundo de mierda");
}

function saveUsuario(){
    let name = $("#usuarioname").val();
    let lastname = $("#usuarioapellido").val();
    let alias = $("#usuarioalias").val();
    let uni = $("#usuariouniversidad").val();
    let career = $("#usuariocarrera").val();
    let period = $("#usuariosemestre").val();
    let pet = $("#usuarionmascota").val();
    let contrasena = $("#usuariocontrasena").val();
     
    if (name === '' || lastname === '' || alias === '' || uni === '' || career === '' || period === '' || pet === '' || contrasena === '') {
        alert('Por favor, complete todos los campos.');
        return; // Detener la ejecución si algún campo está vacío
    }
    let data = {
        nombre: name,
        apellido: lastname,
        username: alias,
        universidad: uni,
        carrera: career,
        semestre: period,
        nmascota: pet,
        password: contrasena,
    }

    $.ajax({
        url: '/auth/register',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            window.location.href = "/index.html";
        },
        error: function(xhr, status, error) {
            alert('Este usuario ya existe, por favor escoger otro', error);

        }
    });

}
function regresar() {
    window.location.href = "/index.html";
}