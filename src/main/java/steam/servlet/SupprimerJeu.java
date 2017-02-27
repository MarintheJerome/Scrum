package steam.servlet;

import steam.model.Game;
import steam.model.Tag;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jerome on 27/02/2017.
 */
@WebServlet(name = "supprimerJeu", urlPatterns={"/supprimerJeu","/SupprimerJeu", "/supprimerJeu.jsp"})
public class SupprimerJeu extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/supprimerJeu.jsp";
    public static final String REDIRECT ="/WEB-INF/result.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(!request.getParameter("gameName").equals("")) {
            Game.deleteGame(request.getParameter("gameName"));
            request.getSession().setAttribute("message", "Jeu correctement supprimé");
            this.getServletContext().getRequestDispatcher(REDIRECT).forward(request, response);
        }else{
            request.getSession().setAttribute("message", "Veuillez selectionner un jeu avant de supprimer");
            this.getServletContext().getRequestDispatcher(REDIRECT).forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ArrayList<Game> games = new ArrayList<>();
        games = Game.findAll();
        request.setAttribute("games", games);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}