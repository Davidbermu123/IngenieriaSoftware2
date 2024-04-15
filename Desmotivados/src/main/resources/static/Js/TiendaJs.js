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
                $.each(data, function(index, tienda) {
                    var item = $("<div>").addClass("col-md-4");
                    var item1 = $("<div>").addClass("card border-0 mb-4");
                    var imgElement = $("<img>").attr("src", tienda.imagenTiendaItem).addClass("card-img-top w-100");
                    var item2 = $("<div>").addClass("card-body");

                    item2.append($("<h6>").text("Descripcion: " + tienda.descripcionTiendaItem).addClass("card-title"));
                    item2.append($("<p>").text("Precio: " + tienda.precio).addClass("card-title"));

                    item.append(item1);
                    item1.append(imgElement);
                    item1.append(item2);
                    $("#listatienda").append(item);
                });
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error al generar la tienda:', errorThrown);
            }
        });
});