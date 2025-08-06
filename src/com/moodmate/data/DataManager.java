package com.moodmate.data;

import com.moodmate.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager{
    private static final String FILE_PATH = "users.dat";

    public static void saveUsers(List<User> users){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(users);
            System.out.println("USER DATA SAVED SUCCESSFULLY ✅");
        }
        catch(IOException e){
            System.err.println("Error While Saving Users to File ⚠️ :"+e);
        }
    }

    public static List<User> loadUsers() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            return (List<User>) ois.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("No existing user data found. Starting fresh.");
            return new ArrayList<>();
        }
        catch(IOException | ClassNotFoundException e){
            System.err.println("Error loading user data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
