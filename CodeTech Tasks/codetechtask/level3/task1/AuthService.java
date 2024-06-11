package codetechtask.level3.task1;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> users = new HashMap<>();

    public User register(String username, String password, String name, String email) {
        User user = new User(username, password, name, email);
        users.put(username, user);
        return user;
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
