import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * TODO:
 * Redo DraggableLabel as a "dual class" including the JLabel attributes and
 * a Node object built in. Include a method to draw a line from the object to 
 * the object it points to as next
 */

class DraggableLabel extends JLabel {
    private Point mouseActionLocation;

    public DraggableLabel(String text, Color color) {
        super(text);
        this.setBounds(50, 50, 100, 30);
        this.setBorder(BorderFactory.createLineBorder(color));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseActionLocation = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mouseActionLocation != null) {
                    Point currLocation = getLocation();
                    setLocation(currLocation.x + e.getX() - mouseActionLocation.x,
                                currLocation.y + e.getY() - mouseActionLocation.y);
                }
            }
        });
    }
}