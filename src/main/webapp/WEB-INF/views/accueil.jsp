<%-- 
    Document   : accueil
    Created on : 30 avr. 2020, 16:39:28
    Author     : ulyss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Les Comptoirs (MVC / AJAX)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<ul>
			<li>Exemples MVC
				<ul>
					<li><a href="${pageContext.request.contextPath}/mvc/categories">Toutes les catégories (MVC)</a></li>
					<li><a href="${pageContext.request.contextPath}/mvc/categorieProduits">Produits par catégories (MVC)</a></li>
					<li><a href="${pageContext.request.contextPath}/mvc/produits">Liste des produits (MVC)</a></li>					
					<li><a href="${pageContext.request.contextPath}/mvc/produits/create">Edition des produits (MVC)</a></li>					
					<li><a href="${pageContext.request.contextPath}/mvc/categorieEditor">Edition des catégories (validation par formulaire)</a></li>
				</ul>
			</li>
			<li>Exemples AJAX
				<ul>
					<li><a href="${pageContext.request.contextPath}/AjaxWithXHR_1.html">Ajax avec l'objet XmlHttpRequest</a></li>
					<li><a href="${pageContext.request.contextPath}/AjaxWithXHR.html">Idem, avec une requête longue pour voir l'aspect asynchrone</a></li>
					<li><a href="${pageContext.request.contextPath}/AjaxWithJQuery.html">Idem, avec JQuery</a></li>					
					<li> Exemples AJAX avec la base de données
						<ul>
							<li> Les services web utilisés
								<ul>
									<li><a href="${pageContext.request.contextPath}/mvc/service/allCategories" target="_blank">Toutes les catégories en XML</a></li>
									<li><a href="${pageContext.request.contextPath}/mvc/service/unitesVendues/categories" target="_blank">Unites vendues par catégorie (XML)</a></li>
									<li><a href="${pageContext.request.contextPath}/mvc/service/unitesVendues/produits?code=1" target="_blank">Produits vendus pour une catégorie (JSON)</a></li>
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath}/contentNegociation.html">client JQuery avec négociation de contenu</a></li>
							<li><a href="${pageContext.request.contextPath}/AjaxJQueryMustache.html">client JQuery / Moteur de template Mustache (données en XML)</a></li>
							<li><a href="https://jsfiddle.net/bastide/0pd5r9t7/35/" target="_blank">Exemple avec le moteur de template Mustache</a></li>
							<li><a href="${pageContext.request.contextPath}/AjaxJQueryDataTable.html">client JQuery / Google Table (données en XML)</a></li>
							<li><a href="${pageContext.request.contextPath}/googlePieChart.html">client JQuery / Google Piechart (données en JSON)</a></li>
							<li><a href="${pageContext.request.contextPath}/mvc/statsProduitsPourCategorie">Ventes pour une catégorie (MVC + AJAX)</a></li>
							<li><a href="${pageContext.request.contextPath}/mvc/listeCommandes">Commandes filtrées par date (MVC + AJAX)</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</body>
</html>
