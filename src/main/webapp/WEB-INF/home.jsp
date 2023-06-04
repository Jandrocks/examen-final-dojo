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
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body class="bg-dark text-white pt-5">
	<div class="container">
		<div class="text-center">
			<h4>Hello, ${ usuario.nombre }</h4>
			<h1 class="text-primary">All Songs Labs</h1>
		</div>
		<div class="text-end">
			<a href="/logout" class="btn btn-secondary">Logout</a>
		</div>
		<div class="row justify-content-center">
			<table class="table w-50 table table-dark table-hover aling-center">
				<thead>
					<tr>
						<th scope="col" class="h2">Songs</th>
						<th scope="col">N of Colaboration</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ songall }" var="songs">
						<tr>
							<th scope="row"><a class="h2" href="/songs/${ songs.id }">${ songs.titulo }</a>
								<br> Genre: ${ songs.genero }</th>
							<td class="h2">${ songs.colaborador }</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<div class="row justify-content-center">
			<div class="col-6 text-center">
				<a class="btn btn-success" href="/songs/new">new song</a>
			</div>
		</div>
	</div>
</body>
</html>