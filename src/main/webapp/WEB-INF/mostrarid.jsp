<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Proyecto</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body class="bg-dark text-white">
	<nav class="navbar bg-body-tertiary">
		<div class="container-fluid">
			<a href="/home">Back to Home</a>
		</div>
	</nav>
	<div class="container">
		<div class="row justify-content-center">
			<table
				class="table w-50 p-2 table table-dark table-hover aling-center ">
				<tbody>
					<tr class="table-active">
						<td colspan="2"><h1>
								<c:out value="${songid.titulo }"></c:out>
							</h1></td>
					</tr>
					<tr class="table-active">

						<td colspan="2">
							<h2>
								(Started by
								<c:out value="${songid.relacion.nombre }"></c:out>
								)
							</h2>
						</td>
					</tr>
					<tr class="table-active">
						<td colspan="2">Genre: <c:out value="${songid.genero }"></c:out></td>
					</tr>
					<tr class="table-active">
						<td colspan="2">Lyric: <br> <c:out
								value="${songid.letracancion }"></c:out></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="row justify-content-center">
			<div class="col-6 text-center">
				<a class="btn  btn-secondary" href="/songs/${ songid.id }/editar">Contribute
				</a>
			</div>
		</div>
	</div>

</body>
</html>