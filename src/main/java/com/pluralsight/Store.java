package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        Collections.sort(inventory);

        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/products.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {

                    String skuString = parts[0].trim();
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);

                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return inventory;
    }
}
