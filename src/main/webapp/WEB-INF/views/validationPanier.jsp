<%-- 
    Document   : validationPanier
    Created on : 3 mai 2020, 18:48:08
    Author     : Alex
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon panier</title>
    </head>
    <body>
        <h1>Mon panier </h1>
        <form method='POST'> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>


            Adresse : <input type="text" name="adresse" required><br>
            Ville : <input type="text" name="ville" required><br>
            Région : <input name="region" type="text" required><br>
            Code Postal : <input name="codePostal" type="text" required><br>
            Pays : <input name="pays" type="text" required><br>

            Port : <input name="port" type="text" required><br>           
            Destinataire : <input name="destinataire" type="text" required><br>
            code : <input name="codeReduc" type="text" value="0" ><br>

            <input type="submit" value="Validation">
        </form>
        <br>
        <br>

        <table border='1'>
            <tr><th>Produits</th><th>Catégorie</th><th>Qte</th></tr>
                    <%-- Pour chaque categorie, une ligne dans la table HTML --%>

            <tr>
                <c:forEach var="produit" items="${user.panier.listeProd}">
                <tr>
                    <td>${produit.produitSelectionne.nom}</td>
                    <td>${produit.produitSelectionne.categorie.libelle}</td>
                    <td>${produit.qte}</td>

                </tr>
            </c:forEach>


        </table> 
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/mvc/editPanier">Modifier mon panier</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/mvc/categorieProduits">Continuer ma commande</a>

    </body>
</html>
