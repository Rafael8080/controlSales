<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="br.com.controlSales.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
</head>
<body>

	<h1>Editar Cliente</h1>
	<a href="salvarFornecedor?acao=listarFornecedores">Dados Fornecedores</a>
	
	<form action="consultarNome?acao=pesquisarFornecedor" method="post" style="margin-bottom: 50px; margin-top: 25px;">
		<input type="text" id="nomeConsulta" name="nomeConsulta">
		<input type="submit" value="Enviar">
	</form>
	
	<form action="salvarFornecedor?acao=editarFornecedor&idFornecedor=${fornecedor.id }" method="POST" style="margin-top:25px;">
		<table>
			<tr>
				<td>Código:</td>
				<td><input readonly type="text" name="id" id="id" value="${fornecedor.id }"></td>

				<td>Nome:</td>
				<td><input type="text" name="nome" id="nome" value="${fornecedor.nome }"></td>

				<td>E-mail:</td>
				<td><input type="text" name="email" id="email" value="${fornecedor.email }"></td>
			</tr>

			<tr>
				<td>Celuluar:</td>
				<td><input type="text" name="celular" id="celular" value="${fornecedor.celular }"></td>
				
				<td>Telefone Fixo:</td>
				<td><input type="text" name="telefone" id="telefone" value="${fornecedor.telefone }"></td>
				
				<td>CEP:</td>
				<td><input type="text" name="cep" id="cep" value="${fornecedor.cep }"></td>
			</tr>
			
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" id="endereco" value="${fornecedor.endereco }"></td>
				
				<td>Numero:</td>
				<td><input type="text" name="numero" id="numero" value="${fornecedor.numero }"></td>
				
				<td>Bairro:</td>
				<td><input type="text" name="bairro" id="bairro" value="${fornecedor.bairro }"></td>
			</tr>
			
			<tr>
				<td>Cidade:</td>
				<td><input type="text" name="cidade" id="cidade" value="${fornecedor.cidade }"></td>
				
				<td>Complemento:</td>
				<td><input type="text" name="complemento" id="complemento" value="${fornecedor.complemento }"></td>
				
				<td>UF:</td>
				<td>
					<select id="uf" name="uf" >
						<option value="SP" 
						<%
						
						if(request.getAttribute("fornecedor") != null){
							Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor");
							if(fornecedor.getUf().equalsIgnoreCase("SP")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						>SP</option>
						<option value="RJ"
						
						<%
						
						if(request.getAttribute("fornecedor") != null){
							Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor");
							if(fornecedor.getUf().equalsIgnoreCase("RJ")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>RJ</option>
						<option value="BA"
						
						<%
						
						if(request.getAttribute("fornecedor") != null){
							Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor");
							if(fornecedor.getUf().equalsIgnoreCase("BA")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>BA</option>
						<option value="PI"
						
						<%
						
						if(request.getAttribute("fornecedor") != null){
							Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor");
							if(fornecedor.getUf().equalsIgnoreCase("PI")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>PI</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>CNPJ:</td>
				<td><input type="text" name="cnpj" id="cnpj" value="${fornecedor.cnpj }"></td>
				
				<td>
					<input type="submit" value="Atualizar">
				</td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>