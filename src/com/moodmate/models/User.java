package com.moodmate.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {
    private List<Habit> habits;
    private List<MoodLog> moodLogs;
    public User(int id, String name, String email, String password){
        super(id,name,email,password);
        habits = new ArrayList<>();
        moodLogs = new ArrayList<>();
    }
    public User() {
        // This no-argument constructor is required for deserialization
    }

    @Override
    public void displayMenu() {
        System.out.println("1.Add a new Habit");
        System.out.println("2.Log today's Mood");
        System.out.println("3.View my Progress");
        System.out.println("4.LogOut");
    }
    public void addHabit(Habit habit){
        habits.add(habit);
    }
    public void logMood(MoodLog moodLog){
        moodLogs.add(moodLog);
    }

    public List<MoodLog> getMoodLogs() {
        return moodLogs;
    }

    public List<Habit> getHabits() {
        return habits;
    }
}
