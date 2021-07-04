package com.example.registration.form.model.Params;

import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.DB.Type;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SignUpParams {

    private String name;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    public SignUpParams() {
    }
    public SignUpParams(String name, String email, String username, String password, Type type) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public User getUser(){
        return new User(name,email,username,password,type);
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
