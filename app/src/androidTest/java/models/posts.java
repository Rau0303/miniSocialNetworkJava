package models;

import java.io.File;

public class posts {
    private String Title;
    private String Description;
    private File PhotoURL;


    // конструктор с фото
    public posts(String Title,String Description,File PhotoURL) {
        this.Title = Title;
        this.Description = Description;
        this.PhotoURL = PhotoURL;
    }
    //конструктор без фото
    public posts(String Title,String Description){
        this.Title = Title;
        this.Description = Description;
        this.PhotoURL = null;
    }


    //геттеры и сеттеры
    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getTitle(){
        return Title;
    }

    public void setDescription(String Description){
        this.Description = Description;
    }
    public String getDescription(){
        return Description;
    }

    public void setPhotoURL(File PhotoURL){
        this.PhotoURL = PhotoURL;
    }
    public File getPhotoURL(){
        return PhotoURL;
    }


    //метод toString
    @Override
    public String toString() {
        return "posts{" +
                "Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", PhotoURL=" + PhotoURL +
                '}';
    }
}
