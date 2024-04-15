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

console.log("holap 1")

$(document).ready(function() {
    $.ajax({
            url: '/requestPou/getPou',
            type: 'GET',
            headers: {
            'Authorization': 'Bearer ' + token
            },
            success: function(data) {

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
                                        guardarElementoPou(iterable.idItem, 0);
                                        guardarElementoPou(tempidItem, 1);
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
                                var tempidItem = iterable.idItem;
                                //Se modifica el fondo equipado actualmente a 0
                                $.each(data, function(index, iterable) {

                                    if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa"){
                                        console.log("--------------idItem antes funcion click--------------"+iterable.idItem);
                                        guardarElementoPou(iterable.idItem, 0);
                                        guardarElementoPou(tempidItem, 1);
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
                                        guardarElementoPou(iterable.idItem, 0);
                                        guardarElementoPou(tempidItem, 1);
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
                                        guardarElementoPou(iterable.idItem, 0);
                                        guardarElementoPou(tempidItem, 1);
                                    }
                                });

                            });

                            $("#muebleBPouInventario").append(item);
                        }
                    });

                },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error al generar misiones:', errorThrown);
            }
        });
});

function guardarElementoPou(idItemm, equipadoItem) {
    let data = {
        idItem: idItemm,
        equipadoItem: equipadoItem,
    };
    $.ajax({
        url: '/requestPou/actualizarEquipado',
        type: 'PUT',
        headers: {
            'Authorization': 'Bearer ' + token
            },
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