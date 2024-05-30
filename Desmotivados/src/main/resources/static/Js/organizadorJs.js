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
    
    function cargarTareas() {
        $.ajax({
            url: '/Corganizador/mistareas',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(response) {
                if (response)  {
                    response.forEach(function(tarea) {
                        agregarTarea(tarea);
                    });
                } else {
                    $('#lista-tareas').append('<li>No hay tareas disponibles</li>'); // Si no hay tareas, muestra un mensaje indicándolo
                }
            },
            error: function(xhr, status, error) {
                Swal.fire("Error al cargar las tareas");
            }
        });
    }
     

    function guardarT() {
        let title = $("#Tareatitulo").val().trim();
        let description = $("#Tareadescripcion").val().trim();
        let startDate = new Date($("#FechaInicio").val());
        let endDate = new Date($("#FechaFin").val());
        let priority = $("#Tareaprioridad").val();
        let completed = false;
    
        // Validación de campos vacíos
        if (title === '' || description === '' || isNaN(startDate) || isNaN(endDate)) {
            Swal.fire("Por favor completa todos los campos");
            return;
        }
    
        // Validación de prioridad
        if (priority !== 'baja' && priority !== 'media' && priority !== 'alta') {
            Swal.fire("Por favor selecciona una prioridad");
            return;
        }
    
        // Validación de fechas y horas pasadas
        let currentDate = new Date();
        if (startDate < currentDate || endDate < currentDate) {
            Swal.fire("No puedes asignar tareas en fechas u horarios pasados");
            return;
        }
    
        let data = {
            titulo: title,
            descripcion: description,
            fechaInicio: startDate,
            fechaFinal: endDate,
            prioridad: priority,
            completado: completed
        };
    
        // Limpiar los campos del formulario
        limpiarCampos();
    
        $.ajax({
            url: '/Corganizador/mistareas',
            type: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
            },
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                agregarTarea(response); // Llama a la función para agregar la nueva tarea
            },
            error: function(xhr, status, error) {
                // Manejar errores si los hay
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
    
        var checkboxChecked = tarea.completado ? 'checked' : '';
        var checkboxDisabled = tarea.completado ? 'disabled' : '';
    
        // Formatear la fecha y la hora
        var fechaInicioFormateada = new Date(tarea.fechaInicio).toLocaleString();
        var fechaFinalFormateada = new Date(tarea.fechaFinal).toLocaleString();
    
        var editarOption = tarea.completado ? '' : '<a class="dropdown-item" href="Editar_Tareas.html">Modificar</a>';
    
        tareaElemento.html(`
            <div class="container mt-4">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="row">
                            <div class="col-sm-6">
                                <p><strong>Título:</strong> ${tarea.titulo}</p>
                                <p><strong>Descripción:</strong> ${tarea.descripcion}</p>
                            </div>
                            <div class="col-sm-6">
                                <p><strong>Fecha Inicio:</strong> ${fechaInicioFormateada}</p>
                                <p><strong>Fecha Final:</strong> ${fechaFinalFormateada}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 position-relative">
                        <p><strong>Prioridad:</strong> ${tarea.prioridad}</p>
                        <div class="form-check mt-2">
                            <input type="checkbox" class="form-check-input tarea-checkbox" id="tarea-${tarea.idTarea}" ${checkboxChecked} ${checkboxDisabled}>
                            <label class="form-check-label" for="tarea-${tarea.completado}">
                                ${tarea.completado ? 'Completada' : 'Completar'}
                            </label>
                            <p><img src="/imgs/moneda.png" alt="Descripción de la imagen" style="width: 20px; height: 20px;">20</p>                        
                        </div>
                    </div>
                    <div class="position-absolute top-0 end-0 mt-2">
                        <button type="button" class="btn btn-light dropdown-toggle mr-3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ≡
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item eliminar-btn" href="#">Eliminar</a>
                            ${editarOption}
                        </div>
                    </div>
                </div>
            </div>
        `);
    
        tareaElemento.find('.eliminar-btn').click(function() {
            eliminarTarea(tarea.idTarea);
        });
    
        tareaElemento.css('margin-bottom', '20px');
        contenedor.append(tareaElemento);
    
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
                headers: {
                    'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
                },
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
    
    $(document).on('change', '.tarea-checkbox', function() {
        let tareaId = $(this).attr('id').split('-')[1];
        let completada = $(this).is(':checked');
        
        if (completada && $(this).is(':disabled')) {
            return;
        }
        
        // Deshabilitar el checkbox después de marcar la tarea como completada
        $(this).prop('disabled', true);
        
        let puntaje = completada ? 20 : 0;
    
        $.ajax({
            url: '/Corganizador/actualizarPuntaje/' + tareaId,
            type: 'PUT',
            headers: {
                'Authorization': 'Bearer ' + token // Enviar el token en el encabezado de autorización
            },
            contentType: 'application/json',
            data: JSON.stringify({ puntaje: puntaje, completado: completada }),
            success: function(response) {
                console.log('Puntaje actualizado correctamente:', response);
            },
            error: function(xhr, status, error) {
                console.error('Error al actualizar el puntaje:', error);
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
    