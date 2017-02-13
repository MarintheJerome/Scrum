package steam.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jerome on 13/02/2017.
 */
@WebServlet(name = "recherche", urlPatterns = {"/recherche"})
public class Recherche extends HttpServlet {

    public static final String VUE ="/WEB-INF/fiche.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("recherche"));

        req.getSession().setAttribute("name", req.getParameter("recherche"));
        req.getSession().setAttribute("shortdescription", req.getParameter("lalala"));
        req.getSession().setAttribute("fulldescription", req.getParameter("lalalalalalalalalalalalalalala"));
        req.getSession().setAttribute("releasedate", req.getParameter("12/08/2017"));
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }
}