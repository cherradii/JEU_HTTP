<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jeu Hazard</title>
</head>
<body>
 <h1>Jeu Hazard</h1>
	<form action="controleur" method="post">
		Devinez:<input type="text" name="nombre" value="${ model.nombre }"> 
		<input type=submit value="Jouer" name="action">
		<input type="submit" value="Relancer" name="action">
	</form>

	<table>
		<c:forEach items="${ model.historique }" var="rep">
			<tr>
				<td>${ rep }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>