package codetechtask.level3.task1;

public class User {
    private String username;
    private String password; // Note: Passwords should be stored securely (hashed) in real applications
    private String name;
    private String email;

    // Constructors, getters, and setters
    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
