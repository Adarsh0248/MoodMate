package com.moodmate.main;


import com.moodmate.core.MoodAnalyzer;
import com.moodmate.core.QuoteManager;
import com.moodmate.data.DataManager;
import com.moodmate.models.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ModeMateApp {
    public static Scanner scanner ;
    public static List<Person> users;
    private static QuoteManager quoteManager;

    public static Person currentUser = null;
    private static void login(){
        Person foundUser = null;
        String email = null;
        System.out.println("Please enter your email: ");
        email = scanner.nextLine();

            for(Person user : users){
                if(user.getEmail().equals(email)){
                    foundUser = (user instanceof User)? (User) user : (Admin) user;
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


    }
    private static void register(){
        String email;
        while (true) {
            System.out.println("Enter your email: ");
            email = scanner.nextLine();

            boolean emailExists = false;
            for (Person user : users) {
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
        User user = new User(name, email, password);
        users.add(user);
        System.out.println("Registration successful ✅");
        System.out.println("Welcome to MoodMate " + user.getName());
    }
    private static void addHabit(User user){
        if(user==null){
            System.out.println("Please Login first");
        }else{
            System.out.println("Enter new habit name: ");
            String newHabit = scanner.nextLine();
            Habit habit = new Habit(newHabit);
            user.addHabit(habit);
            habit.markCompleted();
            System.out.println("Habit successfully added ✅");
            System.out.println("Great! A new journey begins today. Let's start tracking '" + newHabit+" .");
        }
    }
    private static void markHabitComplete(User user) {
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }
        String habitName = null;
        System.out.println("Which habit would you like to complete?");
        habitName = scanner.nextLine();
        Habit habitToMark = null;
        for(Habit habit : user.getHabits()){
            if(Objects.equals(habit.getHabitName(), habitName)){
                habitToMark = habit;
            }
        }
        if(habitToMark==null){
            System.out.println("Habit not found");
            System.out.println("Would You like to add this habit to your Habits ?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int choice  = scanner.nextInt();
            scanner.nextLine();
            if(choice==1){
                habitToMark= new Habit(habitName);
                user.addHabit(habitToMark);

            }else{
                return;
            }
        }
        int newStreak = habitToMark.markCompleted();
        System.out.println("✅ Habit '" + habitToMark.getHabitName() + "' marked as complete!");

        switch (newStreak) {
            case 1:
                System.out.println("Great! A new journey begins today.");
                break;
            case 3:
                System.out.println("🔥 You're on a 3-day roll! The momentum is building. Keep it up!");
                break;
            case 7:
                System.out.println("🎉 An entire week of consistency! Amazing work!");
                break;
            case 14:
                System.out.println("🚀 Two weeks straight! This is becoming a real habit.");
                break;
            case 30:
                System.out.println("🏆 Incredible! You've stuck with it for a whole month!");
                break;
        }

    }
    private static void logMood(User user){
        if(user==null){
            System.out.println("Please Login first");
        } else {
            System.out.println("Please enter your mood: ");
            String mood = scanner.nextLine();
            System.out.println("Please enter any note : ");
            String note = scanner.nextLine();
            user.logMood(new MoodLog(mood, note));
            System.out.println("Mood Logged Successfully 😊");

            //suggestion
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            System.out.println(moodAnalyzer.analyzeMood(note));
            System.out.println("Mood Logged Succesfully 😊");
            Quote dailyQuote = quoteManager.getRandomQuote(mood);
            System.out.println("\nHere's a quote for you:");
            System.out.println("\n" + dailyQuote.getText() + " - " + dailyQuote.getCategory());
        }
    }
    private static void logOut(){
        DataManager.saveUsers(users);
        currentUser = null;
    }
    private static void viewProgress(User user){
        if(user==null){
            System.out.println("Please Login first");
        }else{
            if (user.getHabits().isEmpty()) {
                System.out.println("You haven't added any habits yet. Go add one!");
            }else {
                System.out.println("---Your Habits---");
                int n = 1;
                for (Habit habit : user.getHabits()) {
                    System.out.println((n++) + ". Habit Name: " + habit.getHabitName());
                    System.out.println("Current Streak : " + habit.getStreak() + " Days");
                    System.out.println("No. of Days Completed : " + habit.getDaysCompleted());
                }
            }
            if (user.getMoodLogs().isEmpty()) {
                System.out.println("You haven't logged any moods yet.");
            }else {

                System.out.println("---Your Recent Moods ---");
                int noOfMoods = user.getMoodLogs().size();
                for (int i = noOfMoods - 1; i >= 0; i--) {
                    MoodLog moodLog = user.getMoodLogs().get(i);
                    System.out.println("Date: " + moodLog.getDate());
                    System.out.println("Mood: " + moodLog.getMood());
                    System.out.println("Note: " + moodLog.getNotes());
                }
            }
        }
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        users = DataManager.loadUsers();
        quoteManager= new QuoteManager();
        quoteManager.loadQuotesFromFile();
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
                        System.exit(0); break;
                    default:
                        System.out.println("Wrong choice");
                }


            }else {
                if (currentUser instanceof Admin) {
                    //---Admin Menu---
                    Admin admin = (Admin) currentUser;
                    admin.displayMenu();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1: viewSystemStats(); break;
                        case 2: addNewQuote(); break;
                        case 3: viewAllUsers(); break;
                        case 4:makeAdmin(); break;
                        case 5 :
                            admin = null;
                            logOut(); break;
                            default:
                                System.out.println("Wrong choice");
                    }


                } else {
                    //---Logged In Stage---
                   User user = (User) currentUser;
                    user.displayMenu();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            addHabit(user);
                            break;
                        case 2:
                            logMood(user);
                            break;
                        case 3:
                            viewProgress(user);
                            break;
                        case 4:
                            markHabitComplete(user);
                            break;
                        case 5:
                            logOut();
                            break;
                        default:
                            System.out.println("Wrong choice");
                    }

                }
            }


        }
    }

    private static void makeAdmin() {
        System.out.println("Please enter a Email ID you want to make ADMIN:");
        String email = scanner.nextLine();
        for(int i=0;i< users.size();i++) {
            if(email.equals(users.get(i).getEmail())) {
                if(users.get(i) instanceof Admin) {
                    System.out.println(users.get(i).getName()+" Already an Admin");
                    return;
                }
                else {
                    Person user = users.get(i);
                    Admin admin = new Admin(user.getName(), user.getEmail(), user.getPassword());
                    users.set(i, admin);
                    System.out.println(admin.getName() + " Promted as Admin ⬆️");
                    return;
                }
            }
        }
        System.out.println("Bhai Mila nhi Email !!");
    }

    private static void addNewQuote() {
        System.out.println("Please enter the text of the new quote: ");
        String text = scanner.nextLine();
        System.out.println("Please enter the category of the new quote: ");
        String category = scanner.nextLine();
        Quote quote = new Quote(text, category);
        quoteManager.addQuote(quote);

        try (java.io.FileWriter fw = new java.io.FileWriter("quotes.csv", true);
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
             java.io.PrintWriter out = new java.io.PrintWriter(bw)) {

            // Format the line exactly as it is in your file
            out.println("\n\"" + text + "\":" + category);

            System.out.println("✅ New quote added successfully!");

        } catch (java.io.IOException e) {
            System.err.println("❌ Error: Could not save the new quote to the file.");
            // Optional: Remove the quote from the in-memory list if saving failed
            quoteManager.removeQuote(quote);
        }

    }

    private static void viewSystemStats() {
        int totalUsers = 0;
        int totalAdmins = 0;
        int totalHabits = 0;
        int totalMoodLogs = 0;

        for (Person person : users) {
            if (person instanceof Admin) {
                totalAdmins++;
            } else {
                totalUsers++;
                User user = (User) person;
                totalHabits += user.getHabits().size();
                totalMoodLogs += user.getMoodLogs().size();
            }
        }

        System.out.println("\n--- MoodMate System Statistics ---");
        System.out.println("Total Registered Users: " + totalUsers);
        System.out.println("Total Administrators: " + totalAdmins);
        System.out.println("------------------------------------");
        System.out.println("Total Habits Tracked: " + totalHabits);
        System.out.println("Total Moods Logged: " + totalMoodLogs);
    }

    private static void viewAllUsers() {
        if(currentUser==null){
            System.out.println("Please Login first");
            return;
        }
        if (currentUser instanceof User) {
            System.out.println("Not Accessible to Users.");
            return;
        }
        for(Person person : users){
            String role = (person instanceof Admin) ? "Admin" : "User";
            System.out.println(
                    "ID: " + person.getId() +
                            " | Name: " + person.getName() +
                            " | Email: " + person.getEmail() +
                            " | Role: " + role
            );
        }
    }


}
