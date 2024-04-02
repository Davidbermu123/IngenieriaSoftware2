function guardarAprender() {
        let identification = $("#cajaId").val();
        let name = $("#cajaNombre").val();
        let description = ($("#cajaDescripcion").val());
        let urlLearn = ($("#cajaUrlAprender").val());
        let urlGame = $("#cajaUrlJuego").val();
let data = {
            id: identification,
            nombre: name,
            descripcion: description,
            urlaprender: urlLearn,
            urljuego: urlGame
        };
$.ajax({
            url: '/aprender/guardar',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log('Usuario guardado correctamente:', response);
            },
            error: function(xhr, status, error) {
                console.error('Error al guardar el usuario:', error);
            }
        });
}

function eliminarAprender(){
    var confirmacion = confirm('¿Esta seguro de eliminar la tarea?');
    var idAprender = $("#cajaId2").val();
    if(confirmacion){
        $.ajax({
            url : '/aprender/eliminaraprender/' + idAprender,
            type: 'DELETE',
            success : function(response){
                console.log('Tarea eliminada correctamente: ', response);
            },
            error: function(xhr, status, error){
                console.error('Error al eliminar la tarea: ', error);
            }
        });
    }else{
        console.log('Eliminacion cancelada');
    }
}