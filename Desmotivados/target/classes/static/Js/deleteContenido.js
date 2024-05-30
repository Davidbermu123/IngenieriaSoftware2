$(document).ready(function() {
    $('#verContenidoForm').submit(function(event) {
        event.preventDefault(); // Evitar que se envíe el formulario de forma tradicional

        var idContenido = parseInt($('#idContenido').val());

        // Realizar la petición AJAX para obtener el contenido
        $.ajax({
            url: '/contenido/mostrarContenido',
            type: 'GET',
            data: { id: idContenido },
            success: function(response) {
                console.log("Titulo del contenido:",response.tituloContenido)
                var titulo = response.tituloContenido;
                var detalle = response.detalleContenido;
                var areaEstudio = response.areaEstudio;
                var interes = response.interes;
                var categoria = response.categoria;
                var link = response.link;

                // Crear el HTML para mostrar el contenido
                var contenidoHTML = '<h2>' + titulo + '</h2>';
                contenidoHTML += '<p>' + detalle + '</p>';
                contenidoHTML += '<p><strong>Área de Estudio:</strong> ' + areaEstudio + '</p>';
                contenidoHTML += '<p><strong>Interés:</strong> ' + interes + '</p>';
                contenidoHTML += '<p><strong>Categoría:</strong> ' + categoria + '</p>';
                contenidoHTML += '<p><a href="' + link + '" target="_blank">Enlace</a></p>';

                // Insertar el HTML en el div
                $('#contenidoMostrado').html(contenidoHTML);

                $('#borrarContenido').show(); // Mostrar el botón de borrar contenido
            },
            error: function(xhr, status, error) {
                Swal.fire('Error al obtener contenido '+ error);;
            }
        });
    });

    $('#borrarContenido').click(function() {
        
        var idContenido = parseInt($('#idContenido').val());
        
        // Realizar la petición AJAX para borrar el contenido
        $.ajax({
            url: '/contenido/deleteContenido/' + idContenido,
            type: 'DELETE',
            success: function(response) {
                Swal.fire('Contenido eliminado exitosamente');
                $('#contenidoMostrado').html(''); // Limpiar el contenido mostrado
                $('#borrarContenido').hide(); // Ocultar el botón de borrar contenido
            },
            error: function(xhr, status, error) {
                Swal.fire('Error al borrar contenido' + error);
            }
        });
    });
});