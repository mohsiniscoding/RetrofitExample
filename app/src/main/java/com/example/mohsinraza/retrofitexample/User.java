package com.example.mohsinraza.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    private String name;

    @SerializedName("avatar_url")
    private String avatar_img_url;

    public User(String name, String avatar_img_url) {
        this.name = name;
        this.avatar_img_url = avatar_img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_img_url() {
        return avatar_img_url;
    }

    public void setAvatar_img_url(String avatar_img_url) {
        this.avatar_img_url = avatar_img_url;
    }
}
