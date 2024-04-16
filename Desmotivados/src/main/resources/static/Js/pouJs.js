let token = localStorage.getItem('token');
function verificarTokenYRedireccionarALogin() {
    if (token === null) {
        window.location.href = '/vistas/login.html';
    } else {
        var tokenParts = token.split('.');
        var tokenPayload = JSON.parse(atob(tokenParts[1]));
        var username=tokenPayload.sub;
        console.log(username);
    }
}
verificarTokenYRedireccionarALogin();

function cargarItems(){
    $.ajax({
        url: '/requestPou/getPouItems',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        success: function(data) {
            $.each(data, function(index, iterable) {
                var item = $("<div>");

                if (iterable.equipadoItem == 1 && iterable.tipoItem == "Fondo") {
                    console.log("Encontre un fondo equipadoItem");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#fondoPou").append(item);
                }
                if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa") {
                    console.log("Encontre una ropa equipada");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#ropaPou").append(item);
                }

                if (iterable.equipadoItem == 1 && iterable.tipoItem == "Mueble") {
                    console.log("Encontre un muebleA equipadoItem");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#muebleAPou").append(item);
                }

                if (iterable.equipadoItem == 1 && iterable.tipoItem == "MuebleB") {
                    console.log("Encontre un muebleB equipado");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#muebleBPou").append(item);
                }
            });

            // Mostrar el inventario

            $.each(data, function(index, iterable) {
                var item = $("<div>");

                if (iterable.tipoItem == "Fondo") {
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipo fondo");
                        //Se guarda el fondo clickeado para ponerle el equipado a 1
                        var tempusername = iterable.username;
                        var tempnombreMascota = iterable.nmascota;
                        var tempidItem = iterable.idItem;
                        var tempimagenItem = iterable.imagenItem;
                        var tempdescripcionItem = iterable.descripcionItem;
                        var temptipoItem = iterable.tipoItem;
                        //Se modifica el fondo equipado actualmente a 0
                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Fondo") {
                                guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem, iterable.username, iterable.nmascota);
                                guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem, iterable.username, iterable.nmascota);
                            }
                        });

                    });

                    $("#fondoPouInventario").append(item);
                }
                if (iterable.tipoItem == "Ropa") {
                    console.log("Encontre una ropa comprada");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipoItem ropa");
                        //Se guarda el fondo clickeado para ponerle el equipado a 1
                        var tempidItem = iterable.idItem;
                        var tempimagenItem = iterable.imagenItem;
                        var tempdescripcionItem = iterable.descripcionItem;
                        var temptipoItem = iterable.tipoItem;
                        //Se modifica el fondo equipado actualmente a 0
                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa") {
                                guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem, iterable.username, iterable.nmascota);
                                guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem, iterable.username, iterable.nmascota);
                            }
                        });

                    });

                    $("#ropaPouInventario").append(item);
                }

                if (iterable.tipoItem == "Mueble") {
                    console.log("Encontre un muebleA comprado");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipoItem mueble");
                        //Se guarda el fondo clickeado para ponerle el equipado a 1
                        var tempusername = iterable.username;
                        var tempnombreMascota = iterable.nombreMascota;
                        var tempidItem = iterable.idItem;
                        var tempimagenItem = iterable.imagenItem;
                        var tempdescripcionItem = iterable.descripcionItem;
                        var temptipoItem = iterable.tipoItem;
                        //Se modifica el fondo equipado actualmente a 0
                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Mueble") {
                                guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem, iterable.username, iterable.nmascota);
                                guardarElementoPou(tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem, iterable.username, iterable.nmascota);
                            }
                        });

                    });

                    $("#muebleAPouInventario").append(item);
                }

                if (iterable.tipoItem == "MuebleB") {
                    console.log("Encontre un muebleB comprado");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipoItem muebleB");
                        //Se guarda el fondo clickeado para ponerle el equipado a 1
                        var tempusername = iterable.username;
                        var tempnombreMascota = iterable.nombreMascota;
                        var tempidItem = iterable.idItem;
                        var tempimagenItem = iterable.imagenItem;
                        var tempdescripcionItem = iterable.descripcionItem;
                        var temptipoItem = iterable.tipoItem;
                        //Se modifica el fondo equipado actualmente a 0
                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "MuebleB") {
                                guardarElementoPou(iterable.idItem, iterable.descripcionItem, 0, iterable.imagenItem, iterable.tipoItem, iterable.username, iterable.nmascota);
                                guardarElementoPou(tempusername,tempidItem, tempdescripcionItem, 1, tempimagenItem, temptipoItem, iterable.username, iterable.nmascota);
                            }
                        });

                    });

                    $("#muebleBPouInventario").append(item);
                }
            });
        },error: function(xhr, status, error) {
            console.error('Error al verificar la existencia:', error);
        }
    });
}

function comprobar(){
    $.ajax({
        url: '/requestPou/itemEquipados',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        success: function(data) {
            $.each(data, function(index, iterable) {
                console.log(iterable.tipoItem);
            });
        },error: function(xhr, status, error) {
            console.error('Error al verificar la existencia:', error);
        }
    });
}
comprobar();
