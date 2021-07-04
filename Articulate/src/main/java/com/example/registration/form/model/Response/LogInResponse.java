package com.example.registration.form.model.Response;

public class LogInResponse {
    private String name;
    private String email;
    private String username;

    public LogInResponse() {
    }

    public LogInResponse(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
