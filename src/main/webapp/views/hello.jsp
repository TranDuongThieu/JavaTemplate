<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Categories</h1>
	<c:if test="${not empty categories}">
		<ul>
			<c:forEach var="category" items="${categories}">
				<li>${category.cateName}</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
</body>
</html>