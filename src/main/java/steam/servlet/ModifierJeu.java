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
 * Created by Nicochu on 27/02/2017.
 */
@WebServlet(name = "modifierJeu",urlPatterns={"/modifierJeu","/modifierjeu", "/modifierJeu.jsp", "/modifierjeu.jsp"})
public class ModifierJeu extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/modifierJeu.jsp";
    public static final String RESULT ="/WEB-INF/result.jsp";
    public static final String NAME = "nom";
    public static final String SHORTDESC = "shortDesc";
    public static final String FULLDESC = "fullDesc";
    public static final String VIDEO = "video";
    public static final String PRICE = "price";
    public static final String DATE = "date";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ArrayList<Tag> tags = new ArrayList<>();
        for (int i=1 ; i < 5 ; i++ ) {
            if ( !(request.getParameter("tag"+i).isEmpty()) ) {
                tags.add(new Tag(request.getParameter("tag"+i)));
            }
        }

        String name = request.getParameter(NAME);
        String shortDesc = request.getParameter(SHORTDESC);
        String fullDesc = request.getParameter(FULLDESC);
        String date = request.getParameter(DATE);
        String video = request.getParameter(VIDEO);
        Double price = Double.parseDouble(request.getParameter(PRICE));

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
        Date dateFinale = null;
        try {
            dateFinale = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Game game = new Game(name,shortDesc,fullDesc,price,video,dateFinale,tags);
        for(Tag t : tags) {
            t.sauvegarder();
        }

        game.sauvegarder();

        StringBuilder message = new StringBuilder();
        message.append("Le jeu "+name+"  a été ajouté !");

        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
