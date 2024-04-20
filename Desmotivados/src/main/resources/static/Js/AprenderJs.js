let token = localStorage.getItem('token');
function verificarTokenYRedireccionarALogin() {

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

$.ajax({
            url: '/aprender/retornar',
            type: 'GET',
            headers: {
            'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                $.each(data, function(index, aprendizaje) {
                    var item = $("<div>").addClass("col-md-4");
                    var item1 = $("<div>").addClass("card border-0 mb-4");
                    var imgElement = $("<img>").attr("src", aprendizaje.urlimagen).addClass("card-img-top w-100");
                    var item2 = $("<div>").addClass("card-body");

                    item2.append($("<h6>").text("Titulo: " + aprendizaje.nombre).addClass("card-title"));
                    item2.append($("<p>").text("Titulo: " + aprendizaje.descripcion).addClass("card-title"));
                    item2.append("<button onclick=\"window.open('" + aprendizaje.urlaprender + "', '_blank')\">Recurso</button>");
                    item2.append("<button onclick=\"window.open('" + aprendizaje.urljuego + "', '_blank')\">Juego</button>");

                    item.append(item1);
                    item1.append(imgElement);
                    item1.append(item2);
                    $("#listaAprendizajes").append(item);
                });
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error al generar misiones:', errorThrown);
            }
        });

function logout() {
    // Mostrar un mensaje de confirmación al usuario
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    // Si el usuario confirma el logout, limpiar el token del almacenamiento local y redirigirlo a la página de inicio de sesión
    if (confirmLogout) {
        localStorage.removeItem('token');
        window.location.href = "/vistas/login.html"; // Cambia "login.html" por la ruta de tu página de inicio de sesión
    }
}