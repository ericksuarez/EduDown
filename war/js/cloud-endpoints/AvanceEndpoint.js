function init() {
	console.log("Avance");
	gapi.client.load('avanceendpoint', 'v1', null,
			'http://localhost:8888/_ah/api');
	
}

function insertAvance(timer, term, error, score) {

	var requestData = {};
	requestData.idJuegos = $('#juego').val();
	requestData.idAlumno = $('#alumno').val();
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


/**
 * @author Erick
 */
