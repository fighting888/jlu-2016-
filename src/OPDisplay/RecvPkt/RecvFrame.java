package OPDisplay.RecvPkt;

import OPDisplay.util.JLableFactory;
import OPDisplay.util.JTextFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class RecvFrame extends JFrame {

    private Date date = new Date();

    private DateFormat format = new SimpleDateFormat();

    private String pid = ManagementFactory.getRuntimeMXBean().getName();

    private JLabel pidLable = JLableFactory.getjLableFactory().makeLable(5, 1, 400, 30, 15, "pid:" + pid);

    private JLabel timeLable = JLableFactory.getjLableFactory().makeLable(60, 390, 300, 30, 15, "接收时间: " + format.format(date));

    private JLabel sendLable = JLableFactory.getjLableFactory().makeLable(5,45,15, "发送id");

    private JLabel contentLabel = JLableFactory.getjLableFactory().makeLable(5,80, 15, "内容");

    private JTextField recvField = JTextFactory.getjTextFactory().makeTextField(60, 45, 305, 20, "发送进程id");

    private JTextArea contentArea = JTextFactory.getjTextFactory().makeTextArea(60, 80, 305, 300, "收到的测试数据");

    private JPanel contentPanel = new JPanel(null);

    private int Rid = 0;

    public RecvFrame(int rid) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Receive Process " + String.valueOf(rid));
        Rid = rid;
        setSize(400, 500);
        contentPanel.add(contentLabel);
        contentPanel.add(sendLable);
        contentPanel.add(recvField);
        contentPanel.add(contentArea);
        contentPanel.add(pidLable);
        contentPanel.add(timeLable);
        setContentPane(contentPanel);

    }

    public int getRid() {
        return Rid;
    }

    public void refreshCont(String sid, String content) {
        recvField.setText(sid);
        contentArea.setText(content);
        timeLable.setText(format.format(date));
    }

    /**
     * 单元测试
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RecvFrame frame = new RecvFrame(0);
            }
        });
    }

}
