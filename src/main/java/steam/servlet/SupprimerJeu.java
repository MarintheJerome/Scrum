package steam.servlet;

import steam.model.Game;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jerome on 27/02/2017.
 */
@WebServlet(name = "supprimerJeu", urlPatterns={"/supprimerJeu","/SupprimerJeu", "/supprimerJeu.jsp"})
public class SupprimerJeu extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/supprimerJeu.jsp";
    public static final String REDIRECT ="/WEB-INF/result.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(!request.getParameter("gameName").equals("")) {
            ArrayList<Game> games = Game.findAll();
            boolean trouve = false;
            for(Game game : games){
                if(game.getName().equals(request.getParameter("gameName"))){
                    trouve = true;
                }
            }
            if(trouve){
                Game.deleteGame(request.getParameter("gameName"));
                request.getSession().setAttribute("message", "Jeu correctement supprimé");
            }
            else{
                request.getSession().setAttribute("message", "Ce jeu n'existe pas");
            }
        }else{
            request.getSession().setAttribute("message", "Veuillez selectionner un jeu avant de supprimer");
        }
        this.getServletContext().getRequestDispatcher(REDIRECT).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ArrayList<Game> games = new ArrayList<>();
        games = Game.findAll();
        request.setAttribute("games", games);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}