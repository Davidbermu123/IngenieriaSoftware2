$(document).ready(function() {
    $.ajax({
        url: '/PouN/nombre',
        type: 'GET',
        success: function(response) {
            // Verificar si hay al menos un nombre en la respuesta
            if (response.length > 0) {
                // Establecer el primer nombre en el elemento con el id 'mascota-name'
                $('#mascota-name').text(response[0]);
            } else {
                // Si no hay nombres en la respuesta, mostrar un mensaje de error
                $('#mascota-name').text('No se encontraron nombres de mascotas');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar el nombre de la mascota:', error);
            // Mostrar un mensaje de error en caso de fallo
            $('#mascota-name').text('Error al cargar el nombre de la mascota');
        }
    });
});