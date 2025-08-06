package com.moodmate.models;

import java.time.LocalDate;

public class Habit {
    private String habitName;
    private LocalDate startDate;
    private int daysCompleted;
    private int streak;
    private LocalDate lastCompletionDate;

    public Habit(String habitName) {
        this.habitName = habitName;
        this.startDate = LocalDate.now();
        daysCompleted = 0;
        streak = 0;
        lastCompletionDate = null;
    }
    public void markCompleted() {
        LocalDate today = LocalDate.now();
        if(lastCompletionDate==null) {
            lastCompletionDate = today;
            streak = 1;

        }
        else if(lastCompletionDate.equals(today)){
            return;
        }
        else if(lastCompletionDate.equals(today.minusDays(1))) {
            streak+=1;
            lastCompletionDate = today;

        }else{
            streak = 1;
            lastCompletionDate = today;
        }
        daysCompleted++;
    }

    public LocalDate getLastCompletionDate() {
        return lastCompletionDate;
    }

    public int getStreak() {
        return streak;
    }

    public int getDaysCompleted() {
        return daysCompleted;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getHabitName() {
        return habitName;
    }
}
