package com.example.soc.models;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String login;
    private String photoUrl;
    private String password;

    public CreateUserDto(String firstName,String lastName,String login,String photoUrl,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.photoUrl = photoUrl;
        this.password = password;
    }
    public CreateUserDto(String firstName,String lastName,String login,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.photoUrl = "";
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

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
