package codetechtask.level2.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductDialog extends JDialog {
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private boolean succeeded;
    private Product product;

    public ProductDialog(Frame parent, String title) {
        this(parent, title, null);
    }

    public ProductDialog(Frame parent, String title, Product product) {
        super(parent, title, true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.product = product;
        succeeded = false;

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(20);
        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(20);

        if (product != null) {
            nameField.setText(product.getName());
            quantityField.setText(String.valueOf(product.getQuantity()));
            priceField.setText(String.valueOf(product.getPrice()));
        }

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    succeeded = true;
                    dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
        
        gbc.gridx = 1;
        add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(quantityLabel, gbc);
        
        gbc.gridx = 1;
        add(quantityField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(priceLabel, gbc);
        
        gbc.gridx = 1;
        add(priceField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(okButton, gbc);
        
        gbc.gridx = 1;
        add(cancelButton, gbc);

        pack();
        setLocationRelativeTo(parent);
    }

    private boolean validateFields() {
        String name = nameField.getText();
        String quantityText = quantityField.getText();
        String priceText = priceField.getText();

        if (name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);

            if (product == null) {
                product = new Product(name, quantity, price);
            } else {
                product = new Product(name, quantity, price); // Here, you should update the existing product instead of creating a new one
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity or price format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public Product getProduct() {
        return product;
    }
}
