<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<% int i = 0;%>

<style>
.info{
cursor: context-menu;
}
</style>
<h4 class="panel-title">Detalle del alumno <strong>${alumno.nombre} ${alumno.apaterno} ${alumno.amaterno}</strong></h4>
</div>
<div class="panel-body">

	<!-- Detalle -->
	<div class="row">
<c:forEach items="${semanticos}" var="element"> <% i++; %>
		<div class="col-xs-12 col-md-6 col-lg-4 item">
			<div class="timeline-block">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="media">
							<div class="media-left">
								<a href="/supervisar"><img src="images/${element.imagenIcono}"
									class="media-object" style="max-height: 50px; max-width: 50px !important;"></a>
							</div>
							<div class="media-body">
								<a><b>${element.semantico}</b></a> <span>Campo semantico</span>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="timeline-added-images text-center">
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconRI.png">
							<img src="images/iconRI.png" alt="photo" width="60"></a> 
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconRP.png">
							<img src="images/iconRP.png" alt="photo" width="60"></a>  
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconCP.png">
							<img src="images/iconCP.png" alt="photo" width="60"></a> 
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconLI.png">
							<img src="images/iconLI.png" alt="photo" width="60"></a> 
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconLP.png">
							<img src="images/iconLP.png" alt="photo" width="60"></a> 
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconMI.png">
							<img src="images/iconMI.png" alt="photo" width="60"></a> 
							
							<a class="info" data-pos="<%=i%>"
							data-alumno="${alumno.idAlumno}" data-semantico="${element.idCampo}" data-tipo="iconMP.png">
							<img src="images/iconMP.png" alt="photo" width="60"></a> 
						</div>
					</div>
					<div class="view-all-comments">
						<a href="#"><i class="fa fa-book"></i> Informacion general
						</a>

					</div>
					<ul class="comments" id="<%=i%>">
					<p>Seleccione un tipo de juego para ver su informaciòn.</p>
					</ul>
				</div>
			</div>
		</div>
</c:forEach>

	</div>
	<!-- Fin Detalle -->

</div>

<script src="js/EvaluacionAlumno.js"></script>

<jsp:include page="common/footer.jsp" />
