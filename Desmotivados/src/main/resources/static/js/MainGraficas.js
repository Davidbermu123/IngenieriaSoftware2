$(document).ready(function() {
    // Variable para almacenar el gráfico actual
    var myChart;

    // Cargar IDs de tareas al cargar la página
    $.ajax({
        url: '/tareas/grafica-tareas-ids',
        type: 'GET',
        success: function(response) {
            var selectTask = $('#select-task');
            var selectTaskId = $('#select-task-id');

            response.forEach(function(task) {
                selectTask.append('<option value="' + task.graficasT + '">' + task.graficasT + '</option>');
                selectTaskId.append('<option value="' + task.graficasT + '">' + task.graficasT + '</option>');
            });
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar los IDs de tareas:', error);
        }
    });

    $('#select-graph').change(function() {
        var tipoGrafico = $(this).val();
        var endpoint;
        var params = {};

        if (tipoGrafico === 'misiones') {
            endpoint = '/tareas/grafica/';
        } else if (tipoGrafico === 'tareas') {
            endpoint = '/tareas/grafica-tareas';
            var fechaMin = $('#fecha-min').val();
            var fechaMax = $('#fecha-max').val();
            params.fechaMin = fechaMin;
            params.fechaMax = fechaMax;
        }

        $('#select-task').empty();
        $('#select-task-id').empty();

        if (tipoGrafico === 'tareas') {
            $('#task-selection').show();
            $('#task-id-selection').show();
        } else {
            $('#task-selection').hide();
            $('#task-id-selection').hide();
        }

        if (endpoint) {
            $.ajax({
                url: endpoint,
                type: 'GET',
                data: params,
                success: function(response) {
                    var data = response.map(function(item) {
                        return {
                            label: 'Tarea ' + item.graficasT,
                            data: [item.prioridadBaja, item.prioridadMedia, item.prioridadAlta],
                            backgroundColor: ['rgba(255, 99, 132, 0.5)', 'rgba(54, 162, 235, 0.5)', 'rgba(255, 206, 86, 0.5)'],
                            borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)'],
                            borderWidth: 1
                        };
                    });

                    // Destruir el gráfico existente antes de crear uno nuevo
                    if (myChart) {
                        myChart.destroy();
                    }

                    renderChart(data, tipoGrafico);
                },
                error: function(xhr, status, error) {
                    console.error('Error al cargar los datos para la gráfica:', error);
                }
            });
        }
    });

    $('#select-task-id').change(function() {
        var selectedTaskId = $(this).val();
        if (selectedTaskId) {
            // Ocultar la barra de selección de tarea
            $('#task-selection').hide();
            // Obtener los datos solo para el ID seleccionado
            $.ajax({
                url: '/tareas/grafica-tareas/' + selectedTaskId,
                type: 'GET',
                success: function(response) {
                    var data = [{
                        label: 'Tarea ' + response.graficasT,
                        data: [response.prioridadBaja, response.prioridadMedia, response.prioridadAlta],
                        backgroundColor: ['rgba(255, 99, 132, 0.5)', 'rgba(54, 162, 235, 0.5)', 'rgba(255, 206, 86, 0.5)'],
                        borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)'],
                        borderWidth: 1
                    }];

                    // Destruir el gráfico existente antes de crear uno nuevo
                    if (myChart) {
                        myChart.destroy();
                    }

                    renderChart(data, 'tareas');
                },
                error: function(xhr, status, error) {
                    console.error('Error al cargar los datos de la tarea para la gráfica:', error);
                }
            });
        }
    });

    function renderChart(data, tipoGrafico) {
        var ctx = document.getElementById('myChart').getContext('2d');
        var chartType = 'bar'; // Utilizamos un gráfico de barras para representar las tareas
        var chartLabel = 'Prioridades'; // Etiqueta para el eje Y

        myChart = new Chart(ctx, {
            type: chartType,
            data: {
                labels: ['Prioridad Baja', 'Prioridad Media', 'Prioridad Alta'], // Etiquetas para el eje X
                datasets: data
            },
            options: {
                scales: {
                    yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Cantidad de Tareas'
                        },
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    }
});
function logout() {
    // Mostrar un mensaje de confirmación al usuario
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    // Si el usuario confirma el logout, limpiar el token del almacenamiento local y redirigirlo a la página de inicio de sesión
    if (confirmLogout) {
        localStorage.removeItem('token');
        window.location.href = "/vistas/login.html"; 
    }
}

