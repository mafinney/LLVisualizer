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
        setLayout(null);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            DraggableNode curr = head.getNext();
            DraggableNode next = curr.getNext();

            while (next != null) {
                g.drawLine(curr.getNextPoint().x, curr.getNextPoint().y, next.getNextPoint().x, next.getNextPoint().y);
                curr = next;
                next = next.getNext();
            }
            repaint();
        } catch (NullPointerException e) {}
    }
}