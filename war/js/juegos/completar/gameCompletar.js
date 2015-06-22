$(document).ready(function() {
	
    var canvas = $("#canvas")[0];
    
    var text = $('#media').val();
    
    if(text.substring(text.length - 1) == ";"){
    	text = text.slice(0,-1)
    }
    
    var list = text.split(';');
    var imagenes = [];

    $.each( list, function( key, value ) {
      imagenes[key] = jQuery.parseJSON(value);
      console.log(imagenes[key].id + imagenes[key].silaba + imagenes[key].url);
    });
    
    juego = new MatchWord (canvas, imagenes);
    juego.init ();
    
    $('#siguiente').click(function(){
    	var semantico = $('#semantico').val();
    	var idjuego = $('#idjuego').val();
    	var avance = $('#idAvance').val();
    	window.location ="/completarpalabra?juego=" + idjuego + "&semantico=" + semantico + "&inicio=siguiente&avance=" + avance;
    });
    
});

	