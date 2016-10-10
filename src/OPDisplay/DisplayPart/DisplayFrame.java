package OPDisplay.DisplayPart;

import OPDisplay.util.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class DisplayFrame extends JFrame  {

    private JMenuBar menuBar = new JMenuBar();

    private JMenu startMenu = new JMenu("Start");

    private JMenuItem startItem = new JMenuItem("start game");

    private JMenuItem exitItem = new JMenuItem("exit");

    private static QueuePanel[] sendPanel = new QueuePanel[4];

    private static QueuePanel[] recvPanel = new QueuePanel[4];



    private JPanel contentPanel = new JPanel(new GridLayout(4,2, 20, 20));

    public static DisplayFrame frame = new DisplayFrame();
    public DisplayFrame(){
        setTitle("操作系统实验演示");
        setJMenuBar(menuBar);
        configMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,900);
        setListener();
        add(contentPanel);
        contentPanel.setBounds(0,0,1200,540);
        contentPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        sendPanel[0] = new QueuePanel("S0", QueuePanel.SENDMODE);
        sendPanel[1] = new QueuePanel("S1", QueuePanel.SENDMODE);
        sendPanel[2] = new QueuePanel("S2", QueuePanel.SENDMODE);
        sendPanel[3] = new QueuePanel("S3", QueuePanel.SENDMODE);
        recvPanel[0] = new QueuePanel("R0", QueuePanel.RECVMODE);
        recvPanel[1] = new QueuePanel("R1", QueuePanel.RECVMODE);
        recvPanel[2] = new QueuePanel("R2", QueuePanel.RECVMODE);
        recvPanel[3] = new QueuePanel("R3", QueuePanel.RECVMODE);

        for (int i = 0;i < 4; i++) {
            contentPanel.add(sendPanel[i]);
            contentPanel.add(recvPanel[i]);
        }
    }

    public void configMenu() {
        menuBar.add(startMenu);
        startMenu.add(startItem);
        startMenu.add(exitItem);
        startItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("start");
                // 创建各种进程
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void setListener() {
        this.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + "   " + e.getY());
            }
        });
    }

    public static QueuePanel getSendPanel(int x) {
        return sendPanel[x];
    }

    public static QueuePanel getRecvPanel(int x) {
        return recvPanel[x];
    }

    public static void main(String[] args) {


                frame.setVisible(true);
                PoolFrame frame1 = new PoolFrame();
                frame1.setVisible(true);
//                frame.getSendPanel0().addQueue(new Header(0, 0, 1));
//        frame.getSendPanel0().addQueue(new Header(0, 0, 1));
//                frame.getSendPanel1().addQueue(new Header(0, 1, 1));
//                frame.getSendPanel2().addQueue(new Header(0, 3, 1));
//                frame.getRecvPanel0().addQueue(new Header(1,1,3));

    }


}
