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
	<a href="cadastroFuncionario.jsp">Cadastro Funcionarios</a>
	
	<form action="consultarNome?acao=pesquisarFuncionario" method="post" style="margin-bottom: 50px; margin-top: 25px;">
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
			<th>CPF</th>
			<th>RG</th>
			<th>cargo</th>
			<th>senha</th>
			<th>Nivel de acesso</th>
			<th>Editar</th>
			<th>Excluir</th>
			

		</tr>
		
		

		<c:forEach items="${funcionarios }" var="funcionario">
			<tr>
				<td><c:out value="${funcionario.id }"></c:out></td>

				<td><c:out value="${funcionario.nome }"></c:out></td>
				<td><c:out value="${funcionario.email }"></c:out></td>
				<td><c:out value="${funcionario.celular }"></c:out></td>
				<td><c:out value="${funcionario.telefone }"></c:out></td>
				<td><c:out value="${funcionario.cep }"></c:out></td>
				<td><c:out value="${funcionario.endereco }"></c:out></td>
				<td><c:out value="${funcionario.numero }"></c:out></td>				
   			   <td><c:out value="${funcionario.bairro }"></c:out></td>
				<td><c:out value="${funcionario.cidade }"></c:out></td>
				<td><c:out value="${funcionario.complemento }"></c:out></td>
				<td><c:out value="${funcionario.uf }"></c:out></td>
				<td><c:out value="${funcionario.cpf }"></c:out></td>
				<td><c:out value="${funcionario.rg }"></c:out></td>
				
				<td><c:out value="${funcionario.cargo }"></c:out></td>
				<td><c:out value="${funcionario.senha }"></c:out></td>
				<td><c:out value="${funcionario.nivelAcesso }"></c:out></td>
				
				<td><a
					href="salvarFuncionario?acao=editarFuncionario&idFuncionario=${funcionario.id }">Editar</a></td>
				<td><a
					href="salvarFuncionario?acao=excluirFuncionario&idFuncionario=${funcionario.id }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>