<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<link href ="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel ="stylesheet"> 
	<link href ="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel ="stylesheet"> 
		<body> 

		<%@include file= "Common/navigation.jspf" %>
		
			<div class="conainer">
			<h1> Welcome   ${name } </h1>    <!-- this is only to pass the name such as welcome nishchal from controllr to jsp -->
			<a href ="List-todos">Manage</a> Your todos
		</div>
	</body>
	
	
</html>