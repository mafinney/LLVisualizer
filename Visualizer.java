import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizer {
    static DraggableNode head;
    static DraggableNode curr;
    public static void main(String[] args) {
        head = new DraggableNode("Head", null);
        curr = head;

        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(600, 400));

        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 30);
        JButton clearScreen = new JButton("Clear screen");
        clearScreen.setBounds(0, 0, 150, 30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNode);
        buttonPanel.add(clearScreen);
        frame.add(buttonPanel, BorderLayout.NORTH);

        DynamicLinePanel lineLayer = new DynamicLinePanel();
        frame.add(lineLayer, BorderLayout.CENTER);
        lineLayer.addNode(head);

        addNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = (String) JOptionPane.showInputDialog(frame, "Value of node:");
                DraggableNode newNode = new DraggableNode(userInput, null);
                curr.addNext(newNode);
                lineLayer.addNode(newNode);
                frame.revalidate();
                frame.repaint();
            }
        });

        clearScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lineLayer.clear();
                frame.repaint();
                lineLayer.addNode(head);
                curr = head;
                frame.repaint();
            }
        });

        frame.repaint();
        frame.setVisible(true);
    }
}

/**
 * Ayu Darkvenom
 * Calm Darkvenom
 * Gruvbox Concoctis Dark
 * Lunar
 * One Dark Pro No Italic
 * Rose Noctis
 * Slime
 * Slime Extra Dark
 * Stellar
 * Sweet Dark
 * Sweet Dark Bold
 * Tomorrow Night
 * Zenith
 */