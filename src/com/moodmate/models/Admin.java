package com.moodmate.models;

import java.util.Scanner;

public class Admin extends Person {
    public Admin(int id ,String name, String email, String password) {
        super(id,name, email, password);
    }
    @Override
    public void displayMenu(){
        System.out.println();
        System.out.println("--------ADMIN MENU------");
        System.out.println("1.View System Statistics");
        System.out.println("2.Add new Quote");
        System.out.println("3.View all users");
        System.out.println("4.Make ADMIN");
        System.out.println("5.LogOut");
    }
}
