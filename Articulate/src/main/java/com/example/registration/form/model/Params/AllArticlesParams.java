package com.example.registration.form.model.Params;

import java.util.List;

public class AllArticlesParams {
    private String title;
    private String username;
    private List<String> tags;
    private String sortBy;
    private Integer limit;

    public AllArticlesParams(String title, String username, List<String> tags, String sortBy, Integer limit) {
        this.title = title;
        this.username = username;
        this.tags = tags;
        this.sortBy = sortBy;
        this.limit = limit;
    }

    public AllArticlesParams() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
