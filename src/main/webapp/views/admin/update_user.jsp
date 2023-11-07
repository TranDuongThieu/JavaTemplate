<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>User Update</h2>

		<form action="updateUser" method="post">
			<div class="form-group">
				<label for="id">User ID</label> <input type="text"
					class="form-control" id="id" name="id" value="${user.id}" readonly>
			</div>

			<div class="form-group">
				<label for="name">fullname</label> <input type="text"
					class="form-control" id="fullname" name="fullname"
					value="${user.fullname}">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" value="${user.email}">
			</div>
			<div class="form-group">
				<label for="email">Phone</label> <input type="phone"
					class="form-control" id="phone" name="phone" value="${user.phone}">
			</div>
			<div class="form-group">
				<label for="passowrd">Phone</label> <input type="text"
					class="form-control" id="passwd" name="passwd"
					value="${user.passwd}">
			</div>
			<!-- Add more fields as needed -->

			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
