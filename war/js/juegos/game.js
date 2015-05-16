$(document).ready(function() {

	//alert("Bienvenido al Juego");

	console.log ((3>5) || (6<10));

    var canvas = $("#canvas")[0];
    
    imagenes=[
    	{
    		id:1,
    		url:"img/VACA.png"
    	}, 
    	{	
    		id:2,
    		url:"img/GALLINA.png"
    	},
    	{
    		id:3,
    		url:"img/BORREGO.png"
    	},
    	{
    		id:4,
    		url:"img/BORREGO.png"
    	},
    	{
    		id:5,
    		url:"img/BORREGO.png"
    	},
    	{
    		id:6,
    		url:"img/BORREGO.png"
    	},
    	{
    		id:7,
    		url:"img/BORREGO.png"
    	}    	
    	];
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();

});

	