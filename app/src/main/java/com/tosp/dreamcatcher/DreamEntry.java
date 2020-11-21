package com.tosp.dreamcatcher;

enum Mood{ bad, neutral, good}

public class DreamEntry {


    public DreamEntry() {
    }

    public DreamEntry(String title, String text, Mood mood) {
        this.title = title;
        this.text = text;
        this.mood = mood;
    }


    public boolean isTitleEmpty() {
        return title.isEmpty();
    }

    public boolean isTextEmpty() {
        return text.isEmpty();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    private String title;
    private String text;
    private Mood mood;





}
