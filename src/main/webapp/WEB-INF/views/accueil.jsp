<%-- 
    Document   : accueil
    Created on : 30 avr. 2020, 16:39:28
    Author     : ulyss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenue, ${contact}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/">Se déconnecter</a></li>
            <br><br>
            <li><a href="${pageContext.request.contextPath}/mvc/client">Modifier mes données personnelles</a></li>

            <li><a href="${pageContext.request.contextPath}/mvc/categorieProduits">Créer une nouvelle commande</a></li>
            <li><a href="${pageContext.request.contextPath}/mvc/commandes">Mes anciennes commandes</a></li>
        </ul>
    </body>
</html>
