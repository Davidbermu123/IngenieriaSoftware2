$(document).ready(function() {
    $('#consultaForm').submit(function(event) {
        event.preventDefault(); // Prevenir el envío del formulario por defecto
        
        // Obtener el valor del campo de nombre
        var nombre = $('#nombre').val();
    
        // Realizar la solicitud AJAX para obtener los estudiantes por nombre
        $.ajax({
            url: '/inicio/students',
            type: 'GET',
            data: { name: nombre },
            success: function(estudiantes) {
                var resultadosDiv = $('#resultados');
                resultadosDiv.empty(); // Limpiar resultados anteriores
    
                if (estudiantes.length > 0) {
                    var listaEstudiantes = $('<ul></ul>');
                    $.each(estudiantes, function(index, estudiante) {
                        var itemLista = $('<li></li>').text(estudiante.id + ' ' + estudiante.name + ' ' + estudiante.lastName);
                        listaEstudiantes.append(itemLista);
                    });
                    resultadosDiv.append(listaEstudiantes);
                } else {
                    resultadosDiv.text('No se encontraron estudiantes con ese nombre.');
                }
            },
            error: function(xhr, status, error) {
                console.error('Error al realizar la solicitud AJAX:', error);
            }
        });
    });
    
});