<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Modification de vos paramètres</title>
    </head>
    <body>
        <h1>Modification de vos paramètres</h1>
        <form method='POST'> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
            Fonction : <input name="fonction" placeholder="Veuillez renseigner votre nouvelle fonction"><br>
            Société : <input name="societe" placeholder="Veuillez renseigner votre nouvelle société"><br>

            Adresse : <input name="adresse" placeholder="Veuillez renseigner votre nouvelle adresse"><br>
            Ville : <input name="ville" placeholder="Veuillez renseigner votre nouvelle ville"><br>
            Région : <input name="region" placeholder="Veuillez renseigner votre nouvelle région"><br>
            Code Postal : <input name="codePostal" placeholder="Veuillez renseigner votre noueau code postal"><br>
            Pays : <input name="pays" placeholder="Veuillez renseigner votre nouveau pays"><br>

            Contact : <input name="contact" placeholder="Veuillez renseigner votre nouveau contact"><br>           
            Téléphone : <input name="telephone" placeholder="Veuillez renseigner votre nouveau numéro"><br>
            Fax : <input name="fax" placeholder="Veuillez renseigner votre nouvelle adresse pour le fax"><br>
            
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
            



    </body>
</html>
