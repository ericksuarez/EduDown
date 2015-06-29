var text = $('#media').val();
    
    if(text.substring(text.length - 1) == ";"){
    	text = text.slice(0,-1)
    }
    
    var list = text.split(';');
    
    var imagenes = [];
    var json = [];
    var index = 0;
    $.each( list, function( key, value ) {
      imagenes[key] = jQuery.parseJSON(value);
      console.log(imagenes[key].url);
      json[index++] = imagenes[key].url;
    });
//alert(json.toString());

var id1 = null;
var id2 = null;
var url1 = null;
var url2 = null;
var url = null;
var paresCo = 0;
var time = 0;
var min = 0;
var hours = 0;
var previos = [];
var pares = [];
var aleatorios = [];

$(document).ready(function() {

	generateTable();
	getUrl();
	inity();

	$('.flip').toggle(function() {

		$(this).find('.card').addClass('flipped');
		// console.log("antes: " + url);
		id = $(this).attr('id');

		if (url1 == null) {
			url1 = $(this).find('.card').find('.back').find('img').attr("src");
			id1 = id;
			console.log("asigna" + id);
			// console.log(url1);
		} else if (url2 == null) {
			url2 = $(this).find('.card').find('.back').find('img').attr("src");
			id2 = id;
			// console.log(id);
			// console.log(url2);
			if (url1 == url2) {
				//alert("Correcto!");
				paresCo++;
				if(paresCo == 9){
					guardar();
					$('#acierto').modal('show');
				}else{
					$('#continuar').modal('show');
				}
				url1 = null;
				url2 = null;
			} else {
				//alert("Incorrecto");
				//$('#error').modal('show');
				url1 = null;
				url2 = null;
				setTimeout(regresaCartas, 900, id1, id2);
			}
		}

	}, function() {
		$(this).find('.card').removeClass('flipped');
		id = $(this).attr('id');
		console.log("entro retira" + id);
		if (id == id1) {
			id1 = null;
			id = null;
			url1 = null;
		}
		if (id == id2) {
			id2 = null;
			id = null;
		}
	});

	function regresaCartas(id1, id2) {

		$('#' + id1).find('.card').removeClass('flipped');
		$('#' + id2).find('.card').removeClass('flipped');

		id1 = null;
		id2 = null;
	}

	$('#siguiente').click(function(){
		var semantico = $('#semantico').val();
		var idjuego = $('#idjuego').val();
		var avance = $('#idAvance').val();
		window.location ="/memorama?juego=" + idjuego + "&semantico=" + semantico + "&inicio=inicio&avance=" + avance;
	});
});

this.generateTable = function() {
	var htmltd;
	var aleatorio;
	var cnt = 0;
	var img = 0;
	var contador = 0;
	var ii = 0;
	var posicion;
	var nueve = [];

	for (i = 0; i < 3; i++) {
		htmltd = "";
		for (j = 0; j < 6; j++) {
			if (img < 9) {
				id = random();
				nueve[img] = previos[img];
				img++;
			} else {
				id = random1(nueve);
			}
			ii++;

			htmltd += '<td class="col-xs-2 col-sm-2 col-md-2"><div id="'
					+ ii
					+ '" class="flip"><div class="card"><div class="face front"><img src="images/back.png" class="img-responsive"" /></div><div class="face back"><img  src="'
					+ json[id]
					+ '" class="img img-responsive" /></div></div></div></td>';
		}
		$("#myTable").append('<tr id="fila_' + i + '">' + htmltd + '</tr>');
	}

};

this.random = function() {
	do {
		aleatorio = Math.floor((Math.random() * json.length));
		if (previos.indexOf(aleatorio) < 0) {
			previos.push(aleatorio);
			return aleatorio;
		}

	} while (true);

}

this.random1 = function(nueve) {
	do {
		posicion = nueve[Math.floor(Math.random() * nueve.length)];
		if (aleatorios.indexOf(posicion) < 0) {
			aleatorios.push(posicion);
			return posicion;
		}
	} while (true);
}

this.getUrl = function() {
	var url = document.getElementsByClassName("img");
	// console.log(url);
}

this.timer = function() {

	time++;

	if (time === 60) {
		time = 0;
		min++;
	} else if (min === 60) {
		min = 0;
		hours++;
	}

}

this.inity = function() { // esta es la primera funcion que se manda llamar

	// timer();

	if (typeof game_loop != "undefined") {
		clearInterval();
	}
	game_loop = setInterval(drawScore, 1000);

};

this.drawScore = function() {

	timer();
	// console.log("Tiempo: "+ hours + ":" + min + ":" + time);
	$('#setTime').text("Tiempo: " + hours + ":" + min + ":" + time);
	$('#pares').text("Pares: " + paresCo);
}

this.guardar = function(){

    insertAvance(hours + " : " + min + " : " + time
    			,true,0,10);


};