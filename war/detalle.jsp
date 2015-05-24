<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Detalle del <strong>${alumno.nombre} ${alumno.apaterno} ${alumno.amaterno}</strong></h4>
</div>
<div class="panel-body">

	<!-- Detalle -->
	<div class="row">
		<div class="col-xs-12 col-md-6 col-lg-4 item">
			<div class="timeline-block">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="media">
							<div class="media-left">
								<a href=""><img src="images/detalle.jpg"
									class="media-object"></a>
							</div>
							<div class="media-body">
								<a>Campo semantico</a> <span>Animales de la granja</span>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="timeline-added-images text-center">
							<img src="images/guy-5.jpg" alt="photo" width="70"> 
							<img src="images/guy-5.jpg" alt="photo" width="70"> 
							<img src="images/guy-5.jpg" alt="photo" width="70">
							<img src="images/memorama.png" alt="photo" width="70">
						</div>
					</div>
					<div class="view-all-comments">
						<a href="#"><i class="fa fa-book"></i> Informacion general
						</a>

					</div>
					<ul class="comments">
						<li class="media">
							<div class="media-left">
							<i class="fa fa-clock-o fa-2x media-object"></i>
							</div>
							<div class="media-body">
								<a href="" class="comment-author pull-left">Tiempo promedio </a> 
								<span class="pull-right">12:34 min</span>
							</div>
						</li>
						<li class="media">
							<div class="media-left">
								<i class="fa fa-calculator fa-2x media-object"></i>
							</div>
							<div class="media-body">
								<a href="" class="comment-author pull-left">Total de veces jugado </a> 
								<span class="pull-right">34</span>
							</div>
						</li>
						<li class="media">
							<div class="media-left">
								<i class="fa fa-thumbs-o-up fa-2x media-object"></i>
							</div>
							<div class="media-body">
								<a href="" class="comment-author pull-left">Total de aciertos </a> 
								<span class="pull-right">12</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>


	</div>
	<!-- Fin Detalle -->

</div>
<jsp:include page="common/footer.jsp" />
