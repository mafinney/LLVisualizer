import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        JButton clearScreen = new JButton("Clear screen");
        clearScreen.setBounds(150, 0, 150, 20);
        window.add(clearScreen);

        addNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // add node action
                System.out.println("add");
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