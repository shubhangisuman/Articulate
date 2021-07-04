package com.example.registration.form.model.Params;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class LikeParams {
    @JsonProperty("article_id")
    private Integer articleId;

    public LikeParams() {
    }

    public LikeParams(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
