/**
 * DynamicLinePanel handles drawing lines between connected DraggableNodes
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class DynamicLinePanel extends JPanel {
    ArrayList<DraggableNode> nodes;
    ArrayList<Line> lines;

    public DynamicLinePanel() {
        super();
        setOpaque(false);
        setLayout(null);
        nodes = new ArrayList<>();
        lines = new ArrayList<>();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (DraggableNode node : nodes) {
            ArrayList<DraggableNode> nextList = node.getNextList();
            for (DraggableNode next : nextList) {
                g.drawLine(node.getNextPoint().x, node.getNextPoint().y, next.getNextPoint().x, next.getNextPoint().y);
                lines.add(new Line(node.getNextPoint(), next.getNextPoint()));
            }
        }

        repaint();
    }
    
    public void addNode(DraggableNode node) {
        add(node);
        nodes.add(node);

        repaint();
    }

    public void clear() {
        for (DraggableNode node : nodes) {
            node.clearNextList();
        }
        nodes.clear();
        lines.clear();
        removeAll();
        repaint();
    }
}

class Line {
    private Point src;
    private Point dest;

    public Line(Point src, Point dest) {
        this.src = src;
        this.dest = dest;
    }

    public boolean isComplete() {
        if (src == null || dest == null) {
            return false;
        }
        return true;
    }

    public Point getSrc() {
        return src;
    }

    public Point getDest() {
        return dest;
    }

    public void setSrc(Point point) {
        src = point;
    }

    public void setDest(Point point) {
        dest = point;
    }
}