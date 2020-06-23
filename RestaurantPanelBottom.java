package GUI;

import Project2.*;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

public class RestaurantPanelBottom extends JPanel {
    private Restaurant restaurant;

    public RestaurantPanelBottom(Restaurant restaurant) {
        this.restaurant = restaurant;
        setLayout(new BorderLayout());
    }

    public void showListEmployeesPanel() {
        this.updateUI();
        List<Employee> employees = this.restaurant.getEmployees();
        JPanel panel = new JPanel(new GridLayout(employees.size() + 1, 3));
        JLabel label1 = new JLabel("ID");
        label1.setForeground(Color.red);
        panel.add(label1);
        JLabel label2 = new JLabel("Name");
        label2.setForeground(Color.red);
        panel.add(label2);
        JLabel label3 = new JLabel("Job");
        label3.setForeground(Color.red);
        panel.add(label3);
        for (Employee employee : employees) {
            panel.add(new JLabel((new StringBuilder(String.valueOf(employee.getId()))).toString()));
            panel.add(new JLabel(employee.getName()));
            panel.add(new JLabel((employee instanceof Project2.Cook) ? "Cook" : "Waiter"));
        }
        removeAll();
        add(panel, "North");
        revalidate();
    }

    public void showAddCookPanel() {
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        JTextField name = new JTextField();
        JFormattedTextField salary = new JFormattedTextField(NumberFormat.getNumberInstance());
        JButton addCookButton = new JButton("Add");
        panel.add(new JLabel("Name:"));
        panel.add(name);
        panel.add(new JLabel("Salary:"));
        panel.add(salary);
        panel.add(Box.createGlue());
        panel.add(addCookButton);
        addCookButton.addActionListener(e -> {
            if (name.getText() == null || name.getText().isEmpty()) {
                PopupDiaglog.showError("Error: Enter a name");
                return;
            }
            if (salary.getText().isEmpty()) {
                PopupDiaglog.showError("Error: Enter a salary");
                return;
            }
            String finSalary = salary.getText();
            boolean isParsable = false;
            while (isParsable == false) {
                try {
                    Double.parseDouble(salary.getText());
                } catch (NumberFormatException fr) {
                    char o = ',';
                    finSalary = finSalary.replace("" + o, "");
                }

                isParsable = true;
            }
            this.restaurant.addCook(name.getText(), Double.parseDouble(finSalary));
            PopupDiaglog.showInfo("Cook added successfuly");
        });
        removeAll();
        add(panel, "North");
        revalidate();
        repaint();
    }

    public void showAddWaiterPanel() {
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        JTextField name = new JTextField();
        JButton addWaiterButton = new JButton("Add");
        panel.add(new JLabel("Name:"));
        panel.add(name);
        panel.add(Box.createGlue());
        panel.add(addWaiterButton);
        addWaiterButton.addActionListener(e -> {
            if (name.getText() == null || name.getText().isEmpty()) {
                PopupDiaglog.showError("Error: Enter a name");
                return;
            }
            this.restaurant.addWaiter(name.getText());
            PopupDiaglog.showInfo("Waiter added successsfuly");
        });
        removeAll();
        add(panel, "North");
        revalidate();
        repaint();
    }

    public void showCalculateExpensesPanel() {
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        double expense = this.restaurant.calculateExpenses();
        double revenue = this.restaurant.calculateRevenue();
        double profit = revenue - expense;
        JLabel colorPr = new JLabel(String.valueOf(profit));
        if (profit < 0) {
            colorPr.setForeground(Color.red);
        } else if (profit > 0) {
            colorPr.setForeground(Color.green);
        }

        panel.add(new JLabel("Expenses:"));
        panel.add(new JLabel(String.valueOf(expense)));
        panel.add(new JLabel("Revenue:"));
        panel.add(new JLabel(String.valueOf(revenue)));
        panel.add(new JLabel("Profit:"));
        panel.add(colorPr);

        removeAll();
        add(panel, "North");
        revalidate();
        repaint();
    }
}
