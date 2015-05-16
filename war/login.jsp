<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EduDown 1.0</title>

<link href="css/default.min.css" rel="stylesheet">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<body class="login">
    <div id="content">
        <div class="container-fluid">
            <div class="lock-container">
                <h1>Acceso al Sistema</h1>
                <div class="panel panel-default text-center">
                    <img src="images/guy-5.jpg" class="img-circle">
                    <div class="panel-body">
                        <p>El ingreso al sistema se realizara por medio de su cuenta en Google.</p>
                        <a href="${login_link}" class="btn btn-primary">Ingresar <i class="fa fa-fw fa-unlock-alt"></i></a>
                    </div>
                </div>
            </div>
        </div>
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