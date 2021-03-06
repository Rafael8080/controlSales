<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados Pessoais</title>

<style>
th {
	padding: 10px;
}

td{
	padding:5px;
}
</style>
</head>
<body>
<a href="/controlSales/index.jsp">Inicio</a>
	<h1>Dados Pessoais</h1>
	<a href="cadastroCliente.jsp">Cadastro Clientes</a>
	<form action="consultarNome?acao=pesquisarCliente" method="post" style="margin-bottom: 50px; margin-top: 25px;">
		<input type="text" id="nomeConsulta" name="nomeConsulta">
		<input type="submit" value="Enviar">
	</form>

	<table style="text-aline:center;" style="width:100%;" border="1">
		<tr >
			<th>C�digo</th>
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
			<th>Editar</th>
			<th>Excluir</th>
			<th>Novo</th>

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
				<td><a
					href="salvarCliente?acao=editarCliente&idCliente=${cliente.id }">Editar</a></td>
				<td><a
					href="salvarCliente?acao=excluirCliente&idCliente=${cliente.id }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>