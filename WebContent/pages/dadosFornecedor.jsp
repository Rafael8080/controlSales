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
	<a href="cadastroFornecedor.jsp">Cadastro Clientes</a>
	<form action="consultarNome?acao=pesquisarFornecedor" method="post" style="margin-bottom: 50px; margin-top: 25px;">
		<input type="text" id="nomeConsulta" name="nomeConsulta">
		<input type="submit" value="Enviar">
	</form>

	<table style="text-aline:center;" style="width:100%;" border="1">
		<tr >
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
			<th>CNPJ</th>
			<th>Editar</th>
			<th>Excluir</th>
			<th>Novo</th>

		</tr>
		
		

		<c:forEach items="${fornecedores }" var="fornecedor">
			<tr>
				<td><c:out value="${fornecedor.id }"></c:out></td>

				<td><c:out value="${fornecedor.nome }"></c:out></td>
				<td><c:out value="${fornecedor.email }"></c:out></td>
				<td><c:out value="${fornecedor.celular }"></c:out></td>
				<td><c:out value="${fornecedor.telefone }"></c:out></td>
				<td><c:out value="${fornecedor.cep }"></c:out></td>
				<td><c:out value="${fornecedor.endereco }"></c:out></td>
				<td><c:out value="${fornecedor.numero }"></c:out></td>				
   			   <td><c:out value="${fornecedor.bairro }"></c:out></td>
				<td><c:out value="${fornecedor.cidade }"></c:out></td>
				<td><c:out value="${fornecedor.complemento }"></c:out></td>
				<td><c:out value="${fornecedor.uf }"></c:out></td>
				<td><c:out value="${fornecedor.cnpj }"></c:out></td>
				<td><a
					href="salvarFornecedor?acao=editarFornecedor&idFornecedor=${fornecedor.id }">Editar</a></td>
				<td><a
					href="salvarFornecedor?acao=excluirFornecedor&idFornecedor=${fornecedor.id }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>