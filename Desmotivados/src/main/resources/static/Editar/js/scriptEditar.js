var usuarioAlias; // Variable global para almacenar el alias del usuario

function buscarUsuario() {
    var alias = $('#aliasInput').val(); // Obtener el valor del campo de entrada

    // Realizar la petición AJAX
    $.ajax({
        url: '/usuarios/findbyalias', // URL del endpoint del controlador
        type: 'GET',
        data: { alias: alias }, // Enviar el alias como parámetro
        success: function(response) {
            // Manejar la respuesta exitosa
            // Rellenar los campos con la información del usuario
            $('#userNameInput').val(response.nombre);
            $('#userLastNameInput').val(response.apellido);
            $('#userAliasInput').val(response.alias);
            $('#userUniversityInput').val(response.universidad);
            $('#userCareerInput').val(response.carrera);
            $('#userSemesterInput').val(response.semestre);
            $('#userPetInput').val(response.nmascota);

            // Guardar el alias del usuario en la variable global
            usuarioAlias = response.alias;
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
    var alias = usuarioAlias; // Usar el alias guardado en la variable global
    var universidad = $('#userUniversityInput').val();
    var carrera = $('#userCareerInput').val();
    var semestre = parseInt($('#userSemesterInput').val());
    var mascota = $('#userPetInput').val();

    // Realizar la petición AJAX para actualizar el usuario
    $.ajax({
        url: '/usuarios/updateUsuario', // URL del endpoint del controlador
        type: 'PUT',
        data: {
            aliasBusqueda: alias,
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
        },
        error: function(xhr, status, error) {
            // Manejar errores de la petición
            console.error('Error al actualizar usuario:', error);
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

