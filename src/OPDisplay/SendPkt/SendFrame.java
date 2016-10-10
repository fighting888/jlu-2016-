package OPDisplay.SendPkt;

import javax.swing.*;

import OPDisplay.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayDeque;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class SendFrame extends JFrame {

    private DatagramPacket packet;

    private DatagramSocket socket;

    private byte[] bufBytes = new byte[1024];

    private String bufStr = null;

    private int PORT = 5003;

    private static ArrayDeque<Header> headers = new ArrayDeque<>();

    private static ArrayDeque<Data> datas = new ArrayDeque<>();

    private String pid = ManagementFactory.getRuntimeMXBean().getName();

    private JLabel pidLable = JLableFactory.getjLableFactory().makeLable(5, 1, 400, 30, 15, "pid: " + pid);

    private JLabel sendLable = JLableFactory.getjLableFactory().makeLable(5,45,15, "发送至");

    private JLabel contentLabel = JLableFactory.getjLableFactory().makeLable(5,80, 15, "内容");

    private JTextField recvField = JTextFactory.getjTextFactory().makeTextField(60, 45, 305, 20, "输入接受进程id");

    private JTextArea contentArea = JTextFactory.getjTextFactory().makeTextArea(60, 80, 305, 300, "请输入测试数据");

    private JButton sendButton = ButtonFactory.getButtonFactory().makeButton(180, 400, 80, 50, "发送");

    private JButton clearButton = ButtonFactory.getButtonFactory().makeButton(280, 400, 80, 50, "清除");

    private JMenuBar menuBar = new JMenuBar();

    private JMenu menu = new JMenu("START");

    private JMenuItem menuItem = new JMenuItem("SET TIME");

    private JPanel contentPanel = new JPanel(null);

    public static int time = 0;

    public static int Sid;

    public SendFrame(int sid) {
        Sid = sid;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Send Process " + String.valueOf(sid));
        setSize(400, 550);
        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(menuItem);
        contentPanel.add(contentLabel);
        contentPanel.add(sendLable);
        contentPanel.add(recvField);
        contentPanel.add(contentArea);
        contentPanel.add(sendButton);
        contentPanel.add(clearButton);
        contentPanel.add(pidLable);
        setContentPane(contentPanel);
        setListener();
    }

    public static int getTime() {
        return time;
    }

    public static ArrayDeque<Data> getDatas() {
        return datas;
    }

    public void setListener() {
        contentPanel.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("x : " + e.getX() + "   y: " + e.getY());
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                sendButton.setEnabled(false);
                try {
//                Thread.sleep(5000);
//                System.out.println(false + String.valueOf(time++));
                    socket = new DatagramSocket();
                    socket.setSoTimeout(2);
//                    System.out.println("time out");
                    bufBytes = "0".getBytes();
                    packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), 5000);
                    socket.send(packet);
                    System.out.println("send 0 done"); // tssc

                    socket.receive(packet);
                    bufStr = new String(packet.getData(), 0, packet.getData().length);
                    System.out.println("recv 0 done " + bufStr); // tssc
                    if (bufStr.equals("0")) {
                        JOptionPane.showMessageDialog(contentLabel, "Buffer is full, wait a minute");
                    } else { //发送数据
                        bufBytes = ("1" + String.valueOf(Sid) + recvField.getText() + "0" + contentArea.getText()).getBytes();
                        packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), 5000);
                        bufStr = new String(bufBytes, 0, bufBytes.length);
                        System.out.println("Done!!!  " + bufStr);  //tssc

                        headers.addLast(new Header(Sid, Integer.parseInt(recvField.getText()), 0));
                        datas.addLast(new Data(0, contentArea.getText()));
                        System.out.println("add into the header queue!!" + headers.toString() + "  " + headers.isEmpty());
                        socket.send(packet);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
//                sendButton.setEnabled(true);
                socket.close();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recvField.setText(null);
                contentArea.setText(null);

//                Header h = getHeaders().removeFirst();
//                bufBytes = ("2" + String.valueOf(h.getSendId())).getBytes();
//                try {
//                    packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), 5000);
//                    socket.send(packet);
//                } catch (UnknownHostException e1) {
//                    e1.printStackTrace();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }


            }
        });

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time = Integer.parseInt(JOptionPane.showInputDialog(contentPanel, "SET TIME", "INPUT"));
            }
        });
    }

    public static ArrayDeque<Header> getHeaders() {
        return headers;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SendFrame frame = new SendFrame(0);
            }
        });
    }


}
