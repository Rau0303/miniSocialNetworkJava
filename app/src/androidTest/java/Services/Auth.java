package Services;




import static java.lang.System.out;

import com.example.soc.models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;




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
