<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Students Directory</title>
</head>

<body>

	<div class="container">

		<h3>Students Directory</h3>
		<hr>

				<!-- Add a button -->
				<a href="/StudentsDebateEvent/students/showForForAdd"
					class="btn btn-primary btn-sm mb-3"> Add Book </a> 

					<a href="/StudentsDebateEvent/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a> 
	

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					
					<th>Action</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="tempstudent">
					<tr>
						<td><c:out value="${tempstudent.name}" /></td>
						<td><c:out value="${tempstudent.department}" /></td>
						<td><c:out value="${tempstudent.country}" /></td>
						
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentsDebateEvent/students/showFormForUpdate?studentId=${tempstudent.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/StudentsDebateEvent/students/delete?studentId=${tempstudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a>

						</td>
					

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>