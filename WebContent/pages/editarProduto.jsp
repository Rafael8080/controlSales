<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="br.com.controlSales.model.*" %>
	<%@page import="br.com.controlSales.model.Fornecedor "%>
<%@page import="br.com.controlSales.dao.FornecedorDAO"%>
<%@page import="br.com.controlSales.dao.ProdutoDAO"%>

<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Produtos</title>
</head>
<body>

	<h1>Editar Produto</h1>
	<a href="salvarProduto?acao=listarProduto">Dados Produtos</a>
	
	<form action="salvarProduto?acao=editarProduto&idProduto=${produto.id }" method="POST" style="margin-top:25px;">
		<table>
			<tr>
				<td>Código:</td>
				<td><input readonly type="text" name="id" id="id" value="${produto.id }"></td>
			</tr>
			<tr>
				<td>Descricao:</td>
				<td><input type="text" name="descricao" id="descricao" value="${produto.descricao }"></td>
			</tr>
			<tr>
				<td>Preço:</td>
				<td><input type="text" name="preco" id="preco" value="${produto.preco }"></td>
			</tr>	
				<td>Qtd Estoque:</td>
				<td><input type="text" name="qtd_estoque" id="qtd_estoque" value="${produto.qtd_estoque }"></td>
				<tr>
				<%
				List<Fornecedor> listaFornecedores = new FornecedorDAO().listarFornecedores(); 
				
				ProdutoDAO p = new ProdutoDAO();			
				Produto obj = (Produto) request.getAttribute("produto");
				int idFornecedorAtual = p.consultarProdutoId(Integer.toString(obj.getFornecedorId())).getFornecedorId();
				//request.setAttribute("idFornecedorAtual", idFornecedorAtual);
				
				%>
				<td>Fornecedor:</td>
				<td><select id="fornecedor" name="fornecedor">
						<c:forEach var="fornecedor" items="<%=listaFornecedores %>">						
							<option value="${fornecedor.id}"
								<c:if test="${fornecedor.id}">selected</c:if>
							><c:out value="${fornecedor.nome }"></c:out></option>
						</c:forEach>
				</select></td>
				</tr>
			<tr>
				<td>
					<input type="submit" value="Enviar">
				</td>
			</tr>
				
			
		</table>
	</form>
</body>
</html>