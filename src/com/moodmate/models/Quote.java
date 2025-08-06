package com.moodmate.models;

import java.io.Serializable;

public class Quote implements Serializable {

    private String text;
    private String category;

    Quote(String t, String c) {
        text = t;
        category = c;
    }

    public String getText() {
        return text;
    }
    public String getCategory() {
        return category;
    }
}
