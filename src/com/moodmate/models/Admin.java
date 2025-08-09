package com.moodmate.models;

import java.util.Scanner;

public class Admin extends Person {
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    @Override
    public void displayMenu(){
        System.out.println("1.View System Statistics");
        System.out.println("2.Add new Quote");
        System.out.println("3.LogOut");
    }

    public void viewSystemStatistics(){

    }

    public void addNewQuote(){

    }

    public void logOut(){

    }


    public void startAdminSession(){
        while(true){
            displayMenu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    viewSystemStatistics();
                    break;
                case 2:
                    addNewQuote();
                    break;
                case 3:
                    logOut();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

}
