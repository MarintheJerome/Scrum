<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Fiche de ${name}</title>

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
<h1 class="title">Fiche de ${name}</h1>
<div class="container-fluid">
    <div>
        <div class="video">
            <video>
                <source src="${video}" type="video/mp4">
            </video>
        </div>
        <div class="releasedate">
            <p>
                ${releasedate}
            </p>
        </div>
        <div class="shortdescription">
            <p>
                ${shortdescription}
            </p>
        </div>
    </div>
    <div class="fulldescription">
        <p>
            ${fulldescription}
        </p>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>