<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="common/header_Juego.jsp" />

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
<script src="js/juegos/GameObject.js"></script>
<script src="js/juegos/MatchWord.js"></script>
<script src="js/juegos/gametemporal.js"></script>
<!-- Script necesarios para el Juego -->

<jsp:include page="common/footer_Juego.jsp" />