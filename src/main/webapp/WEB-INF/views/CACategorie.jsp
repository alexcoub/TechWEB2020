<%-- 
    Document   : CAClient
    Created on : 8 mai 2020, 12:41:17
    Author     : numag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produits vendus par categorie</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current',('packages':['corechart']));
            google.charts.setOnLoadCallback(doAjax);
            function drawPieChart(result){
                var data = [['Produit','Unités vendues']];
                result.forEach(ligne=> data.push([ligne.libelle,ligne.unites]));
                var dataTable = google.vizualisation.arrayToDataTable(data);
                
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                var options = (title : "Chiffre affaire par catégorie");
                chart.draw(dataTable,options);
            }
            function doAjax(){
                $.ajax({
                    url:"servlet/unitesVendues/chifreaffaireDate",
                    data : $('#formulaireDates').serialize(),
                    dataType:"json",
                    success: drawPieChart,
                    error:showError
                });
            }    
            function showError(xhr,status,message) {
                alert("Erreur: "+status+":"+message);
            }
            
        </script>
    </head>
    <body>
        <h1>Chiffre d'affaire par catégorie d'article</h1>
            <form id="formulaireDates">
                entre : <input type=date" name="minDate" value="${minDate.htmlValue}" oncharge='doAjax()'>
                et : <input type=date" name="maxDate" value="${maxDate.htmlValue}" oncharge='doAjax()'>
            </form>    
            <div id='piechart' style="width:1000px;height:100px"></div>
        <br>
        <a href="../admin.jsp">Retour</a>
    </body>
</html>
