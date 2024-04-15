function guardarAprender() {
    let identification = $("#cajaId").val();
    let name = $("#cajaNombre").val();
    let description = $("#cajaDescripcion").val();
    let urlLearn = $("#cajaUrlAprender").val();
    let urlImage = $("#cajaUrlImagen").val();
    let urlGame = $("#cajaUrlJuego").val();
    
    console.log(name);
    console.log(urlImage);
    $.ajax({
        url: '/aprender/verificarExistencia/' + identification,
        type: 'GET',
        success: function(response) {
            if (response.existe) {
                // Si el elemento ya existe, mostrar una ventana de confirmación
                var confirmacion = confirm('El elemento ya existe en la base de datos. ¿Desea reemplazarlo con la nueva información?');
                if (confirmacion) {
                    // Si el usuario acepta, guardar el nuevo elemento
                    guardarNuevoElemento(identification, name, description, urlLearn, urlGame, urlImage);
                } else {
                    // Si el usuario cancela, no hacer nada
                    console.log('Guardado cancelado');
                }
            } else {
                // Si el elemento no existe, guardar directamente el nuevo elemento
                guardarNuevoElemento(identification, name, description, urlLearn, urlGame, urlImage);
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al verificar la existencia:', error);
        }
    });
}

function guardarNuevoElemento(identification, name, description, urlLearn, urlGame, urlImage) {
    let data = {
        id: identification,
        nombre: name,
        descripcion: description,
        urlaprender: urlLearn,
        urljuego: urlGame,
        urlimagen: urlImage
    };
    $.ajax({
        url: '/aprender/guardar',
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