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
	<a href="salvarCliente?acao=listarClientes">Dados Pessoais</a>
	
	<form action="consultarNome?acao=pesquisarFuncionario" method="post" style="margin-bottom: 50px; margin-top: 25px;">
		<input type="text" id="nomeConsulta" name="nomeConsulta">
		<input type="submit" value="Enviar">
	</form>
	
	<form action="salvarCliente?acao=editarClient&idCliente=${cliente.id }" method="POST" style="margin-top:25px;">
		<table>
			<tr>
				<td>C�digo:</td>
				<td><input readonly type="text" name="id" id="id" value="${cliente.id }"></td>

				<td>Nome:</td>
				<td><input type="text" name="nome" id="nome" value="${cliente.nome }"></td>

				<td>E-mail:</td>
				<td><input type="text" name="email" id="email" value="${cliente.email }"></td>
			</tr>

			<tr>
				<td>Celuluar:</td>
				<td><input type="text" name="celular" id="celular" value="${cliente.celular }"></td>
				
				<td>Telefone Fixo:</td>
				<td><input type="text" name="telefone" id="telefone" value="${cliente.telefone }"></td>
				
				<td>CEP:</td>
				<td><input type="text" name="cep" id="cep" value="${cliente.cep }"></td>
			</tr>
			
			<tr>
				<td>Endere�o:</td>
				<td><input type="text" name="endereco" id="endereco" value="${cliente.endereco }"></td>
				
				<td>Numero:</td>
				<td><input type="text" name="numero" id="numero" value="${cliente.numero }"></td>
				
				<td>Bairro:</td>
				<td><input type="text" name="bairro" id="bairro" value="${cliente.bairro }"></td>
			</tr>
			
			<tr>
				<td>Cidade:</td>
				<td><input type="text" name="cidade" id="cidade" value="${cliente.cidade }"></td>
				
				<td>Complemento:</td>
				<td><input type="text" name="complemento" id="complemento" value="${cliente.complemento }"></td>
				
				<td>UF:</td>
				<td>
					<select id="uf" name="uf" >
						<option value="SP" 
						<%
						
						if(request.getAttribute("cliente") != null){
							Cliente cli = (Cliente) request.getAttribute("cliente");
							if(cli.getUf().equalsIgnoreCase("SP")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						>SP</option>
						<option value="RJ"
						
						<%
						
						if(request.getAttribute("cliente") != null){
							Cliente cli = (Cliente) request.getAttribute("cliente");
							if(cli.getUf().equalsIgnoreCase("RJ")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>RJ</option>
						<option value="BA"
						
						<%
						
						if(request.getAttribute("cliente") != null){
							Cliente cli = (Cliente) request.getAttribute("cliente");
							if(cli.getUf().equalsIgnoreCase("BA")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>BA</option>
						<option value="PI"
						
						<%
						
						if(request.getAttribute("cliente") != null){
							Cliente cli = (Cliente) request.getAttribute("cliente");
							if(cli.getUf().equalsIgnoreCase("PI")){
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
				<td>RG:</td>
				<td><input type="text" name="rg" id="rg" value="${cliente.rg }"></td>
				
				<td>CPF:</td>
				<td><input type="text" name="cpf" id="cpf" value="${cliente.cpf }"></td>
				
				<td>
					<input type="submit" value="Atualizar">
				</td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>