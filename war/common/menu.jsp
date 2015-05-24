<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar component with st-effect-1 (set on the toggle button within the navbar) -->
<div
	class="sidebar left sidebar-size-2 sidebar-offset-0 sidebar-visible-desktop sidebar-visible-mobile sidebar-skin-dark"
	id="sidebar-menu" data-type="collapse">
	<div data-scrollable>
		<div class="sidebar-block">
			<div class="profile">
				<img src="img/guy-5.jpg" alt="people" class="img-circle">
				<h4>${usuario}</h4>
			</div>
		</div>

		<ul class="sidebar-menu">
			<li class="active"><a href="home.jsp"><i
					class="fa fa-columns"></i> <span>Supervisar</span></a></li>
			<!-- Sample 2 Level Collapse -->
			<li class="hasSubmenu"><a href="#submenu2"><i
					class="fa fa-chevron-circle-down"></i> <span>Estadistica</span></a>
				<ul id="submenu2">
					<li><a href="estadisticaGeneral.jsp"><i class="fa fa-circle-o"></i>
							General Alumnos</a></li>
				</ul></li>
			<li class="hasSubmenu"><a href="#submenu3"><i
					class="fa fa-chevron-circle-down"></i> <span>Altas</span></a>
				<ul id="submenu3">
					<li><a href="perfiles?alta=alumno"><i class="fa fa-circle-o"></i>
							Alta de Alumnos</a></li>
					<li><a href="perfiles?alta=profesor"><i class="fa fa-circle-o"></i>
							Alta de Profesores</a></li>
				</ul></li>
		</ul>
	</div>
</div>
<!-- sidebar effects OUTSIDE of st-pusher: -->