console.log("holap 1")

$.get("/requestPou/getPou", function(data) {

    console.log("holap 2")

    $.each(data, function(index, iterable) {
        var item = $("<div>");

        if (iterable.equipadoItem == 1 && iterable.tipoItem == "Fondo"){
            console.log("Encontre un fondo equipadoItem")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);
            $("#fondoPou").append(item);
        }
        if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa"){
            console.log("Encontre una ropa equipada")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);
            $("#ropaPou").append(item);
        }

        if (iterable.equipadoItem == 1 && iterable.tipoItem == "Mueble"){
            console.log("Encontre un muebleA equipadoItem")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);
            $("#muebleAPou").append(item);
        }

        if (iterable.equipadoItem == 1 && iterable.tipoItem == "MuebleB"){
            console.log("Encontre un muebleB equipado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);
            $("#muebleBPou").append(item);
        }
    });

    //mostrar el inventario

    $.each(data, function(index, iterable) {
        var item = $("<div>");

        if (iterable.tipoItem == "Fondo"){
            console.log("Encontre un fondo comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipo fondo");
                //Se guarda el fondo clickeado para ponerle el equipado a 1
                //var tempusername = iterable.username;
                //var tempnombreMascota = iterable.nombreMascota;
                var tempidItem = iterable.idItem;
                var tempimagenItem = iterable.imagenItem;
                var tempdescripcionItem = iterable.descripcionItem;
                var temptipoItem = iterable.tipoItem;
                //Se modifica el fondo equipado actualmente a 0
                $.each(data, function(index, iterable) {

                    if (iterable.equipadoItem == 1 && iterable.tipoItem == "Fondo"){
                        guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem);
                        guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem);
                    }
                });

            });

            $("#fondoPouInventario").append(item);
        }
        if (iterable.tipoItem == "Ropa"){
            console.log("Encontre una ropa comprada")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipoItem ropa");
                //Se guarda el fondo clickeado para ponerle el equipado a 1
                //var tempusername = iterable.username;
                //var tempnombreMascota = iterable.nombreMascota;
                var tempidItem = iterable.idItem;
                var tempimagenItem = iterable.imagenItem;
                var tempdescripcionItem = iterable.descripcionItem;
                var temptipoItem = iterable.tipoItem;
                //Se modifica el fondo equipado actualmente a 0
                $.each(data, function(index, iterable) {

                    if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa"){
                        guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem);
                        guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem);
                    }
                });

            });

            $("#ropaPouInventario").append(item);
        }

        if (iterable.tipoItem == "Mueble"){
            console.log("Encontre un muebleA comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipoItem mueble");
                //Se guarda el fondo clickeado para ponerle el equipado a 1
                //var tempusername = iterable.username;
                //var tempnombreMascota = iterable.nombreMascota;
                var tempidItem = iterable.idItem;
                var tempimagenItem = iterable.imagenItem;
                var tempdescripcionItem = iterable.descripcionItem;
                var temptipoItem = iterable.tipoItem;
                //Se modifica el fondo equipado actualmente a 0
                $.each(data, function(index, iterable) {

                    if (iterable.equipadoItem == 1 && iterable.tipoItem == "Mueble"){
                        guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem);
                        guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem);
                    }
                });

            });
            
            $("#muebleAPouInventario").append(item);
        }

        if (iterable.tipoItem == "MuebleB"){
            console.log("Encontre un muebleB comprado")
            var imagen = $("<img>");
                imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                item.append(imagen);

            imagen.click(function() {
                // Acción que se ejecutará cuando se haga clic en la imagen
                console.log("Se hizo click en una imagen tipoItem muebleB");
                //Se guarda el fondo clickeado para ponerle el equipado a 1
                //var tempusername = iterable.username;
                //var tempnombreMascota = iterable.nombreMascota;
                var tempidItem = iterable.idItem;
                var tempimagenItem = iterable.imagenItem;
                var tempdescripcionItem = iterable.descripcionItem;
                var temptipoItem = iterable.tipoItem;
                //Se modifica el fondo equipado actualmente a 0
                $.each(data, function(index, iterable) {

                    if (iterable.equipadoItem == 1 && iterable.tipoItem == "MuebleB"){
                        guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem);
                        guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem);
                    }
                });

            });

            $("#muebleBPouInventario").append(item);
        }
    });

});

function guardarElementoPou(idItem, descripcionItem, equipadoItem, imagenItem, tipoItem) {

    $.ajax({
        url: '/requestPou/verificarExistencia/' + idItem,
        type: 'GET',
        success: function(response) {
            if (response.existe) {
                // Si el elemento ya existe, mostrar una ventana de confirmación
                var confirmacion = confirm('El elemento ya existe en la base de datos. ¿Desea reemplazarlo con la nueva información?');
                if (confirmacion) {
                    // Si el usuario acepta, guardar el nuevo elemento
                    guardarNuevoElemento(idItem, descripcionItem, equipadoItem, imagenItem, tipoItem);
                } else {
                    // Si el usuario cancela, no hacer nada
                    console.log('Guardado cancelado');
                }
            } else {
                // Si el elemento no existe, guardar directamente el nuevo elemento
                guardarNuevoElemento(idItem, descripcionItem, equipadoItem, imagenItem, tipoItem);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al verificar la existencia:', error);
        }
    });
}

function guardarNuevoElemento(idItem, descripcionItem, equipadoItem, imagenItem, tipoItem) {
    let data = {
        idItem: idItem,
        descripcionItem: descripcionItem,
        equipadoItem: equipadoItem,
        imagenItem: imagenItem,
        tipoItem: tipoItem
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