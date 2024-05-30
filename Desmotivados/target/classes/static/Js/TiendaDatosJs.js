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


function guardarTienda() {

    let ShopImage =$("#ImagenTienda").val().trim();
    let ShopDescribe = $("#DescripcionTienda").val().trim();
    let ShopType =$("#TipoTienda").val().trim();
    let price =$("#precio").val().trim();

    let data = {
        imagenTiendaItem: ShopImage,
        descripcionTiendaItem: ShopDescribe,
        tipoTiendaItem: ShopType,
        precio: price
    };

    // Limpiar los campos del formulario
    limpiarCampos();

    $.ajax({
        url: '/tienda/guardar',
        type: 'POST',
        headers: {
            'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
        },
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            Swal.fire("Articulo guardado exitosamente!");
        },
        error: function(xhr, status, error) {
            // Manejar errores si los hay
        }
    });
}

function limpiarCampos() {
    $('#ImagenTienda').val('');
    $('#DescripcionTienda').val('');
    $('#TipoTienda').val('');
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