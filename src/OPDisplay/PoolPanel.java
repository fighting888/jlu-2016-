package OPDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by PurpleWall on 2016/9/20.
 */
public class PoolPanel extends JPanel {

    private ArrayDeque<Data> queue = new ArrayDeque<>();

    private JButton createButton = ButtonFactory.getButtonFactory().makeButton(600, 20, 100, 100, "CREATE DATA");

    private JButton editButton = ButtonFactory.getButtonFactory().makeButton(600, 120, 100, 100, "EDIT BUTTON");



    public PoolPanel() {
        Data data = new Data(0, "test0");
        Data data1 = new Data(1, "test0");
        Data data2 = new Data(2, "test0");
        Data data3 = new Data(3, "test0");
        Data data4 = new Data(4, "test0");

        queue.addLast(data);
        queue.addLast(data1);
        queue.addLast(data2);
        queue.addLast(data3);
        queue.addLast(data4);

        add(createButton);
        add(editButton);

        setActionListener();
    }

    public void setActionListener() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.addLast(new Data(10, "test10"));
                repaint();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.getLast().setData(JOptionPane.showInputDialog(this, "input message:"));
                repaint();
            }
        });
    }



    @Override
    public void paint(Graphics g) {
        int cursor = 5;
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 15));

        graphics2D.setStroke(new BasicStroke(3f));

        for (Data data : queue) {
            Rectangle2D rectangle2D = new Rectangle2D.Double(cursor, 80, 80, 400);
            graphics2D.setPaint(Color.CYAN);
            graphics2D.fill(rectangle2D);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawString("dataID:" + String.valueOf(data.getDataId()) , cursor+10, 100);
            if (data.getData().length() > 4) {
                graphics2D.drawString("Content:" , cursor+10, 140);
                graphics2D.drawString(data.getData().substring(0, 5) , cursor+5 , 160);
            }

            cursor += 90;
        }
    }
}
