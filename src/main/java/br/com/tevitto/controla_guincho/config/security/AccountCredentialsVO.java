package br.com.tevitto.controla_guincho.config.security;

import java.io.Serializable;

public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUIS = 1L;

    private String email;
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
