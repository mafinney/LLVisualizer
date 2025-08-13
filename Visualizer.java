import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Visualizer {
    static Node head;
    static Node curr;
    static Node next;

    public static void main(String[] args) {
        // Linkedlist setup
        next = new Node(null, null);
        curr = new Node(null, next);
        head = new Node("Head", curr);

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
                String userInput = (String) JOptionPane.showInputDialog(window, "Value of node: "); // get node value
                DraggableLabel newNode = new DraggableLabel(userInput, Color.BLACK); // create node visual

                curr.setValue(userInput);
                curr = next;
                next = new Node(null, null);
                curr.setNext(next);

                window.add(newNode);
                window.repaint();

                System.out.println(head);
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