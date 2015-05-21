<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style type="text/css">
.cover {
	margin: 0px;
	text-align: center;
	margin-bottom: 6% !important;
	height: auto;
}
</style>
</head>
<body style="background: none repeat scroll 0% 0% #F6F6F6;">

	<!-- Wrapper required for sidebar transitions -->

	<div class="container-fluid">
		<!-- Fixed navbar -->
		<div class="navbar navbar-main navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a href="index.html" data-effect="st-effect-11"
					class="btn btn-primary"> <i class="fa fa-reply-all fa-4x"></i>
				</a>
			</div>
		</div>

		<div class="container" style="margin-top: 6%;">
			<div class="row">
				<div class="col-xs-3 col-md-3">
					<a href="menuJuegos.jsp">
						<div style="height: 245px;"
							class="cover overlay cover-image-full img-circle">
							<img src="images/leon.jpg" alt="cover">
						</div>
					</a>
				</div>
			</div>

			<!-- /st-content-inner -->
		</div>
		<!-- /st-content -->
	</div>
	<!-- /st-container -->
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
