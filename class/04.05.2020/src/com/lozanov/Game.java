package com.lozanov;

public class Game {
    private String id;
    private String title;
    private String[] features;
    private float price;

    public Game(String id, String title, String[] features, float price) {
        this.id = id;
        this.title = title;
        this.features = features;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String[] getFeatures() {
        return features;
    }

    public float getPrice() {
        return price;
    }
}
