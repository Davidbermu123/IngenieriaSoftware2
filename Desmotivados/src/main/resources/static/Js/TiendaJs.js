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

$(document).ready(function() {
    $.ajax({
            url: '/tienda/retornaritems',
            type: 'GET',
            headers: {
            'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                $.ajax({
                    url: '/tienda/existentes',
                    type: 'GET',
                    headers: {
                    'Authorization': 'Bearer ' + token
                    },
                    success : function(comprados){
                        console.log(data);
                        console.log(comprados);
                        const compradosSet = new Set(comprados.map(item => item.imagenItem));
                        $.each(data, function(index, tienda) {
                            var item = $("<div>").addClass("col-md-4");
                            var item1 = $("<div>").addClass("card border-0 mb-4");
                            var imgElement = $("<img>").attr("src", tienda.imagenTiendaItem).addClass("card-img-top w-100");
                            var item2 = $("<div>").addClass("card-body");

                            item2.append($("<h6>").text("Descripcion: " + tienda.descripcionTiendaItem).addClass("card-title"));
                            item2.append($("<p>").text("Precio: " + tienda.precio).addClass("card-title"));

                            var button;

                            if (compradosSet.has(tienda.imagenTiendaItem)) {
                                button = $("<button>").text("Comprado").addClass("btn btn-secondary").prop("disabled", true);
                            } else {
                                button = $("<button>").text("Comprar").addClass("btn btn-primary btn-comprar");
                                button.click(function() {
                                    var confirmacion = confirm("¿Estás seguro de que deseas comprar este artículo?");
                                    if (confirmacion) {
                                        comprar(tienda.descripcionTiendaItem, tienda.imagenTiendaItem, tienda.tipoTiendaItem, tienda.precio);
                                    }
                                });
                            }
                            item.append(item1);
                            item1.append(imgElement);
                            item1.append(item2);
                            item1.append(button);
                            $("#listatienda").append(item);
                        });
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.error('Error al obtener los items comprados:', errorThrown);
                    }
                });
                
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error al generar la tienda:', errorThrown);
            }
        });
    $.ajax({
        url: '/tienda/monedas',
        type: 'GET',
        headers: {
        'Authorization': 'Bearer ' + token
        },
        success: function(data){
            if(data == -1){
                alert("Error al cargar las monedas del usuario");
            }
            $("#cantidadMonedas").text(data);
        },error: function(jqXHR, textStatus, errorThrown) {
            console.error('error al obtener las monedas', errorThrown);
        }
    });
});

function logout() {
    // Mostrar un mensaje de confirmación al usuario
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    // Si el usuario confirma el logout, limpiar el token del almacenamiento local y redirigirlo a la página de inicio de sesión
    if (confirmLogout) {
        localStorage.removeItem('token');
        window.location.href = "/vistas/login.html"; // Cambia "login.html" por la ruta de tu página de inicio de sesión
    }
}

function comprar(descripcionT, imagenT, tipoT, precioT){
    $.ajax({
        url: '/tienda/comprar',
        type: 'POST',
        headers: {
        'Authorization': 'Bearer ' + token
        },
        data: {
            descripcion: descripcionT,
            imagen: imagenT,
            tipo: tipoT,
            precio: precioT
        },
        success: function(response) {
            if (response == "guardado") {
                alert("El item fue comprado");
                location.reload();
            } else {
                if (response == "insuficiente") {
                    alert("No tienes suficientes monedas para comprar este artículo");
                } else {
                    alert("Error al comprar el artículo: " + response);
                }
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error('Error al comprar el artículo:', errorThrown);
        }
    });
}