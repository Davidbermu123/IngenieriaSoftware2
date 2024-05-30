$(document).ready(function() {
    $('#buscarContenido').click(function() {
        var idContenido = parseInt($('#idContenido').val());
        buscarContenidoPorId(idContenido);
    });

    $('#editarContenidoForm').submit(function(event) {
        event.preventDefault(); // Evitar que se envíe el formulario de forma tradicional

        var formData = $(this).serialize();

        $.ajax({
            url: '/contenido/editarContenido',
            type: 'PUT',
            data: formData,
            success: function(response) {
                Swal.fire("Contenido editado exitosamente");
            },
            error: function(xhr, status, error) {
                Swal.fire("Error al editar contenido " + error);
            }
        });
    });

    function buscarContenidoPorId(id) {
        $.ajax({
            url: '/contenido/mostrarContenido',
            type: 'GET',
            data: { id: id },
            success: function(response) {
                $('#tituloContenido').val(response.tituloContenido);
                $('#detalleContenido').val(response.detalleContenido);
                $('#areaEstudio').val(response.areaEstudio);
                $('#interes').val(response.interes);
                $('#link').val(response.link);
            },
            error: function(xhr, status, error) {
                Swal.fire("Error al buscar contenido " + error);
            }
        });
    }
});