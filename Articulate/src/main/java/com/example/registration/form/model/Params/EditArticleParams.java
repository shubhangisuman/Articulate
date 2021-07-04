package com.example.registration.form.model.Params;

public class EditArticleParams {
    private String body;
    private Boolean isPublic;

    public EditArticleParams() {
    }

    public EditArticleParams(String body, Boolean isPublic) {
        this.body = body;
        this.isPublic = isPublic;
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
}
