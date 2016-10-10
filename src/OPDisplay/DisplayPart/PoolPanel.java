package OPDisplay.DisplayPart;

import OPDisplay.util.ButtonFactory;
import OPDisplay.util.Data;
import OPDisplay.util.Header;
import OPDisplay.util.JLableFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;

/**
 * Created by PurpleWall on 2016/9/20.
 */
public class PoolPanel extends JPanel {

    private ArrayDeque<Data> queue = new ArrayDeque<>();

    private JButton setBufferSize = ButtonFactory.getButtonFactory().makeButton(600, 20, 100, 100, "SET BUFFER");

    private JButton editButton = ButtonFactory.getButtonFactory().makeButton(600, 120, 100, 100, "TEST");

    public static int bufferSize = 3;

    private JLabel bufSize = JLableFactory.getjLableFactory().makeLable(600, 220, 15, "BUFFER SIZE :" + String.valueOf(bufferSize));

    public PoolPanel() {
//        Data data = new Data(0, "test0");
//        Data data1 = new Data(1, "test0");
//        Data data2 = new Data(2, "test0");
//        Data data3 = new Data(3, "test0");
//        Data data4 = new Data(4, "test0");
//
//        queue.addLast(data);
//        queue.addLast(data1);
//        queue.addLast(data2);
//        queue.addLast(data3);
//        queue.addLast(data4);

        add(setBufferSize);
        add(editButton);
        add(bufSize);

        setActionListener();
    }

    public void setActionListener() {
        setBufferSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bufferSize = Integer.parseInt(JOptionPane.showInputDialog(editButton, "SIZE:(DEFAULT:3)", "SET BUFFER SIZE"));
                    bufSize.setText("BUFFER SIZE :" + String.valueOf(bufferSize));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(editButton, "INPUT INVALID");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBufferQueue(new Data(10, "test"));
//                repaint();
                DisplayFrame.frame.getSendPanel(0).addQueue(new Header(1,1,1));
            }
        });
    }

    public boolean addBufferQueue(Data data) {
        if (isFull()) {
            //缓冲区慢，写不进去,返回假
            JOptionPane.showMessageDialog(editButton, "the buffer is full");
            return false;
        } else {
            queue.add(data);
            repaint();
//            JOptionPane.showMessageDialog(editButton, "left buffer size:" + String.valueOf(--bufferSize));
            bufSize.setText("BUFFER SIZE :" + String.valueOf(--bufferSize));
            return true;
        }
    }

    public void popBufferQueue() {
        queue.removeFirst();
        repaint();
//        JOptionPane.showMessageDialog(editButton, "left buffer size:" + String.valueOf(++bufferSize));
        bufSize.setText("BUFFER SIZE :" + String.valueOf(++bufferSize));
    }

    public boolean isFull() {
        return bufferSize > 0 ? false : true;
    }

    @Override
    public void paint(Graphics g) {
        int cursor = 5; //绘图游标
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
