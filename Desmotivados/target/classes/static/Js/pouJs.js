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

buscardef();

function buscardef(){
    $.ajax({
        url: '/requestPou/getPouItems',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        success: function(data) {
            if(data == 0){
                console.log("Insertando valores defalut")
                ponerDefault();
            }
        }
    });
}

function cargarItems(){

    $.ajax({
        url: '/requestPou/getPouItems',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        success: function(data) {

            // Busca los items default
            /*

            $.each(data, function(index, iterable) {

                console.log("Buscando items default..");

                ropaDef;
                fondoDef;
                mADef;
                mBDef;

                if (iterable.imagenItem == "/imgs/Fondo1.png"){
                    ropaDef = iterable.idItem;
                    console.log("Se encontro el "+ropaDef+" de pobre");
                }
                if (iterable.imagenItem == "/imgs/Ropa11.png"){
                    fondoDef = iterable.idItem;
                    console.log("Se encontro el "+fondoDef+" de pobre");
                }
                if (iterable.imagenItem == "/imgs/Mueble8.png"){
                    mADef = iterable.idItem;
                    console.log("Se encontro el "+mADef+" de pobre");
                }
                if (iterable.imagenItem == "MuebleB10"){
                    mBDef = iterable.idItem;
                    console.log("Se encontro el "+mBDef+" de pobre");
                }

                ponerDefault(ropaDef,fondoDef,mADef,mBDef);

            });
            */

            // funcionalidad

            $.each(data, function(index, iterableEquipado) {

                var item = $("<div>");

                if (iterableEquipado.equipadoItem == 1 && iterableEquipado.tipoItem == "Fondo") {
                    console.log("Encontre un fondo equipadoItem");
                    var imagen = $("<img>");
                    imagen.attr("src", iterableEquipado.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#fondoPou").append(item);
                }
                if (iterableEquipado.equipadoItem == 1 && iterableEquipado.tipoItem == "Ropa") {
                    console.log("Encontre una ropa equipada");
                    var imagen = $("<img>");
                    imagen.attr("src", iterableEquipado.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#ropaPou").append(item);
                }
                if (iterableEquipado.equipadoItem == 1 && iterableEquipado.tipoItem == "Mueble") {
                    console.log("Encontre un muebleA equipadoItem");
                    var imagen = $("<img>");
                    imagen.attr("src", iterableEquipado.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);
                    $("#muebleAPou").append(item);
                }
                if (iterableEquipado.equipadoItem == 1 && iterableEquipado.tipoItem == "MuebleB") {
                    console.log("Encontre un muebleB equipado");
                    var imagen = $("<img>");
                    imagen.attr("src", iterableEquipado.imagenItem); // Establecer la URL de la imagen
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

                    var tempidItem = iterable.idItem;

                    imagen.click(function() {

                        console.log("Se hizo click en una imagen tipo fondo");

                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Fondo") {
                                cambiarElementoEquipado(iterable.idItem,tempidItem);
                            }
                        });
                        location.reload();
                    });

                    $("#fondoPouInventario").append(item);
                }
                if (iterable.tipoItem == "Ropa") {
                    console.log("Encontre una ropa comprada");
                    var imagen = $("<img>");
                    imagen.attr("src", iterable.imagenItem); // Establecer la URL de la imagen
                    item.append(imagen);

                    var tempimagenItem = iterable.imagenItem;

                    imagen.click(function() {

                        console.log("Se hizo click en una imagen tipoItem ropa");

                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Ropa") {
                                cambiarElementoEquipado(iterable.idItem,tempidItem);
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

                    var tempidItem = iterable.idItem;

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipoItem mueble");

                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "Mueble") {
                                cambiarElementoEquipado(iterable.idItem,tempidItem);
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

                    var tempidItem = iterable.idItem;

                    imagen.click(function() {
                        // Acción que se ejecutará cuando se haga clic en la imagen
                        console.log("Se hizo click en una imagen tipoItem muebleB");

                        $.each(data, function(index, iterable) {

                            if (iterable.equipadoItem == 1 && iterable.tipoItem == "MuebleB") {
                                cambiarElementoEquipado(iterable.idItem,tempidItem);
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

function ponerDefault(){
    $.ajax({
        url: '/requestPou/ponerDefault',
        type: 'POST',
        headers: {
            'Authorization': 'Bearer ' + token
        },        
        success: function() {
            console.log('No error dentro de la funcon de cambiar a default');
        },error: function(xhr, status, error) {
            console.error('Error dentro de la funcon de cambiar a default:', error);
        }
    });
}

function cambiarElementoEquipado(idActual, idFuturo){
    $.ajax({
        url: '/requestPou/cambiarEquipado',
        type: 'PUT',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        data: {
            idItem: idActual,
            idItem2: idFuturo
        },
        success: function() {
            console.log('No error dentro de la funcon de cambiar el elemento equipado');
        },error: function(xhr, status, error) {
            console.error('Error dentro de la funcon de cambiar el elemento equipado:', error);
        }
    });
}

cargarItems();
