package com.example.registration.form.model.Response;

public class SignUpResponse {
    private String email;
    private String username;

    public SignUpResponse(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public SignUpResponse() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
