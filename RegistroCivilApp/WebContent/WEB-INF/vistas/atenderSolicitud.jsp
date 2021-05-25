<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${mensaje != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-info">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-8">
		<form method="POST" action="AtenderSolicitudController.do">
			<div class="field">
				<label class="label has-text-centered" for="filtro-select">Tipo
					de Solicitud</label>
				<div class="control has-text-centered">
					<div class="select">
						<select name="filtro-select" id="filtro-select">
							<option>Solicitud de cedula de identidad</option>
							<option>Retiro de cedula de identidad</option>
							<option>Solicitud de certificado de nacimiento</option>
							<option>Solicitud de certificado de defuncion</option>
						</select>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-info">Filtrar</button>
						</div>
					</div>
				</div>
			</div>


			<table class="table is-hovered is-bordered is-fullwidth">
				<thead class="has-background-primary">
					<tr>
						<th>N° de Atención</th>
						<th>Nombre Cliente</th>
						<th>Tipo de Solicitud</th>
						<th>Atender</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="solicitud" items="${solicitudes}">
						<tr>
							<td>${solicitud.id}</td>
							<td>${solicitud.nombre}</td>
							<td>${solicitud.tipo}</td>
							<td><a
								href="AtenderSolicitudController.do?atencionEliminar=${solicitud.rut}"
								class="button is-normal is-primary is-light">Atender</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			</form>
		</div>
	</div>
</main>
</body>
</html>
>
