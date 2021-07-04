package com.example.registration.form.model.Params;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TagArticleParams {
    @JsonProperty("article_id")
    private Integer articleId;
    private List<String> tags;
    public TagArticleParams(Integer articleId, List<String> tags) {
        this.articleId = articleId;
        this.tags = tags;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
