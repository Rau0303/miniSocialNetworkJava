package com.example.soc.models;

public class UserDto {
    private String login;
    private String password;
    private String email;

    public UserDto(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public UserDto(String email,String password){
        this.email = email;
        this.password = password;
        this.login = "";
    }

    // Геттеры и сеттеры (по необходимости)
}
