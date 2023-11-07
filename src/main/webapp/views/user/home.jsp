<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
</head>
<body>
	<h1>List of Books</h1>
	<c:set var="index" value="0" scope="page" />
	<c:forEach items="${books}" var="book">
		<div class="d-flex border flex-row gap-4">
			<div style="width: 150px; height: 150px;">
				<img style="width: 150px; height: 150px;" alt=""
					src="${book.coverImage}">
			</div>
			<div>
				<h2>
					<a href="/Book/detailbook?id=${book.bookId}">${book.title}</a>
				</h2>
				<p>ISBN: ${book.isbn}</p>
				<p>Publisher: ${book.publisher}</p>
				<p>Publish Date: ${book.publishDate}</p>
				<p>Quantity: ${book.quantity}</p>
				<p>Reviews(${reviews[index]})</p>
			</div>
		</div>
		<c:set var="index" value="${index + 1}" scope="page" />
	</c:forEach>
</body>
</html>
