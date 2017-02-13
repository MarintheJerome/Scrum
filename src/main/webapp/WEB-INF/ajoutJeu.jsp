<%@ page import="java.util.ArrayList" %>
<%@ page import="steam.model.Tag" %>
<%@ page import="steam.model.Game" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    <jsp:include page="/src/main/webapp/bootstrap.min.css" />
</style>

<% if ( !(request.getParameter("name").isEmpty() && !(request.getParameter("shortDesc")).isEmpty() &&
        !(request.getParameter("fullDesc")).isEmpty() && !(request.getParameter("date")).isEmpty())  ) {
%>
<html>
<head>
    <title>Ajout jeu</title>
    <meta http-equiv="refresh" content="2;URL=index.jsp">
</head>
<body>
    <%
        ArrayList<Tag> tags = new ArrayList<>();
        for (int i=1 ; i < 5 ; i++ ) {
            if ( !(request.getParameter("tag"+i).isEmpty()) ) {
                tags.add(new Tag(request.getParameter("tag"+i)));
            }
        }

        String name = request.getParameter("name");
        String shortDesc = request.getParameter("shortDesc");
        String fullDesc = request.getParameter("fullDesc");
        String date = request.getParameter("date");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date dateFinale = sdf.parse(date);

        Game game = new Game(name,shortDesc,fullDesc,dateFinale,tags);
        for(Tag t : tags) {
            t.sauvegarder();
        }

        game.sauvegarder();
    } else {
    %>
Ajout du jeu réussi !
<html>
<head>
    <title>Connexion</title>
    <meta http-equiv="refresh" content="2;URL=ajoutJeu.html">
</head>
<body>
Il manque des attributs au jeu, veuillez réessayer.
<%
    }
%>

</body>
</html>