
	function init() {
		console.log("init");
		gapi.client.load('juegosendpoint', 'v1', null,
				'http://localhost:8888/_ah/api');
	}

	function getJuegos() {
		console.log("getJuegos ... ");
		var requestData = {};
		requestData.idJuegos = $('#idJuego').attr('id');
 
		gapi.client.juegosendpoint.getJuegos(requestData).execute(
				function(resp) {
					if (!resp.code) {
						 resp.items = resp.items.Imagenes_idImagenes || [];
                         var result = "";
                         for (var i=0;i<resp.items.length;i++) {
                        	 console.log(resp);
                         }
					}
				});
	}

/**
 * @author Erick
 */