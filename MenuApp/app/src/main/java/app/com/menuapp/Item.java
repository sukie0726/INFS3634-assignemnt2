package app.com.menuapp;

import java.io.Serializable;

public class Item implements Serializable{
    public String name;
    public String description;
    public double price;
    public int number;
    public int imageId;

    public Item(String name, double price, String description, int imageId) {
        this.name = name;
        this.price = price;
        this.description = description;
        number = 1;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return price * number;
    }
}
