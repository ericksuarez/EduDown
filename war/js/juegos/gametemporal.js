/**
 * @author Erick Suarez
 */
$(document).ready(function() {

	//alert("Bienvenido al Juego");

	console.log ((3>5) || (6<10));

    var canvas = $("#canvas")[0];
    
    imagenes=[
    	{
    		id:1,
    		url:"img/Taza.gif"
    	}, 
    	{	
    		id:2,
    		url:"img/za.png"
    	},
    	{
    		id:3,
    		url:"img/ta.png"
    	},
    	{
    		id:4,
    		url:"img/sa.png"
    	}  	
    	];
    
    juego = new MatchGame (canvas, imagenes);
    juego.init ();

});