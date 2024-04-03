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

    //mostrar el inventario

    $.each(data, function(index, iterable) {
        var item = $("<div>");

        if (iterable.comprado == 1 && iterable.tipo == "Fondo"){
            console.log("Encontre un fondo comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipo fondo");
                // Se realizan las siguientes operaciones

                //Se modifica el fondo equipado actualmente a 0
                $.each(data, function(index, iterable) {

                    if (iterable.equipado == 1 && iterable.tipo == "Fondo"){
                        guardarElementoPou(iterable.id_item, iterable.comprado, 0, iterable.imagen, iterable.nombre, iterable.tipo);
                    }

                });

            });

            $("#fondoPouInventario").append(item);
        }
        if (iterable.comprado == 1 && iterable.tipo == "Ropa"){
            console.log("Encontre una ropa equipada")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipo ropa");
                // Agrega aquí la acción que deseas realizar cuando se haga clic en la imagen
            });

            $("#ropaPouInventario").append(item);
        }

        if (iterable.comprado == 1 && iterable.tipo == "Mueble"){
            console.log("Encontre un muebleA comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipo mueble");
                // Agrega aquí la acción que deseas realizar cuando se haga clic en la imagen
            });
            
            $("#muebleAPouInventario").append(item);
        }

        if (iterable.comprado == 1 && iterable.tipo == "MuebleB"){
            console.log("Encontre un muebleB comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagen); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipo muebleB");
                // Agrega aquí la acción que deseas realizar cuando se haga clic en la imagen
            });

            $("#muebleBPouInventario").append(item);
        }
    });

});

function guardarElementoPou(id_item, comprado, equipado, imagen, nombre, tipo) {

    $.ajax({
        url: '/requestPou/verificarExistencia/' + id_item,
        type: 'GET',
        success: function(response) {
            if (response.existe) {
                // Si el elemento ya existe, mostrar una ventana de confirmación
                var confirmacion = confirm('El elemento ya existe en la base de datos. ¿Desea reemplazarlo con la nueva información?');
                if (confirmacion) {
                    // Si el usuario acepta, guardar el nuevo elemento
                    guardarNuevoElemento(id_item, comprado, equipado, imagen, nombre, tipo);
                } else {
                    // Si el usuario cancela, no hacer nada
                    console.log('Guardado cancelado');
                }
            } else {
                // Si el elemento no existe, guardar directamente el nuevo elemento
                guardarNuevoElemento(id_item, comprado, equipado, imagen, nombre, tipo);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al verificar la existencia:', error);
        }
    });
}

function guardarNuevoElemento(id_item, comprado, equipado, imagen, nombre, tipo) {
    let data = {
        id_item: id_item,
        comprado: comprado,
        equipado: equipado,
        imagen: imagen,
        nombre: nombre,
        tipo: tipo
    };
    $.ajax({
        url: '/requestPou/guardarElementoPou',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            console.log('Usuario guardado correctamente:', response);
            alert('Guardado exitosamente');
        },
        error: function(xhr, status, error) {
            console.error('Error al guardar el usuario:', error);
        }
    });
}