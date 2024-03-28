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

    selectTask.addEventListener('change', function() {
        const selectedTask = selectTask.value;
        taskNameInput.value = tasks[selectedTask].name;
        taskDateInput.value = tasks[selectedTask].date;
        taskTimeInput.value = tasks[selectedTask].time;
        priorityInput.value = tasks[selectedTask].priority;
    });

    form.addEventListener('submit', function(event) {
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
            // Comparar características originales con modificadas
            const differences = [];
            for (const key in originalTask) {
                if (originalTask[key] !== modifiedTask[key]) {
                    differences.push(`${key}: ${originalTask[key]} -> ${modifiedTask[key]}`);
                }
            }

            // Muestra el mensaje de confirmación con las diferencias
            if (differences.length > 0) {
                message.innerText = `La tarea "${selectedTask}" ha sido modificada. Cambios realizados:\n${differences.join('\n')}`;
            } else {
                message.innerText = `No se han realizado cambios en la tarea "${selectedTask}".`;
            }
            message.classList.remove('hidden');
        } else {
            message.innerText = 'Por favor, llena todos los campos.';
            message.classList.remove('hidden');
        }
    });
});