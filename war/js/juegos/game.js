$(document).ready(function() {
	
    var canvas = $("#canvas")[0];
    
    var text = $('#media').val();
    var textAl = $('#alumno').val();
    var textJu = $('#juego').val();
    
    var alumno = jQuery.parseJSON(textAl);
    var juego = jQuery.parseJSON(textJu);
    
    $('#idjuego').val(juego.idJuegos.id);
    
    var list = text.split(';');
    var imagenes = [];

    $.each( list, function( key, value ) {
      imagenes[key] = jQuery.parseJSON(value);
    });
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();
    
    $('#siguiente').click(function(){
    	var semantico = $('#semantico').val();
    	var idjuego = $('#idjuego').val();
    	window.location ="/matchimagen?juego=" + idjuego + "&semantico=" + semantico + "&inicio=siguiente";
    });
    
});

	