package codetechtask.level2.task2;

abstract class Item {
    private int id;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Item(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Category: " + category + ", Available: " + available;
    }
}

class Book extends Item {
    public Book(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public String getType() {
        return "Book";
    }
}

class Magazine extends Item {
    public Magazine(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public String getType() {
        return "Magazine";
    }
}

class DVD extends Item {
    public DVD(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public String getType() {
        return "DVD";
    }
}
