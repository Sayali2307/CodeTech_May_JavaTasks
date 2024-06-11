package codetechtask.level2.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);
        
        gbc.gridx = 1;
        add(usernameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        add(passwordField, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple authentication logic (in a real-world application, use a database)
        if ("admin".equals(username) && "password".equals(password)) {
            InventoryFrame inventoryFrame = new InventoryFrame();
            inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            inventoryFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
