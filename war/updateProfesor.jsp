<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Actualizar Información de profesores</h4>
</div>
<div class="panel-body">
	<!-- Data table -->
	<table id="data-table" class="table" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Nombre(s)</th>
				<th>A.Paterno</th>
				<th>A.Materno</th>
				<th>Correo</th>
				<th>Actualizar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${profesores}" var="element">
				<tr>
					<td>${element.nombre}</td>
					<td>${element.apaterno}</td>
					<td>${element.amaterno}</td>
					<td>${element.email}</td>

					<td><a href="actualizar?editar=profesor&detalle=${element.idProfesor}&eliminar=no"
						class="btn btn-info btn-stroke btn-circle"> <i
							class="fa fa-pencil-square-o"></i>
					</a></td>
					<td><a href="actualizar?editar=profesor&detalle=${element.idProfesor}&eliminar=si"
						class="btn btn-danger btn-stroke btn-circle"> <i
							class="fa fa-trash"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- // Data table -->
</div>

<jsp:include page="common/footer.jsp" />