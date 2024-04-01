$.get("/misiones/retornarmisiones", function(data) {
            $.each(data, function(index, mision) {
                var item = $("<div>");
                item.append("<p>ID: " + mision.idMision + "</p>");
                item.append("<p>Nombre: " + mision.contenido.idContenido + "</p>");
                $("#listaMisiones").append(item);
            });
        });