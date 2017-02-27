<%@ page import="steam.model.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Modifier un jeu</title>

    <!-- Bootstrap -->
    <link href="../style/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<h1>Ajouter un nouveau jeu</h1>

<div class="divGeneral">
    <form class="form-horizontal" method=post action="/ModifierJeu">
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

            Description rapide : <input type="text" name="shortDesc" value=""> </br>
            Description complète : <input type="text" name="fullDesc" value=""> </br>
            Date de sortie : <input type="date" name="date" value=""> </br>
            Chemin d'accès de la vidéo : <input type="date" name="video" value=""> </br>
            Prix du jeu : <input type="text" name="price" value=""> </br>
            Tag 1 : <input type="text" name="tag1" value=""> </br>
            Tag 2 : <input type="text" name="tag2" value=""> </br>
            Tag 3 : <input type="text" name="tag3" value=""> </br>
            Tag 4 : <input type="text" name="tag4" value=""> </br>

            <button class="btn btn-primary" type="submit">Modifier le jeu</button>

        </fieldset>
    </form>
</div>

</body>
</html>