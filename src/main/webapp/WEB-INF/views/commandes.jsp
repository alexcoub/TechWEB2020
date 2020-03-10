<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>Commandes pour le client ${client.societe}</title>
</head>

<body>
	<h1>Commandes pour le client ${client.societe}</h1>
	<table border='1'>
		<tr><th>Numéro</th><th>Saisie le</th><th>nb. lignes</th></tr>
		<%-- Pour chaque commande, une ligne dans la table HTML --%>
		<c:forEach var="commande" items="${client.commandeCollection}">
			<tr>
				<td>${commande.numero}</td>
				<td>${commande.saisieLe}</td>
				<td>${commande.ligneCollection.size()}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="${pageContext.request.contextPath}/">Retour au menu</a>
	<hr>
	<h3>Code source</h3>
	<ul>
		<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/controller/CategorieController.java"  target="_blank">Le contrôleur</a></li>
		<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/webapp/WEB-INF/views/showAllCategories.jsp"  target="_blank">La vue</a></li>
	</ul>
</body>

</html>