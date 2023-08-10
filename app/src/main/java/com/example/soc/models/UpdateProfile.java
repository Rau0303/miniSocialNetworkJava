package com.example.soc.models;

public class UpdateProfile {
    private String firstName;
    private String lastName;
    private String photoUrl;

    public UpdateProfile(String firstName,String lastName,String photoUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
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

    public void setPhotoUrl(String photoUrl){
        this.photoUrl = photoUrl;
    }
    public String getPhotoUrl(){
        return photoUrl;
    }

    @Override
    public String toString() {
        return "UpdateProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
