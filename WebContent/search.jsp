<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="bootstrap/js/jquery.min.js" type=""></script>
<script src="bootstrap/js/bootstrap.min.js" type=""></script>

<title>Search</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="vertical-center">
		<div class="container">
			<div class="horizontal-center">
				<div class="horizontal layout center">
					<h1>Search</h1>
					<div class="flex"></div>
				</div>
				<div class="vertical-section">
					<form id="form" method="post">
						<div class="input-group">
							<select class="form-control" id="article-type" name="type">
								<option value="">Type - (any)</option>
								<c:forEach var="t" items="${types}">
									<option value="${t}">${t}</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Title"
								name="title" aria-describedby="basic-addon2" />
						</div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Author"
								name="author" aria-describedby="basic-addon2" />
						</div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Publisher"
								name="publisher" aria-describedby="basic-addon2" />
						</div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="School"
								name="school" aria-describedby="basic-addon2" />
						</div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Year"
								name="year" aria-describedby="basic-addon2" />
						</div>

						<input type="hidden" name="action" value="search" />
					</form>
					<button onclick="submitForm()" class="btn btn-primary btn-md">
						Search</button>
					<a href="search?action=advanced">
						<button class="btn btn-info btn-md">Advanced Search</button>
					</a>
				</div>
				<h4>Popular Publications</h4>
				<table class="table table-striped">
					<c:forEach var="item" items="${rand}">
						<tr>
							<td class="col-xs-11">${item.getAttributeString('title')}</td>
							<td class="col-xs-1"><a
								href="search?action=popitem&amp;key=${item.getAttributeString('key')}">
									<button type="submit" class="btn btn-link btn-lg">
										<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>


	</div>
	<script type="">
		$('.dropdown-toggle').dropdown();
		$('#divNewNotifications li > a').click(function(){
	    	$('#text').text($(this).html());
		});
	</script>
	<script>
		function submitForm(){
			var e = document.getElementById("article-type");
			var type = e.options[e.selectedIndex].value;
			document.getElementById("form").submit();
		}
	
	</script>
</body>
</html>