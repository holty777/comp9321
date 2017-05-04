<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="bootstrap/js/bootstrap.min.js" type=""></script>
<script src="bootstrap/js/bootstrap-theme.min.js" type=""></script>
<script src="bootstrap/js/jquery.min.js" type=""></script>
<title>Advanced Search</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="vertical-center">
		<div class="container">
			<div class="horizontal-center">
				<div class="horizontal layout center">
					<h1>Advanced Search</h1>
					<div class="flex"></div>
				</div>
				<div class="vertical-section">
					<form id="form" method="post" action="search">
						<div id="form-fields">
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
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Editor"
									name="editor" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="BookTitle"
									name="booktitle" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Pages"
									name="pages" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Address"
									name="address" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Journal"
									name="journal" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Volume"
									name="volume" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Number"
									name="number" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Month"
									name="month" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="URL"
									name="url" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="EE"
									name="ee" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="CDRom"
									name="cdrom" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Cite"
									name="cite" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Note"
									name="note" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="CrossRef"
									name="crossref" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="ISBN"
									name="isbn" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Series"
									name="series" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Chapter"
									name="chapter" aria-describedby="basic-addon2" />
							</div>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Publnr"
									name="publnr" aria-describedby="basic-addon2" />
							</div>
						</div>
						<input type="hidden" name="action" value="search" />
						<div class="flex"></div>
						<button onclick="submitForm()" class="btn btn-primary btn-md">
							Search</button>
					</form>
				</div>
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
		function submitForm() {
			var e = document.getElementById("article-type");
			var type = e.options[e.selectedIndex].value;
			document.getElementById("form").submit();
		}
	</script>
</body>
</html>