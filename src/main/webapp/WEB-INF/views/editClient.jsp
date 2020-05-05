<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Modification de vos paramètres</title>
    </head>
    <body>
        <h1>Modification de vos paramètres</h1>
        <form method='POST'> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
            Fonction : <input name="fonction" value="${mvc.encoders.html(clients.fonction)}"><br>
            Société : <input name="societe" value="${mvc.encoders.html(clients.societe)}"><br>

            Adresse : <input name="adresse" value="${mvc.encoders.html(clients.adresse)}"><br>
            Ville : <input name="ville" value="${mvc.encoders.html(clients.ville)}"><br>
            Région : <input name="region" value="${mvc.encoders.html(clients.region)}"><br>
            Code Postal : <input name="codePostal" value="${mvc.encoders.html(clients.codePostal)}"><br>
            Pays : <input name="pays" value="${mvc.encoders.html(clients.pays)}"><br>

            Contact : <input name="contact" value="${mvc.encoders.html(clients.contact)}"><br>           
            Téléphone : <input name="telephone" value="${mvc.encoders.html(clients.telephone)}"><br>
            Fax : <input name="fax" value="${mvc.encoders.html(clients.fax)}"><br>
            
            <input type="submit" value="Validation">
        </form>

            <br><br><br>
<table border='1'>
                <tr><th>Société</th><th>Fonction</th></tr>
                        <%-- Pour chaque categorie, une ligne dans la table HTML --%>

                <tr>
                    
                    <td>${mvc.encoders.html(clients.societe)}</td>
                    <td>${mvc.encoders.html(clients.fonction)}</td>
                    
                </tr>
            
            </table>
                <br><br>
                

            <table border='1'>
                <tr><th>Contact</th><th>Téléphone</th><th>Fax</th></tr>
                        <%-- Pour chaque categorie, une ligne dans la table HTML --%>

                <tr>
                    <td>${mvc.encoders.html(clients.contact)}</td>
                    <td>${mvc.encoders.html(clients.telephone)}</td>
                    <td>${mvc.encoders.html(clients.fax)}</td>
                </tr>
            </table>
                <br><br>
                
                 <table border='1'>
                <tr><th>Adresse</th><th>Ville</th><th>Région</th><th>Code Postal</th><th>Pays</th></tr>
                        <%-- Pour chaque categorie, une ligne dans la table HTML --%>

                <tr>
                    <td>${mvc.encoders.html(clients.adresse)}</td>
                    <td>${mvc.encoders.html(clients.ville)}</td>
                    <td>${mvc.encoders.html(clients.region)}</td>
                    <td>${mvc.encoders.html(clients.codePostal)}</td>
                    <td>${mvc.encoders.html(clients.pays)}</td>
                </tr>
            </table>
            
         <a href="${pageContext.request.contextPath}/mvc/commandes">Mes commandes</a>
         <a href="${pageContext.request.contextPath}/mvc/categorieProduits">Produits</a><br>
         
           <a href="${pageContext.request.contextPath}/mvc/validationPanier">panier</a>


    </body>
</html>
