<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex align-items-center justify-content-between">
		<div>HEADER</div>
		<a href="#">Trang chu</a> <a href="#">San pham</a>
		<c:if test="${account.id != null }">
			<form action="logout" method="post">
				<button id="btn__logout" class="dropdown-item p-2" href="#">Đăng
					Xuất</button>
			</form>
		</c:if>
		<c:if test="${account.id == null }">
			<a href="/Book/authentication-login">Dang Nhap</a>
		</c:if>
		<a href="#">Trang quan tri</a>
	</div>
</body>
</html>