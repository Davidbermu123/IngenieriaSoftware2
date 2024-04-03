$(document).ready(function() {
    $('#select-task').change(function() {
        var tituloTarea = $(this).val();
        if (tituloTarea) {
            $.ajax({
                url: '/tareas/grafica/' + tituloTarea,
                type: 'GET',
                success: function(response) {
                    var data = response.map(function(tarea) {
                        return {
                            x: new Date(tarea.fechaFinalizacion),
                            y: tarea.tareasDiarias
                        };
                    });

                    var ctx = document.getElementById('myChart').getContext('2d');
                    var myChart = new Chart(ctx, {
                        type: 'bar',
                        data: {
                            datasets: [{
                                label: 'Tareas Diarias',
                                data: data,
                                backgroundColor: 'rgba(255, 99, 132, 0.5)',
                                borderColor: 'rgba(255, 99, 132, 1)',
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                xAxes: [{
                                    type: 'time',
                                    time: {
                                        unit: 'day'
                                    }
                                }],
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                },
                error: function(xhr, status, error) {
                    console.error('Error al cargar los datos para la gráfica:', error);
                }
            });
        }
    });
});