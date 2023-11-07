<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
<link
	href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script
	src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>

</head>
<body>
	<div style="padding: 0 30px" class="d-flex flex-column">
		<div style="padding-bottom: 30px"><%@ include
				file="/common/admin/Header.jsp"%></div>
		<div style="min-height: 400px">
			<decorator:body>
			</decorator:body>
		</div>
		<div><%@ include file="/common/admin/Footer.jsp"%></div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>