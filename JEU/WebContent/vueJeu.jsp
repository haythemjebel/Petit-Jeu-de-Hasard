<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>JEU HASARD</title>
</head>
<body>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<h1>Jeu hazard</h1>
		<p>Le principe est simple vous devez entrer un nombre à vos choix et repeter à chaque fois le nombre est fausse</p>
		<form action="Controle.do" method="post">
			Deviner : <input class="form-control" type="text" name="nombre" value="${model.nombre}">
			<input type="submit" class="btn btn-primary" value="Jouer" name="action">
			<input type="submit" class="btn btn-primary" value="Rejouer" name="action">

		</form>
		<table>
			<c:forEach items="${model.historique}" var="rep">
				<tr>
					<th>${rep}</th>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>