package com.example.mohsinraza.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubClient {

    @GET("/users")
    Call<List<User>> getAllUsers();


}
