<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="common/header_Juego.jsp" />
<!-- Script Jquery necesario -->
<script	src="js/jquery.min.js"></script>

<!-- Parametros -->
<input type="hidden" id="media" value='${jsonMedia}'> 
<!--<input type="hidden" id="alumno" value='${alumno}'> --> 
<input type="hidden" id="juego" value='${juego}'>
<input type="hidden" id="semantico" value="${semantico}"> 
<input type="hidden" id="idjuego" value=""> 
<input type="hidden" id="idAvance" value=""> 

<!-- Seccion del Juego Area del canvas -->
<div class="row">
	<div class="col-xs-1 col-md-1"></div>
	<div class="col-xs-10 col-md-10">
		<canvas id="canvas"> </canvas>
	</div>
	<div class="col-xs-1 col-md-1"></div>
</div>

<!-- Fin Seccion del Juego Area del canvas -->

<!-- Script necesarios para el Juego -->
<script src="js/cloud-endpoints/AvanceEndpoint.js"></script>

<script src="js/juegos/completar/GameObject.js"></script>
<script src="js/juegos/completar/MatchWord.js"></script>
<script src="js/juegos/completar/gameCompletar.js"></script>

<!-- Script necesarios para el Juego -->

<!-- Modal Instrucciones -->
<div class="modal fade" id="instrucciones" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-2 col-md-2"></div>
					<div class="col-xs-8 col-md-8">
						<div class="row">
							<h2 class="text-center"
								style="color: rgb(255, 255, 255); font-weight: 800 ! important;">
								Instrucciones</h2>
							<div class="col-xs-2 col-md-2"></div>
							<div class="col-xs-8 col-md-8">
								<p style="color: rgb(255, 255, 255); font-weight: 800 ! important;">
								Completar las palabras con la silaba correcta.
								</p>
							</div>
							<div class="col-xs-2 col-md-2"></div>
						</div>
						<button type="button" class="btn btn-primary btn-block " data-dismiss="modal" aria-label="Close">
							Aceptar
						</button>
					</div>
					<div class="col-xs-2 col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="common/footer_Juego.jsp" />