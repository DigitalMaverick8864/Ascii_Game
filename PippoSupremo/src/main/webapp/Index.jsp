<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
<meta charset="ISO-8859-1">
<title>ASCII GAME</title>
<link rel="stylesheet" type="text/css" href="index1.css">
<h1 style="text-align:center"><b>ASCII GAME</b></h1>
<style> 
  div {
  border: 1px solid;
  padding: 10px;
  background-color: #011a64;
  box-shadow: 5px 10px #00BFFF;
  font-family: "Audiowide", sans-serif;
  color:white;
}
.button {
  background-color: #6f49d2; 
  border: none;
  color: #0eeffa;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  font-family: "Audiowide", sans-serif;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
.button1 {
  background-color: #0eeffa; 
  color: black; 
  border: 2px solid #6f49d2;
}

.button1:hover {
  background-color: #6f49d2;
  color: white;
}
</style>
</head>
<body>
<body style="background-color:black;">
<h2 style="text-align:left">Regole del gioco:</h2>
<div>
  <p>Il gioco calcolerà il punteggio ASCII di ogni parola inserita. <br>
Quindi ogni file genererà un punteggio massimo per ciascun
giocatore.</p></div><br><br>

	<form action="Random" method="post" enctype="multipart/form-data">
		<center><button class="button button1" input type="submit" value="Start"><b>START</b></input>
		</button></center>
	
	</form>
	
	<form action="Tabella.jsp" method="get">
	<center><button class="button button1" input type="submit" value="Start"><b>Results</b></input>
		</button></center>
</body>
</html>