import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                // add node action
                String userInput = (String) JOptionPane.showInputDialog(window, "Value of node: ");
                DraggableLabel newNode = new DraggableLabel(userInput, Color.BLACK);
                window.add(newNode);
                window.repaint();
            }
        });

        clearScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clear screen action
                System.out.println("clear");
            }
        });
    }
}