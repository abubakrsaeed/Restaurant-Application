package GUI;

import Project2.Restaurant;

import javax.swing.*;
import java.awt.*;

public class Gui {

    public static void main(String[] args) {

        //Just to make the GUI look a little better.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        final Restaurant restaurant = new Restaurant();
        final JFrame frame = new JFrame("Project");
        frame.setDefaultCloseOperation(3);
        frame.setSize(650, 500);
        frame.setMinimumSize(new Dimension(650, 500));

        final JTabbedPane tabbedPane = new JTabbedPane();

        final JPanel orderPanel = new OrderPanel(restaurant);
        tabbedPane.add("Order", orderPanel);

        final JPanel restaurantPanel = new RestaurantPanel(restaurant);
        tabbedPane.add("Restaurant", restaurantPanel);


        frame.add(tabbedPane);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
