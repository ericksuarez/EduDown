$(document).ready(function() {

	
    var canvas = $("#canvas")[0];
    
    //imagenes = {"id":3,"silaba":"mano","url":"images/fondo-letra.png"};
    	
    imagenes=[
    	{
    		id:1,
    		silaba: "vaca",
    		url:"/images/vaca.png"
    	}, 
    	{	
    		id:2,
    		silaba: "gallina",
    		url:"/images/gallina.png"
    	},
    	{
    		id:3,
    		silaba: "borrego",
    		url:"/images/borrego.png"
    	}   	
    	];
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();
    
});

	