var token = localStorage.getItem('token');
if (token) {
    // El token existe en el localStorage
    console.log("Token encontrado:", token);
} else {
    // El token no existe en el localStorage
    console.log("Token no encontrado en el localStorage");
}
var tokenParts = token.split('.');
var tokenPayload = JSON.parse(atob(tokenParts[1]));
console.log(tokenPayload.sub);
var username = tokenPayload.sub; // Variable global para almacenar el alias del usuario

function buscarUsuario() {
   

    // Realizar la petición AJAX
    $.ajax({
        url: '/cregistro/findbyalias', // URL del endpoint del controlador
        type: 'GET',
        data: { username: username }, // Enviar el alias como parámetro
        success: function(response) {
            // Manejar la respuesta exitosa
            // Rellenar los campos con la información del usuario
            $('#userNameInput').val(response.nombre);
            $('#userLastNameInput').val(response.apellido);
            $('#userUniversityInput').val(response.universidad);
            $('#userCareerInput').val(response.carrera);
            $('#userSemesterInput').val(response.semestre);
            $('#userPetInput').val(response.nmascota);

        },
        error: function(xhr, status, error) {
            // Manejar errores de la petición
            console.error('Error al buscar usuario:', error);
            // Limpiar los campos en caso de error
            limpiarCampos();
        }
    });
}

function editarUsuario() {
    // Obtener los datos del formulario
    var nombre = $('#userNameInput').val();
    var apellido = $('#userLastNameInput').val();
    var universidad = $('#userUniversityInput').val();
    var carrera = $('#userCareerInput').val();
    var semestre = parseInt($('#userSemesterInput').val());
    var mascota = $('#userPetInput').val();

    // Realizar la petición AJAX para actualizar el usuario
    $.ajax({
        url: '/cregistro/updateUsuario', // URL del endpoint del controlador
        type: 'PUT',
        data: {
            usernameBusqueda: username,
            nombre: nombre, 
            apellido: apellido, 
            universidad: universidad, 
            carrera: carrera, 
            semestre: semestre, 
            nmascota: mascota
        },
        success: function(response) {
            // Manejar la respuesta exitosa
            console.log('Usuario actualizado exitosamente:', response);
            alert('¡Usuario actualizado exitosamente!');
        },
        error: function(xhr, status, error) {
            // Manejar errores de la petición
            console.error('Error al actualizar usuario:', error);
            alert('Actualización de usuario rechazada');
        }
    });
}


function limpiarCampos() {
    // Limpiar los campos de información del usuario
    $('#userIdInput').val('');
    $('#userNameInput').val('');
    $('#userLastNameInput').val('');
    $('#userAliasInput').val('');
    $('#userUniversityInput').val('');
    $('#userCareerInput').val('');
    $('#userSemesterInput').val('');
    $('#userPetInput').val('');
}

document.addEventListener("DOMContentLoaded", function() {
    buscarUsuario(); // Llama al método una vez que el DOM está listo
});