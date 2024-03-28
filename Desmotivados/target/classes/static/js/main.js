document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('task-form');
    const message = document.getElementById('message');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const taskName = document.getElementById('task-name').value;
        const taskDate = document.getElementById('task-date').value;
        const taskTime = document.getElementById('task-time').value;
        const priority = document.getElementById('priority').value;

        if (taskName && taskDate && taskTime && priority) {
            message.innerText = 'La tarea fue correctamente editada.';
            message.classList.remove('hidden');
        } else {
            message.innerText = 'Por favor, llenar todos los espacios.';
            message.classList.remove('hidden');
        }

        // Puedes agregar aquí más lógica según tus necesidades
    });
});