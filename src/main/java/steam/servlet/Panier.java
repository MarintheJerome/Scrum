package steam.servlet;

import steam.model.Basket;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nitix on 27/02/17.
 */
@WebServlet(name = "panier", urlPatterns = {"/panier"})
public class Panier extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(request.getSession().getAttribute("login") == null){
            this.getServletContext().getRequestDispatcher( "/WEB-INF/inscription.jsp" ).forward( request, response );
            return;
        }
        Basket basket = Basket.getBasket((String) request.getSession().getAttribute("login"));
        request.setAttribute("basket", basket);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/panier.jsp" ).forward( request, response );
    }
}
