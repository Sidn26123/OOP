package main;
import LoginSignup.View.Login;
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
        });
    }
}
