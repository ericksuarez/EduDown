<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Estadistica del alumno ${alumno.nombre}
	${alumno.apaterno} ${alumno.amaterno}</h4>
</div>
<div class="panel-body">

	<input id="semanticos" value='${semanticos}'>

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
				var datos = [];
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
					// 					var data = google.visualization.arrayToDataTable([
					// 							[ 'Juego', 'Avance Ideal','Alcanzado por el alumno' ],
					// 							//semantico - avance ideal - avacne por alumno
					// 							[ 'Alimentos y bebidas', 0, 3 ],
					// 							[ 'Animales Acuatiocos', 2, 5 ],
					// 							[ 'Aniamles de la granja', 5, 4 ],
					// 							[ 'Animales del zoologico', 5, 3 ],
					// 							[ 'Colores', 6, 5 ],
					// 							[ 'Medios de Trasporte', 0, 10 ],
					// 							[ 'Partes del Cuerpo', 2, 7 ],
					// 							[ 'Prendas de Vestir', 2, 7 ]

					// 					]);

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
							maxValue : 11,
							direction : 1,
							ticks : [ {
								v : 0,
								f : "0"
							}, {
								v : 1,
								f : "1"
							}, {
								v : 2,
								f : "2"
							}, {
								v : 3,
								f : "3"
							}, {
								v : 4,
								f : "4"
							}, {
								v : 5,
								f : "5"
							}, {
								v : 6,
								f : "6"
							}, {
								v : 7,
								f : "7"
							}, {
								v : 8,
								f : "8"
							}, {
								v : 9,
								f : "9"
							}, {
								v : 10,
								f : "10"
							}, ]
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