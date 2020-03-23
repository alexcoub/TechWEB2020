<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Commandes filtrées par date</title>
        <!-- On charge la bibliothèque JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <!-- On charge le moteur de template mustache https://mustache.github.io/ -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>		

        <script>
            $(document).ready(// Exécuté à la fin du chargement de la page
                    doRequest
            );

            // On reçoit un tableau de nuéros de commande
            function showResult(tableauCommandes) {
               // Le code source du template est dans la page
                var template = $('#commandesTemplate').html();
                // On combine le template avec le résultat de la requête
                var processedTemplate = Mustache.to_html(template, {commandes: tableauCommandes});
                // On affiche le résultat dans la page
                $('#tableCommandes').html(processedTemplate);
            }

            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                $("#tableCommandes").html("Erreur: " + status + " : " + message);
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
        
        <div id="tableCommandes">...Le résultat va apparaître ici...</div>
        <hr>	
        
        <!-- Le template qui sert à formatter la liste des numéros de commande -->
        <script id="commandesTemplate" type="text/template">
            <div>
                    Numéros :
                    {{! Pour chaque numéro de commande }}
                    {{#commandes}} {{.}}, {{/commandes}}
                    {{! le point représente l élément courant du tableau}}
            </div>
        </script>	            
        <a href="${pageContext.request.contextPath}/">Retour au menu</a>
        <hr>
        <a href="service/commandesFiltrees?minDate=1994-08-04&maxDate=1995-08-04"  target="_blank">Le service utilisé.</a>
        <h3>Code source</h3>
        <ul>
            <li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/controller/CategorieController.java"  target="_blank">Le contrôleur</a></li>
            <li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/webapp/WEB-INF/views/showAllCategories.jsp"  target="_blank">La vue</a></li>
        </ul>
</body>

</html>