$.get("/aprender/retornar", function(data) {
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
        });