<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Estadistica del alumno <strong>${alumno.nombre}
	${alumno.apaterno} ${alumno.amaterno}</strong></h4>
	
</div>
<div class="panel-body">
<!-- <button class="btn btn-success pull-right"> <i class="fa fa-file-text"></i> Visualizar Evaluaciones</button> -->
	<input type="hidden" id="semanticos" value='${semanticos}'>
	<input type="hidden" id="max" value='${max}'>

	<!-- Estadistica -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<div id="grafico" style="width: 900px; height: 600px">
		<i class="fa fa-spinner fa-pulse"></i> Creando grafico por favor
		espere.
		<div>

			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<script type="text/javascript">
				var text = $('#semanticos').val();

				if (text.substring(text.length - 1) == ";") {
					text = text.slice(0, -1)
				}

				var list = text.split(';');
				var info = [];
				var tables = [];
				var max = $('#max').val();
				var index = 0;
				tables[index] = [ 'Juego', 'Avance Ideal','Alcanzado por el alumno' ];

				$.each(list, function(key, value) {
					info[key] = jQuery.parseJSON(value);
					tables[++index] = [ info[key].semantico, info[key].ideal,info[key].avance ];
					console.log(tables[index]);

				});

				google.load("visualization", "1", {
					packages : [ "corechart" ]
				});
				google.setOnLoadCallback(drawChart);
				function drawChart() {
					var data = google.visualization.arrayToDataTable(tables);
					var options = {
						title : 'Evolución del alumno.',
						curveType : 'function',
						hAxis : {
							title : 'Campo Semantico',
							titleTextStyle : {
								color : '#333'
							}
						},
						vAxis : {
							title : 'Puntuaciónn alcanzada en las actividades',
							minValue : 0,
							maxValue : max,
							direction : 1
						},
						pointSize : 5,
					};

					var chart = new google.visualization.LineChart(document
							.getElementById('grafico'));
					chart.draw(data, options);
				}
			</script>
			<!-- Fin Estadistica -->

		</div>
		<jsp:include page="common/footer.jsp" />