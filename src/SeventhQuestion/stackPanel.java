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

    private static final double height = 20;

    private static final double width = 100;

    java.util.List<Integer> list = new ArrayList<>();

    private double length = 300;

    public stackPanel() {
        setVisible(true);
        list.add(50);
        list.add(222);
        list.add(3);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 10));

        graphics2D.setStroke(new BasicStroke(3f));

        for (int i = 0;i < list.size(); ++i) {
            length = length - 20;
            Rectangle2D rectangle2D = new Rectangle2D.Double(20, length, width, height);
            graphics2D.draw(rectangle2D);
            graphics2D.drawString(String.valueOf(list.get(i)), 60, (int)length);
        }
    }

    public void setList(int x) {
        this.list.add(x);
    }
}
