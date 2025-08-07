package com.moodmate.models;

import java.io.Serializable;
import java.time.LocalDate;

public class MoodLog implements Serializable {
    private LocalDate date;
    private String mood;
    private String notes;

    public MoodLog( String mood, String notes) {
        this.date = LocalDate.now();
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
