package steam.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yhugo on 27/02/2017.
 */
@WebServlet(name = "Deconnexion",urlPatterns={"/admin","/Admin"})
public class AdminPannel  extends javax.servlet.http.HttpServlet {


    public static final String VUE = "/WEB-INF/inscription.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
