package SeventhQuestion;

/**
 * Created by PurpleWall on 2016/4/14.
 */

import javax.swing.*;

public class stackFrame extends JFrame {

    public stackPanel sPanel = new stackPanel();

    public stackFrame() {
        setTitle("Stack Situation");
        setBounds(0, 500, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(sPanel);
        setStack(1);
        setStack(2);
        sPanel.repaint();
    }

    public void setStack(int x) {
        sPanel.setList(x);
    }
}
