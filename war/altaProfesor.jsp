<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<c:if test="${not empty actualizar}">

	<h4 class="panel-title">Editar Infomación</h4>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form"
			action="actualizar" method="post">
</c:if>
<c:if test="${not empty alta}">

	<h4 class="panel-title">Alta de profesores</h4>
	</div>
	<div class="panel-body">

		<!-- Alta profesores -->
		<form class="form-horizontal" role="form"
			action="perfiles?alta=profesor" method="post">
</c:if>
<!-- Parametros para hacer Updates -->
<input type="hidden" name="alta" value="profesor">
<input type="hidden" name="idLong" value="${profesor.idProfesor}">
<input type="hidden" name="detalle" value="${profesor.idProfesor}">

<div class="form-group">
	<label class="col-sm-3 control-label">Nombre</label>
	<div class="col-sm-9">
		<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
				type="hidden" name="tipousuario" value="profesor"> <input
				type="text" name="nombre" class="form-control"
				placeholder="Nombre(s)" value="${profesor.nombre}">
		</div>
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Apellido
		paterno</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="apaterno"
			placeholder="Apellido" value="${profesor.apaterno}">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Apellido
		materno</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="amaterno"
			placeholder="Apellido" value="${profesor.amaterno}">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Email</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="email"
			placeholder="Cuenta de Google" value="${profesor.email}">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Especialidad</label>
	<div class="col-sm-9">
		<input type="text" class="form-control" name="especialidad"
			placeholder="Especialidad del docente" value="${profesor.especialidad}">
	</div>
</div>
<div class="form-group">
	<div class="col-sm-offset-3 col-sm-9">
		<button type="button" class="btn btn-success add-grado">
			<i class="fa fa-plus"> Agregar grado</i>
		</button>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">Grado</label>
	<div class="col-sm-9" id="contenido-grado">
	
	<c:if test="${not empty actualizar}">
	<c:forEach items="${profesor.grado_idGrado}" var="elements">
	<div id="contenido-grado-html">
			<select name="grados[]" class="form-control">
			<option value="${elements.idGrado}">${elements.grado}-${elements.grupo}</option>
				<c:forEach items="${grados}" var="element">
					<option value="${element.idGrado}">${element.grado}-
						${element.grupo}</option>
				</c:forEach>
			</select>
		</div>
		</c:forEach>
	</c:if>
	
	<c:if test="${not empty alta}">
		<div id="contenido-grado-html">
			<select name="grados[]" class="form-control">
				<c:forEach items="${grados}" var="element">
					<option value="${element.idGrado}">${element.grado}-
						${element.grupo}</option>
				</c:forEach>
			</select>
		</div>
	</c:if>
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
	<div class="col-sm-9" id="contenido-materia">
	
	<c:if test="${not empty actualizar}">
	<c:forEach items="${profesor.materia_idMateria}" var="elements">
	<div id="contenido-materia-html">
			<select name="materias[]" class="form-control">
			<option value="${elements.idMateria}">${elements.nombreMateria}</option>
				<c:forEach items="${materias}" var="element">
					<option value="${element.idMateria}">${element.nombreMateria}</option>
				</c:forEach>
			</select>
		</div>
		</c:forEach>
	</c:if>
	
	<c:if test="${not empty alta}">
		<div id="contenido-materia-html">
			<select name="materias[]" class="form-control">
				<c:forEach items="${materias}" var="element">
					<option value="${element.idMateria}">${element.nombreMateria}</option>
				</c:forEach>
			</select>
		</div>
	</c:if>
	</div>
</div>
<div class="form-group">
	<div class="col-sm-offset-3 col-sm-9">
		<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
</div>
</form>

<!-- Fin alta profesores -->

</div>

<!-- Para agregar mas grados y materias -->
<script type="text/javascript">
	$(document).ready(function() {

		$('.add-grado').click(function() {
			var content = $('#contenido-grado-html');
			$('#contenido-grado').append("<br>" + content.html());
		});

		$('.add-materia').click(function() {
			var content = $('#contenido-materia-html');
			$('#contenido-materia').append("<br>" + content.html());
		});

	});
</script>

<jsp:include page="common/footer.jsp" />

