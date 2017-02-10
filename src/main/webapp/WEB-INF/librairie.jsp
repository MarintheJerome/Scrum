<%@ page import="steam.model.LibraryEntry" %>
<%@ page import="steam.model.Library" %>
<%@ page import="steam.model.Game" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Annuaire</title>

    <!-- Bootstrap -->
    <link href="bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Identifiez-vous ou créez votre compte pour utiliser notre service.</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <% for(LibraryEntry entry : Library.find(session.getAttribute("userId")).getEntries()) { %>
            <div class="media">
                <div class="media-body">
                    <h4 class="media-heading"><%= Game.find(entry.getGame()) %></h4>
                    <%= entry.getCle() %>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>
