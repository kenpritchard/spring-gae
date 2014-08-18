<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
@import url(resources/css/custom.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events</title>
</head>
<body id="home">

	<div id="wrapper">

		<%@ include file="header.jspf"%>
		<%@ include file="linkbar.jspf"%>

		<div id="content" role="main">
			<c:if test="${requestScope.errors != null}">
				<div id="errors" role="main">
					<h5>Error<c:if test="${fn:length(requestScope.errors) > 1}">s</c:if> encountered:</h5>
					<ul>
						<c:forEach var="error" items="${requestScope.errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</div>


		<%@ include file="footer.jspf"%>
	</div>
</body>
</html>