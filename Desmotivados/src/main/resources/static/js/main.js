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
            const modal = document.createElement('div');
            modal.classList.add('modal');
            const modalContent = `
                <p>¿Estás seguro de querer actualizar la tarea "${selectedTask}" con los siguientes cambios?</p>
                <ul>
                    <li>Nombre: ${modifiedTask.name}</li>
                    <li>Fecha: ${modifiedTask.date}</li>
                    <li>Hora: ${modifiedTask.time}</li>
                    <li>Prioridad: ${modifiedTask.priority}</li>
                </ul>
                <button id="confirmar">Actualizar</button>
                <button id="cancelar">Cancelar</button>
            `;
            modal.innerHTML = modalContent;
            document.body.appendChild(modal);

            const confirmarButton = document.getElementById('confirmar');
            const cancelarButton = document.getElementById('cancelar');

            confirmarButton.addEventListener('click', function() {
                // Realizar la actualización aquí
                tasks[selectedTask] = modifiedTask;
                message.innerText = `La tarea "${selectedTask}" ha sido modificada.`;
                message.classList.remove('hidden');
                modal.remove();
            });

            cancelarButton.addEventListener('click', function() {
                window.location.href = 'index.html'; // Redirige a la página de inicio
            });
        } else {
            message.innerText = 'Por favor, llena todos los campos.';
            message.classList.remove('hidden');
        }
    });
});