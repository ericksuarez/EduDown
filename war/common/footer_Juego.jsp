</div>
<!-- /st-container -->

<!-- Script necesario para los Cloud Endpoints-->
<script src="https://apis.google.com/js/client.js?onload=init"></script>

<!-- Modal Acierto -->
<div class="modal fade" id="acierto" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-2 col-md-2"></div>
					<div class="col-xs-8 col-md-8">
						<div class="row">
							<h2 class="text-center"
								style="color: rgb(255, 255, 255); font-weight: 800 ! important;">!Correcto¡</h2>
							<div class="col-xs-1 col-md-1"></div>
							<div class="col-xs-10 col-md-10">
								<img src="images/correcto.png" class="img-response">
							</div>
							<div class="col-xs-1 col-md-1"></div>
						</div>
						<form action="javascript:void(0);">
							<button type="submit" class="btn btn-primary btn-lg btn-block"
								id="siguiente">
								<i class="fa fa-arrow-right fa-4x"></i>
							</button>
						</form>
					</div>
					<div class="col-xs-2 col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal Error -->
<div class="modal fade" id="error" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-2 col-md-2"></div>
					<div class="col-xs-8 col-md-8">
						<div class="row">
							<h2 class="text-center"
								style="color: rgb(255, 255, 255); font-weight: 800 ! important;">¡Vuelve
								a intentarlo!</h2>
							<div class="col-xs-2 col-md-2"></div>
							<div class="col-xs-8 col-md-8">
								<img src="images/regresar.png" class="img-response">
							</div>
							<div class="col-xs-2 col-md-2"></div>
						</div>
						<button type="button" class="btn btn-primary btn-lg btn-block "
							data-dismiss="modal" aria-label="Close">
							<i class="fa fa-repeat fa-4x"></i>
						</button>
					</div>
					<div class="col-xs-2 col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal continuar -->
<div class="modal fade" id="continuar" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-2 col-md-2"></div>
					<div class="col-xs-8 col-md-8">
						<div class="row">
							<h2 class="text-center"
								style="color: rgb(255, 255, 255); font-weight: 800 ! important;">¡Bien,
								continua jugando!</h2>
							<div class="col-xs-2 col-md-2"></div>
							<div class="col-xs-8 col-md-8">
								<img src="images/regresar.png" class="img-response">
							</div>
							<div class="col-xs-2 col-md-2"></div>
						</div>
						<button type="button" class="btn btn-primary btn-lg btn-block "
							data-dismiss="modal" aria-label="Close">
							<i class="fa fa-repeat fa-4x"></i>
						</button>
					</div>
					<div class="col-xs-2 col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal Menu -->
<div class="modal fade" id="menu" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 600px; margin-top: 57px; margin-left: 1px;">
		<div class="split-vertical"
			style="width: 38%; background-color: #000;">
			<div class="split-vertical-body">
				<div class="split-vertical-cell">
						<p class="text-center">
							<br> <br> <a href="juego?seccion=semanticos" target="" 
								style="color: #fff"> <i class="fa fa-align-justify fa-3x"></i>
							</a> <br> <br>
							<button class="btn btn-link" style="color: #fff" id="repeat">
								<i class="fa fa-repeat fa-3x"></i>
							</button>
							<br> <br>
							<button class="btn btn-link" style="color: #fff" data-dismiss="modal" aria-label="Close">
								<i class="fa fa-play fa-3x"></i>
							</button>
							<br> <br> <a href="index.html" style="color: #fff">
								<i class="fa fa-home fa-3x"></i>
							</a><br>
						</p>
				</div>
			</div>
		</div>

	</div>
</div>
<script src="js/modales.min.js"></script>
<script>
$('#repeat').click(function(){
	var loc = window.location.href;
	window.location.href = loc;
});
</script>

</body>
</html>