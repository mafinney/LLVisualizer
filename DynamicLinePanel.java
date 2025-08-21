/**
 * DynamicLine is a custom JPanel that handles drawing lines between
 * the proper node objects dynamically as the nodes are dragged
 * 
 * TODO: make the line drawing dynamic to connect two nodes
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class DynamicLinePanel extends JPanel {
    ArrayList<DraggableNode> nodes;
    public DynamicLinePanel(DraggableNode head) {
        super();
        nodes = new ArrayList<>();
        nodes.add(head);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateNodeList();

        DraggableNode curr = nodes.get(0);
        DraggableNode next = nodes.get(1);

        for (int i = 2; next != null; i++) {
            g.drawLine(curr.getLocation().x, curr.getLocation().y, next.getLocation().x, next.getLocation().y);
            curr = next;
            next = nodes.get(i);
        }
        repaint();
    }

    private void updateNodeList() {
        DraggableNode head = nodes.get(0);
        DraggableNode curr = head.getNext();
        for (int i = 1; curr != null; i++) {
            nodes.add(i, curr);
            curr = curr.getNext();
        }
        nodes.add(null);
    }
}