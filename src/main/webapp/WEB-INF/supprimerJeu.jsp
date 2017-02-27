<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="steam.model.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
%>
<!DO
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscription</title>

    <link href="../style/bootstrap.min.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<h1>Supprimer un jeu</h1>

<div class="divGeneral">
    <form class="form-horizontal" method=post action="/SupprimerJeu">
        <fieldset>

            <input autocomplete="off" type=text name="gameName" list=games >
            <datalist id=games >
                <%
                    for(Game game : games){
                %>
                <option value="<%= game.getName() %>"> <%= game.getName() %> </option>
                <%}
                %>
            </datalist>

            <input type="submit" value="Supprimer" />
        </fieldset>
    </form>
</div>

</body>
</html>