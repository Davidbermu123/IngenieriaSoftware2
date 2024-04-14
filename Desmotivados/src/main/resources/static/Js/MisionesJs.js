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
$.get("/misiones/retornarmisiones", function(data) {
            $.each(data, function(index, mision) {
                var item = $("<div>");
                item.append("<p>ID: " + mision.idMision + "</p>");
                item.append("<p>Nombre: " + mision.contenido.idContenido + "</p>");
                $("#listaMisiones").append(item);
            });
        });