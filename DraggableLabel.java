import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DraggableLabel extends JLabel {
    private Point mouseActionLocation;

    public DraggableLabel(String text) {
        super(text);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseActionLocation = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
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