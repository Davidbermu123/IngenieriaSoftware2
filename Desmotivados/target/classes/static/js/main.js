document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('task-form');
    const message = document.getElementById('message');
    const tasks = {
        tarea1: { 
            idTarea: 1,
            titulo: 'Nombre de la Tarea 1', 
            descripcion: 'Descripción de la Tarea 1',
            fechaInicio: '2024-04-01', 
            fechaFinal: '2024-04-02', 
            prioridad: 'alta' 
        },
        tarea2: { 
            idTarea: 2,
            titulo: 'Nombre de la Tarea 2', 
            descripcion: 'Descripción de la Tarea 2',
            fechaInicio: '2024-04-02', 
            fechaFinal: '2024-04-03', 
            prioridad: 'media' 
        },
        tarea3: { 
            idTarea: 3,
            titulo: 'Nombre de la Tarea 3', 
            descripcion: 'Descripción de la Tarea 3',
            fechaInicio: '2024-04-03', 
            fechaFinal: '2024-04-04', 
            prioridad: 'baja' 
        }
    };

    const selectTask = document.getElementById('select-task');
    const taskIdInput = document.getElementById('task-id');
    const taskNameInput = document.getElementById('task-name');
    const taskDescriptionInput = document.getElementById('task-description');
    const taskStartDateInput = document.getElementById('task-start-date');
    const taskEndDateInput = document.getElementById('task-end-date');
    const priorityInput = document.getElementById('priority');
    const guardarButton = document.getElementById('guardar');

    selectTask.addEventListener('change', function() {
        const selectedTask = selectTask.value;
        taskIdInput.value = tasks[selectedTask].idTarea;
        taskNameInput.value = tasks[selectedTask].titulo;
        taskDescriptionInput.value = tasks[selectedTask].descripcion;
        taskStartDateInput.value = tasks[selectedTask].fechaInicio;
        taskEndDateInput.value = tasks[selectedTask].fechaFinal;
        priorityInput.value = tasks[selectedTask].prioridad;
    });

    guardarButton.addEventListener('click', function(event) {
        event.preventDefault();

        const selectedTask = selectTask.value;
        const originalTask = tasks[selectedTask];
        const modifiedTask = {
            idTarea: originalTask.idTarea,
            titulo: taskNameInput.value,
            descripcion: taskDescriptionInput.value,
            fechaInicio: taskStartDateInput.value,
            fechaFinal: taskEndDateInput.value,
            prioridad: priorityInput.value
        };

        if (selectedTask && modifiedTask.titulo && modifiedTask.descripcion && modifiedTask.fechaInicio && modifiedTask.fechaFinal && modifiedTask.prioridad) {
            // Crear mensaje de confirmación
            const confirmationMessage = "¿Estás seguro de querer actualizar la tarea \"" + selectedTask + "\" con los siguientes cambios?\n\n" +
                                        "Título: " + modifiedTask.titulo + "\n" +
                                        "Descripción: " + modifiedTask.descripcion + "\n" +
                                        "Fecha de Inicio: " + modifiedTask.fechaInicio + "\n" +
                                        "Fecha de Finalización: " + modifiedTask.fechaFinal + "\n" +
                                        "Prioridad: " + modifiedTask.prioridad;

            // Mostrar mensaje de confirmación en una ventana emergente
            if (confirm(confirmationMessage)) {
                // Si el usuario confirma, realizar la actualización aquí
                tasks[selectedTask] = modifiedTask;
                message.innerText = "La tarea \"" + selectedTask + "\" ha sido modificada.";
                message.classList.remove('hidden');
            } else {
                // Si el usuario cancela, no hacer nada
                return false;
            }
        } else {
            message.innerText = 'Por favor, llena todos los campos.';
            message.classList.remove('hidden');
        }
    });
});