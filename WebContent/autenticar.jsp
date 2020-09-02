<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticar</title>
</head>
<body>
	<h1>Autenticação de usuarios</h1>

	<form action="ServletAutenticar" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email"></td>
				<td><input type="hidden" readonly name="url"
					value="<%= request.getParameter("url")%>"></td>
			</tr>

			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" id="senha"></td>
			</tr>
			<tr>
			
			<td><input type="submit" value="Enviar"></td></tr>
		</table>
	</form>

</body>
</html>