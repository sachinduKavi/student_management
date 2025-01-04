<%@page import="app.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Edit</title>
<%
	Student student = (Student) request.getAttribute("student");
%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="display:flex; flex-driection: column; justify-content:center; align-items:center; padding-top: 10px;">


				<div style="width: 50%">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h5 class="modal-title" id="studentModalLabel">Student
							Details</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<!-- Modal Body with Form -->
					<div class="modal-body">
						<form id="studentForm" method="POST" action="studentUpdate">
							<div class="mb-3">
								<label for="firstname" class="form-label">First Name</label> <input
									type="text" class="form-control" id="firstname"
									value="<%=student.getFirst_name() %>"
									name="firstname" required>
							</div>
							<div class="mb-3">
							<input type="hidden" name="stid" value="<%=student.getStudnet_id() %>"/>
								<label for="lastname" class="form-label">Last Name</label> <input
									type="text" class="form-control" id="lastname" name="lastname"
									value="<%=student.getLast_name() %>"
									required>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="email" class="form-control" id="email" name="email"
									value="<%=student.getEmail() %>"
									required>
							</div>
							<div class="mb-3">
								<label for="dob" class="form-label">Date of
									Birth</label> <input type="date" class="form-control" id="dob"
									value="<%=student.getDate_of_birth() %>"
									name="dob" required>
							</div>
							<div class="mb-3">
								<label for="gender" class="form-label">Gender</label> <select
									class="form-select" id="gender" name="gender" required>
									<option value="" disabled>Select Gender</option>
									<option value="M" <%=(student.getGender() == 'M') ? "selected" : "" %>>Male</option>
									<option value="F" <%=(student.getGender() == 'F') ? "selected" : "" %>>Female</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="phone" class="form-label">Phone</label> <input
									type="text" class="form-control" id="phone" name="phone"
									value="<%=student.getPhone() %>"
									required>
							</div>
							<div class="mb-3">
								<label for="address" class="form-label">Address</label>
								<textarea class="form-control" id="address" name="address"
									rows="3" required><%=student.getAddress() %></textarea>
							</div>
							<div class="mb-3">
								<label for="enrollmentdate" class="form-label">Enrollment
									Date</label> <input type="date" class="form-control"
									value="<%=student.getEnrollment_date() %>"
									id="enrollmentdate" name="enrollmentdate" required>
							</div>
						</form>
					</div>

					<!-- Modal Footer -->
					<div class="modal-footer">
						<a href="students" type="button" class="btn btn-secondary" style="background-color: red;"
						>Close</a>
						<button type="submit" class="btn btn-primary" form="studentForm">Save
							Student</button>
					</div>
				</div>
				</div>
		

</body>
</html>