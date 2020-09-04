<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1>Cadastro de clientes</h1>
	<a href="salvarFornecedor?acao=listarFornecedores">Dados Fornecedor</a>
	<form action="salvarFornecedor?acao=salvarFornecedor" method="POST"
		style="margin-top: 25px;">
		<table>
			<tr>
				<td>Código:</td>
				<td><input readonly type="text" name="id" id="id"></td>

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
				<td><input type="text" name="cep" id="cep"
					onblur="consultaCep()"></td>
			</tr>

			<tr>
				<td>Rua:</td>
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
				<td><select id="uf" name="uf">
						<option value="SP">SP</option>
						<option value="RJ">RJ</option>
						<option value="BA">BA</option>
						<option value="PI">PI</option>
				</select></td>
			</tr>

			<tr>
				<td>CNPJ:</td>
				<td><input type="text" name="cnpj" id="cnpj"></td>

				<td><input type="submit" value="salvar"></td>
			</tr>


		</table>
	</form>
	<script type="text/javascript">
		function consultaCep() {
			var cep = $("#cep").val();

			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {
						if (!("erro" in dados)) {
							$("#endereco").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#uf").val(dados.uf);
						} //end if.
						else {
							$("#endereco").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#uf").val('');
							//CEP pesquisado não foi encontrado.
						
							alert("CEP não encontrado.");
						}

					});

		}
	</script>
</body>
</html>