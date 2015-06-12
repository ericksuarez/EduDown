<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<!-- Alta alumnos -->
<c:if test="${not empty actualizar}">

	<h4 class="panel-title">Editar Infomación</h4>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" action="actualizar"
			method="post">
</c:if>
<c:if test="${not empty alta}">

	<h4 class="panel-title">Alta de alumnos</h4>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form"
			action="perfiles?alta=alumno" method="post">
</c:if>
<!-- Parametros para hacer Updates -->
<input type="hidden" name="alta" value="alumno">
<input type="hidden" name="idLong" value="${alumno.idAlumno}">
<input type="hidden" name="detalle" value="${alumno.idAlumno}">

<div class="form-group">
	<label class="col-sm-3 control-label">Nombre</label>
	<div class="col-sm-9">
		<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
				type="text" name="nombre" class="form-control"
				placeholder="Nombre(s)" value="${alumno.nombre}">
		</div>
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Apellido
		paterno</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="apaterno"
			placeholder="Apellido" value="${alumno.apaterno}">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Apellido
		materno</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="amaterno"
			placeholder="Apellido" value="${alumno.amaterno}">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Usuario</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="usuario"
			placeholder="Usuario para ingresar a los juegos"
			value="${alumno.usuario}">
	</div>
</div>

<div class="form-group">
	<label class="col-sm-3 control-label">Grado</label>
	<div class="col-sm-9">
		<select name="grado" class="selectpicker" data-style="btn-white"
			title="Seleccione una opción..." data-live-search="true"
			data-size="5" style="display: none;">
			<c:if test="${not empty actualizar}">
				<option value="${alumno.grado_idGrado.idGrado}">${alumno.grado_idGrado.grado}
					- ${alumno.grado_idGrado.grupo}</option>
			</c:if>
			<c:forEach items="${grados}" var="element">
				<option value="${element.idGrado}">${element.grado}-
					${element.grupo}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<div class="col-sm-offset-3 col-sm-9">
		<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
</div>
</form>

<!-- Fin alta alumnos -->

</div>
<jsp:include page="common/footer.jsp" />