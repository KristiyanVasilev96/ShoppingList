package com.example.listofshooping.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters !!!!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters !!!!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
