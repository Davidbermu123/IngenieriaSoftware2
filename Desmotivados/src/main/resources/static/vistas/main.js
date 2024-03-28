document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('task-form');
    const message = document.getElementById('message');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const selectedTask = document.getElementById('select-task').value;
        const taskName = document.getElementById('task-name').value;
        const taskDate = document.getElementById('task-date').value;
        const taskTime = document.getElementById('task-time').value;
        const priority = document.getElementById('priority').value;

        if (selectedTask && taskName && taskDate && taskTime && priority) {
            // Muestra el mensaje de confirmación de la tarea seleccionada
            message.innerText = `La tarea "${selectedTask}" fue modificada.`;
            message.classList.remove('hidden');

            // Muestra el mensaje de éxito
            setTimeout(function() {
                message.innerText = 'Tarea modificada exitosamente.';
            }, 2000); // Muestra el mensaje de éxito después de 2 segundos

            // Limpia el formulario
            form.reset();
        } else {
            message.innerText = 'Por favor, llena todos los espacios.';
            message.classList.remove('hidden');
        }
    });
});