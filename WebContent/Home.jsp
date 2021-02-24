<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<div class="jumbotron text-center header"
		style="background: linear-gradient(to bottom, #ccffff 0%, #ffff66 100%);">
		<h1>File Upload</h1>
		<p>code for uploading files</p>
	</div>
	<div class="container text-center">
		<div class="row">
			<form class="form-inline" action="uploadController" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="email">File Upload:</label> <input type="file"
						name="file" class="form-control" id="file" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>

	<c:if test="${status eq 'done'}">
		<script type="text/javascript">
			alert("Uploaded Successfully");
		</script>
	</c:if>
	<c:if test="${status eq 'error'}">
		<script type="text/javascript">
			alert("Error Occured.. Try again with different file");
		</script>
	</c:if>

</body>
</html>