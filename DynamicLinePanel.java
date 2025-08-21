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
    DraggableNode head;
    public DynamicLinePanel(DraggableNode head) {
        super();
        this.head = head;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DraggableNode curr = head.getNext();
        DraggableNode next = curr.getNext();

        while (next != null) {
            g.drawLine(curr.getLocation().x, curr.getLocation().y, next.getLocation().x, next.getLocation().y);
            curr = next;
            next = next.getNext();
        }
        repaint();
    }
}