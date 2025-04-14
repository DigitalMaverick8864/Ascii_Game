<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
<meta charset="UTF-8">
<title>Welcome Players</title>
<link rel="stylesheet" type="text/css" href="PreparazioneU1.css">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  background-image: url("https://cdnb.artstation.com/p/assets/images/images/053/131/961/original/sofia-ritter-city-scene-gif.gif?1661482695");
  background-color: #7a2efa;
  background-size: 1150px;
  font-family: "Audiowide", sans-serif;
  color: #cae2fb;
  text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px fuchsia;
}

.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
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

    <center><h1>Welcome players!</h1>
	<form action="rFile" method="post" enctype="multipart/form-data">
	
	<p>Lunghezza Parole: ${randomico1}</p>
	<p>Numero Parole: ${randomico2}</p><br>
	
	    Player 1:<br><input type="text" name="player1"><br><br>
	    Seleziona un file:<br><input type="file" name="file1" accept=".txt"><br><br><br>
		
		Player 2:<br><input type="text" name="player2"><br><br>
		Seleziona un file:<br><input type="file" name="file2" accept=".txt"><br><br><br>
		
	

		<br><button class="button button1" type="submit"><b>Fight !</b></button>
	</form></center>

</body>
</html>