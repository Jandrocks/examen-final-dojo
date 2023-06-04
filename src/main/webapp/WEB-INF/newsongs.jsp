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
<title>New Project</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body class="bg-dark text-white">
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-8">
				<h2>Create Songs</h2>
				<form:form action="/songs/new" method="post"
					modelAttribute="songnew" class="mt-3 bg-secondary p-2 mb-3"
					style="border-radius: 10px;">
					<form:hidden value="${usuario.id}" path="relacion" />
					<form:hidden value="0" path="colaborador" />

					<div class="d-flex justify-content-between mt-3">
						<form:label path="titulo" class="fs-5 col-4">Song Title:</form:label>
						<form:input path="titulo" class="col-8 form-control w-50" />
					</div>
					<form:errors path="titulo" class="text-danger" />

					<div class="d-flex justify-content-between mt-3">
						<form:label path="genero" class="fs-5 col-4">Genre:</form:label>
						<form:input path="genero" class="col-8 form-control w-50" />
					</div>
					<form:errors path="genero" class="text-danger" />

					<div class="d-flex justify-content-between mt-3">
						<form:label path="letracancion" class="fs-5 col-4">Add you Lirics: </form:label>
						<form:textarea path="letracancion" class="col-8 form-control w-50"
							style="height: 100px" />
					</div>
					<form:errors path="letracancion" class="text-danger" />

					<div class="d-flex justify-content-end mt-3">
						<input type="submit" value="Submit" class="btn btn-success" />
					</div>
				</form:form>


				<a href="/home" class="btn btn-danger me-4">Cancel</a>
			</div>

		</div>
	</div>

</body>
</html>