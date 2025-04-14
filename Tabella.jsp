<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="it.cefi.models.Tabella"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
<meta charset="UTF-8">
<title>Winner table</title>
<link rel="stylesheet" type="text/css" href="Tab.css">
<style>
body {
  margin: 0;
  background-image: url("https://i.pinimg.com/originals/df/66/1b/df661b213ee05573007418bcd5cca532.gif");
  background-color: #7a2efa;
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  font-family: "Audiowide", sans-serif;
  text-align: center;
  color: #cae2fb;
  text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px fuchsia;
}

.image {
    position: center;
    top: 50%;
    left: 50%;
    width: 120px;
    height: 120px;
    margin: 30px 0 0 30px;
    -webkit-animation: spin 4s linear infinite;
    -moz-animation: spin 4s linear infinite;
    animation: spin 4s linear infinite;
}
.tb { 
    border-collapse: collapse;   
    margin-left: auto;
    margin-right: auto;
}
.tb th, .tb td { 
    padding: 5px; 
    border: solid 1px #777; 
}
.tb th { 
    background-color: lightblue; 
}
@-moz-keyframes spin { 
    100% { -moz-transform: rotate(360deg); } 
}
@-webkit-keyframes spin { 
    100% { -webkit-transform: rotate(360deg); } 
}
@keyframes spin { 
    100% { 
        -webkit-transform: rotate(360deg); 
        transform: rotate(360deg); 
    }
}
</style>
</head>
<body>
    <center><h1>STATISTICS</h1></center>
    <table class="tb" style="width:300px;">
        <tr>
            <th>ID</th>
            <th>Nome Utente</th>
            <th>Numero Parole</th>
            <th>Lunghezza Parole in Caratteri</th>
            <th>Data Vittoria</th>
            <th>Punteggio</th>
        </tr>
        <%
        List<Tabella> table = (List<Tabella>) request.getAttribute("winasciigame");
        if (table != null && !table.isEmpty()){
            for (Tabella tabella : table) {
        %>
        <tr>
            <td><%=tabella.getIdplayer()%></td>
            <td><%=tabella.getNomeutente()%></td>
            <td><%=tabella.getNumeroparole()%></td>
            <td><%=tabella.getLunghezzaparolecaratteri()%></td>
            <td><%=tabella.getDatavittoria()%></td>
            <td><%=tabella.getPunteggio()%></td>
        </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="6">Nessun Risultato disponibile</td>
            </tr>
        <%
        }
        %>	
    </table><br><br>

    <form action="visualizzaTabella" method="get">
        <center>
            <button class="button button1" type="submit">
                <b>VISUALIZZA RISULTATI</b>
            </button>
        </center>
    </form><br><br>
    
    <center>
        <form action="Index.jsp">
            <button class="button button1" type="submit"><b>GO BACK</b></button>
        </form>
    </center><br>
    
    <img class="image" src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/089cf2e6-1a07-42af-bcf6-e3528d46e5d4/dbegn0d-b97f551a-7ad0-4b82-8705-c53cf5fa9090.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzA4OWNmMmU2LTFhMDctNDJhZi1iY2Y2LWUzNTI4ZDQ2ZTVkNFwvZGJlZ24wZC1iOTdmNTUxYS03YWQwLTRiODItODcwNS1jNTNjZjVmYTkwOTAuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.JV3HOd3iXgBNtmlEBIdnk-L8JIoxjQUXvJtKyl2saJ8" alt="" width="120" height="120">
</body>
</html>