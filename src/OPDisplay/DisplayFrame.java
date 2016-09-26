package OPDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class DisplayFrame extends JFrame  {

    private JMenuBar menuBar = new JMenuBar();

    private JMenu startMenu = new JMenu("Start");

    private JMenuItem startItem = new JMenuItem("start game");

    private JMenuItem exitItem = new JMenuItem("exit");

//    private sProcess

    private QueuePanel testPanel = new QueuePanel("R0", QueuePanel.SENDMODE);
    private QueuePanel testPanel4 = new QueuePanel("R4", QueuePanel.RECVMODE);
    private QueuePanel testPanel1 = new QueuePanel("R1", QueuePanel.SENDMODE);
    private QueuePanel testPanel5 = new QueuePanel("R5", QueuePanel.RECVMODE);
    private QueuePanel testPanel2 = new QueuePanel("R2", QueuePanel.SENDMODE);
    private QueuePanel testPanel6 = new QueuePanel("R6", QueuePanel.RECVMODE);
    private QueuePanel testPanel3 = new QueuePanel("R3", QueuePanel.SENDMODE);
    private QueuePanel testPanel7 = new QueuePanel("R7", QueuePanel.RECVMODE);
//    private QueuePanel testPanel6 = new QueuePanel("R2");

    private JPanel northPanel = new JPanel(new GridLayout(4,2, 20, 20));

    public DisplayFrame(){
        setTitle("操作系统实验演示");
        setVisible(true);
        setJMenuBar(menuBar);
        configMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,900);
        setListener();
        add(northPanel);
        northPanel.setBounds(0,0,1200,540);
        northPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));



        northPanel.add(testPanel);
        northPanel.add(testPanel4);
        northPanel.add(testPanel1);
        northPanel.add(testPanel5);
        northPanel.add(testPanel2);
        northPanel.add(testPanel6);
        northPanel.add(testPanel3);



        northPanel.add(testPanel7);
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayFrame frame = new DisplayFrame();
                PoolFrame frame1 = new PoolFrame();
            }
        });
    }
}
