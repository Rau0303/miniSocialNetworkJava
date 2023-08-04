package models;

import java.io.File;

public class posts {
    private int Id;
    private String Title;
    private String Description;
    private String Url;


    public posts(int Id,String Title,String Description,String Url) {
        this.Id = Id;
        this.Title = Title;
        this.Description = Description;
        this.Url = Url;
    }


    //геттеры и сеттеры
    public void setId(int Id){
        this.Id =Id;
    }
    public int getId(){
        return Id;
    }

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

    public void setUrl(String Url){
        this.Url = Url;
    }
    public String getUrl(){
        return Url;
    }


    @Override
    public String toString() {
        return "posts{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
