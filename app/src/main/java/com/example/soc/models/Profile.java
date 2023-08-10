package com.example.soc.models;

import androidx.dynamicanimation.animation.SpringForce;

public class Profile {
    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String photoUrl;

    public Profile(String id,String firstName,String lastName,String login,String photoUrl){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.photoUrl = photoUrl;
    }
    public Profile(String id,String firstName,String lastName,String login){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.photoUrl = "";
    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }

    public void setPhotoUrl(String photoUrl){
        this.photoUrl = photoUrl;
    }
    public String getPhotoUrl(){
        return photoUrl;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
