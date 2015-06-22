<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:include page="common/header.jsp" />

<h4 class="panel-title">Seguimiento de los alumnos</h4>
</div>
<div class="panel-body">
	<!-- Data table -->
	<table id="data-table" class="table" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Nombre(s)</th>
				<th>A.Paterno</th>
				<th>A.Materno</th>
				<th>Evaluar</th>
				<th>Estadistica</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alumnos}" var="element">
				<tr>
					<td>${element.nombre}</td>
					<td>${element.apaterno}</td>
					<td>${element.amaterno}</td>

					<td><a href="evaluar?alumno=${element.idAlumno}"
						class="btn btn-info btn-stroke btn-circle"> <i
							class="fa fa-eye"></i>
					</a></td>
					<td><a href="estadistica.jsp"
						class="btn btn-success btn-stroke btn-circle"> <i
							class="fa fa-line-chart"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- // Data table -->
</div>

<jsp:include page="common/footer.jsp" />