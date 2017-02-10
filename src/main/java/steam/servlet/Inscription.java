package steam.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Yhugo on 10/02/2017.
 */
@WebServlet(name = "Inscription",urlPatterns={"/inscription","/Inscription"})
public class Inscription extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/Inscription.jsp";
    public static final String RESULT ="/WEB-INF/result.jsp";
    public static final String LOGIN = "login";
    public static final String MDP = "password";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String ADRESSE = "adresse";
    public static final String TELEPHONE = "telephone";
    public static final String DATENAISSANCE = "dateNaissance";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String motDePasse = request.getParameter(MDP);
        String nom = request.getParameter(NOM);
        String prenom = request.getParameter(PRENOM);
        String adresse = request.getParameter(ADRESSE);
        String telephone = request.getParameter(TELEPHONE);
        String datenaissance = request.getParameter(DATENAISSANCE);

        StringBuilder message = new StringBuilder();


        message.append("Vous êtes bien inscris, merci d'utiliser notre service");
        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
