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

$(document).ready(function() {
    $('#buscarTienda').click(function() {
        var idTienda = parseInt($('#idTienda').val());
        buscarTiendaPorId(idTienda);
    });

    $('#editarTiendaForm').submit(function(event) {
        event.preventDefault(); // Evitar que se envíe el formulario de forma tradicional

        var formData = $(this).serialize();

        $.ajax({
            url: '/tienda/editar',
            type: 'PUT',
            headers: {
                'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
            },
            data: formData,
            success: function(response) {
                Swal.fire("Tienda editada exitosamente!");
            },
            error: function(xhr, status, error) {
                Swal.fire("Error al editar la tienda " + error);
            }
        });
    });

    function buscarTiendaPorId(id) {
        
        $.ajax({
            url: '/tienda/mostrar',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
            },
            data: { id: id },
            success: function(response) {
                $('#imagenTiendaItem').val(response.imagenTiendaItem);
                $('#descripcionTiendaItem').val(response.descripcionTiendaItem);
                $('#tipoTiendaItem').val(response.tipoTiendaItem);
                $('#precio').val(response.precio);
            },
            error: function(xhr, status, error) {
                Swal.fire("Error al buscar el elemento "+ error);
            }
        });
    }
});

function limpiarCampos() {
    $('#ImagenTiendaItem').val('');
    $('#DescripcionTiendaItem').val('');
    $('#TipoTiendaItem').val('');
    $('#precio').val('');
}


function logout() {
    // Mostrar un mensaje de confirmación al usuario
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    // Si el usuario confirma el logout, limpiar el token del almacenamiento local y redirigirlo a la página de inicio de sesión
    if (confirmLogout) {
        localStorage.removeItem('token');
        window.location.href = "/vistas/login.html"; // Cambia "login.html" por la ruta de tu página de inicio de sesión
    }
}