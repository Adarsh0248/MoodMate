package com.moodmate.core;

import com.moodmate.models.Quote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteManager {

    private List<Quote> quotes;

    public QuoteManager() {
        quotes = new ArrayList<>();
    }

    public void loadQuotesFromFile() {
        try( BufferedReader br= new BufferedReader(new FileReader("quotes.csv"))){
            String line;
            while((line=br.readLine())!=null){
                String[] parts = line.split(":");
                if(parts.length==2){
                    String text= parts[0];
                    String category= parts[1];

                    Quote newQuote= new Quote(text, category);
                    quotes.add(newQuote);
                }
            }
        }
        catch(IOException e){
            System.err.println("Error while loading Quotes: "+e.getMessage());
        }
    }

    public Quote getRandomQuote(String mood){
        List<Quote> quotesByMood = new ArrayList<>();
        for(Quote q: quotes){
            if(q.getCategory().equals(mood)) quotesByMood.add(q);
        }
        if(quotesByMood.isEmpty()) return new Quote("Keep going!", "motivational");
        else{
            Random random = new Random();
            int randomIndex = random.nextInt(quotesByMood.size());
            return quotesByMood.get(randomIndex);
        }
    }

    public void addQuote(Quote quote) {
        quotes.add(quote);


    }

    public void removeQuote(Quote quote) {
        quotes.remove(quote);
    }
}
