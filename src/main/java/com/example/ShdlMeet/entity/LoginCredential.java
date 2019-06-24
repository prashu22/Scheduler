package com.example.ShdlMeet.entity;

import javax.validation.constraints.NotBlank;

public class LoginCredential {
    @NotBlank(message = "Email is Mandatory")
    private String email;

    @NotBlank(message = "Password is Mandatory")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
