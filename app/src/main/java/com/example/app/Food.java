package com.example.app;

public class Food {
    private String name, description;
    private int resourceIdPicture, price, id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResourceIdPicture() {
        return resourceIdPicture;
    }

    public void setResourceIdPicture(int resourceIdPicture) {
        this.resourceIdPicture = resourceIdPicture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Food(String name, String description, int resourceIdPicture, int price) {
        this.name = name;
        this.description = description;
        this.resourceIdPicture = resourceIdPicture;
        this.price = price;
    }

    public Food () {}
}
