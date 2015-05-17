<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			<th>Avance</th>
			<th>Detalle</th>
			<th>Estadistica</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Tiger Nixon</td>
			<td>Architect</td>
			<td>Edinburgh</td>
			<td>61%</td>
			<td><a href="detalle.jsp"
				class="btn btn-info btn-stroke btn-circle"> <i class="fa fa-eye"></i>
			</a></td>
			<td><a href="estadistica.jsp"
				class="btn btn-success btn-stroke btn-circle"> <i
					class="fa fa-line-chart"></i>
			</a></td>
		</tr>
	</tbody>
</table>

<!-- // Data table -->
</div>

<jsp:include page="common/footer.jsp" />