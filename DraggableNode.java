/**
 * DraggableLabel is a custom JLabel class that handles displaying the nodes
 * and making them draggable
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class DraggableNode extends JPanel {
    final static int ROWS = 1;
    final static int COLS = 2;

    final static int WIDTH = 100;
    final static int HEIGHT = 30;
    final static double LINE_OFFSET_X = ((double) WIDTH) * (3.0 / 4.0);
    final static double LINE_OFFSET_Y = ((double) HEIGHT) / 2.0;

    String value;
    DraggableNode next;
    JLabel valueBox;
    JLabel nextBox;
    Point mouseClickLocation;

    public DraggableNode(String value, DraggableNode next) {
        super();
        setLayout(new GridLayout(ROWS, COLS));
        setBounds(0, 0, WIDTH, HEIGHT);

        this.value = value;
        this.next = next;
        valueBox = new JLabel(value, SwingConstants.CENTER);
        nextBox = new JLabel("•", SwingConstants.CENTER);
        valueBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nextBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(valueBox);
        add(nextBox);

        revalidate();
        repaint();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseClickLocation = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mouseClickLocation != null) {
                    Point currLocation = getLocation();
                    // New location is current location + mouse location - original mouse click location
                    Point newLocation = new Point(currLocation.x + e.getX() - mouseClickLocation.x,
                                                  currLocation.y + e.getY() - mouseClickLocation.y);
                    Dimension parentBounds = getParent().getSize();
                    
                    if (inBounds(newLocation, parentBounds)) {
                        setLocation(newLocation);
                    }
                }
            }
        });
    }

    // Check if the location given is within the bounds given (and not negative)
    private boolean inBounds(Point location, Dimension bounds) {
        if (location.x < 0 || location.y < 0) {
            return false;
        }
        if (location.x > (bounds.getWidth() - WIDTH) || location.y > (bounds.getHeight() - HEIGHT)) {
            return false;
        }
        return true;
    }

    public Point getNextPoint() {
        return new Point(getLocation().x + (int) LINE_OFFSET_X, getLocation().y + (int) LINE_OFFSET_Y);
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
        String str = getValue();
        DraggableNode temp = getNext();
        while (temp != null) {
            str += " -> " + temp.getValue();
            temp = temp.getNext();
        }
        return str;
    }
}