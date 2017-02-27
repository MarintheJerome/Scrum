package steam.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nitix on 27/02/17.
 */
@WebServlet(name = "panier", urlPatterns = {"/panier.jsp"})
public class Panier extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "WEB-INF/panier.jsp" ).forward( request, response );
    }
}
