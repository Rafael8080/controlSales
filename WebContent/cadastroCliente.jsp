<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Cadastro de clientes</h1>
	<form action="salvarCliente" method="POST">
		<table>
			<tr>
				<td>Código:</td>
				<td><input type="text" name="id" id="id"></td>

				<td>Nome:</td>
				<td><input type="text" name="nome" id="nome"></td>

				<td>E-mail:</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>

			<tr>
				<td>Celuluar:</td>
				<td><input type="text" name="celular" id="celular"></td>
				
				<td>Telefone Fixo:</td>
				<td><input type="text" name="telefone" id="telefone"></td>
				
				<td>CEP:</td>
				<td><input type="text" name="cep" id="cep"></td>
			</tr>
			
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" id="endereco"></td>
				
				<td>Numero:</td>
				<td><input type="text" name="numero" id="numero"></td>
				
				<td>Bairro:</td>
				<td><input type="text" name="bairro" id="bairro"></td>
			</tr>
			
			<tr>
				<td>Cidade:</td>
				<td><input type="text" name="cidade" id="cidade"></td>
				
				<td>Complemento:</td>
				<td><input type="text" name="complemento" id="complemento"></td>
				
				<td>UF:</td>
				<td>
					<select id="uf" name="uf">
						<option value="SP">SP</option>
						<option value="RJ">RJ</option>
						<option value="BA">BA</option>
						<option value="PI">PI</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>RG:</td>
				<td><input type="text" name="rg" id="rg"></td>
				
				<td>CPF:</td>
				<td><input type="text" name="cpf" id="cpf"></td>
				
				<td>
					<input type="submit" value="salvar">
				</td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>