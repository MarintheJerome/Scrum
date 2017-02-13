package steam.servlet;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;
import steam.bdd.MongoDB;
import steam.model.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Yhugo on 13/02/2017.
 */
@WebServlet(name = "Connexion",urlPatterns={"/connexion","/Connexion", "/Connexion.jsp", "/connexion.jsp"})
public class Connexion extends javax.servlet.http.HttpServlet {

    public static final String VUE = "/WEB-INF/inscription.jsp";
    public static final String RESULT = "/WEB-INF/result.jsp";
    public static final String LOGIN = "login-co";
    public static final String MDP = "password-co";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String mdp = request.getParameter(MDP);
        StringBuilder message = new StringBuilder();

        BasicDBObject query = new BasicDBObject();
        query.put("login", login);

        User user = new User(MongoDB.getInstance().mdb.getCollection("Users").find(query).first());

        if (user == null) {
            message.append("Utilisateur non trouvé.");
        } else {
            if (BCrypt.checkpw(mdp, user.getMdp())) {
                message.append("Merci pour votre connexion.");
                request.getSession().setAttribute("login", user.login);
            }else{
                message.append("Mot de passe incorrect.");
            }
        }

        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}