<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Alta de juegos con palabras</h4>
</div>
<div class="panel-body">

	<!-- Alta profesores -->
	<form class="form-horizontal" role="form"
		action="altajuego?alta=alta" method="post">


		<div class="form-group">
			<label class="col-sm-3 control-label">Nombre</label>
			<div class="col-sm-9">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="hidden" name="tipousuario" value="profesor"> <input
						type="text" name="nombre" class="form-control"
						placeholder="Nombre(s)" value="">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-3 control-label">
				Tiempo deseado de termino (min)</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="tiempo"
					placeholder="Ej. 1:30" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">Tipo de juego</label>
			<div class="col-sm-9" id="contenido-grado">
				<div id="contenido-grado-html">
					<select name="iconjuego" class="form-control" id="iconjuego">
						<option value="default.png">Seleccione una opción...</option>
						<!-- <option value="iconRI.png">Relacionar imagenes</option> 
				<option value="iconME.png">Memorama con palabras</option>-->
						<option value="iconCP.png">Completar palabra</option>
						<option value="iconRP.png">Relacionar palabra</option>
					</select>
				</div>
			</div>
		</div>
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

		<div class="form-group dinamico silabas palabras">
			<div class="col-sm-offset-3 col-sm-9">

				<div class="radio dinamico silabas">
					<label> <input type="hidden" name="isSilabas"
						id="isSilabas" value=""> Son palabras por silabas
					</label>
				</div>
				<div class="radio dinamico palabras">
					<label> <input type="hidden" name="isRelacion"
						id="isRelacion" value=""> Relaciòn de palabras principales
					</label>
				</div>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label dinamico silabas palabras">Palabras</label>
			<div class="col-sm-9" id="contenido-palabras">
				<div id="contenido-palabras-html" class="dinamico silabas">
					<input type="text" class="form-control" name="palabras[]"
						placeholder="Palabra PRINCIPAL ej. va-ca" value=""> <input
						type="text" class="form-control" name="palabras[]"
						placeholder="Palabra CORRECTA ej. ca" value=""> <input
						type="text" class="form-control" name="palabras[]"
						placeholder="Palabra ERRONEA ej. pa" value=""> <input
						type="text" class="form-control" name="palabras[]"
						placeholder="Palabra ERRONEA 2 ej. sa" value="">
				</div>
				<div id="contenido-palabras-html" class="dinamico palabras"
					data-tipo="completas">
					<input type="text" class="form-control palabras" name="palabras[]"
						placeholder="Palabra PRINCIPAL 1 ej. vaca" value=""> <input
						type="text" class="form-control palabras" name="palabras[]"
						placeholder="Palabra PRINCIPAL 2 ej. borrego" value=""> <input
						type="text" class="form-control palabras" name="palabras[]"
						placeholder="Palabra PRINCIPAL 3 ej. gallina" value="">
				</div>
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

		$('.dinamico').hide();

		$('.add-palabra').click(function() {
			var content = $('#contenido-palabras-html');
			$('#contenido-palabras').append("<br>" + content.html());
		});

		$('#iconjuego').change(function() {
			$('.dinamico').hide();
			var tipoPalabra = $('#iconjuego').val();
			if (tipoPalabra == "iconRI.png") {
				$('.dinamico').hide();
			} else {
				if (tipoPalabra == "iconCP.png") { //juegos para completar palabra (ta-____)
					$('.silabas').show();
					$('#isRelacion').attr('value', 'inactivo');
					$('#isSilabas').attr('value', 'activo');
				} else {
					$('.palabras').show();
					$('#isRelacion').attr('value', 'activo');
					$('#isSilabas').attr('value', 'inactivo');
				}
			}
		});
	});
</script>

<jsp:include page="common/footer.jsp" />

