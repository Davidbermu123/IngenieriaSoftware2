function guardarDatos(){
    localStorage.setItem('name', $("#usuarioname").val());
    localStorage.setItem('lastname', $("#usuarioapellido").val());
    localStorage.setItem('alias', $("#usuarioalias").val());
    localStorage.setItem('uni', $("#usuariouniversidad").val());
    localStorage.setItem('career', $("#usuariocarrera").val());
    localStorage.setItem('period', $("#usuariosemestre").val());
    localStorage.setItem('pet', $("#usuarionmascota").val());
    localStorage.setItem('contrasena', $("#usuariocontrasena").val());
    window.location.href = "/vistas/formularioVista.html";
}


function saveUsuario(){
    
    var name = localStorage.getItem('name');
    var lastname = localStorage.getItem('lastname');
    var alias = localStorage.getItem('alias');
    var uni = localStorage.getItem('uni');
    var career = localStorage.getItem('career');
    var period = localStorage.getItem('period');
    var pet = localStorage.getItem('pet');
    var contrasena = localStorage.getItem('contrasena');

    var intereses = [];
    var checkboxes = document.querySelectorAll('input[name="interes"]:checked');
    checkboxes.forEach(function(checkbox) {
        intereses.push(checkbox.value);
    });
    
    var interesesString = intereses.join(',');

    if (name === '' || lastname === '' || alias === '' || uni === '' || career === '' || period === '' || pet === '' || contrasena === '' || interesesString == '') {
        alert('Por favor, complete todos los campos.');
        return; // Detener la ejecución si algún campo está vacío
    }
    let data = {
        nombre: name,
        apellido: lastname,
        username: alias,
        universidad: uni,
        carrera: career,
        semestre: period,
        nmascota: pet,
        password: contrasena,
        intereses: interesesString,
        monedas: 0,
    }
    localStorage.clear();
    $.ajax({
        url: '/auth/register',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            localStorage.setItem('token', response.token);
            window.location.href = "/index.html";
        },
        error: function(xhr, status, error) {
            alert('Este usuario ya existe, por favor escoger otro', error);
            window.location.href = "/vistas/registro.html";
        }
    });
}
function regresar() {
    window.location.href = "/index.html";
}