import java.awt.*;
import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame window = new JFrame("Testing window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(600, 400);
        window.setVisible(true);

        DynamicLinePanel panel = new DynamicLinePanel();
        panel.setBackground(Color.BLACK);

        window.add(panel);
    }
}