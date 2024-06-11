package codetechtask.level2.task1;
import javax.swing.*;
import java.awt.*;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setVisible(true);
        });
    }
}
