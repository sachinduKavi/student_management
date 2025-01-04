<%@page import="java.util.List"%>
<%@page import="app.entity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Students - Student Management System</title>
<!-- Bootstrap CSS -->
<% List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container py-5">
		<h1 class="mb-4">Student List</h1>
		<button class="btn btn-warning" data-bs-toggle="modal"
			data-bs-target="#studentModal">Add Student</button>
			
			<a href="goDashboard" type="button" class="btn btn-secondary" style="background-color: red;"
						>Close</a>
		<br><br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Enrollment Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Sample Student Data -->
				<%
				for(Student s: studentList) {
				%>
				<tr>
					<td><%=s.getFirst_name() + " " + s.getLast_name() %></td>
					<td><%=s.getEmail() %></td>
					<td><%=s.getEnrollment_date() %></td>
					<td style="display: flex; flex-direction: row; justify-content: space-evenly;">
						<form action="editStudent" method="post">
						<input type="hidden" name="stid" value="<%=s.getStudnet_id()%>"/>
						<button class="btn btn-warning btn-sm">Edit</button>
						</form>
						<form action="deleteStudent" method="post">
						<input type="hidden" name="stid" value="<%=s.getStudnet_id()%>"/>
						<button class="btn btn-danger btn-sm">Delete</button>
						</form>
					</td>
				</tr>
				<%} %>
				
			</tbody>
		</table>
		<!-- Modal -->
		<div class="modal fade" id="studentModal" tabindex="-1"
			aria-labelledby="studentModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h5 class="modal-title" id="studentModalLabel">Enter Student
							Details</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<!-- Modal Body with Form -->
					<div class="modal-body">
						<form id="studentForm" method="POST" action="save-student">
							<div class="mb-3">
								<label for="firstname" class="form-label">First Name</label> <input
									type="text" class="form-control" id="firstname"
									name="firstname" required>
							</div>
							<div class="mb-3">
								<label for="lastname" class="form-label">Last Name</label> <input
									type="text" class="form-control" id="lastname" name="lastname"
									required>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="email" class="form-control" id="email" name="email"
									required>
							</div>
							<div class="mb-3">
								<label for="dob" class="form-label">Date of
									Birth</label> <input type="date" class="form-control" id="dob"
									name="dob" required>
							</div>
							<div class="mb-3">
								<label for="gender" class="form-label">Gender</label> <select
									class="form-select" id="gender" name="gender" required>
									<option value="" selected disabled>Select Gender</option>
									<option value="M">Male</option>
									<option value="F">Female</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="phone" class="form-label">Phone</label> <input
									type="text" class="form-control" id="phone" name="phone"
									required>
							</div>
							<div class="mb-3">
								<label for="address" class="form-label">Address</label>
								<textarea class="form-control" id="address" name="address"
									rows="3" required></textarea>
							</div>
							<div class="mb-3">
								<label for="enrollmentdate" class="form-label">Enrollment
									Date</label> <input type="date" class="form-control"
									id="enrollmentdate" name="enrollmentdate" required>
							</div>
						</form>
					</div>

					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" form="studentForm">Save
							Student</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
