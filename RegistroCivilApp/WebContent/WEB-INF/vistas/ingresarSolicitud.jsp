<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${errores != null }">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-danger">
					<h6>Existen errores en el formulario</h6>
					<div class="content">
						<ul>
							<c:forEach var="error" items="${errores}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="IngresarSolicitudController.do">
				<div class="card">
					<div class="card-header has-background-warning">
						<span class="card-header-title">Ingresar Solicitud</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="rut-txt">Rut (sin puntos ni guion)</label>
							<div class="control">
								<input type="text" class="input" id="rut-txt" name="rut-txt" />
							</div>
						</div>

						<div class="field">
							<label class="label" for="nombre-txt">Nombre y apellido</label>
							<div class="control">
								<input type="text" class="input" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="tipo-select">Tipo de Solicitud</label>
							<div class="control">
								<div class="select">
									<select name="tipo-select" id="tipo-select">
										<option>Solicitud de cedula de identidad</option>
										<option>Retiro de cedula de identidad</option>
										<option>Solicitud de certificado de nacimiento</option>
										<option>Solicitud de certificado de defuncion</option>
									</select>
								</div>
							</div>
						</div>

						<div class="field">
						<p class="subtitle is-6 has-text-info">*En el caso de Retiro de cedula de identidad, ingrese numero de solicitud original*</p>
						</div>
							<div class="field">
								<label class="label" for="condicion-txt">Ingrese numero de solicitud de cedula de identidad original</label>
								<div class="control">
									<input type="number" class="input" name="condicion-txt" id="condicion-txt"/>
								</div>
							</div>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Ingresar Solicitud</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>