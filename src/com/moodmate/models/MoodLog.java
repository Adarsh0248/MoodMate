package com.moodmate.models;

import java.io.Serializable;
import java.time.LocalDate;

public class MoodLog implements Serializable {
    private LocalDate date;
    private String mood;
    private String notes;

    public MoodLog(LocalDate date, String mood, String notes) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }
    public String getMood() {
        return mood;
    }
    public String getNotes() {
        return notes;
    }

}
