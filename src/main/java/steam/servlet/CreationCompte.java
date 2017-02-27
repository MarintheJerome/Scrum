package steam.servlet;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;
import steam.bdd.MongoDB;
import steam.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yhugo on 27/02/2017.
 */
@WebServlet(name = "CreationCompte",urlPatterns={"/creationCompte","/CreationCompte", "/creationCompte.jsp", "/CreationCompte.jsp"})
public class CreationCompte extends HttpServlet {

    public static final String VUE ="/WEB-INF/ajouterCompte.jsp";
    public static final String RESULT ="/WEB-INF/result.jsp";
    public static final String LOGIN = "login";
    public static final String MDP = "password";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String ADRESSE = "adresse";
    public static final String TELEPHONE = "telephone";
    public static final String DATENAISSANCE = "dateNaissance";
    public static final String ROLE = "role";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder message = new StringBuilder();

        if(request.getSession().getAttribute("role").equals("Administrateur")){
            String login = request.getParameter(LOGIN);
            String mdp = request.getParameter(MDP);
            String nom = request.getParameter(NOM);
            String prenom = request.getParameter(PRENOM);
            String adresse = request.getParameter(ADRESSE);
            String telephone = request.getParameter(TELEPHONE);
            String datenaissance = request.getParameter(DATENAISSANCE);
            String role = request.getParameter(ROLE);

            User user = new User(nom, prenom, telephone, adresse, datenaissance,login, BCrypt.hashpw(mdp, BCrypt.gensalt()),role);

            Document d = user.toDocument();

            if(!login.equals("") && !mdp.equals("") && !nom.equals("") && !prenom.equals("")
                    && !adresse.equals("") && !telephone.equals("") && !datenaissance.equals("")){
                BasicDBObject query = new BasicDBObject();
                query.put("login", login);
                Document testing = MongoDB.getInstance().mdb.getCollection("Users").find(query).first();
                System.out.println(testing);
                if(testing ==null){
                    MongoDB.getInstance().mdb.getCollection("Users").insertOne(d);
                    message.append("Vous avez bien créer un compte.");
                }else{
                    message.append("Un utilisateur existe déjà avec ce login merci d'essyer un nom.");
                }
            }else{
                message.append("Vous n'avez pas rempli le questionnaire entièrement.");
            }
        }else{
            message.append("Vous n'avez pas l'autorisation.");
        }


        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("role") != null
               && request.getSession().getAttribute("role").equals("Administrateur")) {
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }else{
            StringBuilder message = new StringBuilder();
            message.append("Vous n'avez pas l'autorisation.");
            request.getSession().setAttribute("message", message);
            this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );
        }
    }
}
