<%@ page import="steam.model.Game" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Game game = new Game();
    game.setName(request.getParameter("recherche"));
    game.setShortDescription("Ce jeu raconte une histoire epic pleine de rebondissements ! Incarnez Toinou, un lapin au corps qui fait rougir tous ses confrères et voyagez avec lui !");
    game.setFullDescription("Voyagez avec Toinou dans un monde sans limite ! <br> Configuration requise : <br> - Carte graphique : GTX 1080 <br> - Processeur : i7 6900K <br> - Ram : 16GO");
    game.setReleaseDate(new Date(Calendar.getInstance().getTime().getTime()));
    game.setVideo("../video/sample.mp4");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Fiche de <%=  game.getName() %></title>

    <!-- Bootstrap -->
    <link href="../style/bootstrap.min.css" rel="stylesheet">
    <link href="../style/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1 class="title">Fiche de <%=game.getName()%></h1>
<div class="container">
    <div class="row">
        <div>
            <div>
                <video autoplay controls class="video col-md-8">
                    <source src="<%=game.getVideo()%>" type="video/mp4">
                </video>
            </div>
            <div class="releasedate">
                <p>
                    Date de sortie : <%=game.getReleaseDate()%>
                </p>
            </div>
            <div class="shortdescription">
                <p>
                    <%=game.getShortDescription()%>
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div class="pager">
                60 euros <input type="submit" value="Acheter" name="buyGame" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="fulldescription">
            <p>
                <%=game.getFullDescription()%>
            </p>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>