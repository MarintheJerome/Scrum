package steam.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yhugo on 13/02/2017.
 */
@WebServlet(name = "Deconnexion",urlPatterns={"/deconnexion","/Deconnexion"})
public class Deconnexion extends HttpServlet {

    public static final String RESULT ="/WEB-INF/result.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("login", null);
        request.getSession().setAttribute("role", null);
        request.getSession().setAttribute("message", "Vous avec été déconnecté ! Have fun day.");
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );
    }
}