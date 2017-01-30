<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${foo} blah
	<form action='' method='post' name='edit-contact'>
		<fieldset>
			<legend>Editar</legend>
			<label>
				Nome:
				<input type='text' name='contact.name' value=''/>
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
</body>
</html>