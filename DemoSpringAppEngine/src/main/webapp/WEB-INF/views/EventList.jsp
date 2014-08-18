<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import url(resources/css/custom.css);</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events</title>
</head>
	<body id="home">
	
		<div id="wrapper">
			
		<%@ include file="header.jspf" %>
		<%@ include file="linkbar.jspf" %>
			
			<div id="content" role="main">
				<c:if test="${fn:length(requestScope.eventlist) == 0}"><h5>No events so far, create one!</h5></c:if>
				<c:if test="${fn:length(requestScope.eventlist) > 0}"><h5>Events:</h5>
				<ul>
				<c:forEach var="event" items="${requestScope.eventlist}">
					<li>${event}</li>
				</c:forEach>
				</ul>
				</c:if>
			</div>
			
			<%@ include file="footer.jspf" %>
		</div>
	</body>
</html>