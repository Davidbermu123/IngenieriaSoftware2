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
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar las tareas:', error);
        }
    });
}

$(document).ready(function() {
    cargarTareas();
});

/*

    cargarTareas();

    function cargarInformacionTarea(idTarea) {
        $.ajax({
            url: "/Modificador/modificarTarea/" + idTarea,
            type: "GET",
            success: function (tarea) {
                $('#task-id').val(tarea.idTarea);
                $('#task-name').val(tarea.titulo);
                $('#task-description').val(tarea.descripcion);
                $('#task-start-date').val(tarea.fechaInicio);
                $('#task-end-date').val(tarea.fechaFinal);
                $('#task-time').val(tarea.hora);
                $('#priority').val(tarea.prioridad);
            }
        });
    }

    $('#select-task').on('change', function () {
        var idTarea = $(this).val();
        cargarInformacionTarea(idTarea);
    });

    $('#guardar').on('click', function () {
        var tarea = {
            idTarea: $('#task-id').val(),
            titulo: $('#task-name').val(),
            descripcion: $('#task-description').val(),
            fechaInicio: $('#task-start-date').val(),
            fechaFinal: $('#task-end-date').val(),
            hora: $('#task-time').val(),
            prioridad: $('#priority').val()
        };

        $.ajax({
            url: "/Modificador/actualizarTarea/" + tarea.idTarea,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(tarea),
            success: function () {
                $('#message').removeClass('hidden').text('Tarea actualizada correctamente.');
                cargarTareas();
            },
            error: function () {
                $('#message').removeClass('hidden').text('Error al actualizar la tarea.');
            }
        });
    });
});*/