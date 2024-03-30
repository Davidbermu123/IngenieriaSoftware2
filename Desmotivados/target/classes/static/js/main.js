
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('task-form');
    const message = document.getElementById('message');
    const tasks = {
        tarea1: { name: 'Nombre de la Tarea 1', date: '2024-04-01', time: '12:00', priority: 'alta' },
        tarea2: { name: 'Nombre de la Tarea 2', date: '2024-04-02', time: '15:30', priority: 'media' },
        tarea3: { name: 'Nombre de la Tarea 3', date: '2024-04-03', time: '09:00', priority: 'baja' }
    };

    const selectTask = document.getElementById('select-task');
    const taskNameInput = document.getElementById('task-name');
    const taskDateInput = document.getElementById('task-date');
    const taskTimeInput = document.getElementById('task-time');
    const priorityInput = document.getElementById('priority');
    const guardarButton = document.getElementById('guardar');

    selectTask.addEventListener('change', function() {
        const selectedTask = selectTask.value;
        taskNameInput.value = tasks[selectedTask].name;
        taskDateInput.value = tasks[selectedTask].date;
        taskTimeInput.value = tasks[selectedTask].time;
        priorityInput.value = tasks[selectedTask].priority;
    });

    guardarButton.addEventListener('click', function(event) {
        event.preventDefault();

        const selectedTask = selectTask.value;
        const originalTask = tasks[selectedTask];
        const modifiedTask = {
            name: taskNameInput.value,
            date: taskDateInput.value,
            time: taskTimeInput.value,
            priority: priorityInput.value
        };

        if (selectedTask && modifiedTask.name && modifiedTask.date && modifiedTask.time && modifiedTask.priority) {
            // Crear mensaje de confirmación
            const confirmationMessage = "¿Estás seguro de querer actualizar la tarea \"" + selectedTask + "\" con los siguientes cambios?\n\n" +
                                        "Nombre: " + modifiedTask.name + "\n" +
                                        "Fecha: " + modifiedTask.date + "\n" +
                                        "Hora: " + modifiedTask.time + "\n" +
                                        "Prioridad: " + modifiedTask.priority;

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