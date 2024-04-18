$(document).ready(function() {
    $('#tipo-producto').change(function() {
        var tipo = $(this).val();
        cargarInformacion(tipo);
    }).change(); // Cargar productos al inicio

    $('#select-product').change(function() {
        cargarDetallesProducto($(this).val());
    });
});

function cargarInformacion(tipo) {
    $.ajax({
        url: '/compras/productosFiltrados?tipo=' + tipo,
        type: 'GET',
        success: function(response) {
            $('#select-product').empty();
            $('#select-product').append($('<option>', {
                value: "",
                text: "Seleccionar producto"
            }));
            response.forEach(function(titulo) {
                $('#select-product').append($('<option>', {
                    value: titulo,
                    text: titulo
                }));
            });
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar la información de productos:', error);
        }
    });
}

function cargarDetallesProducto(titulo) {
    $.ajax({
        url: '/compras/detallesProducto?titulo=' + titulo,
        type: 'GET',
        success: function(response) {
            $('#product-id').text(response.idCompra);
            $('#product-title').text(response.titulo);
            $('#product-price').text(response.precio);
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar los detalles del producto:', error);
        }
    });

    
}

function logout() {
    // Mostrar un mensaje de confirmación al usuario
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    // Si el usuario confirma el logout, limpiar el token del almacenamiento local y redirigirlo a la página de inicio de sesión
    if (confirmLogout) {
        localStorage.removeItem('token');
        window.location.href = "/vistas/login.html"; 
    }
}
