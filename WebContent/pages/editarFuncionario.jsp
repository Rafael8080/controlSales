<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="br.com.controlSales.model.Funcionario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
</head>
<body>

	<h1>Editar Cliente</h1>
	<a href="salvarFuncionario?acao=listarFuncionarios">Dados Pessoais</a>
	<form action="salvarFuncionario?acao=editarFuncionario&idFuncionario=${funcionario.id }" method="POST" style="margin-top:25px;">
		<table>
			<tr>
				<td>Código:</td>
				<td><input readonly type="text" name="id" id="id" value="${funcionario.id }"></td>

				<td>Nome:</td>
				<td><input type="text" name="nome" id="nome" value="${funcionario.nome }"></td>

				<td>E-mail:</td>
				<td><input type="text" name="email" id="email" value="${funcionario.email }"></td>
			</tr>

			<tr>
				<td>Celuluar:</td>
				<td><input type="text" name="celular" id="celular" value="${funcionario.celular }"></td>
				
				<td>Telefone Fixo:</td>
				<td><input type="text" name="telefone" id="telefone" value="${funcionario.telefone }"></td>
				
				<td>CEP:</td>
				<td><input type="text" name="cep" id="cep" value="${funcionario.cep }"></td>
			</tr>
			
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" id="endereco" value="${funcionario.endereco }"></td>
				
				<td>Numero:</td>
				<td><input type="text" name="numero" id="numero" value="${funcionario.numero }"></td>
				
				<td>Bairro:</td>
				<td><input type="text" name="bairro" id="bairro" value="${funcionario.bairro }"></td>
			</tr>
			
			<tr>
				<td>Cidade:</td>
				<td><input type="text" name="cidade" id="cidade" value="${funcionario.cidade }"></td>
				
				<td>Complemento:</td>
				<td><input type="text" name="complemento" id="complemento" value="${funcionario.complemento }"></td>
				
				<td>UF:</td>
				<td>
					<select id="uf" name="uf" >
						<option value="SP" 
						<%
						
						if(request.getAttribute("funcionario") != null){
							Funcionario func = (Funcionario) request.getAttribute("funcionario");
							if(func.getUf().equalsIgnoreCase("SP")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						>SP</option>
						<option value="RJ"
						
						<%
						
						if(request.getAttribute("funcionario") != null){
							Funcionario func = (Funcionario) request.getAttribute("funcionario");
							if(func.getUf().equalsIgnoreCase("RJ")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>RJ</option>
						<option value="BA"
						
						<%
						
						if(request.getAttribute("funcionario") != null){
							Funcionario func = (Funcionario) request.getAttribute("funcionario");
							if(func.getUf().equalsIgnoreCase("BA")){
								out.print(" ");
								out.print("selected=\"select\"");
								out.print(" ");
							}
						}
						
						%>
						
						>BA</option>
						<option value="PI"
						
						<%
						
						if(request.getAttribute("funcionario") != null){
							Funcionario func = (Funcionario) request.getAttribute("funcionario");
							if(func.getUf().equalsIgnoreCase("PI")){
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
				<td><input type="text" name="rg" id="rg" value="${funcionario.rg }"></td>
				
				<td>CPF:</td>
				<td><input type="text" name="cpf" id="cpf" value="${funcionario.cpf }"></td>
				
				<td>Nivel de Acesso:</td>
				<td>
					<select name="nivelAcesso" id="nivelAcesso">
						<option value="usuario" 
							
							<%
								if(request.getAttribute("funcionario") != null){
									Funcionario func = (Funcionario) request.getAttribute("funcionario");
									if(func.getNivelAcesso().equalsIgnoreCase("usuario")){
									out.print(" ");
									out.print("selected=\"select\"");
									out.print(" ");
									}
								}
							%>
							
						>Usuario</option>
						
							<option value="administrador" 
							
							<%
								if(request.getAttribute("funcionario") != null){
									Funcionario func = (Funcionario) request.getAttribute("funcionario");
									
									if(func.getNivelAcesso().equalsIgnoreCase("administrador")){										
										out.print(" ");
										out.print("selected=\"select\"");
										out.print(" ");
									}
								}
							%>
							
						>Administrador</option>
					</select>
				</td>
				
				<td>
					<input type="submit" value="Atualizar">
				</td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>