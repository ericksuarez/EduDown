$(document).ready(function() {
	
    var canvas = $("#canvas")[0];
    
    var text = $('#media').val();
    var list = text.split(';');
    var imagenes = [];

    $.each( list, function( key, value ) {
      imagenes[key] = jQuery.parseJSON(value);
      alert(imagenes[key].id);
      alert(imagenes[key].silaba);
      alert(imagenes[key].url);
    });
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();
    
    $('#siguiente').click(function(){
    	var semantico = $('#semantico').val();
    	var idjuego = $('#idjuego').val();
    	var avance = $('#idAvance').val();
    	window.location ="/matchimagen?juego=" + idjuego + "&semantico=" + semantico + "&inicio=inicio&avance=" + avance;
    });
    
});

	