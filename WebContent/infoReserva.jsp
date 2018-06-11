<%@page import="modelo.Reserva"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- para poder utilizar etiquetas de jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
Object objeto = session.getAttribute("reserva"); 

Reserva reserva = (Reserva) objeto; 

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserva</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<jsp:include page="navBar.html"></jsp:include>

	<!-- inprimir la lista de parcelas con jstl -->
	<div class="container">
		<div class="row">
			<div class="col">
				<hr>
				<h1>Info de la parcela reservada</h1>
				<table class="table">
					<thead>
						<tr>
							<th>numero</th>
							<th>m<sub>2</sub></th>
							<th>Precio dia</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>${sessionScope.reserva.parcela.numero }</td>
							<td>${sessionScope.reserva.parcela.m_cuadrados }</td>
							<td>${sessionScope.reserva.parcela.precio_dia }</td>
							
						</tr>


					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<hr>
				<h1>Info de la reserva</h1>
				<table class="table">
					<thead>
						<tr>
							<th>nombre</th>
							<th>apellido</th>
							<th>dni</th>
							<th>numero de usuarios</th>
							<th>desde</th>
							<th>hasta</th>
							<th>luz</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>${sessionScope.reserva.nombre_usuario }</td>
							<td>${sessionScope.reserva.apellido_usuario }</td>
							<td>${sessionScope.reserva.dni_usuario }</td>
							<td>${sessionScope.reserva.numero_usuarios }</td>
							<td>${sessionScope.reserva.inicio_reserva }</td>
							<td>${sessionScope.reserva.fin_reserva }</td>
							<td>${sessionScope.reserva.luz }</td>
						</tr>


					</tbody>
				</table>
				<a href="/examen3ebal1/AlmacenarReserva">ConfirmarReserva</a><br>
				<a href="/examen3ebal1/CancelarReserva">Cancelar</a>
			</div>
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>