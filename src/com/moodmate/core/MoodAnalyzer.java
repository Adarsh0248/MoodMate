package com.moodmate.core;

import java.util.HashMap;
import java.util.Map;

public class MoodAnalyzer {
    private final Map<String, String> keyAndSuggestions;

    public MoodAnalyzer() {
        keyAndSuggestions = new HashMap<>();
        addSuggestionWithKeyword();
    }

    private void addSuggestionWithKeyword() {
        keyAndSuggestions.put("tired","Get some rest Buddy !💤");
    }

    public String analyzeMood( String notes) {
        notes=notes.toLowerCase();
        String[] keywords = notes.split(" ");
        for(String keyword : keywords) {
            if(!keyword.equals("")){
                if(keyAndSuggestions.containsKey(keyword)) return keyAndSuggestions.get(keyword);
            }
        }
        return "Give your best as possible... !";
    }
}
