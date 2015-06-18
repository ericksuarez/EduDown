function init() {
	console.log("Avance");
	gapi.client.load('avanceendpoint', 'v1', null,
			'http://localhost:8888/_ah/api');
	
}

function insertAvance(timer, term, error, score) {

    /*var textAl = $('#alumno').val();
    var textJu = $('#juego').val();
    
    var alumno = jQuery.parseJSON(textAl);
    var juego = jQuery.parseJSON(textJu);*/
    
    $('#idjuego').val(juego.idJuegos.id);
    
	var requestData = {};
	/*requestData.Juegos_idJuegos = juego;
	requestData.Alumno_idAlumno = alumno;*/
	requestData.errores = error;
	requestData.fecha = new Date().toISOString();
	requestData.puntuacion = score;
	requestData.tiempoTerminado = timer;
	
	
	gapi.client.avanceendpoint.insertAvance(requestData).execute(
			function(resp) {
				if (!resp.code) {
					console.log(resp.idAvance.id);
					$('#idAvance').val(resp.idAvance.id);
				}
			});

}


/**
 * @author Erick
 */
