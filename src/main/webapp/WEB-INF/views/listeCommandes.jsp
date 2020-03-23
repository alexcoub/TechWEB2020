<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<title>Commandes filtrées par date</title>
		<!-- On charge la bibliothèque JQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

		<script>
			// On exécute l'appel AJAX dès la fin du chargement de la page
			$(document).ready( doRequest );

			// On reçoit un tableau de numéros de commande
			function showResult(tableauCommandes) {
				var message = 'Aucune commande dans cet intervalle';
				if (tableauCommandes.length) { // On a trouvé des commandes dans l'intervalle
					message = 'Les commandes de '
						+ tableauCommandes[0] + ' à '
						+ tableauCommandes[tableauCommandes.length - 1] + ' sont dans cet intervalle ';
				}
				// On affiche le résultat dans la page
				$('#resultat').html(message);
			}

			// Fonction qui traite les erreurs de la requête
			function showError(xhr, status, message) {
				$("#resultat").html("Erreur: " + status + " : " + message);
			}

			// Fonction qui fait l'appel AJAX
			function doRequest() {
				$.ajax({
					url: "service/commandesFiltrees",
					// Les données saisies dans le formlaire
					data: $('#formulaireDates').serialize(),
					dataType: "json",
					success: showResult,
					error: showError
				});
			}
		</script>     
	</head>

	<body>
		<h1>Lister les commandes</h1>

		<form id="formulaireDates">
			entre : <input type="date" name="minDate" value="${minDate.htmlValue}"  onchange='doRequest()'>
			et :    <input type="date" name="maxDate" value="${maxDate.htmlValue}"  onchange='doRequest()'>
		</form>

		<div id="resultat">...Le résultat va apparaître ici...</div>
		<hr>	

		<a href="${pageContext.request.contextPath}/">Retour au menu</a>
		<hr>
		<a href="service/commandesFiltrees?minDate=1994-08-04&maxDate=1995-08-04"  target="_blank">Le service utilisé par l'appel AJAX</a>
		<h3>Code source</h3>
		<ul>
			<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/controller/ListeCommandeController.java"  target="_blank">Le contrôleur</a></li>
			<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/webapp/WEB-INF/views/listeCommandes.jsp"  target="_blank">La vue</a></li>
			<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/comptoirs/model/dao/StatisticsDao.java"  target="_blank">Le DAO avec les requêtes nécessaires</a></li>
			<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/service/StatisticsService.java"  target="_blank">Le service qui fournit les données fltrées par date</a></li>
		</ul>
	</body>

</html>