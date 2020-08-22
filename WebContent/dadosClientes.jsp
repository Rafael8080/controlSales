<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
th {
	padding: 10px;
}
</style>
</head>
<body>
	<h1>Dados Pessoais</h1>

	<form style="margin-bottom: 50px;">

		<label for="pesquisar">Nome</label> <input type="text" id="pesquisar">
		<input type="submit">
	</form>

	<table>
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Celular</th>
			<th>Telefone</th>
			<th>CEP</th>
			<th>Endereco</th>
			<th>Numero</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>Complemento</th>
			<th>UF</th>
			<th>CPF</th>
			<th>RG</th>
		</tr>
		<c:forEach items="${clientes }" var="cliente">
			<tr>
				<td><c:out value="${cliente.id }"></c:out></td>
				
				<td><c:out value="${cliente.nome }"></c:out></td>
				<td><c:out value="${cliente.email }"></c:out></td>
				<td><c:out value="${cliente.celular }"></c:out></td>
				<td><c:out value="${cliente.telefone }"></c:out></td>
				<td><c:out value="${cliente.cep }"></c:out></td>
				<td><c:out value="${cliente.endereco }"></c:out></td>
				<td><c:out value="${cliente.numero }"></c:out></td>
				<td><c:out value="${cliente.bairro }"></c:out></td>
				<td><c:out value="${cliente.cidade }"></c:out></td>
				<td><c:out value="${cliente.complemento }"></c:out></td>
				<td><c:out value="${cliente.uf }"></c:out></td>
				<td><c:out value="${cliente.cpf }"></c:out></td>
				<td><c:out value="${cliente.rg }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

	<a href="#">Novo</a>
	<a href="#">Salvar</a>
	<a href="#">Editar</a>
	<a href="#">Excluir</a>

</body>
</html>