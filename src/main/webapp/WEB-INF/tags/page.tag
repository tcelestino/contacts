<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="title" required="false" description="page title" %>
<html>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel='stylesheet' href='https://necolas.github.io/normalize.css/5.0.0/normalize.css'>
	<link rel='stylesheet' href='/assets/css/app.css'>
	<title>${title}</title>
	<body>
		<header>
			<h1><a href='#' class='navbar-brand'>My Contacts WebApp</a></h1>
			<form class="navbar-form navbar-left" role="search">
				<div class='form-group'>
					<input type='text' class='form-control' placeholder='Search for contacts'>
				</div>
				<input type='submit' class='btn btn-default' value='Find it'>
			</form>
		</header>
	<jsp:doBody/>
	</body>
</html>