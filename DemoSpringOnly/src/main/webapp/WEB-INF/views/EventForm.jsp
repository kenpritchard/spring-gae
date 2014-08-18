<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
@import url(resources/css/custom.css);
@import url(resources/css/flick/jquery-ui-1.8.21.custom.css);
</style>

<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>
		<script type="text/javascript">
			$(function(){

				// Accordion
				$("#accordion").accordion({ header: "h3" });

				// Tabs
				$('#tabs').tabs();

				// Dialog
				$('#dialog').dialog({
					autoOpen: false,
					width: 600,
					buttons: {
						"Ok": function() {
							$(this).dialog("close");
						},
						"Cancel": function() {
							$(this).dialog("close");
						}
					}
				});

				// Dialog Link
				$('#dialog_link').click(function(){
					$('#dialog').dialog('open');
					return false;
				});

				// Datepicker
				$('#datepicker').datepicker({
					inline: true
				});

				// Slider
				$('#slider').slider({
					range: true,
					values: [17, 67]
				});

				// Progressbar
				$("#progressbar").progressbar({
					value: 20
				});

				//hover states on the static widgets
				$('#dialog_link, ul#icons li').hover(
					function() { $(this).addClass('ui-state-hover'); },
					function() { $(this).removeClass('ui-state-hover'); }
				);

			});
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter/Search Event</title>
</head>
<body id="home">

	<div id="wrapper">
		<%@ include file="header.jspf" %>
		<%@ include file="linkbar.jspf" %>

		<div id="content" role="main">
			<c:if test="${requestScope.errors != null}">
			<div id="errors" role="main">
				<h5>Error<c:if test="${fn:length(requestScope.errors) > 1}">s</c:if> found in form, please correct and resubmit</h5>
				<ul>
				<c:forEach var="error" items="${requestScope.errors}">
					<li>${error}</li>
				</c:forEach>
				</ul>
			</div>
			</c:if>
			<c:if test="${requestScope.errors == null}">
				<h5>Create a new event...</h5>
			</c:if>
			<form:form modelAttribute="event" method="post" action="save_event">
				<form:label path="title">Name: </form:label>
				<form:input type="text" path="title" />
				<form:label path="date">Date: </form:label>
				<form:input type="text" name="date" id="datepicker" path="date" />
				<button type="submit">Save</button>
				<button type="reset">Reset</button>
<!--         <button type="submit" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"> -->
<!--             <span class="ui-button-text">Save</span> -->
<!--         </button>  -->
<!--         <button type="reset" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"> -->
<!--             <span class="ui-button-text">Reset</span> -->
<!--         </button>   -->
			</form:form>
			
		</div>

		<%@ include file="footer.jspf" %>
	</div>
</body>
</html>