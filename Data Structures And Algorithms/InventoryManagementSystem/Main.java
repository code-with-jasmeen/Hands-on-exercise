package InventoryManagementSystem;

import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " | " + productName + " | " + quantity + " | " + price;
    }
}

class InventorySystem {

    HashMap<Integer, Product> inventory = new HashMap<>();

    // ADD product
    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Added: " + p.productName);
    }

    // UPDATE product
    public void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Updated: " + p.productName);
        } else {
            System.out.println("Product not found");
        }
    }

    // DELETE product
    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Deleted product ID: " + id);
        } else {
            System.out.println("Product not found");
        }
    }

    // DISPLAY all products
    public void displayProducts() {
        System.out.println("\n--- Inventory List ---");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

public class Main
{
    public static void main(String[] args) {

        InventorySystem system = new InventorySystem();

        // Adding products
        system.addProduct(new Product(1, "Laptop", 10, 50000));
        system.addProduct(new Product(2, "Mouse", 50, 500));
        system.addProduct(new Product(3, "Keyboard", 30, 1200));

        // Update product
        system.updateProduct(1, 8, 48000);

        // Delete product
        system.deleteProduct(2);

        // Display inventory
        system.displayProducts();
    }
}
