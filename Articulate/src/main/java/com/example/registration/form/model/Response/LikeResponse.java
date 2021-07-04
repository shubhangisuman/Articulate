package com.example.registration.form.model.Response;

public class LikeResponse {
    private String username;
    private String articleTitle;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public LikeResponse() {
    }

    public LikeResponse(String username, String articleTitle) {
        this.username = username;
        this.articleTitle = articleTitle;
    }
}
