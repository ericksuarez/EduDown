<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<!-- Alta alumnos -->

<h4 class="panel-title">Alta de juegos de imagenes y memoramas</h4>
</div>
<div class="panel-body">
	<form class="form-horizontal" role="form" action="altaimagenes"
		method="post">

		<div class="form-group">
			<label class="col-sm-3 control-label">Campo Semantico</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="camposemantico" class="form-control">
						<c:forEach items="${camposemantico}" var="element">
							<option value="${element.idCampo}">${element.semantico}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label">Tipo de juego</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="icon" class="form-control" id="icono">
						<option value="">Selecciona una imagen</option>
						<option value="iconRI.png">Relacionar imagen</option>
						<option value="iconLI.png">Relacionar lineas imagen</option>
						<option value="iconMI.png">Memorama imagen</option>
					</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label">Imagen 1</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="image[]" class="selectpicker" data-style="btn-white"
			title="Seleccione una opción..." data-live-search="true"
			data-size="5" style="display: none;">
						<option value="">Selecciona una imagen</option>
						<c:forEach items="${imagenes}" var="element">
							<option value="${element.idImagenes}">${element.nombre}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label">Imagen 2</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="image[]" class="selectpicker" data-style="btn-white"
			title="Seleccione una opción..." data-live-search="true"
			data-size="5" style="display: none;">
						<option value="">Selecciona una imagen</option>
						<c:forEach items="${imagenes}" var="element">
							<option value="${element.idImagenes}">${element.nombre}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label">Imagen 3</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="image[]" class="selectpicker" data-style="btn-white"
			title="Seleccione una opción..." data-live-search="true"
			data-size="5" style="display: none;">
						<option value="">Selecciona una imagen</option>
						<c:forEach items="${imagenes}" var="element">
							<option value="${element.idImagenes}">${element.nombre}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<!-- inicio memorama -->
		<%
			for (int i = 4; i < 19; i++) {
		%>
		<div class="form-group memo">
			<label class="col-sm-3 control-label">Imagen <%=i%></label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="image[]" class="form-control">
						<option value="">Selecciona una imagen</option>
						<c:forEach items="${imagenes}" var="element">
							<option value="${element.idImagenes}">${element.nombre}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<%
			}
		%>
		<!-- fin memorama -->

		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-9">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</div>

	</form>

	<!-- Fin alta alumnos -->

</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('.memo').hide();

		$('#icono').change(function() {
			var cambio = $(this).val();

			if (cambio == "iconRI.png") {
				$('.memo').hide(2000);
			} else {
				$('.memo').show(2000);
			}

		});

	});
</script>

<jsp:include page="common/footer.jsp" />