<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="count" value="0" scope="page" />

<c:set var="relPal" scope="session" value="iconRP.png"/> <!-- URL a matchImg.jsp -->
<c:set var="compPal" scope="session" value="iconCP.png"/> <!-- URL a matchWord.jsp -->


<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Editar palabras de juegos</h4>
</div>
<!-- Head Collapse juegos -->
<div class="panel-group" id="accordion" role="tablist"
	aria-multiselectable="true">
	
<c:forEach items="${juegos}" var="element">
<c:if test="${element.iconJuego == relImg || element.iconJuego == relPal}">
<c:set var="count" value="${count + 1}" scope="page"/>	

	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#${count}" aria-expanded="false" aria-controls="collapseTwo">
          ${element.nombre}
          <p class="pull-right" style="color: #0540FD;"> 
          Campo Semantico: ${element.campoSemantico_idCampoSemantico.semantico}</p>
        </a>
      </h4>
    </div>
    <div id="${count}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
<!-- Head Collapse juegos -->


				<div class="panel-body">
					<form class="form-horizontal" role="form"
						action="actualizarjuego?accion=actualizar" method="post">

						<div class="form-group">
							<label class="col-sm-3 control-label">Nombre</label>
							<div class="col-sm-9">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input type="hidden" name="tipousuario" value="profesor">
									<input type="text" name="nombre" class="form-control"
										placeholder="Nombre(s)" value="${element.nombre}">
										<input type="hidden" name="idLong" value="${element.idJuegos}">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">
								Tiempo deseado de termino (min)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="tiempo"
									placeholder="Ej. 1:30" value="${element.tiempo}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Tipo de juego</label>
							<div class="col-sm-9" id="contenido-grado">
								<div id="contenido-grado-html">
									<input type="hidden" name="iconjuego" value="${element.iconJuego}">
									<input type="text" name="" class="form-control"
										 value="${element.tipoJuego}" disabled>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Campo Semantico</label>
							<div class="col-sm-9" id="contenido-grado">
								<div id="contenido-grado-html">
									<select name="camposemantico" class="form-control">
										<option value="${element.campoSemantico_idCampoSemantico.idCampo}">
										${element.campoSemantico_idCampoSemantico.semantico}</option>
										<c:forEach items="${camposemantico}" var="elemento">
											<option value="${elemento.idCampo}">${elemento.semantico}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group dinamico silabas palabras">
							<div class="col-sm-offset-3 col-sm-9">
							<c:set var="Icon" scope="session" value="iconCP.png"/>
							<c:if test="${element.iconJuego == Icon}">
								<div class="radio dinamico silabas">
									<label> <input type="hidden" name="isSilabas"
										id="isSilabas" value="activo"> Son palabras por silabas
									</label>
									<input type="hidden" name="isRelacion" value="inactivo">
								</div>
							</c:if>
							<c:set var="Icon2" scope="session" value="iconRP.png"/>
							<c:if test="${element.iconJuego == Icon2}">
								<div class="radio dinamico palabras">
									<label> <input type="hidden" name="isRelacion"
										id="isRelacion" value="activo"> Relaciòn de palabras
										principales
									</label>
									<input type="hidden" name="isSilabas" value="inactivo">
								</div>
							</div>
							</c:if>
						</div>
						<div class="form-group ">
							<label class="col-sm-3 control-label dinamico silabas palabras">Palabras</label>
							<div class="col-sm-9" id="contenido-palabras">
							<c:if test="${element.iconJuego == Icon}">
								<div id="contenido-palabras-html" class="dinamico silabas">
									<input type="text" class="form-control" name="palabras[]"
										placeholder="Palabra PRINCIPAL ej. va-ca"
										value="${element.palabras_idPalabras.principal}"> <input
										type="text" class="form-control" name="palabras[]"
										placeholder="Palabra CORRECTA ej. ca"
										value="${element.palabras_idPalabras.correcta}"> <input
										type="text" class="form-control" name="palabras[]"
										placeholder="Palabra ERRONEA ej. pa"
										value="${element.palabras_idPalabras.erronea}"> <input
										type="text" class="form-control" name="palabras[]"
										placeholder="Palabra ERRONEA 2 ej. sa"
										value="${element.palabras_idPalabras.erronea_2}">
								</div>
								</c:if>
								<c:if test="${element.iconJuego == Icon2}">
								<div id="contenido-palabras-html" class="dinamico palabras"
									data-tipo="completas">
									<input type="text" class="form-control palabras"
										name="palabras[]" placeholder="Palabra PRINCIPAL 1 ej. vaca"
										value="${element.palabras_idPalabras.principal}"> <input
										type="text" class="form-control palabras" name="palabras[]"
										placeholder="Palabra PRINCIPAL 2 ej. borrego"
										value="${element.palabras_idPalabras.correcta}"> <input
										type="text" class="form-control palabras" name="palabras[]"
										placeholder="Palabra PRINCIPAL 3 ej. gallina"
										value="${element.palabras_idPalabras.erronea}">
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
					
					
<!-- Footer Collapse juegos -->
				</div>
			</div>
		</div>
	</div>
	</c:if>
</c:forEach>
	
</div>
<!-- Footer Collapse juegos -->

</div>



<jsp:include page="common/footer.jsp" />

