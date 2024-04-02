function cargarTareas() {
    $.ajax({
        url: '/Modificador/todasTareas',
        type: 'GET',
        success: function(response) {
            $('#select-task').empty();
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
        url: '/Modificador/todasTareas',
        type: 'GET',
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
        url: '/Modificador/modificarTarea',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(tareaModificada),
        success: function(response) {
            console.log('Cambios guardados exitosamente:', response);
            alert('Los cambios se han guardado exitosamente.');
        },
        error: function(xhr, status, error) {
            console.error('Error al guardar los cambios:', error);
            alert('Ha ocurrido un error al guardar los cambios.');
        }
    });
}

$(document).ready(function() {
    cargarTareas();

    $('#guardar').click(function() {
        guardarCambios();
    });
});