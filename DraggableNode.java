/**
 * DraggableLabel is a custom JLabel class that handles displaying the nodes
 * and making them draggable
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DraggableNode extends JLabel {
    private String value;
    private DraggableNode next;

    private Point mouseClickLocation;

    public DraggableNode(String text, DraggableNode next) {
        super(text);

        value = text;
        this.next = next;

        // Listens for mouse clicks over the label and stores the location
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickLocation = e.getPoint();
            }
        });

        // Listens for mouse drags and updates the labels location as a drag occurs
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mouseClickLocation != null) {
                    Point currLocation = getLocation();
                    setLocation(currLocation.x + e.getX(), currLocation.y + e.getY());
                }
            }
        });
    }

    public String getValue() {
        return value;
    }

    public DraggableNode getNext() {
        return next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(DraggableNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String str = this.getValue();
        DraggableNode temp = this.getNext();
        while (temp != null) {
            str += " -> " + temp.getValue();
            temp = temp.getNext();
        }
        return str;
    }
}