package com.example.registration.form.model.Params;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewUserParams {
    @JsonProperty("user_id")
    private Long userId;

    public ViewUserParams(Long userId) {
        this.userId = userId;
    }

    public ViewUserParams() {
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
