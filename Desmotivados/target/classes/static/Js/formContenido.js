function verificarTokenYRedireccionarALogin() {
    let token = localStorage.getItem('token');

    // Verificar si el token está presente
    if (token === null) {
        // Si el token no está presente, redirigir al usuario al inicio de sesión
        window.location.href = '/vistas/login.html';
    } else {
        var tokenParts = token.split('.');
        var tokenPayload = JSON.parse(atob(tokenParts[1]));
        var username=tokenPayload.sub;
        console.log(username);
    }
}

verificarTokenYRedireccionarALogin();
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