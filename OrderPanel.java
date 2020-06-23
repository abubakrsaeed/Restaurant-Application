package GUI;

import Project2.Product;
import Project2.Restaurant;
import Project2.Waiter;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel{

    private Restaurant restaurant;
    private OrderPanelBottom panelBottom;
    private OrderPanelTop panelTop;
    JButton OrderButton;

    public OrderPanel(Restaurant restaurant) {
        this.OrderButton = new JButton("New Order");
        this.restaurant = restaurant;
        this.add(this.OrderButton);
        this.OrderButton.addActionListener(e -> this.OrderAppear());
    }

    private Object OrderAppear() {
        this.removeAll();
        this.repaint();
        this.setLayout(new BoxLayout(this, 1));
        JPanel container= new JPanel(new BorderLayout());
        container.add(this.panelBottom=new OrderPanelBottom(this, this.restaurant));
        this.add(this.panelTop=new OrderPanelTop(this, this.restaurant));
        this.add(container);
        Waiter waiter = this.restaurant.assignWaiter();
        showInfoDialog("Hi, I am " + waiter.getName() + ".\n What would you like to order?");
        return null;
    }
    public static void showInfoDialog(final String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Info", 1);
    }

    public void addProduct(final Product selectedItem, final int count) {
        this.panelTop.addProduct(selectedItem, count);
    }
        public void clearPanel(){
            removeAll();
            setLayout(new FlowLayout());
            add(this.OrderButton);
            repaint();
        }
    }