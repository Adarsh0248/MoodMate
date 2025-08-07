package com.moodmate.models;

import java.io.Serializable;

public class Quote implements Serializable {

    private String text;
    private String category;

    public Quote(String text, String category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }
    public String getCategory() {
        return category;
    }
}
