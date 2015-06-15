function init() {
	console.log("Avance");
	gapi.client.load('avanceendpoint', 'v1', null,
			'http://localhost:8888/_ah/api');
	
}

function insertAvance(timer, term, error, score) {

	var requestData = {};
	requestData.idJuegos = '${juego}';
	requestData.idAlumno = '${sesionAlumno}';
	requestData.errores = error;
	requestData.fecha = "2015-06-14";
	requestData.puntuacion = score;
	requestData.terminado = term;
	requestData.tiempoTerminado = timer;
	
	
	gapi.client.avanceendpoint.insertAvance(requestData).execute(
			function(resp) {
				if (!resp.code) {
					console.log(resp.puntuacion + ":" + resp.fecha + ":"
							+ resp.terminado);
				}
			});
}

function updateAvance(timer, term, error, score) {

	var requestData = {};
	requestData.idAvance = $('#idJuego').attr('id');
	requestData.idJuegos = '${juego.idJuegos}';
	requestData.idAlumno = '${sesionAlumno}';
	requestData.fecha = "2015-06-14";
	requestData.tiempo = timer;
	requestData.terminado = term;
	requestData.errores = error;
	requestData.puntuacion = score;
	gapi.client.avanceendpoint.updateAvance(requestData).execute(
			function(resp) {
				if (!resp.code) {
					console.log(resp.puntuacion + ":" + resp.fecha + ":"
							+ resp.terminado);
				}
			});
}

/**
 * @author Erick
 */
