$(document).ready(function() {

    var canvas = $("#canvas")[0];
 /*   
    var text = $('#media').val();
    
    if(text.substring(text.length - 1) == ";"){
    	text = text.slice(0,-1)
    }
    
    var list = text.split(';');
    alert(list.toString());
    var imagenes = [];

    $.each( list, function( key, value ) {
      imagenes[key] = jQuery.parseJSON(value);
      imagenes[key].linea = null;
      console.log(imagenes[key].id + imagenes[key].linea + imagenes[key].url);
    });
alert(imagenes[0].id + imagenes[0].linea + imagenes[0].url);
    lineas = [];    
    juego = new MatchGame (canvas, imagenes, lineas);
    juego.init ();
    
    $('#siguiente').click(function(){
    	var semantico = $('#semantico').val();
    	var idjuego = $('#idjuego').val();
    	var avance = $('#idAvance').val();
    	var GET = getGET();
    	window.location ="/matchimagen?juego=" + idjuego + "&semantico=" + semantico + "&inicio=" + GET['inicio'] + "&avance=" + avance;
    });

    function getGET(){
        var loc = window.location.href;
        var getString = loc.split('?')[1];
        var GET = getString.split('&');
        var get = {};

        for(var i = 0, l = GET.length; i < l; i++){
            var tmp = GET[i].split('=');
            get[tmp[0]] = unescape(decodeURI(tmp[1]));
        }
        return get;
    } */
    
    imagenes=[
          	{
          		id:1,
          		url:"images/vaca.png",
                  linea:null,
                  
          	}, 
          	{	
          		id:2,
          		url:"images/vaca.png",
                  linea:null,
          	},
          	{
          		id:3,
          		url:"images/vaca.png",
                  linea:null,
          	},
          	{
          		id:4,
          		url:"images/vaca.png",
                  linea:null,
          	},
          	{
          		id:5,
          		url:"images/vaca.png",
                  linea:null,
          	},
          	{
          		id:6,
          		url:"images/vaca.png",
                  linea:null,
          	},
          	{
          		id:7,
          		url:"images/vaca.png",
                  linea:null,
          	}    	
          	];

          lineas = [];    
          
          juego = new MatchGame (canvas, imagenes, lineas);
//          alerta = new resgisterEvents (popup);
          juego.init ();


});

	