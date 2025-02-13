package Day2_Collections.ShoppingCart;


import java.util.*;

class ShoppingCart {
    private HashMap<String, Double> productPrices; // Store product prices
    private LinkedHashMap<String, Integer> cart; // Maintain order of items added
    private TreeMap<String, Double> sortedByPrice; // Sort items by price

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
        sortedByPrice = new TreeMap<>(
                (item1, item2) -> {
                    int priceComparison = Double.compare(productPrices.get(item1), productPrices.get(item2));
                    return (priceComparison != 0) ? priceComparison : item1.compareTo(item2);
                }
        );
    }

    // Add product to catalog
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
        updateSortedByPrice();
    }

    // Add item to cart
    public void addItem(String name, int quantity) {
        if (productPrices.containsKey(name)) {
            cart.put(name, cart.getOrDefault(name, 0) + quantity);
            updateSortedByPrice();
        } else {
            System.out.println("Product not found in catalog.");
        }
    }

    // Update sortedByPrice after every modification
    private void updateSortedByPrice() {
        sortedByPrice.clear();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedByPrice.put(entry.getKey(), entry.getValue());
        }
    }

    // Display cart items in the order they were added
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        System.out.println("Items Sorted by Price:");
        for (Map.Entry<String, Double> entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getKey() + " - Price: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 75000);
        cart.addProduct("Mouse", 1500);
        cart.addProduct("Keyboard", 2500);
        cart.addProduct("Monitor", 10000);
        cart.addProduct("CPU", 10000); // New item with same price as Monitor

        cart.addItem("Laptop", 1);
        cart.addItem("Mouse", 2);
        cart.addItem("Keyboard", 1);
        cart.addItem("Monitor", 1);
        cart.addItem("CPU", 1);

        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
