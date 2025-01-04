<%@page import="app.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Courses - Student Management System</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<%
	List<Course> courseList = (List<Course>) request.getAttribute("courseList");

%>
	<div class="container py-5">
		<h1 class="mb-4">Courses List</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Course Code</th>
					<th>Credits</th>
					<th>Department</th>
					<!-- New column for department -->
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Sample Course Data -->
				<%
				for(Course c: courseList) {
				
				%>
				
				<tr>
					<td><%=c.getCourse_id() %></td>
					<td><%=c.getCourse_name() %></td>
					<td><%=c.getCourse_code() %></td>
					<td><%=c.getCredits() %></td>
					<td><%=c.getDepartment_id() %></td>
					<!-- Displaying department name -->
					<td><a href="editCourse.html" class="btn btn-warning btn-sm">Edit</a>
						<a href="deleteCourse.html" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
				
				<%} %>
				
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
