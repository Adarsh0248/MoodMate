package com.moodmate.main;

import com.moodmate.data.DataManager;
import com.moodmate.models.Habit;
import com.moodmate.models.MoodLog;
import com.moodmate.models.User;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class ModeMateApp {
    public static Scanner scanner = new Scanner(System.in);
    public static List<User> users;
    public static User currentUser = null;
    private static void login(){
        User foundUser = null;
        String email = null;
        System.out.println("Please enter your email: ");
        email = scanner.nextLine();

            for(User user : users){
                if(user.getEmail().equals(email)){
                    foundUser = user;

                    break;
                }
            }
            if(foundUser == null){
                System.out.println("❌ Email does not exist, Please Register");
                return;
            }
            String password = null;
            boolean passwordExists = false;
            int noOfAttempts = 3;
            while(noOfAttempts > 0){
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if(!password.equals(foundUser.getPassword())){
                    System.out.println("❌ Wrong password, Please try again");
                    System.out.println("Number of attempts remaining is " + --noOfAttempts);

                }else{

                    passwordExists = true;
                    noOfAttempts = 3;
                    break;
                }

            }
            if(passwordExists){
                currentUser = foundUser;
                System.out.println(currentUser.getName()+", You have successfully logged in 😊");
            }else{
                System.out.println("Out of Attempts");
                System.out.println("Please try again");
            }


    };
    private static void register(){
        String email;
        while (true) {
            System.out.println("Enter your email: ");
            email = scanner.nextLine();

            boolean emailExists = false;
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(email)) {
                    emailExists = true;
                    break;
                }
            }
            if (emailExists) {
                System.out.println("❌ This email is already taken. Please try another one.");
            } else {
                break;
            }
        }

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(users.size(), name, email, password);
        users.add(user);
        System.out.println("Registration successful ✅");
        System.out.println("Welcome to MoodMate " + user.getName());
    }
    private static void addHabit(){
        if(currentUser==null){
            System.out.println("Please Login first");
        }else{
            System.out.println("Enter new habit name: ");
            String newHabit = scanner.nextLine();
            currentUser.addHabit(new Habit(newHabit));
            System.out.println("Habit successfully added ✅");

        }
    }
    private static void logMood(){
        if(currentUser==null){
            System.out.println("Please Login first");
        } else {
            System.out.println("Please enter your mood: ");
            String mood = scanner.nextLine();
            System.out.println("Please enter any note : ");
            String note = scanner.nextLine();
            currentUser.logMood(new MoodLog(mood, note));
            System.out.println("Mood Logged Succesfully 😊");
        }
    };
    private static void logOut(){
        currentUser = null;
    };
    private static void viewProgress(){
        if(currentUser==null){
            System.out.println("Please Login first");
        }else{
            if (currentUser.getHabits().isEmpty()) {
                System.out.println("You haven't added any habits yet. Go add one!");
            }else {
                System.out.println("---Your Habits---");
                int noOfHabits = currentUser.getHabits().size();
                int n = 1;
                for (Habit habit : currentUser.getHabits()) {
                    System.out.println((n++) + ". Habit Name: " + habit.getHabitName());
                    System.out.println("Current Streak : " + habit.getStreak() + " Days");
                    System.out.println("No. of Days Completed : " + habit.getDaysCompleted());
                }
            }
            if (currentUser.getMoodLogs().isEmpty()) {
                System.out.println("You haven't logged any moods yet.");
            }else {

                System.out.println("---Your Recent Moods ---");
                int noOfMoods = currentUser.getMoodLogs().size();
                for (int i = noOfMoods - 1; i >= 0; i--) {
                    MoodLog moodLog = currentUser.getMoodLogs().get(i);
                    System.out.println("Date: " + moodLog.getDate());
                    System.out.println("Mood: " + moodLog.getMood());
                    System.out.println("Note: " + moodLog.getNotes());
                }
            }
        }
    };
    public static void main(String[] args) {
        users = DataManager.loadUsers();
        while (true) {
            if(currentUser == null) {
                //---Logged Out Stage---
                System.out.println("🧠 Welcome to MoodMate 🧠");
                System.out.println("🦾🦾 One Place to Track all Your Habits 🦾🦾");
                System.out.println("1.Login");
                System.out.println("2.Register");
                System.out.println("3.Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: login(); break;
                    case 2: register(); break;
                    case 3:
                        DataManager.saveUsers(users);
                        System.exit(0); break;
                    default:
                        System.out.println("Wrong choice");
                }


            }else{
                //---Logged In Stage---
                currentUser.displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: addHabit(); break;
                    case 2: logMood(); break;
                    case 3: viewProgress(); break;
                    case 4: logOut(); break;
                    default:
                        System.out.println("Wrong choice");
                }

            }


        }
    }
}
