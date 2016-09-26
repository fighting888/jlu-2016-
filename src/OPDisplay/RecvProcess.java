package OPDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class RecvProcess extends JFrame {

    private JLabel sendLable = JLableFactory.getjLableFactory().makeLable(5,15,15, "发送id");

    private JLabel contentLabel = JLableFactory.getjLableFactory().makeLable(5,80, 15, "内容");

    private JTextField recvField = JTextFactory.getjTextFactory().makeTextField(60, 15, 305, 20, "发送进程id");

    private JTextArea contentArea = JTextFactory.getjTextFactory().makeTextArea(60, 80, 305, 300, "收到的测试数据");



    private JPanel contentPanel = new JPanel(null);

    public RecvProcess(int rid) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Receive Process " + String.valueOf(rid));
        setSize(400, 500);
        contentPanel.add(contentLabel);
        contentPanel.add(sendLable);
        contentPanel.add(recvField);
        contentPanel.add(contentArea);
        setContentPane(contentPanel);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RecvProcess frame = new RecvProcess(0);
            }
        });
    }

}
