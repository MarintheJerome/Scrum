package steam.model;

import org.bson.Document;

/**
 * Created by Yhugo on 10/02/2017.
 */
public class Identifiant {

    public String login;
    public String mdp;

    public Identifiant(String log, String mdp){
        this.login=log;
        this.mdp=mdp;
    }

    public Identifiant(Document document) {
        this.login = document.get("login").toString();
        this.mdp = document.get("mdp").toString();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
