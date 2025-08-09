package com.moodmate.models;

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    private static int totalUsers = 0;

    protected Person() {
        // Required for deserialization of subclasses
    }

    public Person( String name, String email, String password) {
        this.id = ++totalUsers;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    abstract public void displayMenu();
}


