<%-- 
    Document   : validationPanier
    Created on : 3 mai 2020, 18:48:08
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method='POST'> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
            Date de saisie : <input type="text" name="dateSaise" ><br>
            Date d'envoi : <input type="text" name="dateEnvoi" ><br>

            Adresse : <input type="text" name="adresse" ><br>
            Ville : <input type="text" name="ville"><br>
            Région : <input name="region" type="text"><br>
            Code Postal : <input name="codePostal" type="text"><br>
            Pays : <input name="pays" type="text"><br>

            Port : <input name="port" type="text"><br>           
            Destinataire : <input name="destinataire" type="text"><br>
            code : <input name="codeReduc" type="text"><br>
            
            <input type="submit" value="Validation">
        </form>
    </body>
</html>
