    // Función para abrir la ventana emergente
    function abrirVentana() {
        $('#miVentanaModal').css('display', 'block');
    }

    // Función para cerrar la ventana emergente
    function cerrarVentana() {
        $('#miVentanaModal').css('display', 'none');
    }

    $(document).ready(function() {
        cargarTareas(); // Llama a la función para cargar las tareas cuando la página se haya cargado completamente
    });
    
    // Función para cargar las tareas desde el backend
    function cargarTareas() {
        $.ajax({
            url: '/Corganizador/tareas',
            type: 'GET',
            success: function(tareas) {
                tareas.forEach(function(tarea) {
                    agregarTarea(tarea);
                });
            },
            error: function() {
                alert('Error al cargar las tareas');
            }
        });
    }

    function guardarT() {
        let title = $("#Tareatitulo").val().trim();
        let description = $("#Tareadescripcion").val().trim();
        let startDate = new Date($("#FechaInicio").val());
        let endDate = new Date($("#FechaFin").val());
        let priority = $("#Tareaprioridad").val();
    
        // Validación de campos vacíos
        if (title === '' || description === '' || isNaN(startDate) || isNaN(endDate)) {
            alert('Por favor completa todos los campos.');
            return;
        }
    
        // Validación de prioridad
        if (priority !== 'baja' && priority !== 'media' && priority !== 'alta') {
            alert('Por favor selecciona una prioridad.');
            return;
        }
    
        // Validación de fechas y horas pasadas
        let currentDate = new Date();
        if (startDate < currentDate || endDate < currentDate) {
            alert('No puedes asignar tareas en fechas u horarios pasados.');
            return;
        }
    
        let data = {
            titulo: title,
            descripcion: description,
            fechaInicio: startDate,
            fechaFinal: endDate,
            prioridad: priority
        };
    
        // Limpiar los campos del formulario
        limpiarCampos();
    
        $.ajax({
            url: '/Corganizador/mistareas',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log('Usuario guardado correctamente:', response);
                agregarTarea(response);
                // Aquí puedes realizar alguna acción adicional si lo necesitas, como redirigir a otra página.
            },
            error: function(xhr, status, error) {
                console.error('Error al guardar el usuario:', error);
            }
        });
    }
    

    // Función para convertir las prioridades en valores numéricos
    function prioridadANumero(prioridad) {
        switch (prioridad) {
            case 'alta':
                return 3;
            case 'media':
                return 2;
            case 'baja':
                return 1;
            default:
                return 0; // Por si acaso hay alguna prioridad no definida
        }
    }

    function agregarTarea(tarea) {
        var contenedor = $('#contenedorTareas');
        var tareaElemento = $('<div>');
        tareaElemento.attr('id', 'tarea-' + tarea.idTarea);
        // Convierte la prioridad de la tarea a un valor numérico y lo asigna como atributo

        tareaElemento.attr('data-prioridad-num', prioridadANumero(tarea.prioridad));

        tareaElemento.addClass('tarea');
        switch (tarea.prioridad) {
            case 'alta':
                tareaElemento.addClass('isla-alta');
                break;
            case 'media':
                tareaElemento.addClass('isla-media');
                break;
            case 'baja':
                tareaElemento.addClass('isla-baja');
                break;
            default:
                break;
        }
        tareaElemento.html(`
        <div class="container mt-4"> <!-- Container con margen superior -->
        <div class="row"> <!-- Row para alinear los elementos en una fila -->
            <div class="col-sm-8"> <!-- Columnas 1 y 2: Título, Descripción, Fecha y Hora de Inicio y Final -->
                <div class="row">
                    <div class="col-sm-6"> <!-- Columna 1: Título y Descripción -->
                        <p><strong>Título:</strong> ${tarea.titulo}</p>
                        <p><strong>Descripción:</strong> ${tarea.descripcion}</p>
                    </div>
                    <div class="col-sm-6"> <!-- Columna 2: Fecha y Hora de Inicio y Final -->
                        <p><strong>Fecha Inicio:</strong> ${tarea.fechaInicio}</p>
                        <p><strong>Fecha Final:</strong> ${tarea.fechaFinal}</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 position-relative"> <!-- Columna 3: Prioridad con Checkbox -->
                <p><strong>Prioridad:</strong> ${tarea.prioridad}</p>
                <div class="form-check mt-2">
                    <input type="checkbox" class="form-check-input tarea-checkbox" id="tarea-${tarea.idTarea}">
                    <label class="form-check-label" for="tarea-${tarea.idTarea}">Completada</label>
                </div>
            </div>
            <!-- Contenedor para el botón de opciones -->
            <div class="position-absolute top-0 end-0 mt-2">
                <button type="button" class="btn btn-light dropdown-toggle mr-3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ≡
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item eliminar-btn" href="#">Eliminar</a>
                    <a class="dropdown-item modificar-btn" href="Editar_Tareas.html">Modificar</a>
                </div>
            </div>
        </div>
    </div>
        `);


        tareaElemento.find('.eliminar-btn').click(function() {
            eliminarTarea(tarea.idTarea);
        });
        // Agrega un margen inferior a cada tarea para separarlas visualmente
        tareaElemento.css('margin-bottom', '20px');
        // Agrega la nueva tarea al contenedor
        contenedor.append(tareaElemento);

        // Ordena las tareas ya existentes basadas en su prioridad
        ordenarTareasPorPrioridad();
    }

    function ordenarTareasPorPrioridad() {
        var contenedor = $('#contenedorTareas');
        var tareas = contenedor.children('div').get();
    
        tareas.sort(function(a, b) {
            var prioridadA = $(a).data('prioridad-num');
            var prioridadB = $(b).data('prioridad-num');
            return prioridadB - prioridadA; // Ordena de mayor a menor prioridad
        });
    
        $.each(tareas, function(idx, itm) {
            contenedor.append(itm);
        });
    }
    
    function eliminarTarea(idTarea) {
        var confirmacion = confirm('¿Estás seguro de que quieres eliminar esta tarea?');
        if (confirmacion) {
            $.ajax({
                url: '/Corganizador/eliminar/' + idTarea,
                type: 'DELETE',
                success: function(response) {
                    console.log('Tarea eliminada correctamente:', response);
                    $('#tarea-' + idTarea).remove(); // Elimina solo el elemento correspondiente a la tarea
                },
                error: function(xhr, status, error) {
                    console.error('Error al eliminar la tarea:', error);
                }
            });
        } else {
            console.log('Eliminación cancelada');
        }
    }
    
    // Función para limpiar los campos del formulario
    function limpiarCampos() {
        $('#Tareatitulo').val('');
        $('#Tareadescripcion').val('');
        $('#FechaInicio').val('');
        $('#FechaFin').val('');
        $('#Tareaprioridad').val('');
    }
    

    