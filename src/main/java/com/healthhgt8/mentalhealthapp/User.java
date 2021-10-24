package com.healthhgt8.mentalhealthapp;

public class User {
    private static User instance = new User();
    private String name;
    private String email;
    private String major;
    private boolean isHelper; // not the best OOP, but OK for now
    private boolean nameDisclosed;

    private User() {

    }
    // Get the only object available-
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    // ------- SETTERS---------------------------------------
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHelper(boolean helper) {
        this.isHelper = helper;
    }

    public void setMajor(String major) {
        this.major = major;

    }

    public void setNameDisclosed(boolean nameDisclosed) {
        this.nameDisclosed = nameDisclosed;
    }
    // ---------- GETTERS ----------------------------------

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }
    // probably don't need getters or setters for the others
}
