package com.example.registration.form.model.Response;

import java.util.List;
import java.util.Map;

public class ViewUserResponse {
    private String username;
    private String name;
    private String email;
    private Map<Integer,String> postedArticle;
    private Map<Integer,String> likedArticle;

    public ViewUserResponse(String username, String name, String email, Map<Integer, String> postedArticle, Map<Integer, String> likedArticle) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.postedArticle = postedArticle;
        this.likedArticle = likedArticle;
    }

    public Map<Integer, String> getPostedArticle() {
        return postedArticle;
    }

    public void setPostedArticle(Map<Integer, String> postedArticle) {
        this.postedArticle = postedArticle;
    }

    public Map<Integer, String> getLikedArticle() {
        return likedArticle;
    }

    public void setLikedArticle(Map<Integer, String> likedArticle) {
        this.likedArticle = likedArticle;
    }

    public ViewUserResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
