package dev.wess.note_taking_app.domain;

import jakarta.persistence.Entity;

@Entity
public class SecureNote extends Note{
    private String passwordHash;


    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
