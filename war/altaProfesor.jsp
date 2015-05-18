<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
	class="st-layout ls-top-navbar ls-bottom-footer show-sidebar sidebar-l2"
	lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EduDown 1.0</title>

<link href="css/default.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body>

	<!-- Wrapper required for sidebar transitions -->
	<div class="st-container">

		<!-- Fixed navbar -->
		<div class="navbar navbar-main navbar-primary navbar-fixed-top"
			role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a href="#sidebar-menu" data-effect="st-effect-1"
						data-toggle="sidebar-menu" class="toggle pull-left visible-xs"><i
						class="fa fa-ellipsis-v"></i></a>
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#main-nav">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">EduDown</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="main-nav">
					<ul class="nav navbar-nav">
						<li><a href="http://www.fjldown.org.mx/">Fundación John
								Langdon Down</a></li>

					</ul>
					<ul class="nav navbar-nav navbar-right">
						<!-- User -->
						<li class="dropdown"><a href="#" class="dropdown-toggle user"
							data-toggle="dropdown"> <img src="img/guy-5.jpg" alt="Bill"
								class="img-circle" width="40" /> Profesor <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="login.html">Salir</a></li>
							</ul></li>
					</ul>
				</div>

				<!-- /.navbar-collapse -->
			</div>
		</div>

		<!-- Sidebar component with st-effect-1 (set on the toggle button within the navbar) -->
		<div
			class="sidebar left sidebar-size-2 sidebar-offset-0 sidebar-visible-desktop sidebar-visible-mobile sidebar-skin-dark"
			id="sidebar-menu" data-type="collapse">
			<div data-scrollable>
				<div class="sidebar-block">
					<div class="profile">
						<img src="img/guy-5.jpg" alt="people" class="img-circle">
						<h4>Profesor</h4>
					</div>
				</div>

				<ul class="sidebar-menu">
					<li class="active"><a href="buttons.html"><i
							class="fa fa-columns"></i> <span>Supervisar</span></a></li>
					<!-- Sample 2 Level Collapse -->
					<li class="hasSubmenu"><a href="#submenu"><i
							class="fa fa-chevron-circle-down"></i> <span>Evaluar</span></a>
						<ul id="submenu">
							<li><a href="#"><i class="fa fa-circle-o"></i> Avance
									Alumnos</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>
									Información Alumnos</a></li>
						</ul></li>
					<li class="hasSubmenu"><a href="#submenu2"><i
							class="fa fa-chevron-circle-down"></i> <span>Reportes</span></a>
						<ul id="submenu2">
							<li><a href="#"><i class="fa fa-circle-o"></i> Avance
									Alumnos</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>
									Información Alumnos</a></li>
						</ul></li>
					<li class="hasSubmenu"><a href="#submenu3"><i
							class="fa fa-chevron-circle-down"></i> <span>Altas</span></a>
						<ul id="submenu3">
							<li><a href="altaAlumno.jsp"><i class="fa fa-circle-o"></i>
									Alta de Alumnos</a></li>
							<li><a href="altaProfesor.jsp"><i
									class="fa fa-circle-o"></i> Alta de Profesores</a></li>
						</ul></li>
				</ul>
			</div>
		</div>




		<!-- sidebar effects OUTSIDE of st-pusher: -->

		<!-- st-effect-1, st-effect-2, st-effect-4, st-effect-5, st-effect-9, st-effect-10, st-effect-11, st-effect-12, st-effect-13 -->
		<!-- content push wrapper -->
		<div class="st-pusher" id="content">

			<!-- sidebar effects INSIDE of st-pusher: -->

			<!-- st-effect-3, st-effect-6, st-effect-7, st-effect-8, st-effect-14 -->
			<!-- this is the wrapper for the content -->
			<div class="st-content">
<!-- validation_error -->
<c:if test="${not empty error}">
			<div class="alert alert-danger alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  ${error}
			</div>
</c:if>		
<c:if test="${not empty acierto}">
			<div class="alert alert-success alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <i class="fa fa-check"></i>
			   ${acierto}
			</div>
</c:if>	
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">Alta de Profesores</h4>
						</div>

						<div class="panel-body">
							<form class="form-horizontal" role="form" action="perfiles" method="post">
								<div class="form-group">
									<label class="col-sm-3 control-label">Nombre</label>
									<div class="col-sm-9">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"></i></span>
											<input type="hidden" name="tipousuario" value="profesor">
											<input type="text" name="nombre" class="form-control" placeholder="Nombre(s)">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label">Apellido paterno</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="apaterno" placeholder="Apellido">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label">Apellido materno</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="amaterno" placeholder="Apellido">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label">Especialidad</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="especialidad" placeholder="Especialidad del docente">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">Grado</label>
									<div class="col-sm-9">
										<select name="select" class="selectpicker"
											data-style="btn-white" title="Seleccione una opción..."
											data-live-search="true" data-size="5" style="display: none;">
											<option>1</option>
											<option>2</option>
											<option>3</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">Grupo</label>
									<div class="col-sm-9">
										<select class="selectpicker"
											data-style="btn-white" title="Seleccione una opción..."
											data-live-search="true" data-size="5" style="display: none;">
											<option>A</option>
											<option>B</option>
											<option>C</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="button" class="btn btn-success add-materia">
										<i class="fa fa-plus"> Agregar materia</i>
										</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">Materias</label>
									<div class="col-sm-9">
										<select name="materias[]" class="selectpicker"
											data-style="btn-white" title="Seleccione una opción..."
											data-live-search="true" data-size="5" style="display: none;">
											<option>A</option>
											<option>B</option>
											<option>C</option>
										</select>
										
										<select name="materias[]" class="selectpicker" 
											data-style="btn-white" title="Seleccione una opción..."
											data-live-search="true" data-size="5" style="display: none;">
											<option>A</option>
											<option>B</option>
											<option>C</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary">Guardar</button>
									</div>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>

			<!-- /st-content -->

			<!-- /st-pusher -->

			<!-- Footer -->
			<div class="footer navbar-primary">
				<p style="color: white">Instituto Politecnico Nacional Unidad
					Culhuacan. &copy; Copyright 2015</p>
			</div>

			<!-- // Footer -->
		</div>

		<!-- /st-container -->

<script>
$('.add-materia').click(function(){
	//alert('hola');
});
</script>
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