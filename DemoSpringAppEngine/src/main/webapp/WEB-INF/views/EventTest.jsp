<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			<h5>Testing</h5>
		</div>
		<aside>
			<h1>Contactn</h1>
			<section role="complementary">
			<div class="sideBlock">
				<a href="mailto:ken@kenpritchard.com">
					<span class="sideLink">Email: ken@kenpritchard.com</span>
				</a>
			</div>
			<div class="sideBlock">
				<a href="http://www.linkedin.com/in/kenpritchard">
					<img
						src="http://s4.licdn.com/scds/common/u/img/logos/logo_132x32_2.png"
						alt="Connect on LinkedIn" />
				</a>
			</div>
			<div class="sideBlock">
				<a href="https://plus.google.com/113165860474166006627?prsrc=3">
					<img
						src="https://ssl.gstatic.com/images/icons/gplus-64.png"
						alt="Connect on Google+" />
				</a>
			</div>
			<div class="sideSpace"></div>
			<div class="sideSpace"></div>
			</section>
		</aside>

		<%@ include file="footer.jspf"%>
	</div>
</body>
</html>