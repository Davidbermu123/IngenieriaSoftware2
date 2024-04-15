function logUsuario() {
    var alias = $("#usuarioalias").val();
    var contrasena = $("#usuariocontrasena").val();

    // Verificar si los campos no están vacíos
    if (alias === '' || contrasena === '') {
        alert('Por favor, complete todos los campos.');
        return;
    }

    // Datos a enviar al servidor
    var data = {
        username: alias,
        password: contrasena
    };

    // Realizar la solicitud al servidor
    $.ajax({
        url: '/auth/login',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        // Continuación de la función success en la solicitud AJAX
        success: function(response) {
            console.log('Token recibido:', response.token);
            // Guardar el token de autenticación en el almacenamiento local
            localStorage.setItem('token', response.token);

            // Decodificar el token para obtener información útil
            var tokenParts = response.token.split('.');
            var tokenPayload = JSON.parse(atob(tokenParts[1]));
            console.log(tokenPayload.sub);
            // Verificar si el token contiene el nombre de usuario
            if (tokenPayload.sub) {
                // Mostrar un mensaje de bienvenida o redirigir a la página principal
                alert('¡Bienvenido, ' + tokenPayload.sub + '!');
                window.location.href = "/index.html"; // Redireccionar a la página de inicio
            } else {
                // En caso de que el token no contenga el nombre de usuario
                alert('El token de autenticación no contiene información de usuario.');
            }
        },
        error: function(xhr, status, error) {
            // Manejar errores de la solicitud
            console.error('Error en la solicitud:', error);
            alert('Ocurrió un error al iniciar sesión. Por favor, intenta nuevamente.');
        }
    });
}
// Asociar la función al evento click del botón de inicio de sesión
$("#loginBtn").click(logUsuario);
