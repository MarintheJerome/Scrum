package steam.servlet;

import org.bson.types.ObjectId;
import steam.model.Basket;
import steam.model.Game;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nitix on 27/02/17.
 */
@WebServlet(name = "panier", urlPatterns = {"/ajoutPanier.jsp"})
public class AjoutPanier extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String sGameId = request.getParameter("game");
        ObjectId gameId = new ObjectId(sGameId);
        Game game = Game.find(gameId);
        Basket basket = Basket.getBasket((String) request.getSession().getAttribute("login"));
        basket.getGames().add(gameId);
        basket.upsert();
        this.getServletContext().getRequestDispatcher( "WEB-INF/panier.jsp" ).forward( request, response );
    }
}