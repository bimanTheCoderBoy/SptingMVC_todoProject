<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title><%=request.getAttribute("page")%></title>
</head>

<%
String pageName = (String) request.getAttribute("page");
%>
<body>


	<div class="container pt-2">
		<h1 class="text-center">Welcome To Spring TODO App</h1>

		<div class="appBody row mt-5">
			<div class="col-md-2">

				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active"
						aria-current="true">Menu </a> <a href="add"
						class="list-group-item list-group-item-action" action="login.jsp">Add
						Task</a> <a href="home" class="list-group-item list-group-item-action">Incomplete
						Tasks</a>
						<a href="homeCompleted" class="list-group-item list-group-item-action">Completed
						Tasks</a>


				</div>
			</div>
			<div class="col-md-10">
				<h3 class="text-center"><%=pageName%></h3>
				<c:if test="${page=='Add Tasks'}">
					<form:form action="saveTodo" method="post" modelAttribute="Todo">
						<div class="form-group">
							<label for="todoTitle" class="form-label">Title</label>
							<form:input path="title" cssClass="form-control"
								placeholder="Type your todo title " id="todoTitle" />
						</div>

						<div class="form-group">
							<label for="todoTitle" class="form-label">Task</label>
							<form:textarea path="message" cssStyle="height:250px"
								cssClass="form-control" placeholder="Write your todo"
								id="todoTitle" />
						</div>
						<div class="text-center mt-5">
							<button type="submit" class="btn btn-primary">Save Task</button>
						</div>
					</form:form>
				</c:if>
				<c:if test="${page=='All Tasks'}">
					<c:forEach items="${taskList}" var="e">
						
						<div class="card mb-3">
							<div class="card-body">
							<div class="row">
							<div class="col-10">
							<div class="row ps-3 pb-3"><c:out value="${e.title}"></c:out></div>
							
							<div class="row ps-3 pb-4"><c:out value="${e.message}"></c:out></div>
							
							
							<div class="row ps-3"><c:out value="${e.date}"></c:out></div>
							</div>
							<div class="col-2 text-center" Style="display:flex;align-items:center;">
							<form action="doneTodo" method="post">
							<input type="hidden" name="title" value="${e.title}"/>
							<button type="submit" class="btn btn-primary" >done</button>
							</form>
							</div>
							</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${page=='Done Tasks'}">
				<c:forEach items="${taskList}" var="e">
						
						<div class="card mb-3">
							<div class="card-body">
							<div class="row">
							<div class="col-10">
							<div class="row ps-3 pb-3"><c:out value="${e.title}"></c:out></div>
							
							<div class="row ps-3 pb-4"><c:out value="${e.message}"></c:out></div>
							
							
							<div class="row ps-3"><c:out value="${e.date}"></c:out></div>
							</div>
							<div class="col-2 text-center" Style="display:flex;align-items:center;">
							<form action="deleteTodo" method="post">
							<input type="hidden" name="title" value="${e.title}"/>
							<button type="submit" class="btn btn-primary" >delete</button>
							</form>
							</div>
							</div>
							</div>
						</div>
					</c:forEach>
				</c:if>

			</div>
		</div>

	</div>











	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>