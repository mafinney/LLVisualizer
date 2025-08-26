import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizer {
    public static void main(String[] args) {
        DraggableNode Child1 = new DraggableNode("Child1", null);
        DraggableNode Child2 = new DraggableNode("Child2", null);
        ArrayList<DraggableNode> tmp = new ArrayList<>();
        tmp.add(Child1);
        tmp.add(Child2);
        DraggableNode Parent = new DraggableNode("Parent", null);
        Parent.addNextList(tmp);

        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(600, 400));

        DynamicLinePanel lineLayer = new DynamicLinePanel();
        frame.add(lineLayer, BorderLayout.CENTER);

        lineLayer.addNode(Parent);
        lineLayer.addNode(Child1);
        lineLayer.addNode(Child2);

        frame.repaint();
        frame.setVisible(true);
    }
}   