<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>My Contacts WebApp</h1>

	<c:if test="${not empty message }">
		<p>${mensagem}</p>
	</c:if>

	<c:choose>
		<c:when test="${not empty contactsList}">
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="contact" items="${contactsList}">
						<tr>
							<td>${contact.name}</td>
							<td>${contact.email}</td>
							<td>${contact.phone}</td>
							<td>
								<ul>
									<li><a href='${linkTo[ContactController].edit(contact)}'>Editar</a></li>
									<li>
										<form action='${linkTo[ContactController].remove()}' method='post'>
											<input type='hidden' name='contact.id' value='${contact.id}' />
											<input type='submit' value='Remover' />
										</form>
									</li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>Não existe nenhum contato cadastrado</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
