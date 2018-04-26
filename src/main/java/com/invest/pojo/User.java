package com.invest.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private static final long serialVersionUID = -1695973853274402680L;

    public String getUsername() {
        return username;
    }

    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
