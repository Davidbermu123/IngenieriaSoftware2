$.get("/aprender/retornar", function(data) {
            $.each(data, function(index, aprendizaje) {
                var item = $("<div>");
                item.append("<p>ID: " + aprendizaje.id + "</p>");
                item.append("<p>Nombre: " + aprendizaje.nombre + "</p>");
                item.append("<p>Descripcion: " + aprendizaje.descripcion + "</p>");
                item.append("<p>Url1: " + aprendizaje.urlaprender + "</p>");
                item.append("<button onclick=\"window.open('" + aprendizaje.urlaprender + "', '_blank')\">Recurso</button>");
                item.append("<p>Url2: " + aprendizaje.urljuego + "</p>");
                item.append("<button onclick=\"window.open('" + aprendizaje.urljuego + "', '_blank')\">Juego</button>");
                $("#listaAprendizajes").append(item);
            });
        });