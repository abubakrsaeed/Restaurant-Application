package GUI;

import Project2.Order;
import Project2.Product;
import Project2.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderPanelTop extends JPanel {
    private DefaultTableModel table;

    private Order Order = new Order();

    private Restaurant restaurant;

    private JButton finalizeButton;

    public OrderPanelTop(OrderPanel pan, Restaurant restaurant) {
        this.restaurant = restaurant;
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Current Order"));
        Object[] columnNames = { "Product Name", "Count", "Price" };
        this.table = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(this.table);
        JScrollPane rightScrollPane = new JScrollPane(table);
        add(rightScrollPane);
        JPanel Panel = new JPanel(new FlowLayout(2));
        this.finalizeButton = new JButton("Finalize");
        this.finalizeButton.setEnabled(false);
        Panel.add(this.finalizeButton);
        add(Panel, "South");
        this.finalizeButton.addActionListener(e -> {

            PopupDiaglog.showInfo("Your order is completed.\nTotal price is " + (this.Order.calculateTotalPrice()));
            pan.clearPanel();
        });
    }

    public void addProduct(Product selectedItem, int count) {
        this.finalizeButton.setEnabled(true);
        for (int i = 0; i < count; i++)
            this.Order.addProduct(selectedItem);
        Object[] rowData = {selectedItem.getName(), (new StringBuilder(String.valueOf(count))).toString(),
                (new StringBuilder(String.valueOf(selectedItem.getSellingPrice() * count))).toString()};
        this.table.addRow(rowData);
    }
}
