package OPDisplay;

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
        setVisible(true);
        setSize(900, 540);
        setTitle("缓冲区演示");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PoolFrame frame = new PoolFrame();
            }
        });
    }
}
