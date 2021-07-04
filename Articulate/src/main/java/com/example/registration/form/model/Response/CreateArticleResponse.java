package com.example.registration.form.model.Response;

public class CreateArticleResponse {
    private String username;
    private String title;

    public CreateArticleResponse(String username, String title) {
        this.username = username;
        this.title = title;
    }

    public CreateArticleResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
