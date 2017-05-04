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

<title>Results</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="snackbar.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="vertical-section-container centered"
		style="margin-bottom: 20px;"></div>

	<div class="vertical layout center">
		<div class="container">
			<div class="horizontal layout center">
				<h1>Results</h1>
			</div>


			<c:choose>
				<c:when test="${fn:length(items) > 0}">
					<table class="table table-striped">
						<tbody>
							<c:forEach var="item" items="${items}">
								<tr>
									<td class="col-xs-11">${item.getAttributeString('title')}</td>
									<td class="col-xs-1"><a
										href="search?action=item&amp;key=${item.getAttributeString('key')}">
											<button type="submit" class="btn btn-link btn-lg">
												<span class="glyphicon glyphicon-info-sign"
													aria-hidden="true"></span>
											</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div style="text-align: center">
						<c:if test="${!results.isStart()}">
							<a href="search?action=backward">
								<button type="submit" class="btn btn-link btn-lg">
									<span class="glyphicon glyphicon-chevron-left"
										aria-hidden="true"></span>
								</button>
							</a>
						</c:if>

						<span>${results.getCurPageNo()} of
							${results.getNoPages()}</span>

						<c:if test="${!results.isEnd()}">
							<a href="search?action=forward">
								<button type="submit" class="btn btn-link btn-lg">
									<span class="glyphicon glyphicon-chevron-right"
										aria-hidden="true"></span>
								</button>
							</a>
						</c:if>
					</div>

				</c:when>
				<c:otherwise>
					<div id="no-results-message" class="page-centered">
						<h2>
							Sorry, no matching results found! <br /> <a href="search"
								class="search-again">Search Again?</a>
						</h2>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>