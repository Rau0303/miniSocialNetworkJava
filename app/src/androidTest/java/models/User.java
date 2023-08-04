package models;
import java.io.File;
import java.io.FileReader;

public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;
    private File PhotoURL;


    // конструктор с фото
    public User(int id,String FirstName,String LastName,String UserName,String Password,File PhotoUrl) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Password = Password;
        this.PhotoURL = PhotoUrl;
    }
    // конструктор без фото
    public User(int id,String FirstName,String LastName,String UserName, String Password){
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Password = Password;
        this.PhotoURL = null;

    }


    // геттеры и сеттеры
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public String getFirstName(){
        return FirstName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    public String getLastName(){
        return LastName;
    }

    public void setUserName(String UserName){
        this.UserName = UserName;
    }
    public String getUserName(){
        return UserName;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getPassword(){
        return Password;
    }

    public void setPhotoURL(File PhotoURL){
        this.PhotoURL = PhotoURL;
    }
    public File getPhotoURL(){
        return PhotoURL;
    }


    //метод toString()
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", PhotoURL=" + PhotoURL +
                '}';
    }
}
