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
	<h1>Dados Produtos</h1>
	<a href="cadastroProduto.jsp">Cadastro Produtos</a>
	<table style="text-aline:center; margin-top:25px;" style="width:100%;" border="1">
		<tr >
			<th>Código</th>
			<th>Descricao</th>
			<th>Qtd. Estoque</th>
			<th>Preço</th>
			<th>Fornecedor</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
	
		<c:forEach items="${produtos }" var="produto">
			<tr>
				<td><c:out value="${produto.id }"></c:out></td>
				<td><c:out value="${produto.descricao }"></c:out></td>
				<td><c:out value="${produto.qtd_estoque }"></c:out></td>
				<td><c:out value="${produto.preco }"></c:out></td>
				<td><c:out value="${produto.fornecedor.nome }"></c:out></td>

				<td><a
					href="salvarProduto?acao=editarProduto&idProduto=${produto.id }">Editar</a></td>
				<td><a
					href="salvarProduto?acao=excluirProduto&idProduto=${produto.id }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>