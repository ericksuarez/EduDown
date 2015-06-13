<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	href="/font-awesome/css/font-awesome.min.css">
<!-- Script Jquery necesario-->
<script
	src="js/jquery.min.js"></script>
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
								class="img-circle" width="40" /> ${usuario} <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="${logout_link}">Salir</a></li>
							</ul></li>
					</ul>
				</div>

				<!-- /.navbar-collapse -->
			</div>
		</div>

		<jsp:include page="menu.jsp" />

		<div class="st-content">
			<div class="st-content-inner" tabindex="2"
				style="overflow-y: hidden; outline: none;">
				<div class="container-fluid">
					<div class="st-pusher" id="content">
					
					<!-- validation_error -->
					<c:if test="${not empty error}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							${error}
						</div>
					</c:if>
					<c:if test="${not empty acierto}">
						<div class="alert alert-success alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<i class="fa fa-check"></i> ${acierto}
						</div>
					</c:if>
					<!-- fin validation_error -->
					
						<div class="panel panel-default">
							<div class="panel-heading">
							
							
							
							
							
							