package com.example.socialapp;

import com.google.gson.annotations.SerializedName;

public class Post {
    // These names must match your database columns
    @SerializedName("username")
    private String username;

    @SerializedName("content")
    private String content;

    // Constructor for creating a new post object
    public Post(String username, String content) {
        this.username = username;
        this.content = content;
    }

    // Getters to retrieve data
    public String getUsername() { return username; }
    public String getContent() { return content; }
}