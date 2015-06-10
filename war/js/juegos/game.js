$(document).ready(function() {

	//alert("Bienvenido al Juego");

	console.log ((3>5) || (6<10));

    var canvas = $("#canvas")[0];
    
    imagenes=[
    	{
    		id:1,
    		url:"/images/vaca.png"
    	}, 
    	{	
    		id:2,
    		url:"/images/gallina.png"
    	},
    	{
    		id:3,
    		url:"/images/borrego.png"
    	},
    	{
    		id:4,
    		url:"/images/borrego.png"
    	},
    	{
    		id:5,
    		url:"/images/borrego.png"
    	},
    	{
    		id:6,
    		url:"/images/borrego.png"
    	},
    	{
    		id:7,
    		url:"/images/borrego.png"
    	}    	
    	];
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();

});

	