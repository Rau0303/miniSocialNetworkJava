package com.example.soc.models;

public class Post {
    private String id;
    private String name;
    private String description;
    private String url;
    private String userId;


    public Post(String id,String name,String description,String url,String userId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.userId = userId;
    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return url;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
