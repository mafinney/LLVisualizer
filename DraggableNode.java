/**
 * DraggableNode stores a value and pointers to the other DraggableNodes and handles display / drag
 * 
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class DraggableNode extends JPanel {
    // Visual consts
    final static int ROWS = 1;
    final static int COLS = 2;
    
    final static int WIDTH = 100;
    final static int HEIGHT = 30;
    final static int LINE_OFFSET_X = (int) ((double) WIDTH * (3.0 / 4.0));
    final static int LINE_OFFSET_Y = (int) ((double) HEIGHT / 2.0);

    // Node fields
    private String value;
    private ArrayList<DraggableNode> nextPointers;
    
    // Visual fields
    private JLabel valueBox;
    private JLabel nextBox;
    private Point mouseClickLocation;

    // Handles value & list of nexts or null next
    public DraggableNode(String valueInput, DraggableNode next) {
        super();
        setLayout(new GridLayout(ROWS, COLS));
        setBounds(0, 0, WIDTH, HEIGHT);

        value = valueInput;
        nextPointers = new ArrayList<>();
        if (next != null) {
            nextPointers.add(next);
        }

        valueBox = new JLabel(value, SwingConstants.CENTER);
        valueBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nextBox = new JLabel("•", SwingConstants.CENTER);
        nextBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(valueBox);
        add(nextBox);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mouseClickLocation = e.getPoint();
                } else {
                    mouseClickLocation = null;
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mouseClickLocation != null) {
                    Point currLocation = getLocation();
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

    private boolean inBounds(Point location, Dimension bounds) {
        if (location.x < 0 || location.y < 0) {
            return false;
        } else if (location.x > (bounds.getWidth() - WIDTH) || location.y > (bounds.getHeight() - HEIGHT)) {
            return false;
        } else {
            return true;
        }
    }

    // Returns the point coords of the center of the next label
    public Point getNextPoint() {
        return new Point(getLocation().x + LINE_OFFSET_X, getLocation().y + LINE_OFFSET_Y);
    }

    // Returns the list of next pointers
    public ArrayList<DraggableNode> getNextList() {
        return nextPointers;
    }

    // Add a list of next pointers to the list
    public void addNextList(ArrayList<DraggableNode> nextList) {
        nextPointers.addAll(nextList);
    }

    // Add a single next pointer
    public void addNext(DraggableNode next) {
        nextPointers.add(next);
    }
}