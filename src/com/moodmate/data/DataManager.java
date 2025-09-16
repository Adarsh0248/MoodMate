package com.moodmate.data;

import com.moodmate.models.Admin;
import com.moodmate.models.Person;
import com.moodmate.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager{
    private static final String FILE_PATH = "users.dat";

    public static void saveUsers(List<Person> users){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(users);
            System.out.println("USER DATA SAVED SUCCESSFULLY ✅");
        }
        catch(IOException e){
            System.err.println("Error While Saving Users to File ⚠️ :"+e);
        }
    }

    public static List<Person> loadUsers() {
        List<Person> users;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            users=(List<Person>) ois.readObject();
        }
        catch( EOFException E){
            Admin defaultAdmin1 = new Admin(1,"Aman","aman@gmail.com","Aman@123");
            Admin defaultAdmin2 = new Admin(2,"Adarsh","adarsh@gmail.com","Adarsh@123");
            Admin defaultAdmin3 = new Admin(3,"Admin","admin@moodmate.com","admin123");
            users= new ArrayList<>();
            users.add(defaultAdmin1);
            users.add(defaultAdmin2);
            users.add(defaultAdmin3);
            return users;
        }
        catch (FileNotFoundException e){
            Admin defaultAdmin1 = new Admin(1,"Aman","aman@gmail.com","Aman@123");
            Admin defaultAdmin2 = new Admin(2,"Adarsh","adarsh@gmail.com","Adarsh@123");
            Admin defaultAdmin3 = new Admin(3,"Admin","admin@moodmate.com","admin123");
            users= new ArrayList<>();
            users.add(defaultAdmin1);
            users.add(defaultAdmin2);
            users.add(defaultAdmin3);
            return users;
        }
        catch(IOException | ClassNotFoundException e){
            System.err.println("Error loading user data: " + e);
            return new ArrayList<>();
        }
        return users;
    }
}
