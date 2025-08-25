import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Visualizer {
    static DraggableNode head;
    static DraggableNode curr;
    public static void main(String[] args) {
        // Node setup
        head = new DraggableNode("head", null);
        curr = head;

        // Frame setup
        JFrame frame = new JFrame("Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(600, 400));

        // Button setup
        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 30);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNode);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Line layer setup
        DynamicLinePanel lineLayer = new DynamicLinePanel(head);
        frame.add(lineLayer, BorderLayout.CENTER);

        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeValue = JOptionPane.showInputDialog(frame, "Value of node: ");
                DraggableNode newNode = new DraggableNode(nodeValue, null);
                newNode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lineLayer.add(newNode);

                curr.setNext(newNode);
                curr = newNode;

                frame.revalidate();
                frame.repaint();
                System.out.println(head);
            }
        });

        frame.setVisible(true);
    }
}