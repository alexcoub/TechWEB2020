<%-- 
    Document   : login
    Created on : 2 mai 2020, 16:02:43
    Author     : Alex
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <form method="POST">
            <label>Votre pseudo : <input name="userName" required></label>
            <label>Mot de passe : <input name="userMdp" required></label>                        
            <input value="Connexion" type="SUBMIT">
        </form>
    </body>
</html>
