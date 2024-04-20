$(document).ready(function() {
    $('#contenidoForm').submit(function(event) {
        event.preventDefault(); // Evitar que se envíe el formulario de forma tradicional

        // Obtener los datos del formulario
        var formData = $(this).serialize();

        // Enviar los datos mediante AJAX al endpoint correspondiente en tu backend
        $.ajax({
            url: '/contenido/postContenido', // URL del endpoint para guardar el contenido
            type: 'POST',
            data: formData,
            success: function(response) {
                alert('Contenido creado exitosamente');
                // Limpiar el formulario después de crear el contenido
                $('#contenidoForm')[0].reset();
            },
            error: function(xhr, status, error) {
                alert('Error al crear contenido: ' + error);
            }
        });
    });
});