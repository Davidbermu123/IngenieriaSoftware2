function saludar(){
    console.log("Hola mundo");
}

// Función para abrir la ventana emergente
function abrirVentana() {
    document.getElementById('miVentanaModal').style.display = 'block';
}

// Función para cerrar la ventana emergente
function cerrarVentana() {
    document.getElementById('miVentanaModal').style.display = 'none';
}

function guardarT() {
    let title = $("#Tareatitulo").val();
    let description = $("#Tareadescripcion").val();
    let startDate = $("#FechaInicio").val();
    let endDate = $("#FechaFin").val();
    let priority = $("#Tareaprioridad").val();

    let a = new Date(startDate);
    
    console.log(a);

    let data ={
        titulo: title,
        descripcion: description,
        fechaInicio: startDate,
        fechaFinal: endDate,
        prioridad: priority
    }

    $.ajax({
        url: '/Corganizador/mistareas',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            console.log('Usuario guardado correctamente:', response);
            // Aquí puedes realizar alguna acción adicional si lo necesitas, como redirigir a otra página.
        },
        error: function(xhr, status, error) {
            console.error('Error al guardar el usuario:', error);
        }
    })
}

function mostrarTarea(tarea) {
    // Crear un elemento para mostrar la tarea
    var tareaElemento = document.createElement('div');
    tareaElemento.textContent = 'Descripción: ' + tarea.descripcion + ', Fecha de inicio: ' + tarea.fechaInicio + ', Hora de inicio: ' + tarea.horaInicio + ', Fecha de fin: ' + tarea.fechaFin + ', Hora de fin: ' + tarea.horaFin;

    // Agregar una clase de prioridad según la prioridad de la tarea
    if (tarea.prioridad === 'alta') {
        tareaElemento.classList.add('prioridad-alta');
    } else if (tarea.prioridad === 'media') {
        tareaElemento.classList.add('prioridad-media');
    } else if (tarea.prioridad === 'baja') {
        tareaElemento.classList.add('prioridad-baja');
    }

    // Agregar la tarea al contenedor de tareas
    document.getElementById('contenedorTareas').appendChild(tareaElemento);
}
