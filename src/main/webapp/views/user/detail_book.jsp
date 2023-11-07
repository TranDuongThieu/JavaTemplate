<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
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
						<p>Review(${rating_count})</p>
					</div>
				</div>
				<div>
					<h3>Reviews (${rating_count})</h3>
					<c:forEach items="${ratings}" var="rating">
						<div class="d-flex gap-4">
							<span>${rating.user.fullname} : </span> <span>${rating.reviewText}</span>
						</div>
					</c:forEach>
					<div class="d-flex flex-column gap-2">
						<h4>Review this book</h4>
						<form action="/Book/submitReview" method="post">
							<textarea name="review" class="form-control" rows="3" required></textarea>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
