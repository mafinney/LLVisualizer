import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizer {
    public static void main(String[] args) {
        // Window setup
        JFrame window = new JFrame("Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(600, 400);
        window.setVisible(true);

        // Button setup
        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 20);
        window.add(addNode);
        JButton clearScreen = new JButton("Clear screen");
        clearScreen.setBounds(150, 0, 150, 20);
        window.add(clearScreen);

        // Button ActionListeners
        addNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DraggableLabel newNode = new DraggableLabel("");
                newNode.setBounds(50, 50, 100, 30);
                newNode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                newNode.add(new JTextField("Value..."));
                window.add(newNode);
            }
        });

        clearScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // clear screen action
                System.out.println("clear");
            }
        });
    }
}