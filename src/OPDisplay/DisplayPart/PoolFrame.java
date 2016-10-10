package OPDisplay.DisplayPart;

import OPDisplay.util.Data;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/9/20.
 */
public class PoolFrame extends JFrame {

    private PoolPanel contentPanel = new PoolPanel();

    public PoolFrame() {
        setContentPane(contentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 540);
        setTitle("缓冲区演示");
    }

    public boolean addBufferData(Data data) {
        return contentPanel.addBufferQueue(data);
    }

    public void popBufferData() {
        contentPanel.popBufferQueue();
    }

    /**
     * 检测缓冲区是否写满
     * @return
     */
    public boolean isFull() {
        return contentPanel.isFull();
    }


    /**
     * 单元测试
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PoolFrame frame = new PoolFrame();
                frame.setVisible(true);
                frame.addBufferData(new Data(5, "add data"));
            }
        });
    }
}
