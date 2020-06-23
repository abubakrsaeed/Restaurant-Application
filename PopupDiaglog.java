package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopupDiaglog {
    
    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(new JFrame(),
                message,
                "Info",
                1);
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(new JFrame(),
                message,
                "Error",
                0);
    }

}