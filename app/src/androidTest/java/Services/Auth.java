package Services;


import models.User;

public class Auth {
    private User user;
    private String url = "http://192.168.31.107:5002/swagger/index.html";

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

    public void login(String UserName, String Password){

    }
}
