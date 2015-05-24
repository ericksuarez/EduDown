<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Alta de alumnos</h4>
</div>
<div class="panel-body">

<!-- Alta alumnos -->

	<form class="form-horizontal" role="form" action="perfiles?alta=alumno"
		method="post">
		<div class="form-group">
			<label class="col-sm-3 control-label">Nombre</label>
			<div class="col-sm-9">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span>
					 <input
						type="text" name="nombre" class="form-control"
						placeholder="Nombre(s)">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-3 control-label">Apellido
				paterno</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="apaterno"
					placeholder="Apellido">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-3 control-label">Apellido
				materno</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="amaterno"
					placeholder="Apellido">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-3 control-label">Usuario</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="usuario"
					placeholder="Usuario para ingresar a los juegos">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">Grado</label>
			<div class="col-sm-9">
				<select name="grado" class="selectpicker" data-style="btn-white"
					title="Seleccione una opción..." data-live-search="true"
					data-size="5" style="display: none;">
					<c:forEach items="${grados}" var="element">
    					<option value="${element.idGrado}">${element.grado} - ${element.grupo}</option>
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