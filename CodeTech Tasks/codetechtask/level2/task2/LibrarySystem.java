package codetechtask.level2.task2;

import java.util.Scanner;

public class LibrarySystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Librarian Login");
            System.out.println("2. Patron Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    librarianMenu();
                    break;
                case 2:
                    patronMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void librarianMenu() {
        while (true) {
            System.out.println("Librarian Menu");
            System.out.println("1. Add New Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Items");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    library.viewAllItems();
                    break;
                case 3:
                    searchItems();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void patronMenu() {
        while (true) {
            System.out.println("Patron Menu");
            System.out.println("1. View All Items");
            System.out.println("2. Search Items");
            System.out.println("3. Check Out Item");
            System.out.println("4. Return Item");
            System.out.println("5. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    library.viewAllItems();
                    break;
                case 2:
                    searchItems();
                    break;
                case 3:
                    checkOutItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addItem() {
        System.out.println("Enter item type (book/magazine/dvd): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();

        switch (type) {
            case "book":
                library.addItem(new Book(title, author, category));
                break;
            case "magazine":
                library.addItem(new Magazine(title, author, category));
                break;
            case "dvd":
                library.addItem(new DVD(title, author, category));
                break;
            default:
                System.out.println("Invalid item type.");
        }
    }

    private static void searchItems() {
        System.out.println("Enter search query (title/author/category): ");
        String query = scanner.nextLine();
        library.searchItems(query);
    }

    private static void checkOutItem() {
        System.out.println("Enter item ID to check out: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        library.checkOutItem(itemId);
    }

    private static void returnItem() {
        System.out.println("Enter item ID to return: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        library.returnItem(itemId);
    }
}
