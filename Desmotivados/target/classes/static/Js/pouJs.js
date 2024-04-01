console.log("holap 1")

$.get("/requestPou/getPou", function(data) {

    console.log("holap 2")

    $.each(data, function(index, iterable) {
        var item = $("<div>");

        if (iterable.equipado == 1 && iterable.tipo == "Fondo"){
            console.log("Encontre un fondo equipado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);
            $("#fondoPou").append(item);
        }
        if (iterable.equipado == 1 && iterable.tipo == "Ropa"){
            console.log("Encontre una ropa equipada")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);
            $("#ropaPou").append(item);
        }

        if (iterable.equipado == 1 && iterable.tipo == "Mueble"){
            console.log("Encontre un muebleA equipado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);
            $("#muebleAPou").append(item);
        }

        if (iterable.equipado == 1 && iterable.tipo == "MuebleB"){
            console.log("Encontre un muebleB equipado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);
            $("#muebleBPou").append(item);
        }
    });
});
