package com.example.soc.models;

public class UserDto {
    private String login;
    private String password;


    public UserDto(String login,String password){
        this.login = login;
        this.password = password;
    }

    // Геттеры и сеттеры (по необходимости)

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
