package com.moodmate.models;

import java.io.Serializable;
import java.time.LocalDate;

public class MoodLog implements Serializable {
    private LocalDate date;
    private String mood;
    private String notes;

    MoodLog(LocalDate d, String m, String n) {
        date=d;
        mood=m;
        notes=n;
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
