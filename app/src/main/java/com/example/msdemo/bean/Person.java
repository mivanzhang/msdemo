package com.example.msdemo.bean;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
//    @SerializedName("avatar_filename")
    private String avatarFilename="isaac_fielder";
    @SerializedName("title")
    private String title;
    @SerializedName("introduction")
    private String introduction;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarFilename() {
        return avatarFilename;
    }

    public void setAvatarFilename(String avatarFilename) {
        this.avatarFilename = avatarFilename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
