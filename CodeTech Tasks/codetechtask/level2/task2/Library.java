package codetechtask.level2.task2;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private static int itemCounter = 1;

    public void addItem(Item item) {
        item.setId(itemCounter++);
        items.add(item);
        System.out.println(item.getType() + " added successfully.");
    }

    public void viewAllItems() {
        System.out.println("All Items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void searchItems(String query) {
        System.out.println("Search Results:");
        for (Item item : items) {
            if (item.getTitle().contains(query) || item.getAuthor().contains(query) || item.getCategory().contains(query)) {
                System.out.println(item);
            }
        }
    }

    public void checkOutItem(int itemId) {
        Item item = findItemById(itemId);
        if (item != null && item.isAvailable()) {
            item.setAvailable(false);
            loans.add(new Loan(item));
            System.out.println(item.getType() + " checked out successfully.");
        } else {
            System.out.println("Item not available or not found.");
        }
    }

    public void returnItem(int itemId) {
        Item item = findItemById(itemId);
        if (item != null && !item.isAvailable()) {
            item.setAvailable(true);
            System.out.println(item.getType() + " returned successfully.");
        } else {
            System.out.println("Item not found or already returned.");
        }
    }

    private Item findItemById(int itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }
}
