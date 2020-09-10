<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.controlSales.model.Fornecedor "%>
<%@page import="br.com.controlSales.dao.FornecedorDAO"%>

<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

</head>
<body>
	<a href="/controlSales/index.jsp">Inicio</a>
	<h1>Cadastro de produtos</h1>
	<a href="salvarProduto?acao=listarProduto">Dados produtos</a>
	<form action="salvarProduto?acao=salvarProduto" method="POST"
		style="margin-top: 25px;">
		<table>
			<tr>
				<td>Código:</td>
				<td><input readonly type="text" name="id" id="id"></td>
			</tr>
			<td>Descrição:</td>
			<td><input type="text" name="descricao" id="descricao"></td>
			<tr>
				<td>Preço:</td>
				<td><input type="text" name="preco" id="preco"></td>

			</tr>
			<tr>
				<td>Qtd.Estoque:</td>
				<td><input type="text" name="qtd_estoque" id="qtd_estoque"></td>
			</tr>



			<%
				List<Fornecedor> listaFornecedores = new FornecedorDAO().listarFornecedores();
			%>
			<tr>
			<td>Fornecedor:</td>
			<td><select id="fornecedor" name="fornecedor">
					<c:forEach items="<%= listaFornecedores%>"
						var="fornecedor">
						<option value="${ fornecedor.id}">
							<c:out value="${fornecedor.nome}"></c:out></option>
					</c:forEach>
			</select></td>

			</tr>
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
			
		</table>
	</form>
	<script type="text/javascript">
		
	</script>
</body>
</html>