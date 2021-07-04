package com.example.registration.form.model.Params;

import javax.persistence.Entity;
import javax.persistence.Id;

public class LogInParams {
    @Id
    private String username;
    private String password;

    public LogInParams() {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
