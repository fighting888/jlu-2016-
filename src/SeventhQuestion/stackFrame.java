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
//        pushStack(10);
//        pushStack(30);
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        popStack(30);
    }

    public void pushStack(double x) {
        sPanel.pushStack(x);
    }

    public void popStack() {
        sPanel.popStack();
    }

    public static void main(String[] args) {
        JFrame frame = new stackFrame();
    }
}
