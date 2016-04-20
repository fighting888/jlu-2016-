package SeventhQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

/**
 * Created by PurpleWall on 2016/4/13.
 */
public class stackPanel extends JPanel {

    private static final double height = 60;

    private static final double width = 200;

    java.util.List<Double> list = new ArrayList<>();

    private double length = 400;

    public stackPanel() {
        setVisible(true);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 15));

        graphics2D.setStroke(new BasicStroke(3f));

        double len = length;
        for (int i = 0;i < list.size(); ++i) {
            len = len - 60;

            if (i %2 == 0) {
                graphics2D.setPaint(Color.ORANGE);
            } else {
                graphics2D.setPaint(Color.red);
            }
            Rectangle2D rectangle2D = new Rectangle2D.Double(80, len, width, height);
            graphics2D.fill(rectangle2D);
            graphics2D.setPaint(Color.black);
            graphics2D.drawString(String.valueOf(list.get(i)), 170, (int)len+40);
        }
    }

    public void pushStack(double x) {
        this.list.add(x);
        this.repaint();
    }

    public void popStack() {
        this.list.remove(this.list.size()-1);
        this.repaint();
    }
}
