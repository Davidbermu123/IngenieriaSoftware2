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
            url: '/misiones/cargarmisiones',
            type: 'GET',
            headers: {
            'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                console.log(data);
                $.each(data, function(index, mision) {
                        var item = $("<div>").addClass("mision");

                        // División para el contenido textual
                        var contentDiv = $("<div>").addClass("mision-content");
                        contentDiv.append("<p>Titulo: " + mision.contenido.tituloContenido + "    Interes: " + mision.contenido.interes + "</p>");
                        contentDiv.append("<p>Contenido: " + mision.contenido.detalleContenido + "</p>");
                        
                        item.append(contentDiv);

                        // Creación del toggle con la estructura dada
                        var toggle = $("<label>").addClass("toggle").attr("for", "toggleID" + mision.idMision);
                        var input = $("<input>").addClass("toggle__input").attr({
                            type: "checkbox",
                            id: "toggleID" + mision.idMision
                        });
                        var track = $("<span>").addClass("toggle-track");
                        var indicator = $("<span>").addClass("toggle-indicator");
                        track.append(indicator);
                        toggle.append(input, track, document.createTextNode(" "));
                        toggle.append("<p><img src='/imgs/moneda.png' alt='Moneda' style='width: 18px; height: 18px;'>50</p>");
                        item.append(toggle);

                    $("#listaMisiones").append(item);

                    input.change(function() {
                        var estadoCheckbox = this.checked;
                        var idMision = $(this).attr('id').replace('toggleID', ''); // Suponiendo que el ID es 'toggleID' seguido del ID de la misión
                        var puntaje = 50; // Obtener el puntaje desde el texto del párrafo
                        console.log(data);
                        $.ajax({                       
                            url: '/misiones/actualizarmision',
                            type: 'PUT',
                            headers: {
                            'Authorization': 'Bearer ' + token
                            },
                            data: {
                                idMision: idMision,
                                estado: estadoCheckbox,
                                puntaje: puntaje // Enviar el puntaje junto con el estado
                            },
                            success: function(response) {
                                location.reload();
                                console.log('Puntaje actualizado correctamente:', response);
                            },
                            error: function() {
                                console.error('Error al actualizar la misión.');
                            }
                        });
                    });
                });
                var numMisiones = $('.mision').length;
                if (numMisiones === 0) {
                    agregar();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error al generar misiones:', errorThrown);
            }
        });
});

/*Hecho por melissa */

function agregar(){
    $.ajax({
                        url: '/misiones/generarmisiones',
                        type: 'POST',
                        headers: {
                        'Authorization': 'Bearer ' + token
                        },
                        success: function(data) {
                            if(data == false){
                                console.log("No hay mas misiones pa")
                            }else{
                                location.reload()
                            }
                        },
                        error: function(jqXHR, textStatus, errorThrown) {
                            console.error('Error al generar misiones:', errorThrown);
                        }
                    });
}
