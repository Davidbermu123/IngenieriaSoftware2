function verificarTokenYRedireccionarALogin() {
    let token = localStorage.getItem('token');

    // Verificar si el token está presente
    if (token === null) {
        // Si el token no está presente, redirigir al usuario al inicio de sesión
        window.location.href = '/vistas/login.html';
    } else {
        var tokenParts = token.split('.');
        var tokenPayload = JSON.parse(atob(tokenParts[1]));
        var username=tokenPayload.sub;
        console.log(username);
    }
}

verificarTokenYRedireccionarALogin();
function guardarIntereses() {
    var intereses = [];
    var checkboxes = document.querySelectorAll('input[name="interes"]:checked');
    checkboxes.forEach(function(checkbox) {
        intereses.push(checkbox.value);
       
    });
    
    mostrarIntereses(intereses);
   
}

function mostrarIntereses(intereses) {
    var listaIntereses = document.getElementById('interesesSeleccionados');
    listaIntereses.innerHTML = '';
    intereses.forEach(function(interes) {
        var li = document.createElement('li');
        li.textContent = interes;
        listaIntereses.appendChild(li);
    });
    listaIntereses.style.display = "block"; // Mostrar la lista de intereses
    console.log(intereses);
   
}
function Siguiente(){
    window.location.href = "/index.html"
}