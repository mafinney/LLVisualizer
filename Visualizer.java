import javax.swing.*;
import java.awt.*;

public class Visualizer {
    public static void main(String[] args) {
        JFrame window = new JFrame("Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(600, 400);
        window.setVisible(true);

        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 20);
        window.add(addNode);
        JButton removeNode = new JButton("Remove node");
        removeNode.setBounds(150, 0, 150, 20);
        window.add(removeNode);

        
    }
}