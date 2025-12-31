package com.example.socialapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    // API to get all tweets from server
    @GET("/")
    Call<List<Post>> getPosts();

    // API to send a new tweet to server
    @POST("/create")
    Call<Void> createPost(@Body Post post);
}