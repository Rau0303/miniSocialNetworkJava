package com.example.soc.models;

public class CreatePostDto {
    private String name;
    private String description;
    private String url;

    public CreatePostDto(String name,String description,String url){
        this.name = name;
        this.description = description;
        this.url = url;
    }


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description =description;
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

    @Override
    public String toString() {
        return "CreatePostDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
