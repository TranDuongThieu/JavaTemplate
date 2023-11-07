<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h5 class="mt-5">List of Users</h5>
		<table class="table table-bordered mt-3">
			<thead class="thead-dark">
				<tr>
					<th>User ID</th>
					<th>Email</th>
					<th>Full Name</th>
					<th>Phone</th>
					<th>Signup Date</th>
					<th>Last Login</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.fullname}</td>
						<td>${user.phone}</td>
						<td>${user.signupDate}</td>
						<td>${user.lastLogin}</td>
						<td>
							<form action="admin/deleteUser?id=${user.id}" method="post">
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
							<form action="admin/updateUser" method=get>
								<input type="hidden" name="id" value="${user.id}">
								<button type="submit" class="btn btn-info">Update</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
