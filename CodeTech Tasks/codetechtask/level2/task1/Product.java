package codetechtask.level2.task1;

import java.io.Serializable;

public class Product implements Serializable {
    private static int counter = 1;
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.id = counter++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }
}
