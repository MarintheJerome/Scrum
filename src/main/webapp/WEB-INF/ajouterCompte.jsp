<%--
  Created by IntelliJ IDEA.
  User: Yhugo
  Date: 27/02/2017
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Ajouter un compte</title>

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
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <form method="post" action="/creationCompte">
                <input type="hidden" name="type" value="inscription">
                <div class="form-group">
                    <label for="login">Identifiant</label>
                    <input type="text" class="form-control" id="login" name="login" placeholder="Identifiant">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe">
                </div>
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom">
                </div>
                <div class="form-group">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom">
                </div>
                <div class="form-group">
                    <label for="adresse">Adresse</label>
                    <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse">
                </div>
                <div class="form-group">
                    <label for="telephone">Téléphone</label>
                    <input type="text" class="form-control" id="telephone" name="telephone" placeholder="Téléphone">
                </div>
                <div class="form-group">
                    <label for="dateNaissance">Date de Naissance</label>
                    <input type="date" class="form-control" id="dateNaissance" name="dateNaissance">
                </div>

                <div class="form-group">
                    <label for="role">Rôle</label>
                    <select class="form-control" id="role" name="role">
                        <option value="Client">Client</option>
                        <option value="Editeur">Editeur</option>
                        <option value="Chargé">Chargé de Facturation</option>
                        <option value="Administrateur">Administrateur</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-default">Enregistrer</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
