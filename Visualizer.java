import javax.swing.*;
import java.awt.*;

public class Visualizer {
    public static void main(String[] args) {
        JFrame window = new JFrame("Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        DraggableLabel label = new DraggableLabel("Label");
        label.setBounds(50, 50, 100, 30);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        window.add(label);
        window.setSize(400, 300);
        window.setVisible(true);
    }
}