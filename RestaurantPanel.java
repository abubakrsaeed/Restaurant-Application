package GUI;

import Project2.Restaurant;
import javax.swing.*;

public class RestaurantPanel extends JPanel {
    private Restaurant restaurant;

    private RestaurantPanelBottom bottomPanel;

    public RestaurantPanel(Restaurant restaurant) {
        this.restaurant = restaurant;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton listEmployeesButton = new JButton("List Employees");
        JButton addCookButton = new JButton("Add Cook");
        JButton addWaiterButton = new JButton("Add Waiter");
        JButton calculateExpenses = new JButton("Calculate Expenses");
        JPanel addButton = new JPanel();
        addButton.add(listEmployeesButton);
        addButton.add(addCookButton);
        addButton.add(addWaiterButton);
        addButton.add(calculateExpenses);
        add(addButton);
        this.bottomPanel = new RestaurantPanelBottom(restaurant);
        add(this.bottomPanel);
        listEmployeesButton.addActionListener(e ->
                this.bottomPanel.showListEmployeesPanel());

        addCookButton.addActionListener(e ->
                this.bottomPanel.showAddCookPanel());

        addWaiterButton.addActionListener(e ->
                this.bottomPanel.showAddWaiterPanel());

        calculateExpenses.addActionListener(e ->
                this.bottomPanel.showCalculateExpensesPanel());
    }
}
