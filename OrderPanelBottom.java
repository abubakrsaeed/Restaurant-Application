package GUI;
import Project2.Product;
import Project2.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderPanelBottom extends JPanel {
    public OrderPanelBottom(OrderPanel parent, Restaurant restaurant) {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);
        setBorder(BorderFactory.createTitledBorder("Add Product"));
        JLabel selectLabel = new JLabel("Product :");
        add(selectLabel);

        JComboBox<Product> productComboBox = new JComboBox<>();
        productComboBox.setMaximumSize(new Dimension(200, 30));
        productComboBox.addItem(null);

        for (Product product : restaurant.getProducts())
            productComboBox.addItem(product);
        add(productComboBox);

        JLabel countLabel = new JLabel("Count :");
        add(countLabel);

        JSpinner countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        countSpinner.setEnabled(false);

        ((JSpinner.DefaultEditor)countSpinner.getEditor()).getTextField().setEditable(false);
        add(countSpinner);

        JLabel priceLabel = new JLabel("Price :");
        add(priceLabel);

        JLabel priceValueLabel = new JLabel();
        add(priceValueLabel);

        JButton addProductButton = new JButton("Add");
        addProductButton.setEnabled(false);
        add(addProductButton);

        List<JComponent> comboBoxEnableList = new ArrayList<>();
        comboBoxEnableList.add(countSpinner);
        comboBoxEnableList.add(addProductButton);

        productComboBox.addActionListener(e -> {
            Product selectedItem = (Product)productComboBox.getSelectedItem();
            comboBoxActionPerformed(selectedItem, comboBoxEnableList);
            countSpinner.setValue(Integer.valueOf(1));
            if (selectedItem != null) {
                double price = selectedItem.getSellingPrice();
                priceValueLabel.setText(String.valueOf(price));
            }
            });
        addProductButton.addActionListener(e -> {
            Product selectedItem = (Product)productComboBox.getSelectedItem();
            int count = ((Integer)countSpinner.getValue()).intValue();
            parent.addProduct(selectedItem, count);
        });
    }

    private void comboBoxActionPerformed(Product product, List<JComponent> comboBoxEnableList) {
        if (product == null) {
            comboBoxEnableList.forEach(c -> c.setEnabled(false));
        } else {
            comboBoxEnableList.forEach(c -> c.setEnabled(true));
        }
    }
}