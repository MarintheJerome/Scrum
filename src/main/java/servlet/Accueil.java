import java.io.IOException;

/**
 * Created by Jerome on 10/02/2017.
 */
@WebServlet(name = "accueil", urlPatterns = {"/index.jsp"})
public class Accueil extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type.equals("inscription")) {
            this.handleInsription(request, response);
        } else {
            this.handleConnection(request, response);
        }
    }
}