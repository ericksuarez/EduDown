/**
 * @ahutor Erick
 */
$(document).ready(function() {
	
	$('.info').click(function(){
		var alumno = $(this).attr('data-alumno');
		var semantico = $(this).attr('data-semantico');
		var tipo = $(this).attr('data-tipo');
		var idhtml = $(this).attr('data-pos');
		
		$("#" + idhtml).empty();
		$("#" + idhtml).html('<i class="fa fa-spinner fa-pulse"></i> Cargando la informaciòn, por favor espere.');
		
		var evaluacion = $.ajax({
			type: "POST",
			url: "/evaluar",
			data: {alumno: alumno, semantico: semantico, tipo: tipo},
			dataType: "html"
		});
		
		evaluacion.done(function(msg){
			$("#" + idhtml).html(msg);
		});
		
		evaluacion.fail(function(jqXHR, textStatus){
			$("#" + idhtml).html("No se pudieron regresar los datos solicitados. Intentelo màs tarde.");
		});
		
	});
	
});