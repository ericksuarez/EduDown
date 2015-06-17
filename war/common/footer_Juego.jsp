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
						<button
						type="submit" class="btn btn-primary btn-lg btn-block" id="siguiente">
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
						<button type="button" class="btn btn-primary btn-lg btn-block " data-dismiss="modal" aria-label="Close">
							<i class="fa fa-repeat fa-4x"></i>
						</button>
					</div>
					<div class="col-xs-2 col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Inline Script for colors and config objects; used by various external scripts; -->
<script>
	var config = {
		debug : true,
		theme : "social-2",
		skins : {
			"default" : {
				"primary-color" : "#16ae9f"
			}
		}
	};
</script>
<script src="js/vendor-bundle-all.min.js"></script>
<script src="js/module-bundle-main.min.js"></script>

</body>
</html>