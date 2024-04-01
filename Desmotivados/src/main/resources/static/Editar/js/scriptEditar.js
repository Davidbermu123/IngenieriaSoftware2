function buscarUsuario() {
    var alias = $('#aliasInput').val(); // Obtener el valor del campo de entrada
    console.log(alias)
    // Realizar la petición AJAX
    $.ajax({
        url: '/usuarios/findbyalias', // URL del endpoint del controlador
        type: 'GET',
        data: { alias: alias }, // Enviar el alias como parámetro
        success: function(response) {
            // Manejar la respuesta exitosa
            // Rellenar los campos con la información del usuario
            $('#userId').text(response.idUsuario);
            $('#userName').text(response.nombre);
            $('#userLastName').text(response.apellido);
            $('#userAlias').text(response.alias);
            $('#userUniversity').text(response.universidad);
            $('#userCareer').text(response.carrera);
            $('#userSemester').text(response.semestre);
            $('#userPet').text(response.nmascota);
        },
        error: function(xhr, status, error) {
            // Manejar errores de la petición
            console.error('Error al buscar usuario:', error);
            // Limpiar los campos en caso de error
            limpiarCampos();
        }
    });
}

function limpiarCampos() {
    // Limpiar los campos de información del usuario
    $('#userId').text('');
    $('#userName').text('');
    $('#userLastName').text('');
    $('#userAlias').text('');
    $('#userUniversity').text('');
    $('#userCareer').text('');
    $('#userSemester').text('');
    $('#userPet').text('');
}
