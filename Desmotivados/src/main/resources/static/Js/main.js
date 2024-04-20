let token = localStorage.getItem('token');
function verificarTokenYRedireccionarALogin() {
    if (token === null) {
        window.location.href = '/vistas/login.html';
    } else {
        var tokenParts = token.split('.');
        var tokenPayload = JSON.parse(atob(tokenParts[1]));
        var username=tokenPayload.sub;
        console.log(username);
    }
}
verificarTokenYRedireccionarALogin();


function cargarTareas2() {
    $.ajax({
        url: '/Corganizador/mistareas',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
        },
        success: function(response) {
            $('#select-task').empty();
            $('#select-task').append($('<option>', {

            }));
            response.forEach(function(tarea) {
                $('#select-task').append($('<option>', {
                    value: tarea.titulo,
                    text: tarea.titulo
                }));
            });

            $('#select-task').change(function() {
                var tituloTarea = $(this).val();
                if (tituloTarea) {
                    cargarInformacionTarea(tituloTarea);
                }
            });
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar las tareas:', error);
        }
    });
}

function cargarInformacionTarea(tituloTarea) {
    $.ajax({
        url: '/Corganizador/mistareas',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
        },
        success: function(response) {
            var tareaSeleccionada = response.find(function(tarea) {
                return tarea.titulo === tituloTarea;
            });
            if (tareaSeleccionada) {

                $('#task-id').val(tareaSeleccionada.idTarea);
                $('#task-name').val(tareaSeleccionada.titulo);
                $('#task-description').val(tareaSeleccionada.descripcion);
                $('#task-start-date').val(tareaSeleccionada.fechaInicio);
                
                var fechaFinal = new Date(tareaSeleccionada.fechaFinal);
                var fechaFinalFormateada = fechaFinal.toISOString().slice(0, 16);
                $('#task-datetime').val(fechaFinalFormateada);
                
                $('#priority').val(tareaSeleccionada.prioridad);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar la información de la tarea:', error);
        }
    });
}

function guardarCambios() {
    var tareaModificada = {
        idTarea: $('#task-id').val(),
        titulo: $('#task-name').val(),
        descripcion: $('#task-description').val(),
        fechaFinal: $('#task-datetime').val(),
        prioridad: $('#priority').val()
    };

    $.ajax({
        url: '/Corganizador/modificarTarea',
        type: 'POST',
        headers: {
            'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
        },
        contentType: 'application/json',
        data: JSON.stringify(tareaModificada),
        success: function(response) {
            console.log('Cambios guardados exitosamente:', response);
            alert('Los cambios se han guardado exitosamente.');
            window.location.href = "/vistas/organizadorVista.html";
        },
        error: function(xhr, status, error) {
            console.error('Error al guardar los cambios:', error);
            alert('Ha ocurrido un error al guardar los cambios.');
        }
    });
}

$(document).ready(function() {
    cargarTareas2();

    $('#guardar').click(function() {
        guardarCambios();
    });
});
