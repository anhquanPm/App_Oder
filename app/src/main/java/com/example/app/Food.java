package com.example.app;

public class Food {
    private String name, description, imageName;
    private int  price, id;

    public Food(String name, String description, String imageName, int price, int id) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
        this.id = id;
    }

    public Food(String name, String description, String imageName, int price) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
    }

    public Food() {
    }

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
}
