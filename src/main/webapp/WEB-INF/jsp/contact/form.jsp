<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='${linkTo[ContactController].create}' method='post' name='save-contact'>
		<fieldset>
			<legend>Adicionar novo contato</legend>
			<label>
				Nome:
				<input type='text' name='contact.name'/>
			</label>
			<label>
				Email:
				<input type='email' name='contact.email'/>
			</label>

			<label>
				Telefone:
				<input type='tel' name='contact.phone'/>
			</label>
			<input type='submit' value='Salvar'/>
		</fieldset>
	</form>

	<c:if test="${not empty errors}">
		<c:forEach var="error" items="${errors}">
			${error.category} - ${error.message}<br />
       </c:forEach>
    </c:if>
</body>
</html>