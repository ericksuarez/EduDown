<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="common/header_Juego.jsp" />

<!-- Parametros -->
<input type="hidden" id="media" value='${jsonMedia}'> 
<input type="text" id="alumno" value='${alumno}'> 
<input type="text" id="juego" value='${juego}'> 
<input type="text" id="semantico" value="${semantico}"> 
<input type="text" id="idjuego" value=""> 

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

<script src="js/juegos/GameObject.js"></script>
<script src="js/juegos/MatchGame.js"></script>
<script src="js/juegos/game.js"></script>

<!-- Script necesarios para el Juego -->

<jsp:include page="common/footer_Juego.jsp" />