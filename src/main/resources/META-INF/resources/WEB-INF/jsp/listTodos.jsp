
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
	<link href ="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel ="stylesheet"> 
		<title>This is todos list</title>
	</head>
	</body>
		<%@include file= "Common/navigation.jspf" %>
		
		<div class ="container">
				
		<h1>YOUR TODO LIST ARE</h1>
	<table class="table">
		<thead> 
			<tr>
				
				<th> Description </th>
				<th> Target Date </th>
				<th> is done? </th>
				<th> </th>
				<th> </th>
				
				</tr>
		 </thead>
		<tbody>
			<c:forEach items="${todos }" var="todo"> 
				<tr>
					
					<td> ${todo.description}</td>
					<td> ${todo.targetDate}</td>
					<td> ${todo.done}</td>
					<td> <a href="delete-todo?id=${todo.id}"  class="btn btn-warning">Delete</a>   </td>
					<td> <a href="update-todo?id=${todo.id}"  class="btn btn-success">Update</a>   </td>
					
					</tr>
		</c:forEach>
		</tbody>
		</table>
		<a href="add-todo" class="btn btn-primary" >Add Todo</a>
	</div>
		<script src = "webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>

	</body>
</html>