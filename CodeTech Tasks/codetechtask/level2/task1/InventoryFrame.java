package codetechtask.level2.task1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Product> products;
    private static final String FILE_NAME = "products.dat";

    public InventoryFrame() {
        setTitle("Inventory Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        products = loadProducts();
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price"}, 0);
        table = new JTable(tableModel);
        refreshTable();

        JButton addButton = new JButton("Add Product");
        JButton editButton = new JButton("Edit Product");
        JButton deleteButton = new JButton("Delete Product");
        JButton lowStockButton = new JButton("Low Stock Report");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProduct();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });

        lowStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateLowStockReport();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(lowStockButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addProduct() {
        ProductDialog dialog = new ProductDialog(this, "Add Product");
        dialog.setVisible(true);
        if (dialog.isSucceeded()) {
            Product product = dialog.getProduct();
            products.add(product);
            saveProducts();
            refreshTable();
        }
    }

    private void editProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int productId = (int) tableModel.getValueAt(selectedRow, 0);
            Product product = findProductById(productId);
            if (product != null) {
                ProductDialog dialog = new ProductDialog(this, "Edit Product", product);
                dialog.setVisible(true);
                if (dialog.isSucceeded()) {
                    saveProducts();
                    refreshTable();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int productId = (int) tableModel.getValueAt(selectedRow, 0);
            products.removeIf(product -> product.getId() == productId);
            saveProducts();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void generateLowStockReport() {
        StringBuilder report = new StringBuilder("Low Stock Products:\n");
        for (Product product : products) {
            if (product.getQuantity() < 5) {
                report.append(product).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, report.toString(), "Low Stock Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Product product : products) {
            tableModel.addRow(new Object[]{product.getId(), product.getName(), product.getQuantity(), product.getPrice()});
        }
    }

    private List<Product> loadProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
