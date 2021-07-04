package com.example.registration.form.model.Params;

import com.example.registration.form.model.DB.Article;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewArticleParams {
    private String title;
    private String body;
    @JsonProperty("is_public")
    private Boolean isPublic;
    public NewArticleParams() {
    }

    public NewArticleParams(String title, String body, Boolean isPublic) {
        this.title = title;
        this.body = body;
        this.isPublic = isPublic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Article getArticle() {
        return new Article(this.title,this.body,this.isPublic);
    }
}
