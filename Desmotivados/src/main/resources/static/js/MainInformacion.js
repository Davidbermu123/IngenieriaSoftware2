// Llama a la función cargarInformacion() cuando el documento esté listo
$(document).ready(function() {
    cargarInformacion();
});

// Función para cargar los títulos de los productos en la barra de selección
function cargarInformacion() {
    $.ajax({
        url: '/Informacion/todasInformaciones',
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

// Función para cargar los detalles del producto seleccionado
function cargarDetallesProducto() {
    var tituloProducto = $('#select-product').val();
    if (tituloProducto) {
        $.ajax({
            url: '/Informacion/detalleProducto?titulo=' + tituloProducto,
            type: 'GET',
            success: function(response) {
                $('#product-id').text(response.idProductLo);
                $('#product-title').text(response.titulo);
                $('#product-description').text(response.descripcion);
                $('#product-price').text(response.precio);
            },
            error: function(xhr, status, error) {
                console.error('Error al cargar la información del producto:', error);
            }
        });
    } else {
        // Limpiar los detalles del producto si no se selecciona ningún producto
        $('#product-id').text("");
        $('#product-title').text("");
        $('#product-description').text("");
        $('#product-price').text("");
    }
}

// Llama a la función cargarDetallesProducto() cuando se cambia la selección en la barra de selección
$('#select-product').change(function() {
    cargarDetallesProducto();
});
