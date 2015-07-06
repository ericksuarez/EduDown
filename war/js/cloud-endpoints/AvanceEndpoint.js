function init() {
	console.log("Avance");
	gapi.client.load('avanceendpoint', 'v1', null,'http://localhost:8888/_ah/api'); 
//	gapi.client.load('avanceendpoint', 'v1', null,'https://edu-down.appspot.com/_ah/api/');
}

function insertAvance(timer, term, error, score) {

    //var textAl = $('#alumno').val(); 
    //var alumno = jQuery.parseJSON(textAl);
	
    var textJu = $('#juego').val();
    var juego = jQuery.parseJSON(textJu);
    
    $('#idjuego').val(juego.idJuegos.id);
    console.log("idJuego " + juego.idJuegos.id);
    
	var requestData = {};
	//requestData.Juegos_idJuegos = juego.idJuegos.id;
	//requestData.Alumno_idAlumno = alumno;
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
