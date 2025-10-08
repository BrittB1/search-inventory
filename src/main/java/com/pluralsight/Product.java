package com.pluralsight;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}
