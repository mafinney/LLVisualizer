/**
 * DraggableLabel is a custom JLabel that handles displaying the nodes
 * and making them draggable
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DraggableLabel extends JLabel {
    private Point mouseClickLocation;

    public DraggableLabel(String text) {
        super(text);

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
                    setLocation(currLocation.x + e.getX() - mouseClickLocation.x,
                                currLocation.y + e.getY() - mouseClickLocation.y);
                }
            }
        });
    }
}