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

function eliminarObjTienda(codigo){
    var confirmacion = confirm('¿Esta seguro de eliminar el obj de la tienda?');
    if(confirmacion){
        $.ajax({
            url : '/tienda/eliminarTienda/' + codigo,
            type: 'DELETE',
            headers: {
            'Authorization': 'Bearer ' + token
            },
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