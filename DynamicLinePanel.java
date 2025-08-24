/**
 * DynamicLine is a custom JPanel class that handles drawing lines between
 * the proper node objects dynamically as the nodes are dragged
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
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            DraggableNode curr = head.getNext();
            DraggableNode next = curr.getNext();

            while (next != null) {
                g.drawLine(curr.getLocation().x, curr.getLocation().y, next.getLocation().x, next.getLocation().y);
                curr = next;
                next = next.getNext();
            }
            repaint();
        } catch (NullPointerException e) {}
    }
}