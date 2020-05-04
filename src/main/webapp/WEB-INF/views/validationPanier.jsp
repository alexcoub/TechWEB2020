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
        <h1>Mon panier duoo</h1>
        <form method='POST'> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
   

            Adresse : <input type="text" name="adresse" ><br>
            Ville : <input type="text" name="ville"><br>
            Région : <input name="region" type="text"><br>
            Code Postal : <input name="codePostal" type="text"><br>
            Pays : <input name="pays" type="text"><br>

            Port : <input name="port" type="text"><br>           
            Destinataire : <input name="destinataire" type="text"><br>
            code : <input name="codeReduc" type="text" value="0" ><br>
            
            <input type="submit" value="Validation">
        </form>
        
        <table border='1'>
                <tr><th>Produits</th><th>User</th></tr>
                        <%-- Pour chaque categorie, une ligne dans la table HTML --%>

                <tr>
                    
                    <td>${mvc.encoders.html(user.mesProduits)}</td>
                    <td>${mvc.encoders.html(user.code)}</td>
                    
                </tr>
            
            </table>
    </body>
</html>
