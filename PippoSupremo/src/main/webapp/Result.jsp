<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
<meta charset="ISO-8859-1">
<title>Victory</title>
<link rel="stylesheet" type="text/css" href="ResultU1.css">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  	background-image: url("https://i.pinimg.com/originals/e7/fc/a4/e7fca41687df365b3f4906a5942bb468.gif");
	background-color: #7a2efa;
	  background-size: auto;
	font-family: "Audiowide", sans-serif;
	font-family: "Audiowide", sans-serif;
	  color: #cae2fb;
	  text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px fuchsia;
}

.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: HotPink;}


</style>
</head>
<body>
	
	<h1>${vincitore}!</h1><br><br>
	<!-- MODIFICA DEL DOTTORE -->
	<!-- AGGIUNGO I TAG ERRORI -->
	<div class="flex-container">
	<div><h3>${errore1}</h3><br><br></div>
	<div><h3>${errore2}</h3><br></div>
	<!---------FINE MODIFICHE---------->
	
	<h2>PLAYER 1 SCORE : ${sommaChar1}</h2><br><br>
	
	<h2>PLAYER 2 SCORE : ${sommaChar2}</h2><br>
	
	</div>
	
	<!---------IL DOTTORE HA CAMBIATO ANCHE LA DISPOSIZIONE DEI DATI.
	          DA UNA PARTE I DATI DEL PL1 E DALL'ALTRA I DATI DEL PL2
	                                                                 ---------->
	<table>
	<tr>
	<th>Elenco parole P1</th>
	<th>Risultato Parziale P1</th>   
	<th>Elenco parole P2</th>
	<th>Risultato Parziale P2</th>
	

  </tr>
  <tr>
  	<td>${contenuto1}</td>
  	<td>${sommaParoleParz1}</td>
  	<td>${contenuto2}</td>
  	<td>${sommaParoleParz2}</td>
  </tr>
	</table><br>
	
	<center><form action="Index.jsp">
	<button class="button button1"input type="submit" value="FINISH"/><b>GO BACK</b></button>
	</form></center>
	
	

</body>
</html>