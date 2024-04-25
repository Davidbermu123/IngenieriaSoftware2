function filtrarContenido() {
    var areaEstudio = $('#areas').val();
    var interes = $('#intereses').val();
    
    // Realizar la solicitud AJAX para obtener el contenido filtrado
    $.ajax({
      url: '/contenido/findContenido',
      type: 'GET',
      data: { area_estudio: areaEstudio, interes: interes },
      success: function(contenidos) {
        var contenidoDiv = $('#contenido');
        contenidoDiv.empty(); // Limpiar contenido anterior
  
        // Filtrar los contenidos por categoría diferente de "Actividad" y mostrarlos
        contenidos.forEach(function(contenido) {
          if (contenido.categoria !== "actividad") {
            var itemContenido = $('<div class="contenido-item"></div>');
            var titulo = $('<h2></h2>').text(contenido.tituloContenido);
            var detalle = $('<p></p>').text(contenido.detalleContenido);
            var enlaceBtn = $('<button class="enlaces-btn">Ir a Enlace</button>').click(function() {
              window.location.href = contenido.link;
            });
            itemContenido.append(titulo, detalle, enlaceBtn);
            contenidoDiv.append(itemContenido);
          }
        });
      },
      error: function(xhr, status, error) {
        console.error('Error al filtrar contenido:', error);
      }
    });
  }