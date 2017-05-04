<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-theme.min.js"></script>
<title>Search</title>


<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="vertical-center">
		<div class="container">
			<div class="horizontal-center">
				<div class="horizontal layout center">
					<h1>Shopping Cart</h1>
					<div class="flex"></div>
				</div>

				<div class="vertical-section">
					<c:if test="${empty items}">
						<h4>Shopping Cart is Empty</h4>
					</c:if>
					<c:if test="${!empty items}">
						<table class="table table-striped">
							<thead>
								<tr>
									<td class=col-xs-9">Title</td>
									<td class=col-xs-3>Delete</td>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${items}">
									<tr>
										<td class="col-xs-9">${item.getAttributeString('title')}</td>
										<td class="col-xs-3"><a
											href="search?action=remove&amp;key=${item.getAttributeString('key')}">
												<button type="submit" class="btn btn-link btn-lg">
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<a href="search" class="btn btn-primary btn-md">Back To Search</a>
				</div>
			</div>
		</div>

	</div>

</body>
</html>