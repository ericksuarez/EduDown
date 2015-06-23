<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:set var="relImg" scope="session" value="iconRI.png"/> <!-- URL a matchImg.jsp -->
<c:set var="relPal" scope="session" value="iconRP.png"/> <!-- URL a matchImg.jsp -->
<c:set var="compPal" scope="session" value="iconCP.png"/> <!-- URL a matchWord.jsp -->
<c:set var="relLine" scope="session" value="iconLI.png"/> <!-- URL a relacionlineas.jsp -->
<c:set var="memo" scope="session" value="iconMI.png"/> <!-- URL a memorama.jsp -->


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html
	class="st-layout ls-top-navbar ls-bottom-footer show-sidebar sidebar-l2"
	lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>EduDown 1.0</title>

<link href="css/default.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="/font-awesome/css/font-awesome.min.css">
<style type="text/css">
.cover {
	margin: 0px;
	text-align: center;
	margin-bottom: 6% !important;
	height: auto;
}

.estrella {
	margin-top: 78% !important;
	color: #FFF300 !important;
}
</style>
</head>
<body style="background: none repeat scroll 0% 0% #F6F6F6;">

	<!-- Wrapper required for sidebar transitions -->

	<div class="container-fluid">
		<!-- Fixed navbar -->
		<div class="navbar navbar-main navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a href="juego?seccion=semanticos" data-effect="st-effect-11"
					class="btn btn-primary"> <i class="fa fa-reply-all fa-4x"></i>
				</a>
			</div>
		</div>


		<div class="container" style="margin-top: 6%;">
			<div class="row">
			<c:forEach items="${juegos}" var="element">
				<div class="col-xs-4 col-md-3">
				
					<c:if test="${element.iconJuego == relImg || element.iconJuego == relPal}">
					<a href="matchimagen?juego=${element.idJuegos}&semantico=${semantico}&inicio=inicio&avance=">
					</c:if>
					<c:if test="${element.iconJuego == compPal}">
					<a href="completarpalabra?juego=${element.idJuegos}&semantico=${semantico}&inicio=inicio&avance=">
					</c:if>
					<c:if test="${element.iconJuego == relLine}">
					<a href="relacionlineas?juego=${element.idJuegos}&semantico=${semantico}&inicio=inicio&avance=">
					</c:if>
					<c:if test="${element.iconJuego == relLine && element.iconJuego == relPal}">
					<a href="relacionlineas?juego=&semantico=${semantico}&inicio=palabras&avance=">
					</c:if>
					<c:if test="${element.iconJuego == memo}">
					<a href="memorama?juego=${element.idJuegos}&semantico=${semantico}&inicio=inicio&avance=">
					</c:if>
					
						<div class="cover overlay cover-image-full img-circle"
							style="height: 293px; text-align: center;">
							<img src="images/${element.iconJuego}" alt="cover">
							<div class="overlay overlay-full"
								style="height: 293px; text-align: center;">
								<i class="fa fa-star-o fa-4x estrella"></i> <i
									class="fa fa-star-o fa-4x estrella"></i> <i
									class="fa fa-star-o fa-4x estrella"></i>
								<!--<c:if test="${not empty error}">
								<i class="fa fa-star fa-4x estrella"></i> <i
									class="fa fa-star fa-4x estrella"></i> <i
									class="fa fa-star fa-4x estrella"></i>
								</c:if>	-->
							</div>
						</div>
					</a>
				</div>
			</c:forEach>

				<!--  
				<div class="col-xs-4 col-md-3">
					<a href="matchWord.jsp">
						<div class="cover overlay cover-image-full img-circle"
							style="height: 293px; text-align: center;">
							<img src="images/leon.jpg" alt="cover">
							<div class="overlay overlay-full"
								style="height: 293px; text-align: center;">
								<i class="fa fa-star-o fa-4x estrella"></i> <i
									class="fa fa-star-o fa-4x estrella"></i> <i
									class="fa fa-star-o fa-4x estrella"></i>
							</div>
						</div>
					</a>
				</div> -->


			</div>

			<!-- /st-content-inner -->
		</div>
		<!-- /st-content -->
	</div>

	<!-- Inline Script for colors and config objects; used by various external scripts; -->
	<script>
		var colors = {
			"danger-color" : "#e74c3c",
			"success-color" : "#81b53e",
			"warning-color" : "#f0ad4e",
			"inverse-color" : "#2c3e50",
			"info-color" : "#2d7cb5",
			"default-color" : "#6e7882",
			"default-light-color" : "#cfd9db",
			"purple-color" : "#9D8AC7",
			"mustard-color" : "#d4d171",
			"lightred-color" : "#e15258",
			"body-bg" : "#f6f6f6"
		};
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
