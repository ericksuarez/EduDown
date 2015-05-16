<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- Script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/juegos/GameObject.js"></script>
<script src="js/juegos/MatchGame.js"></script>
<script src="js/juegos/game.js"></script>

</head>
<body>

	<!-- Wrapper required for sidebar transitions -->
	<div class="st-container">
		<!-- Fixed navbar -->
		<div class="navbar navbar-main navbar-primary navbar-fixed-top"
			role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a href="#st-effect-11" data-toggle="sidebar-menu"
						data-effect="st-effect-11" class="btn btn-default">
						<p style="color: white">
							<i class="fa fa-list fa-4x "></i>
						</p>
					</a>
				</div>
			</div>
		</div>

		<!-- Sidebar component with st-effect-11 (set on the toggle button) -->
		<div
			class="sidebar left sidebar-size-2 sidebar-offset-0 sidebar-skin-dark"
			data-type=dropdown id=st-effect-11>
			<div class="split-vertical">
				<div class="sidebar-block">
					<h4 class="category"></h4>
				</div>
				<div class="split-vertical-body">
					<div class="split-vertical-cell">
						<div data-scrollable>
							<p class="text-center" style="color: white">
								<br>
								<br> <i class="fa fa-align-justify fa-4x"></i> <br>
								<br> <i class="fa fa-repeat fa-4x"></i> <br>
								<br> <i class="fa fa-pause fa-4x"></i> <br>
								<br> <i class="fa fa-play fa-4x"></i> <br>
								<br> <a href="index.html"><i class="fa fa-home fa-4x"></i> </a><br>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br><br>
<!-- Seccion del juego -->	
		<div class="row">
		<div class="col-xs-1 col-md-1"></div>
		<div class="col-xs-10 col-md-10">
		<canvas id="canvas"> </canvas>
		</div>
		<div class="col-xs-1 col-md-1"></div>
		</div>
<!-- Fin Seccion del juego -->	
		<!-- Footer -->
		<div class="footer navbar-primary">
			<p style="color: white">Instituto Politecnico Nacional Unidad
				Culhuacan. &copy; Copyright 2015</p>
		</div>

		<!-- // Footer -->
	</div>

	<!-- /st-container -->

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
	<script src="js/module-essentials.min.js"></script>
	<script src="js/module-layout.min.js"></script>
	<script src="js/module-sidebar.min.js"></script>

</body>
</html>