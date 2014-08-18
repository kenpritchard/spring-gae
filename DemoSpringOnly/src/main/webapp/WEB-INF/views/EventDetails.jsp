<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<h5>Event Details:</h5>
				<p>
				ID: ${event.id}<br/>
				Name: ${event.title}<br/>
				Date: ${event.date}<br/>
				<!-- Date: <fmt:formatDate type="both" value="${event.date}" dateStyle="medium" timeStyle = "short" /><br/> -->
				</p>
			</div>
			
			
			<%@ include file="footer.jspf" %>
		</div>
	</body>
</html>