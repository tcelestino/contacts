<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>My Contacts WebApp</h1>

	<table>
		<thead>
			<tr>
				<td>Lista de Contatos</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Telefone</td>
				<td>Ações</td>
			</tr>
			<c:forEach var="contact" items="${contacts}">
				<tr>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.phone}</td>
					<td>
						<ul>
							<li><a href='/contact/edit'>Editar</a></li>
							<li>
								<form action='${linkTo[ContactController].remove()}' method='post'>
									<input type='hidden' name='${contact.id}'>
									<button>Remover</button>
								</form>
							</li>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
