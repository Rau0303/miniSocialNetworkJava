package Services;




import java.io.IOException;


public class Auth {
    private User user;
    private String url = "http://192.168.31.107:5002/api";

    public Auth() throws IOException {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String login(User user) throws IOException {

       return  null;


    }






}
