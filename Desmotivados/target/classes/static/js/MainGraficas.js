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

$(document).ready(function () {
    var currentChart = null; // Variable para almacenar el gráfico actual

    function cargarGraficoPrioridadTareas(data) {
        mostrarGrafico('#grafico-prioridad-tareas');
        var ctx = document.getElementById('grafico-prioridad-tareas').getContext('2d');
        currentChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Alta', 'Media', 'Baja'],
                datasets: [{
                    label: 'Cantidad de Tareas por Prioridad',
                    data: [data.alta || 0, data.media || 0, data.baja || 0],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)', // Color para Alta
                        'rgba(54, 162, 235, 0.2)', // Color para Media
                        'rgba(255, 206, 86, 0.2)' // Color para Baja
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }

    function cargarGraficoTareasCompletadasSemanal(scatterData) {
        mostrarGrafico('#grafico-tareas-completadas-semanal');
        var ctx = document.getElementById('grafico-tareas-completadas-semanal').getContext('2d');
        currentChart = new Chart(ctx, {
            type: 'scatter',
            data: {
                datasets: [{
                    label: 'Tareas Completadas Semanalmente',
                    data: scatterData,
                    pointRadius: 5,
                    backgroundColor: 'rgba(255, 99, 132, 0.5)', // Cambiar color si lo deseas
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1,
                    showLine: true // Mostrar líneas que conectan los puntos
                }]
            },
            options: {
                scales: {
                    x: {
                        type: 'time',
                        time: {
                            unit: 'week',
                            displayFormats: {
                                week: 'MMM d'
                            }
                        }
                    },
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: 'Hora'
                        },
                        ticks: {
                            stepSize: 1
                        }
                    }
                }
            }
        });
    }

    function cargarGraficoMisionesCompletadasSemanal(scatterData) {
        mostrarGrafico('#grafico-misiones-completadas-semanal');
        var ctx = document.getElementById('grafico-misiones-completadas-semanal').getContext('2d');
        currentChart = new Chart(ctx, {
            type: 'scatter',
            data: {
                datasets: [{
                    label: 'Misiones Completadas Semanalmente',
                    data: scatterData,
                    pointRadius: 5,
                    backgroundColor: 'rgba(75, 192, 192, 0.5)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1,
                    showLine: false// Mostrar líneas que conectan los puntos
                }]
            },
            options: {
                scales: {
                    x: {
                        type: 'time',
                        time: {
                            unit: 'week',
                            displayFormats: {
                                week: 'MMM d'
                            }
                        }
                    },
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }

    $('#tipo-grafico').change(function () {
        var tipo = $(this).val();
        if (tipo === 'tareas') {
            cargarTareasCompletadasSemanal();
        } else if (tipo === 'misiones') {
            cargarMisionesCompletadasSemanal();
        } else {
            cargarCantidadTareasPorPrioridad();
        }
    });

    function cargarCantidadTareasPorPrioridad() {
        $.ajax({
            url: '/tareas/grafica-prioridades',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function (response) {
                cargarGraficoPrioridadTareas(response);
            },
            error: function (xhr, status, error) {
                console.error('Error al cargar los datos:', error);
            }
        });
    }

    function cargarTareasCompletadasSemanal() {
        $.ajax({
            url: '/graficos/tareas-completadas-semanal',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function (response) {
                console.log(response);
                cargarGraficoTareasCompletadasSemanal(response);
            },
            error: function (xhr, status, error) {
                console.error('Error al cargar los datos:', error);
            }
        });
    }

    function cargarMisionesCompletadasSemanal() {
        $.ajax({
            url: '/misiones/misiones-completadas-semanal',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function (response) {
                console.log(response);
                cargarGraficoMisionesCompletadasSemanal(response);
            },
            error: function (xhr, status, error) {
                console.error('Error al cargar los datos:', error);
            }
        });
    }

    function cargarMisiones() {
        $.ajax({
            url: '/misiones/getmisiones',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function (response) {
                if(response == null){
                    console.log("NULL");
                }else{
                    console.log(response);
                }
            },
            error: function (xhr, status, error) {
                console.error('Error al cargar los datos de las misiones:', error);
            }
        });
    }


    function mostrarGrafico(selector) {
        $('#contenedor-graficos canvas').hide();
        $(selector).show();
    }

    cargarCantidadTareasPorPrioridad();
    cargarMisiones();
});