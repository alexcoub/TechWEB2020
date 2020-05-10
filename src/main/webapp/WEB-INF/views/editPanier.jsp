<%-- 
    Document   : editPanier
    Created on : 5 mai 2020, 18:37:13
    Author     : Alex
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier</title>
    </head>
    <body>
        <h1>Revoire mon Panier</h1>

        <table border='1'>
            <tr><th>Produits</th><th>Catégorie</th><th>Quantité</th></tr>
                    <%-- Pour chaque categorie, une ligne dans la table HTML --%>

            <tr>
                <c:forEach var="produit" items="${user.panier.listeProd}">
                <tr>
                    <td>${produit.produitSelectionne.nom}</td>
                    <td>${produit.produitSelectionne.categorie.libelle}</td>
                    <td>${produit.qte}</td>
                    <td>
                        <form method='POST'>
                            <input type="number" name="quantite" min="0" max="${produit.produitSelectionne.unitesEnStock}" required>
                            <input type="submit" value="valider" onclick="">
                            <input name="reference" type="number" value="${produit.produitSelectionne.reference}" hidden >
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <a href="${pageContext.request.contextPath}/mvc/validationPanier">Valider mon Panier</a>
        <br>
        <a href="${pageContext.request.contextPath}/mvc/categorieProduits">Continuer ma commande</a>

    </body>
</html>
