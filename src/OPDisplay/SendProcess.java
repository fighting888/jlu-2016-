package OPDisplay;

import javax.swing.*;
import OPDisplay.JLableFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class SendProcess extends JFrame {

    private JLabel sendLable = JLableFactory.getjLableFactory().makeLable(5,15,15, "发送至");

    private JLabel contentLabel = JLableFactory.getjLableFactory().makeLable(5,80, 15, "内容");

    private JTextField recvField = JTextFactory.getjTextFactory().makeTextField(60, 15, 305, 20, "输入接受进程id");

    private JTextArea contentArea = JTextFactory.getjTextFactory().makeTextArea(60, 80, 305, 300, "请输入测试数据");

    private JButton sendButton = ButtonFactory.getButtonFactory().makeButton(180, 400, 80, 50, "发送");

    private JButton clearButton = ButtonFactory.getButtonFactory().makeButton(280, 400, 80, 50, "清除");

    private JPanel contentPanel = new JPanel(null);

    public SendProcess(int sid) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Send Process " + String.valueOf(sid));
        setSize(400, 500);
        contentPanel.add(contentLabel);
        contentPanel.add(sendLable);
        contentPanel.add(recvField);
        contentPanel.add(contentArea);
        contentPanel.add(sendButton);
        contentPanel.add(clearButton);
        setContentPane(contentPanel);
        setListener();
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
                //System.out.println("send");
                //System.out.println(recvField.getText() + "   " +contentArea.getText());
                //向展示端和指定服务器发送数据

                try {
                    Thread.sleep(1000);
                    System.out.println(true);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recvField.setText(null);
                contentArea.setText(null);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SendProcess frame = new SendProcess(1);
            }
        });
    }


}
