<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bienvenue sur SteamFanBoy !</title>

    <!-- Bootstrap -->
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="../style/index.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div id="divEntete" class = "divGeneral">
    <div id ="divInscription">
        <a href="inscription">Inscription</a>
    </div>
    <h1 id="titre">Bienvenue sur SteamFanBoy !</h1>
</div>

<div id="divEnteteDeux" class = "divG/deral">
    <div id="divRecherche">
        <form action="recherche" class="form-horizontal" method=post">
            <fieldset>
                Recherche : <input type="text" name="recherche" value="">
                <input type="submit" value="Rechercher" name="searchGame" />
            </fieldset>
        </form>
    </div>
</div>

<div id="divMilieu" class = ="divGeneral">
    <div id="divCategories" class = "divGeneral">
        <table id="tableCategories">

            <tr class="trEntete">
                <td class="tdEntete">
                    Genres
                </td>
            </tr>

            <tr class="tableEnteteSeparateurPortefeuilleActions"> </tr>

            <tr class="itemTableCategorie">
                <td class="tdCategorie">
                    RPG
                </td>
            </tr>

            <tr class="itemTableCategorie">
                <td class="tdCategorie">
                    Aventure
                </td>
            </tr>

            <tr class="itemTableCategorie">
                <td class="tdCategorie">
                    Action
                </td>
            </tr>

            <tr class="itemTableCategorie">
                <td class="tdCategorie">
                    Puzzle game
                </td>
            </tr>

            <tr class="itemTableCategorie">
                <td class="tdCategorie">
                    FPS
                </td>
            </tr>

        </table>

    </div>

    <div id="divListeJeux" class = "divGeneral">

        <table id="tableListeDesJeux">

            <tr class="trEntete">
                <td class="tdEntete">
                    Liste des jeux
                </td>
            </tr>

            <tr class="tableEnteteSeparateurPortefeuilleActions"> </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 1
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 2
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 3
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 4
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 5
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 6
                </td>
            </tr>

            <tr class="trJeu">
                <td class="tdJeu">
                    Jeu 7
                </td>
            </tr>

        </table>

    </div>

</div>
</body>
</html>