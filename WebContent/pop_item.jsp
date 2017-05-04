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
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-theme.min.js"></script>
<script src="bootstrap/js/jquery.min.js"></script>
<title>${item.getAttributeString('title')}</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="vertical layout center">
		<div class="container">
			<table class="table table-striped">
				<thead>
					<h4>${item.getAttributeString('title')}</h4>
				</thead>
				<tbody>${item.printItem()}
				</tbody>
			</table>
			<a href="search" class="btn btn-primary btn-md">Back To Search</a> <a
				href="search?action=addpop&amp;key=${item.getAttributeString('key')}"
				class="btn btn-success btn-md">Add To Cart</a>
		</div>
	</div>
</body>
</html>