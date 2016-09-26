package OPDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class QueuePanel extends JPanel {

    public static int STARTLINE = 3;

    public static final int SENDMODE = 0;

    public static final int RECVMODE = 1;

    private int MODE = 0;

    private JLabel title = JLableFactory.getjLableFactory().makeLable(STARTLINE, 20, 25, "队列名");

    //private JLabel title = new JLabel("队列名");

    private ArrayDeque<Header> queue = new ArrayDeque<>();

    public QueuePanel(String name, int mode) {
        MODE = mode;
//        title.setBounds(STARTLINE, 100, 60, 30);
//        setFont(new Font("微软雅黑", Font.BOLD, 20));
        if (mode == SENDMODE) {
            title.setText("SENDID" + String.valueOf(name));
        } else if (mode == RECVMODE) {
            title.setText("RECVID" + String.valueOf(name));
        }

        add(title);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        Header h1 = new Header(0, 0, 0);
        Header h2 = new Header(0, 1, 1);
        queue.addLast(h1);
        queue.addLast(h2);
    }

    @Override
    public void paint(Graphics g) {

        int cursor = 10;

        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 10));

        graphics2D.setStroke(new BasicStroke(3f));

        for (Header header : queue) {
            Rectangle2D rectangle2D = new Rectangle2D.Double(cursor, 70, 80, 80);

            if (MODE == SENDMODE) {
                graphics2D.setPaint(Color.ORANGE);
            } else if (MODE == RECVMODE) {
                graphics2D.setPaint(Color.YELLOW);
            }


            graphics2D.fill(rectangle2D);
            graphics2D.setPaint(Color.BLACK);
            if (MODE == SENDMODE) {
                graphics2D.drawString("SENDID:" + String.valueOf(header.getRecvId()), cursor + 10, 90);
            } else if (MODE == RECVMODE) {
                graphics2D.drawString("RECVID:" + String.valueOf(header.getRecvId()), cursor + 10, 90);
            }

            cursor += 90;
        }
    }
}
