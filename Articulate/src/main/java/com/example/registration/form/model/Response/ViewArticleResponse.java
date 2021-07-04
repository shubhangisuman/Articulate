package com.example.registration.form.model.Response;

import com.example.registration.form.model.DB.Article;

import java.util.List;

public class ViewArticleResponse {
    private Article article;
    private List<String> tags;
    private int likesCount;
    private String username;

    public ViewArticleResponse() {
    }

    public ViewArticleResponse(Article article, List<String> tags, int likesCount, String username) {
        this.article = article;
        this.tags = tags;
        this.likesCount = likesCount;
        this.username = username;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
